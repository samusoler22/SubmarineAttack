public class CargaDeProfundidad {

    // Atributos privados para respetar el principio de encapsulamiento.
    // posicionX es 'final' porque la carga cae en linea recta verticalmente;
    // su coordenada horizontal nunca cambia una vez que es lanzada.
    private final int posicionX;
    private int posicionY;
    private int velocidadCaida;
    private boolean exploto;
    private int profundidadDetonacion;

    // Constantes con los limites de profundidad para la explosion
    private final int PROFUNDIDAD_EXPLOSION_MIN = 300;
    private final int PROFUNDIDAD_EXPLOSION_MAX = 700;

    // Constructor: se ejecuta automaticamente cuando el Barco crea una nueva carga
    public CargaDeProfundidad(int posicionX, int velocidadCaida, int profundidadDetonacion) {
        this.posicionX = posicionX;
        this.velocidadCaida = velocidadCaida;
        this.profundidadDetonacion = profundidadDetonacion;

        // Valores iniciales por defecto estipulados en el requerimiento UML.
        // La carga siempre empieza en la superficie del agua.
        this.posicionY = 0;
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

    // Getters: son publicos y necesarios para que la clase Submarino pueda leer la ubicacion
    public int getPosicionX() {
        return this.posicionX;
    }

    // Se utiliza la Y mayuscula (getPosicionY) para asegurar la compatibilidad con el codigo de tu companero
    public int getPosicionY() {
        return this.posicionY;
    }

    // Getter adicional recomendado para consultar desde afuera si la carga ya exploto
    public boolean isExploto() {
        return this.exploto;
    }
}