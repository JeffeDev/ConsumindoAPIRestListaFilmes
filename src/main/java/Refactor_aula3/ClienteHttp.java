package Refactor_aula3;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp implements Serializable{
	private static final long serialVersionUID = 1L;

	public String buscaDados(String url) {
		HttpResponse<String> response;
		try {
			URI endereco = URI.create(url);
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
			response = client.send(request, BodyHandlers.ofString());
			
			return (response.body());
			
		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException(ex);
		}
		
	}

}
