package ca.blackperl.dwr.bean;

import java.util.List;

public class DatabaseResults {
	List<String> header;
	List<List<String>> rows;
	
	public List<String> getHeader() {
		return header;
	}
	public void setHeader(List<String> header) {
		this.header = header;
	}
	public List<List<String>> getRows() {
		return rows;
	}
	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "DatabaseResults [header=" + header + ", rows=" + rows + "]";
	}
}
