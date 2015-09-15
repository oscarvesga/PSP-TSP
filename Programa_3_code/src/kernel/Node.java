package kernel;

/**
 *
 * Nodo que representa los datos basicos de la lista
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 01-09-2015
 *
 */
public class Node {

    private float x;

    private float y;

    private Node next;

    /**
     * Constructor
     * @param x 
     * @param y
     */
    public Node(float x, float y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

    /**
     * Retorna el valor X del nodo
     * @return X
     */
    public float getX() {
        return this.x;
    }

    /**
     * Retorna el valor Y del nodo
     * @return Y
     */
    public float getY() {
        return this.y;
    }

    /**
     * Retorna el valor X elevado al cuadrado
     * @return X*X
     */
    public float getX2() {
        return this.x * this.x;
    }

    /**
     * Retorna el valor X multiplicado por Y
     * @return X*Y
     */
    public float getXY() {
        return this.x * this.y;
    }

    /**
     * Retorna el valor Y elevado al cuadrado
     * @return Y*Y
     */
    public float getY2() {
        return this.y * this.y;
    }

    /**
     * Retorna el nodo siguiente
     * @return Node
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * Cambia el nodo siguiente 
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
