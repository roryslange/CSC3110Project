package javaImplementation;

public class Node {
    char data;
    int weight = -1;

    Node(char data) {
        this.data = data;
        //this.weight = 0;
    }

    Node (char data, int weight) {
        this. data = data;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
