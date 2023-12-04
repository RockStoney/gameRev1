package game.models;

public class Field {
    private final int SIZE_FIELD;
    final private String[][] stateField;
    private final String DEFAULT_SYMBOL = " ";
    private final int MIN_VALUE;
    private final int MAX_VALUE;

    // Constructor
    public Field(int SIZE_FIELD) {
        this.SIZE_FIELD = SIZE_FIELD;
        this.MIN_VALUE = 0;
        this.MAX_VALUE = getSIZE_FIELD();
        this.stateField = new String[getSIZE_FIELD()][getSIZE_FIELD()];
        setStateField(DEFAULT_SYMBOL);
    }

    // Returns field's size
    public int getSIZE_FIELD() {return SIZE_FIELD;}

    // Returns field's state
    public String[][] getStateField() {return stateField;}

    // Returns default symbol
    public String getDEFAULT_SYMBOL() {return DEFAULT_SYMBOL;}

    // Returns minimal value
    public int getMIN_VALUE() {return MIN_VALUE;}

    // Returns maximal value
    public int getMAX_VALUE() {return MAX_VALUE;}

    // Sets field's state
    public void setStateField(String symbol) {
        for (int i = 0; i < getSIZE_FIELD(); i++) {
            for (int j = 0; j < getSIZE_FIELD(); j++) {
                setCellField(i, j, symbol);
            }
        }
    }

    // Checks coordinate
    public boolean checkCoordinate (int coordinate){
        if (coordinate >= getMIN_VALUE() && coordinate < getMAX_VALUE()){
            return true;
        } else {
            System.out.println("Please, check a coordinate and try enter again");
            return false;
        }
    }

    // Returns field's sign
    public String getCellField (int i, int j){
        if (checkCoordinate(i) && checkCoordinate(j)) {
            return stateField[i][j];
        }
        return null;
    }

    // Sets field's sign
    public void setCellField(int i, int j, String symbol) {
        if (checkCoordinate(i) && checkCoordinate(j)){
            if (stateField[i][j] == getDEFAULT_SYMBOL() || stateField[i][j] == null) {
                this.stateField[i][j] = symbol;
            } else {
                System.out.println("This field occupied. Try again");
            }
        }
    }
}
