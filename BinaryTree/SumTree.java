package BinaryTree;

public class SumTree {
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

    public static void preorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }

        int left = sumTree(root.left);
        int right = sumTree(root.right);

        int data = root.data;
        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data = left + right + newleft + newright;
        return data;

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

        sumTree(root);
        preorder(root);
    }

}
