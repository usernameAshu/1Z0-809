package file_io_nio.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Dog implements Serializable {

	private String name;
	private transient Collar collar;

	public Dog(String name, Collar collar) {
		super();
		this.name = name;
		this.collar = collar;
	}

	public String getName() {
		return name;
	}

	public Collar getCollar() {
		return collar;
	}
	
	private void writeObject(ObjectOutputStream oos) {
		//for saving the Collar object 
		try {
			oos.defaultWriteObject();
			oos.writeUTF(this.collar.getName());
			oos.writeUTF(this.collar.getType());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void readObject(ObjectInputStream ois) {
		
		try {
			ois.defaultReadObject();
			this.collar = new Collar(ois.readUTF(), ois.readUTF());
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", collar=" + collar + "]";
	}
	
	

}
