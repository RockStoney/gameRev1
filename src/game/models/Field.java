package game.models;

public class Field {
    private final int SIZE_FIELD;
    private String[][] stateField;
    private final String DEFAULT_SYMBOL = " ";
    private final int MIN_VALUE;
    private final int MAX_VALUE;

    public Field(int SIZE_FIELD) {
        this.SIZE_FIELD = SIZE_FIELD;
        this.MIN_VALUE = 0;
        this.MAX_VALUE = getSIZE_FIELD();
        this.stateField = new String[getSIZE_FIELD()][getSIZE_FIELD()];
        setStateField(DEFAULT_SYMBOL);
    }

    public int getSIZE_FIELD() {return SIZE_FIELD;}
    public String[][] getStateField() {return stateField;}
    public String getDEFAULT_SYMBOL() {return DEFAULT_SYMBOL;}
    public int getMIN_VALUE() {return MIN_VALUE;}
    public int getMAX_VALUE() {return MAX_VALUE;}

    public void setStateField(String symbol) {
        for (int i = 0; i < getSIZE_FIELD(); i++) {
            for (int j = 0; j < getSIZE_FIELD(); j++) {
                setCellField(i, j, symbol);
            }
        }
        this.stateField = stateField;
    }
    public boolean checkCoordinate (int coordinate){
        if (coordinate >= getMIN_VALUE() && coordinate < getMAX_VALUE()){
            return true;
        } else {
            System.out.println("Please, check a coordinate and try enter again");
            return false;
        }
    }
    public String getCellField (int i, int j){
        if (checkCoordinate(i) && checkCoordinate(j)) {
            return stateField[i][j];
        }
        return null;
    }
    public void setCellField(int i, int j, String symbol) {
        if (checkCoordinate(i) && checkCoordinate(j)){
            if (stateField[i][j] == getDEFAULT_SYMBOL() || stateField[i][j] == null){
                this.stateField[i][j] = symbol;
            } else {
                System.out.println("This field occupied");
            }
        }
    }
}
