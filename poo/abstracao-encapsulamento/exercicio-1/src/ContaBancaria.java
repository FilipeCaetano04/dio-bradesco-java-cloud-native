public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        this.chequeEspecial = (depositoInicial > 500) ? 0.5 * depositoInicial : 50;
        this.chequeEspecialUsado = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return chequeEspecial;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido de depósito!");
            return;
        }

        saldo += valor;
        if (chequeEspecialUsado > 0) {
            // taxa de 20% caso esteja usando cheque especial
            double taxa = 0.2 * chequeEspecialUsado;
            double totalDevido = chequeEspecialUsado + taxa;

            if (saldo >= totalDevido) {
                saldo -= totalDevido;
                chequeEspecialUsado = 0;
            } else {
                // escolha da implementação
                // se saldo não cobrir os 20% a mais, o saldo paga o que for possível do total devido.
                chequeEspecialUsado = totalDevido - saldo;
                saldo -= saldo;
            }
        }

        System.out.println("Depósito realizado. Salto atual: R$" + saldo + ". Cheque especial usado restante: R$" + chequeEspecialUsado);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido de saque!");
            return;
        }

        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado. Saldo atual: R$" + saldo);
        } else if (saldo + (chequeEspecial - chequeEspecialUsado) >= valor) {
            chequeEspecialUsado = valor - saldo;
            saldo = 0;
            System.out.println("Saque realizado com cheque especial. Saldo R$0. Cheque especial usado: R$" + chequeEspecialUsado);
        }
        else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void pagarBoleto(double valor) {
        sacar(valor);
    }

    public boolean usandoChequeEspecial() {
        return chequeEspecialUsado > 0;
    }
}
