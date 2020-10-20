import FuzzyBinaryTreeSearch.BinaryTreeWithFuzzyClosest;

public class TestMainForBinaryTreeTest {
    public static void main(String[] args) {
        // Just to test my code with
        BinaryTreeWithFuzzyClosest binTreeWithFuzzyMoss = new BinaryTreeWithFuzzyClosest();
        binTreeWithFuzzyMoss.add(20);
        binTreeWithFuzzyMoss.add(12);
        binTreeWithFuzzyMoss.add(32);
        binTreeWithFuzzyMoss.add(8);
        binTreeWithFuzzyMoss.add(18);
        binTreeWithFuzzyMoss.add(25);
        binTreeWithFuzzyMoss.add(38);
        System.out.println("Binary Tree size : " + binTreeWithFuzzyMoss.getSize());
        System.out.println(
                 "Closest to 32 is Node " + binTreeWithFuzzyMoss.getClosestContainedNode(32)
        );
        /*
        Input  :  k = 14
        Output :  18 ( 4 positions away)
        Candidate corrected output: 12 (2 positions away)
        -----Minimum absolute difference prefers closer to 0 thus logic is off on the output on that test data
        */
        System.out.println(
                "Closest to 14 is Node " + binTreeWithFuzzyMoss.getClosestContainedNode(14)
        );

        System.out.println(
                "Closest to 21 is Node " + binTreeWithFuzzyMoss.getClosestContainedNode(21)
        );

        System.out.println(
                "Closest to 27 is Node " + binTreeWithFuzzyMoss.getClosestContainedNode(27)
        );
    }

}
