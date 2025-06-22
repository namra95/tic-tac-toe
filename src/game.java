import java.util.Scanner;
import java.util.Random;

public class game {
    public static void printBoard(char[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            if (i < 2) {
                System.out.println();
                System.out.println("--+---+--");
            }
        }
    }
    private static void playerTurn(char[][] board) {
        //prompt user for input
        System.out.println("\nPlace your mark by picking b/w 1-9: ");
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();
        System.out.println("player making move");
        placeMove(board, userInput, 'X');
        keyboard.close();
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        //use switch cases to place user input on board
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("blank");
        }
    }

    public static boolean checkMove(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == '-'); //shortened if-else
            case 2:
                return (board[0][1] == '-');
            case 3:
                return (board[0][2] == '-');
            case 4:
                return (board[1][0] == '-');
            case 5:
                return (board[1][1] == '-');
            case 6:
                return (board[1][2] == '-');
            case 7:
                return (board[2][0] == '-');
            case 8:
                return (board[2][1] == '-');
            case 9:
                return (board[2][2] == '-');
            default:
                return false;
        }
    }
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerTurn;
        System.out.println("comp doin stuff");
        while(true) {
            computerTurn = rand.nextInt(9) + 1; //add 1 to get 1-9 inclusive
            if ((checkMove(board, computerTurn))) { //if spot is available for comp then break out of the loop
                break;
            }
        }
        placeMove(board, Integer.toString(computerTurn), 'O');
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3]; //3x3 array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-'; //initialize with empty space to replace later
            }
        }
        printBoard(board);

        playerTurn(board);

        computerTurn(board);

        printBoard(board);
    }
}
