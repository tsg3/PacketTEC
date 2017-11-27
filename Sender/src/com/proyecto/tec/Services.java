package com.proyecto.tec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/")
public class Services {
	
	ColaMensajes cola= ColaMensajes.getInstance();
	
	//direccion http://localhost:8080/Sender/api/service
	@POST//comando html
	@Path("/service")
	@Consumes(MediaType.APPLICATION_JSON)// contenido que recibe
	@Produces(MediaType.APPLICATION_JSON)
	public String respuestaRest(InputStream llegada) throws IOException, ClassNotFoundException, JSONException {
		StringBuilder mensajeFinal = new StringBuilder();
		try {
			BufferedReader entrada =  new BufferedReader(new InputStreamReader(llegada));
			String line;
			while ((line = entrada.readLine()) != null) {
				mensajeFinal.append(line);
			}
		}catch (Exception e) {
			System.out.println("Error al decodificar mensaje");
		}
		JSONObject jsonObject = new JSONObject(mensajeFinal.toString());
		cola.add(jsonObject.toString());
		return (String) jsonObject.get("mensaje");
	}
	
	//direccion http://localhost:8080/Sender/api/mensajesActual
	@GET
	@Path("/mensajesActual")
	@Produces(MediaType.TEXT_PLAIN)
	public Response mensajesActuales(InputStream inputStream) throws IOException {
		String respuesta = cola.get().toString();
		return Response.status(200).entity(respuesta).build();
	}
	
	//direccion http://localhost:8080/Sender/api/mensajes
	@GET
	@Path("/mensajes")
	@Produces(MediaType.TEXT_PLAIN)
	public Response mensajesTotales(InputStream llegada) {
		String respuesta = cola.todos.toString();
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
}
