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

	/**
	* <b>Name: findEmployee</b><br>
	* This method seeks an employee. This method is to avoid that an employee will be created twice.<br>
	* <b>Pre: </b>The workers ArrayList must be initialized. workers!=null.<br>
	* <b>Post: </b> The employee was or wasn't found successfully.<br>
	* @param id String. Identification of the employee. id!="".<br>
	* @return find Employee. If the method find the employee, it will return it because you can't create the same user twice.<br>
	* But, if the method doesn't find the employee, it wouldn't return anything, it would be null and you can create the employee.
	*/
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

	/**
	* <b>Name: findEmployeePosition</b><br>
	* This method seeks the position in the workers ArrayList of an employee.<br>
	* <b>Pre: </b>The workers ArrayList must be initialized. workers!=null.<br>
	* <b>Post: </b> The position of the employee in the workers ArrayList was or wasn't found successfully.<br>
	* @param id String. Identification of the employee. id!="".<br>
	* @return index int. If the method find the position of the employee in the workers ArrayList, it will return the position where is that employee. <br>
	* But, if the method doesn't find the position of the employee, it will return -1.
	*/
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

	/**
	* <b>Name: hireEmployee</b><br>
	* This method allows to create or hire a soccer player and added to the workers ArrayList.<br>
	* <b>Pre: </b>The workers ArrayList must be created. workers!=null.<br>
	* <b>Post: </b>The soccer player was created and hired successfully.<br>
	* @param name String. Name of the soccer player. name!="".<br>
	* @param id String. Identification of the soccer player. id!="".<br>
	* @param salary double. Salary of the soccer player. salary!=0.<br>
	* @param numberTshirt int. Number of the tshirt of a soccer player.<br>
	* @param amountGoals int. Amount of goals of a soccer player.<br>
	* @param averageGrade int. Average grade of a soccer player.<br>
	* @param position int. Number of the position chose by the player. position mayor o igual a 1 y menor o igual a 4.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>
	* @return message String. Message that confirm or deny if the soccer player was created and hired.<br>
	* @return add String. Message that confirm or deny if the soccer player was added to a team.<br>
	*/
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

		/**
	* <b>Name: hireEmployee</b><br>
	* This method allows to create or hire a main coach and added to the workers ArrayList.<br>
	* <b>Pre: </b>The workers ArrayList must be created. workers!=null.<br>
	* <b>Post: </b>The main coach was created and hired successfully.<br>
	* @param name String. Name of the main coach. name!="".<br>
	* @param id String. Identification of the main coach. id!="".<br>
	* @param salary double. Salary of the main coach. salary!=0.<br>
	* @param years int. Experience years of the main coach.<br>
	* @param teamsInCharge int. Amount of teams in charge along all his career.<br>
	* @param championships ArrayList.Names of the championships achieved by the main coach.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>
	* @return message String. Message that confirm or deny if the main coach was created and hired.<br>
	* @return add String. Message that confirm or deny if the main coach was added to a team.<br>
	*/
	public String hireEmployee(String name, String id, double salary,int years, int teamsInCharge, ArrayList<String> championships,int team){		Employee findEmployee=findEmployee(id);
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

	/**
	* <b>Name: hireEmployee</b><br>
	* This method allows to create or hire an assistant and added to the workers ArrayList.<br>
	* <b>Pre: </b>The workers ArrayList must be created. workers!=null.<br>
	* <b>Post: </b>The assistant was created and hired successfully.<br>
	* @param name String. Name of the assistant. name!="".<br>
	* @param id String. Identification of the asssistant. id!="".<br>
	* @param salary double. Salary of the assistant. salary!=0.<br>	
	* @param years int. Experience years of the main coach.<br>
	* @param player boolean. The assistant was(true) or wasn't(false) a soccer player.<br>
	* @param experticia int[]. Array with the numbers of the experticias chose.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>
	* @return message String. Message that confirm or deny if the assistant was created and hired.<br>
	* @return add String. Message that confirm or deny if the assistant was added to a team.<br>
	*/
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

	/**
	* <b>Name: fireEmployee</b><br>
	* This method allows to fire an employee, chage his/her mood to "inactivo" and taken off his/her team.<br>
	* <b>Pre: </b>The employee must be created.<br>
	* <b>Post: </b>The employee has been fire and taken off his/her team<br>
	* @param name String. Name of the employee. name!="".<br>
	* @param id String. Identification of the employee. id!="".<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>
	* @return message. Message that confirm or deny if the employee has been fired.<br>
	* @return message2. Message that confirm or deny if the king of employee has been fired.<br>
	*/
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

	/**
	* <b>Name: seeEmployeesInfo</b><br>
	* This method shows all the information of all the employees.<br>
	* <b>Pre: </b>The workers ArrayList must be initialized. workers!=null.<br>
	* <b>Post: </b> The information of all the employees has been shown.
	* @return message String. Message with all the information of all the employees.
	*/
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

	/**
	* <b>Name: seeEmployeeInfo</b><br>
	* This method shows all the information of an employee.<br>
	* <b>Pre: </b>The workers ArrayList must be initialized. workers!=null.<br>
	* <b>Pre: </b>The employee must be created.<br>
	* <b>Post: </b> The information of the employee has been shown.<br>
	* @param id String. Identification of the employee. id!="".<br>
	* @return message String. Message with all the information of the employee.
	*/
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

	/**
	* <b>Name: seeTeamInfo</b><br>
	* This method shows all the information of a team.<br>
	* <b>Pre: </b>The teams array must be initialized. teams!=null.<br>
	* <b>Pre: </b>The teams must be created.<br>
	* <b>Post: </b> The information of the team chose has been shown.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>	
	* @return message String. Message with all the information of the team chose.
	*/
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

	/**
	* <b>Name: seeTeamsInfo</b><br>
	* This method shows all the information of the teams.<br>
	* <b>Pre: </b>The teams array must be initialized. teams!=null.<br>
	* <b>Post: </b> The information of the teams has been shown.<br>
	* @return message String. Message with all the information of the teams.
	*/
	public String seeTeamsInfo(){
		String message="";
		for (int i=0;i<teams.length;i++){
			if (teams[i]!=null){
				message+=teams[i].toString();
			}
		}

		return message;	
	}

	/**
	* <b>Name: completeInformation</b><br>
	* This method shows all the information of the Club<br>
	* <b>Pre: </b>The workers ArrayList must be initialized. workers!=null.<br>
	* <b>Pre: </b>The teams array must be initialized. teams!=null.<br>
	* <b>Post: </b>All the information of the Club has been shown.<br>
	* @return message String. Message with all the information of the Club.
	*/
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

	/**
	* <b>Name:locateCoaches</b><br>
	* This method allows to locate the coaches in the offices.<br>
	* <b>Post: </b>The coachess have been located in the offices.<br>
	* @return message String. Message that show the matrix with the location of every coach.
	*/
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

	/**
	* <b>Name:locatePlayers</b><br>
	* This method allows to locate the players of a team in a locker room.<br>
	* <b>Post: </b>The players have been located in the locker room.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>	
	* @return message String. Message that show the matrix with the location of every player.
	*/
	public String locatePlayers(int team){
		String message="";

		if (team==1){
			message="Vestidores EquipoA:"+"\n"+teams[0].locatePlayers1();
		}else if (team==2){
			message="Vestidores EquipoB:"+"\n"+teams[1].locatePlayers2();
		}else if (team==3){
			message+="Vestidores EquipoA:"+"\n"+teams[0].locatePlayers1()+"\nVestidores EquipoB"+"\n"+teams[1].locatePlayers2();
		}else{
			message="Error.Opcion incorrecta";
		}

		return message;
	}
	/**
	* <b>Name: calculatePriceCoach</b><br>
	* This method is to call the method calculateMarketPrice in the MainCoach class to calculate the market price of a main coach.<br>
	* <b>Pre: </b>The main coach object must already be created. main coach!=null.<br>
	* <b>Post: </b>The market price of a main coach has been calculated and shown.<br>
	* @param id String. Identification of the main coach. id!="".<br>
	* @return message String. Message with the market price of a main coach.
	*/
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

	/**
	* <b>Name: calculatePricePlayer</b><br>
	* This method is to call the method calculateMarketPrice in the Player class to calculate the market price of a soccer player.<br>
	* <b>Pre: </b>The player object must already be created. player!=null.<br>
	* <b>Post: </b>The market price of a soccer player has been calculated.
	* @param id String. Identification of the soccer player. id!="".<br>
	* @return message String. Message with the market price of a soccer player.
	*/
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

	/**
	* <b>Name: calculateLevelPlayer</b><br>
	* This method is to call the method calculateStarsLevel in the Player class to calculate the stars level of a soccer player.<br>
	* <b>Pre: </b>The player object must already be created. player!=null.<br>
	* <b>Post: </b>The stars level of a soccer player has been calculated.<br>
	* @param id String. Identification of the soccer player. id!="".<br>
	* @return message String. Message with the stars level of a soccer player.
	*/
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

	/**
	* <b>Name: calculateLevelCoach</b><br>
	* This method is to call the method calculateStarsLevel in the MainCoach class to calculate the stars level of a main coach.<br>
	* <b>Pre: </b>The main coach object must already be created. main coach!=null.<br>
	* <b>Post: </b>The stars level of a main coach has been calculated.<br>
	* @param id String. Identification of the main coach. id!="".<br>
	* @return message String. Message with the stars level of a main coach.
	*/
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

	/**
	* <b>Name: addLineUps</b><br>
	* This method allows to send the information of a new lineup to be added in the Team class with the method addLineUps.<br>
	* <b>Post: </b>The new lineup has been created, added to the lineups ArrayList in the Team class and the matrix with the lineup has been shown.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>	
	* @param date String. Date of the lineup. date!=""<br>
	* @param frills int. Amount of frills.<br>
	* @param forwards int. Amount of forwards.<br>
	* @param defenses int. Amount of defenses.<br>
	* @param tactic int. Number of the tactic chose.<br>
	* @return message String. Message that show the matrix with the players of a team in a locker room.
	*/
	public String addLineUps(int team,String date, int frills, int forwards, int defenses,int tactic){
		String message="";
		int sum=0;
		if (frills>=0 && frills<=7 && forwards>=0 && forwards<=7 && defenses>=0 && defenses<=7){
			sum=frills+forwards+defenses;

			if (sum==10){

				message="Su formacion es: "+defenses+"-"+forwards+"-"+frills;
				if (team==1){
					message+="\n"+teams[0].addLineUps(date,frills,forwards,defenses,tactic);					
				}else if (team==2){
					message+="\n"+teams[1].addLineUps(date,frills,forwards,defenses,tactic);			
				}else{
					message="Error.Opcion incorrecta";
				}

			}else if (sum<10){
				message="Error. Faltan jugadores.";
			}else if (sum>10){
				message="Error. Sobran jugadores.";
			}

		}else{
			message="Error. No se puede poner mas de 7 jugadores en una linea";
		}

		return message;
	}

	/**
	* <b>Name: seeAllLineUps</b><br>
	* This method show all the lineups of a team.<br>
	* <b>Pre: </b>The team must be cretaed.<br>
	* <b>Post: </b>All the lineups of a team has been shown.<br>
	* @param team int. Which team, teamA or teamB. If team==1 is teamA, but if team==2 is teamB.<br>	
	* @return message String. Message that show all the lineups and its matrixs of a team.
	*/
	public String seeAllLineUps(int team){
		String message="";

		if (team==1){
			message=teams[0].seeAllLineUps();
		}else if (team==2){
			message=teams[1].seeAllLineUps();
		}else{
			message="Error. Opcion incorrecta";
		}

		return message;
	}

	/**
	* <b>Name: uploadEmployeeInformation</b><br>
	* This method upload the information of a soccer player.<br>
	* <b>Pre: </b>The player objet must be created.objPlayer!=null.<br>
	* <b>Post: </b>The information of the soccer player has been uploaded.<br>.
	* @param id String. Identification of the soccer player. id!="".<br>
	* @param salary double. Salary of the soccer player. salary!=0.<br>
	* @param mood String. It can be "activo" or "inactivo".<br>
	* @param number int. Number of the tshirt of a soccer player.<br>
	* @param goals int. Amount of goals of a soccer player.<br>
	* @param grade int. Average grade of a soccer player.<br>
	* @param position. Number of the position chose by the player. position mayor o igual a 1 y menor o igual a 4.<br>
	* @return message String. Message that confirm or deny if the information of the soccer player has been uploaded.
	*/
	public String uploadEmployeeInformation(String id,double salary,String mood,int number,int goals,int grade,int position){
		Employee findEmployee=findEmployee(id);
		String message="";

		if (findEmployee==null){
			message="Error. El empleado no existe";

		}else{
			findEmployee.setSalary(salary);
			findEmployee.setMood(mood);
			if (findEmployee instanceof Player){
				Player employeePlayer=(Player)findEmployee;
				employeePlayer.setNumberTshirt(number);
				employeePlayer.setAmountGoals(goals);
				employeePlayer.setAverageGrade(grade);

				if (position==1){
					employeePlayer.setPosition(Position.PORTERO);
				}else if (position==2){
					employeePlayer.setPosition(Position.DEFENSA);
				}else if (position==3){
					employeePlayer.setPosition(Position.VOLANTE);
				}else if (position==4){
					employeePlayer.setPosition(Position.DELANTERO);
				}

				message="Se ha actualizado la informacion del jugador";

			}
		}

		return message;
	}

	/**
	* <b>Name: uploadEmployeeInformation</b><br>
	* This method upload the information of a main coach.<br>
	* <b>Pre: </b>The main coach objet must be created.objMainCoach!=null.<br>
	* <b>Post: </b>The information of the main coach has been uploaded.<br>.
	* @param id String. Identification of the main coach. id!="".<br>
	* @param salary double. Salary of the main coach. salary!=0.<br>
	* @param mood String. It can be "activo" or "inactivo".<br>
	* @param years int. Experience years of the main coach.<br>
	* @param amountTeams int. Amount of teams in charge along all his career.<br>
	* @param championshipsAchieved ArrayList.Names of the championships achieved by the main coach.<br>
	* @return message String. Message that confirm or deny if the information of the main coach has been uploaded.
	*/
	public String uploadEmployeeInformation(String id,double salary,String mood,int years,int amountTeams,ArrayList<String>championshipsAchieved){
		Employee findEmployee=findEmployee(id);
		String message="";

		if (findEmployee==null){
			message="Error. El empleado no existe";

		}else{
			findEmployee.setSalary(salary);
			findEmployee.setMood(mood);
			if (findEmployee instanceof MainCoach){
				MainCoach employeeMainCoach=(MainCoach)findEmployee;
				employeeMainCoach.setExperienceYears(years);
				employeeMainCoach.setNumberTeamsInCharge(amountTeams);
				employeeMainCoach.setChampionshipAchieved(championshipsAchieved);

				message="Se ha actualizado la informacion del entrenador";
			}
		}
		return message;
	}

	/**
	* <b>Name: uploadEmployeeInformation</b><br>
	* This method upload the information of an assistant.<br>
	* <b>Pre: </b>The assistant objet must be created.objAssistant!=null.<br>
	* <b>Post: </b>The information of the assistant has been uploaded.<br>.
	* @param id String. Identification of the assistant. id!="".<br>
	* @param salary double. Salary of the assistant. salary!=0.<br>
	* @param mood String. It can be "activo" or "inactivo".<br>
	* @param years int. Experience years of the assistant.<br>
	* @param experticia int[]. Array with the numbers of the experticias chose.<br>
	* @return message String. Message that confirm or deny if the information of the assistant has been uploaded.
	*/
	public String uploadEmployeeInformation(String id,double salary,String mood,int years,int []experticia){

		Employee findEmployee=findEmployee(id);
		String message="";

		if (findEmployee==null){
			message="Error. El empleado no existe";

		}else{
			findEmployee.setSalary(salary);
			findEmployee.setMood(mood);
			if (findEmployee instanceof Assistant){
				Assistant employeeAssistant=(Assistant)findEmployee;
				employeeAssistant.setExperienceYears(years);

				ArrayList<Experticia> experticias= new ArrayList<Experticia>();				

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

				employeeAssistant.setExperticia(experticias);

				message="Se ha actualizado la informacion del asistente tecnico";
				
			}

		}

		return message;
	}
}
                    