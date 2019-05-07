package demo;

public class Flights {

	private String from;
	private String to;
	private String where;
	public String getFrom() {
		return from;
	}
	public Flights(String from, String to, String where) {
		super();
		this.from = from;
		this.to = to;
		this.where = where;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
}
