/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

public class GeneradorPelicula {
    
    private APIMovie llave;
    private String url;
    private String servicio;
    private String username;
    // agregar un user (tipo String)
    
    public void establecerLlave(APIMovie l){ // APINetflix, APIAmazon
        llave = l;
    }
    
    public void establecerUrl(){
        url = String.format("http://api.movie?api="
                + "%s/%s",username,obtenerLlave().obtenerApiKey());
    }
    
    public void establecerServicio(String s) {
        servicio = s;
    }
    
    public void establecerUsername(String u) {
        username = u;
    }
    
    public APIMovie obtenerLlave(){
        return llave;
    }
    
    public String obtenerUrl(){
        return url;
    }
    
    public String obtenerServicio() {
        return servicio;
    }
    
    public String obtenerUsername() {
        return username;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("%s\n",url);
        return cadena;
    }
    
}
