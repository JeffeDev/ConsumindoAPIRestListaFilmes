package br.com.buscafilmes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.buscafilmes.util.JsonParserManual;
import br.com.buscafilmes.util.gerarFigurinha;

public class BuscafilmesAPIRest {
	public static void main(String[] args) throws IOException, InterruptedException {
		final String urlTeste ="https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
		final String urlCurso = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
        final String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
        
		gerarFigurinha gerarFigurinha = new gerarFigurinha();
		
		// Fazer uma conexão HTTP e buscar os top 250 filmes
        URI endereco = URI.create(urlCurso);
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
        	
        	Integer classificacao;
        	String stars = ""; 
        	
        	String urlImagem = filme.get("image");
        	if (urlImagem == null) {
        		urlImagem = filme.get("hdurl");
        	}
        	
            try {
            	classificacao = Integer.parseInt(filme.get("rank"));
			} catch (Exception e) {
				classificacao = 0;
			}  
            
            for(int i = 0; i < classificacao; i++) {
                stars = stars + "\u2B50";
            }
            
            System.out.println("Título: "+ filme.get("title"));
            System.out.println("Imagem: "+ urlImagem);
            System.out.println("Classificação: "+ classificacao);
            System.out.println("Data: "+ filme.get("date"));
    		
            try {
    			gerarFigurinha.criar(urlImagem, classificacao, stars);
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, "Erro imagem: " + e.getMessage());
    		}
            
            System.out.println(stars);
            System.out.println();	
        }
	}
}

