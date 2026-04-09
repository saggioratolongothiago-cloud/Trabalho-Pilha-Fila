import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleUI.printWelcome();

        int capacidadePilha = readPositiveInt("Informe a capacidade da pilha: ");
        int capacidadeFila = readPositiveInt("Informe a capacidade da fila: ");

        PilhaArray pilha = new PilhaArray(capacidadePilha);
        FilaArray fila = new FilaArray(capacidadeFila);

        runMainMenu(pilha, fila);

        SCANNER.close();
        ConsoleUI.printGoodbye();
    }

    // O menu principal controla qual estrutura o usuário quer testar.
    private static void runMainMenu(PilhaArray pilha, FilaArray fila) {
        boolean running = true;

        while (running) {
            ConsoleUI.clearScreen();
            ConsoleUI.printMainMenu(pilha, fila);

            int option = readOption("Escolha uma opção: ", 1, 3);

            switch (option) {
                case 1:
                    runStackMenu(pilha);
                    break;
                case 2:
                    runQueueMenu(fila);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    ConsoleUI.printError("Opção inválida.");
                    pause();
                    break;
            }
        }
    }

    // Aqui ficam reunidas as operações da pilha para facilitar a navegação no terminal.
    private static void runStackMenu(PilhaArray pilha) {
        boolean keepRunning = true;

        while (keepRunning) {
            ConsoleUI.clearScreen();
            ConsoleUI.printStackMenu(pilha);

            int option = readOption("Escolha uma operação da pilha: ", 1, 9);

            switch (option) {
                case 1:
                    int value = readInt("Digite o valor que será empilhado: ");
                    if (pilha.push(value)) {
                        ConsoleUI.printSuccess("Valor " + value + " empilhado com sucesso.");
                    } else {
                        ConsoleUI.printError("Não foi possível empilhar. A pilha está cheia.");
                    }
                    pause();
                    break;
                case 2:
                    Integer removed = pilha.pop();
                    if (removed != null) {
                        ConsoleUI.printSuccess("Valor removido do topo: " + removed + ".");
                    } else {
                        ConsoleUI.printError("Não foi possível desempilhar. A pilha está vazia.");
                    }
                    pause();
                    break;
                case 3:
                    Integer top = pilha.peek();
                    if (top != null) {
                        ConsoleUI.printInfo("TOPO DA PILHA", "O elemento no topo é: " + top + ".");
                    } else {
                        ConsoleUI.printError("A pilha está vazia. Não existe topo para mostrar.");
                    }
                    pause();
                    break;
                case 4:
                    ConsoleUI.printInfo("PILHA VAZIA?", pilha.isEmpty() ? "Sim. Nenhum elemento armazenado." : "Não. Ainda existem elementos na pilha.");
                    pause();
                    break;
                case 5:
                    ConsoleUI.printInfo("PILHA CHEIA?", pilha.isFull() ? "Sim. Nenhum novo elemento pode ser inserido." : "Não. Ainda há espaço disponível.");
                    pause();
                    break;
                case 6:
                    ConsoleUI.printInfo("ELEMENTOS DA PILHA", pilha.display());
                    pause();
                    break;
                case 7:
                    pilha.clear();
                    ConsoleUI.printSuccess("Todos os elementos da pilha foram removidos.");
                    pause();
                    break;
                case 8:
                    ConsoleUI.printInfo("QUANTIDADE ATUAL", "A pilha possui " + pilha.size() + " elemento(s) de um total de " + pilha.capacity() + ".");
                    pause();
                    break;
                case 9:
                    keepRunning = false;
                    break;
                default:
                    ConsoleUI.printError("Opção inválida.");
                    pause();
                    break;
            }
        }
    }

    // O menu da fila destaca a regra FIFO e mostra os índices de início e fim.
    private static void runQueueMenu(FilaArray fila) {
        boolean keepRunning = true;

        while (keepRunning) {
            ConsoleUI.clearScreen();
            ConsoleUI.printQueueMenu(fila);

            int option = readOption("Escolha uma operação da fila: ", 1, 9);

            switch (option) {
                case 1:
                    int value = readInt("Digite o valor que será inserido na fila: ");
                    if (fila.enqueue(value)) {
                        ConsoleUI.printSuccess("Valor " + value + " inserido na fila com sucesso.");
                    } else {
                        ConsoleUI.printError("Não foi possível inserir. A fila está cheia.");
                    }
                    pause();
                    break;
                case 2:
                    Integer removed = fila.dequeue();
                    if (removed != null) {
                        ConsoleUI.printSuccess("Valor removido da frente da fila: " + removed + ".");
                    } else {
                        ConsoleUI.printError("Não foi possível remover. A fila está vazia.");
                    }
                    pause();
                    break;
                case 3:
                    Integer front = fila.front();
                    if (front != null) {
                        ConsoleUI.printInfo("PRIMEIRO ELEMENTO", "O primeiro elemento da fila é: " + front + ".");
                    } else {
                        ConsoleUI.printError("A fila está vazia. Não existe elemento na frente.");
                    }
                    pause();
                    break;
                case 4:
                    ConsoleUI.printInfo("FILA VAZIA?", fila.isEmpty() ? "Sim. Nenhum elemento armazenado." : "Não. Ainda existem elementos na fila.");
                    pause();
                    break;
                case 5:
                    ConsoleUI.printInfo("FILA CHEIA?", fila.isFull() ? "Sim. Nenhum novo elemento pode ser inserido." : "Não. Ainda há espaço disponível.");
                    pause();
                    break;
                case 6:
                    ConsoleUI.printInfo("ELEMENTOS DA FILA", fila.display());
                    pause();
                    break;
                case 7:
                    fila.clear();
                    ConsoleUI.printSuccess("Todos os elementos da fila foram removidos.");
                    pause();
                    break;
                case 8:
                    ConsoleUI.printInfo("QUANTIDADE ATUAL", "A fila possui " + fila.size() + " elemento(s) de um total de " + fila.capacity() + ".");
                    pause();
                    break;
                case 9:
                    keepRunning = false;
                    break;
                default:
                    ConsoleUI.printError("Opção inválida.");
                    pause();
                    break;
            }
        }
    }

    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);
            if (value > 0) {
                return value;
            }

            ConsoleUI.printError("Digite um número inteiro maior que zero.");
            pause();
            ConsoleUI.clearScreen();
            ConsoleUI.printWelcome();
        }
    }

    // A leitura sempre é feita por linha inteira para evitar erros comuns do Scanner no console.
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String line = SCANNER.nextLine().trim();

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException exception) {
                ConsoleUI.printError("Entrada inválida. Digite apenas números inteiros.");
            }
        }
    }

    private static int readOption(String message, int min, int max) {
        while (true) {
            int option = readInt(message);
            if (option >= min && option <= max) {
                return option;
            }

            ConsoleUI.printError("Escolha uma opção entre " + min + " e " + max + ".");
        }
    }

    private static void pause() {
        System.out.print("Pressione Enter para continuar...");
        SCANNER.nextLine();
    }
}

