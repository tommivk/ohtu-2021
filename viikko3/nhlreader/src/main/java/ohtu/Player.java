
package ohtu;

public class Player {
    private String name;
    private String team;
    private String goals;
    private String assists;


    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setAssits(String assists) {
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public String getGoals() {
        return goals;
    }

    public String getAssists() {
        return assists;
    }


    public int getScore() {
        return Integer.valueOf(goals) + Integer.valueOf(assists);
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name + " " + team + " G:" + goals + " A:" + assists + " = " + getScore();
    }
      
}
