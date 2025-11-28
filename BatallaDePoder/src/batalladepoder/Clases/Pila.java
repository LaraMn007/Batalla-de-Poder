package batalladepoder.Clases;

public class Pila {
    private Nodo tope;

    public void push(Carta carta) {
        Nodo nuevoNodo = new Nodo(carta);
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
        Nodo temp = tope;
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
