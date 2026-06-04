package Views;

public class CargaDeProfundidadView {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private boolean exploto;
    private int profundidadDetonacion;

    public CargaDeProfundidadView(int x, int y, int ancho, int alto, boolean exploto, int profundidadDetonacion) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.exploto = exploto;
        this.profundidadDetonacion = profundidadDetonacion;
    }

    public CargaDeProfundidadView() {}

    public int getX()                      { return x; }
    public int getY()                      { return y; }
    public int getAncho()                  { return ancho; }
    public void setAncho(int ancho)        { this.ancho = ancho; }
    public int getAlto()                   { return alto; }
    public void setAlto(int alto)          { this.alto = alto; }
    public boolean isExploto()             { return exploto; }
    public int getProfundidadDetonacion()  { return profundidadDetonacion; }
}
