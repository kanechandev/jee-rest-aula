package rest.exer9;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class Cliente {
	
	private static WebTarget criar() {
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://localhost:8080/titulos");
		return web;
	}
	
	private static void criar(Titulo titulo) {
		WebTarget web = criar().path("/gravar");
		Response resposta = web.request().post(Entity.json(titulo));
		System.out.println(resposta.getStatus()+" - "+resposta.readEntity(String.class));
		resposta.close();
	}
	
	private static void deletar(String sacado) {
		WebTarget web = criar().path("/deletar");
		Response resposta = web.queryParam("sacado", sacado).request().delete();
		System.out.println(resposta.getStatus()+" - "+resposta.readEntity(String.class));
		resposta.close();
	}
	
	private static void listar() {
		WebTarget web = criar().path("/listar");
		Response resposta = web.request().get();
		System.out.println(resposta.getStatus());
		List<Titulo> titulos = resposta.readEntity(new GenericType<List<Titulo>>() {});
		for (Titulo titulo : titulos) {
			System.out.println(titulo.getSacado()+" - "+titulo.getValor());
		}
		resposta.close();
	}

	public static void main(String[] args) {
		criar(new Titulo());
		criar(new Titulo("Joao", 150));
		criar(new Titulo("Jose", 375));
		criar(new Titulo("Amadeu", 423));
		listar();
		deletar("mister");
		deletar("Joao");
		listar();
	}

}
