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

				case 0: System.out.println("¡Bye!");
				menu=false;
				break;

				default: System.out.println("Opcion incorrecta");
				break;

			}
		}		
	}

	public static void createClub(){
		System.out.println("Ingrese el nombre del club");
		String name= lector.nextLine();

		System.out.println("Ingrese el NIT del club");
		String nit= lector.nextLine();

		System.out.println("Ingrese la fecha de creacion del club");
		String date= lector.nextLine();

		objClub= new Club(name,nit,date);
	}

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




}