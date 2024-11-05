package epsi.tepedelen.leo.rpg.model;

import epsi.tepedelen.leo.rpg.exceptions.NoQuestException;

public class Character {
    private String name;
    private String classType;
    private String treasure;
    private int level;
    private int health;
    private int maxHealth;
    private Quest quest;

    public Character(String name, String classType){
        this.name = name;
        this.classType = classType;
        this.level = 1;
        this.maxHealth = 100;
        this.health = this.maxHealth;
        this.quest = null;
        this.treasure = "";
    }


    public void completeQuest() throws NoQuestException {
        if(this.quest == null){
            throw new NoQuestException("Player has no Quest to complete");
        }else {
            this.treasure += ", " + this.quest.getReward();
            this.quest = null;
            this.levelUp();
        }
    }

    public void levelUp(){
        this.level++;
        this.maxHealth += 10;
        this.fullHeal();
    }

    private void fullHeal() {
        this.health = this.maxHealth;
    }

    @Override
    public String toString() {
        return "Nom: " + name + ", Classe: " + classType + ", Niveau: " + level + ", Sante Max: " + maxHealth + ", Sante: " + health + ", Quest: " + quest;
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

    public String getTreasure() {
        return treasure;
    }

    public void setTreasure(String treasure) {
        this.treasure = treasure;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }
}
