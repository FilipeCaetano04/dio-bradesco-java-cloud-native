package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueMap;

    public EstoqueProdutos() {
        estoqueMap = new HashMap<>();
    }

    public void adicionarProduto(Long codigo, String nome, double preco, int quantidade) {
        estoqueMap.put(codigo, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueMap);
    }

    public double calcularValorTotalEstoque() {
        if (estoqueMap.isEmpty()) {
            System.out.println("Estoque vazio!");
            return 0;
        }

        double valorTotal = 0;
        for (Produto produto : estoqueMap.values()) {
            valorTotal += (produto.getPreco()) * produto.getQuantidade();
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        if (estoqueMap.isEmpty()) {
            System.out.println("Estoque vazio!");
            return null;
        }

        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for (Produto produto : estoqueMap.values()) {
            if (produto.getPreco() > maiorPreco) {
                maiorPreco = produto.getPreco();
                produtoMaisCaro = produto;
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        if (estoqueMap.isEmpty()) {
            System.out.println("Estoque vazio!");
            return null;
        }

        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Produto produto : estoqueMap.values()) {
            if (produto.getPreco() < menorPreco) {
                menorPreco = produto.getPreco();
                produtoMaisBarato = produto;
            }
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorValorTotalNoEstoque() {
        if (estoqueMap.isEmpty()) {
            System.out.println("Estoque vazio!");
            return null;
        }

        Produto produtoMaiorValorTotal = null;
        double valorTotal = Double.MIN_VALUE;
        for (Produto produto : estoqueMap.values()) {
            if (produto.getPreco() * produto.getQuantidade() > valorTotal) {
                valorTotal += (produto.getPreco() * produto.getQuantidade());
                produtoMaiorValorTotal = produto;
            }
        }

        return produtoMaiorValorTotal;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "produto 1", 30d, 1);
        estoqueProdutos.adicionarProduto(2L, "produto 2", 10d, 2);
        estoqueProdutos.adicionarProduto(3L, "produto 3", 4d, 3);
        estoqueProdutos.adicionarProduto(4L, "produto 4", 5d, 10);

        estoqueProdutos.exibirProdutos();

        System.out.println("Valor total de estoque: R$" + String.format("%.2f", estoqueProdutos.calcularValorTotalEstoque()));
        System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("Produto com maior valor total no estoque: " + estoqueProdutos.obterProdutoMaiorValorTotalNoEstoque());
    }
}
