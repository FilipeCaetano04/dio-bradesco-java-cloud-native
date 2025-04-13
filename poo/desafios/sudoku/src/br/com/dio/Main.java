package br.com.dio;

import br.com.dio.model.Board;
import br.com.dio.model.Space;
import br.com.dio.util.BoardTemplate;

import java.util.*;
import java.util.stream.Stream;

import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));

        int option = -1;
        while (true) {
            System.out.println(
                    """
                            Selecione uma das opções a seguir: 
                            1 - Iniciar um novo Jogo
                            2 - Colocar um novo núemro
                            3 - Remover um número
                            4 - Visualizar jogo atual
                            5 - Verificar status atual
                            6 - Limpar jogo
                            7 - Finalizar jogo
                            8 -Sair 
                            """);

            option = scanner.nextInt();
            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida!");
            }

        }
    }

    private static void startGame(Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado!");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; ++i) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; ++j) {
                var positionsConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionsConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionsConfig.split(",")[1]);
                var currentSpace = new Space(fixed, expected);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar!");
    }


    private static void inputNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("Informe a coluna em que o número será inserido: ");
        int col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o número será inserido: ");
        int row = runUntilGetValidNumber(0, 8);
        System.out.printf("Informe o número que entrará na posição: [%s][%s]\n", col, row);
        int value = runUntilGetValidNumber(1, 9);

        if (!board.changeValue(col, row, value)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo!\n", col, row);
        }
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("Informe a coluna em que o número será removido: ");
        int col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o número será removido: ");
        int row = runUntilGetValidNumber(0, 8);

        if (!board.clearValue(col, row)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo!\n", col, row);
        }
    }

    private static void showCurrentGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; ++i) {
            for (var col : board.getSpaces()) {
                args[argPos++] = " " + (isNull(col.get(i).getActual()) ? " " : col.get(i).getActual());
            }
        }

        System.out.println("Seu jogo se encontra da seguinte forma: ");
        System.out.printf((BOARD_TEMPLATE) + "\n", args);
    }

    private static void showGameStatus() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.printf("O status atual do jogo é %s\n", board.getStatus().getLabel());
        if (board.hasErrors()) {
            System.out.println("O jogo contém erros!");
        } else {
            System.out.println("O jogo não contém erros!");
        }
    }

    private static void clearGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("Tem certeza que deseja limpar o jogo e perder seu progresso?");

        String confirm = scanner.next();
        while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não")) {
            System.out.println("Informe 'sim' ou 'não'");
            confirm = scanner.next();
        }

        if (confirm.equalsIgnoreCase("sim")) {
            board.reset();
        }
    }

    private static void finishGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        if (board.gameIsFinished()) {
            System.out.println("Parabéns, você concluiu o jogo!");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Seu jogo contém erros, verifique seu tabuleiro e ajuste-o");
        } else {
            System.out.println("Você ainda precisa preencher algum espaço");
        }
    }

    private static int runUntilGetValidNumber(int min, int max) {
        int currentNumber = scanner.nextInt();
        while (currentNumber < min || currentNumber > max) {
            currentNumber = scanner.nextInt();
        }
        return currentNumber;
    }

}