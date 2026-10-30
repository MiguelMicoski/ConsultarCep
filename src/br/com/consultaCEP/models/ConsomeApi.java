package br.com.consultaCEP.models;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeApi {

    private String json;
    public String getJson() {
        return json;
    }

    public Endereco buscacep2(String key) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + key + "/json/"))
                .build();
        if(key.length() > 8){
            throw new IllegalArgumentException("O CEP deve conter 8 caracteres");
        }
        HttpResponse <String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Endereco.class);
    }


}
