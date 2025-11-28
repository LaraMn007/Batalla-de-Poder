package batalladepoder.Clases;

public class Cola {
    private Nodo frente, fin;

    public void encolar(Carta carta) {
        Nodo nuevoNodo = new Nodo(carta);
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
        Nodo temp = frente;
        while (temp != null) {
            count++;
            temp = temp.siguiente;
        }
        return count;
    }
}
