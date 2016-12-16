package module2;
import processing.core.*;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Created by vicentem on 12/3/16.
 */
public class MyPApplet extends PApplet{
    String url = "https://processing.org/img/processing-web.png";
    private PImage backgroundImg;

    public void setup(){
        size(800, 800);

        System.setProperty("user.dir", "/home/vicentem/MyDev/Software/Java/UCSDUnfoldingMaps/src/module2");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        backgroundImg = loadImage("/home/vicentem/MyDev/Software/Java/UCSDUnfoldingMaps/src/module2/beach.png");
//        backgroundImg = loadImage(url, "png");
    }

    public void draw()
    {
        int [] Rgb;
        backgroundImg.resize(0, height);
        image(backgroundImg, 0, 0);
//        Rgb = check_time();
        Rgb = sunColorSec(second());
        fill(Rgb[0], Rgb[1], Rgb[2]);

        ellipse(width/3, height/3, width/5, height/5);
    }

    private  static int[] check_time(){
/**
 * This function checks the time of the day
 * only the HR, and based on that return the proper
 * color for the sun :).
 */
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH");
        int [] rgb={0, 0, 0};
        String time = localDateFormat.format(new Date());

        int itime = Integer.parseInt(time);
        System.out.println(itime);
        if (itime>=15 & itime < 17){
            System.out.println("mid afternoon");
            rgb[0] = 255;
            rgb[1] = 209;
            rgb[2] = 0;

        }
        else if (itime>=17 & itime < 18){
            System.out.println("late afternoon");
            rgb[0] = 255;
            rgb[1] = 160;
            rgb[2] = 0;
        }
        return rgb;
    }

    public int[] sunColorSec(float seconds)
    {
        int [] rgb = new int[3];
        // scale the brightness of the yellow based on the seconds
        float diffSec = Math.abs(30-seconds);

        float ratio = diffSec/30;
        rgb[0] = (int)(255*ratio);
        rgb[1] = (int)(255*ratio);
        rgb[2] = 0;

        return rgb;
    }

}
