package br.com.buscafilmes.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import br.com.buscafilmes.beans.FilmesBean;
import br.com.buscafilmes.beans.PreparaLista;

public class JsonParserJsonGoogle {

	public List<Map<String, String>> parse(String json) {
		
		Gson gson = new Gson();
		
        PreparaLista listOfFilmes = gson.fromJson(json, PreparaLista.class);
        List<Map<String, String>> dados = new ArrayList<Map<String, String>>();

        for (FilmesBean item : listOfFilmes.items) {

            Map<String, String> atributosItem = new HashMap<String, String>();
            atributosItem.put("id", item.getId());
            atributosItem.put("rank", item.getRank());
            atributosItem.put("title", item.getTitle());
            atributosItem.put("fullTitle", item.getFullTitle());
            atributosItem.put("year", item.getYear());
            atributosItem.put("image", item.getImage());
            atributosItem.put("imDbRating", item.getImDbRating());
            atributosItem.put("crew", item.getCrew());
            atributosItem.put("imDbRatingCount", item.getImDbRatingCount());

            dados.add(atributosItem);
        }

        return dados;
	}
}
