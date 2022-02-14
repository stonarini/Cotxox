package edu.poniperro.cotxox.carrera;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.cotxox.conductores.Conductor;
import edu.poniperro.cotxox.conductores.PoolConductores;

public class CarreraTest {
	Carrera carrera;

	@Before
	public void setup() {
		carrera = new Carrera("1234ABSDI");
	}

	@Test
	public void origenTest() {
		assertNull(carrera.getOrigen());
		carrera.setOrigen("Lloseta");
		assertEquals("Lloseta", carrera.getOrigen());
	}

	@Test
	public void destinoTest() {
		assertNull(carrera.getDestino());
		carrera.setDestino("Lloseta");
		assertEquals("Lloseta", carrera.getDestino());
	}

	@Test
	public void tiempoCarreraTest() {
		assertEquals(0, carrera.getTiempoCarrera());
		carrera.setTiempoCarrera(1);
		assertEquals(1, carrera.getTiempoCarrera());
	}

	@Test
	public void tiempoCarreraEsperadoTest() {
		assertEquals(0, carrera.getTiempoEsperado());
		carrera.setTiempoEsperado(1);
		assertEquals(1, carrera.getTiempoEsperado());
	}

	@Test
	public void conductorCarreraTest() {
		assertNull(carrera.getConductor());
		Conductor conductor = new Conductor("Maria");
		carrera.setConductor(conductor);
		assertEquals(conductor, carrera.getConductor());
	}

	@Test
	public void propinaTest() {
		assertEquals(0, carrera.getPropina());
		carrera.recibirPropina(1);
		assertEquals(1, carrera.getPropina());
	}

	@Test
	public void targetaCreditoTest() {
		assertEquals("1234ABSDI", carrera.getTarjetaCredito());
	}

	@Test
	public void asignarConductorTest() {
		List<Conductor> listaConductores = new ArrayList<Conductor>(Arrays.asList(
				new Conductor("Maximo"),
				new Conductor("Juan"),
				new Conductor("David"),
				new Conductor("Adela")));
		PoolConductores conductores = new PoolConductores(listaConductores);
		carrera.asignarConductor(conductores);

		assertTrue(carrera.getConductor().isOcupado());

		assertTrue(listaConductores.indexOf(carrera.getConductor()) != -1);
	}

	@Test
	public void liberarConductorTest() {
		List<Conductor> listaConductores = new ArrayList<Conductor>(Arrays.asList(
				new Conductor("Maximo"),
				new Conductor("Juan"),
				new Conductor("David"),
				new Conductor("Adela")));
		PoolConductores conductores = new PoolConductores(listaConductores);
		carrera.asignarConductor(conductores);
		carrera.liberarConductor();

		assertFalse(carrera.getConductor().isOcupado());
	}

	@Test
	public void costeTotalTest() {
		assertEquals(0, carrera.getCosteTotal(), 0);
		carrera.realizarPago(1);
		assertEquals(1, carrera.getCosteTotal(), 0);
	}

	@Test
	public void costeEsperadoTest() {
		carrera.setDistancia(10);
		carrera.setTiempoEsperado(10);
		assertEquals(17, carrera.getCosteEsperado(), 0);
	}
}
