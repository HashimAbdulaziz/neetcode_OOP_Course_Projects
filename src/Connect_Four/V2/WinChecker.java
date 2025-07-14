package Connect_Four.V2;

import static java.lang.Math.min;

public class WinChecker {

    private final int[][] grid;
    private final int rows;
    private final int columns;

    public WinChecker(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
    }


    public boolean checkWin(int connectN, int row, int col, GridPosition piece){
        // check Horizontal
        int count  = 0;
        for (int j = 0; j < this.columns; j++) {
            if (this.grid[row][j] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
        }

        // check Vertical
        count = 0;
        for (int i = 0; i < this.rows; i++){
            if (this.grid[i][col] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
        }

        // check diagonal to left
        count = 0;
        int dig_startRight_point = min(this.columns-col-1, row);
        int j = col + dig_startRight_point;
        int i = row - dig_startRight_point;
        while(i < this.rows && j >= 0){
            if(this.grid[i][j] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
            i++;
            j--;
        }

        // check diagonal to Right
        count = 0;
        int dig_startLeft_point = min(col, row);
        j = col - dig_startLeft_point;
        i = row - dig_startLeft_point;
        while(i < this.rows && j < this.columns){
            if(grid[i][j] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
            i++;
            j++;
        }

        /*
        There is another solution by noticing that in check diagonal to left:  col+row = r+c
        and in check diagonal to Right: row-col = r-c
         */

        return false;
    }
}
