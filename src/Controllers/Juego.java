package Controllers;

import Models.*;
import Views.*;
import java.util.ArrayList;
import java.util.List;

public class Juego {

    private static Juego instancia;
    private Partida partida;
    private boolean juegoTerminado = false;

    private Juego() {
        partida = new Partida();
    }

    public static Juego getInstance() {
        if (instancia == null)
            instancia = new Juego();
        return instancia;
    }

    public void moverSubmarino(int cantidad) {
        partida.getSubmarino().movimientoVertical(cantidad);
    }
}
