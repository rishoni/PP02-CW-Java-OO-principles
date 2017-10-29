package hotel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CW2 {
	public static void main (String[] args){
		String Customer=null;
		int Room=0;
		String menu = null;
		String hotel[] = new String[10];
		initialise(hotel);
		do{

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
				view(hotel,Customer,Room);
				break;
			}
			case "A": {
				add(hotel,Room,Customer,sc);
				break;
			}
			case "E": {
				empty(hotel);
				break;
			}
			case "D": {
				delete(hotel,Customer,Room,sc);
				break;
			}
			case "F": {
				find(hotel,Customer,sc);
				break;
			}
			case "S": {
				save(hotel);
				break;
			}
			case "L": {
				load(hotel);
				break;
			}
			case "O": {
				sort(hotel);
	 	 		break; 
			}
			case "X": {
				System.out.println("Exit");
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Please enter a valid input");
				break;
			}
			}
		}while(menu != "X");
		
	}
	private static void initialise(String hotelRecep[]){
		for(int i = 0;i<hotelRecep.length;i++){
			hotelRecep[i] ="EMPTY";
		}
	}
	
	/**
	 * This api is assign a room to a customer
	 * @param hotelRecep
	 * @param room
	 * @param Customer
	 * @param sc
	 */
	private static void add(String hotelRecep[],int room,String Customer,Scanner sc){
		System.out.println("Enter the room number :");
		room = sc.nextInt();
		System.out.println("Enter the Customer name for room number "+room+" :");
		Customer = sc.next().toUpperCase();
		hotelRecep[room] = Customer;
		System.out.println("Cutomer "+Customer+" is added to room number "+room);
		
	}
	
	/**
	 * This api shows all the rooms with it's status(EMPTY/Occupied)
	 * @param hotelRecep
	 * @param Customer
	 * @param room
	 */
	private static void view(String hotelRecep[],String Customer,int room){
		for(int i=0;i<hotelRecep.length;i++){
			if(hotelRecep[i].equals("EMPTY") ){
				System.out.println("Room number "+i+" is EMPTY");
			}else{
				System.out.println("Room number "+i+" is occupied by "+hotelRecep[i]+" .");			
				}
		
		}
	}
	
	/**
	 * It shows the room numbers which are in empty state
	 * @param hotelRecep
	 */
	private static void empty(String hotelRecep[]){
		for(int i = 0;i<hotelRecep.length;i++){
			if(hotelRecep[i].equals("EMPTY")){
				System.out.println("Room number "+i+" is EMPTY");
			}
		}
	}
	
	/**
	 * This is to clear a room details
	 * @param hotelRecep
	 * @param Customer
	 * @param room
	 * @param sc
	 */
	private static void delete(String hotelRecep[],String Customer,int room,Scanner sc){
		System.out.println("Enter the room number to clear the room details :");
		room = sc.nextInt();
		
		if(!hotelRecep[room].equals("EMPTY")){
			hotelRecep[room] = "EMPTY";
			System.out.println("Room deatils for room number "+room+" is cleared");
		}else{
			System.out.println("Room number "+room+" is already EMPTY");
		}
	}
	
	/**
	 * It finds/shows the room details based on customer detail(s)
	 * @param hotelRecep
	 * @param Customer
	 * @param sc
	 */
	private static void find(String hotelRecep[],String Customer,Scanner sc){
		System.out.println("Enter the name of the customer to view details :");
		Customer =sc.next();
		for(int i =0;i<hotelRecep.length;i++){
			if(!hotelRecep[i].equals(Customer)){
				System.out.println("Customer "+Customer+" is in room"+i);
			}
		}
	}
	
	/**
	 * Writes all the hotel details in a txt file
	 * @param hotelRecep
	 */
	private static void save(String hotelRecep[]){
		System.out.print("Store program array data into a plain text file");
		System.out.println();
		try {
			// getting the Hotel text file
			File hotelfile = new File("Hotel.txt");
			PrintWriter printWriter = new PrintWriter(hotelfile);
			// printing the all array element text file
			for (int j = 0; j < hotelRecep.length; j++) {
				if (hotelRecep[j] != null) {
					// printing the a array element text file
					printWriter.println(hotelRecep[j]);
				} else {
					printWriter.println(hotelRecep[j]);
				}
			}
			System.out.println("Succesfully added");
			printWriter.close();
		} 
		catch (IOException e) {
			System.out.println("Check your file.");
		}
	}

	/**
	 * This api is to load hotel details from a txt file
	 * @param hotelRecep
	 */
	private static void load(String hotelRecep[]){
		System.out.print("Load program data back from the file into the array.");
		System.out.println();
		
		File hotelfile = new File("Hotel.txt");
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
	
	/**
	 * this api is to sort the customers based on their names
	 * @param hotelRecep
	 */
	 private static void sort( String hotelRecep[]){ 
	       Arrays.sort(hotelRecep); 
	  
	System.out.println("Alphabetically Ordered Customer Names : "); 
	      
	    for (String str : hotelRecep) { 
	    System.out.println(str); 
	 
	       } 
	    }
}
