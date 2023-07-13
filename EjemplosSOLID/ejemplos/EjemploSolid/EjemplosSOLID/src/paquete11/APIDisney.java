package paquete11;

import java.util.Random;

/**
 *
 * @author santy
 */
public class APIDisney implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        Random r = new Random();
        int random = r.nextInt(26559262);
        apiKey = ak + random;
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
    
}
