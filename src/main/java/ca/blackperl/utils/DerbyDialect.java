package ca.blackperl.utils;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MappingException;
import org.hibernate.dialect.ColumnAliasExtractor;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.lock.LockingStrategy;
import org.hibernate.exception.SQLExceptionConverter;
import org.hibernate.exception.ViolatedConstraintNameExtracter;
import org.hibernate.persister.entity.Lockable;
import org.hibernate.sql.CaseFragment;
import org.hibernate.sql.JoinFragment;

public class DerbyDialect extends org.hibernate.dialect.DerbyDialect {

	private static final Logger log = LogManager.getLogger(DerbyDialect.class);

	@Override
	public String getCrossJoinSeparator() {
		String crossJoinSeparator = super.getCrossJoinSeparator();
		log.debug("crossJoinSeparator: " + crossJoinSeparator);
		return crossJoinSeparator;
	}

	@Override
	public CaseFragment createCaseFragment() {
		CaseFragment createCaseFragment = super.createCaseFragment();
		log.debug("createCaseFragment: " + createCaseFragment);
		return createCaseFragment;
	}

	@Override
	public boolean dropConstraints() {
		boolean dropConstraints = super.dropConstraints();
		log.debug("dropConstraints: " + dropConstraints);
		return dropConstraints;
	}

	@Override
	public boolean supportsSequences() {
		boolean supportsSequences = super.supportsSequences();
		log.debug("supportsSequences: " + supportsSequences);
		return supportsSequences;
	}

	@Override
	public String getSequenceNextValString(String sequenceName) {
		String sequenceNextValString = super.getSequenceNextValString(sequenceName);
		log.debug("sequenceNextValString: " + sequenceNextValString);
		return sequenceNextValString;
	}

	@Override
	public boolean supportsLimit() {
		boolean supportsLimit = super.supportsLimit();
		log.trace("supportsLimit: " + supportsLimit);
		return supportsLimit;
	}

	@Override
	public boolean supportsCommentOn() {
		boolean supportsCommentOn = super.supportsCommentOn();
		log.debug("supportsCommentOn: " + supportsCommentOn);
		return supportsCommentOn;
	}

	@Override
	public boolean supportsLimitOffset() {
		boolean supportsLimitOffset = super.supportsLimitOffset();
		log.trace("supportsLimitOffset: " + supportsLimitOffset);
		return supportsLimitOffset;
	}

	@Override
	public String getForUpdateString() {
		String forUpdateString = super.getForUpdateString();
		log.debug("forUpdateString: " + forUpdateString);
		return forUpdateString;
	}

	@Override
	public String getWriteLockString(int timeout) {
		String writeLockString = super.getWriteLockString(timeout);
		log.debug("writeLockString: " + writeLockString);
		return writeLockString;
	}

	@Override
	public String getReadLockString(int timeout) {
		String readLockString = super.getReadLockString(timeout);
		log.debug("readLockString: " + readLockString);
		return readLockString;
	}

	@Override
	public String getLimitString(String query, int offset, int limit) {
		String limitString = super.getLimitString(query, offset, limit);
		log.debug("limitString: " + limitString);
		return limitString;
	}

	@Override
	public boolean supportsVariableLimit() {
		boolean supportsVariableLimit = super.supportsVariableLimit();
		log.debug("supportsVariableLimit: " + supportsVariableLimit);
		return supportsVariableLimit;
	}

	@Override
	public String getQuerySequencesString() {
		String querySequencesString = super.getQuerySequencesString();
		log.debug("querySequencesString: " + querySequencesString);
		return querySequencesString;
	}

	@Override
	public boolean supportsLobValueChangePropogation() {
		boolean supportsLobValueChangePropogation = super.supportsLobValueChangePropogation();
		log.debug("supportsLobValueChangePropogation: " + supportsLobValueChangePropogation);
		return supportsLobValueChangePropogation;
	}

	@Override
	public boolean supportsUnboundedLobLocatorMaterialization() {
		boolean supportsUnboundedLobLocatorMaterialization = super.supportsUnboundedLobLocatorMaterialization();
		log.debug("supportsUnboundedLobLocatorMaterialization: " + supportsUnboundedLobLocatorMaterialization);
		return supportsUnboundedLobLocatorMaterialization;
	}

	@Override
	public String getLowercaseFunction() {
		log.debug("here");
		return super.getLowercaseFunction();
	}

