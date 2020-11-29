package model;
import java.util.*;
public class Club{
	//Constants
	public final static int AMOUNT_TEAMS=2;
	public final static int ROWS=6;
	public final static int COLUMNS=6;

	//Atributes
	private String name;
	private String nit;
	private String creationDate;

	//Relations
	private ArrayList<Employee> workers;
	private Team [] teams;
	private Coach[][]offices;

	//Methods
	public Club(String name, String nit, String creationDate){
		this.name=name;
		this.nit=nit;
		this.creationDate=creationDate;
		workers= new ArrayList<Employee>();
		teams = new Team[AMOUNT_TEAMS];
		teams[0]= new Team("EquipoA");
		teams[1]= new Team("EquipoB");		
	}
	//Setters and getters
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return  name;
	}

	public void setNit(String nit){
		this.nit=nit;
	}
	public String getNit(){
		return nit;
	}

	public void setCreationDate(String creationDate){
		this.creationDate=creationDate;
	}
	public String getCreationDate(){
		return creationDate;
	}

	public Employee findEmployee(String id){
		Employee find=null;
		boolean exit=false;
		for (int i=0;i<workers.size() && !exit;i++){
			if (workers.get(i).getId().equalsIgnoreCase(id)){
				find=workers.get(i);
				exit=true;
			}
		}

		return find;
	}
	public int findEmployeePosition(String id){
		int index=-1;
		boolean exit=false;
		for (int i=0;i<workers.size() && !exit;i++){
			if (workers.get(i).getId().equalsIgnoreCase(id)){
				index=i;
				exit=true;
			}
		}

		return index;
	}

	public String hireEmployee(String name, String id, double salary,int numberTshirt, int amountGoals, int averageGrade, int position, int team){
		Employee findEmployee=findEmployee(id);
		Player objPlayer=null;		
		String add="";
		String message="Se ha contratado el jugador exitosamente";
		if (findEmployee==null){
			if (position==1){
				workers.add(new Player (name,id,salary,"activo",numberTshirt,amountGoals,averageGrade,Position.PORTERO));
			}else if (position==2){
				workers.add(new Player (name,id,salary,"activo",numberTshirt,amountGoals,averageGrade,Position.DEFENSA));
			}else if (position==3){
				workers.add(new Player (name,id,salary,"activo",numberTshirt,amountGoals,averageGrade,Position.VOLANTE));
			}else if (position==4){
				workers.add(new Player (name,id,salary,"activo",numberTshirt,amountGoals,averageGrade,Position.DELANTERO));
			}else{
				message="No se pudo llenar la posicion del jugador. Por tanto, no se contrato.";
			}			

			int index= findEmployeePosition(id);

			if (index!=-1 && workers.get(index) instanceof Player){
				objPlayer=(Player) workers.get(index);

				if (team==1){
					add=teams[0].addEmployee(objPlayer);
				}else if (team==2){
					add=teams[1].addEmployee(objPlayer);
				}else{
					add="Error. Opcion incorrecta. No se pudo añadir el jugador al equipo. ";
				}
			}			

			
		}else{
			message="Error. El jugador ya esta contratado";		
		}

		return message+" Y "+add;
	}

	public String hireEmployee(String name, String id, double salary,int years, int teamsInCharge, ArrayList<String> championships,int team){
		Employee findEmployee=findEmployee(id);
		MainCoach objMainCoach=null;
		String add="Se añadio el entrenador al equipo";
		
		String message="";
		if (findEmployee==null){
			workers.add(new MainCoach (name,id,salary,"activo",years,teamsInCharge,championships));	

			int index= findEmployeePosition(id);	

			if (index!=-1 && workers.get(index) instanceof MainCoach){
				objMainCoach=(MainCoach) workers.get(index);

				if (team==1 && teams[0].getHeadCoach()==null){
					teams[0].setHeadCoach(objMainCoach);
				}else if (team==2 && teams[1].getHeadCoach()==null){
					teams[1].setHeadCoach(objMainCoach);
				}else{
					add="Error. Opcion incorrecta. No se pudo añadir el entrenador al equipo";
				}
			}	

			message="Se ha contratado el entrenador exitosamente";
		}else{
			message="Error. El entrenador ya esta contratado";		
		}

		return message+" Y "+add;
	}

	public String hireEmployee(String name, String id, double salary,int years, boolean player, int[] experticia,int team){
		Employee findEmployee=findEmployee(id);
		Assistant objAssistant=null;
		ArrayList<Experticia> experticias= new ArrayList<Experticia>();

		String add="";
		String message="Se ha contratado el entrenador exitosamente";

		for (int i=0;i<experticia.length;i++){
			switch (experticia[i]){

				case 1: experticias.add(Experticia.OFENSIVO);
				break;

				case 2:	experticias.add(Experticia.DEFENSIVO);
				break;

				case 3:	experticias.add(Experticia.POSESION);
				break;	

				case 4:	experticias.add(Experticia.JUGADAS_LABORATORIO);
				break;

				case 5:	experticias.add(Experticia.ENTRENADOR_ARQUEROS);
				break;

				case 6:	experticias.add(Experticia.ENTRENADOR_DEFENSAS);
				break;

			}
			
		}
		
		if (findEmployee==null){

			workers.add(new Assistant (name,id,salary,"activo",years,player,experticias));
		
			int index= findEmployeePosition(id);	

			if (index!=-1 && workers.get(index) instanceof Assistant){
				objAssistant=(Assistant) workers.get(index);

				if (team==1){
					add=teams[0].addEmployee(objAssistant);
				}else if (team==2){
					add=teams[1].addEmployee(objAssistant);
				}else{
					add="Error. Opcion incorrecta. No se pudo añadir el asistente al equipo. ";
				}

			}			
			
		}else{
			message="Error. El entrenador ya esta contratado";		
		}
		return message+" Y "+add;
	}


	public String fireEmployee(String name,String id,int team){
		Employee findEmployee=findEmployee(id);
		String message="";
		String message2="";

		if (findEmployee!=null){
			findEmployee.setMood("inactivo");

			if (team==1 && findEmployee instanceof Player){
				Player objPlayer=(Player)findEmployee;
				message2=teams[0].firePlayer(objPlayer);
			}else if (team==2 && findEmployee instanceof Player){
				Player objPlayer=(Player)findEmployee;
				message2=teams[1].firePlayer(objPlayer);
			}else if (team==1 && findEmployee instanceof Assistant){
				Assistant objAssistant=(Assistant)findEmployee;
				message2=teams[0].fireAssistant(objAssistant);
			}else if (team==2 && findEmployee instanceof Assistant){
				Assistant objAssistant=(Assistant)findEmployee;
				message2=teams[1].fireAssistant(objAssistant);
			}else if (team==1 && findEmployee instanceof MainCoach){
				MainCoach objCoach=null;
				teams[0].setHeadCoach(objCoach);
				message2="Se ha despedido el entrenador principal";
			}else if (team==2 && findEmployee instanceof MainCoach){
				MainCoach objCoach=null;
				teams[1].setHeadCoach(objCoach);
				message2="Se ha despedido el entrenador principal";

			}

		
			message="Se ha despedido a "+findEmployee.getName();			
		}else{
			message="Error. No se puede despedir a un empleado que no está contratado";
		}

		return message+" Y "+message2;
	}


	public String seeEmployeesInfo(){
		String message="";
		for (int i=0;i<workers.size();i++){
			if (workers.get(i)!=null && workers.get(i).getMood().equalsIgnoreCase("activo")){
				message+=workers.get(i).toString();
			}			
		}
		if (message==""){
			message="No hay empleados contratados";
		}
		return message;
	}

	public String seeEmployeeInfo(String id){
		String message="";
		int index= findEmployeePosition(id);

		if (index!=-1){
			message=workers.get(index).toString();
		}else{
			message="El empleado no existe";
		}

		return message;		
	}


	public String seeTeamInfo(int team){
		String message="";

		if (team==1){
			if (teams[0]!=null){
				message+=teams[0].toString();
			}
		}else if (team==2){
			if (teams[1]!=null){
				message+=teams[1].toString();
			}
		}	

		return message;	
	}

	public String seeTeamsInfo(){
		String message="";
		for (int i=0;i<teams.length;i++){
			if (teams[i]!=null){
				message+=teams[i].toString();
			}
		}

		return message;	
	}

	public String completeInformation(){
		String employeesInfo=seeEmployeesInfo();
		String teamsInfo=seeTeamsInfo();
		//Me falta poner los vestuarios y oficinas
		return "\n****************************"+
				"\n***********CLUB************"+
				"\n**Nombre: "+name+
				"\n**NIT: "+nit+
				"\n**Fecha de creacion: "+creationDate+
				"\n****************************"+
				"\n*********EMPLEADOS**********"+
				"\n"+employeesInfo+
				"\n****************************"+
				"\n**********EQUIPOS***********"+
				"\n"+teamsInfo+
				"\n****************************";
	}

	public String locateCoaches(){
		int counter=0;
		int index=0;
		String message="";
		boolean exit=false;
		ArrayList<Coach> coaches= new ArrayList<Coach>();

		offices=new Coach[ROWS][COLUMNS];


		for (int i=0;i<workers.size();i++){
			if (workers.get(i) instanceof MainCoach && workers.get(i).getMood().equalsIgnoreCase("activo")){
				MainCoach objCoach=(MainCoach)workers.get(i);
				coaches.add(objCoach);
			}else if (workers.get(i) instanceof Assistant && workers.get(i).getMood().equalsIgnoreCase("activo")){
				Assistant objAssistant=(Assistant)workers.get(i);
				coaches.add(objAssistant);
			}
		}


		for (int x=0;x<offices.length && !exit;x+=2){
			for (int y=0;y<offices[0].length && !exit;y+=2){

				if (x==2 && counter<=coaches.size()){					
					offices[x][y+1]=coaches.get(index);
					index++;
					counter++;

				}else {

					if (offices[x][y]==null && counter<=coaches.size()){
						offices[x][y]=coaches.get(index);
						index++;
						counter++;						
					}
				}

				if (counter==coaches.size()){
					exit=true;
				}

			
			}
		}

		for (int j=0;j<offices.length;j++){
			for (int k=0;k<offices[0].length;k++){
				if (offices[j][k]!=null){
					message+="["+offices[j][k].getName()+"]";
				}else if (offices[j][k]==null){
					message+="[ ]";
				}
			}
			message+="\n";
		}

		return message;

	}



	public String locatePlayers(int team){
		String message="";

		if (team==1){
			message=teams[0].locatePlayers();
		}else if (team==2){
			message=teams[1].locatePlayers();
		}

		return message;


	}


	public String calculatePriceCoach(String id){
		Employee findEmployee=findEmployee(id);
		double price=0;
		String message="";

		if (findEmployee==null){
			message="El entrenador no esta contratado";
		}else{
			if (findEmployee instanceof MainCoach){
				MainCoach objMainCoach=(MainCoach)findEmployee;
				price=objMainCoach.calculateMarketPrice();
				message="El precio de mercado del entrenador "+findEmployee.getName()+" es de: "+price;
			}
		}

		return message;
	}

	public String calculatePricePlayer(String id){
		Employee findEmployee=findEmployee(id);
		double price=0;
		String message="";

		if (findEmployee==null){
			message="El jugador no esta contratado";
		}else{
			if (findEmployee instanceof Player){
				Player objPlayer=(Player)findEmployee;
				price=objPlayer.calculateMarketPrice();
				if (price!=0){
					message="El precio de mercado del jugador "+findEmployee.getName()+" es de: "+price;
				}else{
					message="Error.No se pudo calcular el precio del jugador";
				}
				
			}
		}
		return message;
	}
 

 	public String calculateLevelPlayer(String id){
		Employee findEmployee=findEmployee(id);
		double level=0;
		String message="";

		if (findEmployee==null){
			message="El jugador no esta contratado";
		}else{
			if (findEmployee instanceof Player){
				Player objPlayer=(Player)findEmployee;
				level=objPlayer.calculateStarsLevel();
				if (level!=0){
					message="El nivel del jugador "+findEmployee.getName()+" es de: "+level;
				}else{
					message="Error.No se pudo calcular el nivel del jugador";
				}
				
			}
		}
		return message;
	}

	public String calculateLevelCoach(String id){
		Employee findEmployee=findEmployee(id);
		double level=0;
		String message="";

		if (findEmployee==null){
			message="El entrenador no esta contratado";
		}else{
			if (findEmployee instanceof MainCoach){
				MainCoach objMainCoach=(MainCoach)findEmployee;
				level=objMainCoach.calculateStarsLevel();
				message="El nivel del entrenador "+findEmployee.getName()+" es de: "+level;
			}
		}

		return message;
	}


}
                    