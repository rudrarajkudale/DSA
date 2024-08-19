package BinaryTree;

public class LCA2 {
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

    public static Node findLCA(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;
    }
    public static void main(String[] args)
    {
        //main tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(findLCA(root,4,5).data);
    }
}
