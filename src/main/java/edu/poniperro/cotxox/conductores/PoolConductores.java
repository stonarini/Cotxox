package edu.poniperro.cotxox.conductores;

import java.util.List;
import java.util.Optional;

public class PoolConductores {
	private List<Conductor> poolConductores;

	public PoolConductores(List<Conductor> conductores) {
		this.poolConductores = conductores;
	}

	public List<Conductor> getPoolConductores() {
		return poolConductores;
	}

	public Conductor asignarConductor() {
		Optional<Conductor> conductorAsignado = getPoolConductores().stream().filter(c -> !c.isOcupado()).findAny();

		if (conductorAsignado.isPresent()) {
			Conductor conductor = conductorAsignado.get();
			conductor.setOcupado(true);
			return conductor;
		} else {
			return null;
		}
	}
}
