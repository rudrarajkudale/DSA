package Graph;

import java.util.*;

//This method is only for acyclic directed graphs
public class TopologicalSort {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologySortUtil(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> s, int curr){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topologySortUtil(graph, vis, s, e.dest);
            }
        }

        s.push(curr);
    }

    public static void topologySort(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                topologySortUtil(graph, vis, s, i);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topologySort(graph, V);
    }
}
