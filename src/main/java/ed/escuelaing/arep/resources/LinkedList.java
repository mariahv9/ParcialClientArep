package ed.escuelaing.arep.resources;

/**
 * Class that implements linked list
 * @author Maria Hernandez
 */
public class LinkedList {
    public Node head;
    double sum = 0;
    int size = 0;

    /**
     * Method that verifies if the head of the list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Method that inserts on the head of the list
     * @param number float to insert
     */
    public void insertHead(double number) {
        Node newHead = new Node();
        newHead.number = number;
        newHead.next = head;
        head = newHead;
    }

    /**
     * Method that inserts on the tail of the list
     * @param number float to insert
     */
    public void insertTail(double number) {
        Node now = head;
        Node newTail = new Node();
        newTail.number = number;

        if (head == null){
            head = newTail;
        }
        else{
            while (now.next != null) {
                now = now.next;
            }
            now.next = newTail;
        }
    }

    /**
     * Method that deletes the head of the list
     * @return Node to replace
     */
    public Node deleteHead() {
        Node replace = head;
        head = head.next;
        return replace;
    }

    /**
     * Method that deletes the head of the list
     * @param last to delete
     */
    public void deleteTail(Node last) {
        Node replace = head;
        while (replace.next != null && replace.number != last.number) {
            replace = replace.next;
        }
        if (replace.next != null) replace.next = replace.next.next;
    }

    /**
     * Method that prints the final linked list
     */
    public void printLinked() {
        Node now = head;
        while (now != null) {
            now.printNode();
            now = now.next;
        }
        System.out.println();
    }

    /**
     * Method that returns the size of the linked list
     * @return int size of the list
     */
    public int size() {
        Node now = head;
        size = 0;
        while (now != null) {
            size++;
            now = now.next;
        }
        return size;
    }

    /**
     * Method that returns the sum of all the values on the linked list
     * @return double total sum
     */
    public double sumList() {
        Node now = head;
        sum = 0;
        while (now != null) {
            sum = sum + now.number;
            now = now.next;
        }
        return sum;
    }

    /**
     * Method that does sum of the potence less the data's mean
     * @return double number of sum
     */
    public double sumDev() {
        double m = sum / size;
        double sumD = 0;
        Node now = head;
        double newnum = 0;
        while (now != null){
            newnum = Math.pow((now.number - m), 2);
            sumD = sumD + newnum;
            now = now.next;
        }
        return sumD;
    }
}