package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.swing.*;

public class ProjectilesCollision implements CollisionListener {
    private Player p;


    public ProjectilesCollision(Player p) {

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Enemies){
            collisionEvent.getReportingBody().destroy();
            ((Enemies) collisionEvent.getOtherBody()).dead();
        }
    }
}
