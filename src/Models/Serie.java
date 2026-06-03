package Models;

import java.util.ArrayList;
import java.util.List;

public class Serie {

    // constantes
    private static final int CAPACIDAD_MAXIMA    = 3;   // la cantidad maxima de barcos activos a la vez en pantalla
    private static final int TOTAL_BARCOS_SERIE  = 12;  // cantidad total de barcos que componen la serie

    // atributos
    private List<Barco> barcos;
    private boolean     completa;
    private int         barcosActivos;

    // constructor
    public Serie() {
        this.barcos        = new ArrayList<>();
        this.completa      = false;
        this.barcosActivos = 0;
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

        Barco nuevoBarco = new Barco();
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
            completa = false;
            return false;
        }
        for (Barco b : barcos) {
            if (b.estaVivo()) {
                completa = false;
                return false;
            }
        }
        completa = true;
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
        barcos.clear();
        barcosActivos = 0;
        completa      = false;
        System.out.println("Serie: series reset.");
    }

    // getters y setters

    public List<Barco> getBarcos()       { return barcos; }
    public boolean     isCompleta()      { return completa; }
    public int         getBarcosActivos(){ return barcosActivos; }

    public static int getCapacidadMaxima()   { return CAPACIDAD_MAXIMA; }
    public static int getTotalBarcosSerie()  { return TOTAL_BARCOS_SERIE; }
}