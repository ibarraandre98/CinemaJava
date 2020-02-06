package cinearchivosproyectofin;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 5568263180644830977L;
    String peli,genero,director,vigencia;
    int duracion,sala;
    public Pelicula(){
        
    }
    public Pelicula(int sala){
        setSala(sala);
    }
    public Pelicula(String peli,String genero,String director,int duracion,int sala,String vigencia){
        setPeli(peli);
        setGenero(genero);
        setDirector(director);
        setDuracion(duracion);
        setSala(sala);
        setVigencia(vigencia);
    }

    public String getPeli() {
        return peli;
    }

    public void setPeli(String peli) {
        this.peli = peli;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
    
    
    public void lectura(Vector<Pelicula> vp) throws IOException, ClassNotFoundException {
        File pe = new File("C:\\CINE\\Pelicula.muski");
        FileInputStream fis = new FileInputStream(pe);
        ObjectInputStream ois = new ObjectInputStream(fis);
        vp.clear();
        while (fis.available() > 0) {
            Pelicula p = (Pelicula) ois.readObject();
            peli = p.getPeli();
            genero = p.getGenero();
            director = p.getDirector();
            duracion = p.getDuracion();
            sala=p.getSala();
            vigencia=p.getVigencia();
            vp.addElement(new Pelicula(peli, genero, director, duracion,sala,vigencia));
        }
        ois.close();
    }

    public void escritura(Vector<Pelicula> vp)throws IOException {
        File pe = new File("C:\\CINE\\Pelicula.muski");
        FileOutputStream fos = new FileOutputStream(pe);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < vp.size(); i++) {
            oos.writeObject(new Pelicula(vp.elementAt(i).getPeli(),vp.elementAt(i).getGenero(),vp.elementAt(i).getDirector(),vp.elementAt(i).getDuracion(),vp.elementAt(i).getSala(),vp.elementAt(i).getVigencia()));
        }
        oos.close();
    }
}
