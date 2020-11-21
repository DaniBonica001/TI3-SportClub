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

				case 4: System.out.println(objClub.seeTeamsInfo());
				break;

				case 5: System.out.println(objClub.completeInformation());
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

			System.out.println("Ingrese la posicion del jugador");
			String position= lector.nextLine();

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

					System.out.println("Ingrese la cantidad de campeonatos que ha logrado");
					int championships= lector.nextInt();
					lector.nextLine();

					
					message=objClub.hireEmployee(name,id,salary,years,teams,championships,team);
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

					System.out.println("Ingrese la experticia del nuevo asistente tecnico:"+
										"\n1.Ofensivo"+
										"\n2.Defensivo"+
										"\n3.Posesion del balon"+
										"\n4.Jugadas de laboratorio");
					int experticia= lector.nextInt();
					lector.nextLine();

					message=objClub.hireEmployee(name,id,salary,years,player,experticia,team);
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

		String message="";
		message=objClub.fireEmployee(name,id);
		System.out.println(message);
	}




}