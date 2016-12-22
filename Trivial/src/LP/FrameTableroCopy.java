package LP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom2.JDOMException;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import LN.Casilla;
import LN.GestorPartidas;
import LN.Partida;

public class FrameTableroCopy extends JFrame implements ActionListener
{

private static final long serialVersionUID = 1L;
	
	
	
	private JPanel contentPane;
	private JButton[][] casillas = new JButton[4][4];
	private JButton botonDado;
	private JLabel labelDado;
	private Partida partida;
	private GestorPartidas ges = new GestorPartidas();
	
	
			/**
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FrameTableroCopy frame = new FrameTableroCopy(new Partida());
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
	public FrameTableroCopy(Partida partida) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 683);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		this.partida = partida;
		
		CargarDatos();
		CreateAndShow();
		
		
		
		
	}
	
	
	public void CargarDatos()
	{
		for(int x = 0; x<4; x++){
			for(int y = 0; y<4; y++){
				JButton aux = new JButton();
				Casilla cas = partida.getTablero().getCasillas()[x][y];
				aux.setActionCommand(x+","+y);
				aux.addActionListener(this);
				aux.setEnabled(false);
				try {
					Image icon = ImageIO.read(new File(cas.getIcono()));
					aux.setIcon(new ImageIcon(icon));
					aux.setDisabledIcon(new ImageIcon(icon));
					//aux.setEnabled(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aux.setPreferredSize(new Dimension(100, 100));
				casillas[x][y] = aux;
			}
		}
	}
	public void CreateAndShow()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 2.0;
		c.weighty = 2.0;
		int gridX = 0;
		int gridY = 0;
		int x = 0;
		int y =0;
		for(y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			contentPane.add(casillas[x][y], c);
			gridX++;
		}
		x++;
		gridX = 4;
		for (y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			contentPane.add(casillas[x][y], c);
			gridY++;
		}
		x++;
		gridY = 4;
		for (y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			contentPane.add(casillas[x][y], c);
			gridX--;
		}
		x++;
		gridX = 0;
		for (y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			contentPane.add(casillas[x][y], c);
			gridY--;
		}
		try {
			partida.getTablero().getCasillas()[0][0].ponerIconoFichas(2);
			Image icon = ImageIO.read(new File(partida.getTablero().getCasillas()[0][0].getIcono()));
			casillas[0][0].setIcon(new ImageIcon(icon));;
			casillas[0][0].setDisabledIcon((new ImageIcon(icon)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		botonDado = new JButton("Tirar dado");
		botonDado.setActionCommand("dado");
		botonDado.addActionListener(this);
		c.gridx = 2;
		c.gridy = 2;
		contentPane.add(botonDado, c);
		
		labelDado = new JLabel();
		try {
			Image icon = ImageIO.read(new File("img/dado1.jpg"));
			labelDado.setIcon(new ImageIcon(icon));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.gridx = 2;
		c.gridy = 1;
		contentPane.add(labelDado, c);
				
		
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
		if(arg0.getActionCommand().equals("dado")){
			partida.tirarDado();
			int dado = partida.getDado();
			String ruta = ges.rutaDado(dado);
			try {
				Image icon = ImageIO.read(new File(ruta));
				labelDado.setIcon(new ImageIcon(icon));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			botonDado.setEnabled(false);
			int posX ;
			int posY;
			if(partida.isTurno() == 1){
				posX = partida.getTablero().getPos_x_jug1();
				posY = partida.getTablero().getPos_y_jug1();
			} else{
				posX = partida.getTablero().getPos_x_jug2();
				posY = partida.getTablero().getPos_y_jug2();
			}
			int [] nuevaPosicion1 = ges.nuevaPosicion(posX, posY, dado);
			int [] nuevaPosicion2 = ges.nuevaPosicion(posX, posY, -dado);
			casillas[nuevaPosicion1[0]][nuevaPosicion1[1]].setEnabled(true);
			casillas[nuevaPosicion2[0]][nuevaPosicion2[1]].setEnabled(true);
			
		} else{
		
			Casilla cas;
			int x = Integer.parseInt(arg0.getActionCommand().substring(0, 1));
			int y = Integer.parseInt(arg0.getActionCommand().substring(2));
			cas = partida.getTablero().getCasillas()[x][y];
			AbrirVentanaPregunta(cas.getCategoria());
		}
			
	}

}
