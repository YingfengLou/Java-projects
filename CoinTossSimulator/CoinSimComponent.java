// Name:Yingfeng Lou
// USC NetID:louy
// CS 455 PA1
// Spring 2021

import java.awt.*;
import javax.swing.JComponent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * CoinSimComponent class
 *
 * Constructor initializes necessary data, runs the simulation, get the bar graph.
 *
 */

public class CoinSimComponent extends JComponent
{
    private static final int BOTTOM =20;
    private int bottom;
    private int twoHeadsleft, twoTailsleft, headTailsleft;
    private static final int WIDTH = 50;
    private int twoHeadsHeight, twoTailsHeight, headTailsHeight;
    private double scale;
    private String label1, label2, label3;
    //private CoinTossSimulator tossSim;
    //private int numTrials;

    private int totalTrials;

    /**
     Runs the simulation for numTrials and get label names of each bar
     @param numTrials  number of trials to for simulation.
     */

   public CoinSimComponent(int numTrials)
   {
       CoinTossSimulator tossSim= new CoinTossSimulator();
       tossSim.run(numTrials);

       twoHeadsHeight = tossSim.getTwoHeads();
       twoTailsHeight = tossSim.getTwoTails();
       headTailsHeight = tossSim.getHeadTails();
       totalTrials = tossSim.getNumTrials();

       label1 = "Two Heads: " + twoHeadsHeight + "(" +
               Math.round((float)twoHeadsHeight/totalTrials * 100) + "%" + ")";
       label3 = "Two Tails: " + twoTailsHeight + "(" +
               Math.round((float)twoTailsHeight/ totalTrials * 100) + "%" + ")";
       label2 = "A Head and a Tail: " + headTailsHeight + "(" +
               Math.round((float)headTailsHeight / totalTrials * 100) + "%" + ")";

   }

    /**
     Get left locations, scale,and bottoms, call Bar to draw the graph.
     @param g  graphic.
     */
   public void paintComponent(Graphics g)
   {
       Graphics2D g2 = (Graphics2D) g;

       //Get locations of left
       int leftUnit = (getWidth() - 3 * WIDTH) / 4;
       twoHeadsleft = leftUnit;
       headTailsleft = leftUnit*2 + WIDTH;
       twoTailsleft = leftUnit*3 + WIDTH*2;

       //Get scale by calcualting label height and vertical buffer.
       Font font =g2.getFont();
       FontRenderContext context = g2.getFontRenderContext();
       Rectangle2D labelBounds = font.getStringBounds(label1, context);
       int heightOfLabel = (int) labelBounds.getHeight();
       int verticalBuffer = BOTTOM + heightOfLabel;
       scale = (double)(getHeight() - 2 * verticalBuffer) / totalTrials;

       //Get bottoms that defined in Bar.
       bottom = getHeight() - BOTTOM;

      //Call Bar Class to draw the graph.
       Bar twoHeads = new Bar(bottom, twoHeadsleft, WIDTH, twoHeadsHeight, scale, Color.RED, label1);
       Bar headTails = new Bar(bottom, headTailsleft, WIDTH, headTailsHeight, scale, Color.GREEN, label2);
       Bar twoTails = new Bar(bottom, twoTailsleft, WIDTH, twoTailsHeight, scale, Color.BLUE, label3);

       twoHeads.draw(g2);
       twoTails.draw(g2);
       headTails.draw(g2);
   }
    
}
