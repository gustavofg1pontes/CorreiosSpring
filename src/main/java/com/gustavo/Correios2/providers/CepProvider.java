package com.gustavo.Correios2.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gustavo.Correios2.models.Cep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CepProvider {
    private static final String BASE_URL = "https://brasilapi.com.br/api/cep/v1/";

    public static Cep fetchAddressInfoByCep(String cep) {
        try {
            final HttpClient client = HttpClient.newHttpClient();

            final HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .timeout(Duration.ofSeconds(10))
                    .uri(URI.create(BASE_URL + cep))
                    .build();

            final HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (resp.statusCode() != 200) {
                return null;
            }

            final Gson gson = new GsonBuilder().create();

            return gson.fromJson(resp.body(), Cep.class);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CepProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
