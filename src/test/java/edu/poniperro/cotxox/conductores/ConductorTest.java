package edu.poniperro.cotxox.conductores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ConductorTest {

	Conductor conductor;

	@Before
	public void setup() {
		this.conductor = new Conductor("Marcos");
	}

	@Test
	public void getNombreConductorTest() {
		assertTrue(conductor instanceof Conductor);
		assertEquals("Marcos", conductor.getNombre());

		Conductor conductora = new Conductor("Jazmine");
		assertEquals("Jazmine", conductora.getNombre());
	}

	@Test
	public void matriculaConductorTest() {
		assertNull(conductor.getMatricula());

		conductor.setMatricula("12345ABC");
		assertEquals("12345ABC", conductor.getMatricula());
	}

	@Test
	public void modeloConductorTest() {
		assertNull(conductor.getModelo());

		conductor.setModelo("Fiat");
		assertEquals("Fiat", conductor.getModelo());
	}

	@Test
	public void ocupadoConductorTest() {
		assertFalse(conductor.isOcupado());

		conductor.setOcupado(true);
		assertTrue(conductor.isOcupado());
	}

	@Test
	public void valoracionConductorTest() {
		assertEquals(0, conductor.getValoracion(), 0);
		assertEquals(0, conductor.getNumeroValoraciones());

		conductor.setValoracion((byte) 1);
		conductor.setValoracion((byte) 5);
		conductor.setValoracion((byte) 9);

		assertEquals(5, conductor.getValoracion(), 0);
		assertEquals(3, conductor.getNumeroValoraciones());

	}
}
