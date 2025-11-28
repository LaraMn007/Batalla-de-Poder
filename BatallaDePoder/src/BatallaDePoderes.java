
import batalladepoder.Clases.*;
import java.util.*;

public class BatallaDePoderes {
    private Cola mazoJugador, mazoCPU;
    private Pila derrotadasJugador, derrotadasCPU;
    private Scanner scanner;

    public BatallaDePoderes() {
        mazoJugador = new Cola();
        mazoCPU = new Cola();
        derrotadasJugador = new Pila();
        derrotadasCPU = new Pila();
        scanner = new Scanner(System.in);
        inicializarBaraja();
    }

    private void inicializarBaraja() {
        String[] tipos = {"Fuego", "Agua", "Tierra", "Aire"};
        String[] nombresFuego = {"Fenix", "Salamandra", "Dragon", "Ifrit"};
        String[] nombresAgua = {"Sirena", "Leviatan", "Kraken", "Poseidon"};
        String[] nombresTierra = {"Golem", "Titan", "Gnomo", "Guardian"};
        String[] nombresAire = {"Fenix", "Harpia", "Griffin", "Zeus"};
        
        Random rand = new Random();
        
        for (int i = 0; i < 10; i++) {
            for (String tipo : tipos) {
                String nombre = "";
                switch (tipo) {
                    case "Fuego": nombre = nombresFuego[rand.nextInt(nombresFuego.length)]; break;
                    case "Agua": nombre = nombresAgua[rand.nextInt(nombresAgua.length)]; break;
                    case "Tierra": nombre = nombresTierra[rand.nextInt(nombresTierra.length)]; break;
                    case "Aire": nombre = nombresAire[rand.nextInt(nombresAire.length)]; break;
                }
                nombre += " de " + tipo;
                int poder = rand.nextInt(80) + 20;
                barajaPrincipal.agregar(new Carta(nombre, tipo, poder));
            }
        }
    }

    private void repartirCartas() {
        for (int i = 0; i < 10; i++) {
            mazoJugador.encolar(barajaPrincipal.obtenerAleatoria());
            mazoCPU.encolar(barajaPrincipal.obtenerAleatoria());
        }
    }

    public void jugar() {
        System.out.println("Bienvenido a Batalla de Poderes");
        System.out.print("Ingrese su nombre: ");
        String nombreJugador = scanner.nextLine();

        repartirCartas();
        System.out.println("Se reparten cartas...");
        System.out.println("Tu mazo tiene " + mazoJugador.tamaño() + " cartas.");
        System.out.println("El oponente CPU tambien tiene " + mazoCPU.tamaño() + " cartas.");

        Estadisticas statsJugador = new Estadisticas();
        Estadisticas statsCPU = new Estadisticas();

        int rondas = 1;
        while (!mazoJugador.estaVacia() && !mazoCPU.estaVacia() && rondas <= 10) {
            System.out.println(" Ronda " + rondas );
            
            Carta cartaJugador = mazoJugador.desencolar();
            Carta cartaCPU = elegirCartaCPU(cartaJugador);
            
            statsJugador.setCartasJugadas(statsJugador.getCartasJugadas()+1);
            statsCPU.setCartasJugadas(statsCPU.getCartasJugadas()+1);
            statsJugador.setPoderAcumulado(statsJugador.getPoderAcumulado()+1);
            statsCPU.setPoderAcumulado(statsCPU.getPoderAcumulado()+1);
            
            System.out.println(nombreJugador + " juega: " + cartaJugador);
            System.out.println("CPU juega: " + cartaCPU);

            if (cartaJugador.getPoder() > cartaCPU.getPoder()) {
                System.out.println("Ganador de la ronda: " + nombreJugador);
                
                statsJugador.setRondasGanadas(statsJugador.getRondasGanadas()+1);
                statsJugador.setCartasGanadas(statsJugador.getCartasGanadas()+1);
                mazoJugador.encolar(cartaJugador);
                derrotadasCPU.push(cartaCPU);
            } else if (cartaCPU.getPoder() > cartaJugador.getPoder()) {
                System.out.println("Ganador de la ronda CPU");
                
                statsCPU.setRondasGanadas(statsJugador.getRondasGanadas()+1);
                statsCPU.setCartasGanadas(statsJugador.getCartasGanadas()+1);
                
                mazoCPU.encolar(cartaCPU);
                derrotadasJugador.push(cartaJugador);
            } else {
                System.out.println("Empate ambas cartas vuelven a sus mazos");
                mazoJugador.encolar(cartaJugador);
                mazoCPU.encolar(cartaCPU);
            }
            
            // Opciones después de cada ronda
            if (rondas < 10 && !mazoJugador.estaVacia() && !mazoCPU.estaVacia()) {
                mostrarMenuOpciones(nombreJugador, rondas);
            }
            
            rondas++;
        }

        mostrarResultadosFinales(nombreJugador, statsJugador, statsCPU);
    }

    private void mostrarMenuOpciones(String nombreJugador,int rondas) {
        int opcion;
        do {
            System.out.println(" Opciones ");
            System.out.println("1. Continuar a la siguiente ronda");
            System.out.println("2. Ver cementerio de cartas derrotadas");
            System.out.println("3. Ver estadisticas parciales");
            System.out.print("Elija una opcion: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                switch (opcion) {
                    case 1:
                        System.out.println("Continuando a la siguiente ronda");
                        break;
                    case 2:
                       
                        break;
                    case 3:
                        
                        break;
                    default:
                        System.out.println("Opción invalida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar buffer
                opcion = 0;
            }
        } while (opcion != 1);
    }

}
