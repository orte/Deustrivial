
package LN;

import java.util.ArrayList;

public class Pregunta {
	private int id_pregunta;
	private String categoria;
	private String pregunta;
	private ArrayList<String> respuestas;
	private int correcta; //Índice de la respuesta correcta en el array de respuestas
	
	public Pregunta(String categoria, String pregunta, ArrayList<String>respuestas, int correcta){
		
		this.categoria = categoria;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
		
	}
	
	public boolean esCorrecto(int respuesta){
		if(respuesta == correcta){
			return true;
		} else {
			return false;
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}

	public int getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	
	

}
