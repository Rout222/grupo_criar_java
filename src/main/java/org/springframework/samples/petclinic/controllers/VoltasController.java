package org.springframework.samples.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.samples.petclinic.model.Piloto;
import org.springframework.samples.petclinic.model.Volta;
import org.springframework.samples.petclinic.services.PilotosService;
import org.springframework.samples.petclinic.services.ProcessaCorridaService;
import org.springframework.samples.petclinic.services.ProcessaMelhorVoltaService;
import org.springframework.samples.petclinic.services.VoltasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class VoltasController implements Serializable {

    private static final long serialVersionUID = 1l;

    @Autowired
    private VoltasService voltasService;

    @Autowired
    private ProcessaCorridaService processaCorridaService;

    @Autowired
    private ProcessaMelhorVoltaService processaMelhorVoltaService;

    @Autowired
    private PilotosService pilotosService;

    @GetMapping("/")
    public String index(){
        return "welcome";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        List<Volta>  voltas     = voltasService.retornarVoltas(file);
        List<Piloto> pilotos    = pilotosService.retornarPilotos(voltas);
        pilotos                 = processaCorridaService.processarCorrida(pilotos, voltas);
        Volta volta             = processaMelhorVoltaService.processarMelhorVolta(voltas);

        System.out.println(pilotos);
        return "arquivoprocessado";
    }
}
