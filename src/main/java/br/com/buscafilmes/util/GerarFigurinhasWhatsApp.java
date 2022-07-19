package br.com.buscafilmes.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GerarFigurinhasWhatsApp {

	public void cria() throws Exception {
		// leitura da imagem
		BufferedImage imagemOriginal = ImageIO.read(new File("imagensfilmes/MostPopularTVs_1.jpg"));

		// nova imagem em memoria com transparencia e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		
		BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);
		
		// copiar imagem original para nova imagem memória.
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// escrever uma frase na imagem
		ImageIO.write(novaImagem, "png", new File("saidafigurinha/figurinha.png"));
		
		// salvar imagem arquivo
	}
	
}
