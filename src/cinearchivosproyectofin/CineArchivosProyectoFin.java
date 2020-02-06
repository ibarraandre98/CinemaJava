package cinearchivosproyectofin;

import java.util.*;
import java.io.*;

public class CineArchivosProyectoFin {

    static Scanner leer = new Scanner(System.in);
    static boolean continuar = true;
    static int opc, acc, hac;
    static boolean existe, existe1, enco;
    static int lo, tol, ct, conta;
    static String pro;

    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        Pelicula pelicula = new Pelicula();
        Dulceria dulceria = new Dulceria();
        Taquilla taquilla = new Taquilla();
        Venta ventas = new Venta();
        Salas salas = new Salas();
        Vector<Cliente> vc = new Vector();
        Vector<Pelicula> vp = new Vector();
        Vector<Dulceria> vd = new Vector();
        Vector<Taquilla> vt = new Vector();
        Vector<Venta> vv = new Vector();
        int salitas[][] = new int[10][10];
        int tsali[][] = new int[7][7];
        File cl, ta, du, pe, ve, s1, s2, s3, s4, s5;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        FileReader fr;
        BufferedReader br;
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        //CLIENTE
        String nombre, contraseña, direccion;
        int reg, edad, puntos;
        //PELICULA
        String peli, genero, director, vigencia;
        int duracion, sala;
        //DULCERIA
        String prod;
        int cantidad, pred;
        //TAQUILLA
        String nomcli, pelicu = null;
        int precio = 42, npeli, ptos, boletos, a, b, total, val, nsal;
        //DULCES
        String nclie;
        int pdul, ca;
        File directorio = new File("C:\\CINE");
        cl = new File("C:\\CINE\\Clientes.muski");
        pe = new File("C:\\CINE\\Pelicula.muski");
        du = new File("C:\\CINE\\Dulceria.muski");
        ta = new File("C:\\CINE\\Taquilla.muski");
        ve = new File("C:\\CINE\\Ventas.muski");
        s1 = new File("C:\\CINE\\1.muski");
        s2 = new File("C:\\CINE\\2.muski");
        s3 = new File("C:\\CINE\\3.muski");
        s4 = new File("C:\\CINE\\4.muski");
        s5 = new File("C:\\CINE\\5.muski");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        if (!cl.exists()) {
            fos = new FileOutputStream(cl);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Cliente(null, null, 0, 0));
        }
        if (!pe.exists()) {
            fos = new FileOutputStream(pe);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Pelicula(null, null, null, 0, 0, null));
        }
        if (!du.exists()) {
            fos = new FileOutputStream(du);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Dulceria(null, 0, 0));
        }
        if (!ta.exists()) {
            fos = new FileOutputStream(ta);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Taquilla(null, null, 0, 0, 0, 0, 0));
        }
        if (!ve.exists()) {
            fos = new FileOutputStream(ve);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Venta(null, null, 0, 0, 0));
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                salitas[i][j] = 0;
            }
        }
        if (!s1.exists()) {
            fw = new FileWriter(s1);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    pw.print(salitas[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        }
        if (!s2.exists()) {
            fw = new FileWriter(s2);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    pw.print(salitas[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        }
        if (!s3.exists()) {
            fw = new FileWriter(s3);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    pw.print(salitas[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        }
        if (!s4.exists()) {
            fw = new FileWriter(s4);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    pw.print(salitas[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        }
        if (!s5.exists()) {
            fw = new FileWriter(s5);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    pw.print(salitas[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        }
        do {
            do {
                try {
                    System.out.println("-------------------------------¡Bienvenido a CINEMUSKI!----------------------------");
                    System.out.println("Ingrese el area a la que desea ingresar: \n1.-CLIENTE\n2.-VENTAS\n3.-DULCERIA\n4.-PELICULA\n0.-SALIR\n");
                    opc = leer.nextInt();
                    System.out.println("");
                    switch (opc) {
                        //CLIENTE
                        case 1:
                            do {
                                cliente.lectura(vc);
                                System.out.println("-------------------CLIENTE-------------------");
                                System.out.println("INGRESE LO QUE DESEE HACER: \n1.-REGISTRO\n2.-ACTUALIZACION DE CLIENTE\n3.-ELIMINACION DE CLIENTE\n4.-MOSTRAR PUNTOS DEL CLIENTE\n0.-SALIR A LA PANTALLA PRINCIPAL\n");
                                acc = leer.nextInt();
                                switch (acc) {
                                    case 1:
                                        System.out.println("-------------------REGISTRO DE CLIENTE-----------------");
                                        existe = false;
                                        System.out.println("Ingrese nombre completo del cliente: ");
                                        leer.nextLine();
                                        nombre = leer.nextLine();
                                        nombre = nombre.toLowerCase();
                                        for (int i = 0; i < vc.size(); i++) {
                                            if (nombre.equals(vc.elementAt(i).getNombre())) {
                                                System.out.println("Este usuario ya existe, por favor reintente e ingrese otro nombre!\n");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Ingrese edad del cliente: ");
                                            edad = leer.nextInt();
                                            System.out.println("Ingrese la direccion: ");
                                            leer.nextLine();
                                            direccion = leer.nextLine();
                                            vc.addElement(new Cliente(nombre, direccion, edad, 0));
                                            cliente.escritura(vc);
                                            System.out.println("¡Datos agregados con exito!\n");
                                        }
                                        break;

                                    case 2:
                                        System.out.println("-----------------------ACTUALIZACION------------------");
                                        System.out.println("Ingrese el nombre al cual desea actualizar los datos: ");
                                        leer.nextLine();
                                        nombre = leer.nextLine();
                                        nombre = nombre.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vc.size(); i++) {
                                            if (nombre.equals(vc.elementAt(i).getNombre())) {
                                                System.out.println("Ingrese la nueva edad: ");
                                                edad = leer.nextInt();
                                                System.out.println("Ingrese la nueva direccion: ");
                                                leer.nextLine();
                                                direccion = leer.nextLine();
                                                System.out.println("Ingrese la nueva cantidad de puntos");
                                                puntos = leer.nextInt();
                                                vc.elementAt(i).setEdad(edad);
                                                vc.elementAt(i).setDireccion(direccion);
                                                vc.elementAt(i).setPuntos(puntos);
                                                existe = true;
                                                cliente.escritura(vc);
                                                System.out.println("");
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Este nombre no existe y no es posible actualizarlo\n");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("-----------------------ELIMINACION-----------------------");
                                        System.out.println("Ingrese el nombre del cliente que desea eliminar: ");
                                        leer.nextLine();
                                        nombre = leer.nextLine();
                                        nombre = nombre.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vc.size(); i++) {
                                            if (nombre.equals(vc.elementAt(i).getNombre())) {
                                                vc.removeElementAt(i);
                                                cliente.escritura(vc);
                                                existe = true;
                                                System.out.println("Cliente eliminado con exito!\n");
                                                System.out.println("");
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Este cliente no existe en la base de datos!\n");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("---------------------GESTION DE PUNTOS--------------------");
                                        System.out.println("Ingrese el nombre del cliente: ");
                                        leer.nextLine();
                                        nombre = leer.nextLine();
                                        nombre = nombre.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vc.size(); i++) {
                                            if (nombre.equals(vc.elementAt(i).getNombre())) {
                                                System.out.println("Sus puntos actuales son: " + vc.elementAt(i).getPuntos());
                                                System.out.println("");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("No existe este cliente!\n");
                                        }
                                        break;
                                    case 0:
                                        System.out.println("¡Ha salido a la pantalla principal!\n");
                                        break;
                                    default:
                                        System.out.println("¡Ingrese una opcion valida!\n");
                                        break;
                                }
                            } while (acc != 0);
                            break;

                        //VENTAS
                        case 2:
                            System.out.println("-------------------VENTAS-------------------");
                            System.out.println("Ingrese el nombre del cliente: ");
                            leer.nextLine();
                            nomcli = leer.nextLine();
                            nomcli = nomcli.toLowerCase();
                            cliente.lectura(vc);
                            boolean es = false;
                            for (int i = 0; i < vc.size(); i++) {
                                if (nomcli.equals(vc.elementAt(i).getNombre())) {
                                    System.out.println("Usted es cliente y el total de sus puntos es: " + vc.elementAt(i).getPuntos());
                                    ptos = vc.elementAt(i).getPuntos();
                                    es = true;
                                }
                            }
                            if (es == false) {
                                System.out.println("Usted no es cliente y por ende no tiene puntos!");
                                ptos = 0;
                            }
                            do {
                                cliente.lectura(vc);
                                pelicula.lectura(vp);
                                dulceria.lectura(vd);
                                taquilla.lectura(vt);
                                System.out.println("-------------------VENTAS-------------------");
                                System.out.println("INGRESE EL AREA DONDE DESEA VENDER:\n1.-TAQUILLA(BOLETOS)\n2.-PRODUCTOS(DULCERIA)\n0.-SALIR A LA PANTALLA PRINCIPAL\n");
                                acc = leer.nextInt();
                                switch (acc) {
                                    case 1:
                                        do {
                                            cliente.lectura(vc);
                                            pelicula.lectura(vp);
                                            dulceria.lectura(vd);
                                            taquilla.lectura(vt);
                                            System.out.println("-----------------TAQUILLA----------------");
                                            System.out.println("INGRESE LO QUE DESEA HACER:\n1.-VENTA DE BOLETOS\n2.-CANCELACION DE BOLETO\n3.-CAMBIO DE PELICULA\n4.-CAMBIO DE ASIENTOS\n0.-SALIR A LA PANTALLA VENTAS\n");
                                            hac = leer.nextInt();
                                            switch (hac) {
                                                case 1:
                                                    System.out.println("----------------------------VENTA DE BOLETOS----------------------------");
                                                    System.out.println("Peliculas disponibles");
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        System.out.println(i + ".-" + vp.elementAt(i).getPeli());
                                                    }
                                                    System.out.println("Ingrese que pelicula desea ver: ");
                                                    npeli = leer.nextInt();
                                                    boolean e1 = false;
                                                    lo = 0;
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        if (npeli == i) {
                                                            pelicu = vp.elementAt(i).getPeli();
                                                            lo = vp.elementAt(i).getSala();
                                                            e1 = true;
                                                        }
                                                    }
                                                    if (e1 == false) {
                                                        System.out.println("Esta pelicula no existe, intente de nuevo!\n");
                                                        break;
                                                    }
                                                    System.out.println("Ingrese cuantos boletos desea: ");
                                                    boletos = leer.nextInt();
                                                    total = boletos * precio;
                                                    ptos = boletos * 10;
                                                    boolean e2 = false;
                                                    salas.leer(lo, tsali);
                                                    conta = 0;
                                                    for (int k = 0; k < boletos; k++) {
                                                        System.out.println("Los asientos disponibles son los que se encuentran en DIS: ");
                                                        System.out.print("     ");
                                                        for (int i = 0; i < 7; i++) {
                                                            System.out.print(i + "    ");
                                                        }
                                                        System.out.println("");
                                                        for (int i = 0; i < 7; i++) {
                                                            System.out.print(i + "  ");
                                                            for (int j = 0; j < 7; j++) {
                                                                if (tsali[i][j] == 1) {
                                                                    System.out.print(" OCU ");
                                                                    conta++;
                                                                    if (conta == 49) {
                                                                        System.out.println("\nLa sala esta llena!\n");
                                                                        break;
                                                                    }
                                                                } else {
                                                                    System.out.print(" DIS ");
                                                                }
                                                            }
                                                            System.out.println("");
                                                        }
                                                        if (conta == 49) {
                                                            break;
                                                        } else {
                                                            System.out.println("Ingrese los asientos en los que desea sentarse: ");
                                                            a = leer.nextInt();
                                                            b = leer.nextInt();
                                                            if (tsali[a][b] == 1) {
                                                                System.out.println("Este asiento ya esta ocupado, intente de nuevo!\n");
                                                                conta = 0;
                                                                k--;
                                                            } else {
                                                                tsali[a][b] = 1;
                                                                vt.addElement(new Taquilla(nomcli, pelicu, boletos, total, a, b, lo));
                                                                System.out.println("Asiento comprado con exito!\n");
                                                                for (int i = 0; i < vc.size(); i++) {
                                                                    if (nomcli.equals(vc.elementAt(i).getNombre())) {
                                                                        vc.elementAt(i).setPuntos(vc.elementAt(i).getPuntos() + ptos);
                                                                        System.out.println("Se han acumulado " + ptos + " puntos en su cuenta");
                                                                        cliente.escritura(vc);
                                                                    }
                                                                }
                                                                salas.sobreescribir(lo, tsali);
                                                                taquilla.escritura(vt);
                                                                System.out.println("Accion ejecutada con exito!\n");
                                                            }
                                                        }

                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("--------------------------CANCELACION DE BOLETO---------------------------");
                                                    System.out.println("Los boletos comprados por el usuario " + nomcli + " son: ");
                                                    enco = false;
                                                    for (int i = 0; i < vt.size(); i++) {
                                                        if (nomcli.equals(vt.elementAt(i).getNombre())) {
                                                            System.out.println("Pelicula: " + vt.elementAt(i).getPelicula());
                                                            System.out.println("Asiento: " + vt.elementAt(i).getAsientoi() + " " + vt.elementAt(i).getAsientoj());
                                                            System.out.println("***************************");
                                                            enco = true;
                                                        }
                                                    }
                                                    if (enco == false) {
                                                        System.out.println("No existe ningun boleto comprado por este cliente!\n");
                                                        break;
                                                    }
                                                    System.out.println("Peliculas disponibles: ");
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        System.out.println(i + ".-" + vp.elementAt(i).getPeli());
                                                    }
                                                    System.out.println("Cual es la pelicula que desea cancelar su boleto: ");
                                                    npeli = leer.nextInt();
                                                    boolean ed = false;
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        if (npeli == i) {
                                                            pelicu = vp.elementAt(i).getPeli();
                                                            ed = true;
                                                        }
                                                    }
                                                    if (ed == false) {
                                                        System.out.println("Ingrese una pelicula disponible!\n");
                                                        break;
                                                    }
                                                    System.out.println("Ingrese las dos casillas para las cuales desea cancelar el boleto");
                                                    a = leer.nextInt();
                                                    b = leer.nextInt();
                                                    boolean ez = false;
                                                    for (int i = 1; i < vt.size(); i++) {
                                                        taquilla.lectura(vt);
                                                        if (nomcli.equals(vt.elementAt(i).getNombre()) && pelicu.equals(vt.elementAt(i).getPelicula()) && a == vt.elementAt(i).getAsientoi() && b == vt.elementAt(i).getAsientoj()) {
                                                            nsal = vt.elementAt(i).getNsal();
                                                            salas.leer(nsal, tsali);
                                                            tsali[vt.elementAt(i).getAsientoi()][vt.elementAt(i).getAsientoj()] = 0;
                                                            salas.sobreescribir(nsal, tsali);
                                                            vt.removeElementAt(i);
                                                            taquilla.escritura(vt);
                                                            for (int g = 0; g < vc.size(); g++) {
                                                                if (nomcli.equals(vc.elementAt(g).getNombre())) {
                                                                    vc.elementAt(g).setPuntos(vc.elementAt(g).getPuntos() - 10);
                                                                    System.out.println("Se han restado 10 ptos por su cancelacion");
                                                                    cliente.escritura(vc);
                                                                }
                                                            }
                                                            System.out.println("Cancelacion de boletos exitosa!\n");
                                                            ez = true;
                                                        }
                                                    }
                                                    if (ez == false) {
                                                        System.out.println("No existen boletos para este asiento o para este cliente\n");
                                                    }
                                                    /*for (int i = 1; i < vt.size(); i++) {
                                                        System.out.println("Nombre del cliente: "+vt.elementAt(i).getNombre());
                                                        System.out.println("Pelicula: "+vt.elementAt(i).getPelicula());
                                                        System.out.println("#Boletos: "+vt.elementAt(i).getBoletos());
                                                        System.out.println("Total: "+vt.elementAt(i).getTotal());
                                                        System.out.println("La fila de asiento es: "+vt.elementAt(i).getAsientoi());
                                                        System.out.println("La columna de asiento es: "+vt.elementAt(i).getAsientoj());
                                                        System.out.println("**********************************");
                                                    }*/
                                                    break;
                                                case 3:
                                                    System.out.println("---------------------------CAMBIO DE PELICULA-------------------------");
                                                    System.out.println("Los boletos comprados por el usuario " + nomcli + " son: ");
                                                    boolean ex = false;
                                                    for (int i = 0; i < vt.size(); i++) {
                                                        if (nomcli.equals(vt.elementAt(i).getNombre())) {
                                                            System.out.println("Pelicula: " + vt.elementAt(i).getPelicula());
                                                            System.out.println("Asiento: " + vt.elementAt(i).getAsientoi() + " " + vt.elementAt(i).getAsientoj());
                                                            System.out.println("***************************");
                                                            ex = true;
                                                        }
                                                    }
                                                    if (ex == false) {
                                                        System.out.println("No existe ningun boleto comprado por este cliente!\n");
                                                        break;
                                                    }
                                                    System.out.println("Peliculas disponibles: ");
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        System.out.println(i + ".-" + vp.elementAt(i).getPeli());
                                                    }
                                                    System.out.println("Cual es la pelicula que desea cambiar su boleto: ");
                                                    npeli = leer.nextInt();
                                                    pelicu = null;
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        if (npeli == i) {
                                                            pelicu = vp.elementAt(i).getPeli();
                                                        }
                                                    }
                                                    if (npeli >= 1 && npeli <= 5) {
                                                        String auxp = pelicu;
                                                        int auxa, auxb, auxs = 0;
                                                        System.out.println("Ingrese la fila y columna de su asiento a cambiar: ");
                                                        a = leer.nextInt();
                                                        b = leer.nextInt();
                                                        auxa = a;
                                                        auxb = b;
                                                        boolean ey = false;
                                                        for (int i = 0; i < vt.size(); i++) {
                                                            if (pelicu.equals(vt.elementAt(i).getPelicula()) && a == vt.elementAt(i).getAsientoi() && b == vt.elementAt(i).getAsientoj()) {
                                                                nsal = vt.elementAt(i).getNsal();
                                                                salas.leer(nsal, tsali);
                                                                tsali[a][b] = 0;
                                                                salas.sobreescribir(nsal, tsali);
                                                                vt.removeElementAt(i);
                                                                taquilla.escritura(vt);
                                                                auxs = nsal;
                                                                ey = true;
                                                            }
                                                        }
                                                        if (ey == false) {
                                                            System.out.println("No existe este asiento o usted no esta registrado en esta pelicula por favor reintente el proceso!\n");
                                                            break;
                                                        }

                                                        System.out.println("Peliculas disponibles");
                                                        for (int i = 1; i < vp.size(); i++) {
                                                            System.out.println(i + ".-" + vp.elementAt(i).getPeli());
                                                        }
                                                        System.out.println("Ingrese que pelicula desea ver: ");
                                                        npeli = leer.nextInt();
                                                        boolean ew = false;
                                                        lo = 0;
                                                        for (int i = 1; i < vp.size(); i++) {
                                                            if (npeli == i) {
                                                                pelicu = vp.elementAt(i).getPeli();
                                                                lo = vp.elementAt(i).getSala();
                                                                ew = true;
                                                            }
                                                        }
                                                        if (ew == false) {
                                                            System.out.println("Esta pelicula no existe, intente de nuevo!\n");
                                                            break;
                                                        }
                                                        total = 1 * precio;
                                                        salas.leer(lo, tsali);
                                                        for (int k = 0; k < 1; k++) {
                                                            conta = 0;
                                                            System.out.println("Los asientos disponibles son los que se encuentran en DIS: ");
                                                            System.out.print("     ");
                                                            for (int i = 0; i < 7; i++) {
                                                                System.out.print(i + "    ");
                                                            }
                                                            System.out.println("");
                                                            for (int i = 0; i < 7; i++) {
                                                                System.out.print(i + "  ");
                                                                for (int j = 0; j < 7; j++) {
                                                                    if (tsali[i][j] == 1) {
                                                                        System.out.print(" OCU ");
                                                                        conta++;
                                                                        if (conta == 49) {
                                                                            System.out.println("\nLa sala esta llena!\n");
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        System.out.print(" DIS ");
                                                                    }
                                                                }
                                                                System.out.println("");
                                                            }
                                                            if (conta == 49) {
                                                                tsali[auxa][auxb] = 1;
                                                                vt.addElement(new Taquilla(nomcli, auxp, 1, total, auxa, auxb, auxs));
                                                                salas.sobreescribir(auxs, tsali);
                                                                taquilla.escritura(vt);
                                                                break;
                                                            } else {
                                                                System.out.println("Ingrese el asiento en el que desea sentarse: ");
                                                                a = leer.nextInt();
                                                                b = leer.nextInt();
                                                                if (tsali[a][b] == 1) {
                                                                    System.out.println("Este asiento ya esta ocupado, intente de nuevo!\n");
                                                                    k--;
                                                                } else {

                                                                    tsali[a][b] = 1;
                                                                    vt.addElement(new Taquilla(nomcli, pelicu, 1, total, a, b, lo));
                                                                    System.out.println("Asiento comprado con exito!\n");
                                                                    salas.sobreescribir(lo, tsali);
                                                                    taquilla.escritura(vt);
                                                                    System.out.println("Accion ejecutada con exito!\n");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Reintente el proceso ingresando un numero de pelicula valido!\n");
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("----------------------------CAMBIO DE ASIENTOS------------------------------");
                                                    System.out.println("Los boletos comprados por el usuario " + nomcli + " son: ");
                                                    ex = false;
                                                    for (int i = 0; i < vt.size(); i++) {
                                                        if (nomcli.equals(vt.elementAt(i).getNombre())) {
                                                            System.out.println("Pelicula: " + vt.elementAt(i).getPelicula());
                                                            System.out.println("Asiento: " + vt.elementAt(i).getAsientoi() + " " + vt.elementAt(i).getAsientoj());
                                                            System.out.println("***************************");
                                                            ex = true;
                                                        }
                                                    }
                                                    if (ex == false) {
                                                        System.out.println("No existe ningun boleto comprado por este cliente!\n");
                                                        break;
                                                    }

                                                    System.out.println("Peliculas disponibles: ");
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        System.out.println(i + ".-" + vp.elementAt(i).getPeli());
                                                    }
                                                    System.out.println("Cual es la pelicula que desea cambiar su asiento: ");
                                                    npeli = leer.nextInt();
                                                    for (int i = 1; i < vp.size(); i++) {
                                                        if (npeli == i) {
                                                            pelicu = vp.elementAt(i).getPeli();
                                                        }
                                                    }
                                                    System.out.println("Ingrese la fila y columna de su asiento a cambiar: ");
                                                    a = leer.nextInt();
                                                    b = leer.nextInt();
                                                    boolean ey = false;
                                                    lo = 0;
                                                    for (int i = 0; i < vt.size(); i++) {
                                                        if (pelicu.equals(vt.elementAt(i).getPelicula()) && a == vt.elementAt(i).getAsientoi() && b == vt.elementAt(i).getAsientoj()) {
                                                            nsal = vt.elementAt(i).getNsal();
                                                            lo = nsal;
                                                            salas.leer(nsal, tsali);
                                                            tsali[a][b] = 0;
                                                            salas.sobreescribir(nsal, tsali);
                                                            ey = true;
                                                        }
                                                    }
                                                    if (ey == false) {
                                                        System.out.println("No existe este asiento o usted no esta registrado en esta pelicula por favor reintente el proceso!\n");
                                                        break;
                                                    }

                                                    total = 1 * precio;
                                                    salas.leer(lo, tsali);
                                                    for (int k = 0; k < 1; k++) {
                                                        System.out.println("Los asientos disponibles son los que se encuentran en DIS: ");
                                                        System.out.print("     ");
                                                        for (int i = 0; i < 7; i++) {
                                                            System.out.print(i + "    ");
                                                        }
                                                        System.out.println("");
                                                        for (int i = 0; i < 7; i++) {
                                                            System.out.print(i + "  ");
                                                            for (int j = 0; j < 7; j++) {
                                                                if (tsali[i][j] == 1) {
                                                                    System.out.print(" OCU ");
                                                                } else {
                                                                    System.out.print(" DIS ");
                                                                }
                                                            }
                                                            System.out.println("");
                                                        }
                                                        System.out.println("Ingrese el asiento en el que desea sentarse: ");
                                                        int z = leer.nextInt();
                                                        int y = leer.nextInt();
                                                        if (tsali[z][y] == 1) {
                                                            System.out.println("Este asiento ya esta ocupado, intente de nuevo!\n");
                                                            k--;
                                                        } else {
                                                            tsali[z][y] = 1;
                                                            for (int i = 0; i < vt.size(); i++) {
                                                                if (pelicu.equals(vt.elementAt(i).getPelicula()) && a == vt.elementAt(i).getAsientoi() && b == vt.elementAt(i).getAsientoj()) {
                                                                    vt.elementAt(i).setAsientoi(z);
                                                                    vt.elementAt(i).setAsientoj(y);
                                                                }
                                                            }
                                                            System.out.println("Asiento comprado con exito!\n");
                                                        }
                                                    }
                                                    salas.sobreescribir(lo, tsali);
                                                    taquilla.escritura(vt);
                                                    System.out.println("Accion ejecutada con exito!\n");

                                                    break;

                                                case 0:
                                                    System.out.println("¡Ha salido a la pantalla ventas!\n");
                                                    break;
                                                default:
                                                    System.out.println("Ingrese una opcion valida!\n");
                                                    break;
                                            }
                                        } while (hac != 0);
                                        break;
                                    case 2:
                                        do {
                                            cliente.lectura(vc);
                                            dulceria.lectura(vd);
                                            ventas.lectura(vv);
                                            System.out.println("----------------PRODUCTOS(DULCERIA)---------------------");
                                            System.out.println("INGRESE LO QUE DESEA HACER :\n1.-VENDER PRODUCTO\n2.-CANCELAR ALGUNA COMPRA\n0.-SALIR");
                                            hac = leer.nextInt();
                                            switch (hac) {
                                                case 1:
                                                    System.out.println("----------------------------VENDER PRODUCTO---------------------------");
                                                    System.out.println("Los productos disponibles son: ");
                                                    for (int i = 1; i < vd.size(); i++) {
                                                        System.out.println("#" + i);
                                                        System.out.println("Producto: " + vd.elementAt(i).getProd());
                                                        System.out.println("Cantidad: " + vd.elementAt(i).getCantidad());
                                                        System.out.println("Precio: " + vd.elementAt(i).getPred());
                                                        System.out.println("**************************");
                                                    }
                                                    System.out.println("Ingrese el numero de que producto desea comprar!");
                                                    pdul = leer.nextInt();
                                                    boolean tie = false;
                                                    pro = null;
                                                    tol = 0;
                                                    ct = 0;
                                                    for (int i = 0; i < vd.size(); i++) {
                                                        if (pdul == i) {
                                                            pro = vd.elementAt(i).getProd();
                                                            tol = vd.elementAt(i).getPred();
                                                            ct = vd.elementAt(i).getCantidad();
                                                            tie = true;
                                                        }
                                                    }
                                                    if (tie == false) {
                                                        System.out.println("Este producto no existe reintente el proceso!\n");
                                                        break;
                                                    }
                                                    System.out.println("Ingrese la cantidad de " + pro + " a comprar");
                                                    ca = leer.nextInt();
                                                    total = tol * ca;
                                                    System.out.println("El total es de " + total + " pesos");
                                                    boolean ult = false;
                                                    for (int i = 0; i < vc.size(); i++) {
                                                        if (nomcli.equals(vc.elementAt(i).getNombre())) {
                                                            ult = true;
                                                            System.out.println("Ingrese como desea pagar 1.-Puntos 2.-Efectivo");
                                                            int al = leer.nextInt();
                                                            if (al == 1) {
                                                                if (total <= vc.elementAt(i).getPuntos() && ca <= ct) {
                                                                    System.out.println("Usted ha podido comprarlo con puntos!\n ");
                                                                    vc.elementAt(i).setPuntos(vc.elementAt(i).getPuntos() - total);
                                                                    for (int j = 0; j < vd.size(); j++) {
                                                                        if (pro.equals(vd.elementAt(j).getProd())) {
                                                                            vd.elementAt(j).setCantidad(vd.elementAt(j).getCantidad() - ca);
                                                                        }
                                                                    }
                                                                    vv.addElement(new Venta(nomcli, pro, ca, 0, total));
                                                                    ventas.escritura(vv);
                                                                    dulceria.escritura(vd);
                                                                    cliente.escritura(vc);
                                                                } else {
                                                                    System.out.println("No son suficiente sus puntos o no existen suficientes productos!\n");
                                                                    break;
                                                                }
                                                            } else if (al == 2) {
                                                                System.out.println("Ingrese el dinero en efectivo a dar: ");
                                                                int efe = leer.nextInt();
                                                                if (efe >= total && ca <= ct) {
                                                                    System.out.println("Ha comprado con exito los productos, su feria es: " + (efe - total));
                                                                    for (int j = 0; j < vd.size(); j++) {
                                                                        if (pro.equals(vd.elementAt(j).getProd())) {
                                                                            vd.elementAt(j).setCantidad(vd.elementAt(j).getCantidad() - ca);
                                                                        }
                                                                    }
                                                                    vv.addElement(new Venta(nomcli, pro, ca, total, 0));
                                                                    ventas.escritura(vv);
                                                                    dulceria.escritura(vd);
                                                                } else {
                                                                    System.out.println("No es suficiente el efectivo con el que cuenta!\n");
                                                                    break;
                                                                }
                                                            } else {
                                                                System.out.println("Reintente de nuevo el proceso!\n");
                                                                i--;
                                                            }
                                                        }

                                                    }
                                                    if (ult == false) {
                                                        System.out.println("Ingrese el dinero en efectivo a dar: ");
                                                        int efe = leer.nextInt();
                                                        if (efe >= total && ca <= ct) {
                                                            System.out.println("Ha comprado con exito los productos, su feria es: " + (efe - total));
                                                            for (int j = 0; j < vd.size(); j++) {
                                                                if (pro.equals(vd.elementAt(j).getProd())) {
                                                                    vd.elementAt(j).setCantidad(vd.elementAt(j).getCantidad() - ca);
                                                                }
                                                            }
                                                            vv.addElement(new Venta(nomcli, pro, ca, total, 0));
                                                            ventas.escritura(vv);
                                                            dulceria.escritura(vd);
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("----------------------CANCELACION DE COMPRA----------------------");
                                                    System.out.println("Las compras del cliente: " + nomcli);
                                                    boolean comp = false;
                                                    int vent;
                                                    enco = false;
                                                    for (int i = 0; i < vv.size(); i++) {
                                                        if (nomcli.equals(vv.elementAt(i).getNombre())) {
                                                            System.out.println("#" + i);
                                                            System.out.println("Producto: " + vv.elementAt(i).getProducto());
                                                            System.out.println("Cantidad: " + vv.elementAt(i).getCantidad());
                                                            System.out.println("Efectivo pagado: " + vv.elementAt(i).getEfectivo());
                                                            System.out.println("Puntos pagados: " + vv.elementAt(i).getPuntos());
                                                            System.out.println("*********************************************");
                                                            enco = true;
                                                        }
                                                    }
                                                    if (enco == false) {
                                                        System.out.println("No hay ninguna compra hecha por este cliente!");
                                                        break;
                                                    }
                                                    System.out.println("Ingrese el numero de compra a cancelar: ");
                                                    vent = leer.nextInt();
                                                    for (int i = 1; i < vv.size(); i++) {
                                                        if (vent == i) {
                                                            String producto1 = vv.elementAt(i).getProducto();
                                                            comp = true;
                                                            for (int j = 0; j < vd.size(); j++) {
                                                                if (vv.elementAt(i).getProducto().equals(vd.elementAt(j).getProd())) {
                                                                    vd.elementAt(j).setCantidad(vd.elementAt(j).getCantidad() + vv.elementAt(i).getCantidad());
                                                                    vv.elementAt(i).setCantidad(0);
                                                                    vv.elementAt(i).setEfectivo(0);
                                                                    for (int k = 0; k < vc.size(); k++) {
                                                                        if (nomcli.equals(vc.elementAt(k).getNombre())) {
                                                                            vc.elementAt(k).setPuntos(vc.elementAt(k).getPuntos() + vv.elementAt(i).getPuntos());
                                                                            vv.elementAt(i).setPuntos(0);
                                                                            vv.removeElementAt(i);
                                                                            ventas.escritura(vv);
                                                                            cliente.escritura(vc);
                                                                            dulceria.escritura(vd);
                                                                            System.out.println("Cancelacion de compra exitosa!\n");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (comp == false) {
                                                        System.out.println("Este producto no existe por favor reintente el proceso!\n");
                                                    }
                                                    break;
                                                case 0:
                                                    System.out.println("Ha salido a la pantalla ventas!\n");
                                                    break;
                                                default:
                                                    System.out.println("Ingrese una opcion valida!\n");
                                                    break;
                                            }
                                        } while (hac != 0);
                                        break;
                                    case 0:
                                        System.out.println("¡Ha salido a la pantalla principal!\n");
                                        break;
                                    default:
                                        System.out.println("¡Ingrese una opcion valida!\n");
                                        break;
                                }
                            } while (acc != 0);
                            break;
                        //DULCERIA
                        case 3:
                            do {
                                dulceria.lectura(vd);
                                System.out.println("--------------------DULCERIA--------------------");
                                System.out.println("INGRESE LO QUE DESEA HACER:\n1.-REGISTRAR PRODUCTO(DULCE)\n2.-ACTUALIZAR PRODUCTO\n3.-MOSTRAR TODOS LOS PRODUCTOS\n0.-SALIR A LA PANTALLA PRINCIPAL\n");
                                acc = leer.nextInt();
                                switch (acc) {
                                    case 1:
                                        dulceria.lectura(vd);
                                        System.out.println("---------------------------REGISTRAR PRODUCTO--------------------------");
                                        System.out.println("Ingrese el nombre del producto: ");
                                        leer.nextLine();
                                        prod = leer.nextLine();
                                        prod = prod.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vd.size(); i++) {
                                            if (prod.equals(vd.elementAt(i).getProd())) {
                                                System.out.println("Este producto ya existe y no puede ser registrado!\n");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Ingrese la cantidad del producto: ");
                                            cantidad = leer.nextInt();
                                            System.out.println("Ingrese el precio del producto: ");
                                            pred = leer.nextInt();
                                            vd.addElement(new Dulceria(prod, cantidad, pred));
                                            dulceria.escritura(vd);
                                            System.out.println("Producto añadido con exito!\n");
                                        }
                                        break;
                                    case 2:
                                        dulceria.lectura(vd);
                                        System.out.println("----------------------------ACTUALIZAR PRODUCTO-------------------------------");
                                        System.out.println("Los productos disponibles son: ");
                                        for (int i = 1; i < vd.size(); i++) {
                                            System.out.println("Producto: " + vd.elementAt(i).getProd());
                                        }
                                        System.out.println("Ingrese el nombre del producto: ");
                                        leer.nextLine();
                                        prod = leer.nextLine();
                                        prod = prod.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vd.size(); i++) {
                                            if (prod.equals(vd.elementAt(i).getProd())) {
                                                System.out.println("Añada la nueva cantidad del producto: ");
                                                cantidad = leer.nextInt();
                                                vd.elementAt(i).setCantidad(cantidad);
                                                System.out.println("Ingrese el nuevo precio del producto: ");
                                                pred = leer.nextInt();
                                                vd.elementAt(i).setPred(pred);
                                                dulceria.escritura(vd);
                                                System.out.println("Producto actualizado con exito!\n");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Este producto no existe y por eso no puede ser actualizado!\n");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("------------------------MOSTRAR TODOS LOS PRODUCTOS------------------------");
                                        System.out.println("A continuacion se mostraran todos los productos disponibles en dulceria");
                                        for (int i = 1; i < vd.size(); i++) {
                                            System.out.println("# Producto " + i);
                                            System.out.println("Producto: " + vd.elementAt(i).getProd());
                                            System.out.println("Cantidad: " + vd.elementAt(i).getCantidad());
                                            System.out.println("Precio: " + vd.elementAt(i).getPred());
                                            System.out.println("****************************************");
                                        }
                                        break;
                                    case 0:
                                        System.out.println("¡Ha salido a la pantalla principal!\n");
                                        break;
                                    default:
                                        System.out.println("¡Ingrese una opcion valida!\n");
                                        break;
                                }
                            } while (acc != 0);
                            break;
                        //PELICULA
                        case 4:
                            do {
                                pelicula.lectura(vp);
                                System.out.println("-----------------------PELICULA------------------------");
                                System.out.println("INGRESE LO QUE DESEA HACER:\n1.-REGISTRAR PELICULA\n2.-ACTUALIZACION DE VIGENCIA\n3.-ELIMINAR PELICULA\n4.-HISTORIAL DE PELICULAS\n0.-SALIR A LA PANTALLA PRINCIPAL\n");
                                acc = leer.nextInt();
                                switch (acc) {
                                    case 1:
                                        System.out.println("--------------------REGISTRAR PELICULA------------------");
                                        System.out.println("Las peliculas disponibles son: ");
                                        for (int i = 1; i < vp.size(); i++) {
                                            System.out.println("Pelicula: " + vp.elementAt(i).getPeli());
                                        }
                                        System.out.println("Ingrese el nombre de la pelicula: ");
                                        leer.nextLine();
                                        peli = leer.nextLine();
                                        peli = peli.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vp.size(); i++) {
                                            if (peli.equals(vp.elementAt(i).getPeli())) {
                                                System.out.println("Esta pelicula ya existe y no puede ingresarse!\n");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Ingrese el genero de la pelicula: ");
                                            genero = leer.nextLine();
                                            System.out.println("Ingrese el nombre del director de la pelicula: ");
                                            director = leer.nextLine();
                                            System.out.println("Ingrese la duracion de la pelicula en minutos: ");
                                            duracion = leer.nextInt();
                                            int dia, mes, año;
                                            System.out.println("Ingrese la vigencia de la pelicula: ");
                                            System.out.print("Ingrese el dia: ");
                                            dia = leer.nextInt();
                                            System.out.print("Ingrese el mes: ");
                                            mes = leer.nextInt();
                                            System.out.print("Ingrese el año: ");
                                            año = leer.nextInt();
                                            if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && año >= 2017) {
                                                vigencia = Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(año);
                                            } else {
                                                System.out.println("Esta fecha es imposible!");
                                                break;
                                            }
                                            System.out.println("Ingrese la sala en donde será registrada: ");
                                            sala = leer.nextInt();
                                            existe1 = false;
                                            for (int i = 0; i < vp.size(); i++) {
                                                if (sala == vp.elementAt(i).getSala()) {
                                                    System.out.println("Esta sala no esta disponible por favor ingrese otra sala!\n");
                                                    existe1 = true;
                                                }
                                                if (sala <= 0 || sala >= 6) {
                                                    System.out.println("Esta sala no existe por favor ingrese una sala entre 1-5\n");
                                                    existe1 = true;
                                                }
                                            }
                                            if (existe1 == false) {
                                                vp.addElement(new Pelicula(peli, genero, director, duracion, sala, vigencia));
                                                pelicula.escritura(vp);
                                                System.out.println("Pelicula agregada con exito!\n");
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("------------------ACTUALIZAR VIGENCIA-------------------");
                                        System.out.println("Las peliculas disponibles son: ");
                                        for (int i = 1; i < vp.size(); i++) {
                                            System.out.println("Pelicula: " + vp.elementAt(i).getPeli());
                                        }
                                        System.out.println("Ingrese el nombre de la pelicula: ");
                                        leer.nextLine();
                                        peli = leer.nextLine();
                                        peli = peli.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vp.size(); i++) {
                                            if (peli.equals(vp.elementAt(i).getPeli())) {
                                                int dia, mes, año;
                                                System.out.println("Ingrese la nueva vigencia de la pelicula: ");
                                                System.out.print("Ingrese el dia: ");
                                                dia = leer.nextInt();
                                                System.out.print("Ingrese el mes: ");
                                                mes = leer.nextInt();
                                                System.out.print("Ingrese el año: ");
                                                año = leer.nextInt();
                                                if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && año >= 2017) {
                                                    vigencia = Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(año);
                                                } else {
                                                    System.out.println("Esta fecha es imposible!");
                                                    existe=true;
                                                    break;
                                                }
                                                vp.elementAt(i).setVigencia(vigencia);
                                                pelicula.escritura(vp);
                                                System.out.println("Vigencia actualizada con exito!\n");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Esta pelicula no existe y no puede actualizarse!\n");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("------------------ELIMINAR PELICULA------------------");
                                        System.out.println("Las peliculas disponibles son: ");
                                        for (int i = 1; i < vp.size(); i++) {
                                            System.out.println("Pelicula: " + vp.elementAt(i).getPeli());
                                        }
                                        System.out.println("Ingrese el nombre de la pelicula: ");
                                        leer.nextLine();
                                        peli = leer.nextLine();
                                        peli = peli.toLowerCase();
                                        existe = false;
                                        for (int i = 0; i < vp.size(); i++) {
                                            if (peli.equals(vp.elementAt(i).getPeli())) {
                                                vp.removeElementAt(i);
                                                pelicula.escritura(vp);
                                                System.out.println("Pelicula removida con exito!\n");
                                                existe = true;
                                            }
                                        }
                                        if (existe == false) {
                                            System.out.println("Esta pelicula no existe y no puede ser removida!\n");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("------------------HISTORIAL DE PELICULAS-------------------");
                                        System.out.println("¡SE MOSTRARA EL HISTORIAL DE TODAS LAS PELICULAS REGISTRADAS!");
                                        for (int i = 1; i < vp.size(); i++) {
                                            System.out.println("# Pelicula " + i);
                                            System.out.println("El nombre de la pelicula es: " + vp.elementAt(i).getPeli());
                                            System.out.println("Su genero es: " + vp.elementAt(i).getGenero());
                                            System.out.println("El nombre del director: " + vp.elementAt(i).getDirector());
                                            System.out.println("La duracion de la pelicula es: " + vp.elementAt(i).getDuracion());
                                            System.out.println("La pelicula tiene vigencia hasta: " + vp.elementAt(i).getVigencia());
                                            System.out.println("La sala de la pelicula es: " + vp.elementAt(i).getSala());
                                            System.out.println("******************************************************************");
                                        }
                                        System.out.println("");
                                        break;
                                    case 0:
                                        System.out.println("¡Ha salido a la pantalla principal!\n");
                                        break;
                                    default:
                                        System.out.println("¡Ingrese una opcion valida!\n");
                                        break;
                                }
                            } while (acc != 0);
                            break;
                        case 0:
                            System.out.println("¡Ha salido con exito!\n");
                            break;
                        default:
                            System.out.println("¡Ingrese una opción correcta!\n");
                            break;
                    }
                    continuar = false;
                } catch (NullPointerException e) {
                    leer.nextLine();
                    System.out.println("No existe pelicula con este numero\n");
                } catch (InputMismatchException e) {
                    leer.nextLine();
                    System.err.println("Por favor ingrese formato correcto!\n");
                } catch (ArrayIndexOutOfBoundsException e) {
                    leer.nextLine();
                    System.err.println("Este asiento no existe, reintente el proceso ingresando el asiento correcto\n");
                } catch (Exception e) {
                    leer.nextLine();
                    System.err.println("Ha ocurrido un error " + e + " \n");
                }
            } while (continuar == true);
        } while (opc != 0);
    }

}
