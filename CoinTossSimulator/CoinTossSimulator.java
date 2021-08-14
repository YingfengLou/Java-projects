// Name:Yingfeng Lou
// USC NetID: louy
// CS 455 PA1
// Spring 2021

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;

public class CoinTossSimulator {

   private int twoHeads;
   private int twoTails;
   private int headTails;



   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;

   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {

      Random rand = new Random();

      for(int i = 0; i < numTrials; i++)
      {
         int firstCoin = rand.nextInt(2);
         int secondCoin = rand.nextInt(2);

         if (firstCoin == 1)
         {
            if (secondCoin == 1){
               twoHeads++;
            }
            else{
               headTails++;
            }
         }
         else
         {
            if(secondCoin == 1){
               headTails++;
            }
            else{
               twoTails++;
            }
         }

      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
      return getTwoHeads() + getTwoTails() + getHeadTails();  // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;

   }

}
