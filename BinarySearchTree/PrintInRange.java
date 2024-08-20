package BinarySearchTree;

public class PrintInRange {
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

    public static void printInRange(Node root, int n1, int n2){
        if(root == null){
            return;
        }
        if(root.data >= n1 && root.data <= n2 ){
            printInRange(root.left, n1, n2);
            System.out.print(root.data + " ");
            printInRange(root.right, n1, n2);
        }
        else if(root.data > n1){
            printInRange(root.left, n1, n2);
        }
        else{
            printInRange(root.right, n1, n2);
        }
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = buildBST(root, values[i]);
        }

        printInRange(root, 4, 10);
    }
}
