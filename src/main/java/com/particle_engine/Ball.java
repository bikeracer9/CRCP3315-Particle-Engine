/*
 * Prescott Lau
 * "Particle Engine" Assignment
 * September 10th, 2024
 * Description: Ball -- a ball that moves around the window and bounces off the window's borders.
 */
package com.particle_engine;
import processing.core.*;

public class Ball {
    PApplet main;
    float x,y; //location of the ball
    float radius; //radius (how big the ball is)

    Ball(float x_, float y_, float radius_)
    {
        x = x_;
        y = y_;
        radius = radius_;
    }

    void draw()
    {
        ellipse(x,y,radius,radius);
    }

}
