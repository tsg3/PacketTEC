package com.proyecto.tec;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class User {
	
	private User next;
	private String name;
	public Mensaje front;

	public User getNext() {
		return next;
	}
	public void setNext(User next) {
		this.next = next;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public User (){
		front=null;
	}

	public void push (JSONObject jsonObject) throws IOException, JSONException {
		Mensaje mensaje = new Mensaje(jsonObject);
		if (front == null)
			front = mensaje;
		else {
			Mensaje current = front;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(mensaje);
		}
	}

	public String pop() {
		if (front != null){
			String texto = front.getIdEmisor() + ": " + front.getSalida();
			front = front.getNext();
			return texto;
		}
		else{
			return null;
		}
	}

}