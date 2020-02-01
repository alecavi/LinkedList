package linkedList;

/**
 * An exception thrown by a linked list when attempting to return a nonexistent element
 * 
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
//The built-in stack interface (well, deque) does not throw a checked exception on an attempt to pop a nonexistent element
public class EmptyListException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     * later retrieval by the {@link #getMessage()} method.
     */
	public EmptyListException(String message)
	{
		super(message);
	}
}
