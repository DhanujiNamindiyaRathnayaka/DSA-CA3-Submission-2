
public class DoublyLinkedList {

    // Node class
    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
        System.out.println(data + " added at beginning");
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
        System.out.println(data + " added at end");
    }

    // Remove first
    public int removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        int removedData = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return removedData;
    }

    // Remove last
    public int removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }

        int removedData = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return removedData;
    }

    // Search
    public boolean search(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Display forward
    public void displayForward() {
        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Main method
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.displayForward();
        list.displayBackward();

        list.addFirst(5);
        list.displayForward();

        System.out.println("Removed first: " + list.removeFirst());
        list.displayForward();

        System.out.println("Removed last: " + list.removeLast());
        list.displayForward();
        list.displayBackward();

        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 100: " + list.search(100));
        System.out.println("List size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
    }
}
