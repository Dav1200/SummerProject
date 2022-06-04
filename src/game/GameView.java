package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background;


    public GameView(GameWorld w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/Grass_Sample.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(background,0,0,this);



    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);

    }
}
