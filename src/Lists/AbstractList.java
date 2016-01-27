package lists;

/**
 * ******************************
 * Project: Data Structures
 * Creator: Daniel Papanek
 * Date :   1/26/2016
 * ******************************
 **/
abstract class AbstractList<Type> {
    class Node {
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
}