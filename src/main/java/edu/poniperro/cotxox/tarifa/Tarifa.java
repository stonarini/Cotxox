package edu.poniperro.cotxox.tarifa;

import edu.poniperro.cotxox.carrera.Carrera;

public class Tarifa {

	final static double COSTE_MILLA = 1.35;
	final static double COSTE_MINUTO = 0.35;
	final static double COSTE_MINIMO = 5.0;
	final static byte PORCENTAJE_COMISION = 20;

	public static double getCosteDistancia(double distance) {
		return distance * COSTE_MILLA;
	}

	public static double getCosteTiempo(int minutes) {
		return minutes * COSTE_MINUTO;
	}

	public static double getCosteTotalEsperado(Carrera carrera) {
		double costeTotal = getCosteDistancia(carrera.getDistancia()) + getCosteTiempo(carrera.getTiempoEsperado());
		return costeTotal > COSTE_MINIMO ? costeTotal : COSTE_MINIMO;
	}
}
