package team;
class Pawn {

    private int x;
    private int y;
    private char team;
    boolean inPlay;

    
    public Pawn(char team)
    {
        this.team = team;
        this.inPlay = true;
    }


    private boolean isValidMove(int x, int y)
    {
        return true;
    }

    public void movePiece(int x, int y)
    {
        // this.x = x
        // this.y = y
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void takeOutOfPlay()
    {

    }
}