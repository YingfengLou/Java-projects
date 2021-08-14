// Name: Xinhong Liu
// USC NetID: 3732527587
// CS 455 PA4
// Spring 2021

/**
 * Score table for letters and calculate the score for each word
 *  1 point - A, E, I, O, U, L, N, S, T, R
 *  2 points - D, G
 *  3 points - B, C, M, P
 *  4 points - F, H, V, W, Y
 *  5 points - K
 *  8 points -  J, X
 *  10 points - Q, Z
 */

public class ScoreTable {

    private static final int[] SCORE_TABLE = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    /**
     * This method is to calculate the score for each word
     * @param word
     * @return score
     */

    public int getScore (String word) {
        int len = word.length();
        int score = 0;
        for(int i = 0; i < len; i++) {
            char c =  Character.toLowerCase(word.charAt(i));
            score += SCORE_TABLE[Character.toLowerCase(c)- 'a'];
        }
        return score;

    }
}
