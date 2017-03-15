import java.util.Comparator;
import java.util.ArrayList;

/**
 * The WeatherRecord class is the child class of Record to be used when merging weather data. Station and Date
 * store the station and date associated with each weather reading that this object stores.
 * l stores the weather readings, in the same order as the files from which they came are indexed.
 */
public class WeatherRecord extends Record{
    // TODO declare data structures required
	MinPriorityQueueADT<FileLine> queue;
	Comparator<FileLine> cmp;
	ArrayList<Double> output;
	
	/**
	 * Constructs a new WeatherRecord by passing the parameter to the parent constructor
	 * and then calling the clear method()
	 */
    public WeatherRecord(int numFiles) {
    	super(numFiles);
    	
		cmp = getComparator();
		queue = new FileLinePriorityQueue(numFiles, cmp);
		output = new ArrayList<Double>();
		
		clear();
    }
	
	/**
	 * This comparator should first compare the stations associated with the given FileLines. If 
	 * they are the same, then the dates should be compared. 
	 */
    private class WeatherLineComparator implements Comparator<FileLine> {
		public int compare(FileLine l1, FileLine l2) {
			//Parse l1 into double array
			String[] line1 = l1.getString().split(",");
			double[] info1 = new double[line1.length];
			for(int i = 0; i < line1.length; i++)
				info1[i] = Double.parseDouble(line1[i]);
			
			//Parse l2 into double array
			String[] line2 = l2.getString().split(",");
			double[] info2 = new double[line2.length];
			for(int i = 0; i < line2.length; i++)
				info2[i] = Double.parseDouble(line2[i]);
			
			if(info1[0] > info2[0])
				return 1;
			
			else if(info1[0] < info2[0])
				return -1;
			
			else
			{
				if(info1[1] > info2[1])
					return 1;
				else if(info1[1] < info2[1])
					return -1;
			}
			
			return 0;
		}
		
		public boolean equals(Object o) {
			return this.equals(o);
		}
    }
    
	/**
	 * This method should simply create and return a new instance of the WeatherLineComparator
	 * class.
	 */
    public Comparator<FileLine> getComparator() {
		return new WeatherLineComparator();
    }
	
	/**
	 * This method should fill each entry in the data structure containing
	 * the readings with Double.MIN_VALUE
	 */
    public void clear() {
		// TODO initialize/reset data members
    	for(int i = 0; i < output.size(); i++)
    		output.set(i, Double.MIN_VALUE);
    }

	/**
	 * This method should parse the String associated with the given FileLine to get the station, date, and reading
	 * contained therein. Then, in the data structure holding each reading, the entry with index equal to the parameter 
	 * FileLine's index should be set to the value of the reading. Also, so that
	 * this method will handle merging when this WeatherRecord is empty, the station and date associated with this
	 * WeatherRecord should be set to the station and date values which were similarly parsed.
	 */
    public void join(FileLine li) {
		// TODO implement join() functionality
    	String[] line = li.getString().split(",");
    	double[] lineInfo = new double[line.length];
    	
    	for(int i = 0; i < line.length; i++)
    		lineInfo[i] = Double.parseDouble(line[i]);
    	
    	
    	
    }
    
	/**
	 * See the assignment description and example runs for the exact output format.
	 */
    public String toString() {
		String string = "";
		
		
		
		return string;
    }
}
