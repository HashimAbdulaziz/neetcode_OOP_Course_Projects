package Connect_Four.V2;

import static java.lang.Math.min;

public class Grid {
    private int rows;
    private int columns;
    private int[][] grid;

    public Grid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        initGrid();
    }


    public void initGrid(){
        this.grid = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                grid[i][j] = GridPosition.EMPTY.ordinal();
            }
        }


    }

    public int[][] getGrid(){
        return this.grid;
    }

    public int getColumnCount() {
        return columns;
    }

    public int placePiece(int column, GridPosition piece){
        // Checking if user put valid column
        if (column < 0 || column >= this.columns) {
            throw new Error("Invalid column");
        }
        // Checking if user put valid piece
        if (piece == GridPosition.EMPTY) {
            throw new Error("Invalid piece");
        }
        // Place piece in an EMPTY position
        for(int row = this.rows-1; row >= 0; row--){
            if(grid[row][column] == GridPosition.EMPTY.ordinal()){
                grid[row][column] = piece.ordinal();
                return row;
            }
        }
        return -1;
    }


}
