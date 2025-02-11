import java.util.Scanner;
class TicTacToe
{
    static char[][] board;
    public TicTacToe()
    {
       board = new char[3][3];
        initBoard();
    }
    public void initBoard()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0; j<board[i].length;j++)
            {   
                board[i][j] = ' ';//Empty Character
            }
        }
    }
    public void displayBoard()
    {
        System.out.println("-------------");    
        for(int i=0;i<board.length;i++)
        {
            System.out.print("| ");
            for(int j=0; j<board[i].length;j++)
            {   
                System.out.print(board[i][j]+ " | ");
            }
            System.out.println();
            System.out.println("-------------"); 
        }
    }
    public static void placeMark(int row, int column, char mark)
    {
        if(row>=0 && row<=2 && column>=0 && column<=2)
        {
            board[row][column] = mark;
        }
        else
        {
            System.out.println("Invalid Position");
        }
    }
    public boolean checkWin()
    {
        //Check Column wise
        for(int j=0;j<=2; j++)
        {
            if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
            return true;
        }
        //Check Row wise 
        for(int i=0;i<=2;i++)
        {
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            {
                return true;
            }
        }
        //Check Diagnally
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {            
            return true;
        }
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return true;
        }
        return false;
    }
}


class humanPlayer
{
    String name;
    char mark;
    public humanPlayer(String name, char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    public void makeMove()
    {
        Scanner sc= new Scanner(System.in);
        int row,column;
        do
        {
            System.out.print("Enter the row and column: "); 
            row=sc.nextInt();
            column=sc.nextInt();
        }
        while(!isValidMove(row, column));

        TicTacToe.placeMark(row, column, mark);

    }
    public boolean isValidMove(int row, int column)
    {
        if(row >=0 && row<=2 && column >=0 && column<=2)
        {
            if(TicTacToe.board[row][column] == ' ')
            {
                return true;
            }
        }
        return false;
    }
}

class LaunchGame
{
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        
        humanPlayer p1 = new humanPlayer("Alex", 'X');
        humanPlayer p2 = new humanPlayer("Lorais", 'O');

        //Reference
        humanPlayer cp;
        cp = p1;//Current player is p1

        while (true) 
        {
            System.out.println(cp.name + " turn");
            cp.makeMove();
            t.displayBoard();
            if(t.checkWin())
            {
                System.out.println(cp.name + " has won!");
                break;
            }
            else
            {
                if(cp == p1)
                {
                    cp = p2;
                }
                else
                {
                    cp = p1;
                }
            }    
        }
    }
}