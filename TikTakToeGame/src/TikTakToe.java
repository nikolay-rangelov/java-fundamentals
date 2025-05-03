import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;


public class TikTakToe {

    public static char winner = ' ';
    public static String playerName = null;

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

    public static boolean isInt(String num){
        if (num == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(num);
        } catch (NumberFormatException err) {
            return false;
        }
        return true;
    }

    public static int handleUserInputInt() {
        Scanner sc = new Scanner(in);
        int num;
        String input = sc.nextLine();
        while (!isInt(input)) {
            System.out.printf("Not a valid number, please enter again: ");
            input = sc.nextLine();
        }
        num = Integer.parseInt(input);
        return num;
    }

    public static void handleUserInput (char board[][], char symbol) {
        // It breaks when user inputs nothing, should be fixed.
        Scanner sc = new Scanner(in);
        System.out.printf("Player: %s's {%c} turn, choose position: ", playerName, symbol);
        int choice = handleUserInputInt();
        while (choice < 1 || choice > 9) {
            System.out.printf("Error: No such position. Insert position again: ");
            choice = handleUserInputInt();
        }
        int status = insertUserChoiceInBoard(choice, board, symbol);
        while (status == 1) {
            System.out.printf("Error: Position is already filled. Insert position again: ");
            choice = handleUserInputInt();
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

    public static int[] checkRowBeforeWinning(int r, char[][] board, char symbol){
        int timesSeen = 0;
        int emptyCell = 0;
        int[] coordinates = {0, -1, -1};
        for (int c = 0; c < 3; c++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
                coordinates[1] = r;
                coordinates[2] = c;
            }
        }

        if (timesSeen == 2 && emptyCell == 1) {
            coordinates[0] = 1;
        }
        return coordinates;
    }

    public static int[] checkColumnBeforeWinning(int c, char[][] board, char symbol){
        int timesSeen = 0;
        int emptyCell = 0;
        int[] coordinates = {0, -1, -1};
        for (int r = 0; r < 3; r++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
                coordinates[1] = r;
                coordinates[2] = c;
            }
        }

        if (timesSeen == 2 && emptyCell == 1) {
            coordinates[0] = 1;
        }
        return coordinates;
    }

    public static int[] checkDiagonalsBeforeWinning(char[][] board, char symbol){
        int timesSeen = 0;
        int emptyCell = 0;
        int[] coordinates = {0, -1, -1};
        int r = 0;
        int c = 0;
        for (int i = 0; i < 3; i++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
                coordinates[1] = r;
                coordinates[2] = c;
            }
            r++;
            c++;
        }
        if (timesSeen == 2 && emptyCell == 1) {
            coordinates[0] = 1;
        }

