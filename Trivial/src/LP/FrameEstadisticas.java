package LP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import LN.Estadisticas;
import LN.GestorDatos;

public class FrameEstadisticas extends JFrame implements ActionListener { static final long serialVersionUID = 1L;
	private Map<Integer, Estadisticas> stats;
	private JTable table;
	private JButton btnOrden;
	private boolean modo=false;

	public FrameEstadisticas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Estadisticas de los jugadores");
		getContentPane().setLayout(null);
		
		GestorDatos ges=new GestorDatos();
		stats=ges.mapaVictorias();
		TablaEstadisticasMdl model=new TablaEstadisticasMdl(stats);
		table = new JTable(model.data, model.columnNames);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(false);
		model.fireTableDataChanged();
		JScrollPane scrl=new JScrollPane(table);
		scrl.setBounds(20, 11, 624, 351);
		table.setVisible(true);
		getContentPane().add(scrl);
		
		btnOrden = new JButton("Ranking de aciertos");
		btnOrden.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOrden.setBounds(214, 373, 200, 23);
		btnOrden.addActionListener(this);
		getContentPane().add(btnOrden);
		this.setSize(667, 433);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GestorDatos ges = new GestorDatos();
		if(modo == false){
			stats = ges.mapaAciertos();
			modo = true;
			btnOrden.setText("Ranking de victorias");
			btnOrden.repaint();
			this.getContentPane().revalidate();
		} else{
			stats = ges.mapaVictorias();
			modo = false;
			btnOrden.setText("Ranking de aciertos");
			btnOrden.repaint();
			this.getContentPane().revalidate();
		}
		TablaEstadisticasMdl model = new TablaEstadisticasMdl(stats);
		table=new JTable(model.data,model.columnNames);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(false);
		model.fireTableDataChanged();
		JScrollPane scrl=new JScrollPane(table);
		scrl.setBounds(20, 11, 624, 351);
		table.setVisible(true);
		getContentPane().add(scrl);
	}
	class TablaEstadisticasMdl extends AbstractTableModel{

		private static final long serialVersionUID = 1L;
		private String[] columnNames = {"Nombre", "Partidas jugadas", "Partidas ganadas", "% de acierto"};
		Object[][] data;
		
		public TablaEstadisticasMdl(Map<Integer, Estadisticas> m){
			
			int filas = m.size();
			int cont = 0;
			data = new Object[filas][];
			DecimalFormat dcm = new DecimalFormat("#.##");
			for(Map.Entry<Integer, Estadisticas> entry:m.entrySet()){
				Object[] a = {
						new String(new GestorDatos().obtenerJugador(entry.getValue().getId_jugador()).getNombre_usuario()),
						new Integer(entry.getValue().getPartidas_jugadas()),
						new Integer(entry.getValue().getPartidas_ganadas()),
						new String(dcm.format(entry.getValue().getPorcent_acertadas())+"%")
				};
				data[cont] = a;
				cont++;
			}
		}
		public void setData(Map<Integer, Estadisticas> m){
			int filas = m.size();
			int cont = 0;
			data = new Object[filas][];
			
			for(Map.Entry<Integer, Estadisticas> entry:m.entrySet()){
				Object[] a = {
						new String(new GestorDatos().obtenerJugador(entry.getValue().getId_jugador()).getNombre_usuario()),
						new Integer(entry.getValue().getPartidas_jugadas()),
						new Integer(entry.getValue().getPartidas_ganadas()),
						new String(entry.getValue().getPreguntas_acertadas()+"%")
				};
				data[cont] = a;
				cont++;
			}
		}
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}
		public boolean isCellEditable(int rowIndex, int columnIndex){
			return false;
		}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return data[arg0][arg1];
		}
		
	}
	

}
