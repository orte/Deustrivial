package LN;

public class Jugador {
	
	private int id;
	private String nombre_usuario;
	
	public Jugador (int id, String nombre_usuario){
		this.id = id;
		this.nombre_usuario = nombre_usuario;
	}

	public Jugador(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String toString(){
		return nombre_usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (nombre_usuario == null) {
			if (other.nombre_usuario != null)
				return false;
		} else if (!nombre_usuario.equals(other.nombre_usuario))
			return false;
		return true;
}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombre_usuario == null) ? 0 : nombre_usuario.hashCode());
		return result;
	}
}
