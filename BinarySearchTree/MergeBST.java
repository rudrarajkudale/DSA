package BinarySearchTree;

import java.util.ArrayList;

public class MergeBST {
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

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static Node buildBST(ArrayList<Integer> merge, int si, int end){
        if(si > end){
            return null;
        }

        int mid = (si + end)/2;
        Node root = new Node(merge.get(mid));
        root.left = buildBST(merge, si, mid-1);
        root.right = buildBST(merge, mid+1, end);
        return root;
    }

    public static Node mergeBST(Node root1, Node root2){

        //get inorder of both trees
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        inorder(root1 , arr1);
        inorder(root2, arr2);

        //merge inorder and sort it
        ArrayList<Integer> merge = new ArrayList<>();
        int i=0, j=0;
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                merge.add(arr1.get(i));
                i++;
            }
            else{
                merge.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()){
            merge.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            merge.add(arr2.get(j));
            j++;
        }


        //build bst
        Node root = buildBST(merge, 0, merge.size()-1);
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
    public static void main(String[] args)
    {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preorder(root);
    }

}
