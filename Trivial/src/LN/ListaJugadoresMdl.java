package LN;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ListaJugadoresMdl extends DefaultListModel<Jugador>{

	private static final long serialVersionUID = 1L;
	protected ArrayList<Jugador> lista;
	
	public ListaJugadoresMdl(ArrayList<Jugador> lista){
		this.lista = lista;
	}
	public ListaJugadoresMdl(){
		this.lista = new ArrayList<Jugador>();
	}
	
	public Jugador getElementAt(int index){
		return lista.get(index);
	}
	public int getSize(){
		return lista.size();
	}
	
	public void addElement(Jugador element){
		lista.add(element);
		this.fireContentsChanged(this, lista.size(), lista.size());
	}
	public void removeElement(int index){
		lista.remove(index);
		this.fireContentsChanged(this, lista.size(), lista.size());
	}
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	

}
