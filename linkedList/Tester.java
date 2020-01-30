package linkedList;

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
				+ "\"find\" to find a student in the list, \"remove\" to remove a student from the list, "
				+ "\"test\" to run the automated tests, or \"exit\" to exit");
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
			case "remove":
				tester.removeFromList();
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
						+ "\"find\" to find a student in the list, \"remove\" to remove a student from the list, "
						+ "\"test\" to run the automated tests, or \"exit\" to exit");
				break;
			}
		}
	}
	
	/**
	 * Prompts the user to input an integer until a valid int is provided
	 * @return
	 */
	private int promptForInt()
	{
		int value;
		while(true)
		{
			if(scanner.hasNextInt())
			{
				value = scanner.nextInt();
				scanner.nextLine(); //nextInt does not consume the newline chars added by pressing enter
				break;
			}
			else 
			{
				System.out.println("Please input an integer mark");
				scanner.nextLine(); 
				//If the first input is not an int then hasNextInt won't advance past it and this loop will become infinite, 
				//unless we remove it.
			}
		}
		return value;
	}
	
	/**
	 * Prompts the user for a valid value and adds it to the list
	 */
	private void addToList()
	{
		System.out.println("Input the value to add");
		list.addToList(promptForInt());
	}

	/**
	 * Prints the list as it is currently
	 */
	private void printList()
	{
		list.print();
	}
	
	/**
	 * Prompts the user for a value, then attempts to find a node storing that value in the list and
	 * prints the result
	 */
	private void findInList()
	{
		System.out.println("Input the value to find");
		list.find(promptForInt());
	}
	
	/**
	 * Prompts the user for a value, then attempts to find a node storing that value in the list and
	 * remove it. Finally, prints a success or failure message
	 */
	private void removeFromList()
	{
		System.out.println("Input the value to remove");
		list.remove(promptForInt());
	}
	
	
	/**
	 * Sets up for testing - initialise fields and prepare them to be used
	 */
	private void initialise()
	{
		list = new List();
	}
	
	/**
	 * Performs the automated testing process
	 */
	private void process()
	{
		autoTestAdd();
		System.out.println();
		System.out.println();
		
		autoTestFind();
		System.out.println();
		System.out.println();
		
		autoTestRemove();
	}

	/**
	 * Automatically tests adding elements to the list
	 */
	private void autoTestAdd()
	{
		List list = new List();
		
		System.out.println("AddToList, print:");
		list.print();
		System.out.println();
		
		list.addToList(10);
		list.print();
		System.out.println();
		
		list.addToList(20);
		list.addToList(-97);
		list.print();
	}
	
	/**
	 * Automatically tests finding elements in the list
	 */
	private void autoTestFind()
	{
		List list = new List();	
		
		System.out.println("find:");
		
		list.addToList(10);
		list.addToList(20);
		list.addToList(30);
		
		System.out.println("--Initial list:");
		list.print();
		System.out.println();
		
		System.out.println("find");
		System.out.println("--Normal list:");
		System.out.println("----Middle:");
		list.find(20);
		
		System.out.println("----Beginning:");
		list.find(30);
		
		System.out.println("----End:");
		list.find(10);
		
		System.out.println("--Absent:");
		list.find(9991234);

		System.out.println();
		
		System.out.println("--Empty list");
		List emptyList = new List();
		emptyList.find(0);
	}

	/**
	 * Automatically tests removing elements from the list
	 */
	private void autoTestRemove()
	{
		List list = new List();
		
		System.out.println("remove:");
		
		list.addToList(10);
		list.addToList(20);
		list.addToList(30);
		
		System.out.println("--Initial list:");
		list.print();
		System.out.println();
		
		System.out.println("--Normal list:");
		System.out.println("----Middle:");
		list.remove(20);
		list.print();
		System.out.println();
		
		System.out.println("----Beginning:");
		list.remove(30);
		list.print();
		System.out.println();
		
		System.out.println("----End:");
		list.remove(10);
		list.print();
		System.out.println();
		
		System.out.println("--Absent:");
		list.remove(17312377);
		list.print();
		System.out.println();
		
		System.out.println();
		
		System.out.println("--Empty list");
		List emptyList = new List();
		emptyList.remove(1341341);
	}
}