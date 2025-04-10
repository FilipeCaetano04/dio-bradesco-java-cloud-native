public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void exibirExtrato() {
        System.out.println("=====EXTRATO CONTA POUPANÇA=====");
        exibirInfosComuns();
    }
}
