package clone;

import java.io.Serializable;

public class Msg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String name;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	 
	private Address address;
	
	public Msg(int id,String name,Address address) { 
		this.id=id;
		this.name=name;
		this.address=address;
	}
	public Msg() { 
	}
}
