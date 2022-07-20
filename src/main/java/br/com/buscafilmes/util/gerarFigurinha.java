package br.com.buscafilmes.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class gerarFigurinha {

	public void cria(String urlImagem, Integer classificacao) throws Exception {
		// leitura da imagem

		// InputStream inputStream = new FileInputStream(new
		// File("entrada/entrada.jpg"));
		InputStream inputStream = new URL(urlImagem).openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		// nova imagem em memoria com transparencia e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;

		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copiar imagem original para nova imagem memória.
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		// Configurar a fonte
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setFont(fonte);

		// escrever uma frase na imagem
		if (classificacao >= 9) {
			graphics.setColor(Color.YELLOW);
			graphics.drawString("TOPZERA", 0, novaAltura - 100);
		}else if (classificacao >=7 && classificacao <= 9) {
			graphics.setColor(Color.GREEN);
			graphics.drawString("LEGAL", 0, novaAltura - 100);
		}else if (classificacao >=4 && classificacao <= 6) {
			graphics.setColor(Color.CYAN);
			graphics.drawString("TEM MELHOR", 0, novaAltura - 100);
		}else if (classificacao >=3 ) {
			graphics.setColor(Color.RED);
			graphics.drawString("RUIM!!", 0, novaAltura - 100);
		}

		// salvar imagem arquivo
		ImageIO.write(novaImagem, "png", new File("saida/" + toNomeFigurinha(urlImagem) + ".png"));
	}

	public static String toNomeFigurinha(String urlImagem) {
		int length = urlImagem.length();
		int inicio = 0;

		int i = length - 1;
		while (i > 0) {

			if (urlImagem.substring(i, i + 1).equals("/")) {
				inicio = i + 1;
				i = 0;
			} else {
				i--;
			}
		}

		System.out.println("Nome da Imagem gerada: " + urlImagem.substring(inicio, urlImagem.length() - 4) + ".png");

		return urlImagem.substring(inicio, urlImagem.length() - 4);

	}

}
