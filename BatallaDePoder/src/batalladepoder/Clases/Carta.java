package batalladepoder.Clases;

public class Carta {

    private String nombre;
    private String tipo; // Fuego, Agua, Tierra, Aire
    private int poder; // Entre 1 y 100

    public Carta(String nombre, String tipo, int poder) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
    }

    // Getters
    public int getPoder() {
        return poder;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}

