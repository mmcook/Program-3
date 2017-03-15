import java.util.ArrayList;
import java.util.Comparator;

/**
 * The ThesaurusRecord class is the child class of Record to be used when merging thesaurus data.
 */


public class ThesaurusRecord extends Record{
    // TODO declare data structures required

	ArrayList<String> syn;
	
	/**
	 * Constructs a new ThesaurusRecord by passing the parameter to the parent constructor
	 * and then calling the clear method()
	 */
    public ThesaurusRecord(int numFiles) {
    	super(numFiles);
    	
    	syn = new ArrayList<String>();    	
    	clear();
    }

    /**
	 * This Comparator should simply behave like the default (lexicographic) compareTo() method
	 * for Strings, applied to the portions of the FileLines' Strings up to the ":"
	 * The getComparator() method of the ThesaurusRecord class will simply return an
	 * instance of this class.
	 */
	private class ThesaurusLineComparator implements Comparator<FileLine> {
		public int compare(FileLine l1, FileLine l2) {
			if  (l1.getString().indexOf(':') == -1) {
				return -1;
			}
			if (l2.getString().indexOf(':') == -1) {
				return 1;
			}

			if (l1.getString().substring(0, l1.getString().indexOf(
					':')).compareTo(l2.getString().substring(
							0, l2.getString().indexOf(':'))) > 0) {
				return 1;
			}
			
			if (l1.getString().substring(0, l1.getString().indexOf(
					':')).compareTo(l2.getString().substring(
							0, l2.getString().indexOf(':'))) < 0) {
				return -1;
			}
			return 0;
		}
		
		public boolean equals(Object o) {
			return this.equals(o);
		}
    }
    
	/**
	 * This method should simply create and return a new instance of the ThesaurusLineComparator class.
	 */
    public Comparator<FileLine> getComparator() {
		return new ThesaurusLineComparator();
    }
	
	/**
	 * This method should (1) set the word to null and (2) empty the list of synonyms.
	 */
    public void clear() {
		// TODO initialize/reset data members
    	for (int i = 0; i < syn.size(); i++) {
    		syn.set(i, null);
    	}
    }
	
	/**
	 * This method should parse the list of synonyms contained in the given FileLine and insert any
	 * which are not already found in this ThesaurusRecord's list of synonyms.
	 */
    public void join(FileLine w) {
    	String[] line = w.getString().split(",");
    	String[] newLine = new String[line.length + 1];
    	newLine[0] = line[0].substring(0, line[0].indexOf(':'));
    	newLine[1] = line[0].substring(line[0].indexOf(':') + 1);
    }
	
	/**
	 * See the assignment description and example runs for the exact output format.
	 */
    public String toString() {
		// TODO
		return null;
	}
}
