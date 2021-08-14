// Name: Xinhong
// USC NetID: 3732527587
// CS 455 PA4
// Spring 2021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {

   /**
    * Create a Hash map to store characters in alphabetical order from original dictionary and corresponding anagrams in dictionary.
    */
   private Map<String, ArrayList<String>> dictionary = new HashMap<>();
   

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException {
      // Create file object to get the file.
      File file = new File(fileName);
      Scanner in = new Scanner(file);

      /**
       * Pre-process the dictionary.
       * Fill the anagram map to contain the key (sort characters of word in alphabetical orderin dictionary),
       * and values (anagrams in dictionary).
       */
      while (in.hasNext()){
         String word = in.next();
         String canonicalForm = getCanonicalFormWord(word);

         ArrayList<String> SubSetsInDic = dictionary.get(canonicalForm);

         // Update the map
         if(SubSetsInDic == null){
            SubSetsInDic = new ArrayList<>();
            SubSetsInDic.add(word);
         } else{
            if(dictionary.get(canonicalForm).contains(word)) {
               // if dict has repeated words
               throw new IllegalDictionaryException(word);
            } else {
               SubSetsInDic.add(word);
            }
         }
         dictionary.put(canonicalForm, SubSetsInDic);
      }
   }



   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s

    */
   public ArrayList<String> getAnagramsOf(String s) {
      String sortedString = getCanonicalFormWord(s);
      if(dictionary.get(sortedString) != null) {
         return dictionary.get(sortedString);
      } else {
         return null;
      }
   }

   /**
    * This method is to get Canonical Form of Word
    * such as cmal -> aclm
    * @param word  the original word
    * @return canonicalForm Canonical Form of Word
    */
   public static String getCanonicalFormWord(String word){

      char[] array =word.toCharArray();
      // sort input characters in an ascending order
      Arrays.sort(array);

      String canonicalForm = String.valueOf(array);
      return canonicalForm;
   }


}
