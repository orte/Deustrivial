package LP;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import LN.GestorDatos;

import java.awt.Font;
import javax.swing.JButton;



	
public class MenuPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private BackgroundPanel pBackground;
	private String imagePath = "img/menuP.jpg";
	
	private final String comando_NP= "nuevaPartida";
	private final String comando_CP="cargarPartida";
	private final String comando_VE="verEstadisticas";
	
	private JButton btnNuevaPartida;
	private JLabel lblDeustotrivial;
	private JButton btnCargarPartida;
	private JButton btnEstadsticas;
	
	public MenuPrincipal(){
		setTitle("Deusto Trivial");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pBackground = new BackgroundPanel();
		pBackground.setBackground(imagePath);
		getContentPane().add( pBackground , BorderLayout.CENTER );
		pBackground.setLayout(null);
		
		btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.setBounds(311, 162, 151, 52);
		btnNuevaPartida.setActionCommand(comando_NP);
		btnNuevaPartida.addActionListener(this);
		pBackground.add(btnNuevaPartida);
		
		lblDeustotrivial = new JLabel("DEUSTOTRIVIAL");
		lblDeustotrivial.setForeground(Color.blue);
		lblDeustotrivial.setBounds(326, 13, 123, 21);
		lblDeustotrivial.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblDeustotrivial.setHorizontalAlignment(SwingConstants.CENTER);
		pBackground.add(lblDeustotrivial);
		
		btnCargarPartida = new JButton("Cargar Partida");
		btnCargarPartida.setActionCommand(comando_CP);
		btnCargarPartida.addActionListener(this);
		btnCargarPartida.setBounds(311, 224, 151, 52);
		pBackground.add(btnCargarPartida);
		
		btnEstadsticas = new JButton("Estad\u00EDsticas");
		btnEstadsticas.setBounds(311, 289, 151, 52);
		btnEstadsticas.setActionCommand(comando_VE);
		btnEstadsticas.addActionListener(this);
		pBackground.add(btnEstadsticas);
		this.setResizable(false);
		setSize( 800, 500 );
		
	}
	public static void main(String[]args){
		MenuPrincipal men = new MenuPrincipal();
		men.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String evento= arg0.getActionCommand();
		switch(evento){
		case comando_NP: nuevaPartida() ;break;
		case comando_CP: cargarPartida(); break;
		case comando_VE: estadisticas(); break;
		}
	}
	public void nuevaPartida(){
		FrameNuevaPartida frm = new FrameNuevaPartida();
		frm.setVisible(true);
		this.dispose();
	}
	public void cargarPartida(){
		GestorDatos ges = new GestorDatos();
		if(ges.listaPartidas().isEmpty()){
			JOptionPane.showMessageDialog(this, "No hay partidas guardadas, crea una nueva");
			FrameNuevaPartida frm = new FrameNuevaPartida();
			frm.setVisible(true);
			this.dispose();
		} else{
			FrameCargarPartida frm = new FrameCargarPartida();
			frm.setVisible(true);
			this.dispose();
		}
	}
	public void estadisticas(){
		FrameEstadisticas frm = new FrameEstadisticas();
		frm.setVisible(true);
		this.dispose();
	}
	
}

