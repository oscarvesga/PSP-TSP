package kernel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Lee los datos de un archivo y los carga en una lista simplemente
 * encadenada
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 27-08-2015
 */
public class CargadorDatos
{

    private String file;

    private Head data;

    /**
     * Constructor
     */
    public CargadorDatos()
    {
    }

    /**
     * Retorna los datos cargados
     * @return datos
     */
    public Head getData()
    {
        return data;
    }

    /**
     * Crea la lista de datos para los calculos
     * @param file ubicación del archivo a cargar
     */
    public void cargarDatos(String file)
    {
        Head data1 = new Head();

        FileReader fr = null;
        try {
            File archivo = new File(file);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
//                System.out.println("linea = "+linea);
                Node num = new Node();
                num.setNum(Float.parseFloat(linea));

                Node last = data1.getLast();
                if (last == null) {
                    data1.setFirst(num);
                    data1.setLast(num);
                } else {
                    last.setNext(num);
                    data1.setLast(num);
                }
            }

            this.data = data1;
        } catch (Exception ex) {
            Logger.getLogger(CargadorDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CargadorDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
