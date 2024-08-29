package Graph;

import java.util.ArrayList;

//have to find the vertex
//if delete then graph will split into parts
//same as targans algo
public class ArticulationPoint {
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

        graph[4].add(new Edge(4, 3));
    }

    public static void DFS(ArrayList<Edge> graph[], int dt[], int low[], boolean vis[],
                            boolean at[], int time, int curr, int par){

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;  
        int children = 0;
        for(Edge e : graph[curr]){
            if(e.dest == par){
                continue;
            }
            else if(vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
            else{
                DFS(graph, dt, low, vis, at, time, e.dest, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if(par != -1 && dt[curr] <= low[e.dest]){
                    at[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1){
            at[curr] = true;
        }
    }

    public static void Articulation(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean at[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                DFS(graph, dt, low, vis, at, 0, i, -1);
            }
        }

        for(int i=0; i<V; i++){
            if(at[i]){
                System.out.println("The articulation point is: " + i);
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        Articulation(graph, V);
    }
}
