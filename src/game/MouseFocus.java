package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFocus implements MouseListener {

    private GameWorld World;
    private GameView View;


    public MouseFocus (GameWorld World, GameView View){
        this.World = World;
        this.View = View;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
       View.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
