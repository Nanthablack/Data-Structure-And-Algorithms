import java.util.*;

/*
    มี 3 class 
    class 1 = AVLTree 
    class 2 = SplayTree 
    class 3 = AVLvsSplay ( class ที่ใช้ในการทดลอง class AVLTree และ class SplayTree )
*/
class AVLTree {

    class Node {
        int data;
        Node parent;
        Node left;
        Node right;
        int bf;

        public Node(int data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.bf = 0;
        }
    }

    private Node root;

    public AVLTree() {
        root = null;
    }

    private void printHelper(Node currPtr, String indent, boolean last) {

        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            System.out.println(currPtr.data);

            printHelper(currPtr.left, indent, false);
            printHelper(currPtr.right, indent, true);
        }

    }

    private Node searchTreeHelper(Node node, int key) {
        if (node == null || key == node.data) {
            return node;
        }

        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }

    private Node deleteNodeHelper(Node node, int key) {

        if (node == null)
            return node;
        else if (key < node.data)
            node.left = deleteNodeHelper(node.left, key);
        else if (key > node.data)
            node.right = deleteNodeHelper(node.right, key);
        else {

            if (node.left == null && node.right == null) {
                node = null;
            }

            else if (node.left == null) {
                Node temp = node;
                node = node.right;
            }

            else if (node.right == null) {
                Node temp = node;
                node = node.left;
            }

            else {
                Node temp = minimum(node.right);
                node.data = temp.data;
                node.right = deleteNodeHelper(node.right, temp.data);
            }

        }
        return node;
    }

    private void updateBalance(Node node) {
        if (node.bf < -1 || node.bf > 1) {
            rebalance(node);
            return;
        }

        if (node.parent != null) {
            if (node == node.parent.left) {
                node.parent.bf -= 1;
            }

            if (node == node.parent.right) {
                node.parent.bf += 1;
            }

            if (node.parent.bf != 0) {
                updateBalance(node.parent);
            }
        }
    }

    void rebalance(Node node) {
        if (node.bf > 0) {
            if (node.right.bf < 0) {
                rightRotate(node.right);
                leftRotate(node);
            } else {
                leftRotate(node);
            }
        } else if (node.bf < 0) {
            if (node.left.bf > 0) {
                leftRotate(node.left);
                rightRotate(node);
            } else {
                rightRotate(node);
            }
        }
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void preorder() {
        preOrderHelper(this.root);
    }

    public void inorder() {
        inOrderHelper(this.root);
    }

    public void postorder() {
        postOrderHelper(this.root);
    }

    public Node search(int k) {
        return searchTreeHelper(this.root, k);
    }

    public Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node successor(Node x) {

        if (x.right != null) {
            return minimum(x.right);
        }

        Node y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public Node predecessor(Node x) {

        if (x.left != null) {
            return maximum(x.left);
        }

        Node y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
        x.bf = x.bf - 1 - Math.max(0, y.bf);
        y.bf = y.bf - 1 + Math.min(0, x.bf);

    }

    void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
        x.bf = x.bf + 1 - Math.min(0, y.bf);
        y.bf = y.bf + 1 + Math.max(0, x.bf);

    }

    public void add(int key) {
        Node node = new Node(key);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }
        updateBalance(node);
    }

    Node deleteNode(int data) {
        return deleteNodeHelper(this.root, data);
    }

    static int count = 1;

    public void prettyPrint() {

        System.out.println();
        System.out.println(("[") + count + ("] AVLTree"));
        System.out.println();

        printHelper(this.root, "", true);

        System.out.println();
        System.out.println("---------------END--------------");

        count++;
    }
}

class SplayTree {

    class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public SplayTree() {
        root = null;
    }

    private void printHelper(Node currPtr, String indent, boolean last) {
        // print the tree structure on the screen
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "     ";
            }

            System.out.println(currPtr.data);

            printHelper(currPtr.left, indent, false);
            printHelper(currPtr.right, indent, true);
        }
    }

    private Node searchTreeHelper(Node node, int key) {
        if (node == null || key == node.data) {
            return node;
        }

        return searchTreeHelper(node.right, key);
    }

    private void deleteNodeHelper(Node node, int key) {
        Node x = null;
        Node t = null;
        Node s = null;
        while (node != null) {
            if (node.data == key) {
                x = node;
            }

            if (node.data <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (x == null) {
            System.out.println("Couldn't find key in the tree");
            return;
        }
        // split operation
        splay(x);
        if (x.right != null) {
            t = x.right;
            t.parent = null;
        } else {
            t = null;
        }
        s = x;
        s.right = null;
        x = null;

        // join operation
        if (s.left != null) { // remove x
            s.left.parent = null;
        }
        root = join(s.left, t);
        s = null;
    }

    // rotate left at node x
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Splaying operation. It moves x to the root of the tree
    private void splay(Node x) {
        while (x.parent != null) {
            if (x.parent.parent == null) {
                if (x == x.parent.left) {
                    // zig rotation
                    rightRotate(x.parent);
                } else {
                    // zag rotation
                    leftRotate(x.parent);
                }
            } else if (x == x.parent.left && x.parent == x.parent.parent.left) {
                // zig-zig rotation
                rightRotate(x.parent.parent);
                rightRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.right) {
                // zag-zag rotation
                leftRotate(x.parent.parent);
                leftRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.left) {
                // zig-zag rotation
                leftRotate(x.parent);
                rightRotate(x.parent);
            } else {
                // zag-zig rotation
                rightRotate(x.parent);
                leftRotate(x.parent);
            }
        }
    }

    // joins two trees s and t
    private Node join(Node s, Node t) {
        if (s == null) {
            return t;
        }

        if (t == null) {
            return s;
        }
        Node x = maximum(s);
        splay(x);
        x.right = t;
        t.parent = x;
        return x;
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Pre-Order traversal
    // Node->Left Subtree->Right Subtree
    public void preorder() {
        preOrderHelper(this.root);
    }

    // In-Order traversal
    // Left Subtree -> Node -> Right Subtree
    public void inorder() {
        inOrderHelper(this.root);
    }

    // Post-Order traversal
    // Left Subtree -> Right Subtree -> Node
    public void postorder() {
        postOrderHelper(this.root);
    }

    // search the tree for the key k
    // and return the corresponding node
    public boolean search(int k) {
        Node x = searchTreeHelper(root, k);
        if (x != null) {
            splay(x);
        }
        return true;
    }

    // find the node with the minimum key
    public Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // find the node with the maximum key
    public Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // find the successor of a given node
    public Node successor(Node x) {
        // if the right subtree is not null,
        // the successor is the leftmost node in the
        // right subtree
        if (x.right != null) {
            return minimum(x.right);
        }

        // else it is the lowest ancestor of x whose
        // left child is also an ancestor of x.
        Node y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // find the predecessor of a given node
    public Node predecessor(Node x) {
        // if the left subtree is not null,
        // the predecessor is the rightmost node in the
        // left subtree
        if (x.left != null) {
            return maximum(x.left);
        }

        Node y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    // insert the key to the tree in its appropriate position
    public void add(int key) {
        Node node = new Node(key);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y is parent of x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        // splay node
        splay(node);
    }

    // delete the node from the tree
    void deleteNode(int data) {
        deleteNodeHelper(this.root, data);
    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

}

public class AVLvsSplay {

    static int nextGaussian(Random r, int mean) {
        return (int) (r.nextGaussian() * mean / 2) + mean;
    }

    public static void main(String[] args) {

        int start = 100000;
        int step = 100000;

        Random r = new Random();

        System.out.println("Ordered build AVLTree AVLTree AVLTree AVLTree ");
        // ordered AVL
        for (int n = start; n < start + 10 * step; n += step) {

            AVLTree avl = new AVLTree();
            System.out.println("n: " + n);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.add(i);
            System.out.println("avl ordered build : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(i);
            System.out.println("avl ordered access : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(nextGaussian(r, n));
            System.out.println("avl gaussian accese : " + (System.currentTimeMillis() - startTime));

            System.out.println();

        }

        System.out.println("Random build AVLTree AVLTree AVLTree AVLTree ");
        // random AVl
        for (int n = start; n < start + 10 * step; n += step) {

            AVLTree avl = new AVLTree();
            System.out.println("n: " + n);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.add(r.nextInt(n));
            System.out.println("avl random build : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(i);
            System.out.println("avl ordered access : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(nextGaussian(r, n));
            System.out.println("avl gaussian access : " + (System.currentTimeMillis() - startTime));

            System.out.println();

        }

        System.out.println("Ordered build SplayTree SplayTree SplayTree SplayTree ");
        // ordered Splay

        for (int n = start; n < start + 10 * step; n += step) {

            SplayTree splay = new SplayTree();
            System.out.println("n: " + n);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                splay.add(i);
            System.out.println("splay ordered build : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                splay.search(i);
            System.out.println("splay ordered access : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                splay.search(nextGaussian(r, n));
            System.out.println("splay gaussian accese : " + (System.currentTimeMillis() - startTime));

            System.out.println();

        }

        System.out.println("Random build SplayTree SplayTree SplayTree SplayTree ");
        // random Splay
        for (int n = start; n < start + 10 * step; n += step) {

            SplayTree splay = new SplayTree();
            System.out.println("n: " + n);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                splay.add(r.nextInt(n));
            System.out.println("splay random build : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                splay.search(i);
            System.out.println("splay ordered access : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                splay.search(nextGaussian(r, n));
            System.out.println("splay gaussian access : " + (System.currentTimeMillis() - startTime));

            System.out.println();

        }
    }
}