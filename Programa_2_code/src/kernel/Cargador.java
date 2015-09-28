package kernel;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * Carga y guarda en memoria los archivos a contar
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 28-08-2015
 */
public class Cargador
{

    ArrayList<File> archivos;

    /**
     * Constructor que inicializa la lista de archivos
     */
    public Cargador()
    {
        archivos = new ArrayList<>();
    }

    /**
     * Carga los arhivos .java encontrado en la ruta 'directorio'. Si la ruta
     * contiene mas directorio realiza una busqueda de los archivos de forma
     * recursiva
     *
     * @param directorio
     * @return
     */
    public ArrayList<File> cargarProyecto(String directorio)
    {
        //File archivos[];
        File directorio1 = new File(directorio);
        if (directorio1.isDirectory()) {
            File listado[] = directorio1.listFiles();
            for (int i = 0; i < listado.length; i++) {
//                System.out.println(listado[i].getName());
                cargarProyecto(listado[i].getAbsolutePath());
            }
        } else if (directorio1.toString().endsWith(".java")) {
            this.archivos.add(directorio1);
        }

        return this.archivos;
    }

    /**
     * 
     * @param archivo
     * @return
     */
    public String readLine(File archivo)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
