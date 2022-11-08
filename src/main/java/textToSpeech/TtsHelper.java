package textToSpeech;


import credentials.Credentials;
import okhttp3.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/*            The problem :
                    What response.body content is ?
                    Main goal ,download the audio from the body and play it in IDE
 */


public class TtsHelper
{
    public static void getSpeech()
    {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("http://api.voicerss.org/?key=%s&hl=en-us&c=MP3&f=16khz_16bit_stereo&src=Hello,world!",Credentials.key)))
                .build();
        try
        {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body()); uncomment this to see the error
            System.out.println(response.uri());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
