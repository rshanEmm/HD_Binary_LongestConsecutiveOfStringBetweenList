import LongestConsecutive.LongestConsecutiveBetterWithGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMainForLongestConsecutive {
    private List longest = new ArrayList();

    public static void main(String[] args) {
        final List<String> arrListFinal = new ArrayList<String>(Arrays.asList("sun", "moon", "flower", "fruit", "apple", "star", "rose", "fruit", "lily", "fairy"));
        LongestConsecutiveBetterWithGraph lc = new LongestConsecutiveBetterWithGraph(); // O(EV) , O(E ln V) ....Pretty close to O(n)
        lc.contains(arrListFinal, new ArrayList<String>(Arrays.asList("hercules", "flower", "fruit", "rose")));
        System.out.println(lc.getLongest());
        lc.contains(arrListFinal, new ArrayList<String>(Arrays.asList("apple", "rose", "flower", "fruit", "apple")));
        System.out.println(lc.getLongest());
        lc.contains(arrListFinal, new ArrayList<String>(Arrays.asList("mars", "earth", "jupiter")));
        System.out.println(lc.getLongest());
        lc.contains(arrListFinal, new ArrayList<String>(Arrays.asList("sun", "moon", "flower", "apple", "star", "rose", "fruit")));
        System.out.println(lc.getLongest());


    }
}
