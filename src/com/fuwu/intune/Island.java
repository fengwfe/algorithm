package com.fuwu.intune;

//https://zhuanlan.zhihu.com/p/107076736
//https://www.1point3acres.com/bbs/thread-543569-1-1.html
//https://zhuanlan.zhihu.com/p/107653837
//https://zhuanlan.zhihu.com/p/72948264
public class Island {

    static  int length = 0;

    public static void main(String[] args) {
//        int[][]board = new int[][]{{1,0,0},{1,0,0},{0,1,1}};
//        System.out.println(numOfIsland(board));

//        System.out.println(maxArea(board));


        int[][] board2 = new int[][]{{1,0,0},{1,0,0},{1,0,0}};
        length(board2);
        System.out.println(length);

    }

    /**
     * //岛屿数量
     * @param board
     * @return
     */
    public static int numOfIsland(int[][] board){
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == 1){
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 岛屿最大面积
     * @param board
     * @return
     */
    public static int maxArea(int[][] board){
        int max = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == 1){
                    max = Math.max(max,   dfs_2(board, i, j) );

                }
            }
        }
        return max;
    }

    /**
     * 只有一个岛屿，求周长
     * @param board
     * @return
     */
    public static void length(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == 1){
                   dfs_3(board, i, j);
                    break;//只有一个岛
                }
            }
        }
    }


    public static void dfs(int[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 1){
            return;
        }
        board[row][col] = -1;
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col +  1);
        dfs(board, row, col - 1);
    }

    public static int dfs_2(int[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 1){
            return 0;
        }
        board[row][col] = -1;
        int result  = 1;
        result += dfs_2(board, row + 1, col);
        result += dfs_2(board, row - 1, col);
        result += dfs_2(board, row, col +  1);
        result += dfs_2(board, row, col - 1);
        return result;
    }
    public static void dfs_3(int[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            length++;
            return;
        }
        if(board[row][col] == 0){
            length++;
            return;
        }
        if(board[row][col] == -1){
            return;
        }
        board[row][col] = -1;
         dfs_3(board, row + 1, col);
         dfs_3(board, row - 1, col);
        dfs_3(board, row, col +  1);
        dfs_3(board, row, col - 1);
    }


}
