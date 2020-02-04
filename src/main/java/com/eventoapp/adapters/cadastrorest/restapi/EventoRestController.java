package com.eventoapp.adapters.cadastrorest.restapi;

import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;
import com.eventoapp.adapters.evento.repository.ConvidadoRepository;
import com.eventoapp.adapters.evento.repository.EventoRepository;
import com.eventoapp.app.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoRestController {

    @Autowired
    private EventoService eventoService;

    @GetMapping(value = "/evento/{codigo}")
    public ResponseEntity<Evento> consultaEvento(@PathVariable("codigo") Long codigo){
        Evento evento = eventoService.buscaEvento(codigo);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @GetMapping(value = "/eventos")
    public ResponseEntity<?> consultaEventos(){
        Iterable<Evento> eventos = eventoService.listaEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping(value = "/evento/{codigo}/convidados")
    public ResponseEntity<Iterable<Convidado>> consultaConvidados(@PathVariable("codigo") Long codigo){
        Evento evento = eventoService.buscaEvento(codigo);
        Iterable<Convidado> convidados = eventoService.buscaConvidados(evento);
        return new ResponseEntity<>(convidados, HttpStatus.OK);
    }

    @PostMapping(value = "/evento", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cadastraEvento(@RequestBody Evento evento){
        eventoService.registraEvento(evento);
        return new ResponseEntity<>(evento, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/evento/{codigo}")
    public ResponseEntity<?> deletaEvento(@PathVariable Long codigo){
        Evento evento = eventoService.buscaEvento(codigo);
        eventoService.removeEvento(evento);
        return new ResponseEntity<>(evento, HttpStatus.ACCEPTED);
    }
}
