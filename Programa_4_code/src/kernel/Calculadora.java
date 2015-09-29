package kernel;

/**
 *
 * Calculadora de Datos
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 29-09-2015
 *
 */
class Calculadora
{

    /**
     * Constructor
     */
    public Calculadora()
    {
    }

    /**
     * Retorna el promedio del logaritmo naturla de n datos
     *
     * @param data - n datos
     * @return promedio del logaritmo natural
     */
    private double avglnX(Head data)
    {
        double avg = 0;

        Node first = data.getFirst();
        while (first != null) {
            avg = avg + first.getlnX();

            first = first.getNext();
        }

        return avg / data.size();
    }

    /**
     * Retorna la varianza de n datos
     *
     * @param data - n datos
     * @return varianza
     */
    private double var(Head data)
    {
        double var = 0;

        Node first = data.getFirst();
        while (first != null) {
            double logX = first.getlnX();
            double avg = this.avglnX(data);
            var = var + Math.pow(logX - avg, 2);

            first = first.getNext();
        }

        return var / (data.size() - 1);
    }

    /**
     * Retorna el rango VS de los datos suministrados
     * @param data 
     * @return 
     */
    public double getVS(Head data)
    {
        double vs = 0;
        
        double desEstandar = Math.sqrt(this.var(data));
        double avg = this.avglnX(data);
        vs = avg - 2*desEstandar;
        vs = Math.exp(vs);
        
        return vs;
    }

    /**
     * Retorna el rango S de los datos suministrados
     * @param data
     * @return 
     */
    public double getS(Head data)
    {
        double s = 0;
        
        double desEstandar = Math.sqrt(this.var(data));
        double avg = this.avglnX(data);
        s = avg - 1*desEstandar;
        s = Math.exp(s);
        
        return s;
    }
    
    /**
     * Retorna el rango M de los datos suministrados
     * @param data
     * @return 
     */
    public double getM(Head data)
    {
        double m = 0;
                
        double avg = this.avglnX(data);
        m = avg;
        m = Math.exp(m);
        
        return m;
    }
    
    /**
     * Retorna el rango L de los datos suministrados
     * @param data
     * @return 
     */
    public double getL(Head data)
    {
        double l = 0;
        
        double desEstandar = Math.sqrt(this.var(data));
        double avg = this.avglnX(data);
        l = avg + 1*desEstandar;
        l = Math.exp(l);
        
        return l;
    }
    
    /**
     * Retorna el rango VL de los datos suministrados
     * @param data
     * @return 
     */
    public double getVL(Head data)
    {
        double vl = 0;
        
        double desEstandar = Math.sqrt(this.var(data));
        double avg = this.avglnX(data);
        vl = avg + 2*desEstandar;
        vl = Math.exp(vl);
        
        return vl;
    }
}
