package rpn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

import stack.EmptyStackException;
import stack.Stack;

/**
 * A calculator capable of solving reverse polish notation expression
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class RpnCalculator 
{
	private Stack stack = new Stack();
	private String tokenSeparator = " ";
	private final String operators = "+-*/";
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		RpnCalculator calculator = new RpnCalculator();
		System.out.println("Input an RPN expression");
		String expression = scanner.nextLine();
		
		System.out.println(calculator.infixEquivalent(expression));
		
		/*
		if(!calculator.validate(expression))
		{
			System.out.println("Invalid expression");
			scanner.close();
			return;
		}
		*/
		
		//System.out.println("Result = " +  calculator.calculate(expression));
		
		scanner.close();
	}
	
	
	
	/**
	 * Calculates the result of the passed RPN expression.
	 * 
	 * @param expression the expression to calculate
	 * @return the result of the calculations
	 * @throws IllegalArgumentException if the expression is not a valid RPN expression
	 */
	public int calculate(String expression)
	{
		String[] tokens = expression.split(tokenSeparator);
		for(String token : tokens)
		{
			if(operators.contains(token))
			{
				try
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
					case "/":
						divide();
						break;
					default:
					}
				}
				catch(EmptyStackException e)
				{
					stack.clear();
					throw new IllegalArgumentException("Invalid RPN expression: not enough operands", e);
				}
			}
			else if(isNumber(token))
			{
				int number = Integer.parseInt(token);
				stack.push(number);
			}
			else
			{
				stack.clear();
				throw new IllegalArgumentException("Invalid RPN expression: illegal token");
			}
		}
		int result = stack.pop();
		if(!stack.isEmpty())
			throw new IllegalArgumentException("Invalid RPN expression: too many operands");
		else return result;
	}
	
	/**
	 * Validates the RPN expression passed as the argument, assuming all operators are binary
	 * @param tokens the RPN expression to validate
	 * @return {@code true} if the expression is valid, {@code false} otherwise
	 */
	public boolean validate(String expression)
	{
		int stackDepth = 0;
		String[] tokens = expression.split(tokenSeparator);
		for(String token : tokens)
		{
			if(operators.contains(token))
			{
				if(stackDepth >= 2)
				{
					stackDepth--; //-2 for the operands, +1 for the result
				}
				else return false; //The current operator would not have enough operands
			}
			else if(isNumber(token))
			{
				stackDepth++;
			}
			else
			{
				return false; //Illegal token
			}
		}
		return stackDepth == 1; //Correct amount of operands for every operator (i.e. not too many)
	}

	/**
	 * Converts the passed postfix expression (RPN) in an equivalent infix expression
	 * @param postfixExpression the expression to convert
	 * @return an equivalent infix expression
	 * @throws IllegalArgumentException if the specified string is not a valid RPN expression 
	 */
	public String infixEquivalent(String postfixExpression)
	{
		String[] tokens = postfixExpression.split(tokenSeparator);
		Deque<String> infixStack = new ArrayDeque<String>();
		
		for(String token : tokens)
		{
			if(operators.contains(token))
			{
				try
				{
					String op2 = infixStack.pop();
					String op1 = infixStack.pop();
					infixStack.push("(" + op1 + token + op2 + ")");
				}
				catch(NoSuchElementException e)
				{
					throw new IllegalArgumentException("Invalid RPN expression: not enough operands", e);
				}
			}
			else if(isNumber(token))
			{
				infixStack.push(token);
			}
			else
			{
				throw new IllegalArgumentException("Invalid RPN expression: illegal token");
			}
		}
		String infixExpression = infixStack.pop();
		if(!infixStack.isEmpty())
		{
			throw new IllegalArgumentException("Invalid RPN expression: too many operands");
		}
		else return infixExpression;
		
	}

	/**
	 * Pops the top two numbers from the stack and adds them
	 * @throws EmptyStackException if the stack does not have two elements
	 */
	private void add()
	{
		int addend1 = stack.pop();
		int addend2 = stack.pop();
		stack.push(addend1 + addend2);
	}
	
	/**
	 * Pops the top two numbers from the stack and subtracts the second from the first - 
	 * that is, if the stack contains elements {@code A, B} where A was pushed before B,
	 * the result will be {@code A - B}. After doing so, pushes the result
	 * @throws EmptyStackException if the stack does not have two elements
	 */
	private void subtract()
	{
		int subtrahend = stack.pop();
		int minuend = stack.pop();
		stack.push(minuend - subtrahend);
	}
	
	/**
	 * Pops the top two numbers from the stack and multiplies them
	 * @throws EmptyStackException if the stack does not have two elements
	 */
	private void multiply()
	{
		int factor1 = stack.pop();
		int factor2 = stack.pop();
		stack.push(factor1 * factor2);
	}
	
	/**
	 * Pops the top two numbers from the stack and divides the second by the first - 
	 * that is, if the stack contains elements {@code A, B} where A was pushed before B,
	 * the result will be {@code A / B}. After doing so, rounds the result and pushes it
	 * @throws EmptyStackException if the stack does not have two elements
	 */
	private void divide()
	{
		int divisor = stack.pop();
		int dividend = stack.pop();
		stack.push(Math.round((float) dividend / divisor));
	}
	
	/**
	 * Checks if the argument can be converted to a number.
	 * @param str the string to check
	 * @return {@code true} if the argument is numeric, {@code false} otherwise
	 */
	private boolean isNumber(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}