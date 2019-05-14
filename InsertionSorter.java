/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class InsertionSorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter(  ArrayList< String> usersData) {
        super( usersData);
    }


    /**
      Sort the user's data, implementing insertion sort.
     */
    public void mySort() {
        // iterate through the data, inserting each element
        for( int indexToInsert = 1 // element 0 is already sorted
           ; indexToInsert < elements.size()
           ; indexToInsert++
           ) {
            insertOne( indexToInsert);

            // for debugging
            System.out.println( "    dbg: "
              + "after inserting element " + indexToInsert
              + " elements: " + elements
              );
           }
    }

    private void insertOne( int alreadyInserted) {
        String valueToInsert = elements.get( alreadyInserted);

        // iterate through sorted region
        for( int indexToCompare = alreadyInserted -1
           ; // loop termination happens within the loop
           ; indexToCompare--
           ) {
            /* Did previous iterations find that even the
               smallest value in the sorted region exceeds
               the valueToInsert?
             */
            if( indexToCompare < 0) {
                /* drop valueToInsert at the beginning of
                   the sorted region */
                elements.set( 0, valueToInsert);
                return;
            }
            else{
                String valueToCompare = elements.get( indexToCompare);
                if( valueToInsert.compareTo( valueToCompare) >= 0){
                    // found the destination, so drop valueToInsert here
                    elements.set( indexToCompare +1, valueToInsert);
                    return;
                }
                else // need to look further through the sorted region
                    // Shift  the larger value.
                    elements.set( indexToCompare +1, valueToCompare);
            }
        }  // end of "iterate through sorted region"
    }
}