package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Game {
    final private Scanner scanner = new Scanner(System.in);
    private Board board;
    static Random random = new Random();
    PlayerContext player1;
    PlayerContext player2;

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public Game(PlayerContext player1, PlayerContext player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    private char value() {
        char[][] temp = board.getBoard();
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j] == 'X') countX++;
                else if (temp[i][j] == 'O') countO++;
            }
        }
        if (countX > countO) {
            return 'O';
        } else return 'X';
    }

    public void enterFields() {
        String fields = "_________";
//        System.out.println("Enter cells: ");
//        String fields = scanner.nextLine();
        board = new Board(fields);
        board.print();
    }

    private boolean isCellIsEmpty(int cord1, int cord2) {
        char[][] temp = board.getBoard();
        try {

            //  System.out.println("This cell is occupied! Choose another one!");
            return (temp[cord1][cord2] != 'X') && temp[cord1][cord2] != 'O';
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isEmptyCells() {
        char[][] temp = board.getBoard();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }


    private int cordX(int cord1, int cord2) {
        return 3 - cord2;
    }

    private int cordY(int cord1, int cord2) {
        return cord1 - 1;
    }

    private int cordX(String cord1, String cord2) {
        return (3 - Integer.parseInt(cord2));
    }

    private int cordY(String cord1, String cord2) {
        return (Integer.parseInt(cord1) - 1);
    }

    public boolean states() {
        if (draw()) {
            System.out.println("Draw");
            return true;
        } else if (win('X')) {
            System.out.println("X wins");
            return true;
        } else if (win('O')) {
            System.out.println("O wins");
            return true;
        } else if (gameNotFinished()) {
            //    System.out.println("Game not finished");
            return false;
        }
        return false;
    }

    private boolean gameNotFinished() {
        return isEmptyCells();
    }

    private boolean draw() {
        return !win('X') && !win('O') && !isEmptyCells();
    }

    public boolean win(char value) {
        char[][] temp = board.getBoard();
        int count = 0;
        //pionowo
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j] == value) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
            count = 0;
        }
//        //poziomo
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[j][i] == value) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
            count = 0;
        }
        //skos gora lewo / prawo dol

        int k = 0;
        for (int i = 0; i < temp.length; i++) {

            if (temp[k][i] == value) {
                count++;
                k++;
            }
            if (count == 3) {
                return true;
            }
        }
        count = 0;
        k = 1;
        for (int i = temp.length; i > 0; i--) {
            if (temp[cordX(k, k)][cordY(k, k)] == value) {
                count++;
                k++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

}
