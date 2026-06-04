package Views;

public class EmbarcacionView {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private boolean vivo;

    public EmbarcacionView(int x, int y, int ancho, int alto, boolean vivo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.vivo = vivo;
    }

    public EmbarcacionView() {}

    public int getX()          { return x; }
    public int getY()          { return y; }
    public int getAncho()      { return ancho; }
    public void setAncho(int ancho) { this.ancho = ancho; }
    public int getAlto()       { return alto; }
    public void setAlto(int alto)   { this.alto = alto; }
    public boolean isVivo()    { return vivo; }
}
