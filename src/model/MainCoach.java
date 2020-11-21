package model;
public class MainCoach extends Coach {
	//Atributes
	private int numberTeamsInCharge;
	private int championshipAchieved;
	//Methods
	public MainCoach(String name, String id, double salary, String mood, int years,int teamsInCharge, int championships){
		super(name,id,salary,mood,years);
		numberTeamsInCharge=teamsInCharge;
		championshipAchieved=championships;
	}

	//Setters and getters
	public void setNumberTeamsInCharge(int numberTeamsInCharge){
		this.numberTeamsInCharge=numberTeamsInCharge;
	}
	public int getNumberTeamsInCharge(){
		return numberTeamsInCharge;		
	}

	public void setChampionshipAchieved(int championshipAchieved){
		this.championshipAchieved=championshipAchieved;
	}
	public int getChampionshipAchieved(){
		return championshipAchieved;
	}

	public String toString(){
		String message="";
		message+=super.toString();
		return message+
				"\n**Numero de equipos a cargo en su carrera: "+numberTeamsInCharge+
				"\n**Campeonatos conseguidos: "+championshipAchieved+
				"\n****************************";
	}

	//public double calculateMarketPrice();
	//public int calculateStarsLevel();
}