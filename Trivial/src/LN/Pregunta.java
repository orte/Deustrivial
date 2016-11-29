package LN;

import java.util.ArrayList;

public class Pregunta {
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
	
	@Override
	public String toString() 
	{
		String p = this.getPregunta() + "de la categoria " + this.getCategoria() + " tiene las siguientes respuestas posibles :";
		String p3= " ";
		ArrayList<String> resp = new ArrayList<String>();
		resp=this.getRespuestas();
		
		for(String a : resp)
		{
		p3=p3+a+" ";	
		}
		int p_= this.getCorrecta(); 
		String p_2= " y la correcta es " + this.getCorrecta();
		 
		String pp= p+ p3+ p_+p_2;
		
		
		return pp;
		
	}

	public Pregunta ()
	{
		
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
	
	

}
