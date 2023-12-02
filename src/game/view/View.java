package game.view;

import game.models.Field;
import game.models.Player;

public class View {
    private Field field;

    public View(Field field, Player player1, Player player2) {
        this.field = field;
        System.out.println("----------------------------");
        System.out.println("Hello. This is a new game!!!");
        System.out.println("----------------------------");
        System.out.printf("First player: %s\n", player1.getNAME());
        System.out.printf("Second player: %s\n", player2.getNAME());
        System.out.println("----------------------------");
        System.out.println();
    }

    // prints field
    public void shoeField(){
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                System.out.printf("[%s]", field.getCellField(i, j));
            }
            System.out.println();
        }
    }
}
