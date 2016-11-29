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
	
	public void leerXmlPreguntas() throws JDOMException, IOException
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
		
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "data/Preguntas.xml" ); // Nombre de nuestro archivo
	   
	    Document document = (Document) builder.build(xmlFile);
        // Se obtiene el elemento raiz
        Element rootNode = document.getRootElement();
        
        System.out.println("El rootNode es" +rootNode);
        System.out.println( " ");
           
        
        System.out.println("Actualmente tenemos  "+ rootNode.getChildren().size()+ " guardadas en memoria a disposicion del usuario"); // Devuelve el contenido del fichero...
        											//Almenos el tipo de elementos que contiene
        											// Aunque sin atributos
        
        System.out.println(" ");
        
        
        
        
        
        
        
        
        List<Element>lista_P = rootNode.getChildren("pregunta");
        ArrayList<Pregunta> Array_P= new ArrayList<Pregunta>();
        
        ArrayList<Pregunta> Array_P_aux= new ArrayList<Pregunta>();//Un array en el que meterlos ( preguntas de la partida)
     // Para todos los elementos guardados en <Preguntas> y que sean <pregunta>
        for(int i=0;i<=lista_P.size()-1;i++)
        {
        	
         Element element = (Element) lista_P.get(i); //Creamos un elemento que vaya recogiendo los elementos "pregunta"
         Pregunta pregunta = new Pregunta();			// Una instancia de la clase auxiliar para crear preguntad con los datos del elemento
        
         
         pregunta.setPregunta(element.getChildText("P")); //Mostramos el texto de la pregutna por pantalla y se lo pasamos como atributo a la instancia
         System.out.println("Pregunta : "+element.getChildText("P"));
         
         System.out.println("Respuestas posibles : ");//lo mismo con las respuestas
          List lista_R = element.getChildren("R");//Al haber 3 las recogemos en una lista
          ArrayList <String> resp_aux = new ArrayList <String> (); // Y sino al Array de incorrectas
          int numero_r;
        	for(int j=0; j<=lista_R.size()-1;j++) //Hacemos un for para ir sacandolas
        		
        	{
        		numero_r=j+1;
        		Element element_R = (Element) lista_R.get(j); 
        		if(element_R.getAttributeValue("tipo").equals("T")) //Si es T pasa al atributo String Correcta
        		{
        			pregunta.setCorrecta(element_R.getText());
        		}
        		
        		
        		
        		if(element_R.getAttributeValue("tipo").equals("F"))
        		{
        			
        			resp_aux.add(element_R.getText());
        			pregunta.setRespuestas(resp_aux);
        		}
        		
        		//Mostramos por pantalla el resto de la info de la pregunta
        		System.out.println("Respuesta " + numero_r + " " +element_R.getText() + " "+ element_R.getAttributeValue("tipo")); 
        		
        	}
        	
        	
        pregunta.setCategoria(element.getChildText("C")); //Lo mismo que con el texto de la pregunta
        System.out.println("Categoria : "+element.getChildText("C"));
  
         
         System.out.println( " ");
         
         
         
         //A�adimos las preguntas al Array auxiliar de preguntas 
         Array_P_aux.add(pregunta);
         
         Array_P=Array_P_aux;
        
        	 
        }
        

        
    
        }
	
	public Pregunta SacarPregunta (String categoria) throws JDOMException, IOException
	{
		  SAXBuilder builder = new SAXBuilder();
		    File xmlFile = new File( "data/Preguntas.xml" ); // Nombre de nuestro archivo
		   
		    Document document = (Document) builder.build(xmlFile);
	        // Se obtiene el elemento raiz
	        Element rootNode = document.getRootElement();
	       
	        
	        List<Element>lista_P = rootNode.getChildren("pregunta");
	        ArrayList<Pregunta> Array_P= new ArrayList<Pregunta>();
	        
	        ArrayList<Pregunta> Array_P_aux= new ArrayList<Pregunta>();//Un array en el que meterlos ( preguntas de la partida)
	        // Para todos los elementos guardados en <Preguntas> y que sean <pregunta>
	           for(int i=0;i<=lista_P.size()-1;i++)
	           {
	           	
	            Element element = (Element) lista_P.get(i); //Creamos un elemento que vaya recogiendo los elementos "pregunta"
	            Pregunta pregunta = new Pregunta();			// Una instancia de la clase auxiliar para crear preguntad con los datos del elemento
	            
	            if(element.getChildText("C").equals(categoria))
	            {
	            
	            pregunta.setPregunta(element.getChildText("P")); 
	           
	           
	            
	            
	             List lista_R = element.getChildren("R");//Al haber 3 las recogemos en una lista
	             ArrayList <String> resp_aux = new ArrayList <String> (); // Y sino al Array de incorrectas
	             
	             for(int j=0; j<=lista_R.size()-1;j++) //Hacemos un for para ir sacandolas
	           		
	             {
	           		
	           		Element element_R = (Element) lista_R.get(j); 
	           		if(element_R.getAttributeValue("tipo").equals("true")) //Si es T pasa al atributo String Correcta
	           		{
	           			pregunta.setCorrecta(element_R.getText());
	           		}
	           		
	           		if(element_R.getAttributeValue("tipo").equals("false"))
	           		{
	           			
	           			resp_aux.add(element_R.getText());
	           			pregunta.setRespuestas(resp_aux);
	           		}
	           		
	           	
	           	}
	           	
	           pregunta.setCategoria(element.getChildText("C")); //Lo mismo que con el texto de la pregunta
	           Array_P_aux.add(pregunta);
	           Array_P=Array_P_aux;
	          }
	           
	        
	       }
	           
	           //Elegir aleatoriamente una pregunta del array_P
	           
	          int posAleatoria= (int)(Math.random()*(Array_P.size()-1) + 0);
	           Pregunta p=Array_P.get(posAleatoria);// en lugar de object pones el tipo de dato que maneja tu array 
	           return p;
	        
	}
	
	
	
	
	
	}
