package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.*;

public class MouseFocus implements MouseListener, MouseMotionListener {

    private GameWorld World;
    private GameView View;
    private MouseEvent ee;
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
    public void mousePressed(MouseEvent ee) {
        this.ee = ee;

        Vec2 d = View.viewToWorld(ee.getPoint());
        World.getStudent().setMousePos(d);
        World.getStudent().Shoot();
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

    @Override
    public void mouseDragged(MouseEvent e) {
        Vec2 d = View.viewToWorld(e.getPoint());
        World.getStudent().setMousePos(d);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
