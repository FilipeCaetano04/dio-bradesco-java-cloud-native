package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> conjuntoContatos;

    public AgendaContatos() {
        conjuntoContatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        conjuntoContatos.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(conjuntoContatos);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato contato : conjuntoContatos) {
            if (contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }

        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato contato : conjuntoContatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumeroTelefone(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }

        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("miguel", 991112355);
        agendaContatos.adicionarContato("miguel", 0);
        agendaContatos.adicionarContato("miguel carvalho", 912451358);
        agendaContatos.adicionarContato("rodrigo", 982665412);
        agendaContatos.adicionarContato("marcos", 987885463);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("miguel"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("rodrigo", 123456789));

        agendaContatos.exibirContatos();
    }
}
