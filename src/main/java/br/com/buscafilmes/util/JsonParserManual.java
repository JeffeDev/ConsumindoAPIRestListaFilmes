package br.com.buscafilmes.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParserManual implements Serializable{
	private static final long serialVersionUID = 1L;

	private static final Pattern REGEX_ITEMS = Pattern.compile("\\[(.+)\\]");
	private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"?(.*?)\"?,");

	public List<Map<String, String>> parse(String json) {
		Matcher matcher = REGEX_ITEMS.matcher(json);
		if (!matcher.find()) {

			throw new IllegalArgumentException("Não encontrou items.");
		}

		String[] items = matcher.group(1).split("\\},\\{");

		List<Map<String, String>> dados = new ArrayList<Map<String, String>>();

		for (String item : items) {

			Map<String, String> atributosItem = new HashMap<String, String>();

			Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
			while (matcherAtributosJson.find()) {
				String atributo = matcherAtributosJson.group(1);
				String valor = matcherAtributosJson.group(2);
				
				atributosItem.put(atributo, valor);
			}

			dados.add(atributosItem);
		}

		return dados;
	}

}
