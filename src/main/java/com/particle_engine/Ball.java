/*
 * Prescott Lau
 * "Particle Engine" Assignment
 * September 10th, 2024
 * Description: Ball -- a ball that moves around the window and bounces off the window's borders.
 */
package com.particle_engine;
import processing.core.PApplet;

public class Ball {
    PApplet main; //the main class -- provides all the functionality of processing 

    float x,y; //location of the ball
    
    float yVel = 1; //how fast the ball moves on the Y axis.
    float xVel = 1; //how fast the ball moves on the X axis.
    
    float y_direction = 1; //which direction the ball moves in. 1 = down (adding); -1 = up (subtracting)
    float x_direction = 1; //which direction the ball moves in on the X axis. 1 = down (adding); -1 = up (subtracting)

    float radius; //radius (how big the ball is)
    int ballColor; //color of the ball

    Ball(float x_, float y_, float radius_, PApplet main_, int c)
    {
        x = x_;
        y = y_;
        radius = radius_;
        ballColor = c;

        main = main_;
        
    }

    void draw()
    {
        main.fill(ballColor); //colors the ball
        main.ellipse(x,y,radius,radius); //draws an ellipse
        move(); //calls the move function
    }

    void move()
    {
        y += yVel * y_direction; // equation to make the ball move in the Y axis and in the correct direction.
        x += xVel * x_direction; // equation to make the ball move in the X axis and in the correct direction.

        if(y > main.height) //if the value of the ball on the Y axis is greater than
        {                   //the bottom of the screen value, then the ball will change directions.
            y_direction = -1;
        }

        if(y < 0) //if the value of the ball on the Y axis is greater than
        {        //the top of the screen value then, the ball will change directions.
            y_direction = 1;
        }

        if(x > main.height) //if the value of the ball on the X axis is greater than
        {                   //the bottom of the screen value, then the ball will change directions.
            x_direction = -1;
        }

        if(x < 0) //if the value of the ball on the X axis is greater than
        {        //the top of the screen value then, the ball will change directions.
            x_direction = 1;
        }

    }

    void faster() //called in the main, mouseclicked function
    {             // - clicking the mouse makes the ball move faster.
        yVel++;
    }
}
