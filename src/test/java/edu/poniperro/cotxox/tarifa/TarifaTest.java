package edu.poniperro.cotxox.tarifa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.poniperro.cotxox.carrera.Carrera;

public class TarifaTest {
	@Test
	public void costeDistanciaTest() {
		assertEquals(13.5, Tarifa.getCosteDistancia(10), 0);
	}

	@Test
	public void costeTiempoTest() {
		assertEquals(3.5, Tarifa.getCosteTiempo(10), 0);
	}

	@Test
	public void costeTotalEsperadoTest() {
		Carrera carrera = new Carrera("ABC12345");
		carrera.setTiempoEsperado(10);
		carrera.setDistancia(10);
		assertEquals(17, Tarifa.getCosteTotalEsperado(carrera), 0);
	}

	@Test
	public void costeTotalEsperadoMininoTest() {
		Carrera carrera = new Carrera("ABC12345");
		carrera.setTiempoEsperado(1);
		carrera.setDistancia(1);
		assertEquals(5, Tarifa.getCosteTotalEsperado(carrera), 0);
	}

}
