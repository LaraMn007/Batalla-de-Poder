package batalladepoder.Clases;

public class Cola {
    private NodoCola frente, fin;

    private static class NodoCola {
        Carta carta;
        NodoCola siguiente;

        public NodoCola(Carta carta) {
            this.carta = carta;
            this.siguiente = null;
        }
    }

    public void encolar(Carta carta) {
        NodoCola nuevoNodo = new NodoCola(carta);
        if (fin == null) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public Carta desencolar() {
        if (frente == null) return null;
        Carta carta = frente.carta;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return carta;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int tamaño() {
        int count = 0;
        NodoCola temp = frente;
        while (temp != null) {
            count++;
            temp = temp.siguiente;
        }
        return count;
    }
}
