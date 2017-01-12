package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LN.GestorDatos;
import LN.Jugador;
import LN.ListaJugadoresMdl;
import LN.Partida;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class FrameNuevaPartida extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Jugador>list;
	private JList<Jugador> list_1;
	private JButton btnAgregar;
	private JButton btnNuevoJugador;
	private JButton btnEmpezar;
	private JButton btnEliminar;
	private JLabel lblEligeLosJugadores;
	private JLabel lblParticipantes;
	private JLabel lblJug;
	private JLabel lblJug_1;
	
	private GestorDatos gesDat = new GestorDatos();
	private JButton btnSalir;
	
	public FrameNuevaPartida() {
		setTitle("Nueva Partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaJugadoresMdl model = new ListaJugadoresMdl(gesDat.listaJugadores());
		list = new JList<Jugador>(model);
		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				btnAgregar.setEnabled(true);
			}
		});
		list.setBounds(52, 102, 204, 234);
		contentPane.add(list);
		
		ListaJugadoresMdl model1 = new ListaJugadoresMdl();
		list_1 = new JList<Jugador>(model1);
		list_1.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(list_1.isSelectionEmpty()==false){
					btnEliminar.setEnabled(true);
				} 
			}
		});
		list_1.setBounds(389, 173, 204, 117);
		contentPane.add(list_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.setActionCommand(btnAgregar.getText());
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(29, 349, 97, 25);
		contentPane.add(btnAgregar);
		
		btnNuevoJugador = new JButton("Nuevo Jugador");
		btnNuevoJugador.setActionCommand(btnNuevoJugador.getText());
		btnNuevoJugador.addActionListener(this);
		btnNuevoJugador.setBounds(159, 349, 130, 25);
		contentPane.add(btnNuevoJugador);
		
		btnEmpezar = new JButton("Empezar");
		btnEmpezar.setEnabled(false);
		btnEmpezar.setActionCommand(btnEmpezar.getText());
		btnEmpezar.addActionListener(this);
		btnEmpezar.setBounds(389, 303, 97, 25);
		contentPane.add(btnEmpezar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setActionCommand(btnEliminar.getText());
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(498, 303, 97, 25);
		contentPane.add(btnEliminar);
		
		lblEligeLosJugadores = new JLabel("Elige los dos jugadores que tomar\u00E1n parte");
		lblEligeLosJugadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEligeLosJugadores.setBounds(29, 64, 281, 25);
		contentPane.add(lblEligeLosJugadores);
		
		lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParticipantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipantes.setBounds(442, 144, 97, 16);
		contentPane.add(lblParticipantes);
		
		lblJug = new JLabel("Jug. 1");
		lblJug.setBounds(332, 174, 56, 16);
		contentPane.add(lblJug);
		
		lblJug_1 = new JLabel("Jug. 2");
		lblJug_1.setBounds(332, 204, 56, 16);
		contentPane.add(lblJug_1);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(284, 425, 97, 25);
		btnSalir.setActionCommand("Salir");
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		this.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getActionCommand()){
		case "Agregar": agregar(); break;
		case "Nuevo Jugador": nuevo(); break;
		case "Empezar": empezar(); break;
		case "Eliminar": eliminar(); break;
		case "Salir": salir();
		}
	}
	public void salir(){
		this.dispose();
		MenuPrincipal frm = new MenuPrincipal();
		frm.setVisible(true);
	}
	public void agregar(){
		
		ListaJugadoresMdl nuevo = (ListaJugadoresMdl) list_1.getModel();
		Jugador agregado = (Jugador) list.getSelectedValue();
		nuevo.addElement(agregado);
		((ListaJugadoresMdl) list.getModel()).removeElement(list.getSelectedIndex());
		
		if(((ListaJugadoresMdl) list_1.getModel()).getSize()==2){
			btnEmpezar.setEnabled(true);
			btnAgregar.setEnabled(false);
		} else if(((ListaJugadoresMdl) list_1.getModel()).getSize()<2){
			btnEmpezar.setEnabled(false);
		}
	}
	public void eliminar(){
		ListaJugadoresMdl nuevo = (ListaJugadoresMdl) list.getModel();
		Jugador eliminado = (Jugador) list_1.getSelectedValue();
		nuevo.addElement(eliminado);
		((ListaJugadoresMdl) list_1.getModel()).removeElement(list_1.getSelectedIndex());
		if(((ListaJugadoresMdl) list_1.getModel()).isEmpty()){
			btnEliminar.setEnabled(false);
		}
		if(((ListaJugadoresMdl) list_1.getModel()).getSize()<2){
			btnEmpezar.setEnabled(false);
		}
		btnAgregar.setEnabled(true);
	}
	public void nuevo(){
		FrameNuevoJugador ventana = new FrameNuevoJugador();
		ventana.setVisible(true);
		this.dispose();
	}
	public void empezar(){
		list_1.setSelectedIndex(0);
		Jugador jug1 = list_1.getSelectedValue();
		list_1.setSelectedIndex(1);
		Jugador jug2 = list_1.getSelectedValue();
		Partida nueva = gesDat.nuevaPartida(jug1, jug2);
		FrameTablero tablero = new FrameTablero(nueva);
		tablero.setVisible(true);
		this.dispose();
	}


}

