package tictactoe;

import java.util.Random;

public class PlayerEasy extends Player implements PlayerInterface {
    Random random = new Random();


    public PlayerEasy(Game game, String name, char field) {
        super(game, name, field);
    }

    public PlayerEasy(Player player1) {
        super(player1);
    }

    @Override
    public void enterCords() {
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
        putValueOnBoard(getField(), cordX(x, y), cordY(x, y));
        printBoard();
    }

}
