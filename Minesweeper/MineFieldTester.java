import java.util.Random;

public class MineFieldTester {
    public static void main(String[] args){
        // new MineField test for 1-par constructor
//        boolean[][] a = new boolean[3][3];
//
//        MineField m = new MineField(a);
//        // print out MineField
//        for(int i = 0; i < m.numRows(); i++){
//            for(int j = 0; j < m.numCols(); j++){
//                System.out.print(m.hasMine(i,j) + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        //test for create
        boolean[][] arr = new boolean[][]{{false, true, },
                                         {true, false,},
                                         {true, false}};
        //boolean[][] arr = new boolean[][]{{false}};

        MineField m = new MineField(arr);
        // print out MineField
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(m.hasMine(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(m.numRows());
        System.out.println(m.numCols());
        System.out.println(m.numMines());
        System.out.println(m.inRange(1,1));
        System.out.println(m.numAdjacentMines(0,0));
        m.resetEmpty();
        for(int i = 0; i < m.numRows(); i++){
            for(int j = 0; j < m.numCols(); j++){
                System.out.print(m.hasMine(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        boolean[][] input = new boolean[4][4];
        //boolean[][] arr = new boolean[][]{{false}};

        MineField m_mines = new MineField(input);
        m_mines.populateMineField(0, 0);
        // print out MineField
        for(int i = 0; i < m_mines.numRows(); i++){
            for(int j = 0; j < m_mines.numCols(); j++){
                System.out.print(m_mines.hasMine(i,j) + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(m_mines.numRows());
        System.out.println(m_mines.numCols());
        System.out.println(m_mines.numMines());
        System.out.println(m_mines.inRange(1,1));
        System.out.println(m_mines.numAdjacentMines(0,0));



        //test for 3-arg constructor
        MineField m_3 = new MineField(9,9,20);
        m_3.populateMineField(1, 1);
        // print out MineField
        int num = 0;
        for(int i = 0; i < m_3.numRows(); i++){
            for(int j = 0; j < m_3.numCols(); j++){
                System.out.print(m_3.hasMine(i,j) + " ");
                if (m_3.hasMine(i,j) == true){
                    num++;
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(num);
        System.out.println(m_3.numRows());
        System.out.println(m_3.numCols());
        System.out.println(m_3.numMines());
        System.out.println(m_3.inRange(1,1));
        System.out.println(m_3.numAdjacentMines(1,1));
        m_3.resetEmpty();
        for(int i = 0; i < m_mines.numRows(); i++){
            for(int j = 0; j < m_mines.numCols(); j++){
                System.out.print(m_mines.hasMine(i,j) + " ");
            }
            System.out.println();
        }

    }
}
