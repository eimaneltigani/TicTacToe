public class TicTacToeClass {
    
    private char[][] board;
    public int turns;
    
    public TicTacToeClass() {
        turns = 0;
        board = new char[3][3];

        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    // accessor methodss
    public boolean isWinner(char p) {
        int i;
        // check horizontal 
        for (i = 0; i <= 2; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
                return true;
            } 
        }
        
        int j;
        //check veticals
        for (j = 0; j <= 2; j++) {
            if (board[0][j] == p && board[1][j] == p && board[2][j] == p){
                return true;
            }   
        }
        
        // check diagonals
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
            return true; 
            }
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
            return true;
        }
        
        return false;
    }

    public boolean isFull() {
        if (turns == 9) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCat() {
        if (turns == 9 && (!isWinner('X')) && (!isWinner('O'))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0<= c && c <=2) {
            return true;
        } else {
            return false;
        }
    }

    public int numTurns() {
        return turns;
    }

    public char PlayerAt(int r, int c) {
        if (isValid(r,c)) {
            return board[r][c];
        } else {
            return '@';
        }
    }

    public void displayBoard() {
        System.out.println(" 0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println(" 1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println(" 2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("   0 1 2");
    }

    // modifiers
    public void playMove(char p, int r, int c) {
        board[r][c] = p;
        turns++;
    }
}
