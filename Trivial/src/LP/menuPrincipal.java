package LP;




import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



	
public class menuPrincipal extends JFrame implements ActionListener
{
	
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	backgroundPanel pBackground;
	JPanel pBotonera;
	String imagePath = "img/menuP.jpg";
	
	JMenuBar menuBar;
	JMenu mnPartidas ;
	JMenuItem mntmEmpezarNueva;
	JMenuItem mntmNewMenuItem;
	JMenuItem mntmPartidasEnCurso;
	JMenu mnJugadores ;
	JMenuItem mntmCrearNuevo;
	JMenuItem mntmVerEstadisticasd ;
	JMenuItem mntmVerFichasDe;
	JMenu mnPreguntas;
	JMenuItem mntmAadirPregunta;
	
	final String comando_NP= "nuevaPartida";
	final String comando_CP="continuarPartida";
	final String comando_MP="mostrarPartida";
	final String comando_NJ="nuevoJugador";
	final String comando_VE="verEstadisticas";
	final String comando_FP="verFichas";
	final String comando_P="nuevaP";
	
	
	
	
	public menuPrincipal()
	{
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

	
		pBackground = new backgroundPanel();
	
		pBackground.setLayout(null);
	
		pBackground.setBackground(imagePath);
		
		getContentPane().add( pBackground , BorderLayout.CENTER );
		
		menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		mnPartidas = new JMenu("PARTIDAS");
		menuBar.add(mnPartidas);
		
		mntmEmpezarNueva = new JMenuItem("EMPEZAR NUEVA");
		mntmEmpezarNueva.addActionListener(this);
		mntmEmpezarNueva.setActionCommand(comando_NP);
		mnPartidas.add(mntmEmpezarNueva);
		
		mntmNewMenuItem = new JMenuItem("CONTINUAR PARTIDA");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setActionCommand(comando_CP);
		mnPartidas.add(mntmNewMenuItem);
		
		mntmPartidasEnCurso = new JMenuItem("PARTIDAS EN CURSO");
		mntmPartidasEnCurso.addActionListener(this);
		mntmPartidasEnCurso.setActionCommand(comando_MP);
		mnPartidas.add(mntmPartidasEnCurso);
		
		mnJugadores = new JMenu("JUGADORES");
		menuBar.add(mnJugadores);
		
		mntmCrearNuevo = new JMenuItem("CREAR NUEVO");
		mntmCrearNuevo.addActionListener(this);
		mntmCrearNuevo.setActionCommand(comando_NJ);
		mnJugadores.add(mntmCrearNuevo);
		
		mntmVerEstadisticasd = new JMenuItem("VER ESTADISTICAS");
		mntmVerEstadisticasd.addActionListener(this);
		mntmVerEstadisticasd.setActionCommand(comando_VE);
		mnJugadores.add(mntmVerEstadisticasd);
		
		mntmVerFichasDe = new JMenuItem("VER FICHAS DE PARTIDA");
		mntmVerFichasDe.addActionListener(this);
		mntmVerFichasDe.setActionCommand(comando_FP);
		mnJugadores.add(mntmVerFichasDe);
		
		mnPreguntas = new JMenu("PREGUNTAS");
		menuBar.add(mnPreguntas);
		
		mntmAadirPregunta = new JMenuItem("A\u00D1ADIR PREGUNTA");
		mntmAadirPregunta.addActionListener(this);
		mntmAadirPregunta.setActionCommand(comando_P);
		mnPreguntas.add(mntmAadirPregunta);
		
		setSize( 800, 500 );
		
	}


 public static void main(String [] args)
 {
	 menuPrincipal menu = new menuPrincipal();
	 menu.setVisible(true);
 }
 
 public static void VentanaNJ ()
 {
	 
	 frmNuevoJ ventanaNJ= new frmNuevoJ();
	 ventanaNJ.setVisible(true);
 }
 
 public static void VentanaNP()
 {
	 frmEmpezarPartida ventanaNP = new frmEmpezarPartida();
	 ventanaNP.setVisible(true);
 }


@Override
public void actionPerformed(ActionEvent arg0) 
{
	// TODO Auto-generated method stub
	
	String evento= arg0.getActionCommand();
	
	switch(evento)
	{
	case comando_NP:VentanaNP();break;
	case comando_CP:;
	case comando_MP:;
	case comando_NJ:VentanaNJ();break;
	case comando_VE:;
	case comando_FP:;
	case comando_P:;
	}
	
}
 
 
 
 
}







class backgroundPanel extends JPanel 
{

	
	private static final long serialVersionUID = 1L;
		private Image background;


		
		public backgroundPanel()
		{

		}
		
		
		
		public void paintComponent(Graphics g) {

			
			int width = this.getSize().width;
			int height = this.getSize().height;

			if (this.background != null) {
				g.drawImage(this.background, 0, 0, width, height, null);
			}

			super.paintComponent(g);
		}

		public void setBackground(String imagePath) {
			
			this.setOpaque(false);
			this.background = new ImageIcon(imagePath).getImage();
			repaint();
		}
		
}


