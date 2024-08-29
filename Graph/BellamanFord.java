package Graph;

import java.util.ArrayList;

//It finds shortest path from src to all nodes
//It is dynamic prog algo
//This algorithm can also find shortest path among negative distances 
//But not work for negative cycles
public class BellamanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void Ford(ArrayList<Edge> graph[], int  src, int V)
    {
        int dist[] = new int[V];

        for(int i=0; i<V; i++){
            if(i != src)
            dist[i] = Integer.MAX_VALUE;
        }

        //We have to run loop v-1 times to make sure ans is correct
        for(int i=0; i<V-1; i++){
            //run loop for every edge
            for(int j=0; j<V; j++){
                for(Edge e : graph[j]){
                    int u = e.src;
                    int v = e.dest;
                    //find minimum distance
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        //So check if the negative cycle is present - run loop more one time
        //run loop for every edge
        for(int j=0; j<V; j++){
            for(Edge e : graph[j]){
                int u = e.src;
                int v = e.dest;
                //find minimum distance
                if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]){
                    System.out.println("Negative cycle is present");
                    return;
                }
            }
        }

        for(int i=0; i<V; i++){
            System.out.print(dist[i] + " ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        Ford(graph, 0, V);
    }
}

