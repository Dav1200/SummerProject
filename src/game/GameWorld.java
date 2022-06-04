package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Player student;

    public GameWorld() {
        getSimulationSettings().setTargetFrameRate(60);
        setGravity(0);

        //make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        student = new Player(this);

        student.setPosition(new Vec2(7, -6));
    }

    public Player getStudent() {
        return student;
    }

    public void setStudent(Player student) {
        this.student = student;
    }

}
