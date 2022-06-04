package game;

import city.cs.engine.*;
//dadadasdqawedfasdvxcv
public class Player extends Walker implements StepListener {
    private static final Shape studentShape = new BoxShape(1,2);
    private String facing;

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    private int credits = 0;

    public Player(World world) {
        super(world, studentShape);
        facing ="right";
        addImage(image);
        credits = 0;
    }

    public void move(float speed) {


        if (speed < 0 ) {

            this.startWalking(-6);

        }

        else if (speed > 0) {

            this.startWalking(6);

        }

    }

    public void Stop(){
        stopWalking();
    }

    public void setCredits(int credits){
        this.credits = credits;
    }
    public int getCredits(){
        return credits;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
    getLinearVelocity();
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
