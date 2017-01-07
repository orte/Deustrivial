package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import LN.GestorDatos;
import main.DuplicadoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;

public class FrameNuevoJugador extends JFrame implements ActionListener, DocumentListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	private GestorDatos gesDat = new GestorDatos();

	public FrameNuevoJugador() 
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
		textField.getDocument().addDocumentListener(this);
		contentPane.add(textField);
	
		
		lblNewLabel = new JLabel("NUEVO JUGADOR");
		lblNewLabel.setBounds(147, 66, 168, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setBounds(140, 186, 115, 29);
		btnNewButton.setActionCommand("Aceptar");
		btnNewButton.addActionListener(this);
		btnNewButton.setEnabled(false);
		contentPane.add(btnNewButton);		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) 	{
		String nombre = textField.getText();
		try {
			gesDat.nuevoJugador(nombre);
			JOptionPane.showMessageDialog(this, "Se ha dado de alta a "+nombre);
			this.dispose();
			FrameNuevaPartida frm = new FrameNuevaPartida();
			frm.setVisible(true);
		} catch (DuplicadoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		btnNewButton.setEnabled(true);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if(textField.getText().equals("")){
			btnNewButton.setEnabled(false);
		}
	}
}
