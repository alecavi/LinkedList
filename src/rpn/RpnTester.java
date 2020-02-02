package rpn;

/**
 * An automated testing class for the RPN calculator
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class RpnTester
{
	RpnCalculator calculator = new RpnCalculator();
	
	/**
	 * Performs the automated testing process
	 */
	public void process()
	{
		testCalculate();
		System.out.println();
		System.out.println();
		
		testValidate();
		System.out.println();
		System.out.println();
		
		testInfixEquivalent();
		System.out.println();
		System.out.println();
		
		testTokenSeparator();
		System.out.println();
		System.out.println();
		
	}
	
	/**
	 * Automatically tests calculating RPN expressions
	 */
	private void testCalculate()
	{
		System.out.println("calculate:");
		System.out.println();
		
		System.out.println("1 2 + 3 *");
		System.out.println(calculator.calculate("1 2 + 3 *"));
		System.out.println();
		
		System.out.println("4 2 / 3 +");
		System.out.println(calculator.calculate("4 2 / 3 +"));
		System.out.println();
		
		System.out.println("4 3 / 3 +");
		System.out.println(calculator.calculate("4 3 / 3 +"));
		System.out.println();
		
		System.out.println("4 2 1 +");
		try
		{
			System.out.println(calculator.calculate("4 2 1 +"));
			System.out.println("This line should never be executed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		System.out.println("4 +");
		try
		{
			System.out.println(calculator.calculate("4 +"));
			System.out.println("This line should never be executed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		System.out.println("4 2 x");
		try
		{
			System.out.println(calculator.calculate("4 2 x"));
			System.out.println("This line should never be executed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	/**
	 * Automatically tests validating RPN expressions
	 */
	private void testValidate()
	{
		System.out.println("Validate:");
		System.out.println();
		
		System.out.println("1 2 + 3 *");
		System.out.println(calculator.validate("1 2 + 3 *")? "Valid" : "Not valid");
		System.out.println();
		
		System.out.println("4 2 / 3 +");
		System.out.println(calculator.validate("4 2 / 3 +")? "Valid" : "Not valid");
		System.out.println();
		
		System.out.println("4 2 1 +");
		System.out.println(calculator.validate("4 2 1 +")? "Valid" : "Not valid");
		System.out.println();
		
		System.out.println("4 +");
		System.out.println(calculator.validate("4 +")? "Valid" : "Not valid");
		System.out.println();
		
		System.out.println("4 2 x");
		System.out.println(calculator.validate("4 2 x")? "Valid" : "Not valid");
		System.out.println();
	}
	
	/**
	 * Automatically tests converting RPN expressions to an infix equivalent
	 */
	private void testInfixEquivalent()
	{
		System.out.println("infixEquivalent:");
		System.out.println();
		
		System.out.println("1 2 + 3 *");
		System.out.println(calculator.infixEquivalent("1 2 + 3 *"));
		System.out.println();
		
		System.out.println("4 2 / 3 +");
		System.out.println(calculator.infixEquivalent("4 2 / 3 +"));
		System.out.println();
		
		System.out.println("4 2 1 +");
		try
		{
			System.out.println(calculator.infixEquivalent("4 2 1 +"));
			System.out.println("This line should never be executed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		System.out.println("4 +");
		try
		{
			System.out.println(calculator.infixEquivalent("4 +"));
			System.out.println("This line should never be executed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		System.out.println("4 2 x");
		try
		{
			System.out.println(calculator.infixEquivalent("4 2 x"));
			System.out.println("This line should never be executed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	/**
	 * Automatically tests getting and setting the token separator
	 */
	private void testTokenSeparator()
	{
		System.out.println("getTokenSeparator, setTokenSeparator:");
		System.out.println();
		
		System.out.println("Token separator: \"" + calculator.getTokenSeparator() + "\"");
		
		calculator.setTokenSeparator(",");
		System.out.println("Token separator: \"" + calculator.getTokenSeparator() + "\"");
		
		System.out.println("1,2,+");
		System.out.println(calculator.calculate("1,2,+"));
		System.out.println();
		
		System.out.println("1,2,+");
		System.out.println(calculator.validate("1,2,+")? "Valid" : "Not valid");
		System.out.println();
		
		System.out.println("1,2,+");
		System.out.println(calculator.infixEquivalent("1,2,+"));
		System.out.println();
	}
}