final class ConsoleUI {
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String WHITE = "\u001B[37m";
    private static final int WIDTH = 88;

    private ConsoleUI() {
    }

    public static void clearScreen() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void printWelcome() {
        clearScreen();
        printBox("LABORATÓRIO DE PILHA E FILA", new String[] {
            "Projeto didático em Java com implementação manual usando arrays.",
            "Menu interativo com visual destacado para facilitar a demonstração no vídeo."
        }, CYAN);
    }

    public static void printMainMenu(PilhaArray pilha, FilaArray fila) {
        printBox("MENU PRINCIPAL", new String[] {
            "Escolha qual estrutura deseja explorar.",
            "",
            formatStatusLine("Pilha", pilha.size(), pilha.capacity(), pilha.isEmpty() ? "Topo: vazio" : "Topo: " + pilha.peek()),
            formatStatusLine("Fila ", fila.size(), fila.capacity(), fila.isEmpty() ? "Frente: vazia" : "Frente: " + fila.front()),
            "",
            "1. Entrar na Pilha",
            "2. Entrar na Fila",
            "3. Sair"
        }, BLUE);
    }

    public static void printStackMenu(PilhaArray pilha) {
        printBox("MENU DA PILHA", new String[] {
            "LIFO: o último elemento que entra é o primeiro que sai.",
            "",
            "Resumo: " + formatUsage(pilha.size(), pilha.capacity()),
            "Estado lógico: " + pilha.display(),
            "Memória interna: " + renderStackSlots(pilha),
            "Índices         : " + renderIndexes(pilha.capacity()),
            "",
            "1. Empilhar elemento",
            "2. Desempilhar elemento",
            "3. Visualizar topo",
            "4. Verificar se está vazia",
            "5. Verificar se está cheia",
            "6. Exibir todos os elementos",
            "7. Limpar pilha",
            "8. Mostrar quantidade de elementos",
            "9. Voltar ao menu principal"
        }, GREEN);
    }

    public static void printQueueMenu(FilaArray fila) {
        printBox("MENU DA FILA", new String[] {
            "FIFO: o primeiro elemento que entra é o primeiro que sai.",
            "",
            "Resumo: " + formatUsage(fila.size(), fila.capacity()),
            "Estado lógico: " + fila.display(),
            "Memória interna: " + renderQueueSlots(fila),
            "Índices         : " + renderIndexes(fila.capacity()),
            "Controle        : início=" + fila.getInicioIndex() + " | fim=" + fila.getFimIndex() + " (próxima inserção)",
            "",
            "1. Inserir elemento na fila",
            "2. Remover elemento da fila",
            "3. Visualizar primeiro elemento",
            "4. Verificar se está vazia",
            "5. Verificar se está cheia",
            "6. Exibir todos os elementos",
            "7. Limpar fila",
            "8. Mostrar quantidade de elementos",
            "9. Voltar ao menu principal"
        }, YELLOW);
    }

