package com.proyecto.tec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class ObtenerTodosMSJ {

	public static ArrayList<String> get(){
		ArrayList<String> salida = new ArrayList<>(); 
		String entrada = GetAll();
		entrada = entrada.toString().replace("[","").replace("]","");
		ArrayList<String> lista = new ArrayList<>(Arrays.asList(entrada.split(",")));
		String aux = "";
		for (int i = 0;i < lista.size();i++){
			try {
				aux = lista.get(i) + "," + lista.get(i + 1) + "," + lista.get(i + 2);
			}catch (Exception e){break;}	        
			i += 2;
			salida.add(aux);
		}
		return salida; 
	}
	public static String GetAll(){
		String resultado ="";
		try {
			URL url = new URL("http://localhost:8080/Sender/api/mensajes");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "media/text");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			resultado = convertInputStreamToString(connection.getInputStream());
			System.out.println("\nEl servicio /service funciona");
			in.close();
		} catch (Exception e) {
			System.out.println("\nEl servicio /service no responde");
			System.out.println(e);
		}

		return resultado;
	}
	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while((line = bufferedReader.readLine()) != null)
			result += line;
		inputStream.close();
		return result;

	}
}