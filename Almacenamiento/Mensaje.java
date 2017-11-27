package tec;

import org.json.JSONObject;

public class Mensaje {

	private Mensaje next;
	private String text;
	private String emisor;

	public Mensaje getNext() {
		return next;
	}
	public void setNext(Mensaje next) {
		this.next = next;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
}
