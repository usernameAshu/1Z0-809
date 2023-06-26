package inheritance;

public class Foo {
	
	private int id;
	private String name;
	
	public Foo() {
		System.out.println("No-args constructor of Foo");
	}

	public Foo(int id, String name) {
		System.out.println("Arg constructor of Foo");
		this.id = id;
		this.name = name;
	}

	public void changeName(String newName) {
		this.name = newName;
	}

	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + "]";
	}
	
	
}
