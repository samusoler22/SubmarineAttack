package Models;

import Views.SubmarinoView;

public class Submarino extends Embarcacion {
    // Atributos especificos del submarino
    private int vida;

    // Constantes (final): Valores fijos que no cambian durante el juego
    private final int VIDA_MAXIMA = 100; //
    private final int PROFUNDIDAD_MAXIMA = 800; //
    private final int PROFUNDIDAD_MINIMA = 300; //

    // CONSTRUCTOR
    public Submarino(int velocidad, int posicionX, int posicionY) {
        super(velocidad, posicionX, posicionY);
        this.vida = VIDA_MAXIMA;
        this.ancho = 60;
        this.alto = 25;
    }

    public void revivir(){
        this.vivo = true;
        this.vida = VIDA_MAXIMA;
    }

    public void moverArriba(){
        int nuevaPosicion = this.posicionY - this.velocidad;
        if (nuevaPosicion >= PROFUNDIDAD_MINIMA) {
            this.posicionY = nuevaPosicion;
        }

    }
    public void moverAbajo(){
        int nuevaPosicion = this.posicionY + this.velocidad;
        if (nuevaPosicion <= PROFUNDIDAD_MAXIMA) {
            this.posicionY = nuevaPosicion;
        }
    }

    public void recibirDanio(int danio) {
        this.vida -= danio;

        if (this.vida <= 0) {
            this.vida = 0;
            this.vivo = false;
        }
    }
    public int calcularDanio(int distanciaCarga) {
        if (distanciaCarga > 100) {
            return 0;
        } else if (distanciaCarga > 50) {
            return 30;
        } else if (distanciaCarga > 10) {
            return 50;
        } else {
            return VIDA_MAXIMA;
        }
    }

    public int getVida() { return this.vida; }

    public int getVidaMaxima() { return VIDA_MAXIMA; }

    @Override
    public SubmarinoView toView() {
        return new SubmarinoView(this.posicionX, this.posicionY, this.ancho, this.alto, this.vivo, this.vida, VIDA_MAXIMA);
    }

    public int distanciaConCarga(CargaDeProfundidad carga) {
        // Formula de distancia entre dos puntos: √((x2 - x1)² + (y2 - y1)²)
        double distancia = Math.sqrt(Math.pow(this.posicionX - carga.getPosicionX(), 2) + Math.pow(this.posicionY - carga.getPosicionY(), 2));
        return (int) distancia;
    }
}

