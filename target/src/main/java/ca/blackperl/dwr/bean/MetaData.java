package ca.blackperl.dwr.bean;

public class MetaData {

	//	Retrieves a description of the tables available in the given catalog. Only table descriptions matching the catalog, schema, table name and type criteria are returned. They are ordered by TABLE_TYPE, TABLE_CAT, TABLE_SCHEM and TABLE_NAME. 
	//
	//	Each table description has the following columns: 
	//	1.TABLE_CAT String => table catalog (may be null) 
	//	2.TABLE_SCHEM String => table schema (may be null) 
	//	3.TABLE_NAME String => table name 
	//	4.TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM". 
	//	5.REMARKS String => explanatory comment on the table 
	//	6.TYPE_CAT String => the types catalog (may be null) 
	//	7.TYPE_SCHEM String => the types schema (may be null) 
	//	8.TYPE_NAME String => type name (may be null) 
	//	9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null) 
	//	10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null) 
	//
	private String tableCat;
	private String tableSchema;
	private String tableName;
	private String tableType;
	private String remarks;
	private String typeCat;
	private String typeSchem;
	private String typeName;
	private String selfReferencingColName;
	private String refgenerationString;
	
	public String getRefgenerationString() {
		return refgenerationString;
	}
	public String getRemarks() {
		return remarks;
	}
	public String getSelfReferencingColName() {
		return selfReferencingColName;
	}
	public String getTableCat() {
		return tableCat;
	}
	public String getTableName() {
		return tableName;
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public String getTableType() {
		return tableType;
	}
	public String getTypeCat() {
		return typeCat;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getTypeSchem() {
		return typeSchem;
	}
	public void setRefgenerationString(String refgenerationString) {
		this.refgenerationString = refgenerationString;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSelfReferencingColName(String selfReferencingColName) {
		this.selfReferencingColName = selfReferencingColName;
	}
	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public void setTypeCat(String typeCat) {
		this.typeCat = typeCat;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setTypeSchem(String typeSchem) {
		this.typeSchem = typeSchem;
	}
	@Override
	public String toString() {
		return "MetaData [tableCat=" + tableCat + ", tableSchema=" + tableSchema + ", tableName=" + tableName
				+ ", tableType=" + tableType + ", remarks=" + remarks + ", typeCat=" + typeCat + ", typeSchem="
				+ typeSchem + ", typeName=" + typeName + ", selfReferencingColName=" + selfReferencingColName
				+ ", refgenerationString=" + refgenerationString + "]";
	}
}
