package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Player student;



    private Enemies enemies;
    private GameView view;
    public GameWorld(GameView view) {
        this.view = view;
        getSimulationSettings().setTargetFrameRate(60);
        setGravity(0);


        student = new Player(this,this);
        student.setPosition(new Vec2(7, -6));

        enemies = new Enemies(this);
       // enemies.movement();
    }

    public Player getStudent() {
        return student;
    }

    public void setStudent(Player student) {
        this.student = student;
    }
    public Enemies getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemies enemies) {
        this.enemies = enemies;
    }

}
