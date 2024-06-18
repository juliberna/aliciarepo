package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TestAlicia {
	
	private Supermercado supermercado;
	private Fiesta fiesta;
	private static final String NOMBRE_DEL_SUPER= "El super";
	private static final String NOMBRE_DE_LA_FIESTA= "La fiesta";
	
	@Before
	public void init() {
		this.supermercado = new Supermercado(NOMBRE_DEL_SUPER);
		this.fiesta = new Fiesta(NOMBRE_DE_LA_FIESTA);
	}
	
	
	@Test
	public void queAlComprarUnAlimentoSeDescuenteElDineroDisponible() throws DineroInsuficienteException {
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 3000.0);
		Alimento alimento = new Achicador(2500.0, "bagel");
		
		Boolean comprarAlimento = supermercado.comprarAlimento(alimento, alicia);
		Double precioEsperado = 500.0;
		
		assertEquals(precioEsperado, alicia.getDineroParaComprar());
		assertEquals(1, supermercado.getAlimentos().size());
		assertTrue(comprarAlimento);
		
	}
	
	@Test (expected = DineroInsuficienteException.class)
	public void queNoSeExcedaDelDineroDisponible() throws DineroInsuficienteException  {
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 3000.0);
		Alimento alimento = new Achicador(3500.0, "bagel");
		
		supermercado.comprarAlimento(alimento, alicia);
		
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeAgrande() throws DineroInsuficienteException, AlturaMaximaAlcanzadaException, AlturaMinimaAlcanzadaException {
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 6000.0);
		Alimento alimento = new Agrandador(3500.0, "Caramelo");
		
		supermercado.comprarAlimento(alimento, alicia);
		Boolean seAgrandaAlicia = fiesta.consumirAlimento(alicia, alimento);
		
		Double alturaEsperada = 220.0;
		
		assertTrue(seAgrandaAlicia);
		assertEquals(alturaEsperada, alicia.getAltura());
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeEncoja() throws DineroInsuficienteException, AlturaMaximaAlcanzadaException, AlturaMinimaAlcanzadaException{
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 6000.0);
		Alimento alimento = new Achicador(3500.0, "Bagel");
		
		supermercado.comprarAlimento(alimento, alicia);
		Boolean seAchicaAlicia = fiesta.consumirAlimento(alicia, alimento);
		
		Double alturaEsperada = 130.0;
		
		assertTrue(seAchicaAlicia);
		assertEquals(alturaEsperada, alicia.getAltura());
	}
	
	@Test (expected = AlturaMaximaAlcanzadaException.class)
	public void queAlConsumirAlimentosVerificarQueNoSePuedaAgrandarMasDe280cm() throws DineroInsuficienteException, AlturaMaximaAlcanzadaException, AlturaMinimaAlcanzadaException {
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 6000.0);
		Alimento alimento = new Agrandador(78.0, "Caramelo");
		Alimento alimento2 = new Agrandador(70.0, "Caramelo");
		Alimento alimento3 = new Agrandador(60.0, "Caramelo");
		
		supermercado.comprarAlimento(alimento, alicia);
		supermercado.comprarAlimento(alimento2, alicia);
		supermercado.comprarAlimento(alimento3, alicia);
		
		fiesta.consumirAlimento(alicia, alimento);
		fiesta.consumirAlimento(alicia, alimento2);
		fiesta.consumirAlimento(alicia, alimento3);
		
	}
	
	@Test(expected = AlturaMinimaAlcanzadaException.class)
	public void queAlConsumirAlimentosVerificarQueNoSePuedaAchicarMenosDe50cm() throws DineroInsuficienteException, AlturaMaximaAlcanzadaException, AlturaMinimaAlcanzadaException {
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 6000.0);
		Alimento alimento = new Achicador(78.0, "Caramelo");
		Alimento alimento2 = new Achicador(70.0, "Caramelo");
		Alimento alimento3 = new Achicador(60.0, "Caramelo");
		
		supermercado.comprarAlimento(alimento, alicia);
		supermercado.comprarAlimento(alimento2, alicia);
		supermercado.comprarAlimento(alimento3, alicia);
		
		fiesta.consumirAlimento(alicia, alimento);
		fiesta.consumirAlimento(alicia, alimento2);
		fiesta.consumirAlimento(alicia, alimento3);
		
	}
	
	@Test
	public void verificarQueLaColeccionDeAlimentosQuedeOrdenadaPorNombreDescendente() throws DineroInsuficienteException {
		Alicia alicia = new Alicia(180.0, 60.0, "Alicia", 21, 6000.0);
		Alimento alimento = new Achicador(78.0, "Masitas");
		Alimento alimento2 = new Achicador(70.0, "Alfajores");
		Alimento alimento3 = new Achicador(60.0, "Bagels");
		
		supermercado.comprarAlimento(alimento, alicia);
		supermercado.comprarAlimento(alimento2, alicia);
		supermercado.comprarAlimento(alimento3, alicia);
		
		TreeSet<Alimento> alimentosAchicadores = supermercado.alimentosAchicadoresOrdenadosPorNombreDescendente(new OrdenDescendiente());
		
		assertEquals(alimento.getNombre(), alimentosAchicadores.first().getNombre());
		assertEquals(alimento2.getNombre(), alimentosAchicadores.last().getNombre());
	
		
	}
	
	

}
