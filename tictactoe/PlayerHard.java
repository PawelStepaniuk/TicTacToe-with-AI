package tictactoe;

public class PlayerHard extends Player implements PlayerInterface {
    public PlayerHard(Game game, String name, char field) {
        super(game, name, field);
    }

    public PlayerHard(Player player1) {
        super(player1);
    }
}
