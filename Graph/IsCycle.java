package Graph;

    import java.util.*;

//Check if cycle is present
class IsCycle{
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
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }

    public static boolean isCycle(ArrayList<Edge> graph[], boolean vis[], boolean rec[], int curr){
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            else if(!vis[e.dest] && isCycle(graph, vis, rec, e.dest)){
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                boolean iscycle = isCycle(graph, vis, rec, i);
                if(iscycle){
                    System.out.println("Cycle is present");
                    break;
                }
            }
        }
    }
}
    
