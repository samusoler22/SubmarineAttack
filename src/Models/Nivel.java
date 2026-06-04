package Models;

import Views.NivelView;

public class Nivel {
    private Serie serie;
    private int numeroNivel;


    public Nivel() {
        this.serie        = new Serie();
        this.numeroNivel  = 1;
    }

    public boolean siguienteNivel(){
        if (!serie.isCompleta()) return false;
        this.numeroNivel++;
        this.serie.reiniciarSerie();
        return true;
    }

    public int getNumeroNivel() { return this.numeroNivel; }

    public NivelView toView() {
        return new NivelView(this.numeroNivel);
    }

}

