package main;

import java.util.Comparator;

import LN.Estadisticas;

public class ComparatorAciertos implements Comparator<Estadisticas>{

	@Override
	public int compare(Estadisticas arg0, Estadisticas arg1) {
		// TODO Auto-generated method stub
		int comp;
		if(arg0.getPorcent_acertadas()>arg1.getPorcent_acertadas()){
			comp = -1;
		} else if(arg0.getPorcent_acertadas()<arg1.getPorcent_acertadas()){
			comp = 1;
		} else {
			comp = 0;
		}
		return comp;
	}

}
