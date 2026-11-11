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

    public void print() {
        final int LABEL_W = 4; // width of the row-label column
        final int COL_W = 6; // width of every data column

        System.out.println("Adjacency Matrix:");

        StringBuilder header = new StringBuilder(" ".repeat(LABEL_W)); // Header: blank space the same width as the row labels, then each label

        for (Node n : nodes) {
            header.append(String.format("%" + COL_W + "s", n.getLabel()));
        }
        System.out.println(header);

        for (Node row : nodes) {
            StringBuilder sb = new StringBuilder(String.format("%-" + LABEL_W + "s", row.getLabel()));
            for (int j = 0; j < nodes.size(); j++) {
                sb.append(String.format("%" + COL_W + ".1f", matrix[row.getIndex()][j]));
            }
            System.out.println(sb);
        }
    }
}
