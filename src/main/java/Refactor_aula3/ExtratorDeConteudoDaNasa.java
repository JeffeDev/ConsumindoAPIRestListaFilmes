package Refactor_aula3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.buscafilmes.util.JsonParserManual;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudos{

	public List<Conteudo> extraiConteudo(String json){
        var parser = new JsonParserManual();
        
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();
        
        for (Map<String, String> atributos : listaDeAtributos) {
        	String titulo = atributos.get("title");
        	String urlImagem = atributos.get("hdurl");
        	
        	var conteudo = new Conteudo(titulo, urlImagem, 10);
        	conteudos.add(conteudo);
		}
        
        return conteudos;
	
	}
	
}
