import LongestConsecutive.LongestConsecutive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMainForLongestConsecutive {
    private List longest = new ArrayList();

    public static void main(String[] args) {
        final List arrListFinal = new ArrayList(Arrays.asList("sun", "moon", "flower", "fruit", "apple", "star", "rose", "fruit", "lily", "fairy"));
        LongestConsecutive lc = new LongestConsecutive();
        lc.contains(arrListFinal, new ArrayList(Arrays.asList("hercules", "flower", "fruit", "rose")));
        System.out.println(lc.getLongest());
        lc.contains(arrListFinal, new ArrayList(Arrays.asList("apple", "rose", "flower", "fruit", "apple")));
        System.out.println(lc.getLongest());
        lc.contains(arrListFinal, new ArrayList(Arrays.asList("mars", "earth", "jupiter")));
        System.out.println(lc.getLongest());
        lc.contains(arrListFinal, new ArrayList(Arrays.asList("sun", "moon", "flower", "apple", "star", "rose", "fruit")));
        System.out.println(lc.getLongest());
    }
}
