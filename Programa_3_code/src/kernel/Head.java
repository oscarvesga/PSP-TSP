package kernel;

/**
 *
 * Cabeza de la lista simplemente encadenada
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 01-09-2015
 *
 */
public class Head {

    private Node first;

    private Node last;

    private int length;

    /**
     * Constructor
     */
    public Head() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    /**
     * Retorna el primer elemento de la lista
     * @return
     */
    public Node getFirst() {
        return this.first;
    }

    /**
     * Retorna el ultimo elemento de la lista
     * @return
     */
    public Node getLast() {
        return this.last;
    }

    /**
     * Cambia el primer elemento de la lista
     * @param first
     */
    public void setFirst(Node first) {
        this.first = first;
    }

    /**
     * Cambia el ultimo elemento de la lista
     * @param last
     */
    public void setLast(Node last) {
        this.last = last;
    }

    /**
     * Retorna el tamaño de la lista
     * @return
     */
    public int size() {
        int size = 0;
        
        Node first = this.first;        
        while (first != null){
            size++;
            first = first.getNext();
        }
        
        return size;
    }
    
    /**
     * Retorna en formato String todos los elementos de la lista
     * @return 
     */
    public String toString(){
        String result = "";
        
        Node first = this.first;        
        while (first != null){
            result += "X = "+first.getX() + "\n";
            result += "Y = "+first.getY() + "\n";
            result += "X2 = "+first.getX2() + "\n";
            result += "XY = "+first.getXY() + "\n";
            result += "Y2 = "+first.getY2() + "\n";
            
            first = first.getNext();
        }
        
        return result;
    }
}
