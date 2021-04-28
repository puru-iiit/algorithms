package com.puru.random;

/**
 * 289. Game of Life
 *
 * According to Wikipedia's article: "The Game of Life, a
 * lso known simply as Life, is a cellular automaton devised by the British
 * mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has
 * an initial state: live (represented by a 1) or dead (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {
    private int[][] dirs = {{-1,-1},{1,1},{-1,1},{1,-1},{-1,0},{1,0},{0,-1},{0,1}};
    public void gameOfLife1(int[][] board) {
        if(board==null || board.length==0){
            return;
        }
        int r = board.length, c= board[0].length;
        int[][] newBoard = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int count=0;
                for(int[] dir : dirs){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x>=0 && x<r && y>=0 && y<c && board[x][y]==1){
                        count++;
                    }
                }
               if(board[i][j]==1){
                   if(count==2 || count==3){
                       newBoard[i][j]=1;
                   }
               }else if(count==3){
                   newBoard[i][j]=1;
                }
            }

        }
        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0){
            return;
        }
        int r = board.length, c= board[0].length;
        //int[][] newBoard = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int count=0;
                for(int[] dir : dirs){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x>=0 && x<r && y>=0 && y<c && (board[x][y]==1 || board[x][y]==2)){
                        count++;
                    }
                }
                //alive-->dead : 2
                if(board[i][j]==1){
                    if(count<2 || count>3){
                        board[i][j]=2;
                    }
                }else if(count==3){ //dead-->alive : 2
                    board[i][j]=3;
                }
            }

        }
        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = board[i][j]%2;
            }
        }
    }
}
