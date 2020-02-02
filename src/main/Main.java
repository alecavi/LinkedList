package main;

import java.util.Scanner;

import rpn.RpnCalculator;

public class Main 
{
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Tester tester = new Tester();
		Main main = new Main();
		
		main.printInstructions();
		boolean exit = false;
		while(!exit)
		{
			String input = scanner.nextLine();
			switch(input.toLowerCase())
			{
			case "test":
				tester.menu();
				main.printInstructions();
				break;
			case "help":
				main.printInstructions();
				break;
			case "exit":
				exit = true;
				break;
			default:
				main.solvePostfix(input);
				break;	
			}
		}
		scanner.close();
	}
	
	/**
	 * Prints the instructions to use the main menu.
	 */
	private void printInstructions()
	{
		System.out.println("Input a postfix expression to see the solution and an equivalent"
				+ " infix expression, \"test\" to enter testing mode, \"help\" to see this message,"
				+ " or \"exit\" to exit");
	}
	
	/**
	 * Solves the expression passed as argument and prints the result and an equivalent infix
	 * expression, or an error message if the expression is invalid
	 * @param expression
	 */
	private void solvePostfix(String expression)
	{
		RpnCalculator calculator = new RpnCalculator();
		
		if(calculator.validate(expression))
		{
			System.out.println("Result = " + calculator.calculate(expression));
			System.out.println("Equivalent infix expression = " + calculator.infixEquivalent(expression));
		}
		else
		{
			System.out.println("Invalid expression");
		}
	}
}




















