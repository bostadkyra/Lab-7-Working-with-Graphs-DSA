import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    //uses Maps like examples in class
    //uses constructor for LinkedHashMaps so nodes are kept in the order they were first seen
    private final Map<String, Node> nodes = new LinkedHashMap<>();
    private final Map<Node, List<Edge>> adj = new LinkedHashMap<>();


    //returns existing node or creates then returns the created node
    public Node addNode(String label){
        Node n = nodes.get(label);
        if (n == null){
            n = new Node(label, nodes.size());
            nodes.put(label, n);
            adj.put(n, new ArrayList<>());
        }
        return n;
    }

    private boolean hasEdge(Node a, Node b){
        for (Edge e:adj.get(a)){
            if (e.to == b){
                return true;
            }
        }
        return false;
    }

    //ignores duplicates
    public void addEdge(String from, String to, double weight){
        Node a = addNode(from);
        Node b = addNode(to);
        if (!hasEdge(a, b)){
            adj.get(a).add(new Edge(a, b, weight));
        }
        if (!hasEdge(b, a)){
            adj.get(b).add(new Edge(b, a, weight));
        }
    }

    public Node getNode(String label){
        return nodes.get(label);
    }

    public List<Node> getNodes(){
        return new ArrayList<>(nodes.values());
    }

    public List<Edge> getNeighbors(Node n){
        return adj.get(n);
    }

    public void print(){
        System.out.println("Adjacency List:");
        for (Node n:adj.keySet()){ //.keySet() extracts just the keys in adj
            StringBuilder sb = new StringBuilder(n + " -> ");
            for(Edge e:adj.get(n)){
                sb.append(e.to).append("(").append(e.weight).append(") ");
                System.out.println(sb.toString().trim());
            }
        }
    }
}
