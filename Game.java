import java.util.Scanner;
public class Game {
    static Scanner input = new Scanner(System.in);
    private Player playerOne;
    private Player playerTwo;
    private Grid grid;
    public Game(){
        grid = new Grid();
        System.out.println("Player One: X  || Player Two: O");
        playerOne = new Player(1);
        playerTwo = new Player(4);
        playerOne.setOtherPlayer(playerTwo);
        playerTwo.setOtherPlayer(playerOne);
    }

    public void gameLoop(){
        Player winner;
        while (true){
            playerChoosePosition(playerOne);
            if (grid.draw()){
                winner = null;
                break;}
            if (grid.hasWon()){
                winner = playerOne;
                break;}
            playerChoosePosition(playerTwo);
            if (grid.draw()){
                winner = null;
                break;}
            if (grid.hasWon()){
                winner = playerTwo;
                break;}

        }
        if (winner == null){
            System.out.println("Game is a draw");
            grid.showGrid();
        }
        else{
            System.out.println("Player " + winner.toString() + " has won");
            grid.showGrid();
        }
    }

    private void checkPosition(Player playerAdd){
        Player player = playerAdd;
        int x = 0;
        int y = 0;
        while (true){
            x = Integer.parseInt(input.next());
            y = Integer.parseInt(input.next());
            if (grid.getElement(y,x) == player.getOtherPlayer().getTeam()){
                System.out.println("Position already occupied - Choose new position");
            }
            else{
                grid.addElement(y,x,player.getTeam());
                break;
            }
        }
    }
    private void playerChoosePosition(Player player){
        Player player1 = player;
        grid.showGrid();
        System.out.println("Player " + player1.getTeam() + " Enter X then Y of desired position");
        checkPosition(player1);
    }
}