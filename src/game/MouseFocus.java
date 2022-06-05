package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFocus implements MouseListener {

    private GameWorld World;
    private GameView View;

    private Timer test;


    public MouseFocus(GameWorld World, GameView View) {
        this.World = World;
        this.View = View;
        test = new Timer(140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                World.getStudent().Shoot();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        test.start();


    }


    @Override
    public void mouseReleased(MouseEvent e) {
    test.stop();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        View.requestFocus();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
