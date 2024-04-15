package javaImplementation;

public class Main {

    public static void main(String[] args) {
        
        Graph graph = new Graph();
        char[] cycle = {'C', 'E'};

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, new Node('B', 18));
        graph.addEdge(0, new Node('C', 14));
        graph.addEdge(0, new Node('E', 16));
        graph.addEdge(1, new Node('C', 2));
        graph.addEdge(1, new Node('D', 10));
        graph.addEdge(2, new Node('E', 6));
        graph.addEdge(3, new Node('A', 3));
        graph.addEdge(3, new Node('C', 15));
        graph.addEdge(3, new Node('E', 11));
        graph.addEdge(4, new Node('C', 17));

        graph.print();

        System.out.println("C -> E cycle: " + graph.calculateCycle(cycle));






    }
    
}
