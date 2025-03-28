public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Ingresso ingresso = new Ingresso(25, "Gênio Indomável", true);
        IngressoMeia ingressoMeia = new IngressoMeia(25, "Gênio Indomável", false);
        IngressoFamilia ingressoFamilia = new IngressoFamilia(25, "Gênio Indomável", true, 4);

        ingresso.imprimirInformacoes();
        ingressoMeia.imprimirInformacoes();
        ingressoFamilia.imprimirInformacoes();
    }

}