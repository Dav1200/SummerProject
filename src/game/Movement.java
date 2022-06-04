package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

    private GameWorld World;
    private int speed;

    public Movement(GameWorld World) {
        this.World = World;
        speed = 6;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {

        }
        if (code == KeyEvent.VK_A) {
            World.getStudent().move(-speed);
        }
        if (code == KeyEvent.VK_S) {
            World.getStudent().stopWalking();

        }
        if (code == KeyEvent.VK_D) {
            World.getStudent().move(speed);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) {
            World.getStudent().Stop();
            World.getStudent().setLinearVelocity(new Vec2(0,0));
        }
        if (code == KeyEvent.VK_A) {
            World.getStudent().Stop();
            World.getStudent().setLinearVelocity(new Vec2(0,0));
        }
    }
}
