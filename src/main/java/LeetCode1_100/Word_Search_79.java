package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-11 11:40
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 **/
public class Word_Search_79 {

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || word == null){
            return false;
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(0)){
                    if (helper(i,j,0,word,board) == true) //不能直击return，如果是false，进入下一个循环中继续dfs
                        return true;
                }
            }
        }
        return false;
    }


    public boolean helper(int i, int j,int index,String word,char[][] board){
        if (index == word.length()){
            return true;
        }
        if (i >= board.length || j >= board[0].length || i< 0 || j<0 || board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#'; //避免重复使用
        boolean res = helper(i-1,j,index+1,word,board) ||helper(i+1,j,index+1,word,board) || helper(i,j-1,index+1,word,board)
                || helper(i,j+1,index+1,word,board);
        board[i][j] = temp;
        return res;
    }
}



