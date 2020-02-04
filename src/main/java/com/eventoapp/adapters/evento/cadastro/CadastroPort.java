package com.eventoapp.adapters.evento.cadastro;

import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;

public interface CadastroPort {

    void registraEvento(Evento evento);

    void registraConvidado(Convidado convidado);

    void removeConvidado(Convidado convidado);

    void removeEvento(Evento evento);
}
