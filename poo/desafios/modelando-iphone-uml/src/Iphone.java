public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    private String musicaAtual;

    @Override
    public void ligar(String numero) {
        System.out.println("Efetuando chamada para " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo chamada...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a seguinte página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba...");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando página...");
    }

    @Override
    public void tocar() {
        if (musicaAtual.isEmpty()) {
            System.out.println("Nenhuma música selecionada!");
            return;
        }
        System.out.println("Tocando música: \"" + musicaAtual + "\"!");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando música...");
    }

    @Override
    public void selecionarMusica(String musicaNova) {
        musicaAtual = musicaNova;
        System.out.println("Música selecionada: " + musicaAtual);
    }
}
