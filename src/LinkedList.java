/**
 * Created by Daniel on 1/21/2016.
 */
public class LinkedList<Type> {
    protected class Node {
        private Type data;
        private Node next;

        Node(Type data) {
            this.data = data;
            this.next = null;
        }

        Node(Type data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    public int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public void print() {
        print(head);
    }

    private void print(Node start) {
        if (start == null) {
            System.out.println("n length = " + length);
            return;
        }
        System.out.print(start.data + " | ");
        print(start.next);
    }

    public void reversePrint() {
        reversePrint(head);
    }

    private void reversePrint(Node start) {
        if (start == null) {
            System.out.print("n");
            return;
        }
        reversePrint(start.next);
        System.out.print(" | " + start.data);
    }

    public void prepend(Type data) {
        head = new Node(data, head);
        length++;
    }

    public void append(Type data) {
        if (head == null) {
            prepend(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        length++;
    }

    public void insert(Type data, int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Index must be in 0..length-1");
        }
        if (index == 0) {
            prepend(data);
            return;
        }
        Node current = head;
        Node previous = null;
        while (index-- > 0) {
            previous = current;
            current = current.next;
        }
        previous.next = new Node(data, current);
        length++;
    }

    public void remove(Type data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            removeFirst();
            return;
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
            if (current.data == data) {
                previous.next = current.next;
                length--;
                return;
            }
        }
    }

    public void removeAll(Type data) {
        while (head != null && head.data == data) {
            removeFirst();
        }
        if (head != null) {
            Node current = head;
            Node previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
                if (current.data == data) {
                    while (current.next != null && current.next.data == data) {
                        current = current.next;
                        length--;
                    }
                    previous.next = current.next;
                    length--;
                }
            }
        }
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Index must be in 0..length-1");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        Node previous = null;
        while (index-- > 0) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        length--;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        length--;
    }

    public int indexOf(Type data) {
        if (head == null) {
            return -1;
        }
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

    public void reverseList() {
        reverseList(head);
    }

    private void reverseList(Node node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            head = node;
            return;
        }
        reverseList(node.next);
        node.next.next = node;
        node.next = null;
    }
}
