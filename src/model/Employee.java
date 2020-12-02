package model;
public abstract class Employee{
	//Atributes
	private String name;
	private String id;
	private double salary;
	private String mood;

	//Methods
	public Employee(String name, String id, double salary, String mood){
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.mood=mood;
	}

	//Setters and getters
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return  name;
	}

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}

	public void setSalary(double salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}

	public void setMood(String mood){
		this.mood=mood;
	}
	public String getMood(){
		return mood;
	}

	/**
	* <b>Name: toString</b><br>
	* This method allows to show all the information of an employee.<br>
	* <b>Pre: </b> The employee must already be created. <br>
	* <b> Post: </b> The information of the user will be shown according to the format created.
	*/
	public String toString(){
		return "\n****************************"+
				"\n**Nombre: "+name+
				"\n**ID: "+id+
				"\n**Salario: "+salary+
				"\n**Estado: "+mood;
	}

}