package Models;

import Views.BarcoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barco extends Embarcacion {

    private List<CargaDeProfundidad> cargas;
    private int velocidadCaidaCarga;
    private int tiempoParaSiguienteDisparo;
    private int intervaloDisparoAleatorio;

    private final int PROFUNDIDAD_EXPLOSION_MIN = 300;
    private final int PROFUNDIDAD_EXPLOSION_MAX = 700;
    private final int ANCHO_BARCO = 80;
    private final int ALTO_BARCO = 30;
    public final int posicionInicioX;

    public Barco(int velocidad, int posicionX, int posicionY, int velocidadCaidaCarga) {
        this.ancho = ANCHO_BARCO;
        this.alto = ALTO_BARCO;
        this.velocidadCaidaCarga = velocidadCaidaCarga;
        this.posicionInicioX = this.posicionX;
        this.cargas = new ArrayList<>();
        this.intervaloDisparoAleatorio = generarIntervaloAleatorio();
        this.tiempoParaSiguienteDisparo = this.intervaloDisparoAleatorio;
    }

    private int calcularProfundidadDetonacion() {
        Random random = new Random();
        int rangoAleatorio = (PROFUNDIDAD_EXPLOSION_MAX - PROFUNDIDAD_EXPLOSION_MIN) + 1;
        return random.nextInt(rangoAleatorio) + PROFUNDIDAD_EXPLOSION_MIN;
    }

    private int generarIntervaloAleatorio() {
        Random random = new Random();
        return random.nextInt(50) + 30;
    }

    private void evaluarDisparo() {
        this.tiempoParaSiguienteDisparo--;
        if (this.tiempoParaSiguienteDisparo <= 0) {
            DispararCargaDeProfundidad();
            this.intervaloDisparoAleatorio = generarIntervaloAleatorio();
            this.tiempoParaSiguienteDisparo = this.intervaloDisparoAleatorio;
        }
    }

    private void actualizarCargas() {
        for (CargaDeProfundidad carga : this.cargas) {
            carga.caer();
        }
    }

    private CargaDeProfundidad DispararCargaDeProfundidad() {
        CargaDeProfundidad nuevaCarga = new CargaDeProfundidad(this.posicionX, this.posicionY+this.alto, velocidadCaidaCarga, calcularProfundidadDetonacion());
        this.cargas.add(nuevaCarga);
        return nuevaCarga;
    }
    
    public List<CargaDeProfundidad> getCargas() { return this.cargas; }
    public int getVelocidadCaidaCarga() { return this.velocidadCaidaCarga; }
    public void setVelocidadCaidaCarga(int velocidadCaidaCarga) { this.velocidadCaidaCarga = velocidadCaidaCarga; }

    @Override
    public BarcoView toView() {
        return new BarcoView(this.posicionX, this.posicionY, this.ancho, this.alto, this.vivo);
    }

    public void avanzar() {
        if (posicionInicioX == 400){
            moverIzquierda();
        } else {
            moverDerecha();
        }

        actualizarCargas();
        evaluarDisparo();
    }

}
