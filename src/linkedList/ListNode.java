package linkedList;

/**
 * A linked list node, storing an id and a mark
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class ListNode    
{
    // fields to store the data being held in this list node (a student ID and mark)
    private int value;
    private ListNode next;

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    { 
        value = 0;
        next = null;
    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param id The id for the student
     * @param mark The student's mark
     */
    public ListNode(int value)
    {
        // set id and mark to values provided
        this.value = value;
        this.next = null;
    }

    /**
     * Get the value contained in this list node
     * 
     * @return The value
     */
    public int getValue()
    {
        return value;
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
}