/**
 * Represents a node of a Binary Search Tree
 *
 * @author Bhavyai Gupta
 */
public class Node {
    public Object data;
    public Node left;
    public Node right;

    /**
     * Creates a new node with Object <code>d</code>
     *
     * @param o object that is to be stored in the Node
     */
    public Node(Object o) {
        this.data = o;
        this.left = null;
        this.right = null;
    }
}
