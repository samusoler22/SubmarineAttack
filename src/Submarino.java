
public class Submarino extends Embarcacion {
    // Atributos especificos del submarino
    private int vida;

    // Constantes (final): Valores fijos que no cambian durante el juego
    private final int VIDA_MAXIMA = 100; //
    private final int PROFUNDIDAD_MAXIMA = 800; //
    private final int PROFUNDIDAD_MINIMA = 300; //

    // CONSTRUCTOR
    public Submarino(int velocidad, int posicionX, int posicionY) {
        // "super" invoca al constructor de Embarcacion para inicializar la velocidad y posiciones
        super(velocidad, posicionX, posicionY);
        this.vida = VIDA_MAXIMA; // El submarino arranca con 100 de vida
    }
    // Método para moverse verticalmente en el agua
    public void movimientoVertical(int cantidad) {
        // Calculamos a que profundidad quedaria
        int nuevaPosicion = this.posicionY + cantidad;

        // Controlamos los limites que pide la consigna (entre 300 y 800 metros)
        if (nuevaPosicion >= PROFUNDIDAD_MINIMA && nuevaPosicion <= PROFUNDIDAD_MAXIMA) {
            this.posicionY = nuevaPosicion;
        } else if (nuevaPosicion < PROFUNDIDAD_MINIMA) {
            this.posicionY = PROFUNDIDAD_MINIMA; // Si se queria pasar hacia arriba, clava en 300
        } else {
            this.posicionY = PROFUNDIDAD_MAXIMA; // Si se queria pasar hacia abajo, clava en 800
        }
    }
    // Metodo para aplicar el daño recibido al submarino
    public void recibirDanio(int danio) {
        this.vida -= danio; // Restamos el daño de la vida actual

        // Si la vida baja de 0, la clavamos en 0 y cambiamos el estado a muerto
        if (this.vida <= 0) {
            this.vida = 0;
            this.vivo = false;
        }
    }
    // Metodo que calcula el daño exacto segun la distancia radial de la explosión
    public int calcularDanio(int distanciaCarga) {
        if (distanciaCarga > 100) {
            return 0; // Más de 100m: No produce daño
        } else if (distanciaCarga > 50 && distanciaCarga <= 100) {
            return 30; // Entre 50m y 100m: Disminuye la vida en un 30%
        } else if (distanciaCarga > 10 && distanciaCarga <= 50) {
            return 50; // Entre 10m y 50m: Disminuye la vida en un 50%
        } else {
            return VIDA_MAXIMA; // Menos de 10m: Se pierde una vida (100% de daño)
        }
    }
    // Metodo que calcula la distancia matematica entre el submarino y una carga
    public int distanciaConCarga(CargaDeProfundidad carga) {
        // Formula de distancia entre dos puntos: √((x2 - x1)² + (y2 - y1)²)
        double distancia = Math.sqrt(Math.pow(this.posicionX - carga.getPosicionX(), 2) + Math.pow(this.posicionY - carga.getPosicionY(), 2));
        return (int) distancia; // Convertimos el resultado decimal (double) a un entero (int)
    }
}


