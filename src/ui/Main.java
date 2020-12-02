package ui;
import model.Club;
import java.util.*;
public class Main{
	public static Club objClub;
	public final static Scanner lector = new Scanner (System.in);

	public static void main(String[] args) {
		System.out.println("\n");
		createClub();

		boolean menu=true;
		while (menu){
			System.out.println("\nSeleccione una opcion:"+
								"\n1.Contratar empleados"+
								"\n2.Despedir empleados"+
								"\n3.Ver informacion de los empleados"+
								"\n4.Ver la informacion de los equipos"+
								"\n5.Ver toda la informacion del club"+
								"\n6.Ubicar los entrenadores en oficinas"+
								"\n7.Ubicar a los jugadores de los vestidores"+
								"\n8.Calcular el precio de mercado para entrenadores principales o jugadores"+
								"\n9.Calcular el nivel para entrenadores principales o jugadores"+
								"\n10.Agregar alineaciones a un equipo"+
								"\n11.Ver todas las formaciones de un equipo"+
								"\n12.Actualizar la informacion de un empleado"+
								"\n0.Para salir");
			int option=lector.nextInt();
			lector.nextLine();
			switch(option){
				case 1: hireEmployee();
				break;

				case 2: fireEmployee();
				break;

				case 3: 

				System.out.println("Desea: "+
									"\n1.Ver la informacion de un empleado en particular"+
									"\n2.Ver la informacion de todos los empleados");
				int info=lector.nextInt();
				lector.nextLine();

					if (info==1){
						System.out.println("Ingrese el ID del empleado");
						String id=lector.nextLine();
						System.out.println(objClub.seeEmployeeInfo(id));
					}else if (info==2){
						System.out.println(objClub.seeEmployeesInfo());
					}else{
						System.out.println("Opcion incorrecta");
					}
				break;

				case 4: 
					System.out.println("Desea: "+
										"\n1.Ver la informacion de un equipo en particular"+
										"\n2.Ver la informacion de todos los equipos");
					int whichTeam=lector.nextInt();
					lector.nextLine();

					if (whichTeam==1){
						System.out.println("\n1.EquipoA"+
										"\n2.EquipoB");
						int which=lector.nextInt();
						lector.nextLine();

						System.out.println(objClub.seeTeamInfo(which));						
					}else if (whichTeam==2){
						System.out.println(objClub.seeTeamsInfo());						
					}else {
						System.out.println("Opcion incorrecta");
					}
				
				break;

				case 5: System.out.println(objClub.completeInformation());
				break;				

				case 6: System.out.println(objClub.locateCoaches());
				break;

				case 7: locatePlayers();
				break;

				case 8: calculatePrice();
				break;

				case 9: calculateLevel();
				break;

				case 10: addLineUps();
				break;

				case 11: seeAllLineUps();
				break;

				case 12: uploadEmployeeInformation();
				break;

				case 0: System.out.println("¡Bye!");
				menu=false;
				break;

				default: System.out.println("Opcion incorrecta");
				break;

			}
		}		
	}

	/**
	* <b>Name: createClub</b><br>
	* This method allows you to fill out the information of the sport club and create the object objClub.<br>
	* <b>Post: </b>The object objClub has been created.<br>
	*/
	public static void createClub(){
		System.out.println("Ingrese el nombre del club");
		String name= lector.nextLine();

		System.out.println("Ingrese el NIT del club");
		String nit= lector.nextLine();

		System.out.println("Ingrese la fecha de creacion del club");
		String date= lector.nextLine();

		objClub= new Club(name,nit,date);
	}

