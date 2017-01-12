package LP;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import LN.Casilla;
import LN.GestorDatos;
import LN.Partida;
import LN.Pregunta;
import LN.Respuesta;
import LN.Tablero;

public class FrameTablero extends JFrame implements ActionListener, InternalFrameListener
{

private static final long serialVersionUID = 1L;
	
	
	private JPanel tableroPane;
	private JPanel contentPane;
	private JButton[][] casillas = new JButton[4][4];
	private JButton botonDado;
	private JButton btnGuardar;
	private JLabel labelTurno;
	private JLabel labelDado;
	private JLabel labelNombre1;
	private JLabel labelNombre2;
	private JLabel labelPunt1;
	private JLabel labelPunt2;
	private Partida partida;
	private Tablero tablero;
	private boolean acertada;
	private GestorDatos gesDat = new GestorDatos();
	private String jug1;
	private String jug2;
	private ArrayList<Respuesta> respuestas;
	private Pregunta preg;
	
	public FrameTablero(Partida partida) {
		setTitle("Deusto Trivial");
		respuestas = new ArrayList<Respuesta>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1583, 883);
		jug1 = gesDat.obtenerJugador(partida.getId_j1()).getNombre_usuario();
		jug2 = gesDat.obtenerJugador(partida.getId_j2()).getNombre_usuario();
		contentPane = new JPanel();
		tableroPane = new JPanel();
		contentPane.setLayout(null);
		tableroPane.setBackground(new Color(255, 255, 255));
		tableroPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tableroPane.setBounds(100, 100, 600, 600);
		setContentPane(contentPane);
		tableroPane.setLayout(new GridBagLayout());
		contentPane.add(tableroPane);
		this.partida = partida;
		tablero = partida.getTablero();
		btnGuardar = new JButton("Guardar y salir");
		btnGuardar.setActionCommand("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(340, 50, 120, 30);
		contentPane.add(btnGuardar);
		this.setResizable(false);

		CargarDatos();
		CreateAndShow();	
	}
	
	public void CargarDatos(){
		for(int x = 0; x<4; x++){
			for(int y = 0; y<4; y++){
				JButton aux = new JButton();
				
				Casilla cas = tablero.getCasillas()[x][y];
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
	public void CreateAndShow(){
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
			tableroPane.add(casillas[x][y], c);
			gridX++;
		}
		x++;
		gridX = 4;
		for (y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			tableroPane.add(casillas[x][y], c);
			gridY++;
		}
		x++;
		gridY = 4;
		for (y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			tableroPane.add(casillas[x][y], c);
			gridX--;
		}
		x++;
		gridX = 0;
		for (y = 0; y<4; y++){
			c.gridx = gridX;
			c.gridy = gridY;
			tableroPane.add(casillas[x][y], c);
			gridY--;
		}
		
		labelNombre1 = new JLabel(jug1);
		c.gridx = 1;
		c.gridy = 2;
		tableroPane.add(labelNombre1, c);
		
		labelNombre2 = new JLabel(jug2);
		c.gridx = 3;
		c.gridy = 2;
		tableroPane.add(labelNombre2, c);
		
		labelPunt1 = new JLabel("Puntuación: "+partida.getPuntJug1());
		c.gridx = 1;
		c.gridy = 3;
		tableroPane.add(labelPunt1, c);
		
		labelPunt2 = new JLabel("Puntuación: "+partida.getPuntJug2());
		c.gridx = 3;
		c.gridy = 3;
		tableroPane.add(labelPunt2, c);
		
		labelTurno = new JLabel();
		if(partida.isTurno()){
			labelTurno.setText("Es el turno de "+jug1);
		} else{
			labelTurno.setText("Es el turno de "+jug2);
		}
		c.gridx = 2;
		c.gridy = 3;
		tableroPane.add(labelTurno, c);
		
		botonDado = new JButton("Tirar dado");
		botonDado.setActionCommand("dado");
		botonDado.addActionListener(this);
		c.gridx = 2;
		c.gridy = 2;
		tableroPane.add(botonDado, c);
		
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
		tableroPane.add(labelDado, c);
				
		
	}
	
	public void abrirVentanaPregunta(String c){
		
		preg = gesDat.obtenerPregunta(c); 
		InternalFrmPregunta pantalla = new InternalFrmPregunta(preg, this);
		pantalla.setVisible(true);
		pantalla.addInternalFrameListener(this);
		pantalla.setBounds(800, 100, 600, 700);
		pantalla.setSize(new Dimension(600, 700));
		try {
			pantalla.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(pantalla);
		
	}
	public void tirarDado(){
		partida.tirarDado();
		int dado = partida.getDado();
		String ruta = partida.rutaDado();
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
		if(partida.isTurno() == true){
			posX = partida.getPosx_jug1();
			posY = partida.getPosy_jug1();
		} else{
			posX = partida.getPosx_jug2();
			posY = partida.getPosy_jug2();
		}
		int [] nuevaPosicion1 = partida.nuevaPosicion(posX, posY, dado);
		int [] nuevaPosicion2 = partida.nuevaPosicion(posX, posY, -dado);
		casillas[nuevaPosicion1[0]][nuevaPosicion1[1]].setEnabled(true);
		casillas[nuevaPosicion2[0]][nuevaPosicion2[1]].setEnabled(true);
	}
	public void guardar(){
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro que quieres guardar la partida y salir?");
		if(opcion == 0){
			gesDat.guardarPartida(partida);
			this.dispose();
		}
		gesDat.guardarRespuestas(respuestas);
		int [] id_jugs = {partida.getId_j1(), partida.getId_j2()};
		gesDat.actualizarEstadisticas(id_jugs);
	}
	public void moverFicha(ActionEvent arg0){
		btnGuardar.setEnabled(false);
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4; j++){
				casillas[i][j].setEnabled(false);
			}
		}
		Casilla cas;
		int x = Integer.parseInt(arg0.getActionCommand().substring(0, 1));
		int y = Integer.parseInt(arg0.getActionCommand().substring(2));
		cas = tablero.getCasillas()[x][y];
		int xAnt;
		int yAnt;
		if(partida.isTurno()){
			xAnt = partida.getPosx_jug1();
			yAnt = partida.getPosy_jug1();
		} else{
			xAnt = partida.getPosx_jug2();
			yAnt = partida.getPosy_jug2();
		}
		Casilla anterior = tablero.getCasillas()[xAnt][yAnt];
		if(anterior.isHayDos()){
			if(partida.isTurno() == true){
				anterior.ponerIconoFichas(1);
			} else{
				anterior.ponerIconoFichas(0);
			}
			anterior.setHayDos(false);
		} else{
			anterior.ponerIconoFichas(3);
			anterior.setOcupada(false);
		}
		try {
			Image icon = ImageIO.read(new File(anterior.getIcono()));
			casillas[xAnt][yAnt].setIcon(new ImageIcon(icon));
			casillas[xAnt][yAnt].setDisabledIcon(new ImageIcon(icon));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cas.isOcupada()){
			cas.ponerIconoFichas(2);
			cas.setHayDos(true);
		}else {
			if(partida.isTurno() == true){
				cas.ponerIconoFichas(0);
			}else {
				cas.ponerIconoFichas(1);
			}
		}
		cas.setOcupada(true);
		partida.mover(x, y);
		try {
			Image icon = ImageIO.read(new File(cas.getIcono()));
			casillas[x][y].setIcon(new ImageIcon(icon));
			casillas[x][y].setDisabledIcon(new ImageIcon(icon));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		casillas[x][y].setEnabled(false);
		abrirVentanaPregunta(cas.getCategoria());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("dado")){
			tirarDado();
			
		} 
		else if(arg0.getActionCommand().equals("Guardar")){
			guardar();
		}
		else{
			moverFicha(arg0);
		}
			
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		int id_respuesta;
		int punt;
		String jug;
		this.setEnabled(true);
		botonDado.setEnabled(true);
		btnGuardar.setEnabled(true);
		if(this.acertada){
			if(partida.isTurno()){
				partida.preguntaAcertada(1);
				id_respuesta = partida.getId_j1();
				punt = partida.getPuntJug1();
				jug = jug1;
				labelPunt1.setText("Puntuación: "+punt);
				labelPunt1.repaint();
			} else{
				partida.preguntaAcertada(2);
				id_respuesta = partida.getId_j2();
				punt = partida.getPuntJug2();
				jug = jug2;
				labelPunt2.setText("Puntuación: "+punt);
				labelPunt2.repaint();
			}
			if(punt == 10){
				JOptionPane.showMessageDialog(this, "Enhorabuena! "+jug+" ha ganado la partida");
				int id_perdedor;
				int id_ganador;
				if(partida.isTurno()){
					id_ganador = partida.getId_j1();
					id_perdedor = partida.getId_j2();
				} else{
					id_ganador = partida.getId_j2();
					id_perdedor = partida.getId_j1();
				}
				gesDat.partidaTerminada(id_ganador, true);
				gesDat.partidaTerminada(id_perdedor, false);
				gesDat.guardarRespuestas(respuestas);
				int [] id_jugs = {partida.getId_j1(), partida.getId_j2()};
				gesDat.actualizarEstadisticas(id_jugs);
				gesDat.borrarPartida(partida);
				this.dispose();
			}
			this.getContentPane().revalidate();
		} else{
			String leToca = "";
			if(partida.isTurno()){
				id_respuesta = partida.getId_j1();
				leToca = jug2;
			} else{
				id_respuesta = partida.getId_j2();
				leToca = jug1; 
			}
			labelTurno.setText("Es el turno de "+leToca);
			labelTurno.repaint();
			partida.setTurno(!partida.getTurno());
		}
		Respuesta respuesta = new Respuesta(preg.getId_pregunta(), id_respuesta, acertada);
		respuestas.add(respuesta);
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		botonDado.setEnabled(true);
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
	}

	public boolean isAcertada() {
		return acertada;
	}

	public void setAcertada(boolean acertada) {
		this.acertada = acertada;
	}

}
