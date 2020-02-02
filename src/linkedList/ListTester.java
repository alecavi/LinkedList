package linkedList;

import linkedList.EmptyListException;
import linkedList.List;

/**
 * An automated testing class for the linked list.
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class ListTester
{	
	/**
	 * Performs the automated testing process
	 */
	public void process()
	{
		testSize();
		System.out.println();
		System.out.println();
		
		testAdd();
		System.out.println();
		System.out.println();
		
		testFind();
		System.out.println();
		System.out.println();
		
		testDelete();
		System.out.println();
		System.out.println();
		
		testRemoveFirst();
		System.out.println();
		System.out.println();
	}

	/**
	 * Automatically tests whether the size of the list is correctly updated as elements are added and removed
	 */
	private void testSize()
	{
		System.out.println("size:");
		List list = new List();
		System.out.println("Empty list: " + list.size());
		
		list.addToList(10);
		list.addToList(20);
		list.addToList(90);
		
		System.out.println("after adding 3 elements: " + list.size());
		
		list.delete(10);
		System.out.println("after removing 1 element: " + list.size());
		
		list.delete(0);
		System.out.println("after removing 1 nonexistent element: " + list.size());
		
	}
	
	/**
	 * Automatically tests adding elements to the list
	 */
	private void testAdd()
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
	private void testFind()
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
	 * Automatically tests deleting elements from the list
	 */
	private void testDelete()
	{
		List list = new List();
		
		System.out.println("delete:");
		
		list.addToList(10);
		list.addToList(20);
		list.addToList(30);
		
		System.out.println("--Initial list:");
		list.print();
		System.out.println();
		
		System.out.println("--Normal list:");
		System.out.println("----Middle:");
		list.delete(20);
		list.print();
		System.out.println();
		
		System.out.println("----Beginning:");
		list.delete(30);
		list.print();
		System.out.println();
		
		System.out.println("----End:");
		list.delete(10);
		list.print();
		System.out.println();
		
		System.out.println("--Absent:");
		list.delete(17312377);
		list.print();
		System.out.println();
		
		System.out.println();
		
		System.out.println("--Empty list");
		List emptyList = new List();
		emptyList.delete(1341341);
	}
	
	/**
	 * Automatically tests removing the first element from the list
	 */
	private void testRemoveFirst()
	{
		List list = new List();
		
		System.out.println("removeFirst:");
		
		list.addToList(10);
		list.addToList(20);
		list.addToList(30);
		
		System.out.println("Removed element: " + list.removeFirst());
		System.out.println("Removed element: " + list.removeFirst());
		System.out.println();
		list.print();
		
		System.out.println("Removed element: " + list.removeFirst());
		try
		{
			System.out.println("Removed element: " + list.removeFirst());
			System.out.println("This line should never be executed");
		}
		catch(EmptyListException e)
		{
			System.out.println("EmptyListException: attempt to remove from an empty list");
		}
		list.print();
	}
}