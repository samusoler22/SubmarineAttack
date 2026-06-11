package Models;

import Views.SerieView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Serie {

    private static final int CAPACIDAD_MAXIMA    = 3;
    private static final int TOTAL_BARCOS_SERIE  = 12;
    private static final int ANCHO_PANTALLA      = 400;

    private List<Barco> barcos;
    private boolean     completa;
    private int         barcosActivos;
    private int         velocidadBarco;
    private int         velocidadCaidaProyectil;
    private int         posicionInicioXBarco;
    private int         posicionInicioYBarco;

    public Serie() {
        this.barcos        = new ArrayList<>();
        this.completa      = false;
        this.barcosActivos = 0;
        this.velocidadBarco = 2;
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
            this.posicionInicioXBarco = ANCHO_PANTALLA;
        }
    }

    private void agregarBarco() {
        if (barcos.size() >= TOTAL_BARCOS_SERIE) {
            System.out.println("Serie: total limit of " + TOTAL_BARCOS_SERIE + " ships reached.");
            return;
        }
        if (barcosActivos >= CAPACIDAD_MAXIMA) {
            System.out.println("Serie: active cap of " + CAPACIDAD_MAXIMA + " ships reached.");
            return;
        }

        seleccionarPosicionInicioBarco();
        Barco nuevoBarco = new Barco(velocidadBarco, posicionInicioXBarco, posicionInicioYBarco, velocidadCaidaProyectil);
        barcos.add(nuevoBarco);
        barcosActivos++;
        System.out.println("Serie: ship added. Active=" + barcosActivos + " | Total=" + barcos.size());
    }

    public void avanzar() {
        int activos = 0;
        for (Barco b : barcos) {
            if (!estaFueraDePantalla(b)) {
                b.avanzar();
                activos++;
            }
        }
        barcosActivos = activos;

        while (barcosActivos < CAPACIDAD_MAXIMA && barcos.size() < TOTAL_BARCOS_SERIE) {
            agregarBarco();
        }

        serieCompleta();
    }

    private boolean estaFueraDePantalla(Barco b) {
        return b.getPosicionX() < 0 || b.getPosicionX() > ANCHO_PANTALLA;
    }

    public boolean serieCompleta() {
        if (barcos.size() < TOTAL_BARCOS_SERIE) {
            this.completa = false;
            return false;
        }
        for (Barco b : barcos) {
            if (!estaFueraDePantalla(b)) {
                this.completa = false;
                return false;
            }
        }
        this.completa = true;
        return true;
    }

    public void reiniciarSerie() {
        this.barcos.clear();
        this.barcosActivos = 0;
        this.completa      = false;
        aumentosVelocidad();
        System.out.println("Serie: series reset.");
    }

    public List<Barco> getBarcos()       { return barcos; }
    public boolean     isCompleta()      { return completa; }
    public int         getBarcosActivos(){ return barcosActivos; }

    public static int getCapacidadMaxima()   { return CAPACIDAD_MAXIMA; }
    public static int getTotalBarcosSerie()  { return TOTAL_BARCOS_SERIE; }

    public SerieView toView() {
        return new SerieView(this.barcosActivos, this.completa, this.barcos.size(), CAPACIDAD_MAXIMA, TOTAL_BARCOS_SERIE);
    }
}