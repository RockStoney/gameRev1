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
            showPlayerMove(controllerGame, field, player1, view);
            if (controllerGame.winnerPlayer(player1) || controllerGame.endGame()){break;}

            showPlayerMove(controllerGame, field, player2, view);
            if (controllerGame.winnerPlayer(player2) || controllerGame.endGame()){break;}
        }
        checkGameWinner(controllerGame);
    }

    public static void checkGameWinner(ControllerGame controllerGame){
        if (controllerGame.getWinnerPlayer() == "No Winner!!!"){
            System.out.println(controllerGame.getWinnerPlayer());
        } else {
            System.out.printf("Winner is '%s'", controllerGame.getWinnerPlayer());
        }
    }

    public static void showPlayerMove(ControllerGame controllerGame, Field field, Player player, View view){
        boolean validMove = false;

        while (!validMove) {
            int x = controllerGame.inputCoordinate("x", player);
            int y = controllerGame.inputCoordinate("y", player);

            if (controllerGame.isValidMove(x, y)) {
                controllerGame.movePlayer(x, y, player);
                view.shoeField();
                validMove = true;
            }
        }
    }
}
