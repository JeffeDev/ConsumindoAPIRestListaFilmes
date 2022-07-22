package Refactor_aula2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.buscafilmes.util.GerarFigurinha;
import br.com.buscafilmes.util.JsonParser;

public class Main2 {

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
    	System.out.println(json);
    	
        json.get("items").forEach(filme -> {
            int imDbRating = (int) Math.floor(filme.get("rank").asDouble());
            
            String urlImagem = filme.get("image").asText().toString();
            
            System.out.println( "-".repeat(60) );
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(imDbRating);
            System.out.println( ("⭐".repeat(imDbRating)) );
            System.out.println(urlImagem);
            
			try {
				GerarFigurinha gerarFigurinha = new GerarFigurinha();
				
				InputStream inputStream = new URL(urlImagem).openStream();
				BufferedImage imagemOriginal = ImageIO.read(inputStream);
				
				gerarFigurinha.criar(imagemOriginal, urlImagem );
				
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		        
        });
    }
}
