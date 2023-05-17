package ru.itis.semestrii.rest.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.semestrii.rest.dto.CountryDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

public class CurrencyClient {
    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/central/country/all"))
                .GET() .build();

            HttpResponse response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String resp = (String) response.body();

            ObjectMapper mapper = new ObjectMapper();



            List<CountryDto> countryList = mapper
                    .readValue(resp, new TypeReference<List<CountryDto>>() { });
            countryList.forEach(System.out::println);



        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
