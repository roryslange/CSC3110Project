package javaImplementation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Graph graph = new Graph();
        ArrayList<char[]> cycles = new ArrayList<>();
        char[] cycle1 = {'C', 'E'};
        char[] cycle2 = {'A', 'B', 'D'};
        cycles.add(cycle1);
        cycles.add(cycle2);

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

        //System.out.println("C -> E cycle: " + graph.calculateCycle(cycles.get(0)));
        //System.out.println("A -> B -> D cycle: " + graph.calculateCycle(cycles.get(1)));

        //graph.removeNode('A');
        //graph.print();

        removeSmallestCycles(graph, cycles);
        graph.print();

    }

    static void removeSmallestCycles(Graph g, ArrayList<char[]> cycles) {
        int smallestCycle = Integer.MAX_VALUE;
        ArrayList<char[]> ToRemove = new ArrayList<>();

        //calculate cycles
        for (char[] cycle : cycles) {
            if (g.calculateCycle(cycle) <= smallestCycle) {
                ToRemove.add(cycle);
                smallestCycle = g.calculateCycle(cycle);
            }
        }

        System.out.println("smallest cycle(s): " + String.valueOf(ToRemove.get(0)));
        System.out.println("Cycle Length: " + smallestCycle);

        for (char[] cycle : ToRemove) {
            //remove cycles
            g.removeCycle(cycle);
        }
    }



}
