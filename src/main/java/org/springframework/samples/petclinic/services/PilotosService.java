package org.springframework.samples.petclinic.services;

import org.springframework.samples.petclinic.model.Piloto;
import org.springframework.samples.petclinic.model.Volta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PilotosService {

    public List<Piloto> retornarPilotos(List<Volta> voltas){
        List<Piloto> pilotos = new ArrayList<>();
        for (Volta volta :
            voltas) {
            Piloto p;
            if (!pilotos.contains(volta.getPiloto())) {
                p = volta.getPiloto();
                p.setRecorde(volta.getTempoVolta());
                pilotos.add(p);
            }
        }

        return pilotos;
    }
}
