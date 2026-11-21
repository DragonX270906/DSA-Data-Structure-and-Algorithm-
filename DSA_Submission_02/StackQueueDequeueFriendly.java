import java.util.Stack;

// Queue using two stacks: dequeue is fast (O(1)).
public class StackQueueDequeueFriendly {
    private Stack<Integer> items = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    // Move old items away, add the new item, then restore them.
    // This keeps the oldest item on top of the main stack.
    public void enqueue(int number) {
        while (!items.isEmpty()) {
            helper.push(items.pop());
        }

        items.push(number);

        while (!helper.isEmpty()) {
            items.push(helper.pop());
        }
    }

    public int dequeue() {
        if (items.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return items.pop();
    }

    public int peek() {
        if (items.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return items.peek();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Front item: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}
