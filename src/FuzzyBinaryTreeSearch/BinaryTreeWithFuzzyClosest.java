package FuzzyBinaryTreeSearch;

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

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }


    private boolean containsNodeRecursive(Node current, int value, boolean fuzzy) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            closest = current;
            return true;
        }
<<<<<<< HEAD

=======
      
>>>>>>> 7971d4888585be74f2ebb98b0d107a043f0b51b5
        if(fuzzy){
            captureTheClosestNode(current, value);
        }


        return value < current.value
                ? containsNodeRecursive(current.left, value, fuzzy)
                : containsNodeRecursive(current.right, value, fuzzy);
    }
<<<<<<< HEAD

=======
>>>>>>> 7971d4888585be74f2ebb98b0d107a043f0b51b5
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
