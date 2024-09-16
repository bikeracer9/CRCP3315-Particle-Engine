/*
 * Prescott Lau
 * "Particle Engine" Assignment
 * September 10th, 2024
 * This project uses OOP to create a particle engine with at least 500 particles. 
 * This is the Main Balls file.
 */

package com.particle_engine;

import processing.core.PApplet;


public class Main extends PApplet {

    Balls balls; //draws the simulation to the screen
    public static void main(String[] args) { //sets up processing
        PApplet.main("com.particle_engine.Main");
    }

    //sets up the size of the window
    public void settings()
    {
        size(800, 800);
        balls = new Balls(this);
    }
    
    /*
     * This is the setup function
     * Changes the background color to black.
     */
    public void setup()
    {               
        balls.setup(); //calls the balls from the class into the main function
    } 

    /*
    * This is the main draw function.
    * Draws everything on the screen.
    */
    public void draw()
    {
        balls.draw();
    }

    /*
     * This is the mousePressed method. 
     * When the mouse is pressed, the objects move in the opposite direction.
     */
    public void mousePressed()
    {
        balls.mousePressed();
    }

    /*
     * This is the mouseDragged method. 
     * When the mouse is dragged, the opacity of the objects all change. 
     */
    public void mouseDragged()
    {
            balls.mouseDragged();
    }
}