package LD;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;



public class clsGestorXML 
{

	public clsGestorXML()
	{
		super();
	}
	
	public void cargarXml() throws JDOMException, IOException
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
		
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "Preguntas.xml" ); // Nombre de nuestro archivo
	   
	    Document document = (Document) builder.build(xmlFile);
        // Se obtiene el elemento raiz
        Element rootNode = document.getRootElement();
        
        System.out.println("El rootNode es" +rootNode);
        
        List miembros = rootNode.getChildren("miembro");
        
        System.out.println("Sus Children son" + miembros);
        
        
        System.out.println(rootNode.getContent()); // Devuelve el contenido del fichero...
        											//Almenos el tipo de elementos que contiene
        											// Aunque sin atributos
        
        List lista_P = rootNode.getChildren("pregunta");
        
     // Para todos los elementos guardados en <Preguntas> y que sean <pregunta>
        for(int i=0;i<=lista_P.size()-1;i++)
        {
         Element element = (Element) lista_P.get(i);
         System.out.println("Pregunta : "+element.getChildText("P"));
         System.out.println("Respuestas posibles : ");
         
        List lista_R = element.getChildren("R");
        int numero_r;
        	for(int j=0; j<=lista_R.size()-1;j++)
        		
        	{
        		numero_r=j+1;
        		Element element_R = (Element) lista_R.get(j);
        		System.out.println("Respuesta " + numero_r + " " +element_R.getText());
        		
        	}
        
        
    
         System.out.println("C : "+element.getChildText("C"));
        
         
         System.out.println( " ");
        }
       
       
     
        
        }
        
        
	
	}

