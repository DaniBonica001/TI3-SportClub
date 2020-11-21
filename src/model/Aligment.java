package model;
import java.util.*;
public class Aligment{
	//Atributes
	private String date;
	private int [][] formation;
	private Tactic tactic;
	//Methods
	public Aligment(String date,int[][] lineUps, Tactic tactic){
		this.date=date;
		formation=lineUps;
		this.tactic=tactic;

	}

	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return  date;
	}

	public void setTactic(Tactic tactic){
		this.tactic=tactic;
	}
	public Tactic getTactic(){
		return  tactic;
	}


}