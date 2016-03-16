package ca.blackperl.utils;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class AuditInterceptor extends EmptyInterceptor {

	private static final Logger log = LogManager.getLogger(AuditInterceptor.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int creates;
	private int reads;
	private int updates;
	private int deletes;

	private int statements;

	private int[] totals = new int[5];

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		reads++;
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		deletes++;
		return;
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		updates++;
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public String onPrepareStatement(String sql) {
		statements++;
		log.debug(sql);
		return super.onPrepareStatement(sql);
	}
	
	@Override
	public String toString() {
		return "AuditInterceptor [creates=" + creates + ", reads=" + reads + ", updates=" + updates + ", deletes="
				+ deletes + ", statements=" + statements + ", totals=" + Arrays.toString(totals) + "]";
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		creates++;
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		log.debug(this);
		totals[0] += creates;
		creates = 0;
		totals[1] += reads;
		reads = 0;
		totals[2] += updates;
		updates = 0;
		totals[3] += deletes;
		deletes = 0;
		totals[4] += statements;
		statements = 0;
	}
}
