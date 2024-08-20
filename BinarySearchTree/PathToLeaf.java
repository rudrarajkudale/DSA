package BinarySearchTree;

import java.util.ArrayList;

//create a function to find the paths of all leaf nodes from root.
public class PathToLeaf {
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

    public static void pathToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        
        pathToLeaf(root.left, path);
        pathToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = buildBST(root, values[i]);
        }

        pathToLeaf(root, new ArrayList<>());
    }
}
