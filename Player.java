public class Player {
    private int team;
    private Player otherPlayer;
    public Player(int team){
        this.team = team;
    }
    public void setOtherPlayer(Player otherPlayer){this.otherPlayer =otherPlayer;}
    public int getTeam(){return team;}
    public Player getOtherPlayer(){return otherPlayer;}
    public String toString(){
        return team == 1 ? "One" : "Two";
    }
}