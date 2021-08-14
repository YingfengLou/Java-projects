import java.util.ArrayList;

public class BookshelfTester {
    public static void main(String args[]) {

        //test for creating an empty bookshelf
        Bookshelf empty = new Bookshelf();
        System.out.print("Books in empty bookshelf [exp: []]: " );
        System.out.println(empty.toString());


        ArrayList<Integer> pileOfBooks = new ArrayList<>();
        pileOfBooks.add(7);
        pileOfBooks.add(33);
        pileOfBooks.add(5);
        pileOfBooks.add(4);
        pileOfBooks.add(3);

        ArrayList<Integer> pileOfBooks1 = new ArrayList<>();
        pileOfBooks1.add(5);
        pileOfBooks1.add(9);
        pileOfBooks1.add(20);


        Bookshelf firstShelf = new Bookshelf(pileOfBooks);
        System.out.print("Bookshelf with arrangement[exp:[7,33,5,4,3]]: " );
        System.out.println(firstShelf.toString());
        Bookshelf secondShelf = new Bookshelf(pileOfBooks1);
        System.out.print("Bookshelf with arrangement[exp:[5, 9, 20]]: " );
        System.out.println(secondShelf.toString());

        System.out.print("getHeight[exp: 33]: ");
        System.out.println(firstShelf.getHeight(Integer.parseInt("1")));
        System.out.print("getHeight[exp: 20]: ");
        System.out.println(secondShelf.getHeight(Integer.parseInt("2")));

        System.out.print("get size[exp: 5]: ");
        System.out.println(firstShelf.size());
        System.out.print("get size[exp: 3]");
        System.out.println(secondShelf.size());


        System.out.print("isSorted[exp: false]: ");
        System.out.println(firstShelf.isSorted());
        System.out.print("isSorted[exp: true]: ");
        System.out.println(secondShelf.isSorted());

        System.out.print("addFront[exp: [1, 7, 33, 5, 4, 3]]: ");
        firstShelf.addFront(1);
        System.out.println(firstShelf.toString());
        System.out.print("addFront[exp: [4, 5, 9, 20]]: ");
        secondShelf.addFront(4);
        System.out.println(secondShelf.toString());

        System.out.print("addLast[exp: [1, 7, 33, 5, 4, 3, 10]]: ");
        firstShelf.addLast(10);
        System.out.println(firstShelf.toString());
        System.out.print("addLast[exp: [4, 5, 9, 20, 25]]: ");
        secondShelf.addLast(25);
        System.out.println(secondShelf.toString());

        System.out.print("removeFront[exp: [7, 33, 5, 4, 3, 10]]: ");
        firstShelf.removeFront();
        System.out.println(firstShelf.toString());
        System.out.print("removeFront[exp: [5, 9, 20, 25]]: ");
        secondShelf.removeFront();
        System.out.println(secondShelf.toString());

        System.out.print("removeLast[exp: [7, 33, 5, 4, 3]]: ");
        firstShelf.removeLast();
        System.out.println(firstShelf.toString());
        System.out.print("removeLast[exp: [5, 9, 20]]: ");
        secondShelf.removeLast();
        System.out.println(secondShelf.toString());


    }
}