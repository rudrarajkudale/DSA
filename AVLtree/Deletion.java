package AVLtree;

public class Deletion {
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



    // FOR Deletion
    //get inorder successor
    public static Node inorderSucc(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    //function to delete Node
    public static Node delNode(Node root, int key){
        if(root == null){
            return root;
        }
        //check where the deletio happen
        if(key < root.data){
            root.left = delNode(root.left, key);
        }
        else if(key > root.data){
            root.right = delNode(root.right, key);
        }
        else{
            //to delete Node with no child or one child
            Node temp = null;
            if(root.left == null || root.right == null){
                if(root.left == null){
                    temp = root.right;
                }
                else{
                    temp = root.left;
                }
                //for no child
                if(temp == null){
                    return null;
                }
                //for one child
                else{
                    root = temp;
                }
            }
            else{
                //for two child
                //find inorder successor
                temp = inorderSucc(root.right);
                //replace data
                root.data = temp.data;
                //now delete inorder successor
                root.right = delNode(root.right, temp.data);
            }
        }

        //Now after deleting the Node check balanced factor
        //find the height of root
        root.height = Math.max(getheight(root.left), getheight(root.right)) + 1;

        //find the balnced factor of Node
        int bf = getBalanceFactor(root);

        //now check if tree is balnced or not
        //if not balanced then balance it
        
        //LL case
        if(bf > 1 && getBalanceFactor(root.left) >= 0){
            return rightRotate(root);
        }
        
        //RR case
        if(bf < -1 && getBalanceFactor(root.right) <= 0){
            return leftRotate(root);
        }

        //LR case
        if(bf > 1 && getBalanceFactor(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL case
        if(bf < -1 && getBalanceFactor(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //If tree is balanced return root
        return root;
    }
    public static void main(String[] args){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);
        delNode(root, 30);
        System.out.println();
        preorder(root);
    }
}