package mylinkedlist;

public class MyLinkedList {
    private Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
    }
}
