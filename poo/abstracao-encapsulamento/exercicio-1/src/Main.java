import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Deposite um valor inicial da conta: R$");
        double depositoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(depositoInicial);
        System.out.println("Conta criada!");

        String menu = """
                ========MENU========
                [1] Consultar saldo
                [2] Consultar cheque especial
                [3] Depositar
                [4] Sacar
                [5] Pagar boleto
                [6] Verificar uso do cheque especial
                [0] Encerrar
                
                Digite sua opção: """;

        double valor;
        int opcao;

        do {
            System.out.print(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo da conta: R$" + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.println("Limite do cheque especial: R$" + conta.consultarChequeEspecial());
                    break;
                case 3:
                    System.out.print("Valor para depositar: R$");
                    valor = scanner.nextDouble();
                    conta.depositar(valor);
                    break;
                case 4:
                    System.out.print("Valor para sacar: R$");
                    valor = scanner.nextDouble();;
                    conta.sacar(valor);
                    break;
                case 5:
                    System.out.print("Valor do boleto: R$");
                    valor = scanner.nextDouble();;
                    conta.pagarBoleto(valor);
                    break;
                case 6:
                    System.out.println("Está usando cheque especial? " + conta.usandoChequeEspecial());
                    break;
                case 0:
                    System.out.println("Saindo da conta!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}