package com.eventoapp.eventoapp.controllers;

import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestApiController {

    @Autowired
    private EventoRepository er;

    @GetMapping(value = "/evento/{codigo}")
    public Evento restTest(@PathVariable("codigo") Long codigo){
        Evento evento = er.findByCodigo(codigo);
        return evento;
    }

    @GetMapping(value = "/eventos")
    public Iterable<Evento> restTestEventos(){
        Iterable<Evento> eventos = er.findAll();
        return eventos;
    }
}
