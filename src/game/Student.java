package game;

import city.cs.engine.*;

public class Student extends Walker implements StepListener {
    private static final Shape studentShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    private GameWorld world;
    private int score = 0;


    public Student(GameWorld world) {
        super(world, studentShape);
        addImage(image);
        score = 0;
        this.world = world;

    }




    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
