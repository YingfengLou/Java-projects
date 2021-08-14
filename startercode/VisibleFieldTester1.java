//public class VisibleFieldTester {
//    public static void main(String[] args){
//        boolean[][] mineData =
//                        {{false, false, false, false},
//                        {true, false, false, false},
//                        {false, true, true, false},
//                        {false, true, false, true}};
//        MineField mineField = new MineField(mineData);
//        VisibleField visibleField = new VisibleField(mineField);
//
//        testMove(visibleField, 0,0);
//        testMove(visibleField, 1,0);
//    }
//
//    /***
//     * test every method on VisibleField.java
//     * @param visibleField
//     * @param row
//     * @param col
//     */
//    public static void testMove(VisibleField visibleField, int row, int col){
//        System.out.println("visibleField: " + visibleField.toString());
//        visibleField.uncover(row,col);
//        System.out.println("status: " + visibleField.getStatus(row,col));
//        System.out.println("left: " + visibleField.numMinesLeft());
//        System.out.println("GameOver: " + visibleField.isGameOver());
//        visibleField.resetGameDisplay();
//        System.out.println("reset visibleField: " + visibleField.toString());
//    }
//}
public class VisibleFieldTester1 {
    private static boolean[][] smallMineField =
            {{false, false, false, false},
                    {true, false, false, false},
                    {false, true, true, false},
                    {false, true, false, true}};

    public static void main(String[] args) {
        // create mine field and visible field
        MineField m = new MineField(smallMineField);
        VisibleField v = new VisibleField(m);

        // print out mine field
        for (int i = 0; i < m.numRows(); i++) {
            for (int j = 0; j < m.numCols(); j++) {
                System.out.print(m.hasMine(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        // print out visible field
        for (int i = 0; i < m.numRows(); i++) {
            for (int j = 0; j < m.numCols(); j++) {
                System.out.print(v.getStatus(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(v.numMinesLeft());

        v.uncover(0, 2);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        v.cycleGuess(0,0);
        System.out.println(v.getStatus(0,0));

        v.uncover(1, 0);
        System.out.println("lost test");
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println("Game over?"+v.isGameOver());
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println(v.getStatus(0,0));
        System.out.println("mines left:" + v.numMinesLeft());

        v.resetGameDisplay();
        System.out.println("win test");
        System.out.println("reset visibleField: " );
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        v.uncover(0, 0);
        v.uncover(0, 1);
        v.uncover(0, 2);
        v.uncover(0, 3);
        v.uncover(1, 1);
        v.uncover(1, 2);
        v.uncover(1, 3);
        v.uncover(2, 0);
        v.uncover(2, 3);
        v.uncover(3, 0);
        v.uncover(3, 2);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println("Game over?"+v.isGameOver());
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println("mines left:" + v.numMinesLeft());
    }
}
