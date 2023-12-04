package game;

import game.controller.ControllerGame;
import game.models.Field;
import game.models.Player;
import game.view.View;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(3);
        Player player1 = new Player("Player1", "0");
        Player player2 = new Player("Player2", "1");
        ControllerGame controllerGame = new ControllerGame(field, player1, player2);
        View view = new View(field, player1, player2);
        view.shoeField();

        while (!controllerGame.endGame()){
            View.showPlayerMove(controllerGame, player1, view);
            if (controllerGame.winnerPlayer(player1) || controllerGame.endGame()){break;}

            View.showPlayerMove(controllerGame, player2, view);
            if (controllerGame.winnerPlayer(player2) || controllerGame.endGame()){break;}
        }
        ControllerGame.checkGameWinner(controllerGame);
    }
}
