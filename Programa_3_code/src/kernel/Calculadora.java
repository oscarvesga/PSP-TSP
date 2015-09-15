package kernel;

/**
 *
 * Calculadora de Datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 01-09-2015
 *
 */
public class Calculadora
{

    /**
     * Constructor
     */
    public Calculadora()
    {
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
}
