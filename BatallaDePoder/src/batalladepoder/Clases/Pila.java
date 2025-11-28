package batalladepoder.Clases;

public class Pila {
    private NodoPila tope;

    private static class NodoPila {
        Carta carta;
        NodoPila siguiente;

        public NodoPila(Carta carta) {
            this.carta = carta;
            this.siguiente = null;
        }
    }

    public void push(Carta carta) {
        NodoPila nuevoNodo = new NodoPila(carta);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public Carta pop() {
        if (tope == null) return null;
        Carta carta = tope.carta;
        tope = tope.siguiente;
        return carta;
    }

    public void mostrar() {
        NodoPila temp = tope;
        if (temp == null) {
            System.out.println("No hay cartas derrotadas");
            return;
        }
        int contador = 1;
        while (temp != null) {
            System.out.println("  " + contador + ". " + temp.carta);
            temp = temp.siguiente;
            contador++;
        }
    }

    // Nuevo método para ver el top sin sacarlo
    public Carta peek() {
        if (tope == null) return null;
        return tope.carta;
    }
}
