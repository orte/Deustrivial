package LN;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ListaPartidasMdl extends DefaultListModel<Partida>{

	private static final long serialVersionUID = 1L;
	protected ArrayList<Partida> lista;
	
	public ListaPartidasMdl(ArrayList<Partida> lista){
		this.lista = lista;
	}
	public ListaPartidasMdl(){
		this.lista = new ArrayList<Partida>();
	}
	
	public Partida getElementAt(int index){
		return lista.get(index);
	}
	public int getSize(){
		return lista.size();
	}
	
	public void addElement(Partida element){
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