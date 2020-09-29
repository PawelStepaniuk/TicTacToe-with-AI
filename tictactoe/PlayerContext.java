package tictactoe;

public class PlayerContext {
    private PlayerInterface playerInterface;

    public void setStrategy(PlayerInterface playerInterface) {
        this.playerInterface = playerInterface;
    }

    public PlayerInterface getPlayerInterface() {
        return playerInterface;
    }

    public void enterCords(PlayerInterface playerInterface) {
        playerInterface.enterCords();
    }
}
