package rest.exer7;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Cliente {

	public static void viaXML() {
		Pessoa joao = new Pessoa("João", 55, new BigDecimal(9999.99));
		Client cliente = ClientBuilder.newClient();
		WebTarget web = cliente.target("http://localhost:8080/telefonia/xml");
		Response resposta = web.request().post(Entity.xml(joao));
		if(resposta.getStatus() == 204) {
			System.out.println("Objeto pessoa enviado com sucesso via xml.");
		}else {
			System.out.println("Erro na resposta: "+resposta.toString());
		}
		resposta.close();
		resposta.close();
	}
	
	public static void viaJSON() {
		Pessoa joao = new Pessoa("João", 55, new BigDecimal(9999.99));
		Client cliente = ClientBuilder.newClient();
		WebTarget web = cliente.target("http://localhost:8080/telefonia/xml");
		Response resposta = web.request().post(Entity.json(joao));
		if(resposta.getStatus() == 204) {
			System.out.println("Objeto pessoa enviado com sucesso via json.");
		}else {
			System.out.println("Erro na resposta: "+resposta.toString());
		}
		resposta.close();
		resposta.close();
	}
	
	public static void main(String[] args) {
		viaXML();
		viaJSON();
	}
}
