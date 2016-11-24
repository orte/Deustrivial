package LP;




import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



	
public class menuPrincipal extends JFrame
{
	
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	backgroundPanel pBackground;
	JPanel pBotonera;
	String imagePath = "src\\img\\menuP.jpg";
	
	public menuPrincipal()
	{
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

	
		pBackground = new backgroundPanel();
		
//		JButton bNuevaPartida = new JButton( "Nueva partida" );
//		JButton bCargarPartida = new JButton( "Cargar partida" );
//		JButton bEstadisticas = new JButton( "Estadisticas" );
//		JButton bInstrucciones = new JButton( "Instrucciones" );
//		JButton bSalir = new JButton( "" );

		

		
		pBackground.setLayout(null);
	
		pBackground.setBackground(imagePath);
		
		add( pBackground , BorderLayout.CENTER );
		
		setSize( 800, 500 );
		
	}


 public static void main(String [] args)
 {
	 menuPrincipal menu = new menuPrincipal();
	 menu.setVisible(true);
 }

}

class backgroundPanel extends JPanel 
{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Image background;

		JButton bNuevaPartida = new JButton( "Nueva partida" );
		JButton bCargarPartida = new JButton( "Cargar partida" );
		JButton bEstadisticas = new JButton( "Estadisticas" );
		JButton bInstrucciones = new JButton( "Instrucciones" );
		JButton bSalir = new JButton( "" );
		

		
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


