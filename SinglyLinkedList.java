
public class SinglyLinkedList {

    // Node class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    // Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // Add element at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        size++;

        System.out.println(data + " added at beginning");
    }

    // Add element at the end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        System.out.println(data + " added at end");
    }

    // Remove first element
    public int removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        int removedData = head.data;
        head = head.next;
        size--;

        return removedData;
    }

    // Remove last element
    public int removeLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (head.next == null) {
            int removedData = head.data;
            head = null;
            size--;
            return removedData;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        int removedData = current.next.data;
        current.next = null;
        size--;

        return removedData;
    }

    // Search for a value
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

    // Display list
    public void display() {
        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Check whether list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Get list size
    public int size() {
        return size;
    }

    // Main method
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.display();

        list.addFirst(5);
        list.display();

        System.out.println("Removed first: " + list.removeFirst());
        list.display();

        System.out.println("Removed last: " + list.removeLast());
        list.display();

        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 100: " + list.search(100));

        System.out.println("List size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
    }
}
