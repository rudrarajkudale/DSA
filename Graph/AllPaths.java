package Graph;

import java.util.*;

public class AllPaths {
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

    public static void allPaths(ArrayList<Edge> graph[], boolean vis[], int curr, int tar, String path){
        if(curr == tar){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                allPaths(graph, vis, e.dest, tar, path+e.dest);
                vis[curr] = false;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis[] = new boolean[V];
      
        allPaths(graph, vis, 0, 5, "0");
    }
}
