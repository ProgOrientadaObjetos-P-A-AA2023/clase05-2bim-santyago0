/*
 * 
 * D - Dependency inversion principle (Principio de inversión de dependencias)
 */
package paquete11;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        
        // Grupo 7
        
        /*
        Usar el txt llamado usuarios.txt; por cada línea del archivo
        crer un API en función de su servicio; además el API ahora genera
        información estática (no cambia el API), se debe buscar la forma que el 
        API sea dinámico totalmente (usar alguna librería propia de JAVA, Servicio 
        Random); la url final debe contener el Servicio de servicio y el username
        Por cada objeto de Servicio GeneradoPelicula presentar la información 
        a través de un toString
        */
        
        // Variable con el nombre del archivo
        String nombreArchivo = "usuarios.txt";
        
        /* Objeto de Servicio LecturaArchivo, que recive como parámetro el nombre
        del archivo */
        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.establecerLista();
        // Se establece la lista con los datos del archivo
        
        ArrayList<GeneradorPelicula> lista = new ArrayList<>();

        // Comparación de los tipos para generar las API correctas
        for (int i = 0; i < lectura.obtenerLista().size(); i++) {
            GeneradorPelicula p = new GeneradorPelicula();

            if (lectura.obtenerLista().get(i).obtenerServicio().
                    equals("Netflix")) {
                APINetflix api = new APINetflix();
                
                api.establecerApiKey(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerLlave(api);
                
                p.establecerServicio(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerUsername(lectura.obtenerLista().get(i).
                        obtenerUsername());
                p.establecerUrl();
                
                lista.add(p);
            }
            
            if (lectura.obtenerLista().get(i).obtenerServicio().
                    equals("Disney")) {
                APIDisney api = new APIDisney();
                
                api.establecerApiKey(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerLlave(api);
                
                p.establecerServicio(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerUsername(lectura.obtenerLista().get(i).
                        obtenerUsername());
                p.establecerUrl();
                
                lista.add(p);
            }
            
            if (lectura.obtenerLista().get(i).obtenerServicio().
                    equals("Amazon")) {
                APIAmazonMovie api = new APIAmazonMovie();
                
                api.establecerApiKey(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerLlave(api);
                
                p.establecerServicio(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerUsername(lectura.obtenerLista().get(i).
                        obtenerUsername());
                p.establecerUrl();
                
                lista.add(p);
            }
            
            if (lectura.obtenerLista().get(i).obtenerServicio().
                    equals("Startplus")) {
                APIStarplus api = new APIStarplus();
                
                api.establecerApiKey(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerLlave(api);
                
                p.establecerServicio(lectura.obtenerLista().get(i).
                        obtenerServicio());
                p.establecerUsername(lectura.obtenerLista().get(i).
                        obtenerUsername());
                p.establecerUrl();
                
                lista.add(p);
            }
        }
        
        // Se imprime la lista mediante el toString de GeneradorPelicula
        System.out.println("Lista de URLs:");
        for(int i = 0; i < lista.size(); i++) {
            System.out.printf("(%d) %s",i+1,lista.get(i));
        }
        
        lectura.cerrarArchivo(); // Se cierra el archivo
    }
}
