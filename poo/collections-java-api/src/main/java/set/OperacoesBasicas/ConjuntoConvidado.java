package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {
    private Set<Convidado> conjuntoConvidados;

    public ConjuntoConvidado() {
        conjuntoConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        conjuntoConvidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;

        for (Convidado convidado : conjuntoConvidados) {
            if (convidado.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = convidado;
                break;
            }
        }

        conjuntoConvidados.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return conjuntoConvidados.size();
    }

    public void exibirConvidados() {
        System.out.println(conjuntoConvidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidado conjuntoConvidado = new ConjuntoConvidado();

        System.out.println("Total de convidados: " + conjuntoConvidado.contarConvidados());

        conjuntoConvidado.adicionarConvidado("joão", 1234);
        conjuntoConvidado.adicionarConvidado("joão", 4321);
        conjuntoConvidado.adicionarConvidado("maria", 1324);
        // manuel não é adicionado por ter o mesmo código de maria
        conjuntoConvidado.adicionarConvidado("manuel", 1324);

        conjuntoConvidado.exibirConvidados();
        System.out.println("Total de convidados: " + conjuntoConvidado.contarConvidados());

        conjuntoConvidado.removerConvidadoPorCodigoConvite(4321);
        conjuntoConvidado.exibirConvidados();
        System.out.println("Total de convidados: " + conjuntoConvidado.contarConvidados());

    }

}
