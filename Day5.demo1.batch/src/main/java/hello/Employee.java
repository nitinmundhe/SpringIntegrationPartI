package hello;

public class Employee {

    private String ename;
    private Integer salary;

    public Employee() {
    }

	public Employee(String ename, Integer salary) {
		super();
		this.ename = ename;
		this.salary = salary;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", salary=" + salary + "]";
	}

}
