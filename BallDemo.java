import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    
    private ArrayList<BouncingBall> bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simula el número de bolas que asigna el usuario min 1.
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        BouncingBall a = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);

        for(int i = 0; i < numBolas; i++){
            a = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
            a.draw();
        }
        a.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            a.move();
            // stop once ball has travelled a certain distance on x axis
            if(a.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
