package Graph;

import java.util.ArrayList;

//Adjecency List
//Create a graph Using an Array of ArrayList and Print the neighbours
//It is unweighted graph
public class CreateGraph1 {
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
        graph[0].add(new Edge(0, 2));
        //for 1
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        //for 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        //for 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.print(2 + "->");
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
                System.out.print(e.dest + "->");
        }
    }
}

