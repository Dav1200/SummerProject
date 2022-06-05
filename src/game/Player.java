package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//dadadasdqawedfasdvxcv
public class Player extends Walker implements StepListener {
    private static final Shape studentShape = new BoxShape(1, 2);
    private String facing;
    private float speed;
    private Shape circle = new CircleShape(0.5f);

    public Vec2 getMousePos() {
        return MousePos;
    }

    public void setMousePos(Vec2 mousePos) {
        MousePos = mousePos;
    }

    private Vec2 MousePos;

    private Boolean moveUp;
    private Boolean moveDown;

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    private int credits = 0;
    private GameWorld Gworld;

    public Player(World world, GameWorld GWorld) {
        super(world, studentShape);
        facing = "right";
        addImage(image);

        credits = 0;
        moveDown = false;
        moveUp = false;
    }

    public void Shoot() {

        DynamicBody bullet = new DynamicBody(this.getWorld(), circle);

        Vec2 dir = MousePos.sub(this.getPosition());
        dir.normalize();


        bullet.setPosition(this.getPosition().add(dir.mul(1f)));
        bullet.setLinearVelocity(dir.mul(40));
        ProjectilesCollision Clean = new ProjectilesCollision(this);
        bullet.addCollisionListener(Clean);

        Timer t = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bullet.destroy();

            }
        });
        t.start();
        t.setRepeats(false);
    }

    public void move(float speed) {

        this.speed = speed;
        if (speed < 0) {

            this.startWalking(speed);
            //background move left -> - in x


        } else if (speed > 0) {

            this.startWalking(speed);

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
            this.setLinearVelocity(new Vec2(0, 20));
        }

        if (moveDown) {
            this.setLinearVelocity(new Vec2(0, -20));
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
