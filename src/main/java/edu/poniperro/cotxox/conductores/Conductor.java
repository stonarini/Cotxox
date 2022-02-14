package edu.poniperro.cotxox.conductores;

import java.util.ArrayList;
import java.util.List;

public class Conductor {
	private String nombre;
	private String modelo;
	private String matricula;
	private double valoracionMedia;
	private boolean ocupado;
	private List<Byte> valoraciones = new ArrayList<Byte>();

	public Conductor(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getValoracion() {
		return valoracionMedia;
	}

	public int getNumeroValoraciones() {
		return valoraciones.size();
	}

	public void setValoracion(byte valoracion) {
		this.valoraciones.add(valoracion);
		calcularValoracionMedia();
	}

	private void calcularValoracionMedia() {
		double sumValoraciones = valoraciones.stream()
				.map(b -> Byte.toUnsignedInt(b))
				.reduce(0, (a, b) -> a + b);
		this.valoracionMedia = sumValoraciones / getNumeroValoraciones();
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public boolean isOcupado() {
		return ocupado;
	}
}
