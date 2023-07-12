package paquete11;

/**
 *
 * @author santy
 */
public class APIDisney implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        apiKey = ak+"DISNEY115631";
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
    
}
