package Models;

import Views.NivelView;

public class Nivel {
    private Serie serie;
    private int numeroNivel;
    private int aumentoCaidaProyectil;
    private int aumentoMovimientoBarco;

    public Nivel() {
        this.serie        = new Serie();
        this.numeroNivel  = 1;
        this.aumentoCaidaProyectil = 0;
        this.aumentoMovimientoBarco = 0;
    }

    public boolean siguienteNivel(){
        if (!serie.isCompleta()) return false;

        this.numeroNivel++;
        this.aumentoCaidaProyectil  += 5;
        this.aumentoMovimientoBarco += 1;
        this.serie.reiniciarSerie();
        return true;
    }

    public Serie getSerie()                  { return this.serie; }
    public int getNumeroNivel()              { return this.numeroNivel; }
    public int getAumentoCaidaProyectil()    { return this.aumentoCaidaProyectil; }
    public int getAumentoMovimientoBarco()   { return this.aumentoMovimientoBarco; }

    public NivelView toView() {
        return new NivelView(this.numeroNivel, this.aumentoCaidaProyectil, this.aumentoMovimientoBarco);
    }

}

