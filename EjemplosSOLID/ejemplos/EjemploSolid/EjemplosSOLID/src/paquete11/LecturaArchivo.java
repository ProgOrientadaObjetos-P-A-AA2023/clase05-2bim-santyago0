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
                
                /* Se generan varios if para comparar que tipo de API se debe
                generar, esto se lo hace mediante el indice 2 del ArrayList
                "linea_partes", que divide las líneas del archivo en base al (;)
                */
                if(linea_partes.get(2).equals("Netflix")) {
                    APINetflix api = new APINetflix();
                    String apiKey = String.format("%s",
                            linea_partes.get(2));
                    /* Se crea un String con la cadena de la posición 2 del
                    ArrayList, que en este caso sería el tipo de servicio; y 
                    como el establecerApiKey recive un String que después lo 
                    concatena con el número random, y así poder crear la ApiKey
                    */
                    api.establecerApiKey(apiKey);
                    
                    p.establecerLlave(api);
                    String urlFinal = String.format("http://api.movie?api="
                            + "%s/",linea_partes.get(1));
                    /* En un String "urlFinal", se crea una dadena que contiene
                    todo el URL, con el usuario, que se obtiene de la posición 1
                    del ArrayList */
                    p.establecerUrl(urlFinal);
                    lista.add(p);
                }
                // Comparación para los demás servicios
                if(linea_partes.get(2).equals("Disney")) {
                    APIDisney api = new APIDisney();
                    String apiKey = String.format("%s",
                            linea_partes.get(2));
                    api.establecerApiKey(apiKey);
                    
                    p.establecerLlave(api);
                    String urlFinal = String.format("http://api.movie?api="
                            + "%s/",linea_partes.get(1));
                    p.establecerUrl(urlFinal);
                    lista.add(p);
                }
                
                // Comparación para los demás servicios
                if(linea_partes.get(2).equals("Amazon")) {
                    APIAmazonMovie api = new APIAmazonMovie();
                    String apiKey = String.format("%s",
                            linea_partes.get(2));
                    api.establecerApiKey(apiKey);
                    
                    p.establecerLlave(api);
                    String urlFinal = String.format("http://api.movie?api="
                            + "%s/",linea_partes.get(1));
                    p.establecerUrl(urlFinal);
                    lista.add(p);
                }
                
                // Comparación para los demás servicios
                if(linea_partes.get(2).equals("Startplus")) {
                    APIStarplus api = new APIStarplus();
                    String apiKey = String.format("%s",
                            linea_partes.get(2));
                    api.establecerApiKey(apiKey);
                    
                    p.establecerLlave(api);
                    String urlFinal = String.format("http://api.movie?api="
                            + "%s/",linea_partes.get(1));
                    p.establecerUrl(urlFinal);
                    lista.add(p);
                }

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

    @Override
    public String toString() {
        String cadena = "Lista de URLs:\n";
        
        for (int i = 0; i < obtenerLista().size(); i++) {
            GeneradorPelicula p = obtenerLista().get(i);
            
            cadena = String.format("%s(%d) %s\n", cadena,
                    i + 1,
                    p.obtenerUrl());
        }
        return cadena;
    }
    
}
