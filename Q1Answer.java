/**
 * Who would've guessed? Doomsday devices take a LOT of power. Commander Lambda wants to supplement the LAMBCHOP's quantum antimatter reactor core with solar arrays, and she's tasked you with setting up the solar panels.
 *
 * Due to the nature of the space station's outer paneling, all of its solar panels must be squares. Fortunately, you have one very large and flat area of solar material, a pair of industrial-strength scissors, and enough MegaCorp Solar Tape(TM) to piece together any excess panel material into more squares. For example, if you had a total area of 12 square yards of solar material, you would be able to make one 3x3 square panel (with a total area of 9). That would leave 3 square yards, so you can turn those into three 1x1 square solar panels.
 *
 * Write a function answer(area) that takes as its input a single unit of measure representing the total area of solar panels you have (between 1 and 1000000 inclusive) and returns a list of the areas of the largest squares you could make out of those panels, starting with the largest squares first. So, following the example above, answer(12) would return [9, 1, 1, 1].
 *
 * Languages
 * =========
 *
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit solution.java
 *
 * Test cases
 * ==========
 *
 * Inputs:
 *     (int) area = 12
 * Output:
 *     (int list) [9, 1, 1, 1]
 *
 * Inputs:
 *     (int) area = 15324
 * Output:
 *     (int list) [15129, 169, 25, 1]
 *
 * Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
 */

import java.util.*;

public class Q1Answer {

    public static int[] answer(int area) {

        // We don't know how many squares we can make yet, so use a list
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(arrayTotal(list) < area) {
            list.add(getLargestSquare(area - arrayTotal(list)));
        }

        return convertArrayList(list);
    }

    /* Convert Integer list to int array */
    protected static int[] convertArrayList(ArrayList<Integer> list)
    {
        int[] intArray  = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            intArray[i] = list.get(i).intValue();
        }
        return intArray;
    }

    /* Get the total value from a list of arrays
     * There's probably a more elegant way of doing this
     */
    protected static int arrayTotal(ArrayList<Integer> list)
    {
        int count=0;
        for (Integer aList : list) {
            count += aList;
        }
        return count;
    }

    /* Find the largest sqrtable number */
    protected static int getLargestSquare(int area)
    {
        while(area > 0){
            double sqrt = Math.sqrt(area);
            if(sqrt == Math.round(sqrt)){
                return area;
            }
            area--;
        }
        //Something went wrong, or 0 was passed to the function
        return 0;
    }

}