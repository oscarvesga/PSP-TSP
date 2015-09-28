package kernel;

/**
 *
 * Nodo de la lista para cargar los datos a consultar
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 27-08-2015
 */
public class Node
{

    private float num;

    private Node next;

    /**
     * Constructor
     */
    public void Node()
    {
    }

    /**
     * Cambia el numero para hacer calculos
     * @param num flotante
     */
    public void setNum(float num)
    {
        this.num = num;
    }

    /**
     * Retorna el numero actual del nodo
     * @return float
     */
    public float getNum()
    {
        return num;
    }

    /**
     * Cambia el nodo siguiente de nodo actual
     * @param next Node
     */
    public void setNext(Node next)
    {
        this.next = next;
    }

    /**
     * Retorna el nodo siguiente del nodo actual
     * @return Node
     */
    public Node getNext()
    {
        return next;
    }
}
