package BinaryTree;

public class SumOfNodes {
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

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left+ right + root.data;
    }
    public static void main(String[] args)
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        System.out.println(sumOfNodes(root));
    }
}
