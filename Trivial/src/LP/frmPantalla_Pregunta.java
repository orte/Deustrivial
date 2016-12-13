package LP;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom2.JDOMException;

import LN.GestorPartidas;
import LN.Pregunta;
import javax.swing.JTextArea;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Josune
 *
 */
public class frmPantalla_Pregunta extends JFrame implements ActionListener
{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean running; //boolean para controlar cuando está corriendo el temporizador de la pregunta
	JPanel contentPane;
	 JPanel panel;
	 JPanel panel_1;
	 
	 JButton btn_R1;
	 JButton btn_R2;
	 JButton btn_R3;
	 JButton btn_R4; 
	 
	 JButton[] listaBotones = new JButton[4]; //array de botones para gestionarlos más cómodamente
	 
	 final String comando_R1="R1";
	 final String comando_R2="R2";
	 final String comando_R3="R3";
	 final String comando_R4="R4";
	 
	 String opcion1 = null;
	 String opcion2 = null;
	 String opcion3 = null;
	 String opcion4 = null;
	 
	 ArrayList<String> lista_R; // Las respuestas posibles sacadas de fichero vienen aqui
	 String pregunta ; // el texto de la pregunta viene aqui
	 String correcta; 
	 String categoria = " ";//Esto tenemos que conocerlo de antees 
	// AL crear la ventana la podemos pasar por parametro y en la primera linea
	 //del constructor meterla en este String
	 
	 Pregunta p ;
	 private JTextArea textArea;
	 
	 int temporizador;
	 Thread t = null;
	 JTextField tempoField;
	 
	 GestorPartidas gesPart = new GestorPartidas();
	

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPantalla_Pregunta frame = new frmPantalla_Pregunta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public frmPantalla_Pregunta(String Cat) throws JDOMException, IOException 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(17, 21, 451, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(17, 206, 451, 222);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));

		temporizador = 30;
		
		categoria=Cat;
		
		CargarDatos();
		CreateAndShow();
		
	}
	
	public void CargarDatos() throws JDOMException, IOException
	{
		
		p=gesPart.obtenerPregunta(categoria);
		//le he añadido a GestorPartidas un método de obtener pregunta como el que había en GestorXML, lo he hecho
		//porque en teoría la LP y la LD no se deberían interconectar "a pelo", esa información tiene que pasar por
		//la LD
		lista_R = p.getRespuestas();
		//Ahora el arraylist de respuestas es de 4, ya que he incluido también la respuesta correcta y luego
		//el atributo Correcta es un int que representa el indice de la respuesta correcta dentro de ese array
		//de esta manera es mucho más fácil de manejar en todos los sentidos. He modificado un poco gestorXML para
		//eso también
		
		
		pregunta= p.getPregunta();
		int corr = p.getCorrecta(); 
		correcta = p.getRespuestas().get(corr);
		
		//Aquí lo habías hecho de manera que las diferentes respuestas se pusiesen en los botones de forma aleatoria
		//pero no se si es necesario, igual es liarse de más
		
		
//		String aux= " ";
//	
//		int pos=0;
//		
		//Como la lista de respuestas siempre va aser size 4
		//Y no sabria hacer que con un bucle se fuesen sacan respuestas y
		//metiendolas en el texto de cada boton aleatoriamente, lo haremos repitiendo codigo.
			
//			pos=(int) (Math.random()*(lista_R.size()-1)+1);
//			aux=lista_R.get(pos);
//			lista_R.remove(pos);
//			opcion1=aux;
//			
//			pos=(int) (Math.random()*(lista_R.size()-1)+1);
//			aux=lista_R.get(pos);
//			lista_R.remove(pos);
//			opcion2=aux;
//			
//			pos=(int) (Math.random()*(lista_R.size()-1)+1);
//			aux=lista_R.get(pos);
//			lista_R.remove(pos);
//			opcion3=aux;
//			
//			pos=0;
//			aux=lista_R.get(pos);
//			lista_R.remove(pos);
//			opcion4=aux;
		
	}
	public void CreateAndShow()
	{
		//Aquí voy metiendo los botones en el array a medida que los creo, y les pongo el texto que corresponde a 
		//esa misma posición en el array de respuestas
		btn_R1 = new JButton();
		btn_R1.setBackground(new Color(204, 255, 204));
		btn_R1.setText(lista_R.get(0));
		btn_R1.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R1.addActionListener(this);
		btn_R1.setActionCommand(comando_R1);
		panel_1.add(btn_R1);
		listaBotones[0] = btn_R1;
		
		btn_R2 = new JButton();
		btn_R2.setBackground(new Color(204, 255, 204));
		btn_R2.setText(lista_R.get(1));
		btn_R2.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R2.addActionListener(this);
		btn_R2.setActionCommand(comando_R2);
		panel_1.add(btn_R2);
		listaBotones[1] = btn_R2;
		
		btn_R3 = new JButton();
		btn_R3.setBackground(new Color(204, 255, 204));
		btn_R3.setText(lista_R.get(2));
		btn_R3.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R3.addActionListener(this);
		btn_R3.setActionCommand(comando_R3);
		panel_1.add(btn_R3);
		listaBotones[2] = btn_R3;
		
		btn_R4 = new JButton();
		btn_R4.setBackground(new Color(204, 255, 204));
		btn_R4.setText(lista_R.get(3));
		btn_R4.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R2.addActionListener(this);
		btn_R4.setActionCommand(comando_R4);
		panel_1.add(btn_R4);
		listaBotones[3] = btn_R4;
		
		JLabel lblPregunta = new JLabel("PREGUNTA");
		lblPregunta.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPregunta.setBounds(168, 0, 114, 20);
		panel.add(lblPregunta);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 224));
		textArea.setFont(new Font("Arial", Font.PLAIN,20));
		textArea.setEditable(false);
		textArea.setBounds(15, 29, 451, 141);
		textArea.setLineWrap(true); // Para que el texto se divida en lineas
		textArea.setText(p.getPregunta());
		panel.add(textArea);
		
		tempoField = new JTextField();
		tempoField.setBackground(new Color(255, 255, 224));
		tempoField.setFont(new Font("Arial", Font.BOLD, 21));
		tempoField.setBounds(40, 1, 89, 28);
		panel.add(tempoField);
		tempoField.setEditable(false);
		tempoField.setText(new Integer(temporizador).toString());
		tempoField.setColumns(10);
		
		
		
		//El runnable del temporizador, mientras running sea true y no haya llegado a 0 irá contando descendentemente
		//de 30 a 0 e irá actualizando el textfield del temporizador
		
		Runnable r = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				running = true;
				try {
					while(temporizador>0 && running){
						temporizador--;
						System.out.println(temporizador);
						Thread.sleep(1000);
						tempoField.setText(new Integer(temporizador).toString());
						tempoField.repaint();
						getContentPane().revalidate();
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			 
		 };
		 this.setVisible(true);
		 t = new Thread(r);
		 t.start();
		 
	}
	public void pararTemporizador(){ //para parar el temporizador cuando se pulse un botón, sin más
		running = false;
	}

	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		pararTemporizador();
		
		String c = e.getActionCommand();
		String respuesta = " ";
		
		//Había visto como lo habías hecho y creo que era más sencillo guardar los cuatro botones en un array,
		//y a la hora de tener que cambiarle el color a la respuesta elegida, mirar	si el índice de la respuesta
		//correcta era el mismo que el índice del botón en el array. En el caso de que si, lo pintas de verde, y 
		//en el caso de que no, lo pintas de rojo y pintas de verde el botón que corresponde a la respuesta correcta
		
		for(int i = 0; i<listaBotones.length; i++){
			if(c.equals(listaBotones[i].getActionCommand())){
				JButton btnAux = listaBotones[i];
				respuesta = btnAux.getText();
				if(respuesta.equals(correcta)){
					btnAux.setBackground(Color.green);
				} else {
					btnAux.setBackground(Color.red);
					listaBotones[p.getCorrecta()].setBackground(Color.green);
				}
			}
		}

		
//		String r1=" ";
//		String r2=" ";
//		String r3=" ";
//		
//		switch(c)
//		{
//		case comando_R1: respuesta = btn_R1.getText() ;
//			if(respuesta.equals(correcta))
//			{
//				btn_R1.setBackground(java.awt.Color.green);
//				//Metodo jugador.sumarRespuestaAcertada(); -> lo suma a sus estadisticas
//				//Metodo FichaJugador+ quesito? + turno?
//			}
//			else
//			{
//				btn_R1.setBackground(java.awt.Color.red);
//				if(btn_R2.getText().equals(correcta))
//				{
//					btn_R2.setBackground(Color.green);
//				}
//				else if (btn_R3.getText().equals(correcta))
//				{
//					btn_R3.setBackground(Color.green);
//				}
//				else btn_R4.setBackground(Color.green);
//	
//			};break;
//		case comando_R2: respuesta = btn_R2.getText();
//			if(respuesta.equals(correcta))
//			{btn_R2.setBackground(java.awt.Color.green);}
//			else
//			{
//				btn_R2.setBackground(java.awt.Color.red);
//				if(btn_R1.getText().equals(correcta))
//				{
//					btn_R1.setBackground(Color.green);
//				}
//				else if (btn_R3.getText().equals(correcta))
//				{
//					btn_R3.setBackground(Color.green);
//				}
//				else btn_R4.setBackground(Color.green);
//			};break;
//		case comando_R3: respuesta = btn_R3.getText();
//			if(respuesta.equals(correcta))
//			{btn_R3.setBackground(java.awt.Color.green);}
//			else 
//			{
//				btn_R3.setBackground(java.awt.Color.red);
//				if(btn_R1.getText().equals(correcta))
//				{
//					btn_R1.setBackground(Color.green);
//				}
//				else if (btn_R2.getText().equals(correcta))
//				{
//					btn_R2.setBackground(Color.green);
//				}
//				else btn_R4.setBackground(Color.green);
//	
//			};break;
//		case comando_R4: respuesta = btn_R4.getText();
//			if(respuesta.equals(correcta))
//			{btn_R4.setBackground(java.awt.Color.green);} 
//			else 
//			{
//				btn_R4.setBackground(java.awt.Color.red);
//				if(btn_R1.getText().equals(correcta))
//				{
//					btn_R1.setBackground(Color.green);
//				}
//				else if (btn_R3.getText().equals(correcta))
//				{
//					btn_R3.setBackground(Color.green);
//				}
//				else btn_R2.setBackground(Color.green);
//	
//			};break;
//
//		}
		
	}
}