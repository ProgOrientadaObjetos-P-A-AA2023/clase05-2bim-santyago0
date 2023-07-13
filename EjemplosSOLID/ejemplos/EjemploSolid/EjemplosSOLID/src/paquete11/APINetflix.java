/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

import java.util.Random;


public class APINetflix implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        Random r = new Random();
        int random = r.nextInt(85922012);
        apiKey = ak + random;
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
    
}
