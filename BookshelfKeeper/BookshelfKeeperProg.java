// Name: Yingfeng Lou
// USC NetID: louy
// CSCI455 PA2
// Spring 2021

import java.util.Scanner;
import java.util.ArrayList;

/**
 * BookshelfKeeperProg class
 * Contains the main method. Prompts entering the initial arrangement of books.
 * When running this program, initial arrangement of books followed by newline.
 */
public class BookshelfKeeperProg {
    public static void main(String[] args){
        System.out.println("Please enter initial arrangement of books followed by newline:");
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> books = new ArrayList<>();
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNextInt()){
            int num = lineScanner.nextInt();
            books.add(num);
        }
        checkInitial(books);
        Bookshelf bookshelf = new Bookshelf(books);
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(bookshelf);
        System.out.println(bookshelfKeeper.toString());
        doCommands(in, bookshelfKeeper);
        }

    /**
     * Check the initial arrangement. Check the list of numbers are all positive
     * and in non-decreasing order.
     * @param books the list of numbers of initial arrangement.
     */
    private static void checkInitial(ArrayList<Integer> books){
        for(int i = 0; i < books.size(); i++){
            if (books.get(i) <= 0){
                System.out.println("ERROR: Height of a book must be positive.");
                System.out.println("Exiting Program.");
                System.exit(0);
            }
        }
        for (int j = 1; j < books.size(); j++){
            if (books.get(j) < books.get(j - 1)){
                System.out.println("ERROR: Heights must be specified in non-decreasing order.");
                System.out.println("Exiting Program.");
                System.exit(0);
            }
        }
    }

    /**
     * Do commands entered by users. Print corresponding error message when a error happened
     * Errors include: command is not pick, put or end; put non-positive height book; pick the position
     *                 beyond the valid bounds.
     * @param in the Scanner
     * @param bookshelfKeeper do commands in this bookshelfKeep
     */
    private static void doCommands(Scanner in, BookshelfKeeper bookshelfKeeper){
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
        while(in.hasNext()){
            String type = in.next();
            if (type.equals("pick")){
                int pos = in.nextInt();
                checkPic(pos, bookshelfKeeper);
                bookshelfKeeper.pickPos(pos);
                System.out.println(bookshelfKeeper.toString());
            } else if(type.equals("put")){
                int height = in.nextInt();
                checkPut(height);
                bookshelfKeeper.putHeight(height);
                System.out.println(bookshelfKeeper.toString());
            } else if(type.equals("end")){
                System.out.println("Exiting Program.");
                break;
            } else{
                System.out.println("ERROR: Operation should be either pick or put.");
                System.out.println("Exiting Program.");
                break;
            }
        }
    }

    /**
     * Check if the height is positive
     *
     * @param height the height of a book we want to put in.
     */
    private static void checkPut(int height){
        if (height <= 0){
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            System.exit(0);
        }
    }

    /**
     * Check if the position of a book we want to pick is within in valid bounds.
     *
     * @param position the position of a book we want to pick
     * @param bookshelfKeeper the valid bounds is for this bookshelfkeeper.
     */
    private static void checkPic(int position, BookshelfKeeper bookshelfKeeper){
        if (position >bookshelfKeeper.getNumBooks() - 1 ){
            System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
            System.out.println("Exiting Program.");
            System.exit(0);
        }
    }
}



