/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalladepoder.Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aldai
 */
public class ListaEnlazada {
     private Nodo cabeza;

    

    public void agregar(Carta carta) {
        Nodo nuevoNodo = new Nodo(carta);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public Carta obtenerAleatoria() {
        List<Carta> cartas = new ArrayList<>();
        Nodo temp = cabeza;
        while (temp != null) {
            cartas.add(temp.carta);
            temp = temp.siguiente;
        }
        return cartas.get(new Random().nextInt(cartas.size()));
    }

    public int tamaño() {
        int count = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            count++;
            temp = temp.siguiente;
        }
        return count;
    }
}