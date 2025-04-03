package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPoIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Nome 1", 18, 1.65);
        ordenacaoPessoas.adicionarPessoa("Nome 2", 10, 1.30);
        ordenacaoPessoas.adicionarPessoa("Nome 3", 20, 1.85);
        ordenacaoPessoas.adicionarPessoa("Nome 4", 40, 1.75);
        ordenacaoPessoas.adicionarPessoa("Nome 5", 19, 1.90);

        System.out.println(ordenacaoPessoas.ordenarPoIdade());

        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }

}
