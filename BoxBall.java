import java.awt.*;
import java.awt.geom.*;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    private static final int GRAVITY = 0;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed;                // initial downward speed
    private int xSpeed;
    private int suelo;
    private int paredDerecha;
    private int techo;
    private int paredIzquierda;
    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int ySpeed, int xSpeed, 
                        int suelo, int paredDerecha, int techo, int paredIzquierda, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
        this.suelo = suelo;
        this.paredDerecha = paredDerecha;
        this.techo = techo;
        this.paredIzquierda = paredIzquierda;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        xPosition = xPosition + xSpeed;
        yPosition = yPosition + ySpeed;
        // check if it has hit the ground
        if(yPosition == suelo - diameter) {
            ySpeed = -1;
        }
        else if(yPosition == techo){
            ySpeed = 1;
        }
        
        if(xPosition == paredDerecha - diameter){
            xSpeed = -1;
        }
        else if(xPosition == paredIzquierda){
            xSpeed = 1;
        } 
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}