package LN;
 /**
  * 
  * @author Josune
  * Clase que crea partidas asociando a dos jugadores. En consecuencia crea tambien las fichas de jugador de 
  * forma simultanea
  *
  */
public class GestorPartidas 
{
	String ID_J1;
	String ID_J2;
	

	public GestorPartidas()
	{
		super();
	}
	
	public void CrearPartida(int id1, int id2)
	{	
		Partida nueva_P = new Partida(id1,id2);
		FichaDePartida F1 = new FichaDePartida(id1);
		FichaDePartida F2 = new FichaDePartida(id2);
		
		
		
		
		
	}
	
	
	
}
