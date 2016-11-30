package LD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import LN.Pregunta;



public class GestorXML 
{

	public GestorXML()
	{
		super();
	}



	//Este método lo he cambiado para en vez de que devuelva una pregunta al azar de una categoría, devuelva la lista
	//entera de preguntas de una categoría. Como te he puesto en frm_Pantalla_Pregunta, lo estabas usando para
	//pasarle directamente las preguntas a las ventanas y creo que eso lo tiene que hacer la LN en vez de la LD, así
	//que este lo he cambiado para que devuelva la lista, así tiene una función más útil. También lo he adaptado
	//un poco para que meta en el array de respuestas las cuatro, en vez de tres, y Correcta sea el índice de
	//la respuesta que tenga el tipo=true dentro de ese array
	public ArrayList<Pregunta> listaPreguntas (String categoria) throws JDOMException, IOException
	{

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( "data/Preguntas.xml" ); // Nombre de nuestro archivo

		Document document = (Document) builder.build(xmlFile);
		// Se obtiene el elemento raiz
		Element rootNode = document.getRootElement();


		List<Element>lista_P = rootNode.getChildren("pregunta");
		ArrayList<Pregunta> Array_P= new ArrayList<Pregunta>();

		ArrayList<Pregunta> Array_P_aux= new ArrayList<Pregunta>();
		//Un array en el que meterlos ( preguntas de la partida)
		// Para todos los elementos guardados en <Preguntas> y que sean <pregunta>
		for(int i=0;i<=lista_P.size()-1;i++)
		{

			Element element = (Element) lista_P.get(i); 
			//Creamos un elemento que vaya recogiendo los elementos "pregunta"
			Pregunta pregunta = new Pregunta();			
			// Una instancia de la clase auxiliar para crear preguntad con los datos del elemento

			if(element.getChildText("C").equals(categoria))
			{

				pregunta.setPregunta(element.getChildText("P")); 
				System.out.println(element.getChildText("P"));



				List<Element> lista_R = element.getChildren("R");//Al haber 4 las recogemos en una lista
				ArrayList <String> resp_aux = new ArrayList <String> (); // Y sino al Array de incorrectas

				for(int j=0; j<lista_R.size();j++) //Hacemos un for para ir sacandolas

				{

					Element element_R = (Element) lista_R.get(j); 

					resp_aux.add(element_R.getText());
					pregunta.setRespuestas(resp_aux);
					if(element_R.getAttributeValue("tipo").equals("true")) //Si es T pasa al atributo int Correcta
					{
						pregunta.setCorrecta(j);
					}

				}

				pregunta.setCategoria(element.getChildText("C")); //Lo mismo que con el texto de la pregunta
				Array_P_aux.add(pregunta);
				Array_P=Array_P_aux;
			}


		}

		return Array_P;
		
	}

	public void escribirEnXMLJugadores(int ultimo_id, String nombre_J) throws JDOMException, IOException

	{

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( "data/Jugadores.xml" ); // Nombre de nuestro archivo
		Document document = (Document) builder.build(xmlFile);
		Element Jugadores = new Element("Jugadores");
		Jugadores = document.getRootElement();

		String nuevo_id=String.valueOf(ultimo_id+1);

		Element nuevo_J = new Element("jugador");
		nuevo_J.setAttribute(new Attribute("id_j",nuevo_id));
		nuevo_J.addContent(new Element ("Nombre").setText(nombre_J));

		Jugadores.addContent(nuevo_J);

		// new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();

		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(document, new FileWriter("data/Jugadores.xml"));

	}    


}
