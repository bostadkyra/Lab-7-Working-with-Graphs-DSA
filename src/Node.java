//represents vertices in graph
public class Node {
    private final String label;
    private final int index; //unique index for matrix

    public Node(String label, int index){
        this.label = label;
        this.index = index;
    }

    public String getLabel(){
        return label;
    }

    public int getIndex(){
        return index;
    }

    @Override
    public String toString(){
        return label; //if node is directly printed this will print its label
    }
}
