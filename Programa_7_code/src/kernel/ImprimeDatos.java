package kernel;

import java.io.File;

/**
 *
 * Imprime datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 23-11-2015
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
        if (test.equals("test3.txt") || test.equals("test4.txt")){
            proxyE = 148f;
        }        
        
        double r = calculadora.calcularR(data);
        double r2 = calculadora.calcularR2(data);
        double sig = calculadora.calcularSignificancia(data);
        float B0 = calculadora.calcularB0(data);
        float B1 = calculadora.calcularB1(data);

        System.out.println("---------" + test + "----------");
        System.out.println("r = " + r);
        System.out.println("r2 = " + r2);
        System.out.println("Sig = "+ sig);
        System.out.println("B0 = " + B0);
        System.out.println("B1 = " + B1);        

        float P = calculadora.calcularP(data, proxyE);
        double range = calculadora.calcularRange(data, proxyE);
        double UPI = calculadora.calcularUPI(data, proxyE);
        double LPI = calculadora.calcularLPI(data, proxyE);
        
        System.out.println("P = " + P);
        System.out.println("Range = " + range);
        System.out.println("UPI(70%) = " + UPI);
        System.out.println("LPI(70%) = " + LPI);
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
