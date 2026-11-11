import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix {
    private final List<Node> nodes;
    private final double[][] matrix;

    public AdjacencyMatrix(List<Node> nodes){
        this.nodes = new ArrayList<>(nodes);
        this.matrix = new double[nodes.size()][nodes.size()]; //nxn matrix
    }

    public void addEdge(Node a, Node b, double weight){
        matrix[a.getIndex()][b.getIndex()] = weight;
        matrix[b.getIndex()][a.getIndex()] = weight;
    }

    public boolean hasEdge(Node a, Node b){
        return matrix[a.getIndex()][b.getIndex()] != 0; //returns false if location in matrix equals 0
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public List<Edge> getNeighbors(Node n){
        List<Edge> result = new ArrayList<>();
        for (int j = 0; j < nodes.size(); j++){
            double w = matrix[n.getIndex()][j];
            if(w != 0){
                result.add(new Edge(n, nodes.get(j),w));
            }
        }
        return result;
    }

    public void print(){
        System.out.println("Adjacency Matrix:");
        StringBuilder header = new StringBuilder("  ");
        for (Node n:nodes){
            header.append(String.format("%5s, n")); //%5s right aligns with a minimum field width of 5 characters
        }
        System.out.println(header);
        for (Node row:nodes){
            StringBuilder sb = new StringBuilder(String.format("%-5s", row)); //%- left aligns the string value
            for (int j = 0; j < nodes.size(); j++){
                sb.append(String.format("%5.1f", matrix[row.getIndex()][j])); //%5.1f sets field to 5 width and sets floating number to 1 decimal place
            }
            System.out.println(sb);
        }
    }
}
