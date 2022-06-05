package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Enemies extends Walker implements StepListener {

    private static final Shape enemiesShape = new BoxShape(1, 2);

    private static final BodyImage image =
            new BodyImage("data/books.png", 2f);

    private GameWorld world;
    private Vec2 PlayerPos;
    private String facing;
    private Boolean move;

    private int xmin = -100;
    private int xmax = 100;

    private int ymin = -120;
    private int ymax = 120;

    private int hp;

    public Enemies(GameWorld world) {
        super(world, enemiesShape);
        addImage(image);
        this.world = world;
        facing = "none";
        hp = 100;
        move = true;
    }

    public void dead(){
        hp -= 50;
        if(hp <= 0){
            this.destroy();
        }
    }

    public void spawn(){
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int random_x = (int)Math.floor(Math.random()*(xmax-xmin+1)+xmin);
                int random_y = (int)Math.floor(Math.random()*(ymax-ymin+1)+ymin);
                Enemies enemy = new Enemies(world);
                enemy.setPosition(new Vec2(world.getStudent().getPosition().x+random_x, world.getStudent().getPosition().y +random_y));
                world.addStepListener(enemy);
            }
        });
        t.start();
    }

    public void movement() {
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
    public void preStep(StepEvent stepEvent) {

        movement();
    }


    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
