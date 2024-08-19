package BinaryTree;

public class CheckSubtree {
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

    public static boolean isIdentical(Node node, Node subnode){
        if(node == null && subnode == null){
            return true;
        }

        if(node == null || subnode == null || node.data != subnode.data){
            return false;
        }

        if(!isIdentical(node.left, subnode.left)){
            return false;
        }

        if(!isIdentical(node.right, subnode.right)){
            return false;
        }
        return true;
    }

    public static boolean checkSubtree(Node root, Node subroot){
        if(root == null){
            return false;
        }

        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
            return false;
        }

        return checkSubtree(root.left, subroot) || checkSubtree(root.right, subroot);
    }

    public static void main(String[] args)
    {
        //main tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        //subtree
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        //checking
        System.out.println(checkSubtree(root, subroot));
    }

}
