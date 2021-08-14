// Name:Yingfeng Lou
// USC NetID:louy
// CS 455 PA1
// Spring 2021

/**
 * CoinTossSimulatorTester class
 * Contains the main method. Test for CoinTossSimulator class independently.
 * When running this program, see if results equal to expected values.
 *
 * test that the sum of the number of two-head tosses, two-tail tosses,
 * and head-tail tosses adds up to the total number of trials.
 */

public class CoinTossSimulatorTester
{
    public static void main(String[] args)
    {
        CoinTossSimulator tester = new CoinTossSimulator();

        //Test function of simulator.
        System.out.print("After constructor:\n");
        System.out.println("Number of Trials[exp:0]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(1):\n");
        tester.run(1);
        System.out.println("Number of Trials[exp:1]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(10):\n");
        tester.run(10);
        System.out.println("Number of Trials[exp:11]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(100):\n");
        tester.run(100);
        System.out.println("Number of Trials[exp:111]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(500):\n");
        tester.run(500);
        System.out.println("Number of Trials[exp:611]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(2500):\n");
        tester.run(2500);
        System.out.println("Number of Trials[exp:3111]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        //test function of reset
        System.out.print("After reset: \n");
        tester.reset();
        System.out.println("Number of Trials[exp:0]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(1000):\n");
        tester.run(1000);
        System.out.println("Number of Trials[exp:1000]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After reset: \n");
        tester.reset();
        System.out.println("Number of Trials[exp:0]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

        System.out.print("After run(2500):\n");
        tester.run(2500);
        System.out.println("Number of Trials[exp:2500]:" + tester.getNumTrials());
        System.out.println("Two-head tosses:" + tester.getTwoHeads());
        System.out.println("Two-tail tosses:" + tester.getTwoTails());
        System.out.println("One-head one-tail tosses:" + tester.getHeadTails());
        System.out.print("Tosses add up correctly? ");
        System.out.println(tester.getNumTrials() == tester.getTwoHeads() + tester.getHeadTails()
                + tester.getTwoTails());
        System.out.println();

    }
}