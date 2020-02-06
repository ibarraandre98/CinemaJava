package cinearchivosproyectofin;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Venta implements Serializable{
    private static final long serialVersionUID = 5568263180644830977L;
    String nombre,producto;
    int cantidad,efectivo,puntos;
    public Venta(){
        
    }
    public Venta(String nombre,String producto,int cantidad,int efectivo,int puntos){
        setNombre(nombre);
        setProducto(producto);
        setCantidad(cantidad);
        setEfectivo(efectivo);
        setPuntos(puntos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
     public void lectura(Vector<Venta> vv) throws IOException, ClassNotFoundException {
        File ve=new File("C:\\CINE\\Ventas.muski");
        FileInputStream fis = new FileInputStream(ve);
        ObjectInputStream ois = new ObjectInputStream(fis);
        vv.clear();
        while (fis.available() > 0) {
            Venta v = (Venta) ois.readObject();
            nombre=v.getNombre();
            producto=v.getProducto();
            cantidad=v.getCantidad();
            efectivo=v.getEfectivo();
            puntos=v.getPuntos();
            vv.addElement(new Venta(nombre,producto,cantidad,efectivo,puntos));
        }
        ois.close();
    }

    public void escritura(Vector<Venta> vv)throws IOException {
        File ve=new File("C:\\CINE\\Ventas.muski");
        FileOutputStream fos = new FileOutputStream(ve);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < vv.size(); i++) {
            oos.writeObject(new Venta(vv.elementAt(i).getNombre(),vv.elementAt(i).getProducto(),vv.elementAt(i).getCantidad(),vv.elementAt(i).getEfectivo(),vv.elementAt(i).getPuntos()));
        }
        oos.close();
    }
    
}
