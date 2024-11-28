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
            deleteFirst();
        }
        Node temp = head;
        Node previous = null;
        while(temp.getNext() != null){
            previous = temp;
            temp = temp.getNext();
        }
        previous.setNext(null);
    }

    public void delete(int index){
        if (index == 0) {
            deleteFirst();
        } else if (index == length() - 1){
            deleteLast();
        } else {
            Node preNode = head;
            for (int i = 1; i <= index; i++){
                preNode = preNode.getNext();
            }
            preNode.setNext(preNode.getNext().getNext());
        }
    }

    public void deleteWhile(int index){
        if (index == 0) {
            deleteFirst();
        } else if (index == length() - 1){
            deleteLast();
        } else {
            Node temp = head;
            int count = 0;
            while (count < index - 1){
                temp = temp.getNext();
                count++;
            }
            Node nodeToDelete = temp.getNext();
            temp.setNext(nodeToDelete.getNext());
        }
    }

    public boolean search(int data){
        if (head == null){
            return false;
        }
        Node temp = head;
        while (temp != null){
            if (temp.getData() == data){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public Node searchAtPosition(int index){
        if (index < 0 || index >= length()){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public void sort(){
        if (head == null || head.getNext() == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;
            while (temp != null && temp.getNext() != null) {
                if (temp.getData() > temp.getNext().getData()) {
                    int tempData = temp.getData();
                    temp.setData(temp.getNext().getData());
                    temp.getNext().setData(tempData);
                    swapped = true;
                }
                temp = temp.getNext();
            }
        } while (swapped);
    }

    public void sortAtPosition(int start, int end){
        if (start > end || end < 0 || start < 0){
            return;
        }
        Node temp = head;
        int i = 0;
        while (i < start){
            temp = temp.getNext();
            i++;
        }
        while (i < end){
            Node temp2 = temp.getNext();
            while (temp2 != null){
                if (temp.getData() > temp2.getData()){
                    int tempData = temp.getData();
                    temp.setData(temp2.getData());
                    temp2.setData(tempData);
                }
                temp2 = temp2.getNext();
            }
            temp = temp.getNext();
            i++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.add(6,2);

        System.out.println("Do dai cua danh sach: "+ linkedList.length());

        System.out.print("Danh sach duoc hien thi: ");
        linkedList.display();

        boolean found = linkedList.search(4);
        if (found) {
            System.out.println("Dữ liệu tìm thấy.");
        } else {
            System.out.println("Không tìm thấy dữ liệu.");
        }

        Node nodeAtPosition = linkedList.searchAtPosition(1);
        if (nodeAtPosition != null) {
            System.out.println("Phan tu tai vi tri can tim la: " + nodeAtPosition.getData());
        } else {
            System.out.println("Khong tim thay phan tu tai vi tri do.");
        }

//        linkedList.sort();
//        System.out.print("Danh sach da duoc sort: ");
//        linkedList.display();

        linkedList.sortAtPosition(1,3);
        System.out.print("da sort: ");
        linkedList.display();

        linkedList.deleteWhile(2);
        System.out.print("Danh sach da xoa: ");
        linkedList.display();

        linkedList.delete(2);
        System.out.print("Danh sach da xoa: ");
        linkedList.display();

        linkedList.deleteFirst();
        System.out.print("Danh sach da xoa phan tu dau: ");
        linkedList.display();

        linkedList.deleteLast();
        System.out.print("Danh sach da xoa phan tu cuoi: ");
        linkedList.display();

    }
}
