import java.util.*;

//put it all in continuous loop
//workout computer move
//determine winner/loser/draw

public class game2 {
    public static void main(String[] args) {
        char[][] matrix = new char[3][3];
        printBoard(matrix);
        //placeMove(matrix, getUserInput(), getUserSymbol());
        //printBoard(matrix);
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

    public static int getUserInput() {
        Scanner keyboard = new Scanner(System.in);
        int userInput;
        while (true) {
            System.out.println("Enter a number b/w 1-9, where you'd like to place your symbol: \n");
            try {
                userInput = keyboard.nextInt();
                if (userInput >= 1 && userInput <= 9) {
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

    public static boolean isValidMove(char[][] board, int input) {
        switch (input) {
            case 1:
                return board[0][0] == ' ';
            case 2:
                return board[0][1] == ' ';
            case 3:
                return board[0][2] == ' ';
            case 4:
                return board[1][0] == ' ';
            case 5:
                return board[1][1] == ' ';
            case 6:
                return board[1][2] == ' ';
            case 7:
                return board[2][0] == ' ';
            case 8:
                return board[2][1] == ' ';
            case 9:
                return board[2][2] == ' ';
            default:
                return false;
        }
    }

    public static int computerMove(){
        Random rand  = new Random();
        return rand.nextInt(9) + 1; //to get 0 - 9 range
    }

    public static void placeMove(char[][] board, int input, char symbol) {
        switch (input) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("N/A");
        }
    }
}

