package com.shivakumar.algorithms.prep.g1;


public class GraphCycle {
   static int[][] directions = new int[][]{ {1,0}, {0,1},{-1,0},{0,-1}};
    public static boolean isCycle(int[][] graph, int i, int j, int pi, int pj, int color, boolean[][] visited){
        if(i<0 || i>=graph.length || j<0 || j>=graph[0].length || Math.abs(graph[i][j]) != color )
            return false;
        if(color == -graph[i][j])
            return true;

        else if(graph[i][j] <0)
            return false;

        //visited[i][j] = true;
        graph[i][j] *= -1;

        for(int k=0;k< directions.length;k++){
            int nextI = i + directions[k][0];
            int nextJ = j + directions[k][1];
            if( nextI == pi && nextJ == pj)
                continue;
            if(isCycle(graph,nextI,nextJ,i,j,color,visited)){
                return  true;
            }
        }
        //graph[i][j] *= -1;

        return  false;
    }

    public static void main(String[] args) {

        /*
        *   [ A, A, A, B
        *     A, C, A, B
        *     A ,A, A, C ]
        * */

        //char[][] graph = new char[][]  { {'A', 'A', 'A', 'B' },{'A', 'C', 'A', 'B'}, {'A' ,'A', 'A', 'C'}};
        int[][] graph = new int[][]  { {1, 1, 3, 2 },{1, 1, 1,2}, {1 ,2, 1, 3}};
        boolean[][] visited = new boolean[graph.length][graph[0].length];

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length;j++){
                if(isCycle(graph,i,j,-1,-1,graph[i][j],visited))
                {
                    System.out.println("True"+ i +" "+j);
                    break;
                }
            }
        }


    }
}
