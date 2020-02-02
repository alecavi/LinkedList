package main;

import linkedList.ListTester;
import rpn.RpnTester;
import stack.StackTester;

/**
 * A user-facing menu to test all classes in this project
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class Tester
{
	private ListTester listTester = new ListTester();
	private StackTester stackTester = new StackTester();
	private RpnTester rpnTester = new RpnTester();
	
	/**
	 * main menu for the tester
	 */
	public void menu()
	{
		printInstructions();
		while(true)
		{
			System.out.println("Input a command");
			String input = Main.scanner.nextLine();		
			switch(input.toLowerCase())
			{
			case "list":
				listTester.process();
				break;
			case "stack":
				stackTester.process();
				break;
			case "rpn":
				rpnTester.process();
				break;
			case "back":
				return;
			default:
				System.out.println("Invalid input");
				printInstructions();
				break;
			}
		}
	}
	
	/**
	 * Prints the instruction to use the tester
	 */
	private void printInstructions()
	{
		System.out.println("Input \"list\" to run the automated tests for the list class."
				+ " Input \"stack\" to run the automated tests for the stack class."
				+ " Input \"rpn\" to run the automated tests for the rpn calculator class"
				+ " Input \"back\" to return to the main menu");
	}
}

































