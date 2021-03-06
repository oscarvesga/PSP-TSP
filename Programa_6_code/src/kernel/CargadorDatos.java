package kernel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Cargador de datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 20-10-2015
 *
 */
public class CargadorDatos
{

    private ArrayList data;

    /**
     * Constructor
     */
    public CargadorDatos()
    {
    }

    /**
     * Carga los datos en la lista data
     *
     * @param file - path del archivo
     */
    public String cargarDatos(String file)
    {
        ArrayList data1 = new ArrayList();

        FileReader fr = null;
        try {
            File archivo = new File(file);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();//Quitamos el header
            while ((linea = br.readLine()) != null) {
//                System.out.println("linea = "+linea);

                String[] numeros = linea.split(";");
                double x = Double.parseDouble(numeros[0]);
                int dof = Integer.parseInt(numeros[1]);

                Node node = new Node(x, dof);
                data1.add(node);
            }

            this.data = data1;
            return "OK";
        } catch (Exception ex) {
            Logger.getLogger(CargadorDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CargadorDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    /**
     * retorna la lista de datos
     *
     * @return lista datos (x, y)
     */
    public ArrayList getData()
    {
        return this.data;
    }
}
