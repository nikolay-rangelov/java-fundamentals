import java.util.Scanner;

import static java.lang.System.in;


public class TikTakToe {

    public static char winner = ' ';

    public static void printBoard(char[][] board) {
        System.out.printf(" _ _ _ %n");
        for(int i = 0; i < 3; i++) {
            System.out.printf("|");
            for (int j = 0; j < 3; j++) {
                if (j != 2) {
                    System.out.printf("%c ", board[i][j]);
                } else {
                    System.out.printf("%c", board[i][j]);
                }
            }
            System.out.printf("|%n");
        }
        System.out.printf(" ¯ ¯ ¯ %n");
    }

    public static char returnCharOnPosition(int position, char[][] board) {
        char result = ' ';
        switch (position) {
            case 1:
                result = board[0][0];
                break;
            case 2:
                result = board[0][1];
                break;
            case 3:
                result = board[0][2];
                break;
            case 4:
                result = board[1][0];
                break;
            case 5:
                result = board[1][1];
                break;
            case 6:
                result = board[1][2];
                break;
            case 7:
                result = board[2][0];
                break;
            case 8:
                result = board[2][1];
                break;
            case 9:
                result = board[2][2];
                break;
        }
        return result;
    }

    public static void writeCharOnPosition(int position, char[][] board, char symbol) {
        switch (position) {
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
        }
    }

    public static int insertUserChoiceInBoard(int position, char[][] board, char symbol) {
        int status = 0;
        if (returnCharOnPosition(position, board) == 'X' || returnCharOnPosition(position, board) == 'O') {
            status = 1;
        } else {
            writeCharOnPosition(position, board, symbol);
        }
        return status;
    }

    public static void handleUserInput (int player, char board[][], char symbol) {
        // It breaks when user inputs nothing, should be fixed.
        Scanner sc = new Scanner(in);
        System.out.printf("Player %d {%c} turn, choose position: ", player, symbol);
        int choice = Integer.parseInt(sc.nextLine());
        while (choice < 1 || choice > 9) {
            System.out.printf("Error: No such position. Insert position again: ");
            choice = Integer.parseInt(sc.nextLine());
        }
        int status = insertUserChoiceInBoard(choice, board, symbol);
        while (status == 1) {
            System.out.printf("Error: Position is already filled. Insert position again: ");
            choice = Integer.parseInt(sc.nextLine());
            status = insertUserChoiceInBoard(choice, board, symbol);
        }
    }

    public static boolean checkRow(int r, char[][] board){
        boolean win = true;
        char symbol = ' ';
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                symbol = board[r][i];
            }

            if (symbol != board[r][i]) {
                win = false;
                break;
            }
        }

        if(win) {
            winner = symbol;
        }
        return win;
    }

    public static boolean checkColumn(int c, char[][] board) {
        boolean win = true;
        char symbol = ' ';
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                symbol = board[i][c];
            }

            if (symbol != board[i][c]) {
                win = false;
                break;
            }
        }

        if(win) {
            winner = symbol;
        }
        return win;
    }

    public static boolean checkDiagonals(char[][] board) {
        boolean win = true;
        char symbol = ' ';
        int r = 0;
        int c = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                symbol = board[r][c];
            }
            if (symbol != board[r][c]) {
                win = false;
                break;
            }
            r++;
            c++;
        }

        if (!win) {
            win = true;
            r = 2;
            c = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    symbol = board[r][c];
                }
                if (symbol != board[r][c]) {
                    win = false;
                    break;
                }
                r--;
                c++;
            }
        }
        if(win) {
            winner = symbol;
        }
        return win;
    }

    public static boolean checkIfWon(char[][] board) {
        boolean win = false;
        for (int r = 0; r < 3; r++) {
            win = checkRow(r, board);
            if (win) {
                break;
            }
        }

        if (!win) {
            for (int c = 0; c < 3; c++) {
                win = checkColumn(c, board);
                if (win) {
                    break;
                }
            }
        }

        if (!win) {
            win = checkDiagonals(board);
        }
        return win;
    }

    public static void main(String[] args) {
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        boolean gameWon = false;
        System.out.printf("---Game started---%n");
        printBoard(board);
        int player = 1;
        for (int i = 0; i < 9; i++) {
            if (player == 1) {
                handleUserInput(player, board, 'X');
                player = 2;
            } else {
                handleUserInput(player, board, 'O');
                player = 1;
            }
            printBoard(board);
            gameWon = checkIfWon(board);
            if (gameWon) {
                if (winner == 'X') {
                    System.out.printf("Congratulations, Player 1 {%c} won the game!%n", 'X');
                } else {
                    System.out.printf("Congratulations, Player 2 {%c} won the game!%n", 'O');
                }
                break;
            } else {
                System.out.printf("No one won the game.%n");
            }
        }
        System.out.printf("---Game finished---");
    }
}
