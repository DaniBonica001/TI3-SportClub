package model;
public class Assistant extends Coach{
	//Atributes 
	private boolean player;
	private Experticia experticia;
	//Methods
	public Assistant(String name, String id, double salary, String mood, int years, boolean player, Experticia exper){
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

	public void setExperticia(Experticia experticia){
		this.experticia=experticia;
	}
	public Experticia getExperticia(){
		return experticia;
	}

	public String toString(){
		String message="";
		message+=super.toString();
		return message+
				"\n**Fue jugador: "+player+
				"\n**Experticia: "+experticia+
				"\n****************************";
	}
}