package br.com.buscafilmes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class BuscafilmesAPIRest {
	public static void main(String[] args) throws IOException, InterruptedException {
		final String URLCurso = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
        final String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
        
		
		// Fazer uma conexão HTTP e buscar os top 250 filmes
        URI endereco = URI.create(URLCurso);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Imprimir o JSON recuperado.
        System.out.println(body);

        // Extrair só os dados que interessam (titulo, poster, classificação)
        JsonParserManual parser = new JsonParserManual();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));

        // Exibir e manipular os dados.
        
        for ( Map<String, String> filme: listaDeFilmes) {
        	 
            System.out.println("Título: "+ filme.get("title"));
            System.out.println("Poster: "+ filme.get("image"));
            System.out.println("Classificação: "+ filme.get("rank"));
            Integer classificacao;
            
            try {
            	classificacao = Integer.parseInt(filme.get("rank"));
			} catch (Exception e) {
				classificacao = 0;
			}          
            
            String stars = "";  
            Integer graficoEstrelinha = 100 - (classificacao * 100)/300;
            
            for(int i = 0; i < graficoEstrelinha; i++) {
                stars = stars + "\u2B50";
            }
            
            System.out.println(stars);
            System.out.println();	
        }
	}
}

