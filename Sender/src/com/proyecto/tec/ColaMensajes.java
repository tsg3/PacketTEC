package com.proyecto.tec;

import java.util.ArrayList;

public class ColaMensajes {
	
	private static ColaMensajes colaMensajes = new ColaMensajes(); 
	public ArrayList<String> todos = new ArrayList<>();
	private ArrayList<String> cola = new ArrayList<>();
	private int size = 0;
	
	private ColaMensajes() {}
	
	public static ColaMensajes getInstance() {
		return colaMensajes;
	}
	
	public void add(String nuevo) {
		this.cola.add(nuevo);
		this.todos.add(nuevo);
		this.size +=1;
	}
	public ArrayList<String> get() {
		ArrayList<String> msj = new ArrayList<String>();
		if (size == 0) {
			msj.add("{\"idReceptor\": \"0\",\"idEmisor\": \"0\",\"mensaje\": \"No hay mensajes nuevos\"}");
			return msj;
		}
		msj.add(cola.get(0));
		cola.remove(0);
		size = size-1;
		return msj;
	}
}
