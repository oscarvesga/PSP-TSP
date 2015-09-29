package kernel;

/**
 *
 * Cabeza de la lista simplemente encadenada
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 29-09-2015
 *
 */
public class Head
{

    private Node first;

    private Node last;

    private int length;

    /**
     * Constructor
     */
    public Head()
    {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    /**
     * Agrega un nuevo nodo a la lista
     * @param x - numerador
     * @param y - denominador
     */
    public void addNode(double x, double y)
    {
        Node last = new Node(x, y);
        if (this.last == null) {
            this.first = last;
            this.last = last;
        } else {
            this.last.setNext(last);
            this.last = last;            
        }
        
        this.length++;
    }
    
    /**
     * Retorna el primer elemento de la lista
     *
     * @return
     */
    public Node getFirst()
    {
        return this.first;
    }

    /**
     * Retorna el ultimo elemento de la lista
     *
     * @return
     */
    public Node getLast()
    {
        return this.last;
    }

    
    /**
     * Retorna el tamaño de la lista
     *
     * @return
     */
    public int size()
    {
        return this.length;
    }

    /**
     * Retorna en formato String todos los elementos de la lista
     *
     * @return
     */
    public String toString()
    {
        String result = "";
        int count = 0;

        Node first = this.first;
        while (first != null) {
            count++;
            result += count+" X = " + first.getX() + "\n";
            result += count+" Log_X = " + first.getlnX()+ "\n";                        

            first = first.getNext();
        }

        return result;
    }
}
