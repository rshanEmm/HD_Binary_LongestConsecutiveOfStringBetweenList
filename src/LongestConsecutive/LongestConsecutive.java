package LongestConsecutive;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutive {
    private List<String> longest = new ArrayList();

    public List<String> getLongest() {
        return longest;
    }

    private void resetLongest() {
        longest = new ArrayList();
    }

    private void checkLongest(final List hold) {
        if (longest.size() < hold.size()) {
            this.longest = hold;
        }
    }

    public void contains(final List first, final List second) {
        resetLongest();
        List<String> hold = new ArrayList();

        for (int i = 0; i < first.size(); i++) {
            // Finding the string contained in the
            if (!second.contains(first.get(i))) {
                continue;
            } else {
                hold.add((String) second.get(second.indexOf(first.get(i))));
            }
            int iTemp = i + 1;
            int jLoopSetter = second.indexOf(first.get(i)) + 1;
            if (jLoopSetter >= second.size()) {
                checkLongest(hold);
                hold = new ArrayList();
                continue;
            }

            for (int j = jLoopSetter; j < second.size(); ++j) {


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