	@Override
	public String getAddColumnString() {
		log.debug("here");
		return super.getAddColumnString();
	}

	@Override
	public boolean supportsIdentityColumns() {
		log.debug("here");
		return super.supportsIdentityColumns();
	}

	@Override
	public String getIdentitySelectString() {
		log.debug("here");
		return super.getIdentitySelectString();
	}

	@Override
	public String getIdentityColumnString() {
		log.debug("here");
		return super.getIdentityColumnString();
	}

	@Override
	public String getIdentityInsertString() {
		log.debug("here");
		return super.getIdentityInsertString();
	}

	@Override
	public String getCreateSequenceString(String sequenceName) {
		log.debug("here");
		return super.getCreateSequenceString(sequenceName);
	}

	@Override
	public String getDropSequenceString(String sequenceName) {
		log.debug("here");
		return super.getDropSequenceString(sequenceName);
	}

	@Override
	public boolean supportsPooledSequences() {
		log.debug("here");
		return super.supportsPooledSequences();
	}

	@Override
	public String getLimitString(String sql, boolean hasOffset) {
		log.debug("here");
		return super.getLimitString(sql, hasOffset);
	}

	@Override
	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		log.debug("here");
		return super.convertToFirstRowValue(zeroBasedFirstResult);
	}

	@Override
	public boolean useMaxForLimit() {
		log.debug("here");
		return super.useMaxForLimit();
	}

	@Override
	public boolean supportsOuterJoinForUpdate() {
		log.debug("here");
		return super.supportsOuterJoinForUpdate();
	}

	@Override
	public boolean supportsNotNullUnique() {
		log.debug("here");
		return super.supportsNotNullUnique();
	}

	@Override
	public String getSelectClauseNullString(int sqlType) {
		log.debug("here");
		return super.getSelectClauseNullString(sqlType);
	}

	@Override
	public boolean supportsUnionAll() {
		log.debug("here");
		return super.supportsUnionAll();
	}

	@Override
	public int registerResultSetOutParameter(CallableStatement statement, int col) throws SQLException {
		log.debug("here");
		return super.registerResultSetOutParameter(statement, col);
	}

	@Override
	public ResultSet getResultSet(CallableStatement ps) throws SQLException {
		log.debug("here");
		return super.getResultSet(ps);
	}

	@Override
	public boolean supportsTemporaryTables() {
		log.debug("here");
		return super.supportsTemporaryTables();
	}

	@Override
	public String getCreateTemporaryTableString() {
		log.debug("here");
		return super.getCreateTemporaryTableString();
	}

	@Override
	public String getCreateTemporaryTablePostfix() {
		log.debug("here");
		return super.getCreateTemporaryTablePostfix();
	}

	@Override
	public String generateTemporaryTableName(String baseTableName) {
		log.debug("here");
		return super.generateTemporaryTableName(baseTableName);
	}

	@Override
	public boolean supportsCurrentTimestampSelection() {
		log.debug("here");
		return super.supportsCurrentTimestampSelection();
	}

	@Override
	public String getCurrentTimestampSelectString() {
		log.debug("here");
		return super.getCurrentTimestampSelectString();
	}

	@Override
	public boolean isCurrentTimestampSelectStringCallable() {
		log.debug("here");
		return super.isCurrentTimestampSelectStringCallable();
	}

	@Override
	public boolean supportsParametersInInsertSelect() {
		log.debug("here");
		return super.supportsParametersInInsertSelect();
	}

	@Override
	public boolean requiresCastingOfParametersInSelectClause() {
		log.debug("here");
		return super.requiresCastingOfParametersInSelectClause();
	}

	@Override
	public boolean supportsResultSetPositionQueryMethodsOnForwardOnlyCursor() {
		log.debug("here");
		return super.supportsResultSetPositionQueryMethodsOnForwardOnlyCursor();
	}

	@Override
	public boolean supportsEmptyInList() {
		log.debug("here");
		return super.supportsEmptyInList();
	}

	@Override
	public boolean doesReadCommittedCauseWritersToBlockReaders() {
		log.debug("here");
		return super.doesReadCommittedCauseWritersToBlockReaders();
	}

	@Override
	public boolean supportsTupleDistinctCounts() {
		log.debug("here");
		return super.supportsTupleDistinctCounts();
	}

	@Override
	public String toString() {
		log.debug("here");
		return super.toString();
	}

	@Override
	public String getTypeName(int code) throws HibernateException {
		log.debug("here");
		return super.getTypeName(code);
	}

	@Override
	public String getTypeName(int code, int length, int precision, int scale) throws HibernateException {
		log.debug("here");
		return super.getTypeName(code, length, precision, scale);
	}

	@Override
	public String getCastTypeName(int code) {
		log.debug("here");
		return super.getCastTypeName(code);
	}

	@Override
	protected void registerColumnType(int code, int capacity, String name) {
		log.debug("here");
		super.registerColumnType(code, capacity, name);
	}

	@Override
	protected void registerColumnType(int code, String name) {
		log.debug("registerColumnType: " + code + "," + name);
		super.registerColumnType(code, name);
	}

	@Override
	public String getHibernateTypeName(int code) throws HibernateException {
		log.debug("here");
		return super.getHibernateTypeName(code);
	}

	@Override
	public String getHibernateTypeName(int code, int length, int precision, int scale) throws HibernateException {
		log.debug("here");
		return super.getHibernateTypeName(code, length, precision, scale);
	}

	@Override
	protected void registerHibernateType(int code, int capacity, String name) {
		log.debug("registerHibernateType: " + code + "," + capacity + "," + name);
		super.registerHibernateType(code, capacity, name);
	}

	@Override
	protected void registerHibernateType(int code, String name) {
		log.debug("registerHibernateType: " + code + ", " + name);
		super.registerHibernateType(code, name);
	}

	@Override
	protected void registerFunction(String name, SQLFunction function) {
		log.debug("registerFunction: " + name + " " + function);
		super.registerFunction(name, function);
	}

	@Override
	protected void registerKeyword(String word) {
		log.debug("registerKeyword: " + word);
		super.registerKeyword(word);
	}

	@Override
	public Set<String> getKeywords() {
		Set<String> keywords = super.getKeywords();
		log.debug("getKeywords: " + keywords);
		return keywords;
	}

	@Override
	public Class getNativeIdentifierGeneratorClass() {
		log.debug("here");
		return super.getNativeIdentifierGeneratorClass();
	}

	@Override
	public boolean supportsInsertSelectIdentity() {
		log.debug("here");
		return super.supportsInsertSelectIdentity();
	}

	@Override
	public boolean hasDataTypeInIdentityColumn() {
		log.debug("here");
		return super.hasDataTypeInIdentityColumn();
	}

	@Override
	public String appendIdentitySelectToInsert(String insertString) {
		log.debug("here");
		return super.appendIdentitySelectToInsert(insertString);
	}

	@Override
	public String getIdentitySelectString(String table, String column, int type) throws MappingException {
		log.debug("here");
		return super.getIdentitySelectString(table, column, type);
	}

	@Override
	public String getIdentityColumnString(int type) throws MappingException {
		log.debug("here");
		return super.getIdentityColumnString(type);
	}

	@Override
	public String getSelectSequenceNextValString(String sequenceName) throws MappingException {
		log.debug("here");
		return super.getSelectSequenceNextValString(sequenceName);
	}

	@Override
	public String[] getCreateSequenceStrings(String sequenceName) throws MappingException {
		log.debug("here");
		return super.getCreateSequenceStrings(sequenceName);
	}

	@Override
	public String[] getCreateSequenceStrings(String sequenceName, int initialValue, int incrementSize)
			throws MappingException {
		log.debug("here");
		return super.getCreateSequenceStrings(sequenceName, initialValue, incrementSize);
	}

	@Override
	protected String getCreateSequenceString(String sequenceName, int initialValue, int incrementSize)
			throws MappingException {
		log.debug("here");
		return super.getCreateSequenceString(sequenceName, initialValue, incrementSize);
	}

	@Override
	public String[] getDropSequenceStrings(String sequenceName) throws MappingException {
		log.debug("here");
		return super.getDropSequenceStrings(sequenceName);
	}

	@Override
	public String getSelectGUIDString() {
		log.debug("here");
		return super.getSelectGUIDString();
	}

	@Override
	public boolean bindLimitParametersInReverseOrder() {
		log.debug("here");
		return super.bindLimitParametersInReverseOrder();
	}

	@Override
	public boolean bindLimitParametersFirst() {
		log.debug("here");
		return super.bindLimitParametersFirst();
	}

	@Override
	public boolean forceLimitUsage() {
		log.debug("here");
		return super.forceLimitUsage();
	}

	@Override
	public boolean supportsLockTimeouts() {
		log.debug("here");
		return super.supportsLockTimeouts();
	}

	@Override
	public boolean isLockTimeoutParameterized() {
		log.debug("here");
		return super.isLockTimeoutParameterized();
	}

	@Override
	public LockingStrategy getLockingStrategy(Lockable lockable, LockMode lockMode) {
		log.debug("here");
		return super.getLockingStrategy(lockable, lockMode);
	}

	@Override
	public String getForUpdateString(LockOptions lockOptions) {
		log.debug("here");
		return super.getForUpdateString(lockOptions);
	}

	@Override
	public String getForUpdateString(LockMode lockMode) {
		log.debug("here");
		return super.getForUpdateString(lockMode);
	}

	@Override
	public boolean forUpdateOfColumns() {
		log.debug("here");
		return super.forUpdateOfColumns();
	}

	@Override
	public String getForUpdateString(String aliases) {
		log.debug("here");
		return super.getForUpdateString(aliases);
	}

	@Override
	public String getForUpdateString(String aliases, LockOptions lockOptions) {
		log.debug("here");
		return super.getForUpdateString(aliases, lockOptions);
	}

	@Override
	public String getForUpdateNowaitString() {
		log.debug("here");
		return super.getForUpdateNowaitString();
	}

	@Override
	public String getForUpdateNowaitString(String aliases) {
		log.debug("here");
		return super.getForUpdateNowaitString(aliases);
	}

	@Override
	public String appendLockHint(LockMode mode, String tableName) {
		log.debug("here");
		return super.appendLockHint(mode, tableName);
	}

	@Override
	public String applyLocksToSql(String sql, LockOptions aliasedLockOptions, Map keyColumnNames) {
		log.debug("here");
		return super.applyLocksToSql(sql, aliasedLockOptions, keyColumnNames);
	}

	@Override
	public String getCreateTableString() {
		log.debug("here");
		return super.getCreateTableString();
	}

	@Override
	public String getCreateMultisetTableString() {
		log.debug("here");
		return super.getCreateMultisetTableString();
	}

	@Override
	public String getDropTemporaryTableString() {
		log.debug("here");
		return super.getDropTemporaryTableString();
	}

	@Override
	public Boolean performTemporaryTableDDLInIsolation() {
		log.debug("here");
		return super.performTemporaryTableDDLInIsolation();
	}

	@Override
	public boolean dropTemporaryTableAfterUse() {
		log.debug("here");
		return super.dropTemporaryTableAfterUse();
	}

	@Override
	public String getCurrentTimestampSQLFunctionName() {
		log.debug("here");
		return super.getCurrentTimestampSQLFunctionName();
	}

	@Override
	public SQLExceptionConverter buildSQLExceptionConverter() {
		log.debug("here");
		return super.buildSQLExceptionConverter();
	}

	@Override
	public ViolatedConstraintNameExtracter getViolatedConstraintNameExtracter() {
		log.debug("here");
		return super.getViolatedConstraintNameExtracter();
	}

	@Override
	public JoinFragment createOuterJoinFragment() {
		log.debug("here");
		return super.createOuterJoinFragment();
	}

	@Override
	public String getNoColumnsInsertString() {
		log.debug("here");
		return super.getNoColumnsInsertString();
	}

	@Override
	public String transformSelectString(String select) {
		log.debug("here");
		return super.transformSelectString(select);
	}

	@Override
	public int getMaxAliasLength() {
		log.debug("here");
		return super.getMaxAliasLength();
	}

	@Override
	public String toBooleanValueString(boolean bool) {
		log.debug("here");
		return super.toBooleanValueString(bool);
	}

	@Override
	public char openQuote() {
		log.debug("here");
		return super.openQuote();
	}

	@Override
	public char closeQuote() {
		log.debug("here");
		return super.closeQuote();
	}

	@Override
	public boolean hasAlterTable() {
		log.debug("here");
		return super.hasAlterTable();
	}

	@Override
	public boolean qualifyIndexName() {
		log.debug("here");
		return super.qualifyIndexName();
	}

	@Override
	public boolean supportsUnique() {
		log.debug("here");
		return super.supportsUnique();
	}

	@Override
	public boolean supportsUniqueConstraintInCreateAlterTable() {
		log.debug("here");
		return super.supportsUniqueConstraintInCreateAlterTable();
	}

	@Override
	public String getDropForeignKeyString() {
		log.debug("here");
		return super.getDropForeignKeyString();
	}

	@Override
	public String getTableTypeString() {
		log.debug("here");
		return super.getTableTypeString();
	}

	@Override
	public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
			String[] primaryKey, boolean referencesPrimaryKey) {
		log.debug("here");
		return super.getAddForeignKeyConstraintString(constraintName, foreignKey, referencedTable, primaryKey,
				referencesPrimaryKey);
	}

	@Override
	public String getAddPrimaryKeyConstraintString(String constraintName) {
		log.debug("here");
		return super.getAddPrimaryKeyConstraintString(constraintName);
	}

	@Override
	public boolean hasSelfReferentialForeignKeyBug() {
		log.debug("here");
		return super.hasSelfReferentialForeignKeyBug();
	}

	@Override
	public String getNullColumnString() {
		log.debug("here");
		return super.getNullColumnString();
	}

	@Override
	public String getTableComment(String comment) {
		log.debug("here");
		return super.getTableComment(comment);
	}

	@Override
	public String getColumnComment(String comment) {
		log.debug("here");
		return super.getColumnComment(comment);
	}

	@Override
	public boolean supportsIfExistsBeforeTableName() {
		log.debug("here");
		return super.supportsIfExistsBeforeTableName();
	}

	@Override
	public boolean supportsIfExistsAfterTableName() {
		log.debug("here");
		return super.supportsIfExistsAfterTableName();
	}

	@Override
	public boolean supportsColumnCheck() {
		log.debug("here");
		return super.supportsColumnCheck();
	}

	@Override
	public boolean supportsTableCheck() {
		log.debug("here");
		return super.supportsTableCheck();
	}

	@Override
	public boolean supportsCascadeDelete() {
		log.debug("here");
		return super.supportsCascadeDelete();
	}

	@Override
	public String getCascadeConstraintsString() {
		log.debug("here");
		return super.getCascadeConstraintsString();
	}

	@Override
	public ColumnAliasExtractor getColumnAliasExtractor() {
		log.debug("here");
		return super.getColumnAliasExtractor();
	}

	@Override
	public boolean areStringComparisonsCaseInsensitive() {
		log.debug("here");
		return super.areStringComparisonsCaseInsensitive();
	}

	@Override
	public boolean supportsRowValueConstructorSyntax() {
		log.debug("here");
		return super.supportsRowValueConstructorSyntax();
	}

	@Override
	public boolean supportsRowValueConstructorSyntaxInInList() {
		log.debug("here");
		return super.supportsRowValueConstructorSyntaxInInList();
	}

	@Override
	public boolean useInputStreamToInsertBlob() {
		log.debug("here");
		return super.useInputStreamToInsertBlob();
	}

	@Override
	public boolean replaceResultVariableInOrderByClauseWithPosition() {
		log.debug("here");
		return super.replaceResultVariableInOrderByClauseWithPosition();
	}

	@Override
	public boolean supportsCircularCascadeDeleteConstraints() {
		log.debug("here");
		return super.supportsCircularCascadeDeleteConstraints();
	}

	@Override
	public boolean supportsSubselectAsInPredicateLHS() {
		log.debug("here");
		return super.supportsSubselectAsInPredicateLHS();
	}

	@Override
	public boolean supportsExpectedLobUsagePattern() {
		log.debug("here");
		return super.supportsExpectedLobUsagePattern();
	}

	@Override
	public boolean supportsSubqueryOnMutatingTable() {
		log.debug("here");
		return super.supportsSubqueryOnMutatingTable();
	}

	@Override
	public boolean supportsExistsInSelect() {
		log.debug("here");
		return super.supportsExistsInSelect();
	}

	@Override
	public boolean doesRepeatableReadCauseReadersToBlockWriters() {
		log.debug("here");
		return super.doesRepeatableReadCauseReadersToBlockWriters();
	}

	@Override
	public boolean supportsBindAsCallableArgument() {
		log.debug("here");
		return super.supportsBindAsCallableArgument();
	}

	@Override
	public boolean supportsTupleCounts() {
		log.debug("here");
		return super.supportsTupleCounts();
	}

}
