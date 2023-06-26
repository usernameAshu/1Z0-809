package file_io_nio.serialization;

import java.io.Serializable;
import java.time.LocalDate;

public class Cat extends Animal implements Serializable {
	
	private String name ;
	private LocalDate dob ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", dob=" + dob + "]";
	}

}