    public static void printSuccess(String mensagem) {
        printBox("OPERAÇÃO CONCLUÍDA", new String[] { mensagem }, GREEN);
    }

    public static void printError(String mensagem) {
        printBox("ATENÇÃO", new String[] { mensagem }, RED);
    }

    public static void printInfo(String titulo, String mensagem) {
        printBox(titulo, new String[] { mensagem }, WHITE);
    }

    public static void printGoodbye() {
        printBox("ENCERRANDO", new String[] {
            "Projeto finalizado.",
            "Boa gravação do vídeo e sucesso na apresentação."
        }, CYAN);
    }

    private static void printBox(String title, String[] lines, String color) {
        String border = "+" + "-".repeat(WIDTH - 2) + "+";
        System.out.println(color + border + RESET);
        System.out.println(color + "|" + RESET + padCenter(BOLD + title + RESET, WIDTH - 2) + color + "|" + RESET);
        System.out.println(color + border + RESET);

        for (String line : lines) {
            printWrappedLine(line, color);
        }

        System.out.println(color + border + RESET);
        System.out.println();
    }

    private static void printWrappedLine(String line, String color) {
        int contentWidth = WIDTH - 2;

        if (line == null || line.isEmpty()) {
            System.out.println(color + "|" + RESET + " ".repeat(contentWidth) + color + "|" + RESET);
            return;
        }

        int start = 0;
        while (start < line.length()) {
            int end = Math.min(line.length(), start + contentWidth);

            if (end < line.length()) {
                int lastSpace = line.lastIndexOf(' ', end);
                if (lastSpace > start) {
                    end = lastSpace;
                }
            }

            String chunk = line.substring(start, end).trim();
            if (chunk.isEmpty()) {
                chunk = line.substring(start, Math.min(line.length(), start + contentWidth));
                end = Math.min(line.length(), start + contentWidth);
            }

            System.out.println(color + "|" + RESET + padRight(chunk, contentWidth) + color + "|" + RESET);
            start = end;

            while (start < line.length() && line.charAt(start) == ' ') {
                start++;
            }
        }
    }

    private static String formatStatusLine(String nome, int size, int capacity, String detalhe) {
        return nome + " -> " + formatUsage(size, capacity) + " | " + detalhe;
    }

    private static String formatUsage(int size, int capacity) {
        return size + "/" + capacity + " " + renderBar(size, capacity);
    }

    private static String renderBar(int valorAtual, int capacidade) {
        if (capacidade <= 0) {
            return "[sem capacidade]";
        }

        int largura = Math.min(capacidade, 20);
        int preenchido = (int) Math.round((valorAtual * largura) / (double) capacidade);
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < largura; i++) {
            builder.append(i < preenchido ? "#" : "-");
        }

        builder.append("]");
        return builder.toString();
    }

    private static String renderStackSlots(PilhaArray pilha) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < pilha.capacity(); i++) {
            if (pilha.isSlotOccupied(i)) {
                builder.append("[").append(pilha.getValueAt(i)).append("]");
            } else {
                builder.append("[ ]");
            }

            if (i == pilha.getTopIndex()) {
                builder.append("<-topo");
            }

            if (i < pilha.capacity() - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    private static String renderQueueSlots(FilaArray fila) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < fila.capacity(); i++) {
            if (fila.isSlotOccupied(i)) {
                builder.append("[").append(fila.getValueAt(i)).append("]");
            } else {
                builder.append("[ ]");
            }

            if (!fila.isEmpty() && i == fila.getInicioIndex()) {
                builder.append("<-início");
            }

            if (i == fila.getFimIndex()) {
                builder.append("<-fim");
            }

            if (i < fila.capacity() - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    private static String renderIndexes(int capacidade) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < capacidade; i++) {
            builder.append("[").append(i).append("]");
            if (i < capacidade - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static String padCenter(String value, int width) {
        String cleanValue = stripAnsi(value);
        int difference = width - cleanValue.length();

        if (difference <= 0) {
            return value;
        }

        int left = difference / 2;
        int right = difference - left;
        return " ".repeat(left) + value + " ".repeat(right);
    }

    private static String padRight(String value, int width) {
        String cleanValue = stripAnsi(value);

        if (cleanValue.length() >= width) {
            return value;
        }

        return value + " ".repeat(width - cleanValue.length());
    }

    private static String stripAnsi(String value) {
        return value.replace(RESET, "")
            .replace(BOLD, "")
            .replace(CYAN, "")
            .replace(GREEN, "")
            .replace(YELLOW, "")
            .replace(RED, "")
            .replace(BLUE, "")
            .replace(WHITE, "");
    }
}
