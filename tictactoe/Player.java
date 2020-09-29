package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Player implements PlayerInterface {
    private char field;
    private String name;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    private Game game;


    public Player(Game game, String name, char field) {
        this.game = game;
        this.name = name;
        this.field = field;
    }

    public Player(Player player1) {

    }

    protected void printBoard() {
        game.getBoard().print();
    }

    @Override
    public void enterCords() {
        System.out.println("Enter the coordinates: ");
        String x = "";
        String y = "";
        String[] cords;
        String text;
        //char value = value();
        do {
            text = scanner.nextLine();
            cords = text.split(" ");
            x = cords[0];
            y = (cords.length == 2 ? cords[1] : "");
        }
        while (!isCorrectValue(x) || !isCorrectValue(y) || !isCellIsEmpty(cordX(x, y), cordY(x, y)));

        putValueOnBoard(getField(), cordX(x, y), cordY(x, y));
        game.getBoard().print();
    }

    protected boolean isCellIsEmpty(int cord1, int cord2) {
        char[][] temp = game.getBoard().getBoard();
        try {

            //  System.out.println("This cell is occupied! Choose another one!");
            return (temp[cord1][cord2] != 'X') && temp[cord1][cord2] != 'O';
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    boolean isCorrectValue(String text) {
        int x = 0;
        try {
            x = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (x > 0 && x < 4) return true;
        else {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

    }

    void putValueOnBoard(char value, int x, int y) {
        char[][] temp = game.getBoard().getBoard();
        temp[x][y] = value;
        game.getBoard().setBoard(temp);
    }

    public void enterCordsEasy(char value) {
        System.out.println("Making move level \"easy\"");
        int y;
        int x;
        do {
            x = random.nextInt(3) + 1;
            y = random.nextInt(3) + 1;
            //            x = scanner.nextInt();
            //            y = scanner.nextInt();
            //            scanner.nextLine();
        } while (!isCellIsEmpty(cordX(x, y), cordY(x, y)));
        putValueOnBoard(value, cordX(x, y), cordY(x, y));


        game.getBoard().print();
    }

    protected int cordX(int cord1, int cord2) {
        return 3 - cord2;
    }

    protected int cordY(int cord1, int cord2) {
        return cord1 - 1;
    }

    private int cordX(String cord1, String cord2) {
        return (3 - Integer.parseInt(cord2));
    }

    private int cordY(String cord1, String cord2) {
        return (Integer.parseInt(cord1) - 1);
    }

    public char getField() {
        return field;
    }

    public void setField(char field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
