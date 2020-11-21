package model;
import java.util.*;
public class Team{
	//Constants
	public final static int AMOUNT_PLAYERS=25;
	public final static int AMOUNT_ASSISTANTS=3;
	//Atributes 
	private String name;

	//Relations
	private Player[]players;
	private MainCoach headCoach;
	private Assistant[]assistants;
	private ArrayList<Aligment> lineups;

	//Methods 
	public Team(String nam){
		name=nam;
		//headCoach=coach;
		players= new Player[AMOUNT_PLAYERS];
		assistants= new Assistant [AMOUNT_ASSISTANTS];
		lineups= new ArrayList<Aligment>();
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return  name;
	}

	public void setHeadCoach(MainCoach headCoach){
		this.headCoach=headCoach;
	}

	public Player findPlayer(String id){
		Player find=null;
		boolean exit=false;
		for (int i=0;i<players.length && !exit;i++){
			if (players[i]!=null && players[i].getId().equalsIgnoreCase(id)){
					find=players[i];
					exit=true;
			}
						
		}
	return find;
	}


	public Assistant findAssistant(String id){
		Assistant find=null;
		boolean exit=false;
		for (int i=0;i<assistants.length && !exit;i++){
			if (assistants[i]!=null && assistants[i].getId().equalsIgnoreCase(id)){
					find=assistants[i];
					exit=true;
			}
						
		}
	return find;
	}


	public String addEmployee(Player newPlayer){
		Player findPlayer=findPlayer(newPlayer.getId());
		boolean exit=false;
		String message="";

		if (findPlayer==null){
			for (int i=0;i<players.length && !exit;i++){
				if (players[i]==null){
					players[i]=newPlayer;
					exit=true;

					message="Se ha anadido el jugador al equipo";
				}
			}


			if (exit==false){
				message="Error. No se pueden anadir mas jugadores";
			}
		}else{
			message="Error. El jugador ya esta en el equipo";
		}
	return message;
	}

	public String addEmployee(Assistant newAssistant){
		Assistant findAssistant= findAssistant(newAssistant.getId());
		boolean exit=false;
		String message="";

		if (findAssistant==null){
			for (int i=0;i<assistants.length && !exit;i++){
				if (assistants[i]==null){
					assistants[i]=newAssistant;
					exit=true;

					message="Se ha añadido el asistente al equipo";

				}
			}

			if (exit==false){
				message="Errror.No se pueden anadir mas asistentes";
			}
		}else{
			message="Error. El asistente ya esta en el equipo";
		}

	return message;
	}

	public String toString(){
		String message1="";
		String message2="";

		for (int i=0;i<players.length;i++){
			if (players[i]!=null){
				message1+=players[i].getName()+", ";
			}			
		}

		for (int j=0;j<assistants.length;j++){
			if (assistants[j]!=null){
				message2+=assistants[j].getName()+", ";
			}			
		}

		

		return "\n****************************"+
				"\n**Nombre: "+name+
				"\n**Entrenador principal: "+headCoach+
				"\n**Jugadores: "+message1+
				"\n**Asistentes: "+message2+
				"\n****************************";

	}


	
}