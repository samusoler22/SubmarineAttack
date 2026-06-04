package Views;

public class PartidaView {

    private int vidas;
    private int puntos;
    private int numeroNivel;

    public PartidaView(int vidas, int puntos, int numeroNivel) {
        this.vidas = vidas;
        this.puntos = puntos;
        this.numeroNivel = numeroNivel;
    }

    public PartidaView() {}

    public int getVidas()       { return vidas; }
    public int getPuntos()      { return puntos; }
    public int getNumeroNivel() { return numeroNivel; }
}
