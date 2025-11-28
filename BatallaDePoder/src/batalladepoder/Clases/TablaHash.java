/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalladepoder.Clases;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aldai
 */



public class TablaHash {
    private Map<String, Estadisticas> tabla;

    public TablaHash() {
        tabla = new HashMap<>();
    }

    public void agregarEstadisticas(String jugador, Estadisticas stats) {
        tabla.put(jugador, stats);
    }

    public Estadisticas obtenerEstadisticas(String jugador) {
        return tabla.get(jugador);
    }
}
