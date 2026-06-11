package Models;

import Views.CargaDeProfundidadView;

public class CargaDeProfundidad {

    private final int posicionX;
    private int posicionY;
    private int velocidadCaida;
    private boolean exploto;
    private int profundidadDetonacion;
    private final int ancho = 15;
    private final int alto  = 20;

    public CargaDeProfundidad(int posicionX, int posicionY, int velocidadCaida, int profundidadDetonacion) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidadCaida = velocidadCaida;
        this.profundidadDetonacion = profundidadDetonacion;
        this.exploto = false;
    }

    public void caer() {
        this.posicionY += this.velocidadCaida;
        explotarCarga();
    }

    private void explotarCarga() {
        if (this.posicionY >= this.profundidadDetonacion) {
            this.exploto = true;
        }
    }

    public int getPosicionX()              { return this.posicionX; }
    public int getPosicionY()              { return this.posicionY; }
    public boolean isExploto()             { return this.exploto; }
    public int getVelocidadCaida()         { return this.velocidadCaida; }
    public int getProfundidadDetonacion()  { return this.profundidadDetonacion; }
    public int getAncho()                  { return this.ancho; }
    public int getAlto()                   { return this.alto; }

    public CargaDeProfundidadView toView() {
        return new CargaDeProfundidadView(this.posicionX, this.posicionY, this.ancho, this.alto, this.exploto, this.profundidadDetonacion);
    }
}
