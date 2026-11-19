
import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueueDequeueFriendly {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public StackQueueDequeueFriendly() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    // Enqueue - Add an element to the queue
    public void enqueue(int value) {
        stack1.push(value);
        System.out.println(value + " added to queue");
    }

    // Dequeue - Remove the front element
    public int dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek - View the front element
    public int peek() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Return the number of elements
    public int size() {
        return stack1.size() + stack2.size();
    }

    // Display queue elements in FIFO order
    public void display() {
        System.out.print("Queue: ");

        for (int value : stack2) {
            System.out.print(value + " ");
        }

        Deque<Integer> temp = new ArrayDeque<>(stack1);

        while (!temp.isEmpty()) {
            System.out.print(temp.removeLast() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        queue.display();
    }
}
