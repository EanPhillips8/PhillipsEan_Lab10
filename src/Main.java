import java.util.Scanner;


public class Main {


    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean finised = false;
        Boolean playing = true;
        String player = "X";
        int moveCount = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;

        do {
            player = "X";
            playing = true;
            moveCount = 0;
            clearBoard();
            do {
                do {


                    display();
                    System.out.println("Enter move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter row ", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter column ", 1, 3);
                    row--;
                    col--;
                } while (!isValidMove(row, col));
                board[row][col] = player;
                moveCount++;

                if (moveCount >= MOVES_FOR_WIN)
                {
                    if (isWin(player)) {
                        display();
                        System.out.println("Player" + player + " wins!");
                        playing = false;
                    }
                }
                if (moveCount >= MOVES_FOR_TIE) {
                    if (isTie()) {
                        display();
                        System.out.println("It a Tie!");
                        playing = false;
                    }
                }
                    if (player.equals("X")) {
                        player = "O";
                    } else {
                        player = "X";
                    }
                }while (playing);


            finised = SafeInput.getYN(in, "Done Playing? ");
        } while (!finised);
    }


        private static void clearBoard () {

            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    board[row][col] = " "; // make this cell a space
                }
            }
        }

        private static void display () {
            for (int row = 0; row < ROW; row++) {
                System.out.print("| ");
                for (int col = 0; col < COL; col++) {
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println();
            }


        }

        private static boolean isValidMove ( int row, int col){
            {
                boolean retVal = false;
                if (board[row][col].equals(" "))  // is it a space?
                    retVal = true;
                return retVal;
            }
        }

        private static boolean isWin (String player){
            if (isColWin(player) || isRowWin(player) || isDiagnalWin(player)) {
                return true;
            }
            return false;
        }

        private static boolean isColWin (String player){
            for (int col = 0; col < COL; col++) {
                if (board[col][0].equals(player) && board[col][1].equals(player) && board[col]
                        [2].equals(player)) {
                    return true;
                }
            }
            return false; // no row win
        }

        private static boolean isRowWin (String player){
            for (int row = 0; row < ROW; row++) {
                if (board[row][0].equals(player) && board[row][1].equals(player) && board[row]
                        [2].equals(player)) {
                    return true;
                }
            }
            return false; // no row win
        }

        private static boolean isDiagnalWin (String player){
            if (board[0][0].equals(player) &&
                    board[1][1].equals(player) &&
                    board[2][2].equals(player)) {
                return true;
            }
            if (board[0][2].equals(player) &&
                    board[1][1].equals(player) &&
                    board[2][0].equals(player)) {
                return true;
            }
            return false;
        }


        private static boolean isTie ()
        {
            boolean Oflag = false;
            boolean Xflag = false;

            for (int row = 0; row < ROW; row++)
            {
                if (board[row][0].equals("X") || board[row][1].equals("X") || board[row]
                        [2].equals("X")) {
                    Xflag = true;
                }
                if (board[row][0].equals("O") || board[row][1].equals("O") || board[row]
                        [2].equals("O")) {
                    Oflag = true;

                }
                if (!(Xflag && Oflag)) {
                    return false;
                }
                Xflag = Oflag = false;

            }
            for (int col = 0; col < COL; col++) {
                if (board[col][0].equals("X") || board[col][1].equals("X") || board[col]
                        [2].equals("X")) {
                    Xflag = true;
                }
                if (board[col][0].equals("O") || board[col][1].equals("O") || board[col]
                        [2].equals("O")) {
                    Oflag = true;

                }
                if (!(Xflag && Oflag)) {
                    return false;
                }
            }
            Xflag = Oflag = false;

            if (board[0][0].equals("X") ||
                    board[1][1].equals("X") ||
                    board[2][2].equals("X")) {
                Xflag = true;
            }
            if (board[0][0].equals("O") ||
                    board[1][1].equals("O") ||
                    board[2][2].equals("O")) {
                Oflag = true;
            }
            if (!(Xflag && Oflag)) {
                return false;
            }
            Xflag = Oflag = false;


            if (board[0][2].equals("X") ||
                    board[1][1].equals("X") ||
                    board[2][0].equals("X")) {
                Xflag = true;
            }
            if (board[0][2].equals("O") ||
                    board[1][1].equals("O") ||
                    board[2][0].equals("O")) {
                Oflag = true;
            }
            if (!(Xflag && Oflag)) {
                return false;
            }
            return true;

        }
    }


