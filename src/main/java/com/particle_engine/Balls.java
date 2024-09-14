/*
 * Prescott Lau
 * Sept 12th 2024
 * Balls -- particle engine simulation.
 */
package com.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;

public class Balls {
    PApplet main; //the main class -- provides all the functionality of processing.
    ArrayList<Ball> balls; //all of the balls were drawing.

    //Ball ball; //test case ball

    int ballCount = 200; //the total amount of balls being drawn.
    int maxSize = 55; //max size the ball can be.
    int minSize = 25;

    Balls(PApplet main_)
    {
        main = main_;
        balls = new ArrayList<>();
        init(); //initializes the balls.
    }

    //setup everything you need for the particle engine
    void setup()
    {
        main.background(0);
        //ball = new Ball(main.random(0.f,800.f), main.random(0.f,800.f), main.random(20.f,100.f), main, main.color(main.random(255),main.random(255),main.random(255))); //creates a ball, starting at a random position & with a random size & color
        //ball = new Ball(main.width/2.f, main.height*.10f, 50.f, main, main.color(main.random(255), main.random(255), main.random(255) ) );
    }

    //adds all the balls to the array. all the attributes are random!
    void init()
    {
        for(int i = 0; i < ballCount; i++)
        {
            //Ball ball = new Ball(main.random(main.width.f), main.random(main.height.f), main.random(main.maxSize.f), main, main.color(main.random(255.f), main.random(255.f), main.random(255.f) ) );
            Ball ball = new Ball(main.random(main.width), main.random(main.height), main.random(minSize, maxSize), main, main.color(main.random(255),main.random(255),main.random(255)));
            balls.add(ball);
        }
    }

    //draws the balls 
    void draw()
    {
        main.noStroke();
        main.background(0); //clears the background from the last frame.
        //ball.draw();

        for(int i = 0; i < balls.size(); i++)
        {
            balls.get(i).draw(); //
        }
    }

    //setup everything you need for the mouse interaction
    void mousePressed()
    {
        //ball.faster();
    }

}
