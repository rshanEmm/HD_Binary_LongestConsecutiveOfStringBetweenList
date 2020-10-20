package FuzzyBinaryTreeSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeWithFuzzyClosest {

    Node root;

    private Node closest;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value, false);
    }

    private boolean containsNodeRecursive(Node current, int value, boolean fuzzy) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            closest = current;
            return true;
        }
        /*
            My answer : containsNodeRecursive already searches the binary tree on a O(n) complexity , why not just
            add little code to capture the node. Add a boolean for to gate the tracker. Not much different then
            tracking packets during a given event with Wireshark (yes I have tinkered with it). So I give this the same
            O(n).

            Add a little like-factory design here to discretely sweep up the closest node when need comes, skip when
            it is not.

            Bruce Lee said it best : Be like Water
         */
        if(fuzzy){
            captureTheClosestNode(current, value);
        }


        return value < current.value
                ? containsNodeRecursive(current.left, value, fuzzy)
                : containsNodeRecursive(current.right, value, fuzzy);
    }


    /*
        We want the number of positions away (distance) from the value, least amount of work gets the win.
        Negative or position placement from the value like on a graph or a map. Hence the need to standardize the
        positions to be positive no matter the difference, that way we can compare. Hence the placement cannot be less
        then zero.Least distance between node and value is what we seek.
        (hence minimum absolute difference not next highest value)

            Example

            value (k) = 14

            Node 12 (2 positions away) and node 18 (4 positions away)

            Uncomment debug statements into the block below and look for yourself.
            int diffClosest = (closest.value - value )< 0 ? (closest.value - value ) * -1 : (closest.value - value);
            int diffCurrent = (current.value - value ) < 0 ? (current.value - value ) * -1 : (current.value - value);
            System.out.println(" ========= diffClosest : " + diffClosest);
            System.out.println(" ========= diffCurrent : " + diffCurrent);
            if(diffClosest > diffCurrent){ closest = current;}
    */
    private void captureTheClosestNode(Node current, int value){
        if(closest == null) {
            closest = current;
            return;
        }
        if(((closest.value - value ) < 0 ? (closest.value - value ) * -1 : (closest.value - value))
                >
                ((current.value - value ) < 0 ? (current.value - value ) * -1 : (current.value - value)))
        { closest = current;}
    }
    public int getClosestContainedNode(int value) {
        closest = null;
        containsNodeRecursive(root, value, true);
        return closest.value;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }


    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}