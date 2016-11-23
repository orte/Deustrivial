package LP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmTablero extends JFrame implements MouseListener
{
	
	private JPanel panelPrincipal;
    static GridLayout experimentLayout = new GridLayout(6,0);
    private static JLabel ficha;

    static JLabel label00 = new JLabel("label00");
    static JLabel label10 = new JLabel("label10");
    static JLabel label20 = new JLabel("label20");
    static JLabel label30 = new JLabel("label30");
    static JLabel label40 = new JLabel("label40");
    static JLabel label50 = new JLabel("label50");
    static JLabel label01 = new JLabel("label01");
    static JLabel label11 = new JLabel("label11");
    static JLabel label21 = new JLabel("label21");
    static JLabel label31 = new JLabel("label31");
    static JLabel label41 = new JLabel("label41");
    static JLabel label51 = new JLabel("label51");
    static JLabel label02 = new JLabel("label02");
    static JLabel label12 = new JLabel("label12");
    static JLabel label22 = new JLabel("label22");
    static JLabel label32 = new JLabel("label32");
    static JLabel label42 = new JLabel("label42");
    static JLabel label52 = new JLabel("label52");
    static JLabel label03 = new JLabel("label03");
    static JLabel label13 = new JLabel("label13");
    static JLabel label23 = new JLabel("label23");
    static JLabel label33 = new JLabel("label33");
    static JLabel label43 = new JLabel("label43");
    static JLabel label53 = new JLabel("label53");
    static JLabel label04 = new JLabel("label04");
    static JLabel label14 = new JLabel("label14");
    static JLabel label24 = new JLabel("label24");
    static JLabel label34 = new JLabel("label34");
    static JLabel label44 = new JLabel("label44");
    static JLabel label54 = new JLabel("label54");
    static JLabel label05 = new JLabel("label05");
    static JLabel label15 = new JLabel("label15");
    static JLabel label25 = new JLabel("label25");
    static JLabel label35 = new JLabel("label35");
    static JLabel label45 = new JLabel("label45");
    static JLabel FIN = new JLabel("FIN");
    
    public frmTablero() 
    {
    	super();
	}
	
	public static void createAndShowGUI()
	{
		
		
	
		frmTablero frame = new frmTablero();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.compsToPane(frame.getContentPane());
		frame.setVisible(true);
		frame.pack();
		
		
		
		
	}
	
	public static void añadirFicha(JLabel labelFondo)
	{
		
		
	}
	
	public static void compsToPane(Container pane)
	{
		
		final JPanel panelComp = new JPanel();
		panelComp.setLayout(experimentLayout);
		panelComp.add(label00);
		panelComp.add(label01);
		panelComp.add(label02);
		panelComp.add(label03);
		panelComp.add(label04);
		panelComp.add(label05);
		panelComp.add(label10);
		panelComp.add(label11);
		panelComp.add(label12);
		panelComp.add(label13);
		panelComp.add(label14);
		panelComp.add(label15);
		panelComp.add(label20);
		panelComp.add(label21);
		panelComp.add(label22);
		panelComp.add(label23);
		panelComp.add(label24);
		panelComp.add(label25);
		panelComp.add(label30);
		panelComp.add(label31);
		panelComp.add(label32);
		panelComp.add(label33);
		panelComp.add(label34);
		panelComp.add(label35);
		panelComp.add(label40);
		panelComp.add(label41);
		panelComp.add(label42);
		panelComp.add(label43);
		panelComp.add(label44);
		panelComp.add(label45);
		panelComp.add(label50);
		panelComp.add(label51);
		panelComp.add(label52);
		panelComp.add(label53);
		panelComp.add(label54);
		panelComp.add(FIN);
		
		
		
		label00.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	

		    }  
		}); 
	
		label01.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		  
		    System.out.println("hola");
		    }  
		}); 
		
		pane.add(panelComp, BorderLayout.CENTER);
		

	
		
	
	}
	public static void main(String [] args)
	{
		
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });	    }



@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}
