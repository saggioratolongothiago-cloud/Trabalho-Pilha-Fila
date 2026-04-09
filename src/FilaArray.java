public class FilaArray {
    private final int[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;

    public FilaArray(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade da fila deve ser maior que zero.");
        }

        this.elementos = new int[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
    }

    // Em fila circular, o fim avança e volta ao início usando o operador de módulo.
    public boolean enqueue(int valor) {
        if (isFull()) {
            return false;
        }

        elementos[fim] = valor;
        fim = (fim + 1) % elementos.length;
        quantidade++;
        return true;
    }

    // Como a fila segue FIFO, a remoção acontece sempre na posição de início.
    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }

        int valorRemovido = elementos[inicio];
        elementos[inicio] = 0;
        inicio = (inicio + 1) % elementos.length;
        quantidade--;

        if (quantidade == 0) {
            inicio = 0;
            fim = 0;
        }

        return valorRemovido;
    }

    public Integer front() {
        if (isEmpty()) {
            return null;
        }

        return elementos[inicio];
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

    public boolean isFull() {
        return quantidade == elementos.length;
    }

    public void clear() {
        while (!isEmpty()) {
            elementos[inicio] = 0;
            inicio = (inicio + 1) % elementos.length;
            quantidade--;
        }

        inicio = 0;
        fim = 0;
    }

    public int size() {
        return quantidade;
    }

    public int capacity() {
        return elementos.length;
    }

    public int getInicioIndex() {
        return inicio;
    }

    public int getFimIndex() {
        return fim;
    }

    public boolean isSlotOccupied(int indice) {
        if (isEmpty() || indice < 0 || indice >= elementos.length) {
            return false;
        }

        for (int deslocamento = 0; deslocamento < quantidade; deslocamento++) {
            int posicaoAtual = (inicio + deslocamento) % elementos.length;
            if (posicaoAtual == indice) {
                return true;
            }
        }

        return false;
    }

    public int getValueAt(int indice) {
        return elementos[indice];
    }

    public String display() {
        if (isEmpty()) {
            return "Fila vazia.";
        }

        StringBuilder builder = new StringBuilder("Início -> ");
        for (int deslocamento = 0; deslocamento < quantidade; deslocamento++) {
            int indiceAtual = (inicio + deslocamento) % elementos.length;
            builder.append("[").append(elementos[indiceAtual]).append("]");

            if (deslocamento < quantidade - 1) {
                builder.append(" ");
            }
        }

        builder.append(" <- Fim");
        return builder.toString();
    }
}
