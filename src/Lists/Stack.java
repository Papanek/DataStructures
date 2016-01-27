package lists;

/**
 * ******************************
 * Project: Data Structures
 * Creator: Daniel Papanek
 * Date :   1/21/2016
 * ******************************
 **/
public class Stack<Type> extends AbstractList<Type> {

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
