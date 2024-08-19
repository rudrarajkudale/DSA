package BinaryTree;


//Time Complexity O(n^2)
public class DiameterOfTree {
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

    static class BinaryTree{
        static int idx = -1;

        Node buildBinaryTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newnode = new Node(nodes[idx]);
            newnode.left = buildBinaryTree(nodes);
            newnode.right = buildBinaryTree(nodes);

            return newnode;
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }


    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }

        int left = diameterOfTree(root.left);
        int right = diameterOfTree(root.right);
        int throughroot = height(root.left) + height(root.right) + 1;

        return Math.max(left, Math.max(right, throughroot));
    }
    public static void main(String[] args)
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        System.out.println(diameterOfTree(root));
    }
}
