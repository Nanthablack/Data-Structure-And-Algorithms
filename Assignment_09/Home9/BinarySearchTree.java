import java.lang.*;

class BinarySearchTree {
    class TreeNode {
        int data;
        TreeNode left = null, right = null, parent = null;

        public TreeNode(int d) {
            data = d;
        }
    }

    TreeNode root = null;

    TreeNode search(int d) {
        return search(d, root);
    }

    void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode p = root;
            while (p != null) {
                if (d < p.data) {
                    if (p.left != null)
                        p = p.left;
                    else {
                        p.left = new TreeNode(d);
                        p.left.parent = p;
                        return;
                    }
                } else {
                    if (p.right != null)
                        p = p.right;
                    else {
                        p.right = new TreeNode(d);
                        p.right.parent = p;
                        return;
                    }
                }
            }
        }
    }

    void delete(int d) {
        delete(d, root);
    }

    TreeNode search(int d, TreeNode node) {
        if (node == null)
            return null;
        if (d == node.d)
            return node;
        if (d < node.d)
            return search(d, node.left);
        return search(d, node.right);
    }

    void delete(int d, TreeNode node) {
        if (node == null)
            return;
        if (d < node.d)
            delete(d, node.left);
        else if (d > node.d)
            delete(d, node.right);
        else {
            if ((node.left == null) || (node.right == null)) {
                TreeNode q = (node.left == null) ? node.right : node.left;
                if (node.parent.left == node)
                    node.parent.left = q;
                else
                    node.parent.right = q;
                if (q != null)
                    q.parent = node.parent;
            } else {
                TreeNode q = findMax(node.left);
                delete((int) q.d, node.left);
                if (node.parent.left == node)
                    node.parent.left = q;
                else
                    node.parent.right = q;
                q.left = node.left;
                q.right = node.right;
            }
        }
    }

    TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}

class DataTableBST {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("First set of data");
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Number\t\t\tN\t\t\ttime");
        int count = 1;
        int N = 10000;
        for (int j = 0; j < 10; j += 1) {

            long start = System.currentTimeMillis();

            for (int i = 1; i < N; i++) {
                bst.insert(i);

            }

            long time = (System.currentTimeMillis() - start);

            System.out.print(count + "\t\t\t");
            System.out.print(N);
            System.out.println("\t\t\t" + time);
            N = N + 10000;
            count++;
        }

        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Second set of data");
        System.out.println("Number\t\t\tN\t\t\ttime\t\t\tN1 * Math.random()");
        int count1 = 1;
        int N1 = 10000;
        int[] a = new int[10];
        for (int j = 0; j < 10; j += 1) {

            long start1 = System.currentTimeMillis();

            for (int i = 0; i < N1; i++) {
                a[j] = (int) (N1 * Math.random());
                bst.insert((int) (a[j]));

            }

            long time1 = (System.currentTimeMillis() - start1);
            System.out.print(count1 + "\t\t\t");
            System.out.print(N1);
            System.out.print("\t\t\t" + time1);
            System.out.println("\t\t\t" + a[j]);
            N1 += 10000;
            count1++;
        }

        System.out.println();
    }
}
