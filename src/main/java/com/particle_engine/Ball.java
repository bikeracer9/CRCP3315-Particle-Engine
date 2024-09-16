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

    int alphaValue; //value that changes the balls opacity. 

    //ball constructor.
    Ball(float x_, float y_, float radius_, PApplet main_, int c, int a)
    {
        x = x_;
        y = y_;
        radius = radius_;
        ballColor = c;
        alphaValue = a;

        main = main_;
    }

    //draw function for the balls.
    void draw()
    {
        main.fill(ballColor, alphaValue); //colors the ball with color and set opacity.
        main.ellipse(x,y,radius,radius); //draws an ellipse
        move(); //calls the move function
    }

    //this is the move function, it is what makes the ball move around the screen.
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

    
    /*
    * This is the setter function for the yVel float.
    * This is called in the Balls function to set it 
    * to 0 (when the mouse is in the top right corner) 
    * or 1 (when the mouse is NOT in the top right corner).
    */
    public void set_Y_Vel(float newYVel)
    {
        this.yVel = newYVel;
    }

    /*
    * This is the setter function for the xVel float.
    * This is called in the Balls function to set it 
    * to 0 (when the mouse is in the top right corner) 
    * or 1 (when the mouse is NOT in the top right corner).
    */
    public void set_X_Vel(float newXVel)
    {
        this.xVel = newXVel;
    }

    /*
     * This is the changeColor function.
     * This function randomly changes the color of the balls when called by pressing the 'E' key.
     */
    void changeColor()
    {
        ballColor = main.color(main.random(255),main.random(255),main.random(255));
    }

    /*
    * This function is the reverseDirection method,
    * It is called in the Balls class in mousePressed(), 
    * and it changes the direction of the balls when the mouse is pressed.  
    */
    void reverseDir()
    {
        // xVel *= -1;
        // yVel *= -1;

        y_direction *= -1;
        x_direction *= -1;
    }

}
