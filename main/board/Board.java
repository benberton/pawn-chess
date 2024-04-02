package main.board;
import main.player.Pawn;
import java.util.Scanner;

public class Board {

    Pawn[][] board;

    public Board(int height, int width)
    {
        board = new Pawn[height][width];
    }

    public void setBoard(Pawn[] whiteTeam, Pawn[] blackTeam)
    {
        for (int i = 0; i < board[0].length; ++i)
        {
            board[1][i] = whiteTeam[i];
            board[board.length - 2][i] = blackTeam[i];
        }

    }

    public void movePiece(char team, Scanner in)
    {
        int x = -1;
        int y = -1;
        int x2 = -1;
        int y2 = -1;


        String s;
        do {
            System.out.println("Enter the x value");
            s = in.nextLine();
            x = Integer.parseInt(s);
            System.out.println("Enter the y value");
            s = in.nextLine();
            y = Integer.parseInt(s);
            System.out.println("Enter the new x value");
            s = in.nextLine();
            x2 = Integer.parseInt(s);
            System.out.println("Enter the new y value");
            s = in.nextLine();
            y2 = Integer.parseInt(s);

        }while (!isValidMove(x, y, x2, y2, team));

        board[y2][x2] = board[y][x];
        board[y][x] = null;
    }

    public boolean isInEndState()
    {
        // Checking for black pieces at top of board
        for (int i = 0; i < board.length; ++i)
            if (board[0][i] != null && board[0][i].getTeam() == 'b')
                return true;

        // Checking for black pieces at top of board
        for (int i = 0; i < board.length; ++i)
            if (board[board.length - 1][i] != null && board[board.length - 1][i].getTeam() == 'w')
                return true;
        return false;
    }

    private boolean isValidMove(int x, int y, int x2, int y2, char team)
    {
        // checking if move is on the board
        if (isOnBoard(x, y) && isOnBoard(x2, y2))
        {
            // checking if a valid piece (given the team) is selected
            if (isCorrectTeam(x, y, team))
            {
                // checks if a pawn could physically move there
                if (isPossibleMove(x, y, x2, y2, team))
                {
                    // checks if can move diagonal or straight
                    if (isNormalMove(x, y, x2, y2, team))
                        return true;
                    else
                        System.out.println("ERROR: Invalid straight or diagonal move");
                }else
                    System.out.println("ERROR: Pawn cannot move like that");
            }else
                System.out.println("ERROR: Team piece not chosen");
        }else
            System.out.println("ERROR: Selection not on board");

        return false;
    }

    private boolean isOnBoard(int x, int y)
    {
        if (x >= 0 && x < this.board[0].length)
            if (y >= 0 && y < this.board.length)
                return true;
        return false;
    }

    private boolean isCorrectTeam(int x, int y, char team)
    {
        if (board[y][x] != null && board[y][x].getTeam() == team)
            return true;
        return false;
    }

    private boolean isNormalMove(int x, int y, int x2, int y2, char team)
    {
        if (isDiagonalMove(x, x2)) {
            // checks if position you want to move to has an opposing piece
            if (board[y2][x2] != null && board[y2][x2].getTeam() != team)
                return true;
            return false;
        }else if (isStraightMove(x, x2))
        {
            // cannot move forward if there is a piece in front
            if(isPieceInFront(x, y, team))
                return false;
            return true;
        }
        return true;
    }

    private boolean isPossibleMove(int x, int y, int x2, int y2, char team)
    {
        if (x2 >= x - 1 && x2 <= x + 1)
        {
            if (team == 'w')
                if (y2 == y + 1)
                    return true;
            if (team == 'b')
                if (y2 == y - 1)
                    return true;
        }
        return false;
    }

    boolean isPieceInFront(int x, int y, char team)
    {
        if (team == 'w')
            if (board[y - 1][x] != null)
                return true;
        if (team == 'b')
            if (board[y + 1][x] != null)
                return true;
        return false;
    }

    boolean isDiagonalMove(int x, int x2)
    {
        if (x != x2)
            return true;
        return false;
    }

    boolean isStraightMove(int x, int x2)
    {
        if (x == x2)
            return true;
        return false;
    }



    public void printBoard()
    {
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[i].length; ++j)
            {
                if (board[i][j] == null)
                    System.out.print(" - ");
                else
                    System.out.print(" " + board[i][j].getTeam() + " ");
            }
            System.out.println("");
        }
    }
}
