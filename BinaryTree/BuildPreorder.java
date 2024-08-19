package BinaryTree;

//The preider sequence is given. Build tree from that
public class BuildPreorder {
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

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root  = bt.buildBinaryTree(nodes);

        System.out.println("The root is: " + root.data);
        System.out.println("root leftchild is: " + root.left.data);
        System.out.println("root rightchild is: " + root.right.data);
    }
}
