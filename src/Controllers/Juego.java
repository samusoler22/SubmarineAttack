package Controllers;

import Models.*;
import Views.*;
import javax.swing.Timer;


public class Juego {

    private static Juego instancia;
    private Partida partida;
    private Submarino submarino;
    private static final int FPS = 60;
    private Timer timer;

    private Juego() {
    }

    public static Juego getInstance() {
        if (instancia == null)
            instancia = new Juego();
        return instancia;
    }

    public void iniciarTimer() {
        if (timer != null && timer.isRunning()) return;
        int msPorFrame = 1000 / FPS;
        timer = new Timer(msPorFrame, e -> update());
        timer.start();
    }

    public void pausar() {
        if (timer != null) timer.stop();
    }

    public void update() {
        partida.tick();
        aplicarDanios();
        chequearMuerteSubmarino();
        chequearFinDeJuego();

        // TODO: aplicar daños, chequear si submarino murió, etc.
    }

    public void inicializarObjetos(){
        this.partida = new Partida();
        this.submarino = new Submarino(1, 0, 300);
    }

    private void chequearFinDeJuego() {
        if (partida.getVidas() <= 0) {
            pausar();
        }
    }

    private void chequearMuerteSubmarino() {
        if (!submarino.estaVivo()) {
            partida.decrementarVida();
            submarino.revivir();
        }
    }

    private void aplicarDanios() {
        for (Barco b : partida.getNivel().getSerie().getBarcos()) {
            for (CargaDeProfundidad c : b.getCargas()) {
                if (c.isExploto()) {
                    int distancia = submarino.distanciaConCarga(c);
                    int danio = submarino.calcularDanio(distancia);
                    submarino.recibirDanio(danio);
                }
            }
        }
    }

    public void moverSubmarinoIzquierda() {
        submarino.moverIzquierda();
    }

    public void moverSubmarinoDerecha() {
        submarino.moverDerecha();
    }

    public void moverSubmarinoArriba() {
        submarino.moverArriba();
    }

    public void moverSubmarinoAbajo() {
        submarino.moverAbajo();
    }

    public SubmarinoView getSubmarino(){
        return submarino.toView();
    }

    public PartidaView getPartida(){
        return partida.toView();
    }
}
