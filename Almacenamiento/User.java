package tec;

import org.json.JSONObject;

public class User {
	
	private User next;
	private String name;

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
	
	//-----------------------------------------------------------
	
	public Mensaje front;

	public User (){
		front=null;
	}

	public void push (String text, String emisor) {
		Mensaje mensaje = new Mensaje();
		mensaje.setText(text);
		mensaje.setEmisor(emisor);
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
			String texto = front.getEmisor() + ": " + front.getText();
			front = front.getNext();
			return texto;
		}
		else{
			return null;
		}
	}

}
