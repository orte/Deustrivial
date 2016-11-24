package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LD.GestorSQL;
import LN.GestorPartidas;
import LN.Jugador;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class frmEmpezarPartida extends JFrame implements ActionListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	
	
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	JButton btnNewButton;
	
	ArrayList<Jugador>lista_jugadores;
	ArrayList<String> nombres ;
	
	final String comando_E= "E";
	final int ERROR_MESSAGE=0;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmpezarPartida frame = new frmEmpezarPartida();
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
	public frmEmpezarPartida() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(152, 251, 152), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CargarDatos();
		
		CreateAndShow();
		
		
		
	}
	
	public void CreateAndShow()
	{
		lblNewLabel = new JLabel("JUGADOR 1");
		lblNewLabel.setBounds(15, 117, 259, 42);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("JUGADOR 2");
		lblNewLabel_1.setBounds(415, 115, 251, 46);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 224));
		comboBox.setToolTipText("Recuerde no seleccionar el mismo jugador en los dos campos");
		comboBox.setBounds(15, 175, 259, 42);
		for(Jugador a : lista_jugadores)
		{
			comboBox.addItem(a.getNombre_usuario()+ " "+ a.getId());
		}
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(new Color(255, 255, 224));
		comboBox_1.setToolTipText("Recuerde no seleccionar el mismo jugador en los dos campos");
		comboBox_1.setBounds(415, 175, 259, 42);
		
		
		
		for(Jugador a : lista_jugadores)
		{
			comboBox_1.addItem(a.getNombre_usuario()+ " "+ a.getId());
		}
		contentPane.add(comboBox_1);
		
		btnNewButton = new JButton("EMPEZAR");
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setBounds(278, 369, 143, 42);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand(comando_E);
		contentPane.add(btnNewButton);
	}
	
	
	public void CargarDatos() 
	{
		
		GestorSQL gestorS = new GestorSQL();
		lista_jugadores= new ArrayList<Jugador>();
		nombres = new ArrayList<String>();
		
		lista_jugadores=gestorS.MostrarJugadores();

		for(Jugador j : lista_jugadores)
		{
			
			nombres.add(j.getNombre_usuario());
			
		}
		
		
		
	}

	public void CrearPartida()
	{
		boolean comprobacion=false;
		if(comboBox.getSelectedItem().equals(comboBox_1.getSelectedItem()))
		{
			comprobacion=true;
			JOptionPane.showMessageDialog(null, "Un jugador no puede jugar contra si mismo... Por favor, seleccione dos jugadores diferentes para comenzar la partida", "Error", ERROR_MESSAGE);

		}
		
		if(comprobacion==false)
		{
			FrameTablero tablero= new FrameTablero();
			tablero.setVisible(true);
			
			GestorPartidas gestorP= new GestorPartidas();
			
		//	gestorP.CrearPartida(id1, id2);
			
			//CrearClasePartida y Guardarla en fichero
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		String evento= arg0.getActionCommand();
		
		switch(evento)
		{
		case comando_E : CrearPartida();break;
		}
		
		
		
	}
}
