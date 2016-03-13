package ca.blackperl.utils;

import java.io.Serializable;

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
	private int reads;
	private int deletes;
	private int updates;
	private int creates;

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
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		creates++;
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		log.debug("Creates " + creates + " reads " + reads + " updates " + updates + " deletes " + deletes);
	}
}
