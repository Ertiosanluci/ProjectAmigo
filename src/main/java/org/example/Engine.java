package org.example;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Scanner;

public class Engine {
    public void ini() throws FileNotFoundException {
        boolean continuar = true;
        String fichero = "listaamigos.txt";
        TreeSet<Amigo> misamigos = new TreeSet<>(Comparator.comparing(Amigo::getNombre));
        int opcion;
        Scanner Miscanner = new Scanner(System.in);
        try {
            File friends = new File(fichero);
            if (!friends.exists()) {
                friends.createNewFile();
            }
            FileInputStream fis = new FileInputStream(friends);
            ObjectInputStream ois = new ObjectInputStream(fis);
            var in = new ObjectInputStream(new FileInputStream(fichero));

            Amigo a;
            while (true) {
                misamigos.add((Amigo) ois.readObject());
            }


        }catch (EOFException eo){
            eo.printStackTrace();
    }catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        while (continuar) {
            opcion = 0;
            System.out.println("Bienvenido a la biblioteca amigos");
            System.out.println("Pulsa 1 para almacenar amigos");
            System.out.println("Pulsa 2 para ver la lista de amigos");
            System.out.println("Pulsa 3 para borrar amigos");
            System.out.println("Pulsa 4 para salir");
            opcion = Miscanner.nextInt();
            switch (opcion) {
                case 1:
                    if (almacenaramigos(misamigos, fichero)) {
                        System.out.println("Amigo insertado correctamente");
                    }else {
                        System.out.println("No se ha podido insertar el amigo, ya existe");
                    }
                    break;
                case 2:
                    verAmigos(misamigos);
                    break;
                case 3:
                    borrarAmigos(misamigos);
                    break;
                case 4:
                    continuar= salir(misamigos, fichero);
                        break;
            }

        }
    }

    public Boolean almacenaramigos(TreeSet<Amigo> amigos, String directorio) {
        String name, apellidos, fechanacimiento;
        System.out.println("Dime el nombre de tu amigo");
        name = filtro();
        System.out.println("Dime el apellido de tu amigo");
        apellidos = filtro();
        System.out.println("Dime la fecha de nacimiento");
        fechanacimiento = filtro();
        Amigo miamigo = new Amigo(name, apellidos, fechanacimiento);
        return amigos.add(miamigo);

    }
public String filtro(){
    Scanner sc = new Scanner(System.in);
        String cadena;

        do{
            cadena = sc.nextLine();
        }while (cadena.length()==0);
        return cadena;
}
    public boolean salir(TreeSet<Amigo> a, String directorio) throws FileNotFoundException {
        try {
            File f = new File(directorio);
            if (f.exists()) {
                FileOutputStream fs = new FileOutputStream(directorio);
                ObjectOutputStream oos = new ObjectOutputStream(fs);
                for (Amigo i : a) {
                   oos.writeObject(i);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void verAmigos(TreeSet<Amigo> a){
        System.out.println(a.toString());
    }
    public void borrarAmigos(TreeSet<Amigo> a){
        // no vas a tener dos amigos que se llamen igual y encima que hayan nacido el mismo día, tu tah loco.
        String nombre, apellido;
        System.out.println("Qué amigos quieres borrar");
        System.out.println("Primero dime su nombre");
        nombre = filtro();
        System.out.println("Ahora dime su apellido");
        apellido = filtro();
        Amigo amego = new Amigo(nombre, apellido, "");
        a.remove(amego);
    }
}
