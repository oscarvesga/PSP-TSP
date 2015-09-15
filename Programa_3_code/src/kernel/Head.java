package kernel;

public class Head {

    private Node first;

    private Node last;

    private int length;

    public Head() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Node getFirst() {
        return this.first;
    }

    public Node getLast() {
        return this.last;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int size() {
        int size = 0;
        
        Node first = this.first;        
        while (first != null){
            size++;
            first = first.getNext();
        }
        
        return size;
    }
    
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
