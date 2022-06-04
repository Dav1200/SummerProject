package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GameView extends UserView implements StepListener {

    private Image background;
    private GameWorld World;
    private Player student;


    public GameView(GameWorld w, int width, int height, Player student) {
        super(w, width, height);
        this.student = student;
        this.World = World;
        background = new ImageIcon("data/Grass_Sample.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        Point2D d = worldToView(new Vec2(0, 0));

       /// int i = 0;
       // int k = 0;
      //  while(i<25){
      //      while(k<25){
      //          g.drawImage(background, (int) d.getX() + i * 704, (int) d.getY()+k*320, this);
      //          g.drawImage(background, (int) d.getX() - i * 704, (int) d.getY()-k*320, this);
      //          g.drawImage(background, (int) d.getX(), (int) d.getY()+k*320, this);
       //         g.drawImage(background, (int) d.getX() , (int) d.getY()-k*320, this);
        //            i++;
        //            k++; ///


        for(int i=0; i<10; i++) {


            for (int k = 0; k < 10; k++) {


                g.drawImage(background, (int) d.getX() + i * 704, (int) d.getY() + k * 320, this);
                g.drawImage(background, (int) d.getX() - i * 704, (int) d.getY() - k * 320, this);
                g.drawImage(background, (int) d.getX() + i * 704, (int) d.getY() - k * 320, this);
                g.drawImage(background, (int) d.getX() - i * 704, (int) d.getY() + k * 320, this);
            }
        }

        }


          /* g.drawImage(background, (int) d.getX() + 704, (int) d.getY(), this);
           g.drawImage(background, (int) d.getX(), (int) d.getY() + 310, this);
           g.drawImage(background, (int) d.getX() + 704, (int) d.getY() + 310, this);
           g.drawImage(background, (int) d.getX(), (int) d.getY() + 610, this);
           g.drawImage(background, (int) d.getX() + 704, (int) d.getY() + 610, this);

           */





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
