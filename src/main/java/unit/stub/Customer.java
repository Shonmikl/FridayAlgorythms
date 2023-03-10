package unit.stub;

public class Customer {
	String name;
	long id;
	public Customer(){
		this(-1);
	}
	public Customer(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
}