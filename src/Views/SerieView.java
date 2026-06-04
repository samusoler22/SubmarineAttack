package Views;

public class SerieView {

    private int barcosActivos;
    private boolean completa;
    private int barcosAgregados;
    private int capacidadMaxima;
    private int totalBarcosSerie;

    public SerieView(int barcosActivos, boolean completa, int barcosAgregados, int capacidadMaxima, int totalBarcosSerie) {
        this.barcosActivos = barcosActivos;
        this.completa = completa;
        this.barcosAgregados = barcosAgregados;
        this.capacidadMaxima = capacidadMaxima;
        this.totalBarcosSerie = totalBarcosSerie;
    }

    public SerieView() {}

    public int getBarcosActivos()     { return barcosActivos; }
    public boolean isCompleta()       { return completa; }
    public int getBarcosAgregados()   { return barcosAgregados; }
    public int getCapacidadMaxima()   { return capacidadMaxima; }
    public int getTotalBarcosSerie()  { return totalBarcosSerie; }
}