        if(coordinates[0] == 0) {
            timesSeen = 0;
            emptyCell = 0;
            r = 2;
            c = 0;
            for (int i = 0; i < 3; i++) {
                if (symbol == board[r][c]) {
                    timesSeen++;
                }
                if (board[r][c] != 'X' && board[r][c] != 'O') {
                    emptyCell++;
                    coordinates[1] = r;
                    coordinates[2] = c;
                }
                r--;
                c++;
            }
            if (timesSeen == 2 && emptyCell == 1) {
                coordinates[0] = 1;
            }
        }
        return coordinates;
    }


    public static int[] checkBeforeWinning (char[][] board, char symbol){
        int result[] = {0, -1, -1};
        //check rows before winning
        for (int r = 0; r < 3; r++) {
            result = checkRowBeforeWinning(r, board, symbol);
            if(result[0] == 1) {
                break;
            }
        }
         //check columns before winning
        if (result[0] == 0) {
            for (int c = 0; c < 3; c++) {
                result = checkColumnBeforeWinning(c, board, symbol);
                if(result[0] == 1) {
                    break;
                }
            }
        }

        // check diagonals before winning
        if (result[0] == 0) {
            result = checkDiagonalsBeforeWinning(board, 'X');
        }

        return result;
    }

    public static void calculateRowScore(int r, char[][] board, int[][] boardScore, char symbol) {
        int timesSeen = 0;
        int emptyCell = 0;
        for (int c = 0; c < 3; c++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                boardScore[r][c] += emptyCell - timesSeen;
            }
        }
    }

    public static void calculateColumnScore(int c, char[][] board, int[][] boardScore, char symbol) {
        int timesSeen = 0;
        int emptyCell = 0;
        for (int r = 0; r < 3; r++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
            }
        }
        for (int r = 0; r < 3; r++) {
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                boardScore[r][c] += emptyCell - timesSeen;
            }
        }
    }

    public static void calculateDiagonalsScore(char[][] board, int[][] boardScore, char symbol) {
        int timesSeen = 0;
        int emptyCell = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < 3; i++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
            }
            r++;
            c++;
        }

        r = 0;
        c = 0;
        for (int i = 0; i < 3; i++) {
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                boardScore[r][c] += emptyCell + timesSeen;
            }
            r++;
            c++;
        }

        r = 2;
        c = 0;
        timesSeen = 0;
        emptyCell = 0;
        for (int i = 0; i < 3; i++) {
            if (symbol == board[r][c]) {
                timesSeen++;
            }
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                emptyCell++;
            }
            r--;
            c++;
        }

        r = 2;
        c = 0;
        for (int i = 0; i < 3; i++) {
            if (board[r][c] != 'X' && board[r][c] != 'O') {
                boardScore[r][c] += emptyCell + timesSeen;
            }
            r--;
            c++;
        }
    }

    public static void calculateBoardScore(char[][] board, int[][] boardScore, char symbol) {
        // calculate row score
        for (int r = 0; r < 3; r++) {
            calculateRowScore(r, board, boardScore, symbol);
        }
        // calculate column score
        for (int c = 0; c < 3; c++) {
            calculateColumnScore(c, board, boardScore, symbol);
        }
        calculateDiagonalsScore(board, boardScore, symbol);
    }

    public static void printBoardScore(int scoreBoard[][])
    {
        for (int r = 0; r < 3; r++) {
            System.out.print("[");
            for (int c = 0; c < 3; c++) {
                if (c < 2) {
                    System.out.printf("%d, ", scoreBoard[r][c]);
                } else {
                    System.out.printf("%d", scoreBoard[r][c]);
                }
            }
            System.out.printf("]%n");
        }
    }

    public static int randomNumberInRange(int min, int max) {
        int randomNum = min + (int)(Math.random() * ((max - min) + 1));
        return randomNum;
    }

    public static int[] findBestMoveBasedOnScoreBoard(int scoreBoard[][]) {
        int[] nextMove = {0, 0};
        int max = Integer.MIN_VALUE;
        List<int[]> foundMoves = new ArrayList<int[]>(); // Create an ArrayList object
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (max < scoreBoard[r][c]) {
                    max = scoreBoard[r][c];
                }
            }
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (max == scoreBoard[r][c]) {
                    int[] point = {r, c};
                    foundMoves.add(point);
                }
            }
        }

        if (foundMoves.size() == 1) {
            nextMove = foundMoves.get(0);
        } else {
            int size = foundMoves.size();
            nextMove = foundMoves.get(randomNumberInRange(0, size-1));
        }
        return nextMove;
    }


    public static void gameEngine(char[][] board) {
         //block the other player before winning
        boolean decisionTaken = false;
        int[] result = checkBeforeWinning(board, 'X');

        if (result[0] == 1) {
            char cellNum = board[result[1]][result[2]];
            board[result[1]][result[2]] = 'O';
            System.out.printf("The computer has made the following move: %c.%n", cellNum);
            decisionTaken = true;
        }

        // check if the computer is about to win
        if (!decisionTaken) {
            result = checkBeforeWinning(board, 'O');
            if (result[0] == 1) {
                char cellNum = board[result[1]][result[2]];
                board[result[1]][result[2]] = 'O';
                System.out.printf("The computer has made the following move: %c.%n", cellNum);
                decisionTaken = true;
            }
        }

        // calculate score for each box if decision is still not taken
        if (!decisionTaken) {
            int[][] boardScore = {{ 0, 0, 0},
                                  { 0, 0, 0},
                                  { 0, 0, 0}};
            calculateBoardScore(board, boardScore, 'O');
            result = findBestMoveBasedOnScoreBoard(boardScore);
            char cellNum = board[result[0]][result[1]];
            board[result[0]][result[1]] = 'O';
            System.out.printf("The computer has made the following move: %c.%n",cellNum);
            //printBoardScore(boardScore);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        boolean gameWon = false;
        System.out.printf("Please, enter your name to start the game: ");
        playerName = sc.nextLine();
        while (playerName == "") {
            System.out.printf("No input, please, enter your name to start the game: ");
            playerName = sc.nextLine();
        }
        System.out.printf("Hello, %s! The game starts!%n", playerName);
        System.out.printf("---Game started---%n");
        printBoard(board);
        int player = 1;
        for (int i = 0; i < 9; i++) {
            if (player == 1) {
                handleUserInput(board, 'X');
                player = 2;
            } else {
                gameEngine(board);
                player = 1;
            }
            printBoard(board);
            gameWon = checkIfWon(board);
            if (gameWon) {
                break;
            }
        }
        if (gameWon) {
            if (winner == 'X') {
                System.out.printf("Congratulations, %s {%c} won the game!%n", playerName, 'X');
            } else {
                System.out.printf("You lost, %s {%c}. The Computer {%c} won the game!%n", playerName, 'X', 'O');
            }
        } else {
            System.out.printf("No one won the game.%n");
        }
        System.out.printf("---Game finished, thank you for playing!---");
    }
}