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

    Ball ball;

    //ArrayList<Ball> others; //  OTHER class of balls (used for collide function)

    int ballCount = 500; //the total amount of balls being drawn.
    int maxRadius = 65; //max size the ball can be.
    int minRadius = 25;
    
    // float rR = main.random(255);
    // float rG = main.random(255);
    // float rB = main.random(255);

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
    }

    //adds all the balls to the array. all the attributes are random!
    void init()
    {
        for(int i = 0; i < ballCount; i++)
        {
            Ball ball = new Ball(main.random(main.width), main.random(main.height), main.random(minRadius, maxRadius), main, main.color(main.random(255),main.random(255),main.random(255)));
            balls.add(ball);
        }
    }

    //draws the balls 
    void draw()
    {
        main.noStroke();
        
        if (main.keyPressed)
        {
            if( main.key == 'q' || main.key == 'Q') //if Q is pressed, then do below...
            {
                for(int i = 0; i < balls.size(); i++)//loops through all the balls in the ArrayList.
                {
                    balls.get(i).faster();//makes the balls go faster. called in Ball class.
                    
                    if(balls.get(i).get_Y_Vel() >= 15) //calls the get function to see what the value of yVel is.
                    {
                        balls.get(i).set_Y_Vel(1); //sets the value of yVel back to 1.
                    }
                    
                }
                    
            }

            if(main.key == 'w' || main.key == 'W'  ) //if W is pressed, then do below...
            {
                for(int i =0; i < balls.size(); i++) //loops through all the balls in the ArrayList.
                {
                    balls.get(i).slower(); //makes the balls slow down. called in Ball class.

                    if(balls.get(i).get_Y_Vel() <= 0)//calls the get function to see what the value of yVel is.
                    {
                        balls.get(i).set_Y_Vel(1);//sets the value of yVel back to 1.
                    }
                }
            }
        }
        main.background(0); //clears the background from the last frame.
        for(int i = 0; i < balls.size(); i++)//loops through the balls in the ArrayList
        {
            balls.get(i).draw(); //draws each ball in the list. 
        }
    }

    //mouse interaction below!
    void mousePressed()
    {//if the mouse is pressed, do items below...
        
        for(int i = 0; i < balls.size(); i++) //loops through the balls in the ArrayList.
        {
            balls.get(i).reverseDir(); //calls the reverseDir function in Ball, changes the X & Y direction of the balls.
            
        }
    }

    //collide function when two balls touch each other.
    // void collide()
    // {
    //     for(int i =0; i < balls.size(); i++)
    //     {
    //         float dx = balls.get(i).x - balls.get(i-1).x;
    //         float dy = balls.get(i).y - balls.get(i-1).y;

    //         float distance = sqrt()
    //     }
    // }
    
    // void collide()
    // {
    //     for(int i = 0; i < ballCount; i++)
    //     {
    //         float dx = others.get(i).x - balls.get(i).x;
    //         float dy = others.get(i).y - balls.get(i).y;
            
    //         float distance = (float) sqrt(dx*dx + dy*dy);
    //         float minDist = others.get(i).radius + balls.get(i).radius;
    //         if(distance < minDist)
    //         {
    //             float xdir_ = balls.get(i).get_X_Direction();
    //             xdir_ = xdir_ * -1;
    //             System.out.println("h");
    //             balls.get(i).set_X_Direction(xdir_);
    //         }
            
    //     }
    // }
}
