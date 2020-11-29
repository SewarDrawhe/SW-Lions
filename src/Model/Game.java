package Model;
import  java.util.Scanner;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Model.Player;
import utils.E_Difficulty;
import utils.Soldier_COLOR;

public class Game {
	
	public static final char BLACK='1';	//represents a black piece
	public static final char WHITE='2';	//represents a white piece
	public static final char QUEEN='3';	//represents a queen piece
	public static final char EMPTY='0';	//board position is empty
	public static final char LEFT='l';	//a left move
	public static final char RIGHT='r';	//a right move

	
	private Square[][] Board=new Square[8][8];
	private Date GameDate;
	private Player whitePlayer;
	private Player blackPlayer;
	private Time QueueTime;
	private Soldier[] WhitePieces=new Soldier[12];
	private Soldier[] BlackPieces=new Soldier[12];
	private Square[] BlackSquares=new Square[32];

//---------------------------Constructor----------------------
	
	
	public Game(Square[][] board,Player white,Player black, Date gamedate, Time queueTime, Soldier[] soldier1, Soldier[] soldier2, Square[] blackSquares) {
		super();
		Board = board;
		GameDate = gamedate;
		QueueTime = queueTime;
		WhitePieces = soldier1;
		BlackPieces = soldier2;
		BlackSquares = blackSquares;
		whitePlayer=white;
		blackPlayer=black;
	}
	//---------------Getters and Setters--------------------------
	
	public Square[][] getBoard() {
		return Board;
	}
	public void setBoard(Square[][] board) {
		Board = board;
	}
	
	
	public Date getGameTime() {
		return GameDate;
	}
	public void setGameTime(Time gameTime) {
		GameDate = gameTime;
	}
	
