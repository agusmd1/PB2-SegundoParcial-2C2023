package ar.edu.unlam.pb2.felizNoCumpleanios;

import static org.junit.Assert.*;

import org.junit.Test;

public class testNoCumpleanios {

	/*
	 * Se pide como test unitarios: 1) Que, al comprar un alimento, se descuente el
	 * dinero disponible 2) Que no se exceda del dinero disponible 3) Que, al
	 * consumir un alimento, verificar que se agrande 4) Que al consumir un alimento
	 * verificar que se encoja 5) Que al consumir alimentos verificar que no se
	 * pueda agrandar más de 280cm 6) Que al consumir alimentos verificar que no se
	 * pueda achicar menos de 50cm 7) Verificar que la colección de alimentos quede
	 * ordenada por nombre de manera descendente
	 */

	@Test
	public void queAlComprarAlimentoDescuenteDineroDisponible() throws DineroInsuficienteException {
		// preparacion
		// alicia( nombre, edad, altura, peso, dineroDisponibleParaComprar) para no
		// olvidarme
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Achicador("Achicador", 10.0);
		Double valorEsperado = 990.0; // 1000-10
		Double valorObtenido = 0.0;
		// ejecucion
		alicia.comprarAlimento(alimento1);
		valorObtenido = alicia.getDineroDisponibleParaComprar();
		// validacion
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test(expected = DineroInsuficienteException.class)
	public void queNoSePuedaExcederDineroDisponible() throws DineroInsuficienteException {
		// preparacion

		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Achicador("Masita", 100.0);
		Alimento alimento2 = new Achicador("Alfajor", 800.0);
		Alimento alimento3 = new Agrandador("Gomita", 200.0);
		// ejecucion
		alicia.comprarAlimento(alimento1);
		alicia.comprarAlimento(alimento2);
		// despues de las 2 primeras compras, me deberia quedar $100 y la siguiente
		// compra cuesta $200 por ende no podria comprarla
		alicia.comprarAlimento(alimento3);
	}

	@Test
	public void queAlConsumirAlimentoVerificarQueSeAgrande()
			throws SinAlimentosDisponiblesException, DineroInsuficienteException {
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);

		Alimento alimento1 = new Agrandador("Gomita", 200.0);
		Double valorEsperado = 220.0; // 180+40=220
		Double valorObtenido = 0.0;
		// ejecucion
		alicia.comprarAlimento(alimento1);
		alicia.consumirAlimento(alimento1);
		valorObtenido = alicia.getAltura();
		// validacion
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void queAlConsumirAlimentoVerificarQueSeAchique()
			throws SinAlimentosDisponiblesException, DineroInsuficienteException {
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);

		Alimento alimento1 = new Achicador("Alfajor", 200.0);
		Double valorEsperado = 130.0; // 180-50=130
		Double valorObtenido = 0.0;
		// ejecucion
		alicia.comprarAlimento(alimento1);
		alicia.consumirAlimento(alimento1);
		valorObtenido = alicia.getAltura();
		// validacion
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queAlConsumirAlimentoNoSePuedaAgrandarMasDe280cm()
			throws SinAlimentosDisponiblesException, DineroInsuficienteException {
		// preparacion
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Agrandador("Caramelos", 50.0);
		Alimento alimento2 = new Agrandador("Gomitas", 50.0);
		Alimento alimento3 = new Agrandador("Bocaditos de Chocolate", 50.0);
		Double valorObtenido = 0.0;
		Double valorEsperado = 260.0; // el tercero no deberia poder comerselo
		// ejecucion
		alicia.comprarAlimento(alimento1);
		alicia.comprarAlimento(alimento2);
		alicia.comprarAlimento(alimento3);

		alicia.consumirAlimento(alimento1); // 220cm
		alicia.consumirAlimento(alimento2); // 260cm
		alicia.consumirAlimento(alimento3); // 300cm, no deberia comerlo

		valorObtenido = alicia.getAltura();
		// validacion
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queAlConsumirAlimentoNoSePuedaAchicarMenosDe50cm()
			throws SinAlimentosDisponiblesException, DineroInsuficienteException {
		// preparacion
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Achicador("Masitas", 50.0);
		Alimento alimento2 = new Achicador("Alfajor", 50.0);
		Alimento alimento3 = new Achicador("Bagel", 50.0);
		Double valorObtenido = 0.0;
		Double valorEsperado = 80.0; // el tercero no deberia poder comerselo
		// ejecucion
		alicia.comprarAlimento(alimento1);
		alicia.comprarAlimento(alimento2);
		alicia.comprarAlimento(alimento3);

		alicia.consumirAlimento(alimento1); // 130cm
		alicia.consumirAlimento(alimento2); // 80cm
		alicia.consumirAlimento(alimento3); // 30cm, no deberia comerlo

		valorObtenido = alicia.getAltura();
		// validacion
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queLaColeccionDeAlimentosDisponiblesSeOrdenenPorNombre() throws DineroInsuficienteException {
		// preparacion
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Achicador("Masitas", 15.0);
		Alimento alimento2 = new Achicador("Alfajores", 15.0);
		Alimento alimento3 = new Achicador("Bagels", 15.0);
		Alimento alimento4 = new Agrandador("Caramelos", 50.0);
		Alimento alimento5 = new Agrandador("Gomitas", 50.0);
		Alimento alimento6 = new Agrandador("Bocaditos de Chocolate", 50.0);
		Alimento alimento7 = new Achicador("Alfajores", 15.0);

		// ejecucion
		// cargo en la lista de alismentos de manera desordenada
		alicia.comprarAlimento(alimento1);
		alicia.comprarAlimento(alimento2);
		alicia.comprarAlimento(alimento3);
		alicia.comprarAlimento(alimento4);
		alicia.comprarAlimento(alimento5);
		alicia.comprarAlimento(alimento6);
		alicia.comprarAlimento(alimento7);

		// validacion
		assertEquals("Masitas", alicia.getAlimentosDisponibles().get(0).getNombre());
		assertEquals("Gomitas", alicia.getAlimentosDisponibles().get(1).getNombre());
		assertEquals("Caramelos", alicia.getAlimentosDisponibles().get(2).getNombre());
		assertEquals("Bocaditos de Chocolate", alicia.getAlimentosDisponibles().get(3).getNombre());
		assertEquals("Bagels", alicia.getAlimentosDisponibles().get(4).getNombre());
		assertEquals("Alfajores", alicia.getAlimentosDisponibles().get(5).getNombre());
		assertEquals("Alfajores", alicia.getAlimentosDisponibles().get(6).getNombre());

	}

	@Test(expected = SinAlimentosDisponiblesException.class)
	public void testConsumirAlimentoSinAlimentosDisponibles() throws SinAlimentosDisponiblesException {
		// preparacion
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Agrandador("Gomita", 200.0);

		// ejecucion
		// espero que se lance la excepcion por que alicia intenta comer un alimento que
		// no compro
		// la lista de alimentos disponiibles esta vacia
		alicia.consumirAlimento(alimento1);
	}

	@Test // misma excepcion probada de otra manera
			// testConsumirAlimentoSinAlimentosDisponibles
	public void testConsumirAlimentoSinAlimentosDisponiblesConTryAndCatch() {
		// preparacion
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Agrandador("Gomita", 200.0);
		Boolean pudoComer = true;
		// espero que se lance la excepcion por que alicia intenta comer un alimento que
		// no compro
		// la lista de alimentos disponiibles esta vacia
		// ejecucion
		try {
			alicia.consumirAlimento(alimento1);
			pudoComer = true;
		} catch (SinAlimentosDisponiblesException e) {
			pudoComer = false;

		}
		// validacion
		assertFalse(pudoComer);

	}

	@Test
	public void quePuedaComprarUnAlimentoYPuedaComerloProbadoConTryCatch() throws DineroInsuficienteException {
		// preparacion
		Persona alicia = new Persona("Alicia", 12, 180.0, 60.0, 1000.0);
		Alimento alimento1 = new Agrandador("Gomita", 200.0);
		Boolean pudoComer = false;
		// ejecucion
		alicia.comprarAlimento(alimento1);
		try {
			alicia.consumirAlimento(alimento1);
			pudoComer = true;
		} catch (SinAlimentosDisponiblesException e) {
			pudoComer = false;
		}
		// validacion
		assertTrue(pudoComer);

	}

}
