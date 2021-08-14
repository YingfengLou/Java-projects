// Name: Yingfeng Lou
// USC NetID: louy
// CSCI455 PA2
// Spring 2021


/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

    /**
      Representation invariant:

      The bookshelfKeeper should be in non-decreasing order.

   */
   // <add instance variables here>
   private Bookshelf bookshelfKeeper;
   private int totalOperations;
   private int operations;

   private static final int MID = 2;
   private static final int EMPTY_BOOKSHELF = 0;
   private static final int FIRST_OPERATION = 1;


   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      bookshelfKeeper = new Bookshelf();
      totalOperations = 0;
      assert isValidBookshelfKeeper();

   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      bookshelfKeeper = sortedBookshelf;
      assert isValidBookshelfKeeper();

   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    *
    * @param position the index that we want to pick.
    * PRE: position must be in the range [0, getNumBooks()).
    */
   public int pickPos(int position) {
      if (position < bookshelfKeeper.size() / MID){
         operations = removeLeft(position);
      }
      else{
         operations = removeRight(position);
      }
      totalOperations += operations;
      assert isValidBookshelfKeeper();
      return operations;
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    *
    * @param height  the height of the book we want to put in bookshelf.
    * PRE: height > 0
    */
   public int putHeight(int height) {
      if (getNumBooks() == EMPTY_BOOKSHELF){
         bookshelfKeeper.addFront(height);
         operations = FIRST_OPERATION;
         totalOperations += 1;
         return operations;
      }
      //Compare operations numbers removing from front or last, choose the smaller one.
      int startLeft = findLeft(height);
      int startRight = findRight(height);
      if (startLeft <= startRight){
         operations = putLeft(height);
      }
      else{
         operations = putRight(height);
      }
      totalOperations += operations;
      assert isValidBookshelfKeeper();
      return operations;
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return totalOperations;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return bookshelfKeeper.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      String ans = bookshelfKeeper.toString() + " " + operations + " " + totalOperations;
      assert isValidBookshelfKeeper();
      return ans;
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      if (bookshelfKeeper.size() == EMPTY_BOOKSHELF){
         return true;
      }
      else if(!bookshelfKeeper.isSorted()){
            return false;
      }
      else{
         return true;
      }
   }

   // add any other private methods here
   /**
    * start from the left(front), check how many books we need to remove.
    *
    * Returns the number of books we need to remove from front if we want to
    * put the book in bookshelf.
    *
    * @param height  the height of the book we want to put in bookshelf.
    * PRE: height > 0
    */
   private int findLeft(int height) {
      int left = 0;
      for (int i = 0; i < bookshelfKeeper.size(); i++) {
         if (bookshelfKeeper.getHeight(i) >= height) {
            break;
         } else {
            left++;
         }
      }
      return left;
   }

   /**
    * start from the right(last), check how many books we need to remove.
    *
    * Returns the number of books we need to remove from last if we want to
    * put the book in bookshelf.
    *
    * @param height  the height of the book we want to put in bookshelf.
    * PRE: height > 0
    */
   private int findRight(int height){
      int right = 0;
      for (int i = bookshelfKeeper.size(); i >= 0; i--) {
         if (bookshelfKeeper.getHeight(i) <= height) {
            break;
         } else {
            right++;
         }
      }
      return right;
   }

   /**
    * Calculate the number of calling Bookshelf method starting remove from front.
    *
    * Returns the number calling operations pick from front.
    *
    * @param position the index that we want to pick.
    *     * PRE: position must be in the range [0, getNumBooks()).
    */
   private int removeLeft(int position){
      int opNums = 0;
      Bookshelf temp = new Bookshelf();

      for (int i = 0; i < position; i++){
         int front = bookshelfKeeper.removeFront();
         temp.addLast(front);
         opNums++;
      }
      bookshelfKeeper.removeFront();
      opNums++;
      while (temp.size() != 0){
         bookshelfKeeper.addFront(temp.removeLast());
         opNums++;
      }
      return opNums;
   }

   /**
    * Calculate the number of calling Bookshelf method starting remove from last.
    *
    * Returns the number calling operations pick from last.
    *
    * @param position the index that we want to pick.
    *     * PRE: position must be in the range [0, getNumBooks()).
    */
   private int removeRight(int position){
      int opNums = 0;
      Bookshelf temp = new Bookshelf();

      for (int j = position; j < bookshelfKeeper.size(); j++){
         int last = bookshelfKeeper.removeLast();
         temp.addFront(last);
         opNums++;
      }
      bookshelfKeeper.removeLast();
      opNums++;
      while (temp.size() != 0){
         bookshelfKeeper.addLast(temp.removeFront());
         opNums++;
      }
      return opNums;
   }

   /**
    * Calculate the number of calling methods if we choose remove from front and add
    * to front, then put other books back.
    *
    * Returns the number calling operations put from front.
    *
    * @param height  the height of the book we want to put in bookshelf.
    * PRE: height > 0
    */
   private int putLeft(int height){
      int left = bookshelfKeeper.getHeight(0);
      int opNums = 0;

      //temporarily save the books we remove from origin bookshelf.
      Bookshelf temp = new Bookshelf();
      while(left < height){
         temp.addLast(bookshelfKeeper.removeFront());
         opNums++;
         left = bookshelfKeeper.getHeight(0);
      }
      bookshelfKeeper.addFront(height);
      opNums++;
      while(temp.size() != 0){
         bookshelfKeeper.addFront(temp.removeLast());
         opNums++;
      }
      return opNums;
   }

   /**
    * Calculate the number of calling methods if we choose remove from last and add
    * to last, then put other books back.
    *
    * Returns the number calling operations put from last.
    *
    * @param height  the height of the book we want to put in bookshelf.
    * PRE: height > 0
    */
   private int putRight(int height){
      int right = bookshelfKeeper.getHeight(bookshelfKeeper.size() - 1);
      int opNums = 0;
      Bookshelf temp = new Bookshelf();
      while(right > height){
         temp.addFront(bookshelfKeeper.removeLast());
         opNums++;
         right = bookshelfKeeper.getHeight(bookshelfKeeper.size() - 1);
      }
      bookshelfKeeper.addLast(height);
      opNums++;
      while(temp.size() != 0){
         bookshelfKeeper.addLast(temp.removeFront());
         opNums++;
      }
      return opNums;
   }

}
