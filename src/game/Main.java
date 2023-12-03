package game;

import game.controller.ControllerGame;
import game.models.Field;
import game.models.Player;
import game.view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(3);
        Player player1 = new Player("Player1", "0");
        Player player2 = new Player("Player2", "1");
        ControllerGame controllerGame = new ControllerGame(field, player1, player2);
        View view = new View(field, player1, player2);
        view.shoeField();

        while (!controllerGame.endGame()){
            showPlayerMove(controllerGame, player1,
                    view, controllerGame.inputCoordinate("x", player1), controllerGame.inputCoordinate("y", player1));
            if (controllerGame.winnerPlayer(player1)){
                break;
            }

            showPlayerMove(controllerGame, player2,
                    view, controllerGame.inputCoordinate("x", player2), controllerGame.inputCoordinate("y", player2));
            if (controllerGame.winnerPlayer(player2)){
                break;
            }
        }
        System.out.printf("Winner is '%s'", controllerGame.getWinnerPlayer());
    }

    public static void showPlayerMove(ControllerGame controllerGame, Player player, View view, int x, int y){
        controllerGame.movePlayer(x, y, player);
        view.shoeField();
    }
}
