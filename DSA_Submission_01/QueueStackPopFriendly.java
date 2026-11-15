import java.util.LinkedList;
import java.util.Queue;

// Stack using two queues
public class QueueStackPopFriendly {
    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> helperQueue = new LinkedList<>();

    public void push(int number) {
        helperQueue.offer(number);

        while (!mainQueue.isEmpty()) {
            helperQueue.offer(mainQueue.poll());
        }

        Queue<Integer> oldQueue = mainQueue;
        mainQueue = helperQueue;
        helperQueue = oldQueue;
    }

    public int pop() {
        if (mainQueue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return mainQueue.poll();
    }

    public int peek() {
        if (mainQueue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return mainQueue.peek();
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public int size() {
        return mainQueue.size();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        stack.push(5);
        stack.push(15);
        stack.push(25);

        System.out.println("Removed: " + stack.pop());
        System.out.println("Top item: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }
}
