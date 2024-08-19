package BinaryTree;

import java.util.*;

public class TopView {
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

    static class Info{
        //horizontal distance 
        int hd;
        Node node;
        Info(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }

    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        int min=0, max=0;
        q.add(new Info(0, root));

        while(!q.isEmpty()){
            Info curr = q.remove();
            
            if(!hm.containsKey(curr.hd)){
                hm.put(curr.hd, curr.node);
            }

            if(curr.node.left != null){
                q.add(new Info(curr.hd-1, curr.node.left));
                min = Math.min(min, curr.hd-1);
            }

            if(curr.node.right != null){
                q.add(new Info(curr.hd+1, curr.node.right));
                max = Math.max(max, curr.hd+1);
            }
        }

        //Print the top view
        for(int i=min; i<=max; i++){
            System.out.print(hm.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        topView(root);
    }
}
