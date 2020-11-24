package model;
public class Player extends Employee implements Price{
	//Atributes
	private int numberTshirt;
	private int amountGoals;
	private int averageGrade;
	private Position position;

	//Methods
	public Player(String name, String id, double salary, String mood, int numberTshirt, int amountGoals, int averageGrade, Position position){
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
	public void setPosition(Position position){
		this.position=position;
	}
	public Position getPosition(){
		return position;
	}

	public double calculateMarketPrice(){
		double salary=getSalary();
		double price=0;

		if (position==Position.PORTERO){
			price=(salary*12)+(averageGrade*150);
		}else if (position==Position.DEFENSA){
			price=(salary*13)+(averageGrade*125)+(amountGoals*100);
		}else if (position==Position.VOLANTE){
			price=(salary*14)+(averageGrade*135)+(amountGoals*125);
		}else if (position==Position.DELANTERO){
			price=(salary*15)+(averageGrade*145)+(amountGoals*150);
		}

		return price;


	}
	public double calculateStarsLevel(){
		double level=0;

		if (position==Position.PORTERO){
			level=(averageGrade*0.9);
		}else if (position==Position.DEFENSA){
			level=(averageGrade*0.9)+(amountGoals/100);
		}else if (position==Position.VOLANTE){
			level=(averageGrade*0.9)+(amountGoals/90);
		}else if (position==Position.DELANTERO){
			level=(averageGrade*0.9)+(amountGoals/80);
		}

		return level;
	}

	public String toString(){
		String message="";
		double level=calculateStarsLevel();
		double price=calculateMarketPrice();
		message+=super.toString();
		return message+
				"\n**Numero de camiseta: "+numberTshirt+
				"\n**Cantidad de goles que ha marcado en el club: "+amountGoals+
				"\n**Calificacion promedio: "+averageGrade+
				"\n**Posicion: "+position+
				"\n**Precio de mercado: "+price+
				"\n**Nivel como estrella: "+level+
				"\n****************************";
	}

}