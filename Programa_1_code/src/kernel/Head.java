package kernel;

/**
 *
 * Lista simplemente encadenada que crea la estructura de los datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 27-08-2015
 */
public class Head
{

    private Node first;

    private Node last;

    /**
     * Constructor
     */
    public void Head()
    {
        this.first = null;
        this.last = null;
    }

    /**
     * Cambia el primer nodo de la lista
     * @param first primer nodo
     */
    public void setFirst(Node first)
    {
        this.first = first;
    }

    /**
     * Cambia el ultimo nodo de la lista
     * @param last ultimo nodo
     */
    public void setLast(Node last)
    {
        this.last = last;
    }

    /**
     * Retorna el primer nodo de la lista
     * @return Node
     */
    public Node getFirst()
    {
        return first;
    }

    /**
     * Retorna el ultimo nodo de la lista
     * @return Node
     */
    public Node getLast()
    {
        return last;
    }
}
