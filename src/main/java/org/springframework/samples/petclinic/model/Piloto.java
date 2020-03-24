package org.springframework.samples.petclinic.model;

import java.sql.Time;

public class Piloto implements Comparable<Piloto> {

	private String nome;

	private int id;

	private int numVoltas;

	private Time tempo;

	private float somaMedia;

	private Time recorde;

	public Piloto(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.tempo = new Time(0);
		this.somaMedia = 0;
		this.numVoltas = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumVoltas() {
		return numVoltas;
	}

	public void setNumVoltas(int numVoltas) {
		this.numVoltas = numVoltas;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}

	public float getSomaMedia() {
		return somaMedia;
	}

	public void setSomaMedia(float somaMedia) {
		this.somaMedia = somaMedia;
	}

	public Time getRecorde() {
		return recorde;
	}

	public void setRecorde(Time recorde) {
		this.recorde = recorde;
	}

	@Override
	public String toString() {
		return "Piloto{" + "nome='" + nome + '\'' + ", id=" + id + ", numVoltas=" + numVoltas + ", tempo=" + tempo
				+ ", somaMedia=" + somaMedia + ", recorde=" + recorde + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Piloto) {
			Piloto pilotoObj = (Piloto) obj;
			return this.id == pilotoObj.getId();
		}
		else
			return false;
	}

	@Override
	public int compareTo(Piloto p) {
		if (this.getNumVoltas() == p.getNumVoltas())
			return new Long(this.getTempo().getTime() - p.getTempo().getTime()).intValue();
		else
			return p.getNumVoltas() - this.getNumVoltas();
	}

}
