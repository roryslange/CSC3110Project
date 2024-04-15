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

    //removes a edge to node from all lists
    private void removeEdgeAllLists(char src) {
        for (LinkedList<Node> list : alist) {
            for (Node node : list) {
                if (node.data == src) {
                    list.remove(node);
                }
            }
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
            //System.out.println("add: " + getDistance(currentList, nextChar));
        }

        return sum;
    }

    //only works for letters and assumes graphs are represented in alphabetical order
    public void removeNode(char src) { 
        LinkedList<Node> temp = new LinkedList<>(); 
        for (LinkedList<Node> list : alist) {
            if (list.get(0).data == src) {
                temp = list;
            }
        }
        alist.remove(temp);
    }

    public void removeCycle(char[] cycle) {
        for (char current : cycle) {
            removeNode(current);
            removeEdgeAllLists(current);
        }
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
