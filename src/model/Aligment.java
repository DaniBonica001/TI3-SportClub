package model;
import java.util.*;
public class Aligment{
	//Constants
	public final static int ROWS=10;
	public final static int COLUMNS=7;

	//Atributes
	private String date;
	private int defenses;
	private int forwards;
	private int frills;	
	private Tactic tactic;	
	private int [][] formation;
	//Methods
	public Aligment(String date,int frills,int forwards,int defenses, Tactic tactic){
		this.date=date;
		this.defenses=defenses;
		this.forwards=forwards;
		this.frills=frills;
		this.tactic=tactic;
		formation=new int [ROWS][COLUMNS];

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


	public String locateLineUp(int frills, int forwards, int defenses){
		String message="";
		boolean exit=false;
		int amountFrills=0;
		int forward=0;
		int def=0;

		int [][] lineUp={{0,0,0,0,0,0,0},{0,0,0,1,0,0,0},{0,1,0,0,0,1,0},{0,1,1,0,1,0,0},{0,1,1,0,1,1,0},{0,1,1,1,1,1,0},{1,1,1,1,1,1,0},{1,1,1,1,1,1,1}};

		for (int a=0;a<formation.length;a++){
			for (int b=0;b<formation[0].length ;b++){
				if (a==2){
					for (int i=0;i<lineUp.length;i++){
						if (frills==i){

							if (amountFrills<lineUp[0].length){
								
								formation[a][b]=lineUp[i][amountFrills];
								amountFrills++;
								//exit=true;				

							}					

							
						}
					}
				}else if (a==5){
					for (int d=0;d<lineUp.length;d++){
						if (forwards==d){

							if (forward<lineUp[0].length){
								
								formation[a][b]=lineUp[d][forward];
								forward++;
								//exit=true;							

							}

						}
					}
					

				}else if (a==8){
					for (int e=0;e<lineUp.length;e++){
						if (defenses==e){
							if(def<lineUp[0].length){
								
								formation[a][b]=lineUp[e][def];
								def++;
								//exit=true;
								
							}
						}
					}
					
				}else{
					formation[a][b]=0;
				}
			}
		}

		for (int j=0;j<formation.length;j++){
			for (int k=0;k<formation[0].length;k++){
				message+="["+formation[j][k]+"]";
			}
			message+="\n";
		}

		return message;




	}


}
