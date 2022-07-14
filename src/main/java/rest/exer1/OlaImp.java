package rest.exer1;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ola")
public class OlaImp implements Ola{
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String ola() {
		System.out.println("Executou o rest...");
		return new Date().toString();
	}
}
