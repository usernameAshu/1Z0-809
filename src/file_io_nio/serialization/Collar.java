package file_io_nio.serialization;

public class Collar {

	private String name;
	private String type;

	public Collar(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Collar [name=" + name + ", type=" + type + "]";
	}
	
	

}
