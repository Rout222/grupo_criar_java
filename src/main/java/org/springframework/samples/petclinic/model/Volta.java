package org.springframework.samples.petclinic.model;

import java.sql.Time;

public class Volta implements Comparable<Volta> {

	private Time hora;

	private Piloto piloto;

	private int volta;

	private Time tempoVolta;

	private float velocidadeMedia;

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public int getVolta() {
		return volta;
	}

	public void setVolta(int volta) {
		this.volta = volta;
	}

	public Time getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(Time tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	@Override
	public String toString() {
		return "Volta{" + "hora=" + hora + ", piloto=" + piloto + ", volta=" + volta + ", tempoVolta=" + tempoVolta
				+ ", velocidadeMedia=" + velocidadeMedia + '}';
	}

	@Override
	public int compareTo(Volta v) {
		return new Long(this.getTempoVolta().getTime() - v.getTempoVolta().getTime()).intValue();
	}

}
