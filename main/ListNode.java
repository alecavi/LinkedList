package main;

/**
 * A linked list node, storing an id and a mark
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class ListNode    
{
    // fields to store the data being held in this list node (a student ID and mark)
    private String id;
    private int mark;
    private ListNode next;

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
        // set id and mark to default / empty values 
        id = "";
        mark = 0;
        next = null;
    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param id The id for the student
     * @param mark The student's mark
     */
    public ListNode(String id, int mark)
    {
        // set id and mark to values provided
        this.id = id;
        this.mark = mark;
        this.next = null;
    }

    /**
     * Get the student ID contained in this list node
     * 
     * @return The student's ID as a String
     */
    public String getID()
    {
        return id;
    }

    /**
     * Get the student mark contained in this list node
     * 
     * @return The student mark
     */
    public int getMark()
    {
        return mark;
    }

    /**
     * Get the next node in the list after this one
     * 
     * @return A reference to the next node (or null if
     *         there is no next node)
     */
    public ListNode getNext()
    {
       return next;
    }

    /**
     * Set the next node in the list after this one
     * 
     * @param next A reference to a ListNode object which 
     *             represents the next node in the list after
     *             this one.
     */
    public void setNext(ListNode next)
    {
    	this.next = next;
    }

    /**
     * Return a string containing summary data from this node
     * 
     * @return A String containing a summary of the data contained in this list node
     */
    public String getSummaryData()
    {
        String data;		
        data = "Student with ID " + id + " obtained the following mark: " + mark + "%";		
        return data;
    }
}