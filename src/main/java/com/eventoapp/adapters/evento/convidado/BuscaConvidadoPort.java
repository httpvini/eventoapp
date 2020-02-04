package com.eventoapp.adapters.evento.convidado;

import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;

public interface BuscaConvidadoPort {
    Iterable<Convidado> por(Evento evento);
    Convidado por(String rg);
}
