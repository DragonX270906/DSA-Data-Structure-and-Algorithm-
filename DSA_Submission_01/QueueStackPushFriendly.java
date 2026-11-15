import java.util.LinkedList;
import java.util.Queue;


public class QueueStackPushFriendly {
    private Queue<Integer> items = new LinkedList<>();

    public void push(int number) {
        items.offer(number);
    }

    public int pop() {
        if (items.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int count = items.size();
        for (int i = 1; i < count; i++) {
            items.offer(items.poll());
        }
        return items.poll();
    }

    public int peek() {
        if (items.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int count = items.size();
        for (int i = 1; i < count; i++) {
            items.offer(items.poll());
        }
        int result = items.peek();
        items.offer(items.poll());
        return result;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();
        stack.push(5);
        stack.push(15);
        stack.push(25);

        System.out.println("Removed: " + stack.pop());
        System.out.println("Top item: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }
}
