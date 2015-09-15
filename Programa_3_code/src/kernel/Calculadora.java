package kernel;

public class Calculadora {

    public Calculadora() {
    }

    private float getX(Head data)
    {
        float result =0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getX();
            first = first.getNext();
        }
        
        return result;
    }
    
    private float getY(Head data)
    {
        float result =0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getY();
            first = first.getNext();
        }
        
        return result;
    }
    
    /**
     * Calcula el promedio X de los datos
     * @param data lista de datos x, y
     * @return promedio X
     */
    public float getXavg(Head data) {
        float result =0;
        int size = 0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getX();
            size++;
            first = first.getNext();
        }
        
        return result/size;
    }
    
    /**
     * Calcula el promedio Y de los datos
     * @param data lista de datos x, y
     * @return promedio Y
     */
    public float getYavg(Head data) {
        float result = 0;
        int size = 0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getY();
            size++;
            first = first.getNext();
        }
                
        return result/size;
    }

    public float getX2(Head data) {
        float result = 0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getX2();            
            first = first.getNext();
        }
        
        return result;
    }

    public float getXY(Head data) {
        float result = 0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getXY();            
            first = first.getNext();
        }
        
        return result;
    }

    public float getY2(Head data) {
        float result = 0;
        
        Node first = data.getFirst();
        while (first != null){
            result += first.getY2();            
            first = first.getNext();
        }
        
        return result;
    }

    public float calcularB0(Head data) {
        float result = 0;
        
        float Yavg = getYavg(data);
        float Xavg = getXavg(data);
        float B1 = calcularB1(data);
        
        result = Yavg - B1 * Xavg;
        
        return result;
    }

    public float calcularB1(Head data) {
        float result = 0;
        int n = data.size();
        float Xavg = getXavg(data);
        float Yavg = getYavg(data);
        float XY = getXY(data);
        float X2 = getX2(data);
        
        result = XY - (n*Xavg*Yavg);
        result = result/(X2-(n*Xavg*Xavg));
        
        return result;
    }

    public double calcularR(Head data) {
        
        int n = data.size();
        float X = getX(data);
        float Y = getY(data);
        float XY = getXY(data);
        float X2 = getX2(data);        
        float Y2 = getY2(data);
        
        float result1 = n*XY - X*Y;
        double result2 = ((n*X2)-(X*X))*((n*Y2)-(Y*Y));
        result2 = Math.sqrt(result2);
        
        return result1/result2;
    }

    public double calcularR2(Head data) {
        double r = calcularR(data);
        return r*r;
    }

    public float calcularP(Head data, float proxyE) {
        
        float B0 = calcularB0(data);
        float B1 = calcularB1(data); 
              
        return B0 + B1*proxyE;
    }
}
