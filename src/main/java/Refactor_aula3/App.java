package Refactor_aula3;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import br.com.buscafilmes.util.GerarFigurinha;

public class App {
	public static void main(String[] args) {
        ClienteHttp http = new ClienteHttp();

//      final String url = "https://api.nasa.gov/planetary/apod?api_key=DozONKx6WqzfbLmCqZNi577uqo5OBVVnuNgkpKtw&start_date=2022-07-01&end_date=2022-07-15";
//		ExtratorDeConteudos extrator = new ExtratorDeConteudoDaNasa();
		
		final String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
		ExtratorDeConteudos extrator = new ExtratorDeConteudoIMDB();

		List<Conteudo> conteudos = extrator.extraiConteudo(http.buscaDados(url));
		
        // Exibir e manipular os dados.
        for (int i = 0; i < conteudos.size(); i++) {
        	Conteudo conteudo = conteudos.get(i);
        	String urlImagem = conteudo.getUrlImagem();
        	
            System.out.println("Título: " + conteudo.getTitulo());
            System.out.println("Imagem: " + urlImagem);
            System.out.println("Rank  : " + conteudo.getImDbRating());
        	
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
    		
            System.out.println();	
        }
	}
}

