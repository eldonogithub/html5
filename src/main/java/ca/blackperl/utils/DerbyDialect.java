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
		log.trace("crossJoinSeparator: " + crossJoinSeparator);
		return crossJoinSeparator;
	}

	@Override
	public CaseFragment createCaseFragment() {
		CaseFragment createCaseFragment = super.createCaseFragment();
		log.trace("createCaseFragment: " + createCaseFragment);
		return createCaseFragment;
	}

	@Override
	public boolean dropConstraints() {
		boolean dropConstraints = super.dropConstraints();
		log.trace("dropConstraints: " + dropConstraints);
		return dropConstraints;
	}

	@Override
	public boolean supportsSequences() {
		boolean supportsSequences = super.supportsSequences();
		log.trace("supportsSequences: " + supportsSequences);
		return supportsSequences;
	}

	@Override
	public String getSequenceNextValString(String sequenceName) {
		String sequenceNextValString = super.getSequenceNextValString(sequenceName);
		log.trace("sequenceNextValString: " + sequenceNextValString);
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
		log.trace("supportsCommentOn: " + supportsCommentOn);
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
		log.trace("forUpdateString: " + forUpdateString);
		return forUpdateString;
	}

	@Override
	public String getWriteLockString(int timeout) {
		String writeLockString = super.getWriteLockString(timeout);
		log.trace("writeLockString: " + writeLockString);
		return writeLockString;
	}

	@Override
	public String getReadLockString(int timeout) {
		String readLockString = super.getReadLockString(timeout);
		log.trace("readLockString: " + readLockString);
		return readLockString;
	}

	@Override
	public String getLimitString(String query, int offset, int limit) {
		String limitString = super.getLimitString(query, offset, limit);
		log.trace("limitString: " + limitString);
		return limitString;
	}

	@Override
	public boolean supportsVariableLimit() {
		boolean supportsVariableLimit = super.supportsVariableLimit();
		log.trace("supportsVariableLimit: " + supportsVariableLimit);
		return supportsVariableLimit;
	}

	@Override
	public String getQuerySequencesString() {
		String querySequencesString = super.getQuerySequencesString();
		log.trace("querySequencesString: " + querySequencesString);
		return querySequencesString;
	}

	@Override
	public boolean supportsLobValueChangePropogation() {
		boolean supportsLobValueChangePropogation = super.supportsLobValueChangePropogation();
		log.trace("supportsLobValueChangePropogation: " + supportsLobValueChangePropogation);
		return supportsLobValueChangePropogation;
	}

	@Override
	public boolean supportsUnboundedLobLocatorMaterialization() {
		boolean supportsUnboundedLobLocatorMaterialization = super.supportsUnboundedLobLocatorMaterialization();
		log.trace("supportsUnboundedLobLocatorMaterialization: " + supportsUnboundedLobLocatorMaterialization);
		return supportsUnboundedLobLocatorMaterialization;
	}

	@Override
	public String getLowercaseFunction() {
		log.trace("here");
		return super.getLowercaseFunction();
	}

	@Override
	public String getAddColumnString() {
		log.trace("here");
		return super.getAddColumnString();
	}

	@Override
	public boolean supportsIdentityColumns() {
		log.trace("here");
		return super.supportsIdentityColumns();
	}

	@Override
	public String getIdentitySelectString() {
		log.trace("here");
		return super.getIdentitySelectString();
	}

	@Override
	public String getIdentityColumnString() {
		log.trace("here");
		return super.getIdentityColumnString();
	}

	@Override
	public String getIdentityInsertString() {
		log.trace("here");
		return super.getIdentityInsertString();
	}

	@Override
	public String getCreateSequenceString(String sequenceName) {
		log.trace("here");
		return super.getCreateSequenceString(sequenceName);
	}

	@Override
	public String getDropSequenceString(String sequenceName) {
		log.trace("here");
		return super.getDropSequenceString(sequenceName);
	}

	@Override
	public boolean supportsPooledSequences() {
		log.trace("here");
		return super.supportsPooledSequences();
	}

	@Override
	public String getLimitString(String sql, boolean hasOffset) {
		log.trace("here");
		return super.getLimitString(sql, hasOffset);
	}

	@Override
	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		log.trace("here");
		return super.convertToFirstRowValue(zeroBasedFirstResult);
	}

	@Override
	public boolean useMaxForLimit() {
		log.trace("here");
		return super.useMaxForLimit();
	}

	@Override
	public boolean supportsOuterJoinForUpdate() {
		log.trace("here");
		return super.supportsOuterJoinForUpdate();
	}

	@Override
	public boolean supportsNotNullUnique() {
		log.trace("here");
		return super.supportsNotNullUnique();
	}

	@Override
	public String getSelectClauseNullString(int sqlType) {
		log.trace("here");
		return super.getSelectClauseNullString(sqlType);
	}

	@Override
	public boolean supportsUnionAll() {
		log.trace("here");
		return super.supportsUnionAll();
	}

	@Override
	public int registerResultSetOutParameter(CallableStatement statement, int col) throws SQLException {
		log.trace("here");
		return super.registerResultSetOutParameter(statement, col);
	}

	@Override
	public ResultSet getResultSet(CallableStatement ps) throws SQLException {
		log.trace("here");
		return super.getResultSet(ps);
	}

	@Override
	public boolean supportsTemporaryTables() {
		log.trace("here");
		return super.supportsTemporaryTables();
	}

	@Override
	public String getCreateTemporaryTableString() {
		log.trace("here");
		return super.getCreateTemporaryTableString();
	}

	@Override
	public String getCreateTemporaryTablePostfix() {
		log.trace("here");
		return super.getCreateTemporaryTablePostfix();
	}

	@Override
	public String generateTemporaryTableName(String baseTableName) {
		log.trace("here");
		return super.generateTemporaryTableName(baseTableName);
	}

	@Override
	public boolean supportsCurrentTimestampSelection() {
		log.trace("here");
		return super.supportsCurrentTimestampSelection();
	}

	@Override
	public String getCurrentTimestampSelectString() {
		log.trace("here");
		return super.getCurrentTimestampSelectString();
	}

	@Override
	public boolean isCurrentTimestampSelectStringCallable() {
		log.trace("here");
		return super.isCurrentTimestampSelectStringCallable();
	}

	@Override
	public boolean supportsParametersInInsertSelect() {
		log.trace("here");
		return super.supportsParametersInInsertSelect();
	}

	@Override
	public boolean requiresCastingOfParametersInSelectClause() {
		log.trace("here");
		return super.requiresCastingOfParametersInSelectClause();
	}

	@Override
	public boolean supportsResultSetPositionQueryMethodsOnForwardOnlyCursor() {
		log.trace("here");
		return super.supportsResultSetPositionQueryMethodsOnForwardOnlyCursor();
	}

	@Override
	public boolean supportsEmptyInList() {
		log.trace("here");
		return super.supportsEmptyInList();
	}

	@Override
	public boolean doesReadCommittedCauseWritersToBlockReaders() {
		log.trace("here");
		return super.doesReadCommittedCauseWritersToBlockReaders();
	}

	@Override
	public boolean supportsTupleDistinctCounts() {
		log.trace("here");
		return super.supportsTupleDistinctCounts();
	}

	@Override
	public String toString() {
		log.trace("toString");
		return super.toString();
	}

	@Override
	public String getTypeName(int code) throws HibernateException {
		log.trace("here");
		return super.getTypeName(code);
	}

	@Override
	public String getTypeName(int code, int length, int precision, int scale) throws HibernateException {
		log.trace("here");
		return super.getTypeName(code, length, precision, scale);
	}

	@Override
	public String getCastTypeName(int code) {
		log.trace("here");
		return super.getCastTypeName(code);
	}

	@Override
	protected void registerColumnType(int code, int capacity, String name) {
		log.trace("here");
		super.registerColumnType(code, capacity, name);
	}

	@Override
	protected void registerColumnType(int code, String name) {
		log.trace("registerColumnType: " + code + "," + name);
		super.registerColumnType(code, name);
	}

	@Override
	public String getHibernateTypeName(int code) throws HibernateException {
		log.trace("here");
		return super.getHibernateTypeName(code);
	}

	@Override
	public String getHibernateTypeName(int code, int length, int precision, int scale) throws HibernateException {
		log.trace("here");
		return super.getHibernateTypeName(code, length, precision, scale);
	}

	@Override
	protected void registerHibernateType(int code, int capacity, String name) {
		log.trace("registerHibernateType: " + code + "," + capacity + "," + name);
		super.registerHibernateType(code, capacity, name);
	}

	@Override
	protected void registerHibernateType(int code, String name) {
		log.trace("registerHibernateType: " + code + ", " + name);
		super.registerHibernateType(code, name);
	}

	@Override
	protected void registerFunction(String name, SQLFunction function) {
		log.trace("registerFunction: " + name + " " + function);
		super.registerFunction(name, function);
	}

	@Override
	protected void registerKeyword(String word) {
		log.trace("registerKeyword: " + word);
		super.registerKeyword(word);
	}

	@Override
	public Set<String> getKeywords() {
		Set<String> keywords = super.getKeywords();
		log.trace("getKeywords: " + keywords);
		return keywords;
	}

	@Override
	public Class getNativeIdentifierGeneratorClass() {
		log.trace("here");
		return super.getNativeIdentifierGeneratorClass();
	}

	@Override
	public boolean supportsInsertSelectIdentity() {
		log.trace("here");
		return super.supportsInsertSelectIdentity();
	}

	@Override
	public boolean hasDataTypeInIdentityColumn() {
		log.trace("here");
		return super.hasDataTypeInIdentityColumn();
	}

	@Override
	public String appendIdentitySelectToInsert(String insertString) {
		log.trace("here");
		return super.appendIdentitySelectToInsert(insertString);
	}

	@Override
	public String getIdentitySelectString(String table, String column, int type) throws MappingException {
		log.trace("here");
		return super.getIdentitySelectString(table, column, type);
	}

	@Override
	public String getIdentityColumnString(int type) throws MappingException {
		log.trace("here");
		return super.getIdentityColumnString(type);
	}

	@Override
	public String getSelectSequenceNextValString(String sequenceName) throws MappingException {
		log.trace("here");
		return super.getSelectSequenceNextValString(sequenceName);
	}

	@Override
	public String[] getCreateSequenceStrings(String sequenceName) throws MappingException {
		log.trace("here");
		return super.getCreateSequenceStrings(sequenceName);
	}

	@Override
	public String[] getCreateSequenceStrings(String sequenceName, int initialValue, int incrementSize)
			throws MappingException {
		log.trace("here");
		return super.getCreateSequenceStrings(sequenceName, initialValue, incrementSize);
	}

	@Override
	protected String getCreateSequenceString(String sequenceName, int initialValue, int incrementSize)
			throws MappingException {
		log.trace("here");
		return super.getCreateSequenceString(sequenceName, initialValue, incrementSize);
	}

	@Override
	public String[] getDropSequenceStrings(String sequenceName) throws MappingException {
		log.trace("here");
		return super.getDropSequenceStrings(sequenceName);
	}

	@Override
	public String getSelectGUIDString() {
		log.trace("here");
		return super.getSelectGUIDString();
	}

	@Override
	public boolean bindLimitParametersInReverseOrder() {
		log.trace("here");
		return super.bindLimitParametersInReverseOrder();
	}

	@Override
	public boolean bindLimitParametersFirst() {
		log.trace("here");
		return super.bindLimitParametersFirst();
	}

	@Override
	public boolean forceLimitUsage() {
		log.trace("here");
		return super.forceLimitUsage();
	}

	@Override
	public boolean supportsLockTimeouts() {
		log.trace("here");
		return super.supportsLockTimeouts();
	}

	@Override
	public boolean isLockTimeoutParameterized() {
		log.trace("here");
		return super.isLockTimeoutParameterized();
	}

	@Override
	public LockingStrategy getLockingStrategy(Lockable lockable, LockMode lockMode) {
		log.trace("here");
		return super.getLockingStrategy(lockable, lockMode);
	}

	@Override
	public String getForUpdateString(LockOptions lockOptions) {
		log.trace("here");
		return super.getForUpdateString(lockOptions);
	}

	@Override
	public String getForUpdateString(LockMode lockMode) {
		log.trace("here");
		return super.getForUpdateString(lockMode);
	}

	@Override
	public boolean forUpdateOfColumns() {
		log.trace("here");
		return super.forUpdateOfColumns();
	}

	@Override
	public String getForUpdateString(String aliases) {
		log.trace("here");
		return super.getForUpdateString(aliases);
	}

	@Override
	public String getForUpdateString(String aliases, LockOptions lockOptions) {
		log.trace("here");
		return super.getForUpdateString(aliases, lockOptions);
	}

	@Override
	public String getForUpdateNowaitString() {
		log.trace("here");
		return super.getForUpdateNowaitString();
	}

	@Override
	public String getForUpdateNowaitString(String aliases) {
		log.trace("here");
		return super.getForUpdateNowaitString(aliases);
	}

	@Override
	public String appendLockHint(LockMode mode, String tableName) {
		log.trace("here");
		return super.appendLockHint(mode, tableName);
	}

	@Override
	public String applyLocksToSql(String sql, LockOptions aliasedLockOptions, Map keyColumnNames) {
		log.trace("here");
		return super.applyLocksToSql(sql, aliasedLockOptions, keyColumnNames);
	}

	@Override
	public String getCreateTableString() {
		log.trace("here");
		return super.getCreateTableString();
	}

	@Override
	public String getCreateMultisetTableString() {
		log.trace("here");
		return super.getCreateMultisetTableString();
	}

	@Override
	public String getDropTemporaryTableString() {
		log.trace("here");
		return super.getDropTemporaryTableString();
	}

	@Override
	public Boolean performTemporaryTableDDLInIsolation() {
		log.trace("here");
		return super.performTemporaryTableDDLInIsolation();
	}

	@Override
	public boolean dropTemporaryTableAfterUse() {
		log.trace("here");
		return super.dropTemporaryTableAfterUse();
	}

	@Override
	public String getCurrentTimestampSQLFunctionName() {
		log.trace("here");
		return super.getCurrentTimestampSQLFunctionName();
	}

	@Override
	public SQLExceptionConverter buildSQLExceptionConverter() {
		log.trace("here");
		return super.buildSQLExceptionConverter();
	}

	@Override
	public ViolatedConstraintNameExtracter getViolatedConstraintNameExtracter() {
		log.trace("here");
		return super.getViolatedConstraintNameExtracter();
	}

	@Override
	public JoinFragment createOuterJoinFragment() {
		log.trace("here");
		return super.createOuterJoinFragment();
	}

	@Override
	public String getNoColumnsInsertString() {
		log.trace("here");
		return super.getNoColumnsInsertString();
	}

	@Override
	public String transformSelectString(String select) {
		log.trace("here");
		return super.transformSelectString(select);
	}

	@Override
	public int getMaxAliasLength() {
		log.trace("here");
		return super.getMaxAliasLength();
	}

	@Override
	public String toBooleanValueString(boolean bool) {
		log.trace("here");
		return super.toBooleanValueString(bool);
	}

	@Override
	public char openQuote() {
		log.trace("openQuote");
		return super.openQuote();
	}

	@Override
	public char closeQuote() {
		log.trace("here");
		return super.closeQuote();
	}

	@Override
	public boolean hasAlterTable() {
		log.trace("hasAlterTable");
		return super.hasAlterTable();
	}

	@Override
	public boolean qualifyIndexName() {
		log.trace("here");
		return super.qualifyIndexName();
	}

	@Override
	public boolean supportsUnique() {
		log.trace("here");
		return super.supportsUnique();
	}

	@Override
	public boolean supportsUniqueConstraintInCreateAlterTable() {
		log.trace("here");
		return super.supportsUniqueConstraintInCreateAlterTable();
	}

	@Override
	public String getDropForeignKeyString() {
		log.trace("here");
		return super.getDropForeignKeyString();
	}

	@Override
	public String getTableTypeString() {
		log.trace("here");
		return super.getTableTypeString();
	}

	@Override
	public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
			String[] primaryKey, boolean referencesPrimaryKey) {
		log.trace("here");
		return super.getAddForeignKeyConstraintString(constraintName, foreignKey, referencedTable, primaryKey,
				referencesPrimaryKey);
	}

	@Override
	public String getAddPrimaryKeyConstraintString(String constraintName) {
		log.trace("here");
		return super.getAddPrimaryKeyConstraintString(constraintName);
	}

	@Override
	public boolean hasSelfReferentialForeignKeyBug() {
		log.trace("here");
		return super.hasSelfReferentialForeignKeyBug();
	}

	@Override
	public String getNullColumnString() {
		log.trace("here");
		return super.getNullColumnString();
	}

	@Override
	public String getTableComment(String comment) {
		log.trace("here");
		return super.getTableComment(comment);
	}

	@Override
	public String getColumnComment(String comment) {
		log.trace("here");
		return super.getColumnComment(comment);
	}

	@Override
	public boolean supportsIfExistsBeforeTableName() {
		log.trace("here");
		return super.supportsIfExistsBeforeTableName();
	}

	@Override
	public boolean supportsIfExistsAfterTableName() {
		log.trace("here");
		return super.supportsIfExistsAfterTableName();
	}

	@Override
	public boolean supportsColumnCheck() {
		log.trace("here");
		return super.supportsColumnCheck();
	}

	@Override
	public boolean supportsTableCheck() {
		log.trace("here");
		return super.supportsTableCheck();
	}

	@Override
	public boolean supportsCascadeDelete() {
		log.trace("here");
		return super.supportsCascadeDelete();
	}

	@Override
	public String getCascadeConstraintsString() {
		log.trace("here");
		return super.getCascadeConstraintsString();
	}

	@Override
	public ColumnAliasExtractor getColumnAliasExtractor() {
		log.trace("here");
		return super.getColumnAliasExtractor();
	}

	@Override
	public boolean areStringComparisonsCaseInsensitive() {
		log.trace("here");
		return super.areStringComparisonsCaseInsensitive();
	}

	@Override
	public boolean supportsRowValueConstructorSyntax() {
		log.trace("here");
		return super.supportsRowValueConstructorSyntax();
	}

	@Override
	public boolean supportsRowValueConstructorSyntaxInInList() {
		log.trace("here");
		return super.supportsRowValueConstructorSyntaxInInList();
	}

	@Override
	public boolean useInputStreamToInsertBlob() {
		log.trace("here");
		return super.useInputStreamToInsertBlob();
	}

	@Override
	public boolean replaceResultVariableInOrderByClauseWithPosition() {
		log.trace("here");
		return super.replaceResultVariableInOrderByClauseWithPosition();
	}

	@Override
	public boolean supportsCircularCascadeDeleteConstraints() {
		log.trace("here");
		return super.supportsCircularCascadeDeleteConstraints();
	}

	@Override
	public boolean supportsSubselectAsInPredicateLHS() {
		log.trace("here");
		return super.supportsSubselectAsInPredicateLHS();
	}

	@Override
	public boolean supportsExpectedLobUsagePattern() {
		log.trace("here");
		return super.supportsExpectedLobUsagePattern();
	}

	@Override
	public boolean supportsSubqueryOnMutatingTable() {
		log.trace("here");
		return super.supportsSubqueryOnMutatingTable();
	}

	@Override
	public boolean supportsExistsInSelect() {
		log.trace("here");
		return super.supportsExistsInSelect();
	}

	@Override
	public boolean doesRepeatableReadCauseReadersToBlockWriters() {
		log.trace("here");
		return super.doesRepeatableReadCauseReadersToBlockWriters();
	}

	@Override
	public boolean supportsBindAsCallableArgument() {
		log.trace("here");
		return super.supportsBindAsCallableArgument();
	}

	@Override
	public boolean supportsTupleCounts() {
		log.trace("here");
		return super.supportsTupleCounts();
	}

}
