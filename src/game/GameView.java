package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import java.awt.*;

public class GameView extends UserView {

    public GameView(World w, int width, int height) {
        super(w, width, height);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.setBackground(Color.black);

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        g.setBackground(Color.black);
    }
}
