package kernel;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * Imprime datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 20-10-2015
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
    public void imprimirDatos(ArrayList data, String test)
    {
        Calculadora calculadora = new Calculadora();

        ArrayList result = calculadora.calcularT(data);
        System.out.println("---------" + test + "----------");
        for (int i = 0; i < result.size(); i++) {
            double p = (double) result.get(i);
            Node node = (Node) data.get(i);
            float x = node.getX();
            int dof = node.getDof();
            System.out.println("P(" + x + "," + dof + ") = " + p);
        }
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
        if (archivos.length > 0) {
            for (File archivo : archivos) {
                String result = cargador.cargarDatos(archivo.getPath());
                if (result.equals("OK")) {
                    ArrayList data = cargador.getData();
                    impr.imprimirDatos(data, archivo.getName());
                } else {
                    System.out.println("No se encontro el archivo en el directorio /data");
                }
            }
        } else {
            System.out.println("No se encontro el archivo en el directorio /data");
        }

    }

}
