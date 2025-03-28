public class IngressoMeia extends Ingresso{

    public IngressoMeia(double valor, String nomeFilme, boolean dublado) {
        super(valor, nomeFilme, dublado);
    }

    @Override
    public double calcularValorReal() {
        return valor / 2;
    }
}
