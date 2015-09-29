package kernel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Cuenta las clases, metodos y lineas de codigo 
 * de un proyecto java
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 28-08-2015
 */
public class ContadorLOC
{

    private String directorio;

    private ArrayList<File> archivos;

    private int countClases;

    private int countMetodos;

    private int countLOC;

    /**
     * Crea la estructura de archivos a contar
     * @param directorio
     */
    public ContadorLOC(String directorio)
    {
        this.directorio = directorio;
        this.countClases = 0;
        this.countMetodos = 0;
        this.countLOC = 0;

        Cargador cargador = new Cargador();
        ArrayList<File> archivos1 = cargador.cargarProyecto(directorio);
        this.archivos = (ArrayList<File>) archivos1.clone();
        this.countClases = this.archivos.size();
    }

    /**
     * Retorna la lista de archivos a contar
     * @return
     */
    public ArrayList<File> getArchivos()
    {
        return archivos;
    }

    /**
     *
     * @param archivo
     * @param inicio
     * @param fin
     * @return
     */
    public int contar(File archivo, String inicio, String fin)
    {
        int count = 0;
        return count;
    }

    /**
     *
     * @return
     */
    public int contarClases()
    {
        countClases = archivos.size();
        return countClases;
    }

    /**
     * Cuenta el numero total de metodos e imprime el resultado
     * por consola
     * @param archivo
     */
    public void contarMetodos(File archivo)
    {
        int countMetodos1 = 0;
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.matches("(\\s+)(public|private)(.*)(\\){1})")) {
//                    System.out.println("linea Metodos = " + linea);
                    countMetodos1++;
                }
            }
            System.out.println("Clase : \t"+archivo.getName());
            System.out.println("Metodos : \t"+countMetodos1);
            this.countMetodos+=countMetodos1;
            contarLOC(archivo);
            System.out.println("-----------------------------------");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorLOC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContadorLOC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ContadorLOC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    /**
     * Cuenta el numero de lineas de codigo del archivo e imprime el resultado
     * por consola
     * @param archivo
     */
    public void contarLOC(File archivo)
    {
        int countLOC1 = 0;
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.matches("^[^ip](.*)(\\s\\{|;)${1}") && !linea.contains("//")
                    && !linea.endsWith("   {")) {
//                    System.out.println("LOC = " + linea);
                    countLOC1++;
                }
            }
            System.out.println("LOC : \t\t"+countLOC1);
            this.countLOC+=countLOC1;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorLOC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContadorLOC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ContadorLOC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Inicia el programa y realiza los calculos totales de numero de clases,
     * numero de metodos y numero de lineas de codigo del proyecto
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        ContadorLOC contador = new ContadorLOC("../Programa_1_code/src");
//        ContadorLOC contador = new ContadorLOC("../Programa_2_code/src");
//        ContadorLOC contador = new ContadorLOC("../Programa_3_code/src");
        ContadorLOC contador = new ContadorLOC("../Programa_4_code/src");
        
        for(File archivo: contador.getArchivos()){
            contador.contarMetodos(archivo);
        }
        System.out.println("Total Clases : \t\t"+contador.countClases);
        System.out.println("Total Metodos : \t"+contador.countMetodos);
        System.out.println("Total LOC : \t\t"+contador.countLOC);
        
        System.out.println("Total Size : \t\t"+(contador.countLOC+contador.countMetodos+contador.countClases));
        
    }
}
