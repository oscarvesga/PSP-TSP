package kernel;

/**
 *
 * Calculadora de la media y la desviación estandar
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 27-07-2015
 *
 */
public class Calculadora
{

    private final CargadorDatos cargador;
    
    /**
     * Crea el cargador de datos
     */
    public Calculadora()
    {
        CargadorDatos load = new CargadorDatos();
        cargador = load;
    }

    /**
     * Calcula la media
     *
     * @param data lista de datos para calcular la media
     * @return media
     */
    public float calcularMedia(Head data)
    {
        float sumElement = 0;
        float countElement = 0;
        Node element = data.getFirst();
        while (element != null) {
            sumElement += element.getNum();
            countElement++;
            element = element.getNext();
        }

        return sumElement / countElement;
    }

    /**
     * Calcula la desviación estandar
     *
     * @param data lista de datos para el calculo
     * @return desviacion estandar
     */
    public float calcularDesvEstandar(Head data)
    {
        float media = calcularMedia(data);

        float x2 = 0;
        float countElement = 0;
        Node element = data.getFirst();
        while (element != null) {
            countElement++;
            float x = element.getNum() - media;
            x2 += x * x;
            element = element.getNext();
        }

        return (float) Math.round(Math.sqrt(x2 / (countElement - 1)) * 100) / 100;
    }

    /**
     * Main de la aplicación
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Calculadora cal = new Calculadora();
        cal.cargador.cargarDatos("src/data/data1.csv");
        Head data1 = cal.cargador.getData();
        cal.cargador.cargarDatos("src/data/data2.csv");
        Head data2 = cal.cargador.getData();

        float media1 = 0;
        float desEstandar1 = 0;
        media1 = cal.calcularMedia(data1);
        desEstandar1 = cal.calcularDesvEstandar(data1);
        System.out.println("Media_1 = " + media1);
        System.out.println("Desviación Estandar_1 = " + desEstandar1);

        float media2 = 0;
        float desEstandar2 = 0;
        media2 = cal.calcularMedia(data2);
        desEstandar2 = cal.calcularDesvEstandar(data2);
        System.out.println("Media_2 = " + media2);
        System.out.println("Desviación Estandar_2 = " + desEstandar2);

    }
}
