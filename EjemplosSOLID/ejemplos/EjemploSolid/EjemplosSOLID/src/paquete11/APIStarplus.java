package paquete11;

/**
 *
 * @author santy
 */
public class APIStarplus implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        apiKey = ak+"STAR+5236662";
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
    
}
