package kernel;

/**
 *
 * Calculadora de Datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 23-11-2015
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
     * retorna la sumatoria de todos los valores X
     *
     * @param data lista de datos (x, y)
     * @return sum(X)
     */
    private float getX(Head data)
    {
        float result = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getX();
            first = first.getNext();
        }

        return result;
    }

    /**
     * Retorna la sumatoria de todos los valores Y
     *
     * @param data lista de datos x, y
     * @return sum(Y)
     */
    private float getY(Head data)
    {
        float result = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getY();
            first = first.getNext();
        }

        return result;
    }

    /**
     * Calcula el promedio X de los datos
     *
     * @param data lista de datos x, y
     * @return promedio X
     */
    public float getXavg(Head data)
    {
        float result = 0;
        int size = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getX();
            size++;
            first = first.getNext();
        }

        return result / size;
    }

    /**
     * Calcula el promedio Y de los datos
     *
     * @param data lista de datos x, y
     * @return promedio Y
     */
    public float getYavg(Head data)
    {
        float result = 0;
        int size = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getY();
            size++;
            first = first.getNext();
        }

        return result / size;
    }

    /**
     * retorna la sumatoria de todos los valos X elevados al cuadrado
     *
     * @param data lista de datos (x, y)
     * @return sum(X*X)
     */
    public float getX2(Head data)
    {
        float result = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getX2();
            first = first.getNext();
        }

        return result;
    }

    /**
     * Retorna la sumatoria de todos los X multiplicados por Y
     *
     * @param data lista de datos (x, y)
     * @return sum(X*Y)
     */
    public float getXY(Head data)
    {
        float result = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getXY();
            first = first.getNext();
        }

        return result;
    }

    /**
     * Retorna la sumatoria de todos los Y elevados al cuadrado
     *
     * @param data lista de datos (x, y)
     * @return sum(Y*Y)
     */
    public float getY2(Head data)
    {
        float result = 0;

        Node first = data.getFirst();
        while (first != null) {
            result += first.getY2();
            first = first.getNext();
        }

        return result;
    }

    /**
     * Calcula el parametro B0 de una regresion lineal
     *
     * @param data lista de datos (x, y)
     * @return B0
     */
    public float calcularB0(Head data)
    {
        float result = 0;

        float Yavg = getYavg(data);
        float Xavg = getXavg(data);
        float B1 = calcularB1(data);

        result = Yavg - B1 * Xavg;

        return result;
    }

    /**
     * Calcula el factor B1 de una regresion lineal
     *
     * @param data lista de datos (x, y)
     * @return B1
     */
    public float calcularB1(Head data)
    {
        float result = 0;
        int n = data.size();
        float Xavg = getXavg(data);
        float Yavg = getYavg(data);
        float XY = getXY(data);
        float X2 = getX2(data);

        result = XY - (n * Xavg * Yavg);
        result = result / (X2 - (n * Xavg * Xavg));

        return result;
    }

    /**
     * Calcula el factor de correlación R de un grupo de datos
     *
     * @param data lista de datos (x, y)
     * @return R
     */
    public double calcularR(Head data)
    {
        int n = data.size();
        float X = getX(data);
        float Y = getY(data);
        float XY = getXY(data);
        float X2 = getX2(data);
        float Y2 = getY2(data);

        float result1 = n * XY - X * Y;
        double result2 = ((n * X2) - (X * X)) * ((n * Y2) - (Y * Y));
        result2 = Math.sqrt(result2);

        return result1 / result2;
    }

    /**
     * Calcula el indice de correlación al cuadrado de una lista de datos
     *
     * @param data lista de datos (x, y)
     * @return R*R
     */
    public double calcularR2(Head data)
    {
        double r = calcularR(data);
        return r * r;
    }

    /**
     * Calcula la Proyección de un programa segun una lista de datos
     *
     * @param data - lista de datos (x, y)
     * @param proxyE - Tamaño aproximado del Programa
     * @return P
     */
    public float calcularP(Head data, float proxyE)
    {
        float B0 = calcularB0(data);
        float B1 = calcularB1(data);

        return B0 + B1 * proxyE;
    }

    /**
     * Calcula la significancia de los datos
     *
     * @param data
     * @param proxyE
     * @return
     */
    double calcularSignificancia(Head data)
    {
        double r = this.calcularR(data);
        double r2 = r * r;
        int n = data.size();

        double t = (r * Math.sqrt(n - 2)) / Math.sqrt(1 - r2);
        double p = this.findProbP(t, n - 2);

        return 1 - (2 * p);
    }

    /**
     * Calcula el valor P teniendo en cuenta el error E
     *
     * @param data
     * @param t
     * @return
     */
    private double findProbP(double t, int dof)
    {
        double p1 = funcionP(t, dof, this.num_seg);
        double p2 = funcionP(t, dof, 2 * this.num_seg);

        int j = 2 * this.num_seg;
        while (p2 - p1 >= this.error) {
            p1 = funcionP(t, dof, j);
            p2 = funcionP(t, dof, j * 2);
            j = j * 2;
        }

        return p2;
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
     * Calcula el rango
     *
     * @param data
     * @param proxyE
     * @return
     */
    double calcularRange(Head data, float proxyE)
    {
        int n = data.size();
        float Xavg = this.getXavg(data);

        Node node = data.getFirst();
        double X_Xavg2 = 0;
        while (node != null) {
            X_Xavg2 += Math.pow(node.getX() - Xavg, 2);
            node = node.getNext();
        }

        double desvEstandar = this.calcularDesvEstandar(data);
        double t = this.calcularT(0.35f, n - 2);
        double rest = 1 + (1f / n) + (Math.pow(proxyE - Xavg, 2) / (X_Xavg2));

        return t * desvEstandar * Math.sqrt(rest);
    }

    /**
     * Calcula la desviacion estandar de un grupo de datos
     *
     * @param data grupo de datos
     * @return
     */
    private double calcularDesvEstandar(Head data)
    {
        int n = data.size();
        float B0 = this.calcularB0(data);
        float B1 = this.calcularB1(data);

        double rest = 0;
        Node node = data.getFirst();
        while (node != null) {
            float x = node.getX();
            float y = node.getY();
            float sum = y - B0;
            sum = sum - (B1 * x);
            rest += Math.pow(sum, 2);

            node = node.getNext();
        }

        n = n - 2;
        return Math.sqrt(rest * (1f / n));
    }

    /**
     * Calcula el valor T teniendo en cuenta el error E
     *
     * @param data datos para calcular el valor T
     * @return retorna una lista de valores T asociados a la lista de datos data
     */
    private double calcularT(double p, int dof)
    {
        double t = 1.0d;
        double d = 0.5d;

        double p1 = 0.0d;
        double p2 = 0.5d;
        double err = 0.0d;
        do {
            p1 = p;
            p2 = funcionP(t, dof, this.num_seg);
            if (p1 - p2 > 0) {
                t = t + d;
            } else {
                d = d / 2;
                t = t - d;
            }

            p2 = funcionP(t, dof, this.num_seg);
            err = p1 - p2;
            if (err < 0) {
                err = err * -1;
            }
        } while (err >= this.error);

        return t;
    }

    /**
     * Calcula el Rango superior de estimación
     *
     * @param data
     * @param proxyE
     * @return
     */
    double calcularUPI(Head data, float proxyE)
    {
        double P = this.calcularP(data, proxyE);
        double range = this.calcularRange(data, proxyE);

        return P + range;
    }

    /**
     * Calcula el rango inferior de estimación
     *
     * @param data
     * @param proxyE
     * @return
     */
    double calcularLPI(Head data, float proxyE)
    {
        double P = this.calcularP(data, proxyE);
        double range = this.calcularRange(data, proxyE);

        return P - range;
    }
}
