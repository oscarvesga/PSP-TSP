package kernel;

import java.io.File;

/**
 *
 * Imprime datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 01-09-2015
 *
 */
public class ImprimeDatos
{

    /**
     * Constructor
     */
    public ImprimeDatos()
    {
    }

    /**
     * Imprime los datos solicitados por el programa
     *
     * @param data
     * @param test
     */
    public void imprimirDatos(Head data, String test)
    {
        Calculadora calculadora = new Calculadora();
        float proxyE = 386;
        float B0 = calculadora.calcularB0(data);
        float B1 = calculadora.calcularB1(data);
        double r = calculadora.calcularR(data);
        double r2 = calculadora.calcularR2(data);

        System.out.println("---------" + test + "----------");
        System.out.println("B0 = " + B0);
        System.out.println("B1 = " + B1);
        System.out.println("r = " + r);
        System.out.println("r2 = " + r2);

        float P = calculadora.calcularP(data, proxyE);
        System.out.println("P = " + P);
    }

    /**
     * Ininica la aplicación
     *
     * @param args
     */
    public static void main(String[] args)
    {
        ImprimeDatos impr = new ImprimeDatos();
        CargadorDatos cargador = new CargadorDatos();

        File directorio = new File("data");
        File[] archivos = directorio.listFiles();
        for (File archivo : archivos) {
            cargador.cargarDatos(archivo.getPath());
            Head data = cargador.getData();
            impr.imprimirDatos(data, archivo.getName());
        }

    }

}
