package com.eventoapp.adapters.evento.convidado;

import com.eventoapp.adapters.evento.repository.ConvidadoRepository;
import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaConvidadoPortAdapter implements BuscaConvidadoPort {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Override
    public Iterable<Convidado> por(Evento evento) {
        return convidadoRepository.findByEvento(evento);
    }

    @Override
    public Convidado por(String rg) {
        return convidadoRepository.findByRg(rg);
    }
}
