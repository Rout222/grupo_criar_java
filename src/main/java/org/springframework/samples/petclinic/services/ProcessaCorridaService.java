package org.springframework.samples.petclinic.services;

import org.springframework.samples.petclinic.model.Piloto;
import org.springframework.samples.petclinic.model.Volta;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ProcessaCorridaService {

	public List<Piloto> processarCorrida(List<Piloto> pilotos, List<Volta> voltas) {
		Piloto p;

		for (Volta volta : voltas) {
			p = pilotos.get(pilotos.indexOf(volta.getPiloto()));

			if (p.getRecorde().getTime() < volta.getTempoVolta().getTime())
				p.setRecorde(volta.getTempoVolta());

			p.setTempo(somaTimes(p.getTempo(), volta.getTempoVolta()));
			p.setNumVoltas(p.getNumVoltas() + 1);
			p.setSomaMedia(p.getSomaMedia() + volta.getVelocidadeMedia());
		}
		Collections.sort(pilotos);
		return pilotos;
	}

	private Time somaTimes(Time t1, Time t2) {
		Long t1time = t1.getTime();
		if (t1.getTime() > 0)
			t1time -= 3 * 60 * 60 * 1000; // para correção da soma de horas
		return new Time(t1time + t2.getTime());
	}

}
