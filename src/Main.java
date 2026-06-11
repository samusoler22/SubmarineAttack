
import GUI.TitleScreen;
import Controllers.*;
import Models.*;
import Views.*;
public class Main {
    public static void main(String[] args) {
        Juego Controller = Juego.getInstance();
        Controller.moverSubmarinoVertical();
        System.out.println(Controller.getSubmarino().getY());
        Controller.moverSubmarinoVertical();
        System.out.println(Controller.getSubmarino().getY());

        Partida partida = new Partida();
        System.out.println(partida.toView().getPuntos());
        partida.sumarPuntos(201);
        System.out.println(partida.toView().getPuntos());

        System.out.println("------------");


    }
}