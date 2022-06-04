package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemies extends Walker {

    private static final Shape enemiesShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/books.png", 2f);

    private GameWorld world;



    public Enemies(GameWorld world) {
        super(world, enemiesShape);
        addImage(image);
        this.world = world;

    }
    public void movement(){
        this.setPosition(new Vec2(world.getStudent().getPosition().x +10, world.getStudent().getPosition().y + 10));


    }
}
