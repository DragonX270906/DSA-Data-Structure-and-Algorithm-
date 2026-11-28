// Simple circular doubly linked list.
// The last node connects to the first node, in both directions.
public class CircularDoublyLinkedList {
    private static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void add(int number) {
        Node newNode = new Node(number);

        if (head == null) {
            head = newNode;
            head.next = newNode;
            head.previous = newNode;
            return;
        }

        Node tail = head.previous;

        newNode.next = head;
        newNode.previous = tail;
        tail.next = newNode;
        head.previous = newNode;
    }

    public void delete(int number) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        do {
            if (current.data == number) {
                if (current.next == current) {
                    head = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;

                    if (current == head) {
                        head = current.next;
                    }
                }
                return;
            }

            current = current.next;
        } while (current != head);

        System.out.println(number + " not found");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        System.out.print("Forward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node tail = head.previous;
        Node current = tail;
        System.out.print("Backward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.previous;
        } while (current != tail);

        System.out.println("(back to tail)");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);

        list.displayForward();
        list.displayBackward();

        list.delete(20);
        list.displayForward();
    }
}
