package Views;

public class NivelView {

    private int numeroNivel;
    private int aumentoCaidaProyectil;
    private int aumentoMovimientoBarco;

    public NivelView(int numeroNivel, int aumentoCaidaProyectil, int aumentoMovimientoBarco) {
        this.numeroNivel = numeroNivel;
        this.aumentoCaidaProyectil = aumentoCaidaProyectil;
        this.aumentoMovimientoBarco = aumentoMovimientoBarco;
    }

    public NivelView() {}

    public int getNumeroNivel()             { return numeroNivel; }
    public int getAumentoCaidaProyectil()   { return aumentoCaidaProyectil; }
    public int getAumentoMovimientoBarco()  { return aumentoMovimientoBarco; }
}
