package javaImplementation;
import java.util.*;

public class Graph {
    ArrayList<LinkedList<Node>> alist;

    Graph() {
        alist = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentlList = new LinkedList<>();
        currentlList.add(node);
        alist.add(currentlList);
    }
    
    public void addEdge(int src, Node dst) {
        LinkedList<Node> currentlList = alist.get(src);
        currentlList.add(dst);

    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> currentlList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);

        for(Node node : currentlList) {
            if (node == dstNode) {
                return true;
            }
        }
        return false;
    }

    private LinkedList<Node> getNodeList(char src) {
        for (LinkedList<Node> current : alist) {
            if (current.get(0).data == src) {
                return current;
            }
        }

        return null;
    }

    private int getDistance(LinkedList<Node> list, char src) {
        for (Node n : list) {
            if (n.data == src) {
                return n.weight;
            }
        }
        
        return Integer.MAX_VALUE; //cannot find node return large num
    }

    private void removeEdge(int src, int dst) {
        LinkedList<Node> currentList = alist.get(src);
        LinkedList<Node> otherCurrentList = alist.get(dst);
        Node dstNode = alist.get(dst).get(0);
        Node otherDstNode = alist.get(src).get(0);
        if (checkEdge(src, dst)) {
            currentList.remove(dstNode);
            otherCurrentList.remove(otherDstNode);
        }
    }

    public int calculateCycle(char[] cycle) {
        int sum = 0;
        LinkedList<Node> currentList;
        char currentChar, nextChar;
        for (int i = 0; i < cycle.length; i++) {
            if (i == cycle.length - 1) {
                currentChar = cycle[i];
                nextChar = cycle[0];
            }
            else {
                currentChar = cycle[i];
                nextChar = cycle[i+1];
            }
            currentList = getNodeList(currentChar);
            sum += getDistance(currentList, nextChar);
            System.out.println("add: " + getDistance(currentList, nextChar));
        }

        return sum;
    }

    private void removeNode(Node node) {

    }

    public void print() {
        for (LinkedList<Node> currentList : alist) {
            for (Node node : currentList) {
                System.out.print(node.data + "|" + node.weight + " -> ");
            }
            System.out.println();
        }
    }
}
