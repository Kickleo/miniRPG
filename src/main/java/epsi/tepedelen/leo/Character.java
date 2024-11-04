package epsi.tepedelen.leo;

public class Character {
    private String name;
    private String classType;
    private int level;

    Character(String name, String classType){
        this.name = name;
        this.classType = classType;
        this.level = 1;
    }

    public void levelUp(){
        this.level++;
    }

    @Override
    public String toString() {
        return "Nom: " + name + ", Classe: " + classType + ", Niveau: " + level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
