package stack;

import linkedList.EmptyListException;
import linkedList.List;

/**
 * A stack data structure, backed by a linked list capable of storing id-mark pairs
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class Stack
{
	private List list;
	
	public Stack()
	{
		this.list = new List();
	}
	
	/**
	 * Pushes the specified value on the stack
	 * @param value the value to push
	 */
	public void push(int value)
	{
		list.addToList(value);
	}
	
	/**
	 * Pops the top value from the stack
	 * @return the value that was removed from the top of the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public int pop()
	{
		try
		{
			return list.removeFirst();
		}
		catch(EmptyListException e)
		{
			throw new EmptyStackException("Stack is empty", e);
		}
	}
	
	/**
	 * Clears the stack, deleting all elements
	 */
	public void clear()
	{
		list.clear();
	}

	/**
	 * Returns whether the stack is empty - i.e. whether it has 0 elements
	 * @return {@code true} if the stack is empty, {@code false} otherwise
	 */
	public boolean isEmpty()
	{
		return list.size() == 0;
	}
	
	/**
	 * Returns the size of the stack
	 * @return the size of the stack
	 */
	public int size()
	{
		return list.size();
	}
}