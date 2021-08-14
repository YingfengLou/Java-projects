// Name: Xinhong Liu
// USC NetID: 3732527587
// CS 455 PA4
// Spring 2021

import java.util.ArrayList;
import java.util.HashMap;

/**
   A Rack of Scrabble tiles
 */

public class Rack {

   /**
    This method is to preprocess the input to contains only one character and their frequency,
    the transfer them to allSubsets method
    @param input a string of input word
    */

   public ArrayList<String> subsets(String input) {
      // map use to save letters and frequency
      HashMap<Character, Integer> letter = new HashMap<>();
      int length = input.length();
      // loop through input and calculate frequency
      for(int i = 0; i < length; i++) {
         char c = input.charAt(i);
         letter.put(c, letter.getOrDefault(c, 0) + 1);
      }

      // corresponding frequency to the letter
      int[] mult = new int[letter.size()];
      int pointer = 0;
      // unique letters
      String unique = "";
      for(Character c:letter.keySet()) {
         unique += c;
         mult[pointer] = letter.get(c);
         pointer++;
      }
      return allSubsets(unique, mult, 0);
   }

//   public ArrayList<String> subsets(String input) {
//      // hash map used to save every character and their frequency
//      HashMap<Character, Integer> frequencyOfChar = new HashMap<>();
//
//      for(int i = 0; i < input.length(); i++) {
//         char c = input.charAt(i);
//         frequencyOfChar.put(c, frequencyOfChar.getOrDefault(c, 0) + 1);
//
//
////         if (frequencyOfChar.containsKey(c)) {
////            frequencyOfChar.put(c, frequencyOfChar.get(c) + 1 );
////         } else {
////            frequencyOfChar.put(c, 1);
////         }
//      }
//
//      // mult is to save the  frequency of the corresponding letter
//      int[] mult = new int[frequencyOfChar.size()];
//      StringBuilder unique = new StringBuilder();
//
//      for (int index = 0; index < mult.length; index ++) {
//         for(Character c : frequencyOfChar.keySet()) {
//            unique.append(c);
//            mult[index] = frequencyOfChar.get(c);
//         }
//      }
//
//      return allSubsets(unique.toString(), mult, 0);
//   }
   



   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

}
