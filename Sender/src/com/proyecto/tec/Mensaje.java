package com.proyecto.tec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class Mensaje {
	
	private JSONObject llegada;
	private byte[] array;
	private Object salida;
	private String idEmisor;
	private String idReceptor;
	private Mensaje next;
	
	public Mensaje(JSONObject jo) throws IOException, JSONException {
		setLlegada(jo);
		setIdEmisor();
		setIdReceptor();
		setSalida();
	}
	
	/**
	 * @return the llegada
	 */
	public Object getLlegada() {
		return llegada;
	}
	/**
	 * @param llegada the llegada to set
	 */
	public void setLlegada(JSONObject llegada) {
		this.llegada = llegada;
	}
	/**
	 * @return the array
	 */
	public byte[] getArray() {
		return array;
	}
	/**
	 * @param array the array to set
	 * @throws IOException 
	 */
	public static byte[] setArray(Object in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(in);
	    os.flush();
	    os.close();
	    return out.toByteArray();
	}
	/**
	 * @return the salida
	 */
	public Object getSalida() {
		return salida;
	}
	/**
	 * @param salida the salida to set
	 */
	public static Object setSalidaByte(byte[] array) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(array);
		ObjectInputStream is = new ObjectInputStream(in);
		Object objeto = is.readObject();
		is.close();
	    return objeto;
	}
	/**
	 * @return the idEmisor
	 */
	public String getIdEmisor() {
		return idEmisor;
	}
	/**
	 * @param idEmisor the idEmisor to set
	 * @throws JSONException 
	 */
	public void setIdEmisor() throws JSONException {
		this.idEmisor = (String) llegada.get("idEmisor");
	}
	/**
	 * @return the idReceptor
	 */
	public String getIdReceptor() {
		return idReceptor;
	}
	/**
	 * @param idReceptor the idReceptor to set
	 * @throws JSONException 
	 */
	public void setIdReceptor() throws JSONException {
		this.idReceptor = (String) llegada.get("idReceptor");
	}
	public void setSalida() throws JSONException {
		this.salida = llegada.get("mensaje");
	}
	/**
	 * @return the next
	 */
	public Mensaje getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Mensaje next) {
		this.next = next;
	}
}
