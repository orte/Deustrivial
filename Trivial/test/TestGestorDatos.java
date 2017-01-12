import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.GestorDatos;
import LN.Jugador;
import LN.Partida;
import LN.Pregunta;
import LN.Respuesta;
import main.DuplicadoException;

public class TestGestorDatos {

	int aux = 0;

	ArrayList<Jugador> jugadores;
	ArrayList<Pregunta> preguntas;
	ArrayList<Partida> partidas;
	ArrayList<Respuesta> respuestas;
	GestorDatos ges = new GestorDatos();

	@Before
	public void setUp() throws Exception {
		
		jugadores = new ArrayList<Jugador>();
		preguntas = new ArrayList<Pregunta>();
		partidas = new ArrayList<Partida>();
		respuestas = new ArrayList<Respuesta>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListaPreguntas() {
		preguntas = ges.listaPreguntas("Ocio");
		Pregunta objPregunta = ges.obtenerPregunta("Ocio");
		for(Pregunta x : preguntas){
			if(x.getId_pregunta() == objPregunta.getId_pregunta()){
				assertEquals(objPregunta.getId_pregunta(), x.getId_pregunta());
			}
		}
	}
	@Test
	public void testListaJugadoresNuevoJugador() throws DuplicadoException{
		jugadores = ges.listaJugadores();
		aux = jugadores.size();
		ges.nuevoJugador("asdfg");
		jugadores.clear();
		jugadores = ges.listaJugadores();
		assertEquals(aux + 1, jugadores.size());
		jugadores.clear();
	}
	@Test
	public void testnuevaPartidaListaPartidas(){
		partidas = ges.listaPartidas();
		aux = partidas.size();
		jugadores = ges.listaJugadores();
		ges.nuevaPartida(jugadores.get(1), jugadores.get(4));
		partidas = ges.listaPartidas();
		assertEquals(aux +1 , partidas.size());
		ges.borrarPartida(new Partida(1,4));
		partidas = ges.listaPartidas();
		aux = partidas.size();
		assertEquals(aux, partidas.size());
	}
	

}
