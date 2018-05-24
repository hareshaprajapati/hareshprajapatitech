package The8puzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Board {
    //public Board(int[][] blocks)            construct a board from an N-by-N array of blocks
    //                                        (where blocks[i][j] = block in row i, column j)
    //public int dimension()                  board dimension N
    //public int hamming()                    number of blocks out of place
    //public int manhattan()                  sum of Manhattan distances between blocks and goal
    //public boolean isGoal()                 is this board the goal board?
    //public Board twin()                     a board obtained by exchanging two adjacent blocks in the same row
    //public boolean equals(Object y)         does this board equal y?
    //public Iterable<Board> neighbors()      all neighboring boards
    //public String toString()                string representation of the board (in the output format specified below)

    private final int[][] tiles;
    private int size;
    private int zeroCol;
    private int zeroRow;
    private int hamming;
    private int manhattan;

    public Board(int[][] blocks) throws Exception {
        size = blocks.length;
        tiles =new int[size][size];
        int noOfZeros = 0;
        for(int i = 0; i <size; i++){
            for(int j = 0; j<size; j++){
                this.tiles[i][j] = blocks[i][j];
                if(tiles[i][j] == 0) {
                    setZero(i, j);
                    noOfZeros++;
                }
            }
        }
        if(noOfZeros>1){
            throw new Exception("No of Zeros is more than 1 , invalid board");
        }
    }

    private void setZero(int i, int j){
        this.zeroRow = i;
        this.zeroCol = j;
    }

    public int dimension(){
        return size;
    }

    public String toString() {
        int N = size;
        StringBuilder s = new StringBuilder();
//        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public int manhattan(){
        int arrayPosition;
        int tile;
        manhattan = 0;
        for(int i = 0; i <size; i++){
            for(int j = 0; j<size; j++){
                tile = tiles[i][j];
                if(tile == 0)
                    continue;
                arrayPosition = 1+ j +(i*this.size);

                if(arrayPosition-tile == 0)
                    continue;
                double ii = Math.floor(((double)(tile-1))/this.size);
                double jj = (tile-1)%this.size;
                manhattan +=  (Math.abs(i-ii)+Math.abs(j-jj));
                //StdOut.println("Tile:" + tile + " [MOVES:"+ (Math.abs(i-ii)+Math.abs(j-jj))+"]       | Offsets: i "+  Math.abs(i-ii) + " j "+  Math.abs(j-jj));
            }
        }
        return manhattan;
    }

    public int hamming(){
        int arrayPosition;
        int tile;
        int displaced =0;
        for(int i = 0; i <size; i++){
            for(int j = 0; j<size; j++){
                tile = tiles[i][j];
                if(tile ==0)
                    continue;
                arrayPosition = 1+ j +(i*this.size);

                if(tile != arrayPosition)
                    displaced++;
                else
                    continue;
            }
        }
        return displaced;
    }

    public boolean isGoal(){
        int arrayPosition;
        int tile;

        for(int i = 0; i <size; i++){
            for(int j = 0; j<size; j++){
                if(i==size-1 && j == size -1)
                    continue;
                tile = tiles[i][j];
                arrayPosition = 1+ j +(i*this.size);
                if(tile != arrayPosition)
                    return false;
            }
        }
        return true;
    }

    private int[][]deepCopy(int[][] array){
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] =array[i][j];
            }
        }
        return copy;
    }

    public Board twin() throws Exception {
        int[][] twin = deepCopy(tiles);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j] != 0 && tiles[i][j + 1] != 0 && j < (size - 1)) {
                    int swap = twin[i][j];
                    twin[i][j] = twin[i][j + 1];
                    twin[i][j + 1] = swap;
                    return new Board(twin);
                }
            }
        }
        return new Board(twin);
    }

    public boolean equals(Object y){
        Board that = (Board) y;
        if (y == null) return false;
        if (this == y) return true;
        if (this.getClass() != y.getClass()) return false;
        if (that.size != this.size) return false;

        return Arrays.deepEquals(this.tiles, that.tiles );
    }

    public Iterable<Board> neighbors() throws Exception {
        Stack<Board> boards = new Stack<Board>();
//        Queue<Board> boards = new LinkedList<>();

        if(zeroRow > 0){
            Board boardUP = new Board(swap(tiles,-1,0));
            boards.push(boardUP);
//            boards.add(boardUP);
        }

        if(zeroRow < size-1){
            Board boardDown = new Board(swap(tiles,1,0));
            boards.push(boardDown);
//            boards.add(boardDown);
        }

        if(zeroCol > 0){
            Board boardLeft = new Board(swap(tiles,0,-1));
            boards.push(boardLeft);
//            boards.add(boardLeft);
        }

        if(zeroCol <size-1){
            Board boardRight = new Board(swap(tiles,0,1));
            boards.push(boardRight);
//            boards.add(boardRight);
        }

        return boards;

    }
    public int[][] swap(int[][] board, int rowOffset, int colOffset){
        int[][] tempBoard =  deepCopy(board);
        tempBoard[zeroRow][zeroCol]= tiles[zeroRow+rowOffset][zeroCol+colOffset];
        tempBoard[zeroRow+rowOffset][zeroCol+colOffset]=0;

        return tempBoard;
    }
}
