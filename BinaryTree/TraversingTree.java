package BinaryTree;

import java.util.*;

public class TraversingTree {
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

    public static void printPreorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void printInorder(Node root){
        if(root == null){
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void printPostorder(Node root){
        if(root == null){
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");   
    }

    public static void printLevelorder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root  = bt.buildBinaryTree(nodes);

        System.out.print("The Preorder Sequence is: ");
        printPreorder(root);
        System.out.println();
        System.out.print("The Inorder Sequence is: ");
        printInorder(root);
        System.out.println();
        System.out.print("The Postorder Sequence is: ");
        printPostorder(root);
        System.out.println();
        System.out.println("The Levelorder Sequence is: ");
        printLevelorder(root);
    }
}

