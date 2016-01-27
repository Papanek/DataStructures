package lists;

/**
 * ******************************
 * Project: Data Structures
 * Creator: Daniel Papanek
 * Date :   1/26/2016
 * ******************************
 **/
abstract class AbstractList<Type> {

    // common class node for all lists
    protected class Node {
        Type data;
        Node next;

        Node(Type data) {
            this.data = data;
            this.next = null;
        }

        Node(Type data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public abstract boolean isEmpty();
}