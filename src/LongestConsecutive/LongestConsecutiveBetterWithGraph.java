package LongestConsecutive;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveBetterWithGraph {
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

    private Graph<String> setGraph(final List dataForGraph){
        Graph<String> graphOfStrings = new Graph<String>();
        for (int i = 0; i < (dataForGraph.size()-1); i++) {
            graphOfStrings.addEdge((String) dataForGraph.get(i), (String) dataForGraph.get(i+1), false);
        }
        return graphOfStrings;
    }

    public void contains(final List first, final List second) {
        resetLongest();
        Graph<String> forestOfGraphNodes = setGraph(first);
        List<String> hold = new ArrayList<String>();
        for (int i = 0; i < second.size(); i++) {
             if(i == (second.size()-1)){
                if(forestOfGraphNodes.hasEdge((String) second.get(i-1), (String) second.get(i))){
                    hold.add((String) second.get(i));
                 }

                 checkLongest(hold);
                 hold = new ArrayList<String>();
                 break;

             }

             if(forestOfGraphNodes.hasEdge((String) second.get(i), (String) second.get(i+1)))
             {
                hold.add((String) second.get(i));
                continue;
             } else {
                 if(forestOfGraphNodes.hasVertex((String) second.get(i))) {
                     hold.add((String) second.get(i));
                 }

                if(hold.size() <= 0){
                    continue;
                } else {
                    checkLongest(hold);
                    hold = new ArrayList<String>();
                }
             }
        }



    }
}
