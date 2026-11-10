public class Edge {
    public final Node from;
    public final Node to;
    public final double weight;

    public Edge(Node from, Node to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return from + "->" + to + "(" + weight + ")"; //prints directed connection from one node to another
    }
}
