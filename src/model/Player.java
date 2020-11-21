package model;
public class Player extends Employee {
	//Atributes
	private int numberTshirt;
	private int amountGoals;
	private int averageGrade;
	private String position;

	//Methods
	public Player(String name, String id, double salary, String mood, int numberTshirt, int amountGoals, int averageGrade, String position){
		super(name,id,salary,mood);
		this.numberTshirt=numberTshirt;
		this.amountGoals=amountGoals;
		this.averageGrade=averageGrade;
		this.position=position;
	}

	//Setters and getters
	public void setNumberTshirt(int numberTshirt){
		this.numberTshirt=numberTshirt;
	}
	public int getNumberTshirt(){
		return numberTshirt;
	}

	public void setAmountGoals(int amountGoals){
		this.amountGoals=amountGoals;
	}
	public int getAmountGoals(){
		return amountGoals;
	}

	public void setAverageGrade(int averageGrade){
		this.averageGrade=averageGrade;
	}
	public int getAverageGrade(){
		return averageGrade;
	}
	public void setPosition(String position){
		this.position=position;
	}
	public String getPosition(){
		return position;
	}

	public String toString(){
		String message="";
		message+=super.toString();
		return message+
				"\n**Numero de camiseta: "+numberTshirt+
				"\n**Cantidad de goles que ha marcado en el club: "+amountGoals+
				"\n**Calificacion promedio: "+averageGrade+
				"\n**Posicion: "+position+
				"\n****************************";
	}


	//public double calculateMarketPrice();
	//public int calculateStarsLevel();

}