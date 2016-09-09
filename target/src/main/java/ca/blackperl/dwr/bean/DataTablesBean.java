package ca.blackperl.dwr.bean;

import java.util.Arrays;

public class DataTablesBean {
	private int draw;
	private int start;
	private int length;
	private Search search;
	private Order [] order;
	private Column [] columns;
	public Column[] getColumns() {
		return columns;
	}
	public int getDraw() {
		return draw;
	}
	public int getLength() {
		return length;
	}
	public Order[] getOrder() {
		return order;
	}
	public Search getSearch() {
		return search;
	}
	public int getStart() {
		return start;
	}
	public void setColumns(Column[] columns) {
		this.columns = columns;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setOrder(Order[] order) {
		this.order = order;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "DataTablesBean [draw=" + draw + ", start=" + start + ", length=" + length + ", search=" + search
				+ ", order=" + Arrays.toString(order) + ", columns=" + Arrays.toString(columns) + "]";
	}
}
