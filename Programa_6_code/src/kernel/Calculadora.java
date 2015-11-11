package kernel;

import java.util.ArrayList;

/**
 *
 * Calculadora de datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 11-11-2015
 *
 */
public class Calculadora
{

    private final int num_seg;

    private final double error;
    
    /**
     * Constructor
     */
    public Calculadora()
    {
        this.num_seg = 10;
        this.error = 0.0000001;
    }
    
    /**
     * Calcula el coeficiente Gamma
     * @param xi 
     * @return el coeficiente Gamma
     */
    public double funcionGamma(float xi)
    {
        if (xi == 1) {
            return 1;
        } else if (xi == 0.5) {
            return Math.sqrt(Math.PI);
        } else {
            return (xi - 1) * funcionGamma(xi - 1);
        }
    }

    /**
     * Calcula la funcion F 
     * @param xi segmento a caluclar
     * @param dof grados de libertad 
     * @return 
     */
    public double funcionF(double xi, int dof)
    {
        double result1 = funcionGamma((dof + 1) / 2f);
        result1 = result1 / (Math.pow(dof * Math.PI, 1 / 2f) * funcionGamma(dof / 2f));
        double result2 = 1 + (xi * xi / dof);
        result2 = Math.pow(result2, -(dof + 1) / 2f);

        return result1 * result2;
    }

    /**
     * Calcula la funcion P 
     * @param x 
     * @param dof grados de libertad
     * @param num_seg numero de segmentos de la función
     * @return 
     */
    public double funcionP(double x, int dof, int num_seg)
    {
        double result = 0;
        double w = x / num_seg;

        for (int i = 1; i < num_seg; i++) {
            if (i % 2 == 0) {
                result += 2 * funcionF(w * i, dof);
            } else {
                result += 4 * funcionF(w * i, dof);
            }
        }

        double suma = funcionF(0, dof) + result + funcionF(x, dof);
        return suma * w / 3;
    }

    /**
     * Calcula el valor T teniendo en cuenta el error E
     * @param data datos para calcular el valor T
     * @return retorna una lista de valores T asociados a la lista de datos data
     */
    public ArrayList calcularT(ArrayList data)
    {
        ArrayList result = new ArrayList();

        for (int i = 0; i < data.size(); i++) {
            Node node = (Node) data.get(i);
            double p1 = funcionP(node.getX(), node.getDof(), this.num_seg);
            double p2 = funcionP(node.getX(), node.getDof(), 2 * this.num_seg);

            int j = 2 * this.num_seg;
            while (p1 - p2 >= this.error) {
                p1 = funcionP(node.getX(), node.getDof(), j);
                p2 = funcionP(node.getX(), node.getDof(), j * 2);
                j = j * 2;
            }

            double rest = p2;
            result.add(rest);
        }

        return result;
    }
}
