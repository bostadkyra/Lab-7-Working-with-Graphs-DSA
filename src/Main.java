import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String path;

        while (true){
            System.out.println("Enter the graph file name (ex: graph.txt): ");
            path = in.nextLine().trim();
            if (new File(path).isFile()){
                break; //breaks while loop if file name is a valid file
            }
            System.out.println("Could not find " + path + ". Please try again.");
        }

        ReadFile reader = new ReadFile(path);
        AdjacencyList list = reader.getAdjacencyList();
        AdjacencyMatrix matrix = reader.getAdjacencyMatrix();

        System.out.println();
        list.print();
        System.out.println();
        matrix.print();
        System.out.println();

        Node start = list.getNodes().get(0); //first node in file
        List<Node> fromList = BreadthFirstSearch.search(list,start);
        List<Node> fromMatrix = BreadthFirstSearch.search(matrix, start);
        System.out.println("Breadth-First Search from " + start + " (adjacency list): " + fromList);
        System.out.println("Breadth-First Search from " + start + " (adjacency matrix): " + fromMatrix);
    }
}
