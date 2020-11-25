package model;
import java.util.*;
public class MainCoach extends Coach implements Price {
	//Atributes
	private int numberTeamsInCharge;
	private  ArrayList<String>championshipAchieved;
	//Methods
	public MainCoach(String name, String id, double salary, String mood, int years,int teamsInCharge, ArrayList<String> championships){
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

	public void setChampionshipAchieved(ArrayList<String> championshipAchieved){
		this.championshipAchieved=championshipAchieved;
	}
	public ArrayList<String> getChampionshipAchieved(){
		return championshipAchieved;
	}
	public double calculateMarketPrice(){
		double salary= getSalary();
		int years=getExperienceYears();

		double price=(salary*10)+(years*100)+(championshipAchieved.size()*50);

		return price;

	}
	public double calculateStarsLevel(){
		double level= 5+(championshipAchieved.size()/10);
		return level;
	}

	public String toString(){
		String message="";
		String messageChampionships="";
		boolean exit=false;

		for (int i=0;i<championshipAchieved.size();i++){
			for (int j=0;j<championshipAchieved.size() &&!exit;j++){
				if (i!=j && championshipAchieved.get(i).equalsIgnoreCase(championshipAchieved.get(j))){
					championshipAchieved.remove(championshipAchieved.get(i));
					exit=true;
				}
			}		
		}

		for (int x=0;x<championshipAchieved.size();x++){
			messageChampionships+=championshipAchieved.get(x)+", ";
		}


		double price= calculateMarketPrice();
		double level= calculateStarsLevel();
		message+=super.toString();
		return message+
		"\n**Numero de equipos a cargo en su carrera: "+numberTeamsInCharge+
		"\n**Campeonatos conseguidos: "+messageChampionships+
		"\n**Precio de mercado: "+price+
		"\n**Nivel como estrella: "+level+
		"\n****************************";
	}
}