package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {
    public GameView getView() {
        return view;
    }

    private GameView view;

    /**
     * Initialise a new Game.
     */
    public Game() {

        //1. make your game world
        GameWorld world = new GameWorld(getView());


        //2. make a view to look into the game world
        view = new GameView(world, 1280, 720, world.getStudent());
        view.setZoom(16);
        world.addStepListener(world.getStudent());
        world.addStepListener(view);

        world.addStepListener(world.getEnemies());
        //optional: draw a 1-metre grid over the view


        MouseFocus focus = new MouseFocus(world, view);
        Movement move = new Movement(world);

        view.addMouseListener(focus);
        view.addKeyListener(move);


        //3. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //  JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {

        new Game();
    }
}
