package com.eventoapp.eventoapp.Resources;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.stream.util.EventReaderDelegate;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestApiController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @GetMapping(value = "/evento/{codigo}")
    public ResponseEntity<Evento> consultaEvento(@PathVariable("codigo") Long codigo){
        Evento evento = er.findByCodigo(codigo);
        return ResponseEntity.ok().body(evento);
    }

    @GetMapping(value = "/eventos")
    public ResponseEntity<?> consultaEventos(){
        Iterable<Evento> eventos = er.findAll();
        return ResponseEntity.ok().body(eventos);
    }

    @GetMapping(value = "/evento/{codigo}/convidados")
    public ResponseEntity<Iterable<Convidado>> consultaConvidados(@PathVariable("codigo") Long codigo){
        Evento evento = er.findByCodigo(codigo);
        Iterable<Convidado> convidados = cr.findByEvento(evento);
        return ResponseEntity.ok().body(convidados);
    }

    @PostMapping(value = "/evento", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evento cadastraEvento(@RequestBody Evento evento){
        return er.save(evento);

    }

    @DeleteMapping(value = "/evento/{codigo}")
    public void deletaEvento(@PathVariable Long codigo){
        Evento evento = er.findByCodigo(codigo);
        er.delete(evento);
    }

}
