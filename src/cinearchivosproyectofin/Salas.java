package cinearchivosproyectofin;

import java.io.*;
import java.util.*;
import java.io.Serializable;

public class Salas implements Serializable {

    private static final long serialVersionUID = 5568263180644830977L;
    int sala;
    int[][] salitas;

    public Salas() {

    }

    public Salas(int sala, int[][] salitas) {
        setSala(sala);
        setSalitas(salitas);
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int[][] getSalitas() {
        return salitas;
    }

    public void setSalitas(int[][] salitas) {
        this.salitas = salitas;
    }
    public void leer(int n, int[][] tsali) throws IOException {
        String nom = String.valueOf(n);
        String[] partes;
        File archivo = new File("C:\\CINE\\" + nom + ".muski");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        for (int i = 0; i < 7; i++) {
            linea = br.readLine();
            partes = linea.split(" ");
            for (int j = 0; j < 7; j++) {
                tsali[i][j] = Integer.valueOf(partes[j]);
            }
        }
        br.close();
    }

    public void sobreescribir(int n, int[][] tsali)throws IOException {
        String nom = String.valueOf(n);
        File archivo = new File("C:\\CINE\\" + nom + ".muski");
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                pw.print(tsali[i][j] + " ");
            }
            pw.println();
        }
        pw.close();
    }
}
