package kernel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargadorDatos {

    private Head data;

    public CargadorDatos() {
    }

    public void cargarDatos(String file) {
        Head data1 = new Head();

        FileReader fr = null;
        try {
            File archivo = new File(file);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
//                System.out.println("linea = "+linea);
                
                String[] numeros = linea.split(";");                
                float x = Float.parseFloat(numeros[0]);
                float y = Float.parseFloat(numeros[1]);
                
                Node num = new Node(x,y);
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

    public Head getData() {
        return this.data;
    }
}
