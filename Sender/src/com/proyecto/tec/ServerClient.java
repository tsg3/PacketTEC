package com.proyecto.tec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class ServerClient {
	public static void main(String[] args){
		try {
			String txt = "{idReceptor:\"12345\",idEmisor:\"67890\",mensaje:\"textoMensaje\"}";
			JSONObject jsonObject = new JSONObject(txt);
		try {
			for(int i = 0; i<2;i++) {
			URL url = new URL("http://localhost:8080/Sender/api/service");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter salida = new OutputStreamWriter(connection.getOutputStream());
			salida.write(jsonObject.toString());
			salida.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (in.readLine() != null) {
			}
			System.out.println("\nEl servicio /service funciona");
			in.close();
			}
		} catch (Exception e) {
			System.out.println("\nEl servicio /service no responde");
			System.out.println(e);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String Get(){
		String resultado ="";
		try {
			URL url = new URL("http://localhost:8080/Sender/api/mensajesActual");
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