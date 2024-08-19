package BinaryTree;

public class MinDistBetwNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node LCA(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;
    }

    public static int lcaDist(Node lca, int n){
        if(lca == null){
            return -1;
        }
        if(lca.data == n){
            return 0;
        }

        int left = lcaDist(lca.left, n);
        int right = lcaDist(lca.right, n);

        if(left == -1 && right == -1){
            return -1;
        }
        else if(left == -1){
            return right + 1;
        }
        else{
            return left + 1;
        }
    }
    public static int minDist(Node root, int n1, int n2){
        Node lca = LCA(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(minDist(root,4,6));

    }
}
