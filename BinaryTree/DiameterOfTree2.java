package BinaryTree;


//Time Complexity = O(N)
public class DiameterOfTree2 {
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

    static class TreeInfo{
        int height;
        int diam;

        TreeInfo(int height, int diam){
            this.height = height;
            this.diam = diam;
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

    public static TreeInfo diameterOfTree(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);

        int myheight = Math.max(left.height, right.height) + 1;

        int leftdiam = left.diam;
        int rightdiam = right.diam;
        int throughroot = left.height + right.height + 1;;

        int mydiam = Math.max(leftdiam, Math.max(rightdiam, throughroot));
        return new TreeInfo(myheight, mydiam);
    }
    public static void main(String[] args)
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        TreeInfo t = diameterOfTree(root);
        System.out.println(t.diam);
    }
}
