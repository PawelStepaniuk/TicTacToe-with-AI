package tictactoe;

public enum States {
    GAME_NOT_FINISHED(true) {
        public String output() {
            return "Game not finished";
        }
    }, DRAW(true) {
        public String output() {
            return "Draw";
        }
    }, X_WINS(true) {
        public String output() {
            return "X wins";
        }
    }, O_WINS(true) {
        public String output() {
            return "O wins";
        }
    };
    private final boolean finish;

    States(boolean finish) {
        this.finish = finish;
    }

}
