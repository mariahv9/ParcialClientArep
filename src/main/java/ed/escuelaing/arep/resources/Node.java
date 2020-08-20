package ed.escuelaing.arep.resources;

/**
 * Class node belongs to linked list
 * @author Maria Hernandez
 */
public class Node {
    public double number;
    public Node next;

    /**
     * Method that shows number's node
     */
    public void printNode () {
        System.out.println("{" + number +"}");
    }
}