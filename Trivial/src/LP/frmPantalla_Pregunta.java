package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom2.JDOMException;

import LD.GestorXML;
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
	JPanel contentPane;
	 JPanel panel;
	 JPanel panel_1;
	 
	 JButton btn_R1;
	 JButton btn_R2;
	 JButton btn_R3;
	 JButton btn_R4; 
	 
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
	 
	 private int temporizador;
	 private Thread t = null;
	 private JTextField tempoField;
	

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(17, 21, 451, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(17, 206, 451, 222);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));

		temporizador = 30;
		
		tempoField = new JTextField();
		tempoField.setBounds(100, 460, 114, 19);
		contentPane.add(tempoField);
		tempoField.setText(new Integer(temporizador).toString());
		tempoField.setColumns(10);
		
		categoria=Cat;
		
		CargarDatos();
		CreateAndShow();
		
	}
	
	public void CargarDatos() throws JDOMException, IOException
	{
		GestorXML gestor = new GestorXML();
		//p=gestor.SacarPregunta(categoria);
		ArrayList<String> res = new ArrayList<String>();
		String[] dffdj = {"a", "b", "c"};
		res.addAll(Arrays.asList(dffdj));
		p = new Pregunta("ju", "hu", res, "juihu");
		pregunta= p.getPregunta();
		
		correcta = p.getCorrecta();
		
		lista_R=p.getRespuestas();
		lista_R.add(correcta);
		
		String aux= " ";
		
		
		
		int pos=0;
		
		//Como la lista de respuestas siempre va aser size 4
		//Y no sabria hacer que con un bucle se fuesen sacan respuestas y
		//metiendolas en el texto de cada boton aleatoriamente, lo haremos repitiendo codigo.
			
			pos=(int) (Math.random()*(lista_R.size()-1)+1);
			aux=lista_R.get(pos);
			lista_R.remove(pos);
			opcion1=aux;
			
			pos=(int) (Math.random()*(lista_R.size()-1)+1);
			aux=lista_R.get(pos);
			lista_R.remove(pos);
			opcion2=aux;
			
			pos=(int) (Math.random()*(lista_R.size()-1)+1);
			aux=lista_R.get(pos);
			lista_R.remove(pos);
			opcion3=aux;
			
			pos=0;
			aux=lista_R.get(pos);
			lista_R.remove(pos);
			opcion4=aux;
		
	}
	public void CreateAndShow()
	{
		
		
		btn_R1 = new JButton(opcion1);
		btn_R1.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R1.addActionListener(this);
		btn_R1.setActionCommand(comando_R1);
		panel_1.add(btn_R1);
		
		btn_R2 = new JButton(opcion2);
		btn_R2.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R2.addActionListener(this);
		btn_R2.setActionCommand(comando_R2);
		panel_1.add(btn_R2);
		
		btn_R3 = new JButton(opcion3);
		btn_R3.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R3.addActionListener(this);
		btn_R3.setActionCommand(comando_R3);
		panel_1.add(btn_R3);
		
		btn_R4 = new JButton(opcion4);
		btn_R4.setFont(new Font("Arial", Font.PLAIN, 21));
		btn_R2.addActionListener(this);
		btn_R4.setActionCommand(comando_R4);
		panel_1.add(btn_R4);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN,20));
		textArea.setEditable(false);
		textArea.setBounds(0, 29, 451, 141);
		textArea.setLineWrap(true); // Para que el texto se divida en lineas
		textArea.setText(p.getPregunta());
		panel.add(textArea);
		
		JLabel lblPregunta = new JLabel("PREGUNTA");
		lblPregunta.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPregunta.setBounds(168, 0, 114, 20);
		panel.add(lblPregunta);
		
		Runnable r = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(temporizador>0){
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
		 while(t.isAlive()){

		 }
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		String c = e.getActionCommand();
		String respuesta = " ";
		String r1=" ";
		String r2=" ";
		String r3=" ";
		
		switch(c)
		{
		case comando_R1: respuesta = btn_R1.getText() ;
					if(respuesta.equals(correcta))
					{
						btn_R1.setBackground(java.awt.Color.green);
						//Metodo jugador.sumarRespuestaAcertada(); -> lo suma a sus estadisticas
						//Metodo FichaJugador+ quesito? + turno?
					}
					else
					{
						btn_R1.setBackground(java.awt.Color.red);
						if(btn_R2.getText().equals(correcta))
						{
							btn_R2.setBackground(Color.green);
						}
						else if (btn_R3.getText().equals(correcta))
						{
							btn_R3.setBackground(Color.green);
						}
						else btn_R4.setBackground(Color.green);
						
					};break;
		case comando_R2: respuesta = btn_R2.getText();
					if(respuesta.equals(correcta))
					{btn_R2.setBackground(java.awt.Color.green);}
					else
					{
						btn_R2.setBackground(java.awt.Color.red);
						if(btn_R1.getText().equals(correcta))
						{
							btn_R1.setBackground(Color.green);
						}
						else if (btn_R3.getText().equals(correcta))
						{
							btn_R3.setBackground(Color.green);
						}
						else btn_R4.setBackground(Color.green);
					};break;
		case comando_R3: respuesta = btn_R3.getText();
					if(respuesta.equals(correcta))
					{btn_R3.setBackground(java.awt.Color.green);}
					else 
					{
						btn_R3.setBackground(java.awt.Color.red);
						if(btn_R1.getText().equals(correcta))
						{
							btn_R1.setBackground(Color.green);
						}
						else if (btn_R2.getText().equals(correcta))
						{
							btn_R2.setBackground(Color.green);
						}
						else btn_R4.setBackground(Color.green);
					
					};break;
		case comando_R4: respuesta = btn_R4.getText();
					if(respuesta.equals(correcta))
					{btn_R4.setBackground(java.awt.Color.green);} 
					else 
					{
						btn_R4.setBackground(java.awt.Color.red);
						if(btn_R1.getText().equals(correcta))
						{
							btn_R1.setBackground(Color.green);
						}
						else if (btn_R3.getText().equals(correcta))
						{
							btn_R3.setBackground(Color.green);
						}
						else btn_R2.setBackground(Color.green);
					
					};break;
		
		}
		
	}
}