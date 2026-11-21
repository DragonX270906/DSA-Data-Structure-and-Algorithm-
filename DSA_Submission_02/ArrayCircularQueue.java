// Queue implemented using a fixed-size circular array.
public class ArrayCircularQueue {
    private int[] data;
    private int front;
    private int rear;
    private int count;

    public ArrayCircularQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int number) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % data.length;
        data[rear] = number;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removed = data[front];
        front = (front + 1) % data.length;
        count--;
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return data[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < count; i++) {
            System.out.print(data[(front + i) % data.length] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Removed: " + queue.dequeue());
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Shows circular reuse of an empty position.
        queue.display();

        System.out.println("Front item: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}
