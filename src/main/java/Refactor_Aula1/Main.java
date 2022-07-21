package Refactor_Aula1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        final String URL = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        JsonNode json = pegarJsonDaUrl(URL);
        mostrarFilmes(json);
    }

    private static JsonNode pegarJsonDaUrl(String URL) throws IOException, InterruptedException {

        // Criar um objeto do tipo HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Criar um objeto do tipo HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL)).GET().build();

        // Criar um objeto do tipo HttpResponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Parsear o JSON retornado pelo servidor
        return new JsonParser().parse(response.body());
    }

    private static void mostrarFilmes(JsonNode json) {

        // Percorrer o JSON e exibir os filmes

        json.get("items").forEach(filme -> {
            int imDbRating = (int) Math.floor(filme.get("imDbRating").asDouble());

            System.out.println( "-".repeat(60) );
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
            System.out.println( ("⭐".repeat(imDbRating)) );
            System.out.println( );
        });
    }
}
