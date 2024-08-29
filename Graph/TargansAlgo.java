package Graph;

import java.util.ArrayList;

//Find the bridge of the graph
public class TargansAlgo {
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
        
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void DFS(ArrayList<Edge> graph[], boolean vis[], int dt[], int low[], int time, int curr, int par){
        //Make current vis true and increase time
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        //check for every edge of curr
        for(Edge e : graph[curr]){
            //if dest is parent then continue
            if(e.dest == par){
                continue;
            }
            //if not visited then call DFS for it
            else if(!vis[e.dest]){
                DFS(graph, vis, dt, low, time, e.dest, curr);
                //comapre low time while backtrack and get minimum
                low[curr] = Math.min(low[curr], low[e.dest]);
                //if low of e.dest is greater than dt of curr then its a bridge
                if(dt[curr] < low[e.dest]){
                    System.out.println("The bridge is:" + curr + "," + e.dest);
                }
            }
            //otherwise compare dt time of e.dest and low of curr
            else{
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    //create 2 arrays of dt and low
    public static void TarjansAlgo(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];

        //pass all nodes to DFS
        for(int i=0; i<V; i++){
            if(!vis[i]){
                DFS(graph, vis, dt, low, 0, i, -1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        TarjansAlgo(graph, V);
    }
}
