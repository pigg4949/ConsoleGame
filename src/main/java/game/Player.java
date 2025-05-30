package game;

public class Player {
    private String name;
    private String gender;
    private int affection;

    public Player(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.affection = 0;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAffection() {
        return affection;
    }

    public void setAffection(int affection) {
        this.affection = affection;
    }

    public void addAffection(int delta) {
        this.affection += delta;
    }
}
