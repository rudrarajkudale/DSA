package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//It finds shortest path from src to all nodes
//It is greedy algo
//Djkstras Aglo Only word for Positive edges
public class DjkstrasAlgo {
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
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    //Create One priority queue which sorts based on distance
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int n, int d){
            node = n;
            dist = d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void Djkastras(ArrayList<Edge> graph[], int V, int src){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        //to store all th distances
        int dist[] = new int[V];
        boolean vis[] = new boolean[V];

        //intialize with Max values for comparison
        for(int i=0; i<V; i++){
            //dont intialize source node 
            if(i != src)
            dist[i] = Integer.MAX_VALUE;
        }

        //add source node
        q.add(new Pair(0, 0));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            //if curr node not visited 
            if(!vis[curr.node]){
                //then make it visited
                vis[curr.node] = true;
                //check for edges of current node
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    //find the minimun distance 
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    } 
                    //add new pair of e.dest and wieght in queue
                    q.add(new Pair(v, dist[v]));
                }
            }
        }

        //Print all distance
        for(int i=0; i<V; i++){
            System.out.print(dist[i] + " ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        Djkastras(graph, V, 0);
    }
}
