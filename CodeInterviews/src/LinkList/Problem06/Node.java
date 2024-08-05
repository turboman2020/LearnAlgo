package CodeInterviews.src.LinkList.Problem06;

public class Node{
    int value;
    Node next;
    public Node() {};
    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
    public int getValue(){return this.value;}
    public Node getNext() {return this.next;}

}
