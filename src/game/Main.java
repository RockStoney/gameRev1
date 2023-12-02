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

        int x, y;
        x = controllerGame.inputCoordinate("x", player1);
        y = controllerGame.inputCoordinate("y", player1);
        controllerGame.movePlayer(x, y, player1);
        view.shoeField();

        x = controllerGame.inputCoordinate("x", player2);
        y = controllerGame.inputCoordinate("y", player2);
        controllerGame.movePlayer(x, y, player2);
        view.shoeField();
    }
}
