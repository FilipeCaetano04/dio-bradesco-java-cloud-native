package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatosMap;

    public AgendaContatos() {
        contatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        contatosMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (contatosMap.isEmpty()) {
            System.out.println("Agenda vazia!");
            return;
        }
        contatosMap.remove(nome);
    }

    public void exibirContato() {
        System.out.println(contatosMap);
    }

    public Integer pesquisarPorNome(String nome) {
        if (contatosMap.isEmpty()) {
            System.out.println("Agenda vazia!");
            return null;
        }

        Integer numeroPorNome = null;
        numeroPorNome = contatosMap.get(nome);
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("miguel", 991112355);
        agendaContatos.adicionarContato("miguel", 111111111);
        agendaContatos.adicionarContato("miguel carvalho", 912451358);
        agendaContatos.adicionarContato("rodrigo", 982665412);
        agendaContatos.adicionarContato("marcos", 987885463);

        agendaContatos.exibirContato();

        agendaContatos.removerContato("marcos");
        agendaContatos.exibirContato();

        System.out.println("O numero é: " + agendaContatos.pesquisarPorNome("rodrigo"));
    }
}
