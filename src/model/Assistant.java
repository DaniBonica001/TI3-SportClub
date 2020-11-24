package model;
import java.util.*;
public class Assistant extends Coach{
	//Atributes 
	private boolean player;
	private ArrayList<Experticia> experticia;
	//Methods
	public Assistant(String name, String id, double salary, String mood, int years, boolean player, ArrayList<Experticia> exper){
		super(name,id,salary,mood,years);
		this.player=player;
		experticia=exper;		
	}

	//Setters and getters
	public void setPlayer(boolean player){
		this.player=player;
	}
	public boolean getPlayer(){
		return player;
	}

	public void setExperticia(ArrayList<Experticia> experticia){
		this.experticia=experticia;
	}
	public ArrayList<Experticia> getExperticia(){
		return experticia;
	}

	public String toString(){
		boolean exit=false;
		String message="";
		message+=super.toString();
		String messageExper="";

		for (int i=0;i<experticia.size();i++){
			for (int j=0;j<experticia.size() &&!exit;j++){
				if (i!=j && experticia.get(i)==experticia.get(j)){
					experticia.remove(experticia.get(i));
					exit=true;
				}
			}		
		}

		for (int x=0;x<experticia.size();x++){
			messageExper+=experticia.get(x).name()+", ";
		}

		return message+
				"\n**Fue jugador: "+player+
				"\n**Experticia: "+messageExper+
				"\n****************************";
	}
}