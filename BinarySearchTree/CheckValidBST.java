package BinarySearchTree;

import java.util.ArrayList;

//we check is BST valid or not by checcking inroder is sorted or not
public class CheckValidBST {
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

    static Node buildBST(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = buildBST(root.left, val);
        }
        else{
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static boolean isValidBST(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);

       for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i) > arr.get(i+1)){
                return false;
            }
       }
       return true;
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = buildBST(root, values[i]);
        }

        System.out.println(isValidBST(root));
    }
}
