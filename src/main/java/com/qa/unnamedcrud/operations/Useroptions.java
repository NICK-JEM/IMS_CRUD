package com.qa.unnamedcrud.operations;

import java.util.Scanner;

import com.qa.unnamedcrud.Equipment;



public class Useroptions {
	//instantiates new scanner for user input
	private static Scanner scan = new Scanner(System.in);
	
	//instatiates new equipment object for storing in db
	Equipment equip = new Equipment();
	
	//method to get user input in terminal
	public String getInput() {
		System.out.println("Enter CRUD choice: (store or read for now)");
		return scan.nextLine();
	}
	
	public void choices() {
		
		//new instance of CRUDoperations to open connection
		CRUDoperations op = new CRUDoperations();
		
		//ask for user to choose CRUD operation
		String crud = getInput();
		
		//try-finally block to close connection
		try {
			
			do {
				switch (crud.toLowerCase()) {
				case "store":
					System.out.println("Enter item name: (max 100 characters) ");
					String itName = scan.nextLine();
					equip.setItem_name(itName);
					
					System.out.println("Enter brief item description: (max 200 characters) ");
					String itDesc = scan.nextLine();
					equip.setItem_desc(itDesc);
					
					System.out.println("Enter associated department: (supplies if more than one) ");
					String itDept = scan.nextLine();
					equip.setDept(itDept);
					
					System.out.println("Enter quantity to be stored: ");
					int itQuant = scan.nextInt();
					equip.setQuantity(itQuant);
					scan.nextLine();
					
					System.out.println("Enter your name: ");
					String itByWhom = scan.nextLine();
					equip.setStored_by(itByWhom);
					
					System.out.println("Enter date: (YYYY-MM-DD) ");
					String itDate = scan.nextLine();
					equip.setDate(itDate);
					
					op.create(new Equipment(itName, itDesc, itDept, itQuant, itByWhom, itDate ));
					
					break;
					
				case "read":
					op.read();
					break;
					
					default:
						System.out.println("Invalid option");
				}
				
				System.out.println("Would you like to continue? (y/n)");
				String quit = scan.nextLine();
				if(quit.toLowerCase().equals("y")) {
					crud = getInput();
				} else if(quit.toLowerCase().equals("n")) {
					crud = "quit";
				} else {
					System.out.println("Please enter 'y' or 'n'");
				}
				
			} while(!crud.equals("quit"));
			System.out.println("Goodbye");
			
		} finally {
			
			op.closeConn();
			
		}
		
	}

}
