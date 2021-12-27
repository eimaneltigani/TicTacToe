import java.util.Scanner;

public class TicTacToeRunner {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToeClass ttt = new TicTacToeClass();
        int r, c;

        while (!(ttt.isFull() || ttt.isWinner('X') || ttt.isWinner('O'))) {
            ttt.displayBoard();
            if (ttt.turns % 2 == 0 || ttt.turns == 0) {
                System.out.println("Please enter the row and column you'd like to place X (e.g.,0 0)");
                String input = scan.nextLine();
                String[] rowcol = input.split(" ");
                r = Integer.parseInt(rowcol[0]);
                c = Integer.parseInt(rowcol[1]);
                if (ttt.PlayerAt(r, c) == ' ' && ttt.isValid(r, c)) {
                    ttt.playMove('X', r, c);
                    ttt.displayBoard();
                } else {
                    System.out.println("That location is not available. Please try again.");
                }
            }
            if (ttt.turns % 2 != 0) {
                System.out.println("Please enter the row and column you'd like to place O (e.g.,0 0)");
                String input = scan.nextLine();
                String[] rowcol = input.split(" ");
                r = Integer.parseInt(rowcol[0]);
                c = Integer.parseInt(rowcol[1]);
                if (ttt.PlayerAt(r, c) == ' ' && ttt.isValid(r, c)) {
                    ttt.playMove('O', r, c);
                } else {
                    System.out.println("That location is not available. Please try again.");
                }
            }
        }

        ttt.displayBoard();

        if (ttt.isCat()) {
            System.out.println("It's a tie!");
            scan.close();
        }
        if (ttt.isWinner('X')) {
            System.out.println("X is the winner, congrats!");
            scan.close();
        } 
        if (ttt.isWinner('O')) {
            System.out.println("O is the winner, congrats!");
            scan.close();
        }
    
        
    }
}
