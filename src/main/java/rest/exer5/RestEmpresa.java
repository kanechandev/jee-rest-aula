package rest.exer5;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/funcionario/")
public class RestEmpresa {
	
	private Funcionario criar() {
		Funcionario contato = new Funcionario();
		contato.setNome("João");
		contato.setCpf(45127565412L);
		contato.setSalario(new BigDecimal("6999.99"));
		return contato;
	}

	@Path("/xml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Funcionario servicoXml() {
		System.out.println("Criado um objeto Java TO XML.");
		Funcionario contato = criar();
		return contato;
	}
	
	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Funcionario servicoJson() {
		System.out.println("Criado um objeto Java TO JSON");
		Funcionario contato = criar();
		return contato;
	}
}
