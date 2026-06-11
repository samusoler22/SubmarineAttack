
import GUI.TitleScreen;
import Controllers.*;
import Models.*;
import Views.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Juego Controller = Juego.getInstance();
        Controller.inicializarObjetos();
        Controller.iniciarTimer();
        System.out.println(Controller.getSubmarino().getX());
        Controller.moverSubmarinoDerecha();
        Controller.moverSubmarinoDerecha();
        System.out.println(Controller.getSubmarino().getX());
        System.out.println(Controller.getPartida().getVidas());


    }
}