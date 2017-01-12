package LP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LN.GestorDatos;
import LN.ListaPartidasMdl;
import LN.Partida;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class FrameCargarPartida extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Partida> list;
	private JButton btnCargar;
	private GestorDatos ges = new GestorDatos();
	private JButton btnCancelar;

	
	public FrameCargarPartida() {
		if(ges.listaPartidas().isEmpty()){
			JOptionPane.showMessageDialog(this, "No hay partidas guardadas, crea una nueva");
			FrameNuevaPartida frm = new FrameNuevaPartida();
			frm.setVisible(true);
		} else{
			
		}
		setTitle("Cargar partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaPartidasMdl model = new ListaPartidasMdl(ges.listaPartidas());
		list = new JList<Partida>(model);
		list.setBounds(12, 50, 541, 315);
		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				btnCargar.setEnabled(true);
			}
			
		});
		contentPane.add(list);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(131, 403, 97, 25);
		btnCargar.setActionCommand("Cargar");
		btnCargar.setEnabled(false);
		btnCargar.addActionListener(this);
		contentPane.add(btnCargar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(318, 403, 97, 25);
		btnCancelar.setActionCommand("Cancelar");
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		this.setResizable(false);

		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("Cargar")){
			Partida cargada = list.getSelectedValue();
			FrameTablero tablero = new FrameTablero(cargada);
			tablero.setVisible(true);
			this.dispose();
		} else{
			this.dispose();
			MenuPrincipal frm = new MenuPrincipal();
			frm.setVisible(true);
		}
	}
}
