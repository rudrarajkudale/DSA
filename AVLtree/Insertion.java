package AVLtree;

public class Insertion {
    static class Node{
        int data, height;
        Node left, right;
        Node(int data){
            this.data = data;
            this.height = 1;
        }
    }
    public static Node root;

    //find height of the tree
    public static int getheight(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    public static int getBalanceFactor(Node root){
        if(root == null){
            return 0;
        }
        return getheight(root.left) - getheight(root.right);
    }

    //Rotate to left
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        y.height = Math.max(getheight(y.left), getheight(y.right)) + 1;
        x.height = Math.max(getheight(x.left), getheight(x.right)) + 1;

        return y;
    }

    //Rotate to right
    public static Node rightRotate(Node x){
        Node y = x.left;
        Node z = y.right;

        y.right = x;
        x.left = z;

        y.height = Math.max(getheight(y.left), getheight(y.right)) + 1;
        x.height = Math.max(getheight(x.left), getheight(x.right)) + 1;

        return y;
    }


    public static Node insert(Node root, int key){
        //check where key will insert
        if(root == null)
            root = new Node(key);
        else if(key < root.data)
            root.left = insert(root.left, key);
        else if(key > root.data)
            root.right = insert(root.right, key);
        //if duplicate dont insert
        else
            return root;

        
        //find the height of root
        root.height = Math.max(getheight(root.left), getheight(root.right)) + 1;

        //find the balnced factor of Node
        int bf = getBalanceFactor(root);

        //now check if tree is balnced or not
        //if not balanced then balance it
        
        //LL case
        if(bf > 1 && key < root.left.data){
            return rightRotate(root);
        }
        
        //RR case
        if(bf < -1 && key > root.right.data){
            return leftRotate(root);
        }

        //LR case
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL case
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //If tree is balanced return root
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
    public static void main(String[] args){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);
    }

}
