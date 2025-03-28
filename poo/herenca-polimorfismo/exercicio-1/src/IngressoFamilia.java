public class IngressoFamilia extends Ingresso {
    private int numeroPessoas;

    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valor, nomeFilme, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double calcularValorReal() {
        double desconto = 0;
        if (numeroPessoas > 3) desconto = 0.05;

        return valor * numeroPessoas * (1 - desconto);
    }
}
