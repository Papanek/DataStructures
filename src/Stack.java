/**
 * Created by Daniel on 1/21/2016.
 */
public class Stack<Type> {
    private class Node {
        private Type data;
        private Node next;

        Node(Type data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int length;

    public Stack() {
        head = null;
        length = 0;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public Type peek() {
        return head.data;
    }

    public Type pop() {
        Type data = head.data;
        head = head.next;
        length--;
        return data;
    }

    public void push(Type data) {
        head = new Node(data, head);
        length++;
    }

    public int search(Type data) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                break;
            }
            current = current.next;
            index++;
        }
        if (index >= length) {
            return -1;
        } else {
            return index;
        }
    }
}
