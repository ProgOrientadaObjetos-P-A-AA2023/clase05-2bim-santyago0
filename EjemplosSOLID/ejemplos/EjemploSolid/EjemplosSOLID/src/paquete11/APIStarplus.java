package paquete11;

import java.util.Random;

/**
 *
 * @author santy
 */
public class APIStarplus implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        Random r = new Random();
        int random = r.nextInt(15121644);
        apiKey = ak + random;
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
    
}