	public Game(Date gameDate, Player whitePlayer, Player blackPlayer) {
		super();
		GameDate = gameDate;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
	}
	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(Player whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public void setBlackPlayer(Player blackPlayer) {
		this.blackPlayer = blackPlayer;
	}

	public Soldier[] getWhitePieces() {
		return WhitePieces;
	}

	public void setWhitePieces(Soldier[] whitePieces) {
		WhitePieces = whitePieces;
	}

	public Soldier[] getBlackPieces() {
		return BlackPieces;
	}

	public void setBlackPieces(Soldier[] blackPieces) {
		BlackPieces = blackPieces;
	}

	public Time getQueueTime() {
		return QueueTime;
	}
	public void setQueueTime(Time queueTime) {
		QueueTime = queueTime;
	}
	public Soldier[] getSoldier1() {
		return WhitePieces;
	}
	
	public void setSoldier1(Soldier[] soldier1) {
		WhitePieces = soldier1;
	}
	public Soldier[] getSoldier2() {
		return BlackPieces;
	}
	public void setSoldier2(Soldier[] soldier2) {
		BlackPieces = soldier2;
	}
	public Square[] getBlackSquares() {
		return BlackSquares;
	}
	public void setBlackSquares(Square[] blackSquares) {
		BlackSquares = blackSquares;
	}
	
//---------------------Methods------------------------------
	
	public void initiateGame()
	{
		//To do
				for(int i=0;i<WhitePieces.length;i++)
				{
					WhitePieces[i].setIsAlive(true);			
					
				}
				
				for(int i=0;i<BlackPieces.length;i++)
				{
					BlackPieces[i].setIsAlive(true);			
					
				}

		        whitePlayer.setPoints(0);
		        blackPlayer.setPoints(0);
		        
		     
		        for (int x=0; x<8; x++)
		         
		        	for (int z=0; z<8; z++)
		          
		            Board[x][z].setNumber(EMPTY);
		          
		        	

			  	Board[0][0].setNumber(WHITE);Board[2][0].setNumber(WHITE);Board[4][0].setNumber(WHITE);Board[6][0].setNumber(WHITE);
			  	Board[1][1].setNumber(WHITE);Board[3][1].setNumber(WHITE);Board[5][1].setNumber(WHITE);Board[7][1].setNumber(WHITE);
			  	Board[0][2].setNumber(WHITE);Board[2][2].setNumber(WHITE);Board[4][2].setNumber(WHITE);Board[6][2].setNumber(WHITE);

			  	Board[1][7].setNumber(BLACK);Board[3][7].setNumber(BLACK);Board[5][7].setNumber(BLACK);Board[7][7].setNumber(BLACK);
			  	Board[0][6].setNumber(BLACK);Board[2][6].setNumber(BLACK);Board[4][6].setNumber(BLACK);Board[6][6].setNumber(BLACK);
			  	Board[1][5].setNumber(BLACK);Board[3][5].setNumber(BLACK);Board[5][5].setNumber(BLACK);Board[7][5].setNumber(BLACK);

	}
	
	public void AddPlayer(String wp,String bp)
	{
		 this.whitePlayer = new Player(wp,0);
		 this. blackPlayer = new Player(bp,0);


	}
	
	public void StartGame()
	{
		//To do
	}
	
	public void FinishGame()
	{
		//To do
	}
	
	public void PauseGame()
	{
		//To do
	}
	
	public void resumeGame()
	{
		//To do
	}
	
	public boolean returnSoldier(Soldier s)
	{
		int x;//row number
		int y;//col number
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your row number that you want to return the soldier in: "); 
		x = sc.nextInt();
		System.out.println("Enter your col number that you want to return the soldier in: "); 
		y = sc.nextInt();
		
		if(s.getColor()==Soldier_COLOR.WHITE) {
			if(x==0)
				return false;
			else if(x==1 && y==0) {
				if(Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK || Board[x][y+2].getColor()==Soldier_COLOR.BLACK || Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK || Board[x+2][y+2].getColor()==Soldier_COLOR.BLACK || Board[x+2][y].getColor()==Soldier_COLOR.BLACK )
					return false;
				
			}
			else if(x==3 && y==0) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.BLACK || Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK||Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK||Board[x+2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x+2][y].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==7 && y==0) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.BLACK || Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			
			else if(x==3 && y==0) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.BLACK || Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK||Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK||Board[x+2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x+2][y].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==7 && y==4) {
				if(Board[x][y-2].getColor()==Soldier_COLOR.BLACK || Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y-2].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y].getColor()==Soldier_COLOR.BLACK||Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK||Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==7 && y==6) {
				if(Board[x][y-2].getColor()==Soldier_COLOR.BLACK || Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y-2].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y].getColor()==Soldier_COLOR.BLACK||Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==6 && y==7) {
				if(Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK || Board[x][y-2].getColor()==Soldier_COLOR.BLACK|| Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y-2].getColor()==Soldier_COLOR.BLACK||Board[x-2][y].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==4 && y==7) {
				if(Board[x+2][y].getColor()==Soldier_COLOR.BLACK || Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK|| Board[x+2][y-2].getColor()==Soldier_COLOR.BLACK|| Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x-2][y-2].getColor()==Soldier_COLOR.BLACK||Board[x-2][y].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==6 && y==5) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.BLACK || Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK||Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK||Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x][y-2].getColor()==Soldier_COLOR.BLACK||Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x-2][y-2].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==6 && y==1) {//10 
				if(Board[x-2][y].getColor()==Soldier_COLOR.BLACK || Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK||Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK||Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			else if(x==1 && y==6) {//11 
				if(Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK || Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x+2][y].getColor()==Soldier_COLOR.BLACK|| Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x+2][y-2].getColor()==Soldier_COLOR.BLACK||Board[x][y-2].getColor()==Soldier_COLOR.BLACK||Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			
			else if(x==1 && y==2) {//12 
				if(Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK || Board[x][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x+2][y+2].getColor()==Soldier_COLOR.BLACK||Board[x+2][y].getColor()==Soldier_COLOR.BLACK||Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x+2][y-2].getColor()==Soldier_COLOR.BLACK||Board[x][y-2].getColor()==Soldier_COLOR.BLACK||Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			
			else{
				if(Board[x-2][y].getColor()==Soldier_COLOR.BLACK || Board[x-1][y+1].getColor()==Soldier_COLOR.BLACK|| Board[x-2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x][y+2].getColor()==Soldier_COLOR.BLACK||Board[x+1][y+1].getColor()==Soldier_COLOR.BLACK||Board[x+2][y+2].getColor()==Soldier_COLOR.BLACK|| Board[x+2][y].getColor()==Soldier_COLOR.BLACK||Board[x+1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x+2][y-2].getColor()==Soldier_COLOR.BLACK||Board[x][y-2].getColor()==Soldier_COLOR.BLACK||Board[x-1][y-1].getColor()==Soldier_COLOR.BLACK||Board[x-2][y-2].getColor()==Soldier_COLOR.BLACK)
					return false;
			}
			Board[x][y].setColor(Soldier_COLOR.WHITE);
			return true;
		}
		
		if(s.getColor()==Soldier_COLOR.BLACK) {
			if(x==7)
				return false;
			else if(x==1 && y==0) {
				if(Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE || Board[x][y+2].getColor()==Soldier_COLOR.WHITE || Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE || Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE || Board[x+2][y].getColor()==Soldier_COLOR.WHITE )
					return false;
				
			}
			else if(x==3 && y==0) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.WHITE || Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x-2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x][y+2].getColor()==Soldier_COLOR.WHITE||Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			
			else if(x==3 && y==0) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.WHITE || Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x-2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x][y+2].getColor()==Soldier_COLOR.WHITE||Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y].getColor()==Soldier_COLOR.WHITE)
					return false;
			}

			else if(x==6 && y==7) {
				if(Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE || Board[x][y-2].getColor()==Soldier_COLOR.WHITE|| Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE|| Board[x-2][y-2].getColor()==Soldier_COLOR.WHITE||Board[x-2][y].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==4 && y==7) {
				if(Board[x+2][y].getColor()==Soldier_COLOR.WHITE || Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y-2].getColor()==Soldier_COLOR.WHITE|| Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x-2][y-2].getColor()==Soldier_COLOR.WHITE||Board[x-2][y].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==6 && y==5) {
				if(Board[x-2][y].getColor()==Soldier_COLOR.WHITE || Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x-2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x][y+2].getColor()==Soldier_COLOR.WHITE||Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE||Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x][y-2].getColor()==Soldier_COLOR.WHITE||Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x-2][y-2].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==6 && y==1) {//10 
				if(Board[x-2][y].getColor()==Soldier_COLOR.WHITE || Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x-2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x][y+2].getColor()==Soldier_COLOR.WHITE||Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE||Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==1 && y==6) {//11 
				if(Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE || Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y].getColor()==Soldier_COLOR.WHITE|| Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y-2].getColor()==Soldier_COLOR.WHITE||Board[x][y-2].getColor()==Soldier_COLOR.WHITE||Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			
			else if(x==1 && y==2) {//12 
				if(Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE || Board[x][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE||Board[x+2][y].getColor()==Soldier_COLOR.WHITE||Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y-2].getColor()==Soldier_COLOR.WHITE||Board[x][y-2].getColor()==Soldier_COLOR.WHITE||Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==0 && y==1) {//* 
				if(Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE || Board[x+2][y].getColor()==Soldier_COLOR.WHITE|| Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE||Board[x][y+2].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==0 && y==3) {//** 
				if(Board[x][y-2].getColor()==Soldier_COLOR.WHITE || Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y-2].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y].getColor()==Soldier_COLOR.WHITE||Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE ||Board[x][y+2].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else if(x==0 && y==7) {//* 
				if(Board[x][y-2].getColor()==Soldier_COLOR.WHITE || Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y-2].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			else{
				if(Board[x-2][y].getColor()==Soldier_COLOR.WHITE || Board[x-1][y+1].getColor()==Soldier_COLOR.WHITE|| Board[x-2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x][y+2].getColor()==Soldier_COLOR.WHITE||Board[x+1][y+1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y+2].getColor()==Soldier_COLOR.WHITE|| Board[x+2][y].getColor()==Soldier_COLOR.WHITE||Board[x+1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x+2][y-2].getColor()==Soldier_COLOR.WHITE||Board[x][y-2].getColor()==Soldier_COLOR.WHITE||Board[x-1][y-1].getColor()==Soldier_COLOR.WHITE||Board[x-2][y-2].getColor()==Soldier_COLOR.WHITE)
					return false;
			}
			
			Board[x][y].setColor(Soldier_COLOR.BLACK);
			return true;
			
		}
		
		return false;
		
	}
	
	public void removeSoldier(Soldier[] s, int index)
	{
		if(s==null)
			return;
		s[index]=null;
		return;
	}
	
	public void soldierTurnToQueen(Soldier s)
	{
		s.setIsQueen(true);
	}
	
	
	public boolean IsEatable(Player p)
	{
		if(p.getColor()==Soldier_COLOR.WHITE) {
			
			for(int i=0;i<WhitePieces.length; i++) {
				int x=WhitePieces[i].getLocation().getX();
				int y=WhitePieces[i].getLocation().getY();
				if(WhitePieces[i].isIsQueen()==false)
				{
					
					if(y==0||y==1) {
						if((Board[x-1][y+1].getColor())==(Soldier_COLOR.BLACK) && Board[x-2][y+2].getColor()==null) {
							
							return true;
						}
							
					}
					if(y==6||y==7) {
						if((Board[x-1][y-1].getColor())==(Soldier_COLOR.BLACK) && Board[x-2][y-2].getColor()==null) {
							
							return true;
						}
							
					}
					else {
						if(((Board[x-1][y+1].getColor())==(Soldier_COLOR.BLACK) && Board[x-2][y+2].getColor()==null)|| ((Board[x-1][y-1].getColor())==(Soldier_COLOR.BLACK) && Board[x-2][y-2].getColor()==null)) {
							return true;
						}
					}
				}
				else if(WhitePieces[i].isIsQueen()==true) {
					//case the queen is moving up right
					while(Board[x-1][y+1].getColor()==null) {
						x--;
						y++;
						// case the queen arrived the edge of the board
						if(y==7 && x==0) {
							y=0;
							x=7;
						}
						else if(y==7 && x!=0) {
							y=0;
							x--;
						}
						else if(x==0) {
							x=7;
							y++;
						}
					}
					if(Board[x][y].getColor()==Soldier_COLOR.BLACK && Board[x-1][y+1].getColor()==null)
						return true;
					//case the queen is moving up left
					while(Board[x-1][y-1].getColor()==null) {
						x--;
						y--;
						// case the queen arrived the edge of the board
						if(y==0) {
							y=7;
							x--;
						}else if(x==0) {
							y--;
							x=7;
						}
			
					}
					if(Board[x][y].getColor()==Soldier_COLOR.BLACK && Board[x-1][y-1].getColor()==null)
						return true;
					//case the queen is moving right down
					while(Board[x+1][y+1].getColor()==null) {
						x++;
						y++;
						
						// case the queen arrived the edge of the board
						if(x==7) {
							y++;
							x=0;
						}else if(y==7) {
							y=0;
							x++;
						}
					}
					if(Board[x][y].getColor()==Soldier_COLOR.BLACK && Board[x+1][y+1].getColor()==null)
						return true;
					//case the queen is moving left down
					while(Board[x+1][y-1].getColor()==null) {
						x++;
						y--;
						
						// case the queen arrived the edge of the board
						if(x==7 && y==0) {
							y=7;
							x=0;
						}else if(x==7 && y!=0) {
							y--;
							x=0;
						}else if(y==0) {
							y=7;
							x++;
						}
					}
					if(Board[x][y].getColor()==Soldier_COLOR.BLACK && Board[x+1][y-1].getColor()==null)
						return true;
				}
				
			}
			
		}
		if(p.getColor()==Soldier_COLOR.BLACK) {
			
			for(int i=0;i<BlackPieces.length; i++) {
				int x=BlackPieces[i].getLocation().getX();
				int y=BlackPieces[i].getLocation().getY();
				if(BlackPieces[i].isIsQueen()==false)
				{
					
					if(y==0||y==1) {
						if((Board[x+1][y+1].getColor())==(Soldier_COLOR.WHITE) && Board[x+2][y+2].getColor()==null) {
							
							return true;
						}
							
					}
					if(y==6||y==7) {
						if((Board[x+1][y-1].getColor())==(Soldier_COLOR.WHITE) && Board[x+2][y-2].getColor()==null) {
							
							return true;
						}
							
					}
					else {
						if(((Board[x+1][y-1].getColor())==(Soldier_COLOR.WHITE) && Board[x+2][y-2].getColor()==null)|| ((Board[x+1][y+1].getColor())==(Soldier_COLOR.WHITE) && Board[x+2][y+2].getColor()==null)) {
							return true;
						}
					}
				}
				
				else if(BlackPieces[i].isIsQueen()==true) {
					//case the queen is moving up right
					while(Board[x-1][y+1].getColor()==null) {
						x--;
						y++;
						// case the queen arrived the edge of the board
						if(y==7 && x==0) {
							y=0;
							x=7;
						}
						else if(y==7 && x!=0) {
							y=0;
							x--;
						}
						else if(x==0) {
							x=7;
							y++;
						}
					}
					if(Board[x][y].getColor()==Soldier_COLOR.WHITE && Board[x-1][y+1].getColor()==null)
						return true;
					//case the queen is moving up left
					while(Board[x-1][y-1].getColor()==null) {
						x--;
						y--;
						// case the queen arrived the edge of the board
						if(y==0) {
							y=7;
							x--;
						}else if(x==0) {
							y--;
							x=7;
						}
			
					}
					if(Board[x][y].getColor()==Soldier_COLOR.WHITE && Board[x-1][y-1].getColor()==null)
						return true;
					//case the queen is moving right down
					while(Board[x+1][y+1].getColor()==null) {
						x++;
						y++;
						
						// case the queen arrived the edge of the board
						if(x==7) {
							y++;
							x=0;
						}else if(y==7) {
							y=0;
							x++;
						}
					}
					if(Board[x][y].getColor()==Soldier_COLOR.WHITE && Board[x+1][y+1].getColor()==null)
						return true;
					//case the queen is moving left down
					while(Board[x+1][y-1].getColor()==null) {
						x++;
						y--;
						
						// case the queen arrived the edge of the board
						if(x==7 && y==0) {
							y=7;
							x=0;
						}else if(x==7 && y!=0) {
							y--;
							x=0;
						}else if(y==0) {
							y=7;
							x++;
						}
					}
					if(Board[x][y].getColor()==Soldier_COLOR.WHITE && Board[x+1][y-1].getColor()==null)
						return true;
					
				}
				
			}
			
		}
		return false;
	}
	
	// this function return true if all the reval solider is blocked
	// Player p is the rival player
	// Queen not chekied
		public boolean IsBlocked(Player p)
		{
			int countBlockedSoldier=0;
			int countSolidersinGame=0;
			int x=0;
			int y=0;
			
			if(p.equals(blackPlayer)) {
				for(int i=0;i<BlackPieces.length;i++) {
					if(BlackPieces[i]!=null)
						countSolidersinGame++;
						}
			
					for(int i=0;i<BlackPieces.length;i++) {
						if(BlackPieces[i]!=null)
						{
						x=BlackPieces[i].getLocation().getX();
						y=BlackPieces[i].getLocation().getY();
						
						if(x==0 && y==7) {
							if(Board[x+1][y-1].getColor()!=null)
								countBlockedSoldier++;
							}
						else if(x==7 && y==0) {
							if(Board[x-1][y+1].getColor()!=null)
								countBlockedSoldier++;
							}
						else if(y==0) {
							//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
							if(Board[x-1][y+1].getColor()!=null && Board[x+1][y+1].getColor()!=null)
								countBlockedSoldier++;
							}
						else if(y==7) {
							//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
							if(Board[x-1][y-1].getColor()!=null && Board[x+1][y-1].getColor()!=null)
								countBlockedSoldier++;
							}
						else {
							if(Board[x-1][y-1].getColor()!=null && Board[x+1][y-1].getColor()!=null 
							&& Board[x-1][y+1].getColor()!=null &&Board[x+1][y+1].getColor()!=null)
								countBlockedSoldier++;
							}
						
					}
				}
				
			}
			if(p.equals(whitePlayer)) {
				for(int i=0;i<WhitePieces.length;i++) {
					if(WhitePieces[i]!=null)
						countSolidersinGame++;
						}
			
					for(int i=0;i<WhitePieces.length;i++) {
						if(WhitePieces[i]!=null)
						{
						x=WhitePieces[i].getLocation().getX();
						y=WhitePieces[i].getLocation().getY();
						
						if(x==0 && y==7) {
							if(Board[x+1][y-1].getColor()!=null)
								countBlockedSoldier++;
							}
						else if(x==7 && y==0) {
							if(Board[x-1][y+1].getColor()!=null)
								countBlockedSoldier++;
							}
						else if(y==0) {
							//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
							if(Board[x-1][y+1].getColor()!=null && Board[x+1][y+1].getColor()!=null)
								countBlockedSoldier++;
							}
						else if(y==7) {
							//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
							if(Board[x-1][y-1].getColor()!=null && Board[x+1][y-1].getColor()!=null)
								countBlockedSoldier++;
							}
						else {
							if(Board[x-1][y-1].getColor()!=null && Board[x+1][y-1].getColor()!=null 
							&& Board[x-1][y+1].getColor()!=null &&Board[x+1][y+1].getColor()!=null)
								countBlockedSoldier++;
							}
						
					}
				}
				
			}
	    if(countBlockedSoldier==countSolidersinGame)
	    	return true;
	    return false;
		}
			
	@Override
	public String toString() {
		return "Game [GameDate=" + GameDate + ", whitePlayer=" + whitePlayer + ", blackPlayer=" + blackPlayer + "]";
	}
	

}