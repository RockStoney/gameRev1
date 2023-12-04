package game.models;

public class Player {
    private String NAME;
    private final String FIGURE;

    public Player(String NAME, String FIGURE) {
        this.NAME = NAME;
        this.FIGURE = FIGURE;
    }

    public String getNAME() {return NAME;}
    public String getFIGURE() {return FIGURE;}
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
