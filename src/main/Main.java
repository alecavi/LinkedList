package main;

import java.util.Scanner;

import rpn.RpnCalculator;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		RpnCalculator calculator = new RpnCalculator();
		
		System.out.println("Input a postfix expression");
		String expression = scanner.nextLine();
		
		if(calculator.validate(expression))
		{
			int result = calculator.calculate(expression);
			String infix = calculator.infixEquivalent(expression);
			
			System.out.println("result = " + result);
			System.out.println("Equivalent infix expression = " + infix);
			
		}
		else
		{
			System.out.println("Invalid expression");
		}
		scanner.close();
	}
}
