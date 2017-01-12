package module2;

import processing.core.PApplet;

/**
 * Created by vicentem on 12/6/16.
 */
public class MyDisplay extends PApplet{

    public void setup()
    {
        size(600, 600);
        background(250, 200, 200);

    }

    public void draw()
    {
        fill(200, 200, 0);
        ellipse(300,300, 550, 600);

        // eyes
        fill(0, 0, 0);
        //moves the rest of the objects 0,60
        translate(0, 60);
        ellipse(150, 140, 70, 70);

        ellipse(450, 140, 70, 70);



        //mouth
//        noFill();
        arc(300, 400, 150, 150, 0, PI);

        fill(255);
        rect(0, 0, 50, 50);
        pushMatrix();
        translate(30, 20);
        fill(0);
        rect(0, 0, 50, 50);  // Black rectangle
        popMatrix();

        fill(100);
        rect(15, 10, 50, 50);  // Gray rectangle


    }
}
