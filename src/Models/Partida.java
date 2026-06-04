package Models;

import Views.PartidaView;

public class Partida {

    private int vidas;
    private int puntos;
    private Submarino submarino;
    public Nivel nivel;

    public Partida() {
        this.vidas = 3;
        this.puntos = 0;
        this.submarino = new Submarino(5, 0, 300);
        this.nivel = new Nivel();
    }

    public void decrementarVida() {
        this.vidas--;
    }

    public void sumarPuntos(int p) {
        int multiploAntes = this.puntos / 500;
        this.puntos += p;
        int multiploAhora = this.puntos / 500;
        for (int i = 0; i < (multiploAhora - multiploAntes); i++) {
            this.vidas++;
        }
    }

    public void resetearSubmarino() {
        this.submarino = new Submarino(5, 0, 300);
    }

    private void incrementarPuntos(int puntosGanados) {
        this.puntos += puntosGanados;
    }

    public int getVidas()           { return vidas; }
    public int getPuntos()          { return puntos; }
    public Submarino getSubmarino() { return submarino; }

    public PartidaView toView() {
        return new PartidaView(this.vidas, this.puntos, this.nivel.getNumeroNivel());
    }
}
