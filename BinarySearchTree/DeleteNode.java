package BinarySearchTree;

public class DeleteNode {
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
    
    static Node findSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    static Node deleteNode(Node root, int key){
        if (root == null) {
            return null;
        }
        if(root.data > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.data < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            //if have no child
            if(root.left == null && root.right == null){
                return null;
            }
            
            //having one child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //having 2 childs
            //first find inorder successor
            Node succ = findSuccessor(root.right);
            //replace data
            root.data = succ.data;
            //delete successor node
            root.right = deleteNode(root.right, succ.data);
        }
        return root;
    }

    static boolean searchBST(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        else if(root.data > key){
            return searchBST(root.left, key);
        }
        else{
            return searchBST(root.right, key);
        }
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = buildBST(root, values[i]);
        }

        System.out.println(searchBST(root, 6));
        deleteNode(root, 6);
        System.out.println(searchBST(root, 6));
    }
}
