import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
    //Colecion de BouncingBall.
    private ArrayList<BouncingBall> bolas;
    //Colecion de BoxBall.
    private ArrayList<BoxBall> bolasBox;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<BouncingBall>();
        bolasBox = new ArrayList<BoxBall>();
    }

    /**
     * Simula el número de bolas que asigna el usuario min 1.
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line
        Random num = new Random();
        Color colores = new Color(num.nextInt(23));
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i = 0; i < numBolas; i++){
            Color color = new Color(num.nextInt(255),num.nextInt(255),num.nextInt(255));
            bolas.add(new BouncingBall(num.nextInt(200), num.nextInt(150), num.nextInt(50), color, ground, myCanvas));
            bolas.get(i).draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < bolas.size() && !finished;i++){
                bolas.get(i).move();
                if(bolas.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }

    /**
     * 
     */
    public void boxBounce(int numBolas)
    {
        Random num = new Random();
        Color colores = new Color(num.nextInt(23));
        myCanvas.setVisible(true);
        // draw the ground
        myCanvas.drawLine(0, 0, 550, 0);
        myCanvas.drawLine(550, 0, 550, 300);
        myCanvas.drawLine(550, 300, 0 , 300);
        myCanvas.drawLine(0, 300, 0, 0);

        for(int i = 0; i < numBolas; i++){
            int xSpeed = 1;
            if(num.nextInt(2) == 0){
                xSpeed = -1;
            }
            int ySpeed = 1;
            if(num.nextInt(2) == 0){
                ySpeed = -1;
            }
            Color color = new Color(num.nextInt(255),num.nextInt(255),num.nextInt(255));
            bolasBox.add(new BoxBall(num.nextInt(200), num.nextInt(150), num.nextInt(50), color, ySpeed, xSpeed, 300, 550, 0, 0, myCanvas));
            bolasBox.get(i).draw();
        }
        boolean infinito = true;
        while(infinito){
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < bolasBox.size();i++){
                bolasBox.get(i).move();
            }
        }
    }
}
