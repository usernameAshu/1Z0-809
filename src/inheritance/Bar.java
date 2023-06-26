package inheritance;

public class Bar extends Foo {

	private int id;
	private String name;

	public Bar() {
		super();
		System.out.println("No-args constructor of Bar");
	}

	public Bar(int id, String name) {
		System.out.println("Args constructor of Bar");
		this.id = id;
		this.name = name;
	}

	@Override
	public void changeName(String newName) {
		System.out.println("Bar.changeName");
		super.changeName(newName);
	}

	@Override
	public String toString() {
		return "Bar [id=" + id + ", name=" + name + "]";
	}
	
	

}
