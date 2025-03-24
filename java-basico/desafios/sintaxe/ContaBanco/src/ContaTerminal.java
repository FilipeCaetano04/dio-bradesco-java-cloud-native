import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Define o local de scanner para aceitar '.' como representação decimal

        int agencia;
        String numeroConta;
        String nomeCliente;
        double saldo;

        System.out.println("Por favor, informe as informações necessárias!");

        System.out.println("Digite o número da Agência!");
        agencia = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite o número da Conta!");
        numeroConta = scanner.nextLine();

        System.out.println("Digite o nome do Cliente!");
        nomeCliente = scanner.nextLine();

        System.out.println("Digite o Saldo da conta!");
        saldo = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, " +
                           "sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo "  +
                            saldo + " já está disponível para saque.");

    }
}
