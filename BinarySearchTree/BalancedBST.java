package BinarySearchTree;

//we have to create a BST of minimum height
public class BalancedBST {
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

    static Node balancedBuildBST(int val[], int si, int end){
        if(si > end){
            return null;
        }

        int mid = (si + end)/2;
        Node root = new Node(val[mid]);
        root.left = balancedBuildBST(val, si, mid-1);
        root.right = balancedBuildBST(val, mid+1, end);

        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = {3,5,6,8,10,11,12};

        Node root = balancedBuildBST(values, 0, values.length-1);
        preorder(root);
    }
}
