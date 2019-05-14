/**
  Implement a sub-sort-then-merge, in the Sorters structure.
  Also known by the regrettable name "merge sort"
  among the heathen.
 */
import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter {

    /**
      Construct an instance to process the user's data
     */
    public SubSortThenMerge_Sorter(  ArrayList< String> usersData) {
        super( usersData);
    }


    /**
      Sort the user's data, implementing sub-sort-then-merge.
     */
    public void mySort() {
        sortRange( 0, elements.size());
    }


    /**
      Problem: Sort the data from the given range.
      Recursive Abstraction: When I am asked to {problem statement},
      the recursive abstraction can sort the data from a sub-range.
     */
    private void sortRange( int startAt, int stopBefore) {
        int splitBefore = (stopBefore + startAt +1) / 2;
        /* "splitBefore" seemed like a clear name. So "+1"
           was included to match the processing to the name */

        // temp for debugging
        System.out.println( "startAt= " + startAt
                          + ", stopBefore= " + stopBefore
                          + ", splitBefore= " + splitBefore
                          );

        // decision: Is the requested a base or recursive case?
        if( splitBefore < stopBefore) {
            /* solution to base case of 0 or 1 elements:
                  already sorted, trivially */
            // solution to recursive cases
            sortRange( startAt, splitBefore);
            sortRange(          splitBefore, stopBefore);
            new Merger( elements).merge( startAt
                                       , splitBefore
                                       , stopBefore);
        }
    }
}