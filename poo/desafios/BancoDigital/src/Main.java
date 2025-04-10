public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Miguel");
        Cliente cliente3 = new Cliente("Gustavo");

        Banco banco = new Banco("PayPay");

        Conta contaCorrente = new ContaCorrente(cliente1);
        Conta contaPoupanca1 = new ContaPoupanca(cliente2);
        Conta contaPoupanca2 = new ContaPoupanca(cliente3);

        contaPoupanca1.depositar(600);
        contaPoupanca1.transferir(500, contaCorrente);

        contaCorrente.exibirExtrato();
        contaPoupanca1.exibirExtrato();

        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca1);
        banco.adicionarConta(contaPoupanca2);

        banco.listarClientes();
    }
}