package main;

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

    /**
     * Default constructor. Initialise fields to default values.
     */
    public List()
    {
        // set the list to be empty, i.e. not referring to anything valid yet
        head = null;
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
     * NOTE: if a list already exists, the existing listing will be 
     * lost since the head is being assigned to something new.
     */
    public void setHead(ListNode newHead)
    {
        head = newHead;
    }

    /**
     * Add a new node to the start of the list which will contain
     * the data provided (a student ID and mark).
     * 
     * @param id The id of the student to be placed in this list node
     * @param mark The student's mark 
     * @throws IllegalArgumentException if {@code id} is null
     */
    public void addToList(String id, int mark)
    {
    	if(id == null) throw new IllegalArgumentException("Can't add null ids");
    	
        ListNode node = new ListNode(id, mark);
        if(head == null)
        {
        	head = node;
        }
        else 
        {
        	node.setNext(head);
        	head = node;
        }
        
    }

    /**
     * Display the ID and mark of every node in the list, or an error message if the list is empty.
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
    		System.out.println("ID: " + currentNode.getID() + ", mark: " + currentNode.getMark());
    		currentNode = currentNode.getNext();
    	}
    }
    
    /**
     * Display the mark associated with the specified ID, or an error message if there is no such ID.
     * Note that if there are multiple elements with the same ID, this function will return the first - 
     * the one that was added last
     * @param id
     */
    public void findByID(String id)
    {
    	if(head == null)
    	{
    		System.out.println("The list is empty");
    		return;
    	}
    	
    	ListNode currentNode = head;
    	while(currentNode != null)
    	{
    		if(currentNode.getID().equals(id))
    		{
    			System.out.println(currentNode.getMark());
    			return;
    		}
    		currentNode = currentNode.getNext();
    	}
    	System.out.println("There is no student with the specified id");
    }
}