package GUI;

import javax.swing.*;
import java.awt.*;

public class TitleScreen extends JFrame {

    private JLabel startGameTxt;

    public TitleScreen(){

        this.setSize(800,700);

        configurarVentana();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void configurarVentana() {

        background();
        startText();
    }

    private void background(){

        JPanel backgroundPanel = new JPanel(){

            Image backgroundImage = new ImageIcon("resources/kitten.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g){

                super.paintComponent(g);

                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(null);

        this.setContentPane(backgroundPanel);
    }

    private void startText(){

        Container c = this.getContentPane();

        startGameTxt = new JLabel("Press any button to start game");

        startGameTxt.setFont(new Font("Arial", Font.BOLD, 20));

        int labelWidth = 400;
        int labelHeight = 100;

        int x = (getWidth() - labelWidth) / 2;
        int y = (int)(getHeight() * 0.60);

        startGameTxt.setBounds(x, y, labelWidth, labelHeight);

        startGameTxt.setHorizontalAlignment(SwingConstants.CENTER);

        c.add(startGameTxt);

        Timer blinkTimer = new Timer(500, e -> {
            startGameTxt.setVisible(!startGameTxt.isVisible());
        });

        blinkTimer.start();
    }
}