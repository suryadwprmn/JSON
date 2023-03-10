package connect;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConnectURI {
    //pembuatan JSON
    private final String USER_AGENT = "mozilla/5.0";
    public static URL buildURL(String urlQuey){
        URL url = null;
        try {
            url = new URL(urlQuey.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput){
                return scanner.next();
            }
            else {
                return null;
            }

        }
        finally {
            urlConnection.disconnect();
        }
    }
}

