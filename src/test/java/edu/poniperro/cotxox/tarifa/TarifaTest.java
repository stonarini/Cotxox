package edu.poniperro.cotxox.tarifa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TarifaTest {
	@Test
	public void costeDistanciaTest() {
		assertEquals(13.5, Tarifa.getCosteDistancia(10));
	}

	@Test
	public void costeTiempoTest() {
		assertEquals(3.5, Tarifa.getCosteTiempo(10));
	}

	@Test
	public void costeTotalEsperadoTest() {
		Carrera carrera = new Carrera("ABC12345");
		carrera.setTiempoEsperado(10);
		carrera.setDistancia(10);
		assertEquals(17, Tarifa.getCosteTotalEsperado());
	}

	@Test
	public void costeTotalEsperadoMininoTest() {
		Carrera carrera = new Carrera("ABC12345");
		carrera.setTiempoEsperado(1);
		carrera.setDistancia(1);
		assertEquals(5, Tarifa.getCosteTotalEsperado());
	}

}
