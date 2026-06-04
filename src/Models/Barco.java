package Models;

import Views.BarcoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// La palabra reservada 'extends' indica que Barco hereda los atributos y metodos de Embarcacion
public class Barco extends Embarcacion {

    // Lista para almacenar y gestionar el inventario de las cargas que lanza este barco
    private List<CargaDeProfundidad> cargas;

    // Constantes con los limites de profundidad
    private final int PROFUNDIDAD_EXPLOSION_MIN = 300;
    private final int PROFUNDIDAD_EXPLOSION_MAX = 700;
    private final int ANCHO_BARCO = 80;
    private final int ALTO_BARCO = 30;

    // Constructor del Barco
    public Barco(int velocidad, int posicionX, int posicionY) {
        // 'super' invoca obligatoriamente al constructor de la clase padre (Embarcacion)
        // para inicializar los atributos heredados
        super(velocidad, posicionX, posicionY);
        this.ancho = ANCHO_BARCO;
        this.alto = ALTO_BARCO;
        this.cargas = new ArrayList<>();
    }

    // Metodo privado que calcula matematicamente a que profundidad estallara la bomba
    private int calcularProfundidadDetonacion() {
        Random random = new Random();

        // La formula '(MAX - MIN) + 1' genera la cantidad total de numeros posibles (401 numeros).
        // Al resultado se le suma el valor MIN (300) para desplazar el rango.
        // Asi nos aseguramos que el resultado siempre caiga entre 300 y 700.
        int rangoAleatorio = (PROFUNDIDAD_EXPLOSION_MAX - PROFUNDIDAD_EXPLOSION_MIN) + 1;
        return random.nextInt(rangoAleatorio) + PROFUNDIDAD_EXPLOSION_MIN;
    }

    // Metodo privado que fabrica y lanza el proyectil al agua
    private CargaDeProfundidad DispararCargaDeProfundidad(int profundidadDetonacion) {
        // Se define una velocidad de caida fija para la carga.
        // El UML no dice de cuanto debe ser, asi que le asignamos 10.
        int velocidadCaidaCarga = 10;

        // Instancia el objeto CargaDeProfundidad pasandole la posicion X del barco,
        // para simular que la carga cae exactamente desde donde esta navegando.
        CargaDeProfundidad nuevaCarga = new CargaDeProfundidad(this.posicionX, this.posicionY+this.alto, velocidadCaidaCarga, profundidadDetonacion);

        // Guarda la carga recien creada en el registro del barco
        this.cargas.add(nuevaCarga);

        return nuevaCarga;
    }

    public List<CargaDeProfundidad> getCargas() { return this.cargas; }

    @Override
    public BarcoView toView() {
        return new BarcoView(this.posicionX, this.posicionY, this.ancho, this.alto, this.vivo);
    }

}
