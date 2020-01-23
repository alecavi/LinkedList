/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * An automated testing class for the linked list.
 * 
 * @author acavicchioli
 * @version 1.0
 */
public class Tester
{
	private List list;
	private static final Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args)
	{
		Tester tester = new Tester();
		tester.initialise();
		
		System.out.println("Input \"add\" to add a student to the list, \"print\" to print the list, "
				+ "\"find\" to find a student in the list, \"test\" to run the automated tests, or "
				+ "\"exit\" to exit");
		boolean exit = false;
		while(!exit)
		{
			System.out.println("Input a command");
			String input = scanner.nextLine();
			switch(input.toLowerCase())
			{
			case "add":
				tester.addToList();
				break;
			case "print":
				tester.printList();
				break;
			case "find":
				tester.findInList();
				break;
			case "test":
				tester.process();
				break;
			case "exit":
				exit = true;
				break;
			default:
				System.out.println("Command not recognised");
				System.out.println("Input \"add\" to add a student to the list, \"print\" to print the list, "
						+ "\"find\" to find a student in the list, \"test\" to run the automated tests, or "
						+ "\"exit\" to exit");
				break;
			}
		}
	}
	
	/**
	 * Prompts the user for a valid ID and mark, and adds them to the list
	 */
	private void addToList()
	{
		System.out.println("Input the ID of the student to add");
		String id = scanner.nextLine();
		System.out.println("Input the mark of the student to add");
		int mark;
		while(true)
		{
			if(scanner.hasNextInt())
			{
				mark = scanner.nextInt();
				scanner.nextLine(); //nextInt does not consume the newline chars added by pressing enter
				break;
			}
			else 
			{
				System.out.println("Please input an integer mark");
			}
			
			scanner.nextLine(); 
			//If the first input is not an int then hasNextInt won't advance past it and this loop will become infinite, 
			//unless we remove the line.		
		}
		list.addToList(id, mark);
	}

	/**
	 * Prints the list as it is currently
	 */
	private void printList()
	{
		list.print();
	}
	
	/**
	 * Prompts the user for an ID, then attempts to find the corresponding student in the list and
	 * prints the result
	 */
	private void findInList()
	{
		System.out.println("Input the ID of the student to add");
		String id = scanner.nextLine();
		list.findByID(id);
	}
	
	/**
	 * Set up for testing - initialise fields and prepare them to be used
	 */
	private void initialise()
	{
		list = new List();
	}
	
	/**
	 * Perform the automated testing process
	 */
	private void process()
	{
		List list = new List();
		
		System.out.println("AddToList, print:");
		list.print();
		System.out.println();
		
		list.addToList("a", 10);
		list.print();
		System.out.println();
		
		list.addToList("b", 20);
		list.addToList("c", -97);
		try
		{
			list.addToList(null, 900);
			System.out.println("Flow control should never reach this line");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("null IDs are not allowed");
		}
		list.print();
		System.out.println();
		System.out.println();
		
		System.out.println("findByID");
		System.out.println("--Normal list:");
		System.out.println("----Middle:");
		list.findByID("b");
		
		System.out.println("----Beginning:");
		list.findByID("c");
		
		System.out.println("----End:");
		list.findByID("a");
		
		System.out.println("--Absent:");
		list.findByID("dbnauibdiu");
		
		System.out.println("--Null ID:");
		list.findByID(null);
		System.out.println();
		
		System.out.println("--Empty list");
		List emptyList = new List();
		emptyList.findByID("This list is empty. Any ID will do");
	}
}