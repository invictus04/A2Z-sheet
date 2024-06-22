class Solution {
    boolean search(char[][] board, String word, int i, int j, int n, int m,int k){
        if(k>= word.length()) return true;
        if(i<0 || i>=n || j<0 || j>=m || board[i][j] == '.' || word.charAt(k) != board[i][j]) return false;
        if(word.length() == 1 && word.charAt(k) == board[i][j]) return true;
        board[i][j] = '.';
        boolean temp = false;
        int x[] = {0,0,-1,1};
        int y[] = {-1,1,0,0};
        for(int l=0; l<4; l++) {
            temp = temp || search(board,word,i+x[l],j+y[l],n,m,k+1);
        }
        board[i][j] = word.charAt(k);
        return temp;
    }
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        if(board[0].length == 0) return false;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(word.charAt(0) == board[i][j]){
                    if(search(board, word,i,j,board.length,board[0].length,0)) return true;
                }
            }
        }
        return false;
    }
}