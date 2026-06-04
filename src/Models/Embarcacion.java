package Models;

import Views.EmbarcacionView;

public abstract class Embarcacion {
    protected boolean vivo;
    protected int velocidad;
    protected int posicionX;
    protected int posicionY;
    protected int ancho;
    protected int alto;

    public Embarcacion(int velocidad, int posicionX, int posicionY) {
        this.vivo = true;
        this.velocidad = velocidad;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public boolean estaVivo()  { return this.vivo; }
    public int getPosicionX()  { return this.posicionX; }
    public int getPosicionY()  { return this.posicionY; }
    public int getVelocidad()  { return this.velocidad; }
    public int getAncho()      { return this.ancho; }
    public int getAlto()       { return this.alto; }

    public void moviemientoHorizontal() {
        this.posicionX += this.velocidad;
    }

    public abstract EmbarcacionView toView();
}



