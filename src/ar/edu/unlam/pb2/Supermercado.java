package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Supermercado {
	
	private String nombre;
	private List<Alimento> alimentos;
	

	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.alimentos = new ArrayList<>();
	}

	
	public Boolean comprarAlimento(Alimento alimento, Alicia alicia) throws DineroInsuficienteException {
		if(alicia.getDineroParaComprar() > alimento.getPrecio()) {
			Double dineroDisponible = alicia.getDineroParaComprar() - alimento.getPrecio();
			alimentos.add(alimento);
			alicia.setDineroParaComprar(dineroDisponible);
			return true;
		}
		throw new DineroInsuficienteException("Alicia no tiene dinero suficiente");
	}
	
	
	public TreeSet<Alimento> alimentosAchicadoresOrdenadosPorNombreDescendente(Comparator<Alimento> ordenDescendente){
		TreeSet<Alimento> alimentosAchicadoresOrdenadosPorNombre = new TreeSet<>(ordenDescendente);
		
		for (Alimento alimento : alimentos) {
			if(alimento instanceof Achicador) {
				alimentosAchicadoresOrdenadosPorNombre.addAll(alimentos);
			}
		}
		
		return alimentosAchicadoresOrdenadosPorNombre;
	}
	

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TreeSet<Alimento> obtenerlosAlimentosOrdenados() {
		TreeSet<Alimento> alimentosOrdenados = new TreeSet<>();
		
		for (Alimento alimento : alimentos) {
			if(alimento instanceof Achicador) {
				alimentosOrdenados.add(alimento);
			}
		}
		return alimentosOrdenados;
	}



	
	

}
