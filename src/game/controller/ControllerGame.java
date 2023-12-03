package game.controller;

import game.models.Field;
import game.models.Player;

import java.util.Scanner;

public class ControllerGame {
    private Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Field field;

    public ControllerGame(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int inputCoordinate(String coordinate, Player player){
        System.out.printf("%s, enter the %s coordinate: \n", player.getNAME(), coordinate);
        return scanner.nextInt();
    }

    // Sets player's figure on the field. If it was unsuccessful !!!
    public void movePlayer(int x, int y, Player player){
        field.setCellField(x, y, player.getFIGURE());
    }

    //
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
        if (counter % 2 == 0){
            return player1.getFIGURE();
        }
        return player2.getFIGURE();
    }

    //
    public boolean endGame(){
        if (currentMove() != null){
            return false;
        }
        return true;
    }

    private boolean checkHorizontal(Player player) {
        int counter = 0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
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
    private boolean checkVertical(Player player) {
        int counter = 0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
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
    private boolean checkDiagonal(Player player) {
        int counter = 0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            if (field.getCellField(i, i) == player.getFIGURE()){
                counter++;
            }
        }
        if (counter == field.getSIZE_FIELD()){
            return true;
        }

        counter = 0;

        for (int i = field.getSIZE_FIELD() - 1; i >= 0; i--) {
            if (field.getCellField(i, field.getSIZE_FIELD() - 1 - i) == player.getFIGURE()){
                counter++;
            }
        }
        return counter == field.getSIZE_FIELD();
    }

    //
    public boolean winnerPlayer(Player player) {
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal(player);
    }

    //
    public String getWinnerPlayer(){
        if (winnerPlayer(player1)){
            return player1.getNAME();
        } else if (winnerPlayer((player2))) {
            return player2.getNAME();
        }
        return "No Winner!!!";
    }
}
