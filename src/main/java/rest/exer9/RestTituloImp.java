package rest.exer9;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/titulos/")
public class RestTituloImp implements ServicoTitulo {
	
	private static final List<Titulo> banco = new ArrayList<Titulo>();
	static {
		banco.add(new Titulo("Sacado 1", 1000));
		banco.add(new Titulo("Sacado 2", 2000));
	}

	@Path("/gravar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void gravar(Titulo titulo) throws NegocioException {
		titulo.validar();
		banco.add(titulo);
	}

	@Path("/deletar")
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Override
	public void deletar(@QueryParam("sacado") String sacado) throws NegocioException {
		if(sacado == null) {
			throw new NegocioException("Sacado é obrigatório na deleção.");
		}
		Titulo deletar = null;
		for (Titulo t : banco) {
			if(t.getSacado().equals(sacado)) {
				deletar = t;
				break;
			}
		}
		if(deletar == null) {
			throw new NegocioException("Sacado inexistente.");
		}
		banco.remove(deletar);
	}

	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Titulo> lista() throws NegocioException {
		return new ArrayList<>(banco);
	}

}
