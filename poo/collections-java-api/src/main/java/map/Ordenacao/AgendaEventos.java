package main.java.map.Ordenacao;

import java.time.LocalDate;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AgendaEventos {
    Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao) {
        eventoMap.put(data, new Evento(nomeEvento, nomeAtracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosOrdemCrescente = new TreeMap<>(eventoMap);
        System.out.println(eventosOrdemCrescente);
    }

    public Evento obterProximoEvento() {
        if (eventoMap.isEmpty()) {
            System.out.println("Agenda vazia!");
            return null;
        }

        Set<LocalDate> dataSet = eventoMap.keySet();
        LocalDate dataMaisrecente = LocalDate.MAX;
        for (LocalDate data : dataSet) {
            if (data.isBefore(dataMaisrecente) && (data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now()))) {
                dataMaisrecente = data;
            }
        }

        return eventoMap.get(dataMaisrecente);
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2020, Month.JANUARY, 18), "Evento 3", "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.APRIL, 10), "Evento 4", "Atracao 4");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.APRIL, 20), "Evento 5", "Atracao 5");

        agendaEventos.exibirAgenda();
        System.out.println("O próximo evento é: " + agendaEventos.obterProximoEvento());

    }

}
