/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

import java.util.Random;


public class APIAmazonMovie implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        Random r = new Random();
        /* Con la librería que elegimos para el random se debe crear un objeto
        de tipo Random */
        int random = r.nextInt(9021548);
        /* A una variable entera le damos el valor random hasta él número en el
        paréntesis, que sería el límite */
        apiKey = ak + random;
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
    
}
