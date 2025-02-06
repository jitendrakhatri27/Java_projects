import java.util.Scanner;
public class TicTacToe
{
	private char[][] board;
	private char currentPlayer;
	
	public TicTacToe()
	{
		board = new char[3][3];
		currentPlayer = 'X'; //Player X is Starts
		initializeBoard();
	}
	
	private void initializeBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0; j<3;j++)
			{
				board[i][j] = '-'; 
			}
		}
	}
	
	public void printBoard()
	{
		System.out.println("Current Board: ");
		for(int i=0; i<3; i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	} 
	public boolean isBoardFull()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(board[i][j] == '-')
				{
					return false;
				}
			}
		}
		return true;	
	}
	public boolean checkForWin()
	{
		//Check rows
		for(int i=0; i<3; i++)
		{
			if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer)
			{
				return true;
			}
		}
		//Check columns
		for(int i=0; i<3; i++)
		{
			if(board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer)
			{
				return true;
			}
		}
		//Check diagonals
		if(board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer)
		{
			return true;
		}
		if(board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer)
		{
			return true;
		}
		return false;
	}

	public void changePlayer()
	{
		currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
	}

	public void play()
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			printBoard();
			int row,col;
			System.out.println("Player " +currentPlayer+", enter your move (row and col): ");
			row=sc.nextInt();
			col=sc.nextInt();

			if(row<0 || row>=3 || col<0 || col>=3 || board[row][col]!='-')
			{
				System.out.println("This move is not valid");
				continue;
			}

			board[row][col] = currentPlayer;

			if(checkForWin())
			{
				printBoard();
				System.out.println("Player "+currentPlayer+ " Wins!");
				break;
			}
		
			if(isBoardFull())
			{
				printBoard();
				System.out.println("The Game is Draw!");
				break;
			}

			changePlayer();
		}
		sc.close();
	}
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
		game.play();
	}
}