// Simple singly linked list.
public class SinglyLinkedList {
    private static class Node {
        int data;
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
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void delete(int number) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == number) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != number) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(number + " not found");
        } else {
            current.next = current.next.next;
        }
    }

    public boolean search(int number) {
        Node current = head;
        while (current != null) {
            if (current.data == number) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.display();

        System.out.println("Is 20 found? " + list.search(20));
        list.delete(20);
        list.display();
    }
}
