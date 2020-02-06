package cinearchivosproyectofin;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Taquilla implements Serializable{
    private static final long serialVersionUID = 5568263180644830977L;
    String nombre,pelicula;
    int boletos,total,asientoi,asientoj,nsal;
    public Taquilla(){
        
    }
    public Taquilla(String nombre,String pelicula,int boletos,int total,int asientoi,int asientoj,int nsal){
        setNombre(nombre);
        setPelicula(pelicula);
        setBoletos(boletos);
        setTotal(total);
        setAsientoi(asientoi);
        setAsientoj(asientoj);
        setNsal(nsal);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getBoletos() {
        return boletos;
    }

    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAsientoi() {
        return asientoi;
    }

    public void setAsientoi(int asientoi) {
        this.asientoi = asientoi;
    }

    public int getAsientoj() {
        return asientoj;
    }

    public void setAsientoj(int asientoj) {
        this.asientoj = asientoj;
    }

    public int getNsal() {
        return nsal;
    }

    public void setNsal(int nsal) {
        this.nsal = nsal;
    }
    
    
        public void lectura(Vector<Taquilla> vt) throws IOException, ClassNotFoundException {
        File ta = new File("C:\\CINE\\Taquilla.muski");
        FileInputStream fis = new FileInputStream(ta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        vt.clear();
        while (fis.available() > 0) {
            Taquilla t = (Taquilla) ois.readObject();
            nombre=t.getNombre();
            pelicula=t.getPelicula();
            boletos=t.getBoletos();
            total=t.getTotal();
            asientoi=t.getAsientoi();
            asientoj=t.getAsientoj();
            nsal=t.getNsal();
            vt.addElement(new Taquilla(nombre,pelicula,boletos,total,asientoi,asientoj,nsal));
        }
        ois.close();
    }

    public void escritura(Vector<Taquilla> vt)throws IOException {
        File ta = new File("C:\\CINE\\Taquilla.muski");
        FileOutputStream fos = new FileOutputStream(ta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < vt.size(); i++) {
            oos.writeObject(new Taquilla(vt.elementAt(i).getNombre(),vt.elementAt(i).getPelicula(),vt.elementAt(i).getBoletos(),vt.elementAt(i).getTotal(),vt.elementAt(i).getAsientoi(),vt.elementAt(i).getAsientoj(),vt.elementAt(i).getNsal()));
        }
        oos.close();
    }
}
