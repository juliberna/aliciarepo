package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenDescendiente implements Comparator<Alimento>{

	@Override
	public int compare(Alimento o1, Alimento o2) {
		// TODO Auto-generated method stub
		return o2.getNombre().compareTo(o1.getNombre());
	}




}
