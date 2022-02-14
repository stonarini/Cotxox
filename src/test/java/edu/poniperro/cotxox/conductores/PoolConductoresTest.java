package edu.poniperro.cotxox.conductores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PoolConductoresTest {

	PoolConductores poolConductores;
	List<Conductor> conductores = new ArrayList<Conductor>();
	{
		add(new Conductor("Maximo"));
		add(new Conductor("Juan"));
		add(new Conductor("David"));
		add(new Conductor("Adela"));
	}

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

		assertFalse(poolConductores.getPoolConductores().contains(conductorAsignado.getNombre()));
	}

}
