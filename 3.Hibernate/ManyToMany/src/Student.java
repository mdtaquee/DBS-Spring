import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_Details")
public class Student {
	
	@Id
	@Column(name = "pin")
	private int pin;
	@Column(name = "name")
	private String name;
	
	Student(){
		
	}
	
	Student(int pin, String name){
		this.pin = pin;
		this.name = name;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Pin : "+this.getPin()+"\tName : "+this.getName();
	}
	
}
