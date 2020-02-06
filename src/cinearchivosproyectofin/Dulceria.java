package cinearchivosproyectofin;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Dulceria implements Serializable{
    private static final long serialVersionUID = 5568263180644830977L;
    String prod;
    int cantidad,pred;
    public Dulceria(){
        
    }
    public Dulceria(String prod,int cantidad,int pred){
        setProd(prod);
        setCantidad(cantidad);
        setPred(pred);
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPred() {
        return pred;
    }

    public void setPred(int pred) {
        this.pred = pred;
    }
    
    public void lectura(Vector<Dulceria> vd) throws IOException, ClassNotFoundException {
        File du=new File("C:\\CINE\\Dulceria.muski");
        FileInputStream fis = new FileInputStream(du);
        ObjectInputStream ois = new ObjectInputStream(fis);
        vd.clear();
        while (fis.available() > 0) {
            Dulceria d = (Dulceria) ois.readObject();
            prod=d.getProd();
            cantidad=d.getCantidad();
            pred=d.getPred();
            vd.addElement(new Dulceria(prod,cantidad,pred));
        }
        ois.close();
    }

    public void escritura(Vector<Dulceria> vd)throws IOException {
        File du=new File("C:\\CINE\\Dulceria.muski");
        FileOutputStream fos = new FileOutputStream(du);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < vd.size(); i++) {
            oos.writeObject(new Dulceria(vd.elementAt(i).getProd(),vd.elementAt(i).getCantidad(),vd.elementAt(i).getPred()));
        }
        oos.close();
    }
}
