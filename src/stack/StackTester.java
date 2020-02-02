package stack;

public class StackTester
{
	public void process()
	{
		testEmpty();
		System.out.println();
		System.out.println();
		
		testSize();
		System.out.println();
		System.out.println();
		
		testPop();
		System.out.println();
		System.out.println();
		
		testPush();
	}
	
	private void testEmpty()
	{
		Stack stack = new Stack();
		System.out.println("isEmpty:");
		
		System.out.println("--Empty stack");
		System.out.println(stack.isEmpty() ? "Empty" : "Not empty");
		
		stack.push(10);
		System.out.println("--Non-empty stack");
		System.out.println(stack.isEmpty() ? "Empty" : "Not empty");
	}
	
	private void testSize()
	{
		Stack stack = new Stack();
		System.out.println("size:");
		
		System.out.println("--Empty stack");
		System.out.println(stack.size());
		
		stack.push(10);
		stack.push(10);
		stack.push(10);
		System.out.println("--After adding three elements");
		System.out.println(stack.size());
		
		stack.pop();
		System.out.println("--After removing one element");
		System.out.println(stack.size());
	}
	
	private void testPop()
	{
		Stack stack = new Stack();
		System.out.println("pop:");
		
		System.out.println("--Empty stack");
		try
		{
			stack.pop();
			System.out.println("This line should never be executed");
		}
		catch(EmptyStackException e)
		{
			System.out.println("EmptyStackException: attempt to pop from empty stack");
		}
		
		System.out.println("--Non-empty stack");
		stack.push(10);
		System.out.println(stack.pop());
	}
	
	private void testPush()
	{
		Stack stack = new Stack();
		System.out.println("push:");
		
		System.out.println("--Empty stack");
		stack.push(10);
		
		System.out.println("Pushed:" + stack.pop());
		
		stack.push(20); //the 10 was removed to be printed
		System.out.println("--Non-empty stack");
		stack.push(30);
		System.out.println("Pushed:" + stack.pop());
	}
}