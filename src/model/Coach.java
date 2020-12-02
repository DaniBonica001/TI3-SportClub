package model;
public class Coach extends Employee{
	//Atributes
	private int experienceYears;
	//Methods
	public Coach(String name, String id, double salary, String mood, int years){
		super(name,id,salary,mood);
		experienceYears=years;
	}

	//Setters and getters
	public void setExperienceYears(int experienceYears){
		this.experienceYears=experienceYears;
	}
	public int getExperienceYears(){
		return experienceYears;
	}

	/**
	* <b>Name: toString</b><br>
	* This method allows to show all the information of a coach.<br>
	* <b>Pre: </b> The coach must already be created. <br>
	* <b> Post: </b> The information of the coach will be shown according to the format created.
	*/
	public String toString(){
		String message="";
		message+=super.toString();
		return message+
				"\n**Anos de experiencia: "+experienceYears;
	}
}