package stack;

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
	 * Returns whether the stack has 0 elements
	 * @return {@code true} if the stack is empty, {@code false} otherwise
	 */
	public boolean isEmpty()
	{
		return list.size() == 0;
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
	 * @throws EmptyListException if the stack is empty
	 */
	//TODO: throw a more specific exception
	public int pop()
	{
		return list.removeFirst();
	}
}
