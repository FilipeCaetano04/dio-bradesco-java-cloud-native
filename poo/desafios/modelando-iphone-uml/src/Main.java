public class Main {
    public static void main(String[] args) {
        Iphone meuIphone = new Iphone();

        meuIphone.exibirPagina("https://www.youtube.com/");
        meuIphone.atualizarPagina();
        meuIphone.adicionarNovaAba();

        System.out.println();

        meuIphone.selecionarMusica("Everlong - Foo Fighters");
        meuIphone.tocar();
        meuIphone.pausar();

        System.out.println();

        meuIphone.ligar("(85) 99999-9999");
        meuIphone.iniciarCorreioVoz();
        meuIphone.atender();

    }
}