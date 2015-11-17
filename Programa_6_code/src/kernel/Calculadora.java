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
     *
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
     *
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
     *
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
     *
     * @param data datos para calcular el valor T
     * @return retorna una lista de valores T asociados a la lista de datos data
     */
    public ArrayList calcularT(ArrayList data)
    {
        ArrayList result = new ArrayList();

        for (int i = 0; i < data.size(); i++) {
            Node node = (Node) data.get(i);
            double t = 1.0d;
            double d = 0.5d;

            double p1 = 0.0d;
            double p2 = 0.5d;
            double err = 0.0d;
            do {
                p1 = node.getX();
                p2 = funcionP(t, node.getDof(), this.num_seg);
                if (p1 - p2 > 0) {
                    t = t + d;                    
                } else {
                    d = d / 2;
                    t = t - d;                    
                }

                p2 = funcionP(t, node.getDof(), this.num_seg);                                
                err = p1 - p2;
                if (err < 0) {
                    err = err * -1;
                }
            } while (err >= this.error);

            double rest = t;
            result.add(rest);
        }

        return result;
    }
}
