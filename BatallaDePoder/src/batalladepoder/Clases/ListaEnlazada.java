/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoguii;

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

    
}
