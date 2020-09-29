package tictactoe;

public class Board {
    private char[][] board;
    private int size = 3;

    public Board(String value) {
        this.board = fill(value);
    }

    public Board(String value, int size) {
        this.board = fill(value);
        this.size = size;
    }

    private char[][] fill(String value) {
        char[][] map = new char[size][size];
        int k = 0;
        char[] values = value.toCharArray();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (values[k] == '_') {
                    map[i][j] = ' ';
                } else
                    map[i][j] = values[k];
                k++;
            }
        }
        return map;
    }

    void print() {
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");

    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}
