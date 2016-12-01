package LP;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom2.JDOMException;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Color;

import LN.Pregunta;

/**
 * 
 * @author Josune
 *
 */

public class FrameTablero extends JFrame implements ActionListener
{

	
	private static final long serialVersionUID = 1L;
	
	
	JPanel contentPane;
	
	JButton btnNewButton_11;
	JButton btnNewButton_28;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_7;
	JButton btnNewButton_8;
	JButton btnNewButton_9;
	JButton btnNewButton_10;
	JButton btnNewButton_12;
	JButton btnNewButton_13;
	JButton btnNewButton_14;
	JButton btnNewButton_15;
	JButton btnNewButton_16;
	JButton btnNewButton_17;
	JButton btnNewButton_18;
	JButton btnNewButton_19;
	JButton btnNewButton_20;
	JButton btnNewButton_21;
	JButton btnNewButton_22;
	JButton btnNewButton_23;
	JButton btnNewButton_24;
	JButton btnNewButton_25;
	JButton btnNewButton_26;
	JButton btnNewButton_27;
	JButton btnNewButton_29;
	JButton btnNewButton_30;
	JButton btnNewButton_31;
	JButton btnNewButton_32;
	JButton btnNewButton_33;
	JButton btnNewButton_34;
	
	JLabel ficha1;
	JLabel ficha2;
	
	final String comando_Ocio=" Ocio ";
	final String comando_Historia=" Historia ";
	final String comando_Geografia=" Geografia ";
	final String comando_Ciencia=" Ciencia ";
	final String comando_Deportes=" Deportes ";
	
	ArrayList<ArrayList<Pregunta>> listas;
	
