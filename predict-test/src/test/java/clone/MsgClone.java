package clone;

public class MsgClone implements Cloneable {
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
	
	public MsgClone(int id,String name) {
		this.id=id;
		this.name=name;
	} 
	
	@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
	}
	

//    return "Person [age=" + age + ", name=" + name + ", address=" + address + "]";
}
