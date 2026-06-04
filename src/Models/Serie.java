package Models;

import Views.SerieView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Serie {

    // constantes
    private static final int CAPACIDAD_MAXIMA    = 3;   // la cantidad maxima de barcos activos a la vez en pantalla
    private static final int TOTAL_BARCOS_SERIE  = 12;  // cantidad total de barcos que componen la serie

    // atributos
    private List<Barco> barcos;
    private boolean     completa;
    private int         barcosActivos;
    private int         velocidadBarco;
    private int         velocidadCaidaProyectil;
    private int         posicionInicioXBarco;
    private int         posicionInicioYBarco;

    // constructor
    public Serie() {
        this.barcos        = new ArrayList<>();
        this.completa      = false;
        this.barcosActivos = 0;
        this.velocidadBarco = 1;
        this.velocidadCaidaProyectil = 1;
        this.posicionInicioYBarco = 0;
    }

    private void aumentosVelocidad() {
        this.velocidadBarco = (int) (this.velocidadBarco * 1.2);
        this.velocidadCaidaProyectil = (int) (this.velocidadCaidaProyectil * 1.2);
    }

    private void seleccionarPosicionInicioBarco() {
        Random random = new Random();
        int lado = random.nextInt(2);
        if (lado == 0) {
            this.posicionInicioXBarco = 0;
        } else {
            this.posicionInicioXBarco = 400;
        }
    }
    
    /*
     * Agrega un nuevo barco a la serie si no alcanza el límite de activos ni el total.
     */
    private void agregarBarco() {
        if (barcos.size() >= TOTAL_BARCOS_SERIE) {
            System.out.println("Serie: total limit of " + TOTAL_BARCOS_SERIE + " ships reached.");
            return;
        }
        if (barcosActivos >= CAPACIDAD_MAXIMA) {
            System.out.println("Serie: active cap of " + CAPACIDAD_MAXIMA + " ships reached.");
            return;
        }

        Barco nuevoBarco = new Barco(velocidadBarco,posicionInicioXBarco, posicionInicioYBarco,velocidadCaidaProyectil);
        barcos.add(nuevoBarco);
        barcosActivos++;
        System.out.println("Serie: ship added. Active=" + barcosActivos
                + " | Total=" + barcos.size());
    }

    /**
     * si el TOTAL_BARCOS_SERIE se agregaron y ninguno de ellos está vivo,
     * entonces la serie se considera completa.
     * Devuelve true si la serie está completa, false de lo contrario.
     */
    public boolean serieCompleta() {
        if (barcos.size() < TOTAL_BARCOS_SERIE) {
            this.completa = false;
            return false;
        }
        for (Barco b : barcos) {
            if (b.estaVivo()) {
                this.completa = false;
                return false;
            }
        }
        this.completa = true;
        return true;
    }

    /**
     * Itera sobre todos los barcos y actualiza barcosActivos para reflejar cuántos barcos
     * estan activos. Llamar a este método después de cambios en el estado de los barcos.
     */
    public void checkearBarcos() {
        int activos = 0;
        for (Barco b : barcos) {
            if (b.estaVivo()) {
                activos++;
            }
        }
        barcosActivos = activos;

        // Completa a capacidad_maxima cada vez que se libera un slot y aún hay barcos por agregar
        while (barcosActivos < CAPACIDAD_MAXIMA && barcos.size() < TOTAL_BARCOS_SERIE) {
            agregarBarco();
        }

        // Si llego al total de barcos y ninguno está vivo, marca la serie como completa
        serieCompleta();
    }

    /**
     * Resetea la serie para que empieze otra ronda: limpia lista de barcos,
     * pone barcosActivos en 0 y completa en false.
     */
    public void reiniciarSerie() {
        /*
         * Quizas haya que mover la posicion de los barcos en la lista fuera de vista
         * antes de limpiarla para que no queden colgados.
         * Definir cuando se agregue las vistas y ver como se comporta.
         */
        this.barcos.clear();
        this.barcosActivos = 0;
        this.completa      = false;
        aumentosVelocidad();
        System.out.println("Serie: series reset.");
    }

    // getters y setters

    public List<Barco> getBarcos()       { return barcos; }
    public boolean     isCompleta()      { return completa; }
    public int         getBarcosActivos(){ return barcosActivos; }

    public static int getCapacidadMaxima()   { return CAPACIDAD_MAXIMA; }
    public static int getTotalBarcosSerie()  { return TOTAL_BARCOS_SERIE; }

    
    public SerieView toView() {
        return new SerieView(this.barcosActivos, this.completa, this.barcos.size(), CAPACIDAD_MAXIMA, TOTAL_BARCOS_SERIE);
    }

}