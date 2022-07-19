package rest.exer16;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class GzipServidor implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) 
			throws IOException, WebApplicationException {
		System.out.println("Executou o interceptador GzipServidor...");
		GZIPOutputStream os = new GZIPOutputStream(context.getOutputStream());
		context.setOutputStream(os);
		context.proceed();		
	}
}
