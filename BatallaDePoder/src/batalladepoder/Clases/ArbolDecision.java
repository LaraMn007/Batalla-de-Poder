/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalladepoder.Clases;

/**
 *
 * @author aldai
 */
public class ArbolDecision {
     private NodoArbol raiz;

    

    public void construirArbol() {
        raiz = new NodoArbol("¿Carta jugador > 80 de poder?");
        raiz.si = new NodoArbol("¿Tipo débil?");
        raiz.no = new NodoArbol("Jugar carta fuerte");
        
        raiz.si.si = new NodoArbol("Jugar carta media");
        raiz.si.no = new NodoArbol("Jugar carta fuerte");
    }

    public boolean decidir(Carta cartaJugador, Carta cartaMedia, Carta cartaFuerte) {
        return evaluar(raiz, cartaJugador, cartaMedia, cartaFuerte);
    }

    private boolean evaluar(NodoArbol nodo, Carta cartaJugador, Carta poderMedio, Carta poderFuerte) {
        if (nodo.pregunta.equals("¿Carta jugador > 80 de poder?")) {
            return cartaJugador.getPoder() > 80 ? 
                evaluar(nodo.si, cartaJugador, poderMedio, poderFuerte) : 
                evaluar(nodo.no, cartaJugador, poderMedio, poderFuerte);
        } else if (nodo.pregunta.equals("¿Tipo débil?")) {
            return esTipoDebil(cartaJugador) ? 
                evaluar(nodo.si, cartaJugador, poderMedio, poderFuerte) : 
                evaluar(nodo.no, cartaJugador, poderMedio, poderFuerte);
        } else if (nodo.pregunta.equals("Jugar carta media")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean esTipoDebil(Carta carta) {
        return carta.getTipo().equals("Agua"); 
    }
}
