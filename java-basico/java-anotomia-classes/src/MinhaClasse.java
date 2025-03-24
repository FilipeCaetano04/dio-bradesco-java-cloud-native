public class MinhaClasse {
    public static void main(String [] args) {
        System.out.println("Olá a todos! Sejam bem vindos!");

        String primeiroNome = "Filipe";
        String segundoNome = "Abner";

        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);
        System.out.println(nomeCompleto);
    }

    public static String nomeCompleto(String primeiroNome, String segundoNome) {
        return "Retorno do método: " + primeiroNome.concat(" ").concat(segundoNome);
    }
}
