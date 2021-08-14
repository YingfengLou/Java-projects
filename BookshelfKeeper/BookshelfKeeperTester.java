import java.util.ArrayList;

public class BookshelfKeeperTester {
    public static void main(String[] arg){
        BookshelfKeeper myBookshelfKeeper = new BookshelfKeeper();
        System.out.print("Books in empty bookshelf [exp: 0]: " );
        System.out.println(myBookshelfKeeper.getTotalOperations());

        ArrayList<Integer> sortedBookshelf = new ArrayList<>();
        sortedBookshelf.add(1);
        sortedBookshelf.add(5);
        sortedBookshelf.add(8);


        Bookshelf pileofBooks = new Bookshelf(sortedBookshelf);
        BookshelfKeeper mybookshelfKeeper = new BookshelfKeeper(pileofBooks);
        mybookshelfKeeper.putHeight(10);
        System.out.println(mybookshelfKeeper.toString());
        mybookshelfKeeper.putHeight(6);
        System.out.println(mybookshelfKeeper.toString());
        mybookshelfKeeper.putHeight(4);
        System.out.println(mybookshelfKeeper.toString());
        mybookshelfKeeper.pickPos(3);
        System.out.println(mybookshelfKeeper.toString());






    }

}

