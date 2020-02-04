package com.eventoapp.adapters.evento.repository;

import com.eventoapp.app.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findByCodigo(long codigo);
}
