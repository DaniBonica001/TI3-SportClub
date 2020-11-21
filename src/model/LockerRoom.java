package model;
public class LockerRoom{
	//Constants
	public final static int ROWS=7;
	public final static int COLUMNS=6;
	//Atributes
	private char name;
	private int capacity;
	//Relations
	private Player[][]players;
	//Methods
	public LockerRoom(){
		players= new Player[ROWS][COLUMNS];
	}
}