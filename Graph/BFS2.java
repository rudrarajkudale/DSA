package Graph;


import java.util.*;

//This is BFS for DisJoined Graph
public class BFS2 {

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
        //for 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        //for 2
        graph[2].add(new Edge(2, 1));
        //for 3
        graph[3].add(new Edge(3, 4));
        //for 4 
        graph[4].add(new Edge(4, 3));

        /*  Graph 1
              0 - 1 - 2

            Graph 2
              3 - 4
         */
    }

    public static void BFSsearch(ArrayList<Edge> graph[], int V, boolean vis[], int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while(!q.isEmpty()){
            int v = q.remove();

            if(!vis[v]){
                System.out.print(v + " ");
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
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                BFSsearch(graph, V, vis, i);
            }
        }
        
    }
}
        
