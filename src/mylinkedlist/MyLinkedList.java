package mylinkedlist;

public class MyLinkedList {
    private Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
    }
}
