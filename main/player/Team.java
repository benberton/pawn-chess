package main.player;
import main.player.Pawn;

public class Team {

    private String teamName;
    private Pawn[] pawns;
    private char team;

    public Team(String teamName, char team, int numOfPawns)
    {
        this.teamName = teamName;
        this.pawns = new Pawn[numOfPawns];
        this.team = team;
        givePawns();
    }

    private void givePawns()
    {
        for (int i = 0; i < this.pawns.length; ++i)
        {
            this.pawns[i] = new Pawn(this.team);
        }
    }

    public Pawn[] getPawns()
    {
        return this.pawns;
    }

    public String getTeamName()
    {
        return this.teamName;
    }

    public char getTeam()
    {
        return this.team;
    }


}
