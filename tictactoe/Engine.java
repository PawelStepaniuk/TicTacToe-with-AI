package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Engine {
    PlayerContext player1 = new PlayerContext();
    PlayerContext player2 = new PlayerContext();
    Game game = new Game(player1, player2);

    void play() {
        game.enterFields();
        boolean round = true;
        do {
            if (round) {
                game.player1.enterCords(player1.getPlayerInterface());
                round = false;
            } else {
                game.player2.enterCords(player2.getPlayerInterface());
                round = true;
            }
        } while (!game.states());
        System.out.println("koniec");
    }


    void start() {
        boolean loop;
        boolean play = true;

        do {
            String[] args;
            do {
                loop = true;
                System.out.println("Input command:");
                args = new Scanner(System.in).nextLine().split(" ");
                if (args.length == 3) {
                    String start = args[0];
                    String player1 = args[1];
                    String player2 = args[2];

                    if (start.equals("start")) {
                        if (player1.equals("easy") || player1.equals("medium") || player1.equals("hard") || player1.equals("user")) {
                            if (player2.equals("easy") || player2.equals("medium") || player2.equals("hard") || player2.equals("user")) {
                                loop = false;
                            }
                        }
                    }
                } else if (args.length == 1 && args[0].equals("exit")) {
                    play = false;
                    System.exit(0);
                }
                if (loop) System.out.println("Bad parameters!");
            } while (loop);
            System.out.println(Arrays.toString(args));
            switch (args[1]) {
                case "easy":
                    player1.setStrategy(new PlayerEasy(game, "Easy", 'X'));
                    break;
                case "medium":
                    player1.setStrategy(new PlayerMedium(game, "Medium", 'X'));
                    break;
                case "hard":
                    player1.setStrategy(new PlayerHard(game, "Hard", 'X'));
                    break;
                case "user":
                    player1.setStrategy(new Player(game, "Player", 'X'));
                    break;
            }
            switch (args[2]) {
                case "easy":
                    player2.setStrategy(new PlayerEasy(game, "Easy", 'O'));
                    break;
                case "medium":
                    player2.setStrategy(new PlayerMedium(game, "Medium", 'O'));
                    break;
                case "hard":
                    player2.setStrategy(new PlayerHard(game, "Hard", 'O'));
                    break;
                case "user":
                    player2.setStrategy(new Player(game, "Player", 'O'));
                    break;
            }
            play();
            System.out.println(Arrays.toString(args));
        } while (play);
    }
}