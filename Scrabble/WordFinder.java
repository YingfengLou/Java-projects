// Name: Xinhong Liu
// USC NetID: 3732527587
// CS 455 PA4
// Spring 2021

import java.io.FileNotFoundException;
import java.util.*;

/**
 *This class contains the main method that's responsible for processing the command- line argument,
 * and handling any error processing.
 * This program simulate Scrabble game, print all valid result combinations in score decreasing order,
 * if two words have the same score, print in lexicographical order
 *
 * run program as: java WordFinder [dictionaryFile]
 * [dictionaryFile] dictionary to look up from, default: sowpods.txt
 * type . to quit
 *
 * NOTE:
 * this program don't think about a input with a white-space
 * this program is case-sensitive
 * this program will ignore any other characters in the input
 */

public class WordFinder {


    /**
     * This is the main method, that's responsible for processing the command- line argument, and handling any error processing.
     *   args is an optional command-line input to choose the dictionary
     *   If users don't type anything,we will use the default dictionary sowpods.txt
     * @param args  command- line argument
     *
     */

    public static void main(String[] args) {

        String dictionaryFile;

        if(args.length > 0){
            dictionaryFile = args[0];
        } else{
            dictionaryFile = "sowpods.txt";
        }

        try {
            AnagramDictionary dictionary = new AnagramDictionary(dictionaryFile);
            System.out.println("Type . to quit.");
            Scanner in = new Scanner(System.in);

            while(true){
                System.out.print("Rack? ");
                String str = in.next();
                if(str.equals(".")){
                    in.close();
                    break;
                } else {
                    //get result
                    HashMap<String, Integer> wordForResult = getResult(str, dictionary);
                    //sort result and print
                    sortResultAndPrint(str,wordForResult);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Dictionary file" +   dictionaryFile + "does not exist");
     //       System.out.println("Exit program.");
            System.exit(0);
        } catch (IllegalDictionaryException exception) {
            System.out.println("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + exception.getMessage());
     //       System.out.println("Exit program.");
            System.exit(0);
        }
    }


    /**
     * This method is used to get result: the word and score.
     * the length of word must be greater than 1
     *
     * @param str  the the canonical format of original input
     * @param dictionary  the anagram dictionary
     * @return  wordForResult  the original result without sorting
     */


    private static HashMap<String, Integer> getResult (String str, AnagramDictionary dictionary) {

        Rack rack = new Rack();
        ScoreTable scoreTable = new ScoreTable();
        //make only the valid character left, like @abc -> abc
        String formattedRack = getFormattedRack(str);
        //get all subsets of rack
        ArrayList<String> subsets = rack.subsets(formattedRack);
        //to save the result
        HashMap<String, Integer> wordForResult = new HashMap<>();

        for (String s : subsets) {
            // only look for words length greater than 1
            if (s.length() >= 2) {
                int score = scoreTable.getScore(s);
                ArrayList<String> correspondWords = dictionary.getAnagramsOf(str);

                if(correspondWords != null) {
                    // put all words in map
                    for(String word:correspondWords) {
                        wordForResult.put(word, score);
                    }
                }
            }
        }
        return wordForResult;
    }


    /**
     * This is method make only the valid character left, like @abc -> abc
     * @param str input string from user
     * @return the the canonical format of original input
     */


    private static String getFormattedRack (String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }




    /**
     * This method is used to sort the result following this rule:
     *  1. Descending order of score
     *  2. If scores are the same, sort them in alphabetical order
     * @param str  the the canonical format of original input
     * @param wordForResult the original result without sorting
     */

    private static void sortResultAndPrint(String str, HashMap<String, Integer> wordForResult) {
        ArrayList<Map.Entry<String, Integer>> sortedRes = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : wordForResult.entrySet()) {
            sortedRes.add(entry);
        }

        Collections.sort(sortedRes, new MyComparator());
        displayFinalResult(str,sortedRes);
    }


    /**
     *
     * @param str   the the canonical format of original input
     * @param sortedRes  the result with sorted
     */
    private static void displayFinalResult (String str, ArrayList<Map.Entry<String, Integer>> sortedRes ) {

        int numOfWords = sortedRes.size();
        System.out.println("We can make " + numOfWords + " words from " + "\"" + str + "\"");
        if(numOfWords != 0) {
            System.out.println("All of the words with their scores (sorted by score):");
        }
        for(Map.Entry<String, Integer> entry : sortedRes) {
            System.out.printf(entry.getValue() + ":" + entry.getKey());
        }

    }

}


/**
 * MyComparator is used to sort the result, sort the result in descending score order,
 * If they have the same score, compare the key, then sort in alphabetical order
 */

class MyComparator implements Comparator<Map.Entry<String,Integer>>{

    @Override

    public int compare(Map.Entry<String,Integer> result1, Map.Entry<String,Integer> result2){

        if(result1.getValue().equals(result2.getValue())) {
            return result1.getKey().compareTo(result2.getKey());
        } else {
            return result2.getValue() - result1.getValue();
        }
    }
}

