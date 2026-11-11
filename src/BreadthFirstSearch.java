import java.util.*;

public class BreadthFirstSearch {

    public static List<Node> search(AdjacencyList g, Node start){
        return bfs(start, g::getNeighbors); //:: passes the getNeighbors method of the object g as a function argument into bfs method
    }

    public static List<Node> search (AdjacencyMatrix g, Node start){
        return bfs(start, g::getNeighbors);
    }

    private static List<Node> bfs(Node start, java.util.function.Function<Node, List<Edge>> neighbors){ //.Function lets you reuse bfs for different graph types
        List<Node> order = new ArrayList<>();
        Set<Node> visited = new HashSet<>(); //set used because no duplicates (only need to know if it was visited or not)
        Queue<Node> queue = new LinkedList<>(); //note a queue is used for bfs (dfs uses a stack representation)
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            order.add(cur);
            for (Edge e:neighbors.apply(cur)){
                if (visited.add(e.to)){
                    queue.add(e.to);
                }
            }
        }
        return order;
    }
}
