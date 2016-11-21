package LN;

public class Jugador {
	
	private int id;
	private String nombre_usuario;
	private Estadisticas estadisticas;
	
	public Jugador (int id, String nombre_usuario)
	{
		this.id = id;
		this.nombre_usuario = nombre_usuario;
		estadisticas = new Estadisticas(id);
	}

	
	public void EvaluarRespuesta(String respuesta_dada, String respuesta_correcta)
	{
		
		if (respuesta_dada.equals(respuesta_correcta))
		{
			
		}
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

	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(Estadisticas estadisticas) {
		this.estadisticas = estadisticas;
	}
	

}
