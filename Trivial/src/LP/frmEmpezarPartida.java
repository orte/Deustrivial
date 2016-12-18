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
import LN.FichaDePartida;
import LN.GestorPartidas;
import LN.Jugador;
import LN.Partida;
import LP.FrameTableroCopy;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class frmEmpezarPartida extends JFrame implements ActionListener 
{
	
	//Falta: que si a pantalla cambia de tama�o el JPanel y su contenido lo hagan tambien.

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
	ArrayList<Partida>lista_partidas;
	ArrayList<String> nombres ;
	
	final String comando_E= "E";
	final int ERROR_MESSAGE=0;
	GestorSQL gestorS;
	
	
	
	

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
			comboBox.addItem(a.getNombre_usuario());
		}
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(new Color(255, 255, 224));
		comboBox_1.setToolTipText("Recuerde no seleccionar el mismo jugador en los dos campos");
		comboBox_1.setBounds(415, 175, 259, 42);
		
		
		
		for(Jugador a : lista_jugadores)
		{
			comboBox_1.addItem(a.getNombre_usuario());
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
		
		gestorS = new GestorSQL();
		lista_jugadores= new ArrayList<Jugador>();
		nombres = new ArrayList<String>();
		
		lista_jugadores=gestorS.MostrarJugadores();

		for(Jugador j : lista_jugadores)
		{
			
			nombres.add(j.getNombre_usuario());
			
		}
		
		lista_partidas=gestorS.MostrarPartidas();
		
		
		
		
	}

	public void CrearPartida()
	{
		
		//Comprobar que no es el mismo jugador en los dos campos 
		boolean comprobacion=false;
		boolean comprobacion_2 = false;
		
		String id_jug1=" ";
		String id_jug2= " ";
		if(comboBox.getSelectedItem().equals(comboBox_1.getSelectedItem()))
		{
			comprobacion=true;
			JOptionPane.showMessageDialog(null, "Un jugador no puede jugar contra si mismo... Por favor, seleccione dos jugadores diferentes para comenzar la partida", "Error", ERROR_MESSAGE);

		}
		
		
		//Comprobar que los dos jugadores no tienen ya una partida empezada
		for(Jugador j : lista_jugadores)
		{
			if(comboBox.getSelectedItem().equals(j.getNombre_usuario()))
			{
				id_jug1=Integer.toString(j.getId());
				
				
				// Esto no funciona porque los ID estan en String y en int.
				//Hay que homogenizarlo o poner Strings que no empiecen por 0, porque sino al 
				//hacer la conversion la hace quitandolos y el resultado pasa de ser 00001 a ser 1.
				
				//YA FUNCIONA
			}
		}
		for(Jugador j : lista_jugadores)
		{
			if(comboBox_1.getSelectedItem().equals(j.getNombre_usuario()))
			{
				id_jug2=Integer.toString(j.getId());
			}
		}
		
		
		//Comrpobar que el id1 y el id2 no son el id1 y id2 de la partida, o viceversa
		
		for(Partida p : lista_partidas)
		{
			if(((p.getId_j1().equals(id_jug1))&&((p.getId_j2().equals(id_jug2))))||((p.getId_j1().equals(id_jug2))&&((p.getId_j2().equals(id_jug1)))))
			{
				if(p.isTerminada()==false)
				{
					comprobacion_2=true;
					JOptionPane.showMessageDialog(null, "Los jugadores ya tienen una partida en curso, si desea seguir con la partida vuelva al menu principal y elija CONTINUAR PARTIDA", "Error", ERROR_MESSAGE);

				}
			}
			
			
		}
		
		
		if(comprobacion==false && comprobacion_2==false)
		{
			/**FrameTablero tablero= new FrameTablero(new Partida());
			tablero.setVisible(true);**/
			
			FrameTableroCopy tablero = new FrameTableroCopy(new Partida());
			tablero.setVisible(true);
			
			
			GestorPartidas gestorP= new GestorPartidas();
			
			String n1=(String) comboBox.getSelectedItem();
			String n2=(String)comboBox_1.getSelectedItem();
			
		System.out.println(n1 + " "+ n2);
			
			String id1=" ";
			String id2=" ";
			
			
			for(Jugador j: lista_jugadores)
			{
				if(j.getNombre_usuario().equals(n1))
				{
					
				id1=Integer.toString(j.getId());
				
				
					
				}
				if(j.getNombre_usuario().equals(n2))
				{
					id2=Integer.toString(j.getId());
				
				}
				
				System.out.println(id1+" "+ id2);
			}
			
			ArrayList<Object> lista_o= new ArrayList<Object>();
			
			
			//Conseguri aqui el siguiente ID_P
			String nuevo_idP = " ";
			int aux =0;
			int idp_int=0;
			String idp=" ";
			
			for(Partida pp : lista_partidas)
			{
				idp=pp.getId_P();
				idp_int =Integer.parseInt(idp);
				
				if(idp_int> aux)
				{
					
					aux=idp_int;
				}
				
			}
			aux=aux+1;
			
			nuevo_idP=String.valueOf(aux);
			lista_o=gestorP.CrearPartida(id1, id2,nuevo_idP);
			
			Partida p = new Partida();
			FichaDePartida fp1 = new FichaDePartida();
			FichaDePartida fp2 = new FichaDePartida();
			
			
		p=(Partida) lista_o.get(0);
		fp1=(FichaDePartida) lista_o.get(1);
		fp2=(FichaDePartida) lista_o.get(2);
		
		
		gestorS.GuardarPartida(p, fp1, fp2);
		
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
