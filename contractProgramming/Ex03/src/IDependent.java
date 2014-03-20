public interface IDependent {
	
	//@ requires employee != null;
	//@ ensures GetEmployee() != null;
	void SetEmployee(IEmployee employee);
	
	//@ requires !name.isEmpty();
	//@ ensures GetName() == name;
	void SetName(String name);
	
	//@ requires age > 0;
	//@ ensures GetAge() == age;
	void SetAge(int age);
	
	//@ pure;
	IEmployee GetEmployee();
	
	//@ pure;
	String GetName();
	
	//@ pure;
	int GetAge();
}