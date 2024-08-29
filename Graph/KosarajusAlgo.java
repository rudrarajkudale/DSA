package Graph;

import java.util.ArrayList;
import java.util.Stack;

//In this we have to find the components which has only one path
//Means find SSC - dtrongly connected component only for Directed graph
public class KosarajusAlgo {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topoSort(ArrayList<Edge> graph[], Stack<Integer> s, boolean vis[], int curr){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoSort(graph, s, vis, e.dest);
            }
        }
        s.push(curr);
    }

    public static void DFS(ArrayList<Edge> graph[], boolean vis[], int curr){
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                DFS(graph, vis, e.dest);
            }
        }
    }


    @SuppressWarnings("unchecked")
    public static void KosarajuAlgo(ArrayList<Edge> graph[], int V){
       //Step 1 - we have to perform topological sorting
       Stack<Integer> s = new Stack<>();
       boolean vis[] = new boolean[V];
       for(int i=0; i<V; i++){
            if(!vis[i]){
                topoSort(graph, s, vis, i);
            }
       }

       //step 2 - we hae to transpose graph
       // for that we just reverse all the edges
       ArrayList<Edge> transpose[] = new ArrayList[V];
       for(int i=0; i<graph.length; i++){
        transpose[i] = new ArrayList<>();
        vis[i] = false;
        }

        for(int i=0; i<V; i++){
            for(Edge e : graph[i]){
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step 3 - perform DFS according to Stack topologically sorted
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                DFS(transpose, vis, curr);
                System.out.println();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        KosarajuAlgo(graph, V);
    }

}
