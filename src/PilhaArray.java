public class PilhaArray {
    private final int[] elementos;
    private int topo;

    public PilhaArray(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade da pilha deve ser maior que zero.");
        }

        this.elementos = new int[capacidade];
        this.topo = -1;
    }

    // O topo sempre aponta para a última posição ocupada da pilha.
    public boolean push(int valor) {
        if (isFull()) {
            return false;
        }

        topo++;
        elementos[topo] = valor;
        return true;
    }

    // Como a pilha segue a regra LIFO, removemos sempre o elemento do topo.
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }

        int valorRemovido = elementos[topo];
        elementos[topo] = 0;
        topo--;
        return valorRemovido;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }

    public void clear() {
        while (!isEmpty()) {
            elementos[topo] = 0;
            topo--;
        }
    }

    public int size() {
        return topo + 1;
    }

    public int capacity() {
        return elementos.length;
    }

    public int getTopIndex() {
        return topo;
    }

    public boolean isSlotOccupied(int indice) {
        return indice >= 0 && indice <= topo;
    }

    public int getValueAt(int indice) {
        return elementos[indice];
    }

    public String display() {
        if (isEmpty()) {
            return "Pilha vazia.";
        }

        StringBuilder builder = new StringBuilder("Base -> ");
        for (int i = 0; i <= topo; i++) {
            builder.append("[").append(elementos[i]).append("]");

            if (i < topo) {
                builder.append(" ");
            }
        }

        builder.append(" <- Topo");
        return builder.toString();
    }
}
