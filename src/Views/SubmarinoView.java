package Views;

public class SubmarinoView extends EmbarcacionView {

    private int vida;
    private int vidaMaxima;

    public SubmarinoView(int x, int y, int ancho, int alto, boolean vivo, int vida, int vidaMaxima) {
        super(x, y, ancho, alto, vivo);
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
    }

    public SubmarinoView() {}

    public int getVida()        { return vida; }
    public int getVidaMaxima()  { return vidaMaxima; }
}
