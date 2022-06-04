package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

    private GameWorld World;


    public Movement (GameWorld World){
        this.World = World;

}
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            World.getStudent().setPosition(new Vec2(World.getStudent().getPosition().x, World.getStudent().getPosition().y+1));
        }
        if (code == KeyEvent.VK_A) {
            World.getStudent().setPosition(new Vec2(World.getStudent().getPosition().x-1, World.getStudent().getPosition().y));
        }
        if (code == KeyEvent.VK_S) {
            World.getStudent().setPosition(new Vec2(World.getStudent().getPosition().x, World.getStudent().getPosition().y - 1));
        }
        if (code == KeyEvent.VK_D) {
            World.getStudent().setPosition(new Vec2(World.getStudent().getPosition().x+1, World.getStudent().getPosition().y));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
