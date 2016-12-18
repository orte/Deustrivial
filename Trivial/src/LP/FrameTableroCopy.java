package LP;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom2.JDOMException;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import LN.Casilla;
import LN.Partida;
import LN.Pregunta;

/**
 * 
 * @author Josune
 *
 */

public class FrameTableroCopy extends JFrame implements ActionListener
{

	
	private static final long serialVersionUID = 1L;
	
	
	
	JPanel contentPane;
	JLabel ficha1;
	JLabel ficha2;
	JButton[][] casillas = new JButton[4][4];
	
	final String comando_Ocio="Ocio";
	final String comando_Historia="Historia";
	final String comando_Geografia="Geografia";
	final String comando_Deportes="Deportes";
	Partida partida;
	
	ArrayList<ArrayList<Pregunta>> listas;
	
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
		
		
		CreateAndShow();
		CargarDatos();
		
		
		
	}
	
	
	public void CargarDatos()
	{
		
	}
	public void CreateAndShow()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 2.0;
		c.weighty = 2.0;
		int x;
		int y=0;
		for(x = 0; x<4; x++){
			JButton aux = new JButton();
			Casilla cas = partida.getTablero().getCasillas()[x][0];
			aux.setActionCommand(x+","+0);
			aux.setEnabled(false);
			aux.addActionListener(this);
			try {
				Image icon = ImageIO.read(new File(cas.getIcono()));
				aux.setIcon(new ImageIcon(icon));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aux.setPreferredSize(new Dimension(100, 100));
			casillas[x][y] = aux;
			
			c.gridx = x;
			c.gridy = y;
			contentPane.add(casillas[x][y], c);
			
		}
		x = 3;
		for (y = 0; y<4; y++){
			JButton aux = new JButton();
			Casilla cas = partida.getTablero().getCasillas()[y][1];
			aux.setActionCommand(y+","+1);	
			aux.setEnabled(false);
			aux.addActionListener(this);
			try {
				Image icon = ImageIO.read(new File(cas.getIcono()));
				aux.setIcon(new ImageIcon(icon));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aux.setPreferredSize(new Dimension(100, 100));
			casillas[y][1] = aux;
			
			c.gridx = x+1;
			c.gridy = y;
			contentPane.add(casillas[y][1], c);
		}
		y = 3;
		for (x = 3; x>=0; x--){
			JButton aux = new JButton();
			Casilla cas = partida.getTablero().getCasillas()[x][2];
			aux.setActionCommand(x+","+2);
			aux.setEnabled(false);
			aux.addActionListener(this);
			try {
				Image icon = ImageIO.read(new File(cas.getIcono()));
				aux.setIcon(new ImageIcon(icon));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aux.setPreferredSize(new Dimension(100, 100));
			casillas[x][2] = aux;
			
			c.gridx = x+1;
			c.gridy = y+1;
			contentPane.add(casillas[x][2], c);
		}
		x = 0;
		for (y = 3; y>=0; y--){
			JButton aux = new JButton();
			Casilla cas = partida.getTablero().getCasillas()[y][3];
			aux.setActionCommand(y+","+3);
			aux.setEnabled(false);
			aux.addActionListener(this);
			try {
				Image icon = ImageIO.read(new File(cas.getIcono()));
				aux.setIcon(new ImageIcon(icon));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aux.setPreferredSize(new Dimension(100, 100));
			casillas[y][3] = aux;
			
			c.gridx = x;
			c.gridy = y+1;
			contentPane.add(casillas[y][3], c);
		}
		try {
			partida.getTablero().getCasillas()[0][0].ponerIconoFichas(2);
			Image icon = ImageIO.read(new File(partida.getTablero().getCasillas()[0][0].getIcono()));
			casillas[0][0].setIcon(new ImageIcon(icon));;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		int x = Integer.parseInt(arg0.getActionCommand().substring(0, 1));
		int y = Integer.parseInt(arg0.getActionCommand().substring(2));
		Casilla aux = partida.getTablero().getCasillas()[x][y];
		String categoria=aux.getCategoria();
		aux.ponerIconoFichas(1);
		try {
			Image icon = ImageIO.read(new File(aux.getIcono()));
			casillas[x][y].setIcon(new ImageIcon(icon));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AbrirVentanaPregunta(categoria);
			
	}

}