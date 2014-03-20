package ex03;

public interface IEmployee {
	
	//@ requires registration >= 0 && registration <= 1000;
	void SetRegistration(int registration);
	
	//@ requires !name.isEmpty();
	void SetName(String name);
	
	//@ requires baseSalary > 0.0;
	void SetBaseSalary(float baseSalary);
	
	//@ requires age > 0;
	void SetAge(int age);
}
