
public class UnboundedArrayStack {
    private int[] data;
    private int count;

    public UnboundedArrayStack() {
        data = new int[2];
        count = 0;
    }

    public void push(int number) {
        if (count == data.length) {
            changeCapacity(data.length * 2);
        }
        data[count] = number;
        count++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        count--;
        int removed = data[count];

        // Reduce the array when only one quarter is being used.
        if (data.length > 2 && count <= data.length / 4) {
            changeCapacity(Math.max(2, data.length / 2));
        }
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return data[count - 1];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int capacity() {
        return data.length;
    }

    private void changeCapacity(int newSize) {
        int[] biggerOrSmaller = new int[newSize];
        for (int i = 0; i < count; i++) {
            biggerOrSmaller[i] = data[i];
        }
        data = biggerOrSmaller;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        stack.push(35);
        stack.push(45);

        System.out.println("Current size: " + stack.size());
        System.out.println("Array capacity: " + stack.capacity());
        System.out.println("Top item: " + stack.peek());

        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("New size: " + stack.size());
        System.out.println("New capacity: " + stack.capacity());
    }
}
