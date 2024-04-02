package main;
import main.player.Team;
import main.board.Board;
import java.util.Scanner;
import main.game.Game;


public class Main {
    public static void main(String[] args) {
//        Team t1 = new Team("Team Ben",'w',8);
//        Team t2 = new Team("Team Josh",'b',8);
//
//        Board board = new Board(8,8);
//        board.setBoard(t1.getPawns(),t2.getPawns());
//        board.printBoard();
//        board.movePiece(t1.getTeam());
//        board.printBoard();
        Game game = new Game(8,8);
        game.play();

//        System.out.println(t1.getTeamName()); // Display the string.
    }
}
