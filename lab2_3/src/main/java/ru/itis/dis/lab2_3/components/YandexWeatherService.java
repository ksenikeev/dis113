package ru.itis.dis.lab2_3.components;

import ru.itis.dis.lab2_3.IWeatherService;
import ru.itis.dis.lab2_3.annotations.Component;
import ru.itis.dis.lab2_3.annotations.Propertie;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class YandexWeatherService implements IWeatherService {

    @Propertie
    private String yandexKey;

    @Override
    public String getWeather(String lat, String lon) {


        String result = "";

        try {
            URL url = new URL("https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestProperty("X-Yandex-API-Key", yandexKey);

            int code = connection.getResponseCode();

            System.out.println(code);

            if (code == 200) {
                int cl = connection.getContentLength();
                byte[] buffer = new byte[cl];

                InputStream is = connection.getInputStream();
                int r;
                while ((r = is.read(buffer)) != -1 ) {
                    result = result + new String(buffer,0,r);
                }

            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

}
