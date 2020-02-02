package main;

import java.util.Scanner;

import linkedList.EmptyListException;
import linkedList.List;

/**
 * An automated testing class for the linked list.
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class Tester
{
	private List list;
	private static final Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args)
	{
		Tester tester = new Tester();
		tester.initialise();
		
		System.out.println("Input \"add\" to add a student to the list, \"print\" to print the list, "
				+ "\"find\" to find a student in the list, \"delete\" to delete a student from the list, "
				+ "\"removeFirst\" to remove the first element from the list, \"size\" to print the size of the list"
				+ " \"test\" to run the automated tests, or \"exit\" to exit");
	}
	
	/**
	 * Sets up for testing - initialise fields and prepare them to be used
	 */
	private void initialise()
	{
		list = new List();
	}
	
	/**
	 * Performs the automated testing process
	 */
	private void process()
	{
		autoTestSize();
		System.out.println();
		System.out.println();
		
		autoTestAdd();
		System.out.println();
		System.out.println();
		
		autoTestFind();
		System.out.println();
		System.out.println();
		
		autoTestDelete();
		System.out.println();
		System.out.println();
		
		autoTestRemoveFirst();
	}

	private void autoTestSize()
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
	private void autoTestAdd()
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
	private void autoTestFind()
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
	private void autoTestDelete()
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
	private void autoTestRemoveFirst()
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