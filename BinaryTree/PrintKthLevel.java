package BinaryTree;

import java.util.*;

//It is Done By using Level Order Traversal
public class PrintKthLevel {
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

    public static void printKthLevel(Node root, int level){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        int k = 1;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    return;
                }else{ 
                    k++;
                    if(k > level){
                        break;
                    }
                    q.add(null);
                }
            }
            else{
                if(k == level){
                    System.out.print(curr.data + " ");
                }
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printKthLevel(root, 3);
    }
}
