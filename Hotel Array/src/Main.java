
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import java.util.Scanner;

import java.util.*;
public class Main {
	
	static Room[] room = new Room[10];//creating the room array object
	
	public static void main(String[] args){
		
		
		String Customer = null ;
		String menu = null;
		int roomNo = 0;
		
		initialise();
		
		do {

			System.out.println("\n");
			System.out.println("  Welcome to Hotel JetWing ");
			System.out.println("      Hotel Booking Menu  ");
			System.out.println("=====================================");
			System.out.println("\n");
			System.out.println("A. Add a customer to room");
			System.out.println("V. View all rooms");
			System.out.println("D. Delete customer from room");
			System.out.println("S. Store program array data into a plain text file");
            System.out.println("E: To Display empty rooms");
			System.out.println("L. Load program data back from the file into the array");
			System.out.println("F. Find room from customer name");
            System.out.println("O. Press O to View alphabetically ordered Customer names");
			System.out.println("X. Press X to Exit");
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter your Selection: ");
			
			menu = sc.nextLine().toUpperCase();
			System.out.println();
			
			switch (menu) {
			case ("V"): {
				view(roomNo);
				break;
			}
			case "A": {
				addCustomer(room,roomNo,sc,Customer);
				break;
			}
			case "E": {
				empty(room,Customer,roomNo);
				break;
			}
			case "D": {
				delete(room,roomNo,sc);
				break;
			}
			case "F": {
				find(room,sc,Customer);
				break;
			}
			case "S": {
				save(room);
				break;
			}
			case "L": {
				load(room);
				break;
			}
			case "O": {
				
				for(int x=0; x<10;x++){
					Arrays.sort(room,NewComparator);
					if(!(room[x].getCustomer().equals("EMPTY")))
					{
						System.out.println(room[x].getCustomer());
					}
				}
	 	 		break; 
			}
			case "X": {
				System.out.println("Exit");
				System.exit(0);
				break;
			}
			default: {
				break;
			}
			}
		}while(menu !="X");
			
	}
	
	private static void initialise(){        
		 for (int i = 0; i < room.length; i++) {
				room[i] = new Room();
				room[i].setCustomer("EMPTY");
				room[i].setRoom(i);
			}   
	    }
	
	private static void addCustomer(Room roomRecep[], int roomNo, Scanner sc, String Customer){
		System.out.println("Enter a Room Number between 0 - 9 :");
		 roomNo = sc.nextInt();
		 if(roomNo <10 && roomNo >= 0){
		 System.out.println("Enter the Name for room Number "+roomNo+" :");
		 Customer = sc.next().toUpperCase();

		if (roomRecep[roomNo].getCustomer().equals("EMPTY") && Customer.matches("[a-zA-Z_]+")) {
			roomRecep[roomNo].setCustomer(Customer);
					
			System.out.println("Added Customer " + Customer + " to room number " + roomNo);
					
		}else{
			System.out.println("Invalid Name. Please enter a valid name.");
		}
		 }else{
			 System.out.println("Invalid Room Number. Enter a valid Room Number between 0 to 9");
		 }
	}
	
	public static void view(int roomNo){
		for(int i=0; i< room.length;i++){
			if(room[i].getCustomer().equals("EMPTY")){
				System.out.println("Room number " + room[i].getRoom() + " is available.");
			}else{
				System.out.println("Room number " + room[i].getRoom() + " is ordered by " + room[i].getCustomer() + ".");
			}
		}
	}
	
	public static void delete(Room roomRecep[], int roomNo,Scanner sc){
		System.out.println("Enter the room number to delete customer :");
		roomNo = sc.nextInt();
		for(int i=0; i<roomRecep.length;i++){
			if(roomRecep[i].getRoom() == roomNo){
			roomRecep[roomNo].setCustomer("EMPTY");
			System.out.println("Room number "+roomNo+ " customer deleted.");
			}
		}
	}
		
	public static void empty(Room roomRecep[],String Customer,int roomNo){
		for(int i=0;i<roomRecep.length;i++){
			if(roomRecep[i].getCustomer().equals("EMPTY")){
				System.out.println("Room number "+roomRecep[i].getRoom()+" is empty");
			}
		}
	}
	
	public static void find(Room roomRecep[],Scanner sc,String Customer){
		System.out.println("Enter the name of the Customer :");
		Customer = sc.next();
		for(int i=0;i<roomRecep.length;i++){
			if(roomRecep[i].getCustomer().equals(Customer)){
				System.out.println("Customer "+Customer+" room is "+roomRecep[i].getRoom());
			}
			
		}
	}
	public static void save(Room roomRecep[]){
		System.out.print("Store program array data into a plain text file");
		System.out.println();
		try {
			// getting the Hotel text file
			File hotelfile = new File("HotelSystem.txt");
			PrintWriter printWriter = new PrintWriter(hotelfile);
			// printing the all array element text file
			for (int j = 0; j < roomRecep.length; j++) {
				if (roomRecep[j].getCustomer() != null) {
					// printing the a array element text file
					printWriter.println(roomRecep[j].getCustomer());
				} else {
					printWriter.println(roomRecep[j].getCustomer());
				}
			}
			System.out.println("Succesfully added");
			printWriter.close();
		} 
		catch (IOException e) {
			System.out.println("Check your file.");
		}
	}
	
	public static void load(Room roomRecep[]){
		System.out.print("Load program data back from the file into the array.");
		System.out.println();
		
		File hotelfile = new File("HotelSystem.txt");
		BufferedReader br = null;
		FileReader fr = null;
		
		try{
			fr = new FileReader(hotelfile);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(hotelfile));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		}catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
			
		}
		System.out.println();
		System.out.println("Load successful");

	}
	
	public static Comparator<Room> NewComparator = new Comparator<Room>() {
		public int compare(Room obj1, Room obj2){
			
			return obj1.getCustomer().compareTo(obj2.getCustomer());
			}
		};
		

}