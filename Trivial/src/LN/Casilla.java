package LN;

public class Casilla {
	private int posicion_x;
	private int posicion_y;
	private String categoria;
	private boolean quesito;
	
	public Casilla(int posicion_x, int posicion_y, String categoria, boolean quesito){
		this.posicion_x = posicion_x;
		this.posicion_y = posicion_y;
		this.categoria = categoria;
		this.quesito = quesito;
	}

	public int getPosicion_x() {
		return posicion_x;
	}

	public void setPosicion_x(int posicion_x) {
		this.posicion_x = posicion_x;
	}

	public int getPosicion_y() {
		return posicion_y;
	}

	public void setPosicion_y(int posicion_y) {
		this.posicion_y = posicion_y;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isQuesito() {
		return quesito;
	}

	public void setQuesito(boolean quesito) {
		this.quesito = quesito;
	}
	

}
