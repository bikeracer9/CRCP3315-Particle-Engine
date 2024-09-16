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

    int ballCount = 500; //the total amount of balls being drawn.
    int maxRadius = 65; //max size the ball can be.
    int minRadius = 25; //min size the ball can be.

    int alphaValue = 255;


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
            Ball ball = new Ball(main.random(main.width), main.random(main.height), main.random(minRadius, maxRadius), main, main.color(main.random(255), main.random(255), main.random(255)), alphaValue);
            balls.add(ball);
        }
    }

    //draws the balls 
    void draw()
    {
        main.noStroke();

        if (main.keyPressed)
        {
            if( main.key == 'e' || main.key == 'E') //if E is pressed, then do below...
            {
                for(int i = 0; i < balls.size(); i++)
                {
                    balls.get(i).changeColor(); //changes the color of all the objects.
                }
            }

            if( main.key == 'r' || main.key == 'R') //if R is pressed, then do below...
            {
                for(int i = 0; i < balls.size(); i++)
                {
                    balls.get(i).alphaValue = 255; //resets the opacity of the objects.
                }
            }
        }

        main.background(0); //clears the background from the last frame.
        
        for(int i = 0; i < balls.size(); i++)//loops through the balls in the ArrayList
        {
            balls.get(i).draw(); //draws each ball in the list
        }
        checkMouseXY(); //checks to see if the mouse is in the top right corner or not.
    } 

    //mouse interaction below!

    
    //This is the mousePressed function...
    void mousePressed()
    {//if the mouse is pressed, do items below...
        
        for(int i = 0; i < balls.size(); i++) //loops through the balls in the ArrayList.
        {
            balls.get(i).reverseDir(); //calls the reverseDir function in Ball, changes the X & Y direction of the balls.
        }
    }

    /*
     * This function is the checkMouseXY function.
     * It checks to see if the mouseX & mouseY is in a specific spot on the window (the top right corner)
     * If this is true, then it sets the velocity to be 0, otherwise it is always set to 1.
     */
    void checkMouseXY()
    {
        for(int i = 0; i < balls.size(); i++)
        {
            if(main.mouseX >= 700 && main.mouseY <= 100)
            {
                    balls.get(i).xVel = 0;
                    balls.get(i).yVel = 0;
            }
            
            else
            {
                balls.get(i).set_Y_Vel(1);
                balls.get(i).set_X_Vel(1);
            }
        }
    }

    /*
     * This is the mouseDragged function.
     * If the mouse is clicked & dragged, then it changes the opacity of the objects and adds 1 to it.
     */
    void mouseDragged()
    {
        for(int i = 0; i < balls.size(); i++)
        {
            balls.get(i).alphaValue = balls.get(i).alphaValue + 1;
            if(balls.get(i).alphaValue >= 255)
            {
                balls.get(i).alphaValue = 0;
            }
        }
    }

}
