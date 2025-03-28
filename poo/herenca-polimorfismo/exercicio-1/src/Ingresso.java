public class Ingresso {
    protected double valor;
    protected String nomeFilme;
    protected boolean dublado;

    public Ingresso(double valor, String nomeFilme, boolean dublado) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    public double calcularValorReal() {
        return valor;
    }

    public void imprimirInformacoes() {
        String exibicao = dublado ? "Dublado" : "Legendado";
        System.out.println("Filme: " + nomeFilme + " (" + exibicao + ") - Valor: R$" + String.format("%.2f", calcularValorReal()));
    }

}
