package utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {


    /**
     * These utilities will be used to communicate with the network.
     */

    final static String NEWS_API_URL =
            "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=fa4628e1880d447eb17e1e34514a2dda";


    public static URL buildURL (){
        Uri builtUri = Uri.parse(NEWS_API_URL).buildUpon(). build();

        URL url = null;


        try{
            url = new URL(builtUri.toString());
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }

        return url;

    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
