package kernel;

/**
 *
 * Representa un par de datos x, dof para realizar los calculos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 20-10-2015
 *
 */
public class Node
{

    private float x;

    private int dof;

    /**
     * Constructor
     *
     * @param x
     * @param dof
     */
    public Node(float x, int dof)
    {
        this.x = x;
        this.dof = dof;
    }

    /**
     * Retorna el valor X
     *
     * @return X
     */
    public float getX()
    {
        return this.x;
    }

    /**
     * Retorna el valor dof
     *
     * @return dof
     */
    public int getDof()
    {
        return this.dof;
    }
}
