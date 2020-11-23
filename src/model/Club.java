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
	private String[][]offices;

	//Methods
	public Club(String name, String nit, String creationDate){
		this.name=name;
		this.nit=nit;
		this.creationDate=creationDate;
		workers= new ArrayList<Employee>();
		teams = new Team[AMOUNT_TEAMS];
		teams[0]= new Team("EquipoA");
		teams[1]= new Team("EquipoB");
		offices = new String[ROWS][COLUMNS];
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

	public String hireEmployee(String name, String id, double salary,int years, int teamsInCharge, int championships,int team){
		Employee findEmployee=findEmployee(id);
		MainCoach objMainCoach=null;
		String add="Se añadio el entrenador al equipo";
		
		String message="";
		if (findEmployee==null){
			workers.add(new MainCoach (name,id,salary,"activo",years,teamsInCharge,championships));	

			int index= findEmployeePosition(id);	

			if (index!=-1 && workers.get(index) instanceof MainCoach){
				objMainCoach=(MainCoach) workers.get(index);

				if (team==1){
					teams[0].setHeadCoach(objMainCoach);
				}else if (team==2){
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

	public String hireEmployee(String name, String id, double salary,int years, boolean player, int experticia,int team){
		Employee findEmployee=findEmployee(id);
		Assistant objAssistant=null;
		String add="";
		String message="Se ha contratado el entrenador exitosamente";
		
		if (findEmployee==null){
			if (experticia==1){
				workers.add(new Assistant (name,id,salary,"activo",years,player,Experticia.OFENSIVO));
			}else if (experticia==2){
				workers.add(new Assistant (name,id,salary,"activo",years,player,Experticia.DEFENSIVO));
			}else if (experticia==3){
				workers.add(new Assistant (name,id,salary,"activo",years,player,Experticia.POSESION));
			}else if (experticia==4){
				workers.add(new Assistant (name,id,salary,"activo",years,player,Experticia.JUGADAS_LABORATORIO));
			}else{
				message="No se puedo llenar el campo de experticia del asistente. Por tanto, no se contrato";
			}

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


	public String fireEmployee(String name,String id){
		Employee findEmployee=findEmployee(id);
		String message="";

		if (findEmployee!=null){
			findEmployee.setMood("inactivo");
			message="Se ha despedido a "+findEmployee.getName();			
		}else{
			message="Error. No se puede despedir a un empleado que no está contratado";
		}

		return message;
	}


	public String seeEmployeesInfo(){
		String message=" ";
		boolean exit=false;
		for (int i=0;i<workers.size() && !exit;i++){
			if (workers.get(i)!=null && workers.get(i).getMood().equalsIgnoreCase("activo")){
				message+=workers.get(i).toString();
			}else{
				message+="No hay empleados contratados";
				exit=true;
			}			
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
		String message="";
		ArrayList<Coach> coaches= new ArrayList<Coach>();


		for (int i=0;i<workers.size();i++){
			if (workers.get(i) instanceof MainCoach){
				MainCoach objCoach=(MainCoach)workers.get(i);
				coaches.add(objCoach);
			}else if (workers.get(i) instanceof Assistant){
				Assistant objAssistant=(Assistant)workers.get(i);
				coaches.add(objAssistant);
			}
		}

		

		int index=0;

		for (int x=0;x<offices.length;x+=4){
			for (int y=0;y<offices[0].length;y+=2){
				if (offices[x][y]==null){
					offices[x][y]=coaches.get(index).getName();

					if (index<coaches.size()){
						index++;
					}

					
				}
			}
		}

		for (int z=1;z<offices[0].length;z+=2){
			if (offices[2][z]==null){
				offices[2][z]=coaches.get(index).getName();

				if (index<coaches.size()){
						index++;
				}
				
			}
		}

		for (int a=0;a<offices.length;a++){
			for (int b=0;b<offices[0].length;b++){
				if (offices[a][b]==null){
					offices[a][b]=" ";
				}
			}
		}

		for (int c=0;c<offices.length;c++){
			for (int d=0;d<offices[0].length;d++){
				
				message+="["+offices[c][d]+"]"+" ";				
			}
			message+="";
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
				price=objMainCoach.calculateMarketPrice(findEmployee);
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
				price=objPlayer.calculateMarketPrice(findEmployee);
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
                    