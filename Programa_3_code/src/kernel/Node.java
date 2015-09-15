package kernel;

public class Node {

    private float x;

    private float y;

    private Node next;

    public Node(float x, float y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getX2() {
        return this.x * this.x;
    }

    public float getXY() {
        return this.x * this.y;
    }

    public float getY2() {
        return this.y * this.y;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
