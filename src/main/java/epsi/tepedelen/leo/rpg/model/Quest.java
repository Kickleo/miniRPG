package epsi.tepedelen.leo.rpg.model;

public class Quest {
    private String questName;
    private int difficulty;
    private String reward;

    public Quest(String questName, int difficulty, String reward) {
        this.questName = questName;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "questName='" + questName + '\'' +
                ", difficulty=" + difficulty +
                ", reward='" + reward + '\'' +
                '}';
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
}
