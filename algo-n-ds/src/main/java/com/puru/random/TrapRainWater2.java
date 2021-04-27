package com.puru.random;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapRainWater2 {
    class Cell{
        Integer x;Integer y; Integer h;

        public Cell(int x, int y, int h) {
            this.x=x;this.y=y;this.h=h;
        }
    }
    public static int[] pointX = {0,0,-1,1};
    public static int[] pointY = {-1,1,0,0};

    public int trapRainWater(int[][] h) {
        int r = h.length;
        int c= h[0].length;
        Comparator<Cell> com = (c1, c2)->{return c1.h.compareTo(c2.h);};
        PriorityQueue<Cell> q = new PriorityQueue<>(com);
        boolean[][] v = new boolean[r][c];
        for(int i=0;i<r;i++){
            q.offer(new Cell(i, 0, h[i][0]));
            v[i][0]=true;
        }
        for(int i=0;i<r;i++){
            q.offer(new Cell(i, c-1, h[i][c-1]));
            v[i][c-1]=true;
        }
        for(int i=1;i<c-1;i++){
            q.offer(new Cell(0, i, h[0][i]));
            v[0][i]=true;
        }
        for(int i=1;i<c-1;i++){
            q.offer(new Cell(r-1, i, h[r-1][i]));
            v[r-1][i]=true;
        }
        int res=0;
        while(!q.isEmpty()){
            Cell p = q.poll();
            for(int i=0;i<pointX.length;i++){
                int nX = p.x+pointX[i];
                int nY = p.y+pointY[i];
                if(nX>=0 && nX<r && nY>=0 && nY<c && !v[nX][nY]){
                    v[nX][nY]=true;
                    res+=Math.max(0, p.h-h[nX][nY]);
                    q.offer(new Cell(nX,nY,h[nX][nY]));
                }
            }
        }
        return res;
    }
}
