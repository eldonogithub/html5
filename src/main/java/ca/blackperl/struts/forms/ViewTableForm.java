package ca.blackperl.struts.forms;

import org.apache.struts.action.ActionForm;

import ca.blackperl.dwr.bean.DatabaseResults;

public class ViewTableForm extends ActionForm {

	private String tableSchema;
	private String tableName;
	private DatabaseResults results;
	
	public DatabaseResults getResults() {
		return results;
	}
	public void setResults(DatabaseResults results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "ViewTableForm [tableSchema=" + tableSchema + ", tableName=" + tableName + ", results=" + results + "]";
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
