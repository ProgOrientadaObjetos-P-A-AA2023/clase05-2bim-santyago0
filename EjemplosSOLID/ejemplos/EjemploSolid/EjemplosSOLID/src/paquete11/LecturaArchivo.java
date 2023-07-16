package paquete11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author santy
 */
public class LecturaArchivo {
    
    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<GeneradorPelicula> lista;

    public LecturaArchivo(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("datos/%s", nombreArchivo);
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
            }
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("datos/%s.txt",
                obtenerNombreArchivo());
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }
    
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                
                GeneradorPelicula p = new GeneradorPelicula();
                
                /* Se establece el usuario y el tipo de servicio con los métodos
                establecer, y a través de la separación realizada por el ArrayList
                "linea_partes", donde en la posición 1 está el usuario, y en la
                2 el tipo de servicio
                */
                p.establecerUsername(linea_partes.get(1));
                p.establecerServicio(linea_partes.get(2));
                
                lista.add(p);
            }
        }
    }

    public ArrayList<GeneradorPelicula> obtenerLista() {

        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        }

    }
    
}
