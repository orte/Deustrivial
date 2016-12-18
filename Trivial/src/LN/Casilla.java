package LN;


public class Casilla {
	private int posicion_x;
	private int posicion_y;
	private String categoria;
	private boolean quesito;
	private String icono;
	
	public Casilla(int posicion_x, int posicion_y, String categoria, boolean quesito){
		this.posicion_x = posicion_x;
		this.posicion_y = posicion_y;
		this.categoria = categoria;
		this.quesito = quesito;
		ponerIcono();
	}

	public void ponerIcono(){
		switch (getCategoria()){
		case "Geografía": setIcono("casilla_geografia"); break;
		case "Historia": setIcono("casilla_historia"); break;
		case "Ocio": setIcono("casilla_ocio"); break;
		case "Deportes": setIcono("casilla_deportes"); break;
		}
		
	}
	public void ponerIconoFichas(int jugador){
		String subs = getIcono().substring(4, getIcono().length()-4);
		if(jugador == 0){
			setIcono(subs+"_ficha1");
		} else if(jugador == 1){
			setIcono(subs+"_ficha2");
		} else if(jugador ==2){
			setIcono(subs+"_ficha12");
		}
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

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		String ruta = "img/"+icono+".jpg";
		this.icono = ruta;
	}
	

}
