package Models;

import Views.CargaDeProfundidadView;

public class CargaDeProfundidad {

    // Atributos privados para respetar el principio de encapsulamiento.
    // posicionX es 'final' porque la carga cae en linea recta verticalmente;
    // su coordenada horizontal nunca cambia una vez que es lanzada.
    private final int posicionX;
    private int posicionY;
    private int velocidadCaida;
    private boolean exploto;
    private int profundidadDetonacion;
    private final int ancho = 15;
    private final int alto  = 20;

    // Constantes con los limites de profundidad para la explosion
    private final int PROFUNDIDAD_EXPLOSION_MIN = 300;
    private final int PROFUNDIDAD_EXPLOSION_MAX = 700;

    // Constructor: se ejecuta automaticamente cuando el Barco crea una nueva carga
    public CargaDeProfundidad(int posicionX, int posicionY, int velocidadCaida, int profundidadDetonacion) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidadCaida = velocidadCaida;
        this.profundidadDetonacion = profundidadDetonacion;

        // La carga se crea intacta, por lo tanto no exploto todavia.
        this.exploto = false;
    }

    // Metodo que simula el hundimiento de la carga en el agua
    public void caer() {
        // En cada turno del juego, la carga baja sumando su velocidad a su posicion vertical
        this.posicionY += this.velocidadCaida;
    }

    // Metodo que verifica si la carga llego al punto critico
    public void explotarCarga() {
        // Si la profundidad actual (posicionY) alcanza o supera la profundidad de detonacion asignada, estalla.
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
