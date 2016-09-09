package ca.blackperl.dwr.bean;

public class Order {
	private int column;
	private String dir;
	public int getColumn() {
		return column;
	}
	public String getDir() {
		return dir;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	@Override
	public String toString() {
		return "Order [column=" + column + ", dir=" + dir + "]";
	}
}
