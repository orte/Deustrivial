package ln;

public class Pregunta {
	private String categoria;
	private String pregunta;
	private String [] respuestas;
	private int correcta;
	
	public Pregunta(String categoria, String pregunta, String[] respuestas, int correcta){
		this.categoria = categoria;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
		
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

	public String[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}
	
	

}
