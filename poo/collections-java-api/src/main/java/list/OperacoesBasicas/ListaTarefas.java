package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> listaTarefas;

    public  ListaTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasARemover = new ArrayList<>();

        if (!listaTarefas.isEmpty()) {
            for (Tarefa tarefa : listaTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefasARemover.add(tarefa);
                }
            }
            listaTarefas.removeAll(tarefasARemover);
            return;
        }

        System.out.println("Lista vazia!");
    }

    public int obterNumeroTotalTarefas() {
        return listaTarefas.size();
    }

    public void obterDescricoesTarefas() {
        if (!listaTarefas.isEmpty()) {
            System.out.println(listaTarefas);
            return;
        }
        System.out.println("Lista vazia!");
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas1 = new ListaTarefas();

        System.out.println("Total de tarefas: " + listaTarefas1.obterNumeroTotalTarefas());
        listaTarefas1.obterDescricoesTarefas();

        listaTarefas1.adicionarTarefa("Comprar comida");
        listaTarefas1.adicionarTarefa("Limpar o quarto");

        System.out.println("Total de tarefas: " + listaTarefas1.obterNumeroTotalTarefas());
        listaTarefas1.obterDescricoesTarefas();

        listaTarefas1.adicionarTarefa("Limpar a casa");
        listaTarefas1.adicionarTarefa("Ir a academia");

        System.out.println("Total de tarefas: " + listaTarefas1.obterNumeroTotalTarefas());
        listaTarefas1.obterDescricoesTarefas();

        listaTarefas1.removerTarefa("limpar o quarto");
        listaTarefas1.removerTarefa("comprar comida");

        System.out.println("Total de tarefas: " + listaTarefas1.obterNumeroTotalTarefas());
        listaTarefas1.obterDescricoesTarefas();

    }
}
