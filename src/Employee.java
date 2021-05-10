import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Employee {
String name;
int age;
int startTime;
int endTime;
public Employee() throws IOException {
	
	System.out.println("\nEnter employee name:");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = br.readLine();
	this.name=s;
	
	System.out.println("\nEnter employee age:");
	BufferedReader brAge = new BufferedReader(new InputStreamReader(System.in));
	String a = brAge.readLine();
	int Age = Integer.parseInt(a);
	this.age=Age;
	}

void startTimeSetter() throws IOException {
	System.out.println("\nEnter start of shift:");
	BufferedReader time = new BufferedReader(new InputStreamReader(System.in));
	
	String a = time.readLine();
	int startTime = Integer.parseInt(a);
	this.startTime=startTime;
}

void endTimeSetter() throws IOException {
	System.out.println("\nEnter end of shift:");
	BufferedReader time = new BufferedReader(new InputStreamReader(System.in));
	
	String a = time.readLine();
	int endTime = Integer.parseInt(a);
	this.endTime=endTime;
}

int startTimeGetter() {
	return this.startTime;
}

int endTimeGetter() {
	return this.endTime;
}

void getInfo() {
	System.out.println("Name: "+this.name + ";\n"
			+ "Age: "+this.age+";\n"
					+ "Schedule: "+this.startTimeGetter()+" - "+this.endTimeGetter()+";");
}
void employeeSwitcher() throws IOException {
BufferedReader option = new BufferedReader(new InputStreamReader(System.in));
	
	String a = option.readLine();
	int choice = Integer.parseInt(a);
	if(choice == 1) {
		new Employee();
		this.startTimeSetter();
		this.endTimeSetter();
	}
	else if(choice == 2){
		
	}
	else {
		System.out.println("Please choose a valid option.");
		this.employeeSwitcher();
	}
}
}
