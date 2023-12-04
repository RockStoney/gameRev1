package game.controller;

import game.models.Field;
import game.models.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerGame {
    private Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Field field;

    // Constructor
    public ControllerGame(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    // Inputs player's coordinates
    public int inputCoordinate(String coordinate, Player player) {
        while (true) {
            try {
                System.out.printf("%s, enter the %s coordinate: ", player.getNAME(), coordinate);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Characters cannot be entered");
            } finally {
                scanner.nextLine();
            }
        }
    }

    // Sets player's figure on the field.
    public void movePlayer(int x, int y, Player player){
        field.setCellField(x, y, player.getFIGURE());
    }

    // Checks if the player's coordinate is correct.
    public boolean isValidMove(int x, int y) {
        return field.checkCoordinate(x) && field.checkCoordinate(y) && field.getCellField(x, y) == field.getDEFAULT_SYMBOL();
    }

    // Determines the current move or turn in the game
    public String currentMove(){
        String[][] temp = field.getStateField();
        int lenTemp = temp.length;
        int counter = 0;
        for (int i = 0; i < lenTemp; i++) {
            for (int j = 0; j < lenTemp; j++) {
                if (temp[i][j] != " "){
                    counter++;
                }
            }
        }
        if (counter == field.getSIZE_FIELD() * field.getSIZE_FIELD()){
            return null;
        }
        return player2.getFIGURE();
    }

    // Determines end of the game
    public boolean endGame(){
        if (currentMove() != null){
            return false;
        }
        return true;
    }

    // Checks horizontal player's move
    private boolean checkHorizontal(Player player) {
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            int counter = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(i, j) == player.getFIGURE()) {
                    counter++;
                }
                if (counter == field.getSIZE_FIELD()) {
                    return true;
                }
            }
        }
        return false;
    }
    // Checks vertical player's move
    private boolean checkVertical(Player player) {
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            int counter = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(j, i) == player.getFIGURE()) {
                    counter++;
                }
                if (counter == field.getSIZE_FIELD()) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks diagonal player's move
    private boolean checkDiagonal1(Player player) {
        int counter = 0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            if (field.getCellField(i, i) == player.getFIGURE()){
                counter++;
            }
        }
        if (counter == field.getSIZE_FIELD()) {
            return true;
        }
        return false;
    }

    // Checks diagonal player's move
    private boolean checkDiagonal2(Player player) {
        int counter = 0;
        for (int i = field.getSIZE_FIELD() - 1; i >= 0; i--) {
            if (field.getCellField(i, field.getSIZE_FIELD() - 1 - i) == player.getFIGURE()){
                counter++;
            }
        }
        if (counter == field.getSIZE_FIELD()) {
            return true;
        }
        return false;
    }

    // Determines winner
    public boolean winnerPlayer(Player player) {
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal1(player) || checkDiagonal2(player);
    }

    // Returns winner
    public String getWinnerPlayer(){
        if (winnerPlayer(player1)){
            return player1.getNAME();
        } else if (winnerPlayer((player2))) {
            return player2.getNAME();
        }
        return "No Winner. Try again.";
    }

    // Checks same player name
    public static void checkSamePlayerName(Player p1, Player p2, Scanner scanner){
        boolean isNameTaken;
        do {
            p2.setNAME(scanner.nextLine());
            isNameTaken = p1.getNAME().equalsIgnoreCase(p2.getNAME());
            if (isNameTaken) {
                System.out.print("This name already taken. Enter another name: ");
            }
        } while (isNameTaken);
    }
}
