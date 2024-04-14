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
    
    public void addEdge(int src, int dst) {
        LinkedList<Node> currentlList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);
        currentlList.add(dstNode);

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

    private void removeNode(Node node) {
        
    }

    public void print() {
        for (LinkedList<Node> currentList : alist) {
            for (Node node : currentList) {
                System.out.print(node.data + " ->");
            }
            System.out.println();
        }
    }
}
