public class Character {
    String name;
    String classType;
    int level;

    Character(String name, String classType){
        this.name = name;
        this.classType = classType;
        this.level = 1;
    }

    public void levelUp(){
        this.level++;
    }

    
}
