package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonReader {
    private static final String KEY = "9db4d5104fdfa59f53f20d5e98c6dd31";
    private String city;
    private String urlAddress;

    public JsonReader(String city) {
        this.city = city;
    }

    public String read() {
        urlAddress = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + KEY + "&units=metric&lang=ru";
        HttpURLConnection urlConnection = null;
        StringBuilder stringBuilder = null;
        URL url;
        try {
            url = new URL(urlAddress);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            try (InputStream inputStream = urlConnection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                stringBuilder = new StringBuilder();

                while (reader.ready()) {
                    stringBuilder.append(reader.readLine()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        if (stringBuilder != null) {
            return stringBuilder.toString();
        } else {
            return "Something went wrong";
        }
    }


    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader("Kyiv");
        System.out.println(jsonReader.read());

    }
}

