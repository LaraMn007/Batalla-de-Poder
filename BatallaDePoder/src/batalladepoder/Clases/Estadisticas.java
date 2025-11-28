/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RT5
 */
import java.util.Queue;
import java.util.LinkedList;

public class Estadisticas {
    private int cartasJugadas;
    private int cartasGanadas;
    private int poderAcumulado;
    private int rondasGanadas;

    public int getCartasJugadas() {
        return cartasJugadas;
    }

    public void setCartasJugadas(int cartasJugadas) {
        this.cartasJugadas = cartasJugadas;
    }

    public int getCartasGanadas() {
        return cartasGanadas;
    }

    public void setCartasGanadas(int cartasGanadas) {
        this.cartasGanadas = cartasGanadas;
    }

    public int getPoderAcumulado() {
        return poderAcumulado;
    }

    public void setPoderAcumulado(int poderAcumulado) {
        this.poderAcumulado = poderAcumulado;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
    }

    public Estadisticas() {
        this.cartasJugadas = 0;
        this.cartasGanadas = 0;
        this.poderAcumulado = 0;
        this.rondasGanadas = 0;
    }
}


