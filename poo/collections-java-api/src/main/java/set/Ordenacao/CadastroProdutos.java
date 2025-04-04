package main.java.set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> conjuntoProduto;

    public CadastroProdutos() {
        conjuntoProduto = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        conjuntoProduto.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(conjuntoProduto);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(conjuntoProduto);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "produto 3", 5.50, 3);
        // produto 10 não é adicionado por já ter o seu codigo existente
        cadastroProdutos.adicionarProduto(1L, "produto 10", 10.50, 10);
        cadastroProdutos.adicionarProduto(3L, "produto 1", 10.45, 5);
        cadastroProdutos.adicionarProduto(2L, "produto 2", 3.85, 6);

        System.out.println(cadastroProdutos.conjuntoProduto);

        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
