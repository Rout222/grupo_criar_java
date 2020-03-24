package org.springframework.samples.petclinic.services;

import org.springframework.samples.petclinic.model.Volta;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProcessaMelhorVoltaService {
    public Volta processarMelhorVolta(List<Volta> voltas){
        Collections.sort(voltas);
        return voltas.get(0);
    }
}
