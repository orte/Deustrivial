package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class FrameTablero extends JFrame 
{

	private JPanel contentPane;
		
			/**
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FrameTablero frame = new FrameTablero();
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
	public FrameTablero() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 683);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 7, 0, 0));
		
		JButton btnNewButton_11 = new JButton("Ocio");
		btnNewButton_11.setBackground(Color.magenta.darker());
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_28 = new JButton("Historia");
		btnNewButton_28.setBackground(Color.yellow);
		contentPane.add(btnNewButton_28);
		
		JButton btnNewButton_30 = new JButton("Ciencia");
		btnNewButton_30.setBackground(Color.green);
		contentPane.add(btnNewButton_30);
		
		JButton btnNewButton_29 = new JButton("Deportes");
		btnNewButton_29.setBackground(Color.orange);
		contentPane.add(btnNewButton_29);
		
		JButton btnNewButton_7 = new JButton("Geografia");
		btnNewButton_7.setBackground(Color.cyan.darker());
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_1 = new JButton("Geografia");
		btnNewButton_1.setBackground(Color.cyan.darker());
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setVisible(false);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ocio");
		btnNewButton_3.setBackground(Color.magenta.darker());
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setVisible(false);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ocio");
		btnNewButton_5.setBackground(Color.magenta.darker());
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_8 = new JButton("Deportes");
		btnNewButton_8.setBackground(Color.orange);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_14 = new JButton("New button");
		btnNewButton_14.setVisible(false);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_6 = new JButton("Deportes");
		btnNewButton_6.setBackground(Color.orange);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setVisible(false);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("Historia");
		btnNewButton_12.setBackground(Color.yellow);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_15 = new JButton("Ciencia");
		btnNewButton_15.setBackground(Color.green);
		contentPane.add(btnNewButton_15);
		
		JButton btnNewButton_9 = new JButton("Geografia");
		btnNewButton_9.setBackground(Color.cyan.darker());
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton = new JButton("FINISH");
		btnNewButton.setBackground(Color.pink);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_18 = new JButton("Geografia");
		btnNewButton_18.setBackground(Color.cyan.darker());
		contentPane.add(btnNewButton_18);
		
		JButton btnNewButton_21 = new JButton("Ciencia");
		btnNewButton_21.setBackground(Color.green);
		contentPane.add(btnNewButton_21);
		
		JButton btnNewButton_13 = new JButton("Historia");
		btnNewButton_13.setBackground(Color.yellow);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_16 = new JButton("New button");
		btnNewButton_16.setVisible(false);
		contentPane.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Historia");
		btnNewButton_17.setBackground(Color.yellow);
		contentPane.add(btnNewButton_17);
		
		JButton btnNewButton_24 = new JButton("New button");
		btnNewButton_24.setVisible(false);
		contentPane.add(btnNewButton_24);
		
		JButton btnNewButton_19 = new JButton("Deportes");
		btnNewButton_19.setBackground(Color.orange);
		contentPane.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("Ocio");
		btnNewButton_20.setBackground(Color.magenta.darker());
		contentPane.add(btnNewButton_20);
		
		JButton btnNewButton_22 = new JButton("New button");
		btnNewButton_22.setVisible(false);
		contentPane.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("Ocio");
		btnNewButton_23.setBackground(Color.magenta.darker());
		contentPane.add(btnNewButton_23);
		
		JButton btnNewButton_25 = new JButton("New button");
		btnNewButton_25.setVisible(false);
		contentPane.add(btnNewButton_25);
		
		JButton btnNewButton_26 = new JButton("Geografia");
		btnNewButton_26.setBackground(Color.cyan.darker());
		contentPane.add(btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("Geografia");
		btnNewButton_27.setBackground(Color.cyan.darker());
		contentPane.add(btnNewButton_27);
		
		JButton btnNewButton_31 = new JButton("Deportes");
		btnNewButton_31.setBackground(Color.orange);
		contentPane.add(btnNewButton_31);
		
		JButton btnNewButton_32 = new JButton("Ciencia");
		btnNewButton_32.setBackground(Color.green);
		contentPane.add(btnNewButton_32);
		
		JButton btnNewButton_33 = new JButton("Historia");
		btnNewButton_33.setBackground(Color.yellow);
		contentPane.add(btnNewButton_33);
		
		JButton btnNewButton_34 = new JButton("Ocio");
		btnNewButton_34.setBackground(Color.magenta.darker());
		contentPane.add(btnNewButton_34);
	}

}
