package rpn;

import java.util.Scanner;

import linkedList.EmptyListException;
import stack.Stack;

public class RpnCalculator 
{
	private Stack stack = new Stack();
	private String tokenSeparator = " ";
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		RpnCalculator calculator = new RpnCalculator();
		System.out.println("Input an RPN expression");
		String expression = scanner.nextLine();
		
		System.out.println("Result = " +  calculator.calculate(expression));
	}
	
	
	
	/**
	 * Calculates the result of the passed RPN expression.
	 * 
	 * @param expression the expression to calculate
	 * @return the result of the calculations
	 * @throws IllegalArgumentException if the expression is not a valid RPN expression
	 */
	//TODO: flush stack on exception
	public int calculate(String expression)
	{
		String[] tokens = expression.split(tokenSeparator);
		for(String token : tokens)
		{
			switch(token)
			{
			case "+":
				add();
				break;
			case "-":
				subtract();
				break;
			case "*":
				multiply();
				break;
			default:
				try //This way, the exception is always as specific as possible
				{
					int number = Integer.parseInt(token);
					stack.push(number);
				}
				catch(NumberFormatException e)
				{
					throw new IllegalArgumentException("Invalid RPN string", e);
				}
				break;
			}
		}
		return stack.pop();
	}
	
	/**
	 * Pops the top two numbers from the stack and adds them
	 * @throws EmptyListException if the stack does not have two elements
	 */
	private void add()
	{
		int v1 = stack.pop();
		int v2 = stack.pop();
		stack.push(v1 + v2);
	}
	
	/**
	 * Pops the top two numbers from the stack and subtracts the second from the first - 
	 * that is, if the stack contains elements {@code A, B} where A was pushed before B,
	 * the result will be {@code A - B}. After doing so, pushes the result
	 * @throws EmptyListException if the stack does not have two elements
	 */
	private void subtract()
	{
		int v1 = stack.pop();
		int v2 = stack.pop();
		stack.push(v2 - v1);
	}
	
	/**
	 * Pops the top two numbers from the stack and multiplies them
	 * @throws EmptyListException if the stack does not have two elements
	 */
	private void multiply()
	{
		int v1 = stack.pop();
		int v2 = stack.pop();
		stack.push(v1 * v2);
	}
}
