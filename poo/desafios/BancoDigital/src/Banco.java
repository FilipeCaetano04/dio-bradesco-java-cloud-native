import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nomeBanco;
    private List<Conta> listaContas;

    public Banco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
        listaContas = new ArrayList<>();
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void adicionarConta(Conta conta) {
        listaContas.add(conta);
    }

    public void listarClientes() {
        if (listaContas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
            return;
        }

        List<Cliente> listaClientesNoBanco = new ArrayList<>();
        for (Conta conta : listaContas) {
            listaClientesNoBanco.add(conta.cliente);
        }


        System.out.println("Clientes do banco: " + nomeBanco);
        System.out.println(listaClientesNoBanco);
    }
}
