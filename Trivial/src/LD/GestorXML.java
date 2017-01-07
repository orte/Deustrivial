package LD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import LN.Partida;



public class GestorXML 
{
	public void nuevaPartida(Partida nueva) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( "data/partidas.xml" ); // Nombre de nuestro archivo
		Document document = (Document) builder.build(xmlFile);
		Element partidas = new Element("Partidas");
		partidas = document.getRootElement();
		
		Element nuevaP = new Element("partida");
		nuevaP.setAttribute(new Attribute("fecha", nueva.getFecha_inic()));
		nuevaP.addContent(new Element("id_jug1").setText(Integer.toString(nueva.getId_j1())));
		nuevaP.addContent(new Element("id_jug2").setText(Integer.toString(nueva.getId_j2())));
		nuevaP.addContent(new Element("posx_jug1").setText(Integer.toString(nueva.getPosx_jug1())));
		nuevaP.addContent(new Element("posy_jug1").setText(Integer.toString(nueva.getPosy_jug1())));
		nuevaP.addContent(new Element("posx_jug2").setText(Integer.toString(nueva.getPosx_jug2())));
		nuevaP.addContent(new Element("posy_jug2").setText(Integer.toString(nueva.getPosy_jug2())));
		nuevaP.addContent(new Element("puntJug1").setText(Integer.toString(nueva.getPuntJug1())));
		nuevaP.addContent(new Element("puntJug2").setText(Integer.toString(nueva.getPuntJug2())));
		nuevaP.addContent(new Element("dado").setText(Integer.toString(nueva.getDado())));
		int turno;
		if(nueva.getTurno()){
			turno = 1;
		} else{
			turno = 2;
		}
		nuevaP.addContent(new Element("turno").setText(Integer.toString(turno)));;
		partidas.addContent(nuevaP);
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(document, new FileWriter("data/partidas.xml"));
	}
	public void guardarPartida(String fecha, String id_jug1, String id_jug2, String posx_jug1, String posy_jug1, String posx_jug2, String posy_jug2, String puntJug1, String puntJug2, String dado, String turno) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( "data/partidas.xml" ); // Nombre de nuestro archivo
		Document document = (Document) builder.build(xmlFile);
		XMLOutputter xmlOut = new XMLOutputter();
		Element partidas = new Element("Partidas");
		partidas = document.getRootElement();
		List<Element> list = partidas.getChildren();
		for(int i = 0; i<list.size(); i++){
			Element aux = (Element) list.get(i);
			if(aux.getAttributeValue("fecha").equals(fecha)){
				aux.getChild("id_jug1").setText(id_jug1);
				aux.getChild("id_jug2").setText(id_jug2);
				aux.getChild("posx_jug1").setText(posx_jug1);
				aux.getChild("posy_jug1").setText(posy_jug1);
				aux.getChild("posx_jug2").setText(posx_jug2);
				aux.getChild("posy_jug2").setText(posy_jug2);
				aux.getChild("puntJug1").setText(puntJug1);
				aux.getChild("puntJug2").setText(puntJug2);
				aux.getChild("dado").setText(dado);
				aux.getChild("turno").setText(turno);
				xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(document, new FileWriter("data/partidas.xml"));
				
				
			}
		}
	}
	public void borrarPartida(String fecha) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( "data/partidas.xml" ); // Nombre de nuestro archivo
		Document document = (Document) builder.build(xmlFile);
		XMLOutputter xmlOut = new XMLOutputter();
		Element partidas = new Element("Partidas");
		partidas = document.getRootElement();
		List<Element> list = partidas.getChildren();
		for(int i = 0; i<list.size(); i++){
			Element aux = (Element) list.get(i);
			if(aux.getAttributeValue("fecha").equals(fecha)){
				aux.getParent().removeContent(aux);
				xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(document, new FileWriter("data/partidas.xml"));
			}
		}
	}
	public List<Element> listaPartidas() throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( "data/partidas.xml" ); // Nombre de nuestro archivo
		Document document = (Document) builder.build(xmlFile);
		Element partidas = new Element("Partidas");
		partidas = document.getRootElement();
		List<Element> list = partidas.getChildren();
		return list;
	}
}