			/**
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FrameTablero frame = new FrameTablero();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

	/**
	 * Create the frame.
	 */
	public FrameTablero() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 683);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 7, 0, 0));
		
		
		
		CreateAndShow();
		CargarDatos();
		
		
		
	}
	
	public void CargarDatos()
	{
		
	}
	public void CreateAndShow()
	{
		btnNewButton_11 = new JButton("Ocio");
		btnNewButton_11.setBackground(Color.magenta.darker());
		btnNewButton_11.addActionListener(this);
		btnNewButton_11.setActionCommand(comando_Ocio);
		contentPane.add(btnNewButton_11);
		
		btnNewButton_28 = new JButton("Historia");
		btnNewButton_28.setBackground(Color.yellow);
		btnNewButton_28.addActionListener(this);
		btnNewButton_28.setActionCommand(comando_Historia);
		contentPane.add(btnNewButton_28);
		
		btnNewButton_30 = new JButton("Ciencia");
		btnNewButton_30.setBackground(Color.green);
		btnNewButton_30.addActionListener(this);
		btnNewButton_30.setActionCommand(comando_Ciencia);
		contentPane.add(btnNewButton_30);
		
		btnNewButton_29 = new JButton("Deportes");
		btnNewButton_29.setBackground(Color.orange);
		btnNewButton_29.addActionListener(this);
		btnNewButton_29.setActionCommand(comando_Deportes);
		contentPane.add(btnNewButton_29);
		
		btnNewButton_7 = new JButton("Geografia");
		btnNewButton_7.setBackground(Color.cyan.darker());
		btnNewButton_7.addActionListener(this);
		btnNewButton_7.setActionCommand(comando_Geografia);
		contentPane.add(btnNewButton_7);
		
		btnNewButton_1 = new JButton("Geografia");
		btnNewButton_1.setBackground(Color.cyan.darker());
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand(comando_Geografia);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setVisible(false);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Ocio");
		btnNewButton_3.setBackground(Color.magenta.darker());
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setActionCommand(comando_Ocio);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setVisible(false);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Ocio");
		btnNewButton_5.setBackground(Color.magenta.darker());
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setActionCommand(comando_Ocio);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_8 = new JButton("Deportes");
		btnNewButton_8.setBackground(Color.orange);
		btnNewButton_8.addActionListener(this);
		btnNewButton_8.setActionCommand(comando_Deportes);
		contentPane.add(btnNewButton_8);
		
		btnNewButton_14 = new JButton("New button");
		btnNewButton_14.setVisible(false);
		contentPane.add(btnNewButton_14);
		
		btnNewButton_6 = new JButton("Deportes");
		btnNewButton_6.setBackground(Color.orange);
		btnNewButton_6.addActionListener(this);
		btnNewButton_6.setActionCommand(comando_Deportes);
		contentPane.add(btnNewButton_6);
		
		btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setVisible(false);
		contentPane.add(btnNewButton_10);
		
		btnNewButton_12 = new JButton("Historia");
		btnNewButton_12.setBackground(Color.yellow);
		btnNewButton_12.addActionListener(this);
		btnNewButton_12.setActionCommand(comando_Historia);
		contentPane.add(btnNewButton_12);
		
		btnNewButton_15 = new JButton("Ciencia");
		btnNewButton_15.setBackground(Color.green);
		btnNewButton_15.addActionListener(this);
		btnNewButton_15.setActionCommand(comando_Ciencia);
		contentPane.add(btnNewButton_15);
		
		btnNewButton_9 = new JButton("Geografia");
		btnNewButton_9.setBackground(Color.cyan.darker());
		btnNewButton_9.addActionListener(this);
		btnNewButton_9.setActionCommand(comando_Geografia);
		contentPane.add(btnNewButton_9);
		
		btnNewButton = new JButton("FINISH");
		btnNewButton.setBackground(Color.pink);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnNewButton_18 = new JButton("Geografia");
		btnNewButton_18.setBackground(Color.cyan.darker());
		btnNewButton_18.addActionListener(this);
		btnNewButton_18.setActionCommand(comando_Geografia);
		contentPane.add(btnNewButton_18);
		
		btnNewButton_21 = new JButton("Ciencia");
		btnNewButton_21.setBackground(Color.green);
		btnNewButton_21.addActionListener(this);
		btnNewButton_21.setActionCommand(comando_Ciencia);
		contentPane.add(btnNewButton_21);
		
		btnNewButton_13 = new JButton("Historia");
		btnNewButton_13.setBackground(Color.yellow);
		btnNewButton_13.addActionListener(this);
		btnNewButton_13.setActionCommand(comando_Historia);
		contentPane.add(btnNewButton_13);
		
		btnNewButton_16 = new JButton("New button");
		btnNewButton_16.setVisible(false);
		contentPane.add(btnNewButton_16);
		
		btnNewButton_17 = new JButton("Historia");
		btnNewButton_17.setBackground(Color.yellow);
		btnNewButton_17.addActionListener(this);
		btnNewButton_17.setActionCommand(comando_Historia);
		contentPane.add(btnNewButton_17);
		
		btnNewButton_24 = new JButton("New button");
		btnNewButton_24.setVisible(false);
		contentPane.add(btnNewButton_24);
		
		btnNewButton_19 = new JButton("Deportes");
		btnNewButton_19.setBackground(Color.orange);
		btnNewButton_19.addActionListener(this);
		btnNewButton_19.setActionCommand(comando_Deportes);
		contentPane.add(btnNewButton_19);
		
		btnNewButton_20 = new JButton("Ocio");
		btnNewButton_20.setBackground(Color.magenta.darker());
		btnNewButton_20.addActionListener(this);
		btnNewButton_20.setActionCommand(comando_Ocio);
		contentPane.add(btnNewButton_20);
		
		btnNewButton_22 = new JButton("New button");
		btnNewButton_22.setVisible(false);
		contentPane.add(btnNewButton_22);
		
		btnNewButton_23 = new JButton("Ocio");
		btnNewButton_23.setBackground(Color.magenta.darker());
		btnNewButton_23.addActionListener(this);
		btnNewButton_23.setActionCommand(comando_Ocio);
		contentPane.add(btnNewButton_23);
		
		btnNewButton_25 = new JButton("New button");
		btnNewButton_25.setVisible(false);
		contentPane.add(btnNewButton_25);
		
		btnNewButton_26 = new JButton("Geografia");
		btnNewButton_26.setBackground(Color.cyan.darker());
		btnNewButton_26.addActionListener(this);
		btnNewButton_26.setActionCommand(comando_Geografia);
		contentPane.add(btnNewButton_26);
		
		btnNewButton_27 = new JButton("Geografia");
		btnNewButton_27.setBackground(Color.cyan.darker());
		btnNewButton_27.addActionListener(this);
		btnNewButton_27.setActionCommand(comando_Geografia);
		contentPane.add(btnNewButton_27);
		
		btnNewButton_31 = new JButton("Deportes");
		btnNewButton_31.setBackground(Color.orange);
		btnNewButton_31.addActionListener(this);
		btnNewButton_31.setActionCommand(comando_Deportes);
		contentPane.add(btnNewButton_31);
		
		btnNewButton_32 = new JButton("Ciencia");
		btnNewButton_32.setBackground(Color.green);
		btnNewButton_32.addActionListener(this);
		btnNewButton_32.setActionCommand(comando_Ciencia);
		contentPane.add(btnNewButton_32);
		
		btnNewButton_33 = new JButton("Historia");
		btnNewButton_33.setBackground(Color.yellow);
		btnNewButton_33.addActionListener(this);
		btnNewButton_33.setActionCommand(comando_Historia);
		contentPane.add(btnNewButton_33);
		
		btnNewButton_34 = new JButton("Ocio");
		btnNewButton_34.setBackground(Color.magenta.darker());
		btnNewButton_34.addActionListener(this);
		btnNewButton_34.setActionCommand(comando_Ocio);
		contentPane.add(btnNewButton_34);
		
	}
	
	public void AbrirVentanaPregunta(String c) 
	{
		
		frmPantalla_Pregunta pantalla;
		try {
			pantalla = new frmPantalla_Pregunta(c);
			pantalla.setVisible(true);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//Aquí tenías un switch montado para pasarle la categoría correcta a la ventanaPregunta pero era tan sencillo
		//como pasarle directamente el comando que recibamos y ya
		// TODO Auto-generated method stub
		String categoria=arg0.getActionCommand();
		AbrirVentanaPregunta(categoria);
			
	}

}
