package view;

import java.net.URL;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import Model.Game;
import Model.Player;
import Model.Soldier;
import Model.Square;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;

public class BoardGameController implements Initializable{
	private Square[][] board;
	private int numofYellowSquares=0;
    public Game g;
    private Rectangle r=null;
    //soldier that has choosen to be moved
    private Circle soldier=null;
    // target square the soldier want to turn to
    private Rectangle target=null;
    //this Pane is the CurrentRowPane: help us at the CheckAndDoYellow methods
    private Pane rowPane=null;

	@FXML
    private Text BlackPlayerNic= new Text();

    @FXML
    private Text WhitePlayerNick =new Text();
    
    @FXML
    private Label BlackPoints= new Label();

    @FXML
    private Label WhitePoints= new Label();

    @FXML
    private TextField BlackNickText = new TextField();

    @FXML
    private TextField WhiteNickText = new TextField();

    @FXML
    private TextField bPointsValue = new TextField();

    @FXML
    private TextField wPointsValue= new TextField();

    @FXML
    private AnchorPane Pane = new AnchorPane();

    @FXML
    private Button exitbutton = new Button();

    @FXML
    private Button Homepagebutton= new Button();

    // the circle soldiers
    @FXML
    private Circle b0 = new Circle();

    @FXML
    private Circle b1= new Circle();

    @FXML
    private Circle b3= new Circle();

    @FXML
    private Circle b2= new Circle();

    @FXML
    private Circle b4= new Circle();

    @FXML
    private Circle b5= new Circle();

    @FXML
    private Circle b6= new Circle();

    @FXML
    private Circle b7= new Circle();

    @FXML
    private Circle b8= new Circle();

    @FXML
    private Circle b9= new Circle();

    @FXML
    private Circle b10= new Circle();

    @FXML
    private Circle b11= new Circle();

    @FXML
    private Circle w8= new Circle();

    @FXML
    private Circle w9= new Circle();

    @FXML
    private Circle w11= new Circle();

    @FXML
    private Circle w10= new Circle();

    @FXML
    private Circle w4= new Circle();

    @FXML
    private Circle w5= new Circle();

    @FXML
    private Circle w6= new Circle();

    @FXML
    private Circle w7= new Circle();

    @FXML
    private Circle w0= new Circle();

    @FXML
    private Circle w3= new Circle();

    @FXML
    private Circle w2= new Circle();

    @FXML
    private Circle w1= new Circle();
    
    @FXML
    private Rectangle s0 = new Rectangle();
   
    @FXML
    private Rectangle s1= new Rectangle();

    @FXML
    private Rectangle s2= new Rectangle();

    @FXML
    private Rectangle s3= new Rectangle();

    @FXML
    private Rectangle s4= new Rectangle();

    @FXML
    private Rectangle s5= new Rectangle();

    @FXML
    private Rectangle s6= new Rectangle();

    @FXML
    private Rectangle s7= new Rectangle();
    
    @FXML
    private Rectangle s8= new Rectangle();

    @FXML
    private Rectangle s9= new Rectangle();

    @FXML
    private Rectangle s10= new Rectangle();

    @FXML
    private Rectangle s11= new Rectangle();

    @FXML
    private Rectangle s12= new Rectangle();

    @FXML
    private Rectangle s13= new Rectangle();

    @FXML
    private Rectangle s14= new Rectangle();

    @FXML
    private Rectangle s15= new Rectangle();

    @FXML
    private Rectangle s16= new Rectangle();

    @FXML
    private Rectangle s17= new Rectangle();

    @FXML
    private Rectangle s18= new Rectangle();

    @FXML
    private Rectangle s19= new Rectangle();

    @FXML
    private Rectangle s20= new Rectangle();

    @FXML
    private Rectangle s21= new Rectangle();

    @FXML
    private Rectangle s22= new Rectangle();

    @FXML
    private Rectangle s23= new Rectangle();
    
    @FXML
    private Rectangle s24= new Rectangle();

    @FXML
    private Rectangle s25= new Rectangle();

    @FXML
    private Rectangle s26= new Rectangle();

    @FXML
    private Rectangle s27= new Rectangle();
    @FXML
    private Rectangle s28= new Rectangle();

    @FXML
    private Rectangle s29= new Rectangle();

    @FXML
    private Rectangle s30= new Rectangle();

    @FXML
    private Rectangle s31= new Rectangle();

    @FXML
    private Pane boardPane = new Pane();
   
    @FXML
    void MoveToSquare(MouseEvent event) {
    	
    	this.target=(Rectangle) event.getTarget();
    	MoveSoldierToTarget();
    }
    
    @FXML
    void MoveSoldier(MouseEvent event) {
    	this.soldier=(Circle) event.getTarget();

    }



	@FXML
    void exit(ActionEvent event) {
    	((Stage) Pane.getScene().getWindow()).close();
    }

    @FXML
    void openHomepage(ActionEvent event) {
    	Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		MainBoardController temp=new MainBoardController();
		try {
		temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}


    }
    //this function trasfer the layout cordenate to 0<c<7
    private int TransForCordinateNum(int c) {
    	int num=0;
		while(c>=30) {
			c=c-60;
			num++;
		}
		return num;
	}
   
    
    private int MoveSoldierToTarget() {
    	if(soldier!=null && target!=null) {
    		int sourcex=TransForCordinateNum((int)this.soldier.getLayoutY()-30);
    	System.out.printf("the row is: %d\n",sourcex);

    	
    	int sourcey=TransForCordinateNum((int)this.soldier.getLayoutX()-30);
    	System.out.printf("the col is: %d\n",sourcey);
    	
    	
    	//turns the square target cordenaties to: 0<x<7 & 0<y<7
    	//System.out.println(target.getLayoutX());
    	int targetx=TransForCordinateNum((int)target.getLayoutY());
		System.out.printf("move to row:%d\n",targetx);
		
    	int targety=TransForCordinateNum((int) target.getLayoutX());
		System.out.printf("move to col num:%d\n",targety);
		
		

    	//double oldRow = target.getLayoutY();
    	//System.out.println(oldRow);
    	
		//moving the black soldier to target square
		if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.BLACK) {
			for(int i=0; i<g.getBlackPieces().length; i++) {
				if(g.getBlackPieces()[i].getLocation().getX()== sourcex && g.getBlackPieces()[i].getLocation().getY()== sourcey
						&&!g.getBlackPieces()[i].isIsQueen()) {
				int isOk =(g.getBlackPieces()[i]).moveBlack( sourcex, sourcey, targetx,targety,board);
				if(isOk==0) {
				
					System.out.println("is ok");
					if(sourcex+1==targetx && targety==sourcey-1)
					{
						
						double soldiersourcex=this.soldier.getLayoutX();
						double soldiersourcey=this.soldier.getLayoutY();
						this.soldier.setLayoutX(soldiersourcex-60);
						this.soldier.setLayoutY(soldiersourcey+60);
						board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
					
					}
					
					if(sourcex==targetx-1 && sourcey==targety-1)
					{
						double soldiersourcex=this.soldier.getLayoutX();
						double soldiersourcey=this.soldier.getLayoutY();
						this.soldier.setLayoutX(soldiersourcex+60);
						this.soldier.setLayoutY(soldiersourcey+60);
						board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
					
					}
					
					if(targetx==7)
					{
						this.soldier.setFill(Color.BROWN);
						for(int j=0;j<g.getBlackPieces().length;j++)
						{
							if(g.getBlackPieces()[i].getLocation().getX()== targetx && g.getBlackPieces()[i].getLocation().getY()== targety)
							{
								g.getBlackPieces()[i].setIsQueen(true);
							}
						}
					}
					
										
				}
				else
					System.out.println("not ok");
				}
			}
			
		}
		//moving the black soldier to target square
		if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.WHITE ) {
			for(int i=0; i<g.getWhitePieces().length; i++) {
				if(g.getWhitePieces()[i].getLocation().getX()== sourcex && g.getWhitePieces()[i].getLocation().getY()== sourcey
						&&!g.getWhitePieces()[i].isIsQueen()) {
				int isOk =(g.getWhitePieces()[i]).moveWhite( sourcex, sourcey, targetx,targety,board);
				if(isOk==0) {
				
					System.out.println("is ok");
					if(sourcex==targetx+1 && targety-1==sourcey)
					{
						
						double soldiersourcex=this.soldier.getLayoutX();
						double soldiersourcey=this.soldier.getLayoutY();
						this.soldier.setLayoutX(soldiersourcex+60);
						this.soldier.setLayoutY(soldiersourcey-60);
						board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);					
					}
					
					if(sourcex==targetx+1 && sourcey==targety+1)
					{
						double soldiersourcex=this.soldier.getLayoutX();
						double soldiersourcey=this.soldier.getLayoutY();
						this.soldier.setLayoutX(soldiersourcex-60);
						this.soldier.setLayoutY(soldiersourcey-60);
						board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);

					
					}
					if(targetx==0)
					{
						this.soldier.setFill(Color.BLUE);
						for(int j=0;j<g.getWhitePieces().length;j++)
						{
							if(g.getWhitePieces()[i].getLocation().getX()== targetx && g.getWhitePieces()[i].getLocation().getY()== targety)
							{
								g.getWhitePieces()[i].setIsQueen(true);
							}
						}
					}
					
					

					
										
				}
				else
					System.out.println("not ok");
				}
			}
			
		}
		
		this.soldier=null;
		this.target=null;
		return 0;
    	}
    	
    	return -1;
   
    	
    }

    public void eat() {
    	//TODO

	}

    
    
public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/BoardGame.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Game Board");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (!NicknamesSetUpController.getWhitename().isEmpty() && !NicknamesSetUpController.getBlackname().isEmpty()) {
			// setting the current player in the board game
			
			Player white = new Player(NicknamesSetUpController.getWhitename() , 0);
			Player black = new Player(NicknamesSetUpController.getBlackname() , 0);
			WhiteNickText.setEditable(false);
			BlackNickText.setEditable(false);

			WhiteNickText.setText(NicknamesSetUpController.getWhitename());
			BlackNickText.setText(NicknamesSetUpController.getBlackname());

			
			
			wPointsValue.setText(Integer.toString(white.getPoints()));
			bPointsValue.setText(Integer.toString(black.getPoints()));
			Date d = new Date();
			Time t = new Time(0, 0, 0);
			
			g = new Game(white, black,d,t);
			g.initiateGame();
			this.board=g.getBoard();
			System.out.println(board[0][1]);
//			for(int r=0; r<8;r++) {
//				for(int c=0; c<8;c++) {
//					//the board is null!!!
//					System.out.println(board[r][c].toString());
//
//				}
//			}
		while(numofYellowSquares<3) {
		CheckAndDoYellowSquares();
		}
			

		}
		
	}
	public void CheckAndDoYellowSquares() {
		Random rand = new Random();
		int x = rand.nextInt(8); 
        int y = rand.nextInt(8);
        if(board[x][y]!=null) 
        {
        	System.out.println(board[x][y].getSoldierColor());
        if(board[x][y].getSquareColor()!=null) {
        	System.out.println(board[x][y].getSquareColor());
        if(board[x][y].getSquareColor()==SQUARE_COLOR.BLACK && board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
        	System.out.println(board[x][y].getSoldierColor());
        	board[x][y].setSquareColor(SQUARE_COLOR.YELLOW);
        	setRectangleToYellow(x,y);
        	
    	    numofYellowSquares++;
    	    System.out.println(numofYellowSquares);
        }
        }
	}
        
	
}


// this function take the square cordetaties: 0<=x<8 & 0<=x<8
//this function returns a rectangle r in the scenebuilder that appropriate to the cordetaties x and y 
public Rectangle getRectangle(int x, int y) {
        int xviewscene=x*60;//cheks the func	
        int yviewscene=	y*60;//cheks the func
        
		if(xviewscene==60 && yviewscene==0) {
			return s0;
		}
		if(xviewscene==180 && yviewscene==0) {
			return s1;
		}
		if(xviewscene==300 && yviewscene==0) {
			return s2;
		}
		if(xviewscene==420 && yviewscene==0) {
			return s3;
		}
		if(xviewscene==0 && yviewscene==60) {
			return s4;
		}
		if(xviewscene==120 && yviewscene==60) {
			return s5;
		}
		if(xviewscene==240 && yviewscene==60) {
			return s6;
		}
		if(xviewscene==360 && yviewscene==60) {
			return s7;
		}
		if(xviewscene==60 && yviewscene==120) {
			return s8;
		}
		if(xviewscene==180 && yviewscene==120) {
			return s9;
		}
		if(xviewscene==300 && yviewscene==120) {
			return s10;
		}
		if(xviewscene==420 && yviewscene==120) {
			return s11;
		}
		if(xviewscene==0 && yviewscene==180) {
			return s12;
		}
		if(xviewscene==120 && yviewscene==180) {
			return s13;
		}
		if(xviewscene==240 && yviewscene==180) {
			return s14;
		}
		if(xviewscene==360 && yviewscene==180) {
			return s15;
		}
		if(xviewscene==60 && yviewscene==240) {
			return s16;
		}
		if(xviewscene==180 && yviewscene==240) {
			return s17;
		}
		if(xviewscene==300 && yviewscene==240) {
			return s18;
		}
		if(xviewscene==420 && yviewscene==240) {
			return s19;
		}
		if(xviewscene==0 && yviewscene==300) {
			return s20;
		}
		if(xviewscene==120 && yviewscene==300) {
			return s21;
		}
		if(xviewscene==240 && yviewscene==300) {
			return s22;
		}
		if(xviewscene==360 && yviewscene==300) {
			return s23;
		}
		if(xviewscene==60 && yviewscene==360) {
			return s24;
		}
		if(xviewscene==180 && yviewscene==360) {
			return s25;
		}
		if(xviewscene==300 && yviewscene==360) {
			return s26;
		}
		if(xviewscene==420 && yviewscene==360) {
			return s27;
		}
		if(xviewscene==0 && yviewscene==420) {
			return s28;
		}
		if(xviewscene==120 && yviewscene==420) {
			return s29;
		}
		if(xviewscene==240 && yviewscene==420) {
			return s30;
		}
		if(xviewscene==360 && yviewscene==420) {
			return s31;
		}

        
        return null;
	
}
	
	

public void setRectangleToYellow(int x, int y) {
    int xviewscene=x*60;//cheks the func	
    int yviewscene=	y*60;//cheks the func
    
	if(xviewscene==60 && yviewscene==0) {
		s0.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==180 && yviewscene==0) {
		s1.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==300 && yviewscene==0) {
		s2.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==420 && yviewscene==0) {
		s3.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==0 && yviewscene==60) {
		s4.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==120 && yviewscene==60) {
		s5.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==240 && yviewscene==60) {
		s6.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==360 && yviewscene==60) {
		s7.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==60 && yviewscene==120) {
		s8.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==180 && yviewscene==120) {
		s9.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==300 && yviewscene==120) {
		s10.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==420 && yviewscene==120) {
		s11.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==0 && yviewscene==180) {
		s12.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==120 && yviewscene==180) {
		s13.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==240 && yviewscene==180) {
		s14.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==360 && yviewscene==180) {
		s15.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==60 && yviewscene==240) {
		s16.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==180 && yviewscene==240) {
		s17.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==300 && yviewscene==240) {
		s18.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==420 && yviewscene==240) {
		s19.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==0 && yviewscene==300) {
		s20.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==120 && yviewscene==300) {
		s21.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==240 && yviewscene==300) {
		s22.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==360 && yviewscene==300) {
		s23.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==60 && yviewscene==360) {
		s24.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==180 && yviewscene==360) {
		s25.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==300 && yviewscene==360) {
		s26.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==420 && yviewscene==360) {
		s27.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==0 && yviewscene==420) {
		s28.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==120 && yviewscene==420) {
		s29.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==240 && yviewscene==420) {
		s30.setFill(Color.rgb(255,255,0));
		return;
	}
	if(xviewscene==360 && yviewscene==420) {
		s31.setFill(Color.rgb(255,255,0));
		return;
	}

    
    return;

}



			

	

}