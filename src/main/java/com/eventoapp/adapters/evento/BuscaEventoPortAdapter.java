package com.eventoapp.adapters.evento;

import com.eventoapp.adapters.evento.repository.EventoRepository;
import com.eventoapp.app.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaEventoPortAdapter implements BuscaEventoPort {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento por(long codigo) {
        return eventoRepository.findByCodigo(codigo);
    }

    public Iterable<Evento> buscaTodos(){
        return eventoRepository.findAll();
    }
}
