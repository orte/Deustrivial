package LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.GestorSQL;
import LN.Jugador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;

public class frmNuevoJ extends JFrame implements ActionListener 
{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel contentPane;
	JTextField textField;
	JLabel lblNewLabel;
	JButton btnNewButton;
	
	GestorSQL gestorS;
	ArrayList<Jugador> lista_jugadores ;
	
	final int ERROR_MESSAGE=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNuevoJ frame = new frmNuevoJ();
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
	public frmNuevoJ() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Escriba el nombre del nuevo jugador");
		textField.setBounds(127, 119, 146, 26);
		contentPane.add(textField);
	
		
		lblNewLabel = new JLabel("NUEVO JUGADOR");
		lblNewLabel.setBounds(147, 66, 168, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setBounds(140, 186, 115, 29);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		CargarDatos();
		
		
	}
	
	public void CargarDatos()
	{
		gestorS= new GestorSQL();
		lista_jugadores= new ArrayList<Jugador>();
		
		lista_jugadores=gestorS.MostrarJugadores();
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		String nuevo_nombre=textField.getText();
		boolean comprobacion = false;
		
		for(Jugador a : lista_jugadores)
		{
			if(a.getNombre_usuario().equals(nuevo_nombre))
			{
				comprobacion=true;
				JOptionPane.showMessageDialog(null, "Ya existe un jugador con ese nombre de Usuario, porfavor eliga otro que no este cogido ya.", "Error", ERROR_MESSAGE);
				textField.setText(" ");
			}
		}
		
		if(comprobacion==false)
		{
			gestorS.GuardarJugadorYEstadistica(nuevo_nombre);
		}
		
		
	}
}
