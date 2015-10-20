package kernel;

public class Node {

    private float x;

    private int dof;

    public Node(float x, int dof) {
        this.x = x;
        this.dof = dof;
    }

    public float getX() {
        return this.x;
    }

    public int getDof() {
        return this.dof;
    }
}
