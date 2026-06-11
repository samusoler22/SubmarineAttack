package Controllers;

import Models.*;
import Views.*;

public class Juego {

    private static Juego instancia;
    private Partida partida;
    private Submarino submarino;

    private Juego() {
        this.partida = new Partida();
        this.submarino = new Submarino(1, 0, 300);
    }


    public static Juego getInstance() {
        if (instancia == null)
            instancia = new Juego();
        return instancia;
    }

    public void moverSubmarinoVertical() {
        submarino.movimientoVertical();
    }

    public void moverSubmarinoHorizontal(){
        submarino.moviemientoHorizontal();
    }

    public SubmarinoView getSubmarino(){
        return submarino.toView();
    }

    public PartidaView getPartida(){
        return partida.toView();
    }
}
