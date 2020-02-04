package com.eventoapp.adapters.evento;

import com.eventoapp.app.models.Evento;

public interface BuscaEventoPort {
    Evento por(long codigo);

    Iterable<Evento> buscaTodos();
}
