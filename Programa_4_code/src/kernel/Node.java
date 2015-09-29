package kernel;

/**
 *
 * Nodo que representa los datos basicos de la lista
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 29-09-2015
 *
 */
public class Node
{

    private double x;

    private Node next;

    /**
     * Constructor
     *
     * @param x
     * @param y
     */
    public Node(double x, double y)
    {
        this.x = x/y;        
        this.next = null;
    }

    /**
     * Retorna el valor X del nodo
     *
     * @return X
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * Retorna el valor Y del nodo
     *
     * @return Y
     */
    public double getlnX()
    {
        return Math.log(this.x);
    }

    /**
     * Retorna el nodo siguiente
     *
     * @return Node
     */
    public Node getNext()
    {
        return this.next;
    }

    /**
     * Cambia el nodo siguiente
     *
     * @param next
     */
    public void setNext(Node next)
    {
        this.next = next;
    }
}
