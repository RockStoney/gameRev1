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

    public int inputCoordinate(String coordinate){
        System.out.printf("Enter coordinates %s", coordinate);
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

    //
    private boolean winnerPlayer(Player player){
        int counter = 0;
        // check horizontal
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(i, j) == player.getFIGURE()){
                    counter++;
                }
                if (counter == field.getSIZE_FIELD()){
                    return true;
                }
            }
        }

        // check vertical
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(j, i) == player.getFIGURE()){
                    counter++;
                }
                if (counter == field.getSIZE_FIELD()){
                    return true;
                }
            }
        }

        // check horizontal
        counter = 0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(j, i) == player.getFIGURE()){
                    counter++;
                    break;
                }
            }
        }
        if (counter == field.getSIZE_FIELD()){
            return true;
        }

        // check vertical
        counter = 0;
        for (int i = field.getSIZE_FIELD(); i >= 0; i--) {
            for (int j = field.getSIZE_FIELD(); j >= 0; j--) {
                if (field.getCellField(j, i) == player.getFIGURE()){
                    counter++;
                    break;
                }
            }
        }
        if (counter == field.getSIZE_FIELD()){
            return true;
        }

        return false;
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