package game.view;

import game.controller.ControllerGame;
import game.models.Field;
import game.models.Player;
import java.util.Scanner;

public class View {
    private Field field;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public View(Field field, Player player1, Player player2) {
        this.field = field;
        System.out.println("-----------------------------------------------");
        System.out.println("        Hello. This is a new game!!!");
        System.out.println("-----------------------------------------------");
        System.out.print("Enter name for first player: ");
        player1.setNAME(scanner.nextLine());
        System.out.println("-----------------------------------------------");
        System.out.print("Enter name for second player: ");
        ControllerGame.checkSamePlayerName(player1, player2, scanner);
        System.out.println("-----------------------------------------------");
        System.out.printf("First player:   %s and his character is '%s'\n", player1.getNAME(), player1.getFIGURE());
        System.out.printf("Second player:  %s and his character is '%s'\n", player2.getNAME(), player2.getFIGURE());
        System.out.println("-----------------------------------------------");
    }

    // Prints field
    public void shoeField(){
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                System.out.printf("[%s]", field.getCellField(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Shows player's move
    public static void showPlayerMove(ControllerGame controllerGame, Player player, View view){
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
