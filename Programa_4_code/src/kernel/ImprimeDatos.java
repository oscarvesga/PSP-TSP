package kernel;

import java.io.File;

/**
 *
 * Imprime datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 29-09-2015
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
       
        System.out.println("---------" + test + "----------");
        System.out.println("VS = "+calculadora.getVS(data));
        System.out.println("S = "+calculadora.getS(data));
        System.out.println("M = "+calculadora.getM(data));
        System.out.println("L = "+calculadora.getL(data));
        System.out.println("VL = "+calculadora.getVL(data));
        
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
