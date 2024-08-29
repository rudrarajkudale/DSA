package Graph;

import java.util.*;
import java.util.LinkedList;

//This is BFS for Joined Graph
public class BFS {

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
        //for 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        //for 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        //for 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        //for 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        //for 4 
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        //for 5
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        //for
        graph[6].add(new Edge(6, 5));

        /*  Graph
                1 - 3
                /    | \
            0     |  5 - 6
                \    | /
                2 - 4
            */
    }

    public static void BFSsearch(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int v = q.remove();

            if(!vis[v]){
                System.err.print(v + " ");
                vis[v] = true;
                for(int i=0; i<graph[v].size(); i++){
                    Edge e = graph[v].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        BFSsearch(graph, V);
    }
}
    
