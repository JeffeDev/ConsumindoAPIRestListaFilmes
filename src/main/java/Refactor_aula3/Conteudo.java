package Refactor_aula3;

import java.io.Serializable;
import java.util.Objects;

public class Conteudo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String titulo;
	private final String urlImagem;
	private final Integer imDbRating;
	
	public Conteudo(String titulo, String urlImagem, Integer imDbRating) {
		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.imDbRating = imDbRating;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public Integer getImDbRating() {
		return imDbRating;
	}
	
	
}
