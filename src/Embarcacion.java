
public abstract class Embarcacion {
    // Atributos protegidos (protected):
    // Permite que las clases hijas (Submarino y Barco) los hereden y usen directamente.
    protected boolean vivo;
    protected int velocidad;
    protected int posicionX;
    protected int posicionY;

    // CONSTRUCTOR: Es el bloque que se ejecuta cuando nace una nueva embarcación.
    public Embarcacion(int velocidad, int posicionX, int posicionY) {
        this.vivo = true; // Por defecto arranca viva en el juego [cite: 28, 51]
        this.velocidad = velocidad; // Velocidad asignada según el nivel [cite: 28, 52]
        this.posicionX = posicionX; // Posición horizontal inicial [cite: 28, 52]
        this.posicionY = posicionY; // Posición vertical inicial [cite: 28, 52]
    }

    // GETTER: Un método simple para que otras clases consulten si la nave sigue viva.
    public boolean estaVivo() {
        return this.vivo; // Devuelve true o false [cite: 29, 53]
    }

    // MÉTODO DE MOVIMIENTO: Incrementa la posición X sumándole la velocidad en cada actualización del juego.
    public void moviemientoHorizontal() {
        this.posicionX += this.velocidad; // Esto simula el desplazamiento horizontal [cite: 29, 53]
    }
}




