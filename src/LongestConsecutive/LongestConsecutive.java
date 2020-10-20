package LongestConsecutive;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutive {
    private List<String> longest = new ArrayList();

    public List<String> getLongest() {return longest;}

    private void resetLongest(){longest = new ArrayList();}

    private void checkLongest(List hold){
        if(longest.size() < hold.size()) {
            this.longest = hold;
        }
    }

    public void contains(List first, List second) {
        resetLongest();
        List<String> hold = new ArrayList();

        /*
        This is something like O(n(n as along as n as a pattern)), this was as close to O(n) as I could get.
        At least it not true O(n^2). I did use contain and indexOf to position the second loop in a logical fashion.
        It breaks out on a bad condition statement then moves on to the next position in first after checking for
        a save condition.
         */
        for (int i=0; i<first.size(); i++) {
            // Finding the string contained in the
            if(!second.contains(first.get(i))){
                continue;
            } else {
                hold.add((String)second.get(second.indexOf(first.get(i))));
            }
            int iTemp = i+1;
            int jLoopSetter = second.indexOf(first.get(i))+1;
            // if string found at last position of second list then save, reset, try again
            if(jLoopSetter >= second.size()){
                checkLongest(hold);
                hold = new ArrayList();
                continue;
            }
            /*
            The bane of this, wish I had a solution where I did not have to setup an inner loop yet I do not have time.
            Found out things I have to take care of so I settled on a slightly less then O(n) solution. With how
            this test was designed, I could not use a "Set" and O(n) anyway.
             */
            for(int j = jLoopSetter; j < second.size(); ++j ) {


                if (first.get(iTemp) == second.get(j)) {
                    hold.add((String) second.get(j));
                    iTemp++;
                } else {
                    break;
                }

            }
            checkLongest(hold);
            hold = new ArrayList();
        }
    }
}
