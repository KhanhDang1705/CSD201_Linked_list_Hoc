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

    public void add(int data, int index){
        Node newNode = new Node(data);
        if (index == 0){
            addFirst(data);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++){
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(nextNode);
        }
    }

    public int length(){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            if (temp.getNext() != null){
                System.out.print("->");
            }
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void deleteFirst(){
        if (head != null) {
            head = head.getNext();
        }
    }

    public void deleteLast(){
        if(head == null){
            return;
        }
        if(head.getNext() == null){
            head = null;
            return;
        }
        Node temp = head;
        while (temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(null);
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.add(6,1);

        System.out.println("Do dai cua danh sach: "+ linkedList.length());

        System.out.print("Danh sach duoc hien thi: ");
        linkedList.display();

        linkedList.deleteFirst();
        System.out.print("Danh sach da xoa phan tu dau: ");
        linkedList.display();

        linkedList.deleteLast();
        System.out.print("Danh sach da xoa phan tu cuoi: ");
        linkedList.display();

    }
}
