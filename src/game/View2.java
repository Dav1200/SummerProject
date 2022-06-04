package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class View2 extends UserView implements StepListener {

    private Image background;
    private GameWorld World;
    private Player student;


    public View2(GameWorld w, int width, int height, Player student) {
        super(w, width, height);
        this.student = student;
        this.World = World;
        background = new ImageIcon("data/Grass_Sample.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(background, 0, 0, this);
        g.drawImage(background, 704, 0, this);
        g.drawImage(background, 0, 310, this);
        g.drawImage(background, 704, 310, this);
        g.drawImage(background, 0, 610, this);
        g.drawImage(background, 704, 610, this);


    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        setCentre(student.getPosition());
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
