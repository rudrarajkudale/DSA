package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//remove all cycles and find minimum edges to build MST(minimum spanning tree)
//MST should be - Undirected , Connected , Weighted
public class PrismAlgo {
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
        
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 3, 50));
    }

    //create class Which store nodes and minimum distance of each edge
    static class Pair implements Comparable<Pair>{
        int node;
        int count;
        Pair(int n, int c){
            node = n;
            count = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.count - p2.count;
        }
    }

    public static void Prism(ArrayList<Edge> graph[], int V){
        //Use priority queue to get minimum distance when remove
        PriorityQueue<Pair> q = new PriorityQueue<>();
        //store MST edges in arraylist
        ArrayList<Edge> pairs = new ArrayList<>();
        boolean vis[] = new boolean[V];

        q.add(new Pair(0, 0));
        int count = 0;

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            //if not visited make it vsited and add count
            if(!vis[curr.node]){
                vis[curr.node] = true;
                count += curr.count;
            }
            for(int i=0; i<graph[curr.node].size(); i++){
                Edge e = graph[curr.node].get(i);
                if(!vis[e.dest]){
                    q.add(new Pair(e.dest, e.wt));
                    pairs.add(new Edge(e.src, e.dest, e.wt));
                }

            }
        }

        int printcount = 0;
        for(Edge e : pairs){
            System.out.println(e.src + "," + e.dest);
            printcount += e.wt;
            if(printcount == count){
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        Prism(graph, V);
    }
}
