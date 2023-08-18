package conceptsTesting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class _equals_hashcode {
	public static void main(String[] args) {
		Department software = new Department("Manager","Architect","8A");
		Department finance = new Department("Manager","Accounts","8A");
		
		Employee ravi = new Employee("1234","Ravi Kumar",software);
		Employee kishan = new Employee("1234","Kishan Kumar",finance);
		
		System.out.println("Hashcode of ravi :"+ ravi.hashCode());
		System.out.println("Hashcode of kishan :"+ kishan.hashCode());
		
		if(ravi.equals(kishan)) {
			System.out.println("Both employee are same\n"+ravi+"\n"+kishan);
		} else {
			System.out.println("Different employees\n"+ravi+"\n"+kishan);
		}
	}

}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Employee {
	private String id;
	private String name;
	private Department department;
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(this==(Employee)obj) 
			return true;
		else if(obj instanceof Employee && this.getId().equalsIgnoreCase(((Employee)obj).getId()))
			return true;
		else 
			return false;
	}
	
	
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Department {
	private String position;
	private String role;
	private String band;
}