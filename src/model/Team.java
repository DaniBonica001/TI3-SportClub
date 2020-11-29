package model;
import java.util.*;
public class Team{
	//Constants
	public final static int AMOUNT_PLAYERS=25;
	public final static int AMOUNT_ASSISTANTS=3;
	public final static int ROWS=7;
	public final static int COLUMNS=6;
	//Atributes 
	private String name;

	//Relations
	private Player[]players;
	private MainCoach headCoach;
	private Assistant[]assistants;
	private ArrayList<Aligment> lineups;
	private Player[][]lockerRoomPlayers;

	//Methods 
	public Team(String nam){
		name=nam;
		headCoach=null;
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

	public MainCoach getHeadCoach(){
		return headCoach;
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


	public String firePlayer(Player player){
		String message="";
		boolean exit=false;
		for (int i=0;i<players.length && !exit;i++){
			if (players[i].getId().equalsIgnoreCase(player.getId())){
				players[i]=null;
				exit=true;
				message="Se ha eliminado al jugador del equipo";
			}
		}

		if (exit==false){
			message="No se ha eliminado al jugador del equipo";
		}

		return message;

	}

	public String fireAssistant(Assistant assistant){
		String message="";
		boolean exit=false;
		for (int i=0;i<assistants.length;i++){
			if (assistants[i].getId().equalsIgnoreCase(assistant.getId())){
				assistants[i]=null;
				exit=true;
				message="Se ha eliminado al asistente del equipo";
			}
		}

		if (exit==false){
			message="No se ha eliminado al asistente  dell equipo";
		}
		return message;
	}

	public String locatePlayers(){
		String message="";
		boolean exit=false;
		int counter=0;
		int index=0;
		String names="Se quedaron sin vestidor: ";

		
		List<Player> playersList= Arrays.asList(players);

		Collections.shuffle(playersList);
	

		lockerRoomPlayers= new Player[ROWS][COLUMNS];

		for (int k=0;k<lockerRoomPlayers.length;k++){
			for (int j=0;j<lockerRoomPlayers[0].length && !exit;j+=2){

				if (k%2!=0 && counter<=playersList.size() ){
					lockerRoomPlayers[k][j+1]=playersList.get(index);
					counter++;
					index++;
					
				}else if (lockerRoomPlayers[k][j]==null && counter<=playersList.size()){
					lockerRoomPlayers[k][j]=playersList.get(index);
					counter++;
					index++;
					
				}

				if (counter==playersList.size()){
					exit=true;
				}else if (counter==21){
					exit=true;
					for (int a=index+1;a<playersList.size();a++){
						if (playersList.get(a)!=null){
							names+=playersList.get(a).getName()+", ";
						}

					}
				}



			}
		}

		for (int a=0;a<lockerRoomPlayers.length;a++){
			for (int b=0;b<lockerRoomPlayers[0].length;b++){
				if (lockerRoomPlayers[a][b]!=null){
					message+="["+lockerRoomPlayers[a][b].getName()+"]";
				}else if (lockerRoomPlayers[a][b]==null){
					message+="[ ]";
				}
			}
			message+="\n";
		}

		return message+" Y "+names;

		


	}








	public String toString(){
		String message1="";
		String message2="";
		String coachName="";

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

		if (headCoach!=null){
			coachName=headCoach.getName();
		}else if (headCoach==null){
			coachName= "null";
		}


		return "\n****************************"+
				"\n**Nombre: "+name+
				"\n**Entrenador principal: "+coachName+
				"\n**Jugadores: "+message1+
				"\n**Asistentes: "+message2+
				"\n****************************";

	}


	
}