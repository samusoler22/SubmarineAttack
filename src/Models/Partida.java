package Models;

import Views.PartidaView;

public class Partida {

    private static final int VIDAS_INICIALES = 3;
    private static final int PTS_VIDA_EXTRA  = 500;

    private int vidas;
    private int puntos;
    private Nivel nivel;

    public Partida() {
        this.vidas  = VIDAS_INICIALES;
        this.puntos = 0;
        this.nivel  = new Nivel();
    }

    public void tick() {
        nivel.avanzar();

        if (nivel.estaCompleto()) {
            nivel.siguienteNivel();
        }
    }

    public void decrementarVida() {
        this.vidas--;
    }

    public void sumarPuntos(int p) {
        int multiploAntes = this.puntos / PTS_VIDA_EXTRA;
        this.puntos += p;
        int multiploAhora = this.puntos / PTS_VIDA_EXTRA;
        for (int i = 0; i < (multiploAhora - multiploAntes); i++) {
            this.vidas++;
        }
    }

    private void incrementarPuntos(int puntosGanados) {
        this.puntos += puntosGanados;
    }

    public int getVidas()   { return vidas; }
    public int getPuntos()  { return puntos; }
    public Nivel getNivel() { return nivel; }

    public PartidaView toView() {
        return new PartidaView(this.vidas, this.puntos, this.nivel.getNumeroNivel());
    }
}