package rest.exer15;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

public class FiltroNumero implements ClientResponseFilter{

	@Override
	public void filter(ClientRequestContext requestContext, 
			ClientResponseContext responseContext) throws IOException {
		System.out.println("Tamanho da resposta: "+responseContext.getLength());
	}

}
