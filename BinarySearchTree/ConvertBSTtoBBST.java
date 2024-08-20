package BinarySearchTree;

import java.util.ArrayList;

//we have to covert BST to balanced BST
public class ConvertBSTtoBBST {
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

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static Node buildBBST(ArrayList<Integer> arr, int si, int end){
        if(si > end){
            return null;
        }

        int mid = (si + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = buildBBST(arr, si, mid-1);
        root.right = buildBBST(arr, mid+1, end);
        return root;
    }

    public static Node returnBST(Node root){
        if(root == null){
            return null;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        root = buildBBST(arr, 0, arr.size()-1);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = returnBST(root);
        preorder(root);
    }
}
