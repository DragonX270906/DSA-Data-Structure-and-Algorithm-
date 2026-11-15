import java.util.Stack;

// 
public class StackQueueEnqueueFriendly {
    private Stack<Integer> incoming = new Stack<>();
    private Stack<Integer> outgoing = new Stack<>();

    public void enqueue(int number) {
        incoming.push(number);
    }

    private void moveItemsIfNeeded() {
        if (outgoing.isEmpty()) {
            while (!incoming.isEmpty()) {
                outgoing.push(incoming.pop());
            }
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        moveItemsIfNeeded();
        return outgoing.pop();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        moveItemsIfNeeded();
        return outgoing.peek();
    }

    public boolean isEmpty() {
        return incoming.isEmpty() && outgoing.isEmpty();
    }

    public int size() {
        return incoming.size() + outgoing.size();
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Front item: " + queue.peek());
        queue.enqueue(35);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Queue size: " + queue.size());
    }
}
