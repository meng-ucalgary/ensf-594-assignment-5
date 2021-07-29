/**
 * Stores the Student Nodes in a Binary Search Tree
 *
 * @author Bhavyai Gupta
 */
public class StudentTree {
    private Node root;
    private StringBuilder tempString;
    private NodeQueue tempQueue;

    /**
     * Creates an empty tree
     */
    public StudentTree() {
        this.root = null;
        this.tempString = null;
    }

    /**
     * Inserts a Student at appropriate position in the StudentTree
     *
     * @param s the Student to be inserted
     */
    public void insert(Student s) {
        this.root = this.insert(this.root, s);
    }

    /**
     * Actual method that inserts a Student at appropriate position in the
     * StudentTree
     *
     * @param root the root node of the StudentTree
     * @param s    the Student to be inserted
     * @return the root node of the StudentTree
     */
    public Node insert(Node root, Student s) {
        if (root == null) {
            return new Node(s);
        }

        else if (s.compareTo((Student) root.data) > 0) {
            root.right = this.insert(root.right, s);
            return root;
        }

        else {
            root.left = this.insert(root.left, s);
            return root;
        }
    }

    /**
     * Traverses the tree in in-order fashion and returns the string representing
     * the tree
     *
     * @return in-order representation of the StudentTree
     */
    public String inOrder() {
        // reset the tempString
        this.tempString = new StringBuilder();
        this.tempString.append(Student.studentDivider());
        this.tempString.append(Student.studentHeader());
        this.tempString.append(Student.studentDivider());

        this.inOrder(this.root);

        this.tempString.append(Student.studentDivider());
        return this.tempString.toString();
    }

    /**
     * Actual method that traverses the tree in in-order fashion
     *
     * @param root the root node of the StudentTree
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        this.inOrder(root.left);
        this.tempString.append((Student) root.data); // equivalent to System.out.println((Student) root.data);
        this.inOrder(root.right);
    }

    /**
     * Traverses the tree in level-order fashion and returns the string representing
     * the tree
     *
     * @return level-order representation of the StudentTree
     */
    public String levelOrder() {
        // reset the tempString
        this.tempString = new StringBuilder();
        this.tempString.append(Student.studentDivider());
        this.tempString.append(Student.studentHeader());
        this.tempString.append(Student.studentDivider());

        // reset the tempQueue
        this.tempQueue = new NodeQueue();

        this.tempQueue.enqueue((Node) this.root);

        while (!this.tempQueue.isEmpty()) {
            Node temp = this.tempQueue.dequeue();
            this.tempString.append(temp.data);

            if (temp.left != null) {
                this.tempQueue.enqueue((Node) temp.left);
            }

            if (temp.right != null) {
                this.tempQueue.enqueue((Node) temp.right);
            }
        }

        this.tempString.append(Student.studentDivider());
        return this.tempString.toString();
    }
}
