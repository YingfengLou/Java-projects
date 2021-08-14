public class VisibleFieldTester {
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
        System.out.println();
        System.out.println(v.getStatus(0,2));
        System.out.println(v.isGameOver());

        v.uncover(0, 0);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(v.getStatus(0,0));
        System.out.println(v.isGameOver());

        v.uncover(2, 0);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(v.getStatus(2,0));
        System.out.println(v.isGameOver());

        v.uncover(2, 3);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(v.getStatus(2,3));
        System.out.println(v.isGameOver());

        v.uncover(3, 0);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(v.getStatus(3,0));
        System.out.println(v.isGameOver());

        v.uncover(3, 2);
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(v.getStatus(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(v.getStatus(3,2));
        System.out.println(v.isGameOver());
    }
}
