// Name:Yingfeng Lou
// USC NetID:louy
// CS 455 PA1
// Spring 2021

import javax.swing.JFrame;
import java.util.Scanner;

/**
 * CoinSimViewer class
 * Contains the main method. Prompts for the number of trials.
 * When running this program, enter the number of trials and get the simulating result.
 */

public class CoinSimViewer 
{
    public static void main(String[] args)
    {
        //Construct the bar window.
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Prompt enter number of trials and read it.
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of trials:");
        int trialsNumber = in.nextInt();

        //Error-checking.
        while (trialsNumber <= 0)
        {
            System.out.print("ERROR: Number entered must be greater than 0.\n");
            System.out.println("Enter number of trials:");
            trialsNumber = in.nextInt();
        }

        //Draw the bars.
        CoinSimComponent component = new CoinSimComponent(trialsNumber);
        frame.add(component);

        frame.setVisible(true);
    }
}
