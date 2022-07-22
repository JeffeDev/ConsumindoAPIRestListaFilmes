package br.com.buscafilmes.util;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class GerarFigurinha implements Serializable{
	private static final long serialVersionUID = 1L;

	public void criar(BufferedImage imagemOriginal, String urlImagem) throws Exception {
		// leitura da imagem

		InputStream inputStreamJeffe = new FileInputStream(new File("imagemSemFundo/jeffersonimagem-removebg-preview.png"));
		BufferedImage imagemJeffe = ImageIO.read(inputStreamJeffe);
		
		imagemOriginal = resizeImage(imagemOriginal, 750, 1200);
		
		// nova imagem em memoria com transparencia e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;

		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copiar imagem original para nova imagem memória.
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		// Configurar a fonte
		Font fonte = new Font(Font.MONOSPACED, Font.BOLD, 120);
		graphics.setFont(fonte);
		
		// escrever uma frase na imagem
		
		graphics.drawImage(imagemJeffe, 0, altura-300, null);
		

		graphics.setFont(fonte);
		//graphics.drawString(stars, 10, novaAltura - 150);	
		
		// salvar imagem arquivo
		ImageIO.write(novaImagem, "png", new File("saida/" + toNomeFigurinha(urlImagem) + ".png"));
	}

    BufferedImage resizeImage(BufferedImage imagemOriginal, int larguraD, int alturaD) throws IOException{
        Image posImagem = imagemOriginal.getScaledInstance(larguraD, alturaD, Image.SCALE_SMOOTH);
        BufferedImage resultado = new BufferedImage(larguraD, alturaD, BufferedImage.TYPE_INT_RGB);
        resultado.getGraphics().drawImage(posImagem, 0, 0, null);
        return resultado;
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
