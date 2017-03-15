import java.util.Comparator;

/**
 * An implementation of the MinPriorityQueueADT interface. This implementation stores FileLine objects.
 * See MinPriorityQueueADT.java for a description of each method. 
 *
 */
public class FileLinePriorityQueue implements MinPriorityQueueADT<FileLine> {
    private Comparator<FileLine> cmp;
    
    private int maxSize;
    
    private FileLine[] queue;
    
    private int numItems;
    
    private int index;

    /**
     * The constructor initializes all of the variables and objects. We will 
     * diffrentiate between the current index and the number of items because
     * 
     * @param initialSize the maximum number of FileLine objects that could be
     * inserted into this queue
     * @param cmp is the Comparator object used to reheapify the queue
     */
    public FileLinePriorityQueue(int initialSize, Comparator<FileLine> cmp) {
		this.cmp = cmp;
		
		maxSize = initialSize;
		
		queue = new FileLine[maxSize];
		
		numItems = 0;
		
		index = 1;
    }

    /**
     * Returns the removed original root, and reheapifies the queue so that
     * the minimum node becomes the next root
     */
    public FileLine removeMin() throws PriorityQueueEmptyException {
    	
    	boolean done = false;
    	
    	//If queue is empty, throw Exception
    	if(isEmpty())
    	{
    		throw new PriorityQueueEmptyException();
    	}
    	
    	FileLine tmp = queue[1];
    	
    	int curr = 1;
    	
    	//Reheapify the queue
    	while(!done)
    	{
    		curr = curr * 2;
    		
    		//End loop if all levels are checked
    		if(curr >= numItems)
    		{
    			done = true;
    		}
    		else
    		{
    			//Choose the minimum sibling to compare with parent
    			if(cmp.compare(queue[curr], queue[curr + 1]) > 0)
    				curr = curr + 1;
    			
    			//Swap parent and child if parent is larger
    			if(cmp.compare(queue[curr], queue[curr / 2]) < 0)
    				queue[curr / 2] = queue[curr];
    		}
    	}
    	
    	//Decrement index and numItems
    	index--;
    	numItems--;
    	
		return tmp;
    }

    /**
     * Inserts a new FileLine object into queue, then reheapifies the queue.
     */
    public void insert(FileLine fl) throws PriorityQueueFullException {
		// TODO
    	
    	boolean done = false;
    	
    	//If queue reaches maximum number of items, throw exception
    	if(numItems == maxSize)
    	{
    		throw new PriorityQueueFullException();
    	}
    	
    	queue[index] = fl;
    	
    	int curr = index;
    	
    	//Reheapify the queue
    	while(!done)
    	{	
    		curr = curr / 2;
    		
    		//End loop if curr reaches the root or the parent of the current node is smaller
    		if(curr == 0 || cmp.compare(queue[index],queue[curr]) < 0)
    		{
    			done = true;
    		}
    		//Swap between parent and child
    		else
    		{
    			FileLine tmp = queue[curr];
    			queue[curr] = queue[index];
    			queue[index] = tmp;
    		}
    	}
    	
    	//Increment index and numItems
    	index++;
    	numItems++;
    }

    /**
     * This method returns true if the queue is empty false otherwise
     */
    public boolean isEmpty() {
    	if(numItems == 0)
			return true;
    	
    	else
    		return false;
    }
}
