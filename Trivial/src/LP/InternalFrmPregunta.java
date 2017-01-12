package LP;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import LN.Pregunta;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InternalFrmPregunta extends JInternalFrame implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	private InternalFrmPregunta frame = this;
	private FrameTablero parent;
	private JButton[] listaBotones = new JButton[4];
	private JTextArea textArea;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton;
	private int temporizador;
	private Thread t = null;
	private JTextField tempoField;
	private Pregunta preg;
	private boolean running;
	
	
	public InternalFrmPregunta(Pregunta pregunta, final FrameTablero parent) {
		running = true;
		temporizador = 30;
		getContentPane().setLayout(null);
		this.parent = parent;
		preg = pregunta;
		
		textArea = new JTextArea();
		textArea.setBounds(79, 52, 470, 132);
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setText(preg.getPregunta());
		textArea.setLineWrap(true);
		getContentPane().add(textArea);
		
		panel = new JPanel();
		panel.setBounds(79, 215, 470, 252);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNewButton_1 = new JButton("New button");
		listaBotones[0] = btnNewButton_1;
		
		btnNewButton_2 = new JButton("New button");
		listaBotones[1] = btnNewButton_2;
		
		btnNewButton_3 = new JButton("New button");
		listaBotones[2] = btnNewButton_3;
		
		btnNewButton = new JButton("New button");
		listaBotones[3] = btnNewButton;
		this.setResizable(false);

		
		for(int i = 0; i<listaBotones.length; i++){
			listaBotones[i].setText(preg.getRespuestas().get(i));
			listaBotones[i].setActionCommand("boton"+i);
			listaBotones[i].addActionListener(this);
		}
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_2);
		panel.add(btnNewButton_3);
		panel.add(btnNewButton);
		
		tempoField = new JTextField();
		tempoField.setBackground(new Color(255, 255, 224));
		tempoField.setFont(new Font("Arial", Font.BOLD, 21));
		tempoField.setBounds(40, 1, 89, 28);
		tempoField.setEditable(false);
		tempoField.setText(new Integer(temporizador).toString());
		tempoField.setColumns(10);
		getContentPane().add(tempoField);
		Runnable r = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				running = true;
				try {
					while(temporizador>0 && running){
						temporizador--;
						Thread.sleep(1000);
						tempoField.setText(new Integer(temporizador).toString());
						tempoField.repaint();
						getContentPane().revalidate();
						if(temporizador == 0){
							JOptionPane.showMessageDialog(frame, "Se ha acabado el tiempo!");
							frame.dispose();
							parent.setAcertada(false);
						}
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} 
		 };
		 t = new Thread(r);
		 t.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		running = false;
		int indice = Integer.parseInt(arg0.getActionCommand().substring(arg0.getActionCommand().length()-1));
		if(indice == preg.getCorrecta()){
			listaBotones[indice].setBackground(Color.green);
			JOptionPane.showMessageDialog(this, "Respuesta correcta!");
			parent.setAcertada(true);
			this.dispose();
		} else{
			listaBotones[indice].setBackground(Color.red);
			listaBotones[preg.getCorrecta()].setBackground(Color.green);
			JOptionPane.showMessageDialog(this, "Respuesta incorrecta...");
			parent.setAcertada(false);
			this.dispose();
		}
	}
}
