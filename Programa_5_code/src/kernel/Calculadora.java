package kernel;


import java.util.ArrayList;

public class Calculadora {

    private int num_seg;

    private double error;

    private float with;

    public Calculadora() {
        this.num_seg = 10;
        this.error = 0.0000001;        
    }

    public double funcionGamma(float xi) {        
        if (xi == 1){
            return 1;
        }
        else if (xi == 0.5){
            return Math.sqrt(Math.PI);
        }
        else{
            return (xi-1)*funcionGamma(xi-1);
        } 
    }

    public double funcionF(float xi, int dof) {
        double result1 = funcionGamma((dof+1)/2);
        result1 = result1/(Math.sqrt(dof*Math.PI)*funcionGamma((float)dof/2));
        double result2 = 1 + (xi*xi/dof);
        result2 = Math.pow(result2,-(dof+1)/2);        
        
        return result1*result2;
    }

    public double funcionP(float x, int dof, int num_seg) {
        double result = 0;
        float w = x/num_seg;
        
        for (int i = 1; i < num_seg; i++) {
            if (i%2 == 0){
                result +=2*funcionF(w*i, dof);
            }
            else {
                result +=4*funcionF(w*i, dof);
            }
        }
        
        double suma = funcionF(0, dof) + result + funcionF(x, dof);
        return suma * w/3;
    }

    public ArrayList calcularP(ArrayList data) {
        ArrayList result = new ArrayList();
        
        for (int i = 0; i < data.size(); i++) {
            Node node = (Node)data.get(i);            
            double result1 =  funcionP(node.getX(), node.getDof(), this.num_seg);
            double result2 =  funcionP(node.getX(), node.getDof(), 2*this.num_seg);
            
            int j = 2*this.num_seg;
            while (result1 - result2 > this.error) {
                result1 = funcionP(node.getX(), node.getDof(), j);                
                result2 = funcionP(node.getX(), node.getDof(), j*2);
                j=j*2;
            }
            
            double rest = result1 - result2;
            result.add(rest);
        }
        
        return result;
    }
}
