package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemies extends Walker implements StepListener {

    private static final Shape enemiesShape = new BoxShape(1, 2);

    private static final BodyImage image =
            new BodyImage("data/books.png", 2f);

    private GameWorld world;
    private Vec2 PlayerPos;
    private String facing;
    private Boolean move;


    public Enemies(GameWorld world) {
        super(world, enemiesShape);
        addImage(image);
        this.world = world;
        facing = "none";

        move = true;

    }


    @Override
    public void preStep(StepEvent stepEvent) {
        PlayerPos = world.getStudent().getPosition();


        if (PlayerPos.x < this.getPosition().x && this.getPosition().y - PlayerPos.y > -1 && this.getPosition().y - PlayerPos.y < 1) {
            move = false;
            setLinearVelocity(new Vec2(-6, 0));
        } else if (PlayerPos.x > this.getPosition().x && this.getPosition().y - PlayerPos.y > -1 && this.getPosition().y - PlayerPos.y < 1) {
            move = false;
            setLinearVelocity(new Vec2(6, 0));
        } else if (PlayerPos.y > this.getPosition().y && this.getPosition().x - PlayerPos.x > -1 && this.getPosition().x - PlayerPos.x < 1) {
            move = false;
            setLinearVelocity(new Vec2(0, 6));
        } else if (PlayerPos.y < this.getPosition().y && this.getPosition().x - PlayerPos.x > -1 && this.getPosition().x - PlayerPos.x < 1) {
            move = false;
            setLinearVelocity(new Vec2(0, -6));
        } else {
            move = true;
            setLinearVelocity(new Vec2(0, 0));
        }


        if (move) {
            if (PlayerPos.x < this.getPosition().x && PlayerPos.y > this.getPosition().y) {


                setLinearVelocity(new Vec2(-6, 6));
            }


            if (PlayerPos.x > this.getPosition().x && PlayerPos.y > this.getPosition().y) {
                setLinearVelocity(new Vec2(6, 6));

            }

            if (PlayerPos.x < this.getPosition().x && PlayerPos.y < this.getPosition().y) {
                setLinearVelocity(new Vec2(-6, -6));

            }

            if (PlayerPos.x > this.getPosition().x && PlayerPos.y < this.getPosition().y) {
                setLinearVelocity(new Vec2(6, -6));

            }

        }


    }


    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
