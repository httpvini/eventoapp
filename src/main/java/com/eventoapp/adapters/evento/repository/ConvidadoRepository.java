package com.eventoapp.adapters.evento.repository;

import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);
}
