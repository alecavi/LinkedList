package linkedList;

import linkedList.ListNode;

/**
 * A class representing a linked list
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class List 
{
    private ListNode head; // used to hold a reference to an instance of a ListNode object
    // which will be the first item in the list, i.e. at the 'head'
    // of the list
    private int size;

    /**
     * Default constructor. Initialise fields to default values.
     */
    public List()
    {
        // set the list to be empty, i.e. not referring to anything valid yet
        head = null;
        size = 0;
    }

    /**
     * Get the list node which is at the 'head' of the list
     * 
     * @return A reference to a ListNode object which represents the node at the
     *         head of the list (or null if the list is empty, i.e. no 'head' has
     *         been set yet).    
     */
    public ListNode getHead()
    {
        return head;
    }

    /**
     * Set the 'head' of the list to the given node
     * 
     * @param  newHead A reference to a ListNode object which will be
     *                 the head of the list. 
     *
     * <br>
     * NOTE: if a list already exists, the existing listing will be 
     * lost since the head is being assigned to something new.
     * <br>
     * NOTE: the size of the list will be invalidated permanently
     */
    public void setHead(ListNode newHead)
    {
        head = newHead;
    }
    
    /**
     * Return the amount of elements in this list
     * 
     * @return the size of the list
     */
    //Named after java.utils.List.size()
    public int size()
    {
    	return size;
    }

    /**
     * Add a new node containing the specified value to the start of the list
     * 
     * @param value The value stored in this list node 
     */
    public void addToList(int value)
    {
        ListNode node = new ListNode(value);
        if(head == null)
        {
        	head = node;
        }
        else 
        {
        	node.setNext(head);
        	head = node;
        }
        size++;
    }

    /**
     * Display the value of every node in the list, or an error message if the list is empty.
     */
    public void print()
    {
    	if(head == null)
    	{
    		System.out.println("The list is empty");
    		return;
    	}
    	
    	ListNode currentNode = head;
    	while(currentNode != null)
    	{
    		System.out.println("value: " + currentNode.getValue());
    		currentNode = currentNode.getNext();
    	}
    }
    
    /**
     * Search the list for a node with the specified value, and display it if it is found.
     * Note that if there are multiple nodes with the same value, this function will return the first - 
     * the one that was added last
     * @param value the value to find
     */
    public void find(int value)
    {
    	if(head == null)
    	{
    		System.out.println("Cannot find: the list is empty");
    		return;
    	}
    	
    	ListNode currentNode = head;
    	while(currentNode != null)
    	{
    		if(currentNode.getValue() == value)
    		{
    			System.out.println("found: " + currentNode.getValue());
    			return;
    		}
    		currentNode = currentNode.getNext();
    	}
    	System.out.println("no student with the specified id was found");
    }
    
    /**
     * Search the list for a node with the specified value, removes it, and prints a message
     * representing success, or an error message if there is no such node. Note that if there are multiple
     * nodes with the same value, this function will remove the first - the one that was added last 
     * @param value the value to remove
     */
    public void delete(int value)
    {
    	if(head == null)
    	{
    		System.out.println("Cannot remove: the list is empty");
    		return;
    	}
    	
    	ListNode lastNode = null;
    	ListNode currentNode = head;
    	while(currentNode != null)
    	{
    		if(currentNode.getValue() == value)
    		{
    			if(lastNode != null) 
    				lastNode.setNext(currentNode.getNext());
    			else //lastNode will be null if the head of the list has the specified id
    				head = head.getNext();
    			
    			System.out.println("The specified node (value: " + value + ") has been removed");
    			size--;
    			return;
    		}
    		
    		lastNode = currentNode;
    		currentNode = currentNode.getNext();
    	}
    	System.out.println("cannot remove: there is no student with the specified id");
    }
    
    /**
     * Removes the first element from the list and returns its value
     * @return the value of the first element of the list
     * @throws EmptyListException if the list is empty
     */
    public int removeFirst()
    {
    	if(head == null)
    	{
    		throw new EmptyListException("No such element");
    	}
    	else
    	{
    		int value = head.getValue();
    		setHead(head.getNext());
    		size--;
    		return value;
    	}
    }  
    
    /**
     * Clears the list, deleting all elements
     */
    public void clear()
    {
    	size = 0;
    	head = null;
    }
}