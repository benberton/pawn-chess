package main.game;
import main.board.Board;
import main.player.Team;

import java.util.Scanner;

public class Game {
    private Team whiteTeam;
    private Team blackTeam;
    private Board board;

    private Team curTeam;

    private Scanner in;

    public Game(int w, int h)
    {
        this.whiteTeam = new Team("White Team",'w', w);
        this.blackTeam = new Team("Black Team",'b', w);
        this.board = new Board(h,w);
        this.board.setBoard(whiteTeam.getPawns(),blackTeam.getPawns());
        curTeam = whiteTeam;
        in = new Scanner(System.in);
    }

    public void play()
    {
        turn();
    }

    private void turn()
    {
        while (!board.isInEndState())
        {
            this.board.printBoard();
            System.out.println(curTeam.getTeamName() + "'s Turn!");
            board.movePiece(curTeam.getTeam(), this.in);
            // Switching whose turn it is
            if (this.curTeam == this.whiteTeam)
                this.curTeam = this.blackTeam;
            else
                this.curTeam = this.whiteTeam;
        }
        this.in.close();
    }
}
