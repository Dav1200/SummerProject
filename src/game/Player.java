package game;

import city.cs.engine.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.jbox2d.common.Vec2;

//dadadasdqawedfasdvxcv
public class Player extends Walker implements StepListener {
    private static final Shape studentShape = new BoxShape(1, 2);
    private String facing;


    private Boolean moveUp;
    private Boolean moveDown;

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    private int credits = 0;

    public Player(World world) {
        super(world, studentShape);
        facing = "right";
        addImage(image);
        credits = 0;
        moveDown = false;
        moveUp = false;
    }

    public void move(float speed) {


        if (speed < 0) {

            this.startWalking(-6);

        } else if (speed > 0) {

            this.startWalking(6);

        }

    }

    public void Stop() {
        stopWalking();
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (moveUp) {
            this.setLinearVelocity(new Vec2(0, 6f));
        }

        if (moveDown) {
            this.setLinearVelocity(new Vec2(0, -6f));
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

    public Boolean getMoveUp() {
        return moveUp;
    }

    public void setMoveUp(Boolean moveUp) {
        this.moveUp = moveUp;
    }

    public Boolean getMoveDown() {
        return moveDown;
    }

    public void setMoveDown(Boolean moveDown) {
        this.moveDown = moveDown;
    }
}
