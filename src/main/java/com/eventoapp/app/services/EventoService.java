package com.eventoapp.app.services;

import com.eventoapp.adapters.evento.BuscaEventoPort;
import com.eventoapp.adapters.evento.cadastro.CadastroPort;
import com.eventoapp.adapters.evento.convidado.BuscaConvidadoPort;
import com.eventoapp.app.models.Convidado;
import com.eventoapp.app.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private BuscaConvidadoPort buscaConvidado;

    @Autowired
    private BuscaEventoPort buscaEvento;

    @Autowired
    private CadastroPort cadastro;


    public Iterable<Convidado> buscaConvidados(Evento evento){
        return buscaConvidado.por(evento);
    }

    public Convidado buscaConvidado(String rg){
        return buscaConvidado.por(rg);
    }

    public void registraConvidado(Convidado convidado) {
        cadastro.registraConvidado(convidado);
    }

    public Evento buscaEvento(long codigo) {
        return buscaEvento.por(codigo);
    }

    public Iterable<Evento> listaEventos(){
        return buscaEvento.buscaTodos();
    }

    public void registraEvento(Evento evento) {
        cadastro.registraEvento(evento);
    }

    public void removeConvidado(Convidado convidado){
        cadastro.removeConvidado(convidado);
    }

    public void removeEvento(Evento evento){
        cadastro.removeEvento(evento);
    }

}