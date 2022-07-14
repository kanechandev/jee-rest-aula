package rest.exer3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cadastro/{username:[a-zA-z]*}")
public class RestCadastro {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String processarCadastro(@PathParam("username") String nome) {
		System.out.println("Processando cadastro de = "+nome);
		return "Cadastro realizado com sucesso : "+nome;
	}
}