	/**
	* <b>Name: hireEmployee</b><br>
	* This method allows you to hire an employee who can be a soccer player, a main coach or and assistant.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b>The user has been created, hired and added to a team.<br>
	*/
	public static void hireEmployee(){
		System.out.println("Ingrese el nombre del nuevo empleado");
		String name= lector.nextLine();

		System.out.println("Ingrese el id del nuevo empleado");
		String id= lector.nextLine();

		System.out.println("Ingrese cuanto sera el salario del nuevo empleado");		
		double salary= lector.nextDouble();
		lector.nextLine();

		System.out.println("Ingrese a que equipo va a pertener el empleado"+
								"\n1.EquipoA"+
								"\n2.EquipoB");
		int team= lector.nextInt();
		lector.nextLine();

		System.out.println("ingrese:"+
							"\n1.Si la persona a contratar es un jugador"+
							"\n2.Si la persona a contratar es un entrenador");
		int option= lector.nextInt();
		lector.nextLine();

		switch(option){
			case 1: 

			System.out.println("Ingrese el numero de la camiseta del jugador");
			int number= lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese la cantidad de goles que ha marcado jugador");
			int goals= lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese la calificacion promedio del jugador");
			int average= lector.nextInt();
			lector.nextLine();

			System.out.println("Seleccione la posicion del jugador"+
								"\n1.Portero"+
								"\n2.Defensa"+
								"\n3.Volante"+
								"\n4.Delantero");
			int position= lector.nextInt();
			lector.nextLine();


			String message="";
			message= objClub.hireEmployee(name,id,salary,number,goals,average,position,team);
			System.out.println(message);

			break;

			case 2: 

			System.out.println("Ingrese los años de experiencia del entrenador");
			int years= lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese: "+
								"\n1.Si sera un entrenador principal"+
								"\n2.Si sera un asistente tecnico ");
			int type= lector.nextInt();
			lector.nextLine();

				switch(type){
					case 1:
					System.out.println("Ingrese la cantidad de equipos que ha tenido a cargo el nuevo entrenador");
					int teams= lector.nextInt();
					lector.nextLine();

					boolean exit=true;
					ArrayList<String>championshipsAchieved= new ArrayList<String>();

					while (exit){
						System.out.println("Ingrese el nombre de los campeonatos que ha ganado O Ingrese 0 para contratar el entrenador");
						String championships= lector.nextLine();

						if (championships.equalsIgnoreCase("0")){
							exit=false;
						}else{
							championshipsAchieved.add(championships);
						}
					}			

					
					message=objClub.hireEmployee(name,id,salary,years,teams,championshipsAchieved,team);
					System.out.println(message);
					break;

					case 2:
					boolean player;

					System.out.println("Ingrese: "+
										"\n1.Si el nuevo asistente tecnico fue jugador"+
										"\n2.Si el nuevo asistente tecnico NO fue jugador");
					int playerOrNot= lector.nextInt();
					lector.nextLine();

					if (playerOrNot==1){
						player=true;
					}else{
						player=false;
					}

					System.out.println("Ingrese la cantidad de  experticias del nuevo asistente tecnico:");
					int cantExperticias=lector.nextInt();
					lector.nextLine();

					int[] experticias= new int [cantExperticias];

					for (int i=0;i<experticias.length;i++){

						System.out.println("Ingrese la experticia del nuevo asistente tecnico:"+
											"\n1.Ofensivo"+
											"\n2.Defensivo"+
											"\n3.Posesion del balon"+
											"\n4.Jugadas de laboratorio"+
											"\n5.Entrenador de arqueros"+
											"\n6.Entrenador de defensas");
						int experticia= lector.nextInt();
						lector.nextLine();

						experticias[i]=experticia;
						
					}


					message=objClub.hireEmployee(name,id,salary,years,player,experticias,team);
					System.out.println(message);
					break;

					default:
					System.out.println("Opcion incorrecta");
					break;
				}
			break;

		}
	}

	/**
	* <b>Name:fireEmployee</b><br>
	* This method allows you to fire an employee without care if is a soccer player, a main coah or an assistant.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b>The employee has been fired and taken form his team.<br>
	*/
	public static void fireEmployee(){
		System.out.println("Ingrese el nombre del empleado que sera despedido");
		String name= lector.nextLine();

		System.out.println("Ingrese el id del empleado que sera despedido");
		String id= lector.nextLine();

		System.out.println("Ingrese a que equipo pertenecia el empleado"+
								"\n1.EquipoA"+
								"\n2.EquipoB");
		int team= lector.nextInt();
		lector.nextLine();

		String message="";
		message=objClub.fireEmployee(name,id,team);
		System.out.println(message);
	}

	/**
	* <b>Name: locatePlayers</b><br>
	* This method asks you which players of a team you want to locate in a locker room.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b> The soccer players of a team has been located in a locker room.<br>
	*/
	public static void locatePlayers(){
		System.out.println("Ingrese que equipo quiere ubicar en los vestidores"+
							"\n1.EquipoA"+
							"\n2.EquipoB"+
							"\n3.Ambos");
		int team= lector.nextInt();
		lector.nextLine();

		String message="";
		message=objClub.locatePlayers(team);
		System.out.println(message);
	}

	/**
	* <b>Name: calculatePrice</b><br>
	* This method asks you if you want to calculate the market price of a soccer player or a main coach<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b> The market price of a soccer player or of a main coach will be calculated<br>
	*/
	public static void calculatePrice(){
		String message="";
		System.out.println("Seleccione una opcion"+
							"\n1.Calcular el precio de mercado de un jugador"+
							"\n2.Calcular el precio de mercado de un entrenador principal");
		int option= lector.nextInt();
		lector.nextLine();

		System.out.println("Ingrese el id del empleado que desea calcular el precio");
		String id= lector.nextLine();

		switch(option){
			case 1:
			message=objClub.calculatePricePlayer(id);
			System.out.println(message);
			break;

			case 2: 
			message=objClub.calculatePriceCoach(id);
			System.out.println(message);
			break;
		}		
	}

	/**
	* <b>Name: calculateLevel</b><br>
	* This method asks you if you want to calculate the stars level of a soccer player or a main coach.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b>The stars level of a soccer player or of a main coach will be calculated<br>
	*/
	public static void calculateLevel(){
		String message="";
		System.out.println("Seleccione una opcion"+
							"\n1.Calcular el nivel de un jugador"+
							"\n2.Calcular el nivel de un entrenador principal");
		int option= lector.nextInt();
		lector.nextLine();

		System.out.println("Ingrese el id del empleado que desea conocer el nivel");
		String id= lector.nextLine();

		switch(option){
			case 1:
			message=objClub.calculateLevelPlayer(id);
			System.out.println(message);
			break;

			case 2: 
			message=objClub.calculateLevelCoach(id);
			System.out.println(message);
			break;
		}				
	}

	/**
	* <b>Name: addLineUps</b><br>
	* This method allows to create a line up for a team with all the necessary information.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b>The line up will be added to a team's list line ups<br>
	*/
	public static void addLineUps(){
		System.out.println("Ingrese a que equipo quiere agregar una alineacion"+
							"\n1.EquipoA"+
							"\n2.EquipoB");
		int team= lector.nextInt();
		lector.nextLine();

		System.out.println("Ingrese la fecha de la alineacion");
		String date = lector.nextLine();

		System.out.println("Ingrese la cantidad de volantes");
		int frills= lector.nextInt();
		lector.nextLine();

		System.out.println("Ingrese la cantidad de delanteros");
		int forwards= lector.nextInt();
		lector.nextLine();

		System.out.println("Ingrese la cantidad de defensas");
		int defenses= lector.nextInt();
		lector.nextLine();

		System.out.println("Ingrese que tipo de tactica se usa en esta alineacion"+
							"\n1.Posesion"+
							"\n2.Contraataque"+
							"\n3.Presion alta"+
							"\n4.Por defecto");
		int tactic= lector.nextInt();
		lector.nextLine();

		String message="";
		message=objClub.addLineUps(team,date,frills,forwards,defenses,tactic);
		System.out.println(message);
	}

	/**
	* <b>Name: seeAllLienUps</b><br>
	* This method asks you if you want to see all the line ups of a team.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b> All the line ups of a team will be shown.<br>
	*/
	public static void seeAllLineUps(){
		System.out.println("Ingrese que equipo quiere ver todas sus alineaciones"+
							"\n1.EquipoA"+
							"\n2.EquipoB");
		int team= lector.nextInt();
		lector.nextLine();

		String message="";
		message=objClub.seeAllLineUps(team);
		System.out.println(message);
	}

	/**
	* <b>Name: uploadEmployeeInformation</b><br>
	* This method asks all the new information of an employee to upload it.<br>
	* <b>Pre: </b>The objClub object must already be created. objClub!=null.<br>
	* <b>Post: </b>The new information of an employee will be uploaded.<br>
	*/
	public static void uploadEmployeeInformation(){
		String message="";

		System.out.println("Ingrese el ID del empleado que desea actualizar la informacion");
		String id= lector.nextLine();

		System.out.println("Ingrese el nuevo salario del empleado");
		double salary=lector.nextDouble();
		lector.nextLine();

		System.out.println("Ingrese el nuevo estado del empleado");
		String mood=lector.nextLine();

		System.out.println("ingrese:"+
							"\n1.Si la persona es un jugador"+
							"\n2.Si la persona es un entrenador");
		int option= lector.nextInt();
		lector.nextLine();

		switch(option){
			case 1:
			System.out.println("Ingrese el nuevo numero de camiseta del jugador");
			int number=lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese la cantidad de goles del jugador");
			int goals=lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese la nueva calificacion promedio del jugador");
			int grade=lector.nextInt();
			lector.nextLine();

			System.out.println("Seleccione la nueva posicion del jugador"+
								"\n1.Portero"+
								"\n2.Defensa"+
								"\n3.Volante"+
								"\n4.Delantero");
			int position= lector.nextInt();
			lector.nextLine();

			message=objClub.uploadEmployeeInformation(id,salary,mood,number,goals,grade,position);
			System.out.println(message);
			break;

			case 2: 

			System.out.println("Ingrese los años de experiencia del entrenador");
			int years=lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese: "+
								"\n1.Si es un entrenador principal"+
								"\n2.Si es un asistente tecnico ");
			int type= lector.nextInt();
			lector.nextLine();

				switch(type){
					case 1: 

					System.out.println("Ingrese la cantidad de equipos que ha tenido a cargo el entrenador");
					int teams= lector.nextInt();
					lector.nextLine();

					boolean exit=true;
					ArrayList<String>championshipsAchieved= new ArrayList<String>();

					while (exit){
						System.out.println("Ingrese el nombre de los campeonatos que ha ganado o ingrese 0 para actualizar la informacion del entrenador");
						String championships= lector.nextLine();

						if (championships.equalsIgnoreCase("0")){
							exit=false;
						}else{
							championshipsAchieved.add(championships);
						}
					}

					message=objClub.uploadEmployeeInformation(id,salary,mood,years,teams,championshipsAchieved);
					System.out.println(message);
					break;

					case 2:

					System.out.println("Ingrese la nueva cantidad de experticias del asistente tecnico:");
					int cantExperticias=lector.nextInt();
					lector.nextLine();

					int[] experticias= new int [cantExperticias];

					for (int i=0;i<experticias.length;i++){

						System.out.println("Ingrese la experticia del nuevo asistente tecnico:"+
											"\n1.Ofensivo"+
											"\n2.Defensivo"+
											"\n3.Posesion del balon"+
											"\n4.Jugadas de laboratorio"+
											"\n5.Entrenador de arqueros"+
											"\n6.Entrenador de defensas");
						int experticia= lector.nextInt();
						lector.nextLine();

						experticias[i]=experticia;
						
					}

					message=objClub.uploadEmployeeInformation(id,salary,mood,years,experticias);
					System.out.println(message);
					break;
				}

			break;
		}
	}




}