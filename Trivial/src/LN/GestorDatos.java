package LN;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import LD.Datos;
import LD.GestorXML;
import main.ComparatorAciertos;
import main.ComparatorVictorias;
import main.DuplicadoException;

public class GestorDatos {
	private Datos datos = new Datos();
	private GestorXML xml = new GestorXML();
	
	public ArrayList<Pregunta> listaPreguntas(String categoria){
		
		ResultSet rs = datos.obtenerDatos("SELECT * FROM preguntas WHERE categoria = \""+categoria+"\"");
		int id_pregunta = 0;
		String pregunta = null;
		ArrayList <String> respuestas;
		int correcta = -1;
		
		ArrayList<Pregunta> resultado = new ArrayList<Pregunta>();
		Pregunta aux;
		try {
			while(rs.next()){
				respuestas = new ArrayList<String>();
				id_pregunta = rs.getInt("id_pregunta");
				for(int i = 0; i<4; i++){
					String res = rs.getString("respuesta"+(i+1));
					respuestas.add(res);
				}
				pregunta = rs.getString("pregunta");
				correcta = rs.getInt("correcta");
				aux = new Pregunta(categoria, pregunta, respuestas, correcta);
				aux.setId_pregunta(id_pregunta);
				resultado.add(aux);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return resultado;
	}
	public ArrayList<Jugador> listaJugadores(){
		ResultSet rs = datos.obtenerDatos("SELECT * FROM jugadores");
		String nombre = " ";
		ArrayList<Jugador> datos_J_aux = new ArrayList<Jugador>();
		int id_int;
		Jugador j1;
		try {
				while(rs.next())
				{
					j1 = new Jugador();
					id_int = rs.getInt(1);
					j1.setId(id_int);
					nombre = rs.getString(2);
					j1.setNombre_usuario(nombre);
					datos_J_aux.add(j1);
				}
		}
		catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datos_J_aux;
	}
	public void nuevoJugador(String nombre) throws DuplicadoException{
		ArrayList<Jugador> lista = listaJugadores();
		HashSet<Jugador> set = new HashSet<Jugador>();
		set.addAll(lista);
		int ultimo_id = lista.get(lista.size()-1).getId();
		Jugador nuevo = new Jugador((ultimo_id+1), nombre);
		if(set.add(nuevo)==false){
			DuplicadoException e = new DuplicadoException();
			throw e;
		} else{
			datos.guardarDatos("INSERT INTO jugadores (id_jugador, nombre) VALUES ("+nuevo.getId()+", '"+nuevo.getNombre_usuario()+"')");
			Estadisticas stats = new Estadisticas(nuevo.getId(), 0, 0, 0, 0);
			datos.guardarDatos("INSERT INTO estadisticas (id_jugador) VALUES ("+stats.getId_jugador()+")");
		}
	}
	public Partida nuevaPartida(Jugador jug1, Jugador jug2){
		ArrayList<Jugador> jugadores = listaJugadores();
		Jugador jugAux = null;
		for(Jugador aux:jugadores){
			if(jug1.equals(aux)){
				jugAux = aux;
			}
		}
		int id1 = jugAux.getId();
		for(Jugador aux:jugadores){
			if(jug2.equals(aux)){
				jugAux = aux;
			}
		}
		int id2 = jugAux.getId();
		Partida nueva = new Partida(id1, id2);
		try {
			xml.nuevaPartida(nueva);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nueva;
	}
	public void guardarPartida(Partida partida){
		String fecha = partida.getFecha_inic();
		String id_jug1 = Integer.toString(partida.getId_j1());
		String id_jug2 = Integer.toString(partida.getId_j2());
		String posx_jug1 = Integer.toString(partida.getPosx_jug1());
		String posy_jug1 = Integer.toString(partida.getPosy_jug1());
		String posx_jug2 = Integer.toString(partida.getPosx_jug2());
		String posy_jug2 = Integer.toString(partida.getPosy_jug2());
		String puntJug1 = Integer.toString(partida.getPuntJug1());
		String puntJug2 = Integer.toString(partida.getPuntJug2());
		String dado = Integer.toString(partida.getDado());
		String turno = "";
		if(partida.isTurno()){
			turno = "1";
		} else{
			turno = "2";
		}
		try {
			xml.guardarPartida(fecha, id_jug1, id_jug2, posx_jug1, posy_jug1, posx_jug2, posy_jug2, puntJug1, puntJug2, dado, turno);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Partida> listaPartidas(){
		List<Element> lista = null;
		try {
			lista = xml.listaPartidas();
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		for(int i = 0; i<lista.size(); i++){
			Element aux = lista.get(i);
			String fecha = aux.getAttributeValue("fecha");
			int id_jug1 = Integer.parseInt(aux.getChildText("id_jug1"));
			int id_jug2 = Integer.parseInt(aux.getChildText("id_jug2"));
			int posx_jug1 = Integer.parseInt(aux.getChildText("posx_jug1"));
			int posy_jug1 = Integer.parseInt(aux.getChildText("posy_jug1"));
			int posx_jug2 = Integer.parseInt(aux.getChildText("posx_jug2"));
			int posy_jug2 = Integer.parseInt(aux.getChildText("posy_jug2"));
			int puntJug1 = Integer.parseInt(aux.getChildText("puntJug1"));
			int puntJug2 = Integer.parseInt(aux.getChildText("puntJug2"));
			int dado = Integer.parseInt(aux.getChildText("dado"));
			int tur = Integer.parseInt(aux.getChildText("turno"));
			boolean turno;
			if(tur == 1){
				turno = true;
			} else{
				turno = false;
			}
			Partida cargada = new Partida(fecha, id_jug1, id_jug2, posx_jug1, posy_jug1, posx_jug2, posy_jug2, puntJug1, puntJug2, turno, dado);
			partidas.add(cargada);
			
		}
		return partidas;
	}
	public Jugador obtenerJugador(int id){
		ArrayList<Jugador> lista = listaJugadores();
		Jugador jug = null;
		for(Jugador aux:lista){
			if(aux.getId()==id){
				jug = aux;
			}
		}
		return jug;
	}
	public Pregunta obtenerPregunta(String categoria){
		Pregunta pregunta = null;
		ArrayList <Pregunta> lista = listaPreguntas(categoria);	
		int random = (int)(Math.random()*lista.size());
		pregunta = lista.get(random);
		return pregunta;
	}
	public void guardarRespuestas(ArrayList<Respuesta> respuestas){
		int id_jug;
		int id_pregunta;
		String fecha;
		int correcta;
		for(Respuesta aux:respuestas){
			id_jug = aux.getId_jugador();
			id_pregunta = aux.getId_pregunta();
			fecha = aux.getFecha();
			if(aux.isCorrecta()){
				correcta = 1;
			} else{
				correcta = 0;
			}
			String sentencia = "INSERT INTO respuestas (id_jugador, id_pregunta, fecha, correcta)"
					+ " VALUES ("+id_jug+", "+id_pregunta+", \""+fecha+"\", "+correcta+")";
			datos.guardarDatos(sentencia);
		}
	}
	public ArrayList<Respuesta> listaRespuestas(){
		ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
		ResultSet rs = datos.obtenerDatos("SELECT * FROM respuestas");
		int id_jug;
		int id_preg;
		String fecha;
		boolean correcta;
		try {
			while(rs.next()){
				id_jug = rs.getInt(1);
				id_preg = rs.getInt(2);
				fecha = rs.getString(3);
				int corr = rs.getInt(4);
				if(corr == 0){
					correcta = false;
				} else{
					correcta = true;
				}
				Respuesta res = new Respuesta(id_preg, id_jug, correcta);
				res.setFecha(fecha);
				respuestas.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuestas;
	}
	public void actualizarEstadisticas(int[] id_jugs){
		for (int i = 0; i<id_jugs.length; i++){
			ArrayList<Estadisticas> stats = listaStats();
			Estadisticas stat = null;
			for(Estadisticas aux:stats){
				if(id_jugs[i] == aux.getId_jugador()){
					stat = aux;
				}
			}
			ArrayList<Respuesta> respuestas = listaRespuestas();
			int totales = 0;
			int correctas = 0;
			for(Respuesta aux:respuestas){
				if(aux.getId_jugador() == stat.getId_jugador()){
					if(aux.isCorrecta()){
						totales++;
						correctas++;
					} else{
						totales++;
					}
				}
			}
			String sentencia = "UPDATE estadisticas SET preg_totales = "+totales+", preg_acertadas = "+correctas+""
					+ " WHERE id_jugador = "+stat.getId_jugador();
			datos.guardarDatos(sentencia);
		}
	}
	public void partidaTerminada(int id_jug, boolean ganador){
		ArrayList<Estadisticas> stats = listaStats();
		Estadisticas stat = null;
		for(Estadisticas aux:stats){
			if(id_jug == aux.getId_jugador()){
				stat = aux;
			}
		}
		if(ganador){
			stat.partidaGanada();
		} else{
			stat.partidaPerdida();
		}
		String sentencia = "UPDATE estadisticas SET part_totales = "+stat.getPartidas_jugadas()+", part_ganadas = "+stat.getPartidas_ganadas()+" "
				+ "WHERE id_jugador = "+id_jug;
		datos.guardarDatos(sentencia);
	}
	public ArrayList<Estadisticas> listaStats(){
		ArrayList<Estadisticas> lista = new ArrayList<Estadisticas>();
		ResultSet rs = datos.obtenerDatos("SELECT * FROM estadisticas");
		int id_jug;
		int preg_tot;
		int preg_acert;
		int part_tot;
		int part_ganadas;
		try {
			while(rs.next()){
				id_jug = rs.getInt(1);
				preg_tot = rs.getInt(2);
				preg_acert = rs.getInt(3);
				part_tot = rs.getInt(4);
				part_ganadas = rs.getInt(5);
				Estadisticas stats = new Estadisticas(id_jug, preg_tot, preg_acert, part_tot, part_ganadas);
				lista.add(stats);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public ArrayList<Estadisticas> ordenarPorVictorias(){
		ArrayList<Estadisticas> lista = listaStats();
		Collections.sort(lista, new ComparatorVictorias());
		return lista;
	}
	public ArrayList<Estadisticas> ordenarPorAciertos(){
		ArrayList<Estadisticas> lista = listaStats();
		Collections.sort(lista, new ComparatorAciertos());
		return lista;
	}
	public Map<Integer, Estadisticas> mapaVictorias(){
		Map<Integer, Estadisticas> map = new TreeMap<Integer, Estadisticas>();
		ArrayList<Estadisticas> lista = ordenarPorVictorias();
		for(int i = 0; i<lista.size(); i++){
			map.put(i, lista.get(i));
		}
		return map;
	}
	public Map<Integer, Estadisticas> mapaAciertos(){
		Map<Integer, Estadisticas> map = new TreeMap<Integer, Estadisticas>();
		ArrayList<Estadisticas> lista = ordenarPorAciertos();
		for(int i = 0; i<lista.size(); i++){
			map.put(i, lista.get(i));
		}
		return map;
	}
	public void borrarPartida(Partida partida){
		try {
			xml.borrarPartida(partida.getFecha_inic());
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
