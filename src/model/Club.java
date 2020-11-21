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
		offices = new Coach[ROWS][COLUMNS];
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

	public String hireEmployee(String name, String id, double salary,int numberTshirt, int amountGoals, int averageGrade, String position, int team){
		Employee findEmployee=findEmployee(id);
		Player objPlayer=null;		
		String add="";
		String message="";
		if (findEmployee==null){
			workers.add(new Player (name,id,salary,"activo",numberTshirt,amountGoals,averageGrade,position));

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

			message="Se ha contratado el jugador exitosamente";
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
			if (workers.get(i)!=null){
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
 


}
                    