package utilities;

import android.os.AsyncTask;

import java.io.IOException;

public class NewsQueryTask extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... voids) {
        try {
            String json = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildURL());
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}