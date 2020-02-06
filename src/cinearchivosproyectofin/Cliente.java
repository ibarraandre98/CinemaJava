package cinearchivosproyectofin;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 5568263180644830977L;
    String nombre, direccion;
    int edad, puntos;

    public Cliente() {

    }

    public Cliente(String nombre, String direccion, int edad, int puntos) {
        setNombre(nombre);
        setDireccion(direccion);
        setEdad(edad);
        setPuntos(puntos);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void lectura(Vector<Cliente> vc) throws IOException, ClassNotFoundException {
        File cl = new File("C:\\CINE\\Clientes.muski");
        FileInputStream fis = new FileInputStream(cl);
        ObjectInputStream ois = new ObjectInputStream(fis);
        vc.clear();
        while (fis.available() > 0) {
            Cliente c = (Cliente) ois.readObject();
            nombre = c.getNombre();
            direccion = c.getDireccion();
            edad = c.getEdad();
            puntos = c.getPuntos();
            vc.addElement(new Cliente(nombre, direccion, edad, puntos));
        }
        ois.close();
    }

    public void escritura(Vector<Cliente> vc)throws IOException {
        File cl = new File("C:\\CINE\\Clientes.muski");
        FileOutputStream fos = new FileOutputStream(cl);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < vc.size(); i++) {
            oos.writeObject(new Cliente(vc.elementAt(i).getNombre(), vc.elementAt(i).getDireccion(), vc.elementAt(i).getEdad(), vc.elementAt(i).getPuntos()));
        }
        oos.close();
    }
}
