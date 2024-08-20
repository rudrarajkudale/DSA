package BinarySearchTree;


//it is second way of checking th bst is valid or not
//we are using min max variables
public class CheckValidBST2 {
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

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = buildBST(root, values[i]);
        }

        System.out.println(isValidBST(root, null, null));
    }
}
