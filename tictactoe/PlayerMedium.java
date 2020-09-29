package tictactoe;

public class PlayerMedium extends Player implements PlayerInterface {
    public PlayerMedium(Game game, String name, char field) {
        super(game, name, field);
    }

    public PlayerMedium(Player player1) {
        super(player1);
    }
}
