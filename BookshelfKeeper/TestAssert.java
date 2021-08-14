
import java.util.Scanner;

public class TestAssert{
    /**
     * this's the program testing assert method.
     */
    public static void main(String[] args){

        String words = "Hello world";
        int num = longestWordLen(words);
        System.out.println(num);
    }

    private static int longestWordLen(String words) {
        Scanner scanner = new Scanner(words);
        return longestWordlenhepler(scanner.next(), scanner);
    }

    private static int longestWordlenhepler(String words, Scanner scanner) {
        int longest = 0;
        if (!scanner.hasNext()) {
            return longest;
        }
        else{
            if (scanner.next().length() > longest) {
                longest = scanner.next().length();
                Scanner scanner1 = new Scanner (scanner.next());
                longestWordlenhepler(scanner.next(), scanner1);
            }
        }
        return longest;
    }
}




