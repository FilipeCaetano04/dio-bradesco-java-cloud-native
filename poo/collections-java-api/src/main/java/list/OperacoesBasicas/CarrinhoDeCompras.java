package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> carrinhoDecompras;

    public CarrinhoDeCompras() {
        carrinhoDecompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinhoDecompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        if (carrinhoDecompras.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        List<Item> itemARemover = new ArrayList<>();
        for (Item item : carrinhoDecompras) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itemARemover.add(item);
            }
        }

        carrinhoDecompras.removeAll(itemARemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;

        for (Item item : carrinhoDecompras) {
            valorTotal += (item.getPreco() * item.getQuantidade());
        }

        return valorTotal;
    }

    public void exibirItens() {
        if (carrinhoDecompras.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }
        System.out.println(carrinhoDecompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("arroz", 5.50, 5);
        carrinhoDeCompras.adicionarItem("carne", 30, 3);
        carrinhoDeCompras.adicionarItem("chocolate", 13.30, 2);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("arroz");

        System.out.println("Valor total da compra será: R$" + String.format("%.2f", carrinhoDeCompras.calcularValorTotal()));
    }
}
