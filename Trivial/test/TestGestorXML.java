import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.GestorXML;
import LN.Partida;

public class TestGestorXML {

	private GestorXML ges = new GestorXML();
	private Partida nuevaP;
	List<Element> listaPartidas;
	String fecha;
	String id_jug1;
	String id_jug2;
	String posx_jug1;
	String posy_jug1;
	String posx_jug2;
	String posy_jug2;
	String puntJug1;
	String puntJug2;
	String dado;
	String turno;
	@Before
	public void setUp() throws Exception {	
		nuevaP = new Partida();	
		nuevaP.setId_j1(1);
		nuevaP.setId_j2(2);
		nuevaP.setPosx_jug1(0);
		nuevaP.setPosy_jug1(0);
		nuevaP.setPosx_jug2(0);
		nuevaP.setPosy_jug2(0);
		nuevaP.setPuntJug1(0);
		nuevaP.setPuntJug2(0);
		nuevaP.setDado(4);
		nuevaP.setTurno(true);
		
		fecha = "2018-21-03-11-21-23";
		id_jug1 = "3";
		id_jug2 = "4";
		posx_jug1 = "4";
		posx_jug2 = "4";
		posy_jug1 = "4";
		posy_jug2 = "4";
		puntJug1 = "3";
		puntJug2 = "4";
		dado = "5";
		turno = "true";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNuevaPartidaListaPartidas() throws JDOMException, IOException {
		ges.nuevaPartida(nuevaP);
		ges.guardarPartida(fecha, id_jug1, id_jug2, posx_jug1, posx_jug2, posy_jug1, posy_jug2, puntJug1, puntJug2, dado, turno);
		listaPartidas = ges.listaPartidas();
		
		for(Element x : listaPartidas){
			if(x.getAttributeValue("fecha").equals(nuevaP.getFecha_inic())){
				assertEquals(x.getAttributeValue("fecha"),nuevaP.getFecha_inic());
			}

			if(x.getAttributeValue("fecha").equals(fecha)){
				assertEquals(x.getAttributeValue("fecha"),fecha);
			}
		}
	}
	@Test
	public void testBorrarPartida() throws JDOMException, IOException{
		ges.borrarPartida(fecha);
		for(Element x : listaPartidas){
			assertEquals(x.getAttributeValue("fecha"), fecha);
			fail("Error - no debería de existir partida con fecha" + fecha);
		}
	}

}
