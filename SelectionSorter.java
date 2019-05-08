/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SelectionSorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public SelectionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
      sort the user's data, implementing insertion sort
     */
    /**
      Pre-condition: The list must have only Strings
      Post-condition: The list will be returned sorted
     */
    public void mySort() {
        for (int index = 0; index < elements.size(); index++){
			int nextLargerAt = champIndex(index);
			String currentValue = elements.get(index);
			elements.set(index, elements.get(nextLargerAt));
			elements.set(nextLargerAt, currentValue);
		}
	}
	/**
      Pre-condition: The list must have only Strings
      Post-condition: The lowest index will go to the end of the list
     */
	private int champIndex(int lowestIndex) {
		 String champ = "ZZZZZZZZ";
		 for (int index = lowestIndex; index < elements.size(); index++){
			 if (elements.get(index).compareTo(champ) < 0){
				 lowestIndex = index;
				 champ = elements.get(index);
			 }
		 }
		 return lowestIndex;
     }
	

}