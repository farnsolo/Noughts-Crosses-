import java.util.Dictionary;
import java.util.Hashtable;
public class Grid {
    int[][] grid;
    static Dictionary<Integer, Character> dict = new Hashtable<>();
    public Grid(){
        grid = new int[3][3];
        dict.put(1,'X');
        dict.put(4,'O');
    }
    public void showGrid(){
        int index = 0;
        System.out.println(" | " + 0 + " | " + 1 + " | " + 2 + " | ");
        for(int[] colum : grid){
            for(int i = 0; i<colum.length;i++){
                if (i == 0){
                    System.out.print(index+ "| "+ dict.get(colum[i]) +" | ");
                }
                else{
                    System.out.print(dict.get(colum[i]) + " | ");
                }
            }
            index++;
            System.out.print("\n");
        }
    }

    public void addElement(int y, int x, int payload){
        grid[y][x] = payload;
    }
    public int getElement(int y, int x){return grid[y][x];}

    public boolean hasWon(){
        double verticalA=0, verticalB = 0;
        int indexDiagonalA=0, diagonalA=0, diagonalB =0;
        int indexDiagonalB = 2;
        for (int[] colum : grid){
            if ((colum[0] == 1 || colum[0] == 4) && colum[0] == colum[1] && colum[1] == colum[2]){
                return true;
            }
            verticalA += colum[0];
            verticalB += colum[2];
            diagonalA += colum[indexDiagonalA];
            indexDiagonalA++;
            diagonalB += colum[indexDiagonalB];
            indexDiagonalB--;
        }
        return ((verticalA == 3 || verticalA == 16) || (verticalB == 3 || verticalB == 16)) ||
                ((diagonalA == 3 || diagonalA == 16) || (diagonalB == 3 || diagonalB == 16));
    }

    public boolean draw(){
        int allElementsFull = 0;
        for (int[] column : grid){
            if (column[0] != 0 && column[1] != 0 && column[2] != 0){
                allElementsFull++;
            }
        }
        return allElementsFull == 3;
    }
}