package archibook;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.StringEntity;

public class HttpPostReq {
    
    public String JSONString;
    public String APIkey;
    
    public HttpPostReq(String JSONString2, String APIkey2){
            JSONString = JSONString2;
            APIkey = APIkey2;
        }

    public void send() {
       

        String url = "https://project-archibook.000webhostapp.com/";

        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
        //e34a2154179b291826b06d2c80db04b38899ac4208c564ab7cf6d481ad1585eb
        try {
            HttpPost request = new HttpPost(url+ "api.php/" + APIkey);
            
            StringEntity params =new StringEntity(JSONString);
            
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            // handle response here...
            System.out.println(response);
        }
        
        catch (Exception ex) {
            // handle exception here
        }
    }






}
