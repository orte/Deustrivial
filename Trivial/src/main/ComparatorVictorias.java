package main;

import java.util.Comparator;

import LN.Estadisticas;

public class ComparatorVictorias implements Comparator<Estadisticas>{

	@Override
	public int compare(Estadisticas arg0, Estadisticas arg1) {
		// TODO Auto-generated method stub
		int comp;
		if(arg0.getPartidas_ganadas()>arg1.getPartidas_ganadas()){
			comp = -1;
		} else if(arg0.getPartidas_ganadas()<arg1.getPartidas_ganadas()){
			comp = 1;
		} else {
			comp = 0;
		}
		return comp;
	}

}
