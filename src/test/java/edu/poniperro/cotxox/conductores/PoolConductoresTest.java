package edu.poniperro.cotxox.conductores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PoolConductoresTest {

	PoolConductores poolConductores;
	List<Conductor> conductores = new ArrayList<Conductor>(Arrays.asList(
			new Conductor("Maximo"),
			new Conductor("Juan"),
			new Conductor("David"),
			new Conductor("Adela")));

	@Before
	public void setup() {
		this.poolConductores = new PoolConductores(conductores);
	}

	@Test
	public void getPoolConductoresTest() {
		assertEquals(conductores, poolConductores.getPoolConductores());
	}

	@Test
	public void asignarConductorTest() {
		Conductor conductorAsignado = poolConductores.asignarConductor();

		int i = poolConductores.getPoolConductores().indexOf(conductorAsignado);

		assertTrue(poolConductores.getPoolConductores().get(i).isOcupado());
	}

}
