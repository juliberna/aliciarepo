package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Fiesta {
	
	private String nombre;
	private List<Alimento> alimentos; 

	public Fiesta(String nombre) {
		this.nombre = nombre;
		this.alimentos = new ArrayList<>();
	}
	
	public Boolean consumirAlimento(Alicia alicia, Alimento alimento) throws AlturaMaximaAlcanzadaException, AlturaMinimaAlcanzadaException {
		if(alimento instanceof Agrandador) {
			Double alturaDeAliciaAlConsumirAlimento = alicia.getAltura() + 40.0;
			alicia.setAltura(alturaDeAliciaAlConsumirAlimento);
			alimentos.remove(alimento);
			if(alicia.getAltura() > 280.0) {
				throw new AlturaMaximaAlcanzadaException("Alcanzaste la altura maxima");
			}
			return true;
		} else if(alimento instanceof Achicador) {
			Double alturaDeAliciaAlConsumirAlimentoAchicador = alicia.getAltura() - 50.0;
			alicia.setAltura(alturaDeAliciaAlConsumirAlimentoAchicador);
			if(alicia.getAltura() < 50.0) {
				throw new AlturaMinimaAlcanzadaException("Alcanzaste la altura minima");
			}
			return true;
		}
		throw new AlimentoInexistenteException("No existe ningun alimento");
	}

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	
	
	

}
