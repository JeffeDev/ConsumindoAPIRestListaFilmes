package br.com.buscafilmes.util;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser implements Serializable{
	private static final long serialVersionUID = 1L;
	
    public JsonNode parse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(json);
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao parsear o JSON");
        }

        return null;
    }
}
