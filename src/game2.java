import java.util.*;

//put it all in continuous loop
//workout computer move
//determine winner/loser/draw

public class game2 {
    private static final char EMPTY = '\u0000'; //check for null char cell

    public static void main(String[] args) {
        char[][] matrix = new char[3][3];
        printBoard(matrix);

        char userSymbol = getUserSymbol();
        char compSymbol = getComputerSymbol(userSymbol);

        //!!!loop the entire game as well (game ends if checkWin is true or draw is true(all slots are filled))
        while (!isBoardFull(matrix)) {
            // user goes first and check move validity
            int userMove = getUserInput();
            while (!isValidMove(matrix, userMove)) {
                System.out.println("Invalid move. Try again.");
                userMove = getUserInput(); // Prompt user again
            }
            placeMove(matrix, userMove, userSymbol);
            printBoard(matrix);

            if (isBoardFull(matrix)) {
                break;
            }
            if (checkWin(matrix, userSymbol) || checkWin(matrix, compSymbol)) {
                break;
            }

            // computer goes next
            int compMove = getCompMove();
            while (!isValidMove(matrix, compMove)) {
                compMove = getCompMove();
            }
            placeMove(matrix, compMove, compSymbol);
            System.out.println("computer picked: " + compMove);
            printBoard(matrix);
        }

        // check for win/draw
        System.out.println("Result:");
        if (checkWin(matrix, userSymbol)) {
           System.out.println("User wins!");
        } else if (!checkWin(matrix, userSymbol) && !checkWin(matrix, compSymbol) && isBoardFull(matrix)) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Computer Wins!");
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]); // print row and col
                if (j < 2) { //first 2 cols get a divider
                    System.out.print(" | ");
                }
                if (j == 2) { //go to next line
                    System.out.println();
                }
            }
            if (i < 2) { // for the first 2 rows, print the line
                System.out.println("---+---+---");
            }
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int getUserInput() {
        Scanner keyboard = new Scanner(System.in);
        int userInput;
        while (true) {
            System.out.println("Enter a number b/w 0-8, where you'd like to place your symbol: ");
            try {
                userInput = keyboard.nextInt();
                if (userInput >= 0 && userInput <= 8) {
                    return userInput;
                } else {
                    System.out.println("Enter a number b/w 1-9 only");
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                keyboard.nextInt();
            }
        }
    }

    public static char getUserSymbol() {
        Scanner keyboard = new Scanner(System.in);
        char userInput;
        while (true) {
            System.out.println("Pick either X or O: ");
            try {
                userInput = keyboard.next().charAt(0);
                userInput = Character.toUpperCase(userInput);
                if (userInput == 'X' || userInput == 'O') {
                    return userInput;
                } else {
                    System.out.println("Enter X or O only");
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                keyboard.nextLine();
            }
        }
    }

    public static char getComputerSymbol(char userSymbol) {
        char compSymbol;
        if (userSymbol == 'X') {
            compSymbol = 'O';
        } else {
            compSymbol = 'X';
        }
        return compSymbol;
    }

    public static boolean isValidMove(char[][] board, int move) {
        return switch (move) {
            case 0 -> board[0][0] == EMPTY;
            case 1 -> board[0][1] == EMPTY;
            case 2 -> board[0][2] == EMPTY;
            case 3 -> board[1][0] == EMPTY;
            case 4 -> board[1][1] == EMPTY;
            case 5 -> board[1][2] == EMPTY;
            case 6 -> board[2][0] == EMPTY;
            case 7 -> board[2][1] == EMPTY;
            case 8 -> board[2][2] == EMPTY;
            default -> false;
        };
    }

    public static int getCompMove() {
        Random rand  = new Random();
        return rand.nextInt(9) + 1; //to get 0-8 range
    }

    public static void placeMove(char[][] board, int move, char symbol) {
        int row = move / 3;
        int col = move % 3;
        board[row][col] = symbol;
    }

    public static boolean checkWin(char[][] board, char symbol) {
        //iterate after each symbol placement to check row, col or diagonal for the same symbol

        //check row
        for (int i = 0; i < 3; i++) {
           if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) { //[row = i][col]
               return true;
           }
        }
        //check column
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) { //[row][col = j]
                return true;
            }
        }
        //check diagonal
        for (int i = 0; i < 3; i++) {
            if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
                return true;
            } else if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
                return true;
            }
        }
        return false;
    }

    // if user && comp checkWin is false, then it is a draw


}

