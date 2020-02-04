package com.eventoapp.adapters.evento.cadastro;

import com.eventoapp.adapters.evento.repository.ConvidadoRepository;
import com.eventoapp.adapters.evento.repository.EventoRepository;
import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroAdapter implements CadastroPort {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Override
    public void registraEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void registraConvidado(Convidado convidado) {
        convidadoRepository.save(convidado);
    }

    @Override
    public void removeConvidado(Convidado convidado) {
        convidadoRepository.delete(convidado);
    }

    @Override
    public void removeEvento(Evento evento) {
        eventoRepository.delete(evento);
    }
}
