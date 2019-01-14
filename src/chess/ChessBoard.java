package chess;

/* 
 * ClassName		 :
 * ChessBoard 
 * 
 * Description 	     :
 * 高師軟工碩一課程專家系統期中作業 - 八皇后遊戲
 * 功能:開新遊戲、悔棋、擺完八個皇后可以確認答案
 *     計算N皇后問題的可行解數(N = 4 ~10)
 *     可以展示出每一種八皇后問題的解
 * 
 * Author		     :
 * 許博淳
 * 
 * History	         :	    
 * Date		 2016/11/16
 * Version   1.0
 * 
 * Copyright notice  :
 * 非經原作者授權許可，禁止轉載抄襲。
 * 
 * 未來的更動:重構改善架構
 *          老師的建議:1.Chessboard類別應該要取消  考慮在負責處理gui的地方用一個副程式去呼叫繪(N路棋盤)圖的方式	
 * 					  2.把綁定在Left/Right/MidJPanel甚至是Chessboard裡的屬性給扁平化
 *                      也就是移到JFrame類別下進行宣告，這樣這些變數就變成全域可見
 *          改善串接字串的效能
 *          GameInterface類別內的功能太多要把他們分出來
 *          其他參照註解進行更動
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

/**
 * 負責繪製和建立棋盤，儲存和操作放過的皇后位置，還有悔棋的功能。
 * 
 * @note 八皇后遊戲
 * @author 	許博淳
 * @version 1.0
 * 
 */

public class ChessBoard extends JPanel{	
	private static final long serialVersionUID = 1L;
	private int grids ;
	private Dimension chessView;
	private Image queen;              		//棋盤上皇后的icon
	private int chessWidth ;          		//當前棋盤的寬度
	private int chessHeight ;         		//當前棋盤的高度
	private	int chessBoardMinLength;  		//當前棋盤寬度和高度兩個值中最小的那一個
	private	int cell;   					//棋盤格子大小
	private int space; 						//棋盤跟JPanel邊界之間留白大小
	private int x;  						//滑鼠在棋盤上點擊位置的X座標
	private int y;  						//滑鼠在棋盤上點擊位置的Y座標
	private int coordinateX ;     			//棋盤的X座標
	private int coordinateY ; 			 	//棋盤的Y座標
	private int[][] poistionOccupied;     	//判斷棋盤格子上是否有棋子
	static ArrayList<int[]> chessMoves ;  	//暫時儲存棋子下過的步數
	public int shouldnotbecaught1=2;
	public static int shouldnotbecaught2=2;
	
	public static int aetsnbc2 =2;
	public  int aetsnbc1 =2;
	
	public static int vtpsnbc2 =2;
	public  int vtpsnbc1 =2;
	
	
	public int testsnbc1=1;
	public static int testsnbc2=1;
	public static int testData = 1;
    public RightControlPanel abc;
	public int grids1 ;
	public int grids2 ;
	public int grids11 ;
	public int grids12;
	public int grids13 ;
	public int grids14 ;
	public int grids15 ;
	public int grids16 ;
	public int grids17 ;
	public int grids18 ;
	public int grids19 ;
	public int grids100 ;
	public int grids101 ;
	public int grids102 ;
	public int grids103 ;
	public int grids104 ;
	public int grids105 ;
	public int grids20 ;
	public int grids21 ;
	public int grids22 ;
	public int grids23 ;
	public int grids24 ;
	public int grids25 ;
	public int grids26 ;
	public int grids27 ;
	public int grids28 ;
	public int grids29 ;
	public int grids200 ;
	public int grids201 ;
	public int grids202 ;
	public int grids3 ;
	public int grids30 ;
	public int grids31 ;
	public int grids32 ;
	public int grids33 ;
	public int grids34 ;
	public int grids35 ;
	public int grids36 ;
	public int grids37 ;
	public int grids38 ;
	public int grids39 ;
	public int grids003 ;
	public int grids300 ;
	public int grids301 ;
	public int grids302 ;
	public int grids303 ;
	public int grids4 ;
	public int grids40 ;
	public int grids41 ;
	public int grids42 ;
	public int grids43 ;
	public int grids44 ;
	public int grids45 ;
	public int grids46 ;
	public int grids47 ;
	public int grids48 ;
	public int grids49 ;
	public int grids5 ;
	public int grids50 ;
	public int grids51 ;
	public int grids52 ;
	public int grids53 ;
	public int grids54 ;
	public int grids55 ;
	public int grids56 ;
	public int grids57 ;
	public int grids58 ;
	public int grids59 ;
	public int grids500 ;
	
	
	
	
	/**
	 * 初始化棋盤路數(N*N路棋盤)、皇后圖標。
	 */
	public ChessBoard(int grids){
		this.grids = grids;
		this.queen = getToolkit().getImage("queen.jpg");	
		initialize();				
	}
	
	
	public int getaetsnbc1() {
		Prolog prolog = new Prolog();
		return 1;
	}
	
	public static int getaetsnbc2() {
		GameStatusController gameStatusController = new GameStatusController();
		gameStatusController.getClass();
		return 1;
	}
	
	public int getvtpsnbc1() {
		LeftControlPanel leftControlPanel = new LeftControlPanel();
		leftControlPanel.getClass();
		
		
		return 1;
	}
	
	public static int getvtpsnbc2() {
		return 1;
	}
	
	public static int getestsnbc2() {
		return 1;
	}
	
	public int getestsnbc1() {
		return 1;
	}
	
	
	public int getABC(){
		ChessBoard d = new ChessBoard(1);
		GameStatusController gameStatusController = new GameStatusController();
		LeftControlPanel leftControlPanel = new LeftControlPanel();
		RightControlPanel mitsbc1 = new RightControlPanel(d);		
		getestsnbc2();
		grids1 = RightControlPanel.getaetsbc1();
		//b.get1();
		//d.getABC();
		//RightControlPanel.get2();
 /*
		if(2>1){
			
			
			if(0>1){
				ChessBoard d1 = new ChessBoard(1);
				ChessBoard.getestsnbc2();
				RightControlPanel mitsbc2 = new RightControlPanel(d1);
				d1.setSBC();
				int vtpsnbc1 = getvtpsnbc2();
				int vtpsnbc2 = ChessBoard.getvtpsnbc2();
				grids1 = this.getaetsnbc1();
				grids1 = ChessBoard.getData();
				grids1 = getABC();
				RightControlPanel.get2();
				grids1 = mitsbc2.getaetsbc2() ; //+  mitsbc2.getadditionsbc999();
			}else if(2>1) {

				getestsnbc1();
			}else {
				this.getestsnbc1();
			}
		}
		*/
		return 1;
	}
	
	public void testNotnullIdentifier() {
		
	}
	
	public void setSBC() {
		testNotnullIdentifier();
		GameStatusController gameStatusController = new GameStatusController();
		
		LeftControlPanel leftControlPanel = new LeftControlPanel();

		//leftControlPanel.getClass();
		//gameStatusController.getClass();
		ChessBoard c1 = new ChessBoard(1);
		//ChessBoard.getestsnbc2();
		int a = ChessBoard.shouldnotbecaught2;
		//int a = grids31;
		int abc;
		//LeftControlPanel lcp1 = new LeftControlPanel();
		//abc =lcp1.testLCPattributes;
		//abc =  grids31;
		//abc =  c1.grids31;
		//a1= c1.grids31;
		a = c1.getestsnbc1() + a;
		//int a = c1.getestsnbc1();
		//getestsnbc1();
		//int a = c1.aetsnbc1;
		//this.getestsnbc1();
		
		RightControlPanel a1 = new RightControlPanel(c1);
		//int b  =a1.getestsbc1();
		int c;
		a1.vtpsbc1 =a1.getestsbc1();
		//LeftControlPanel left = new LeftControlPanel();
		//left.test1 = 20;
		//c=RightControlPanel.aetsbc2 ;
		//LeftControlPanel.test1 =	a1.getestsbc1();
		//GameStatusController.test2;
		//c=a1 .aetsbc2 ;
		//RightControlPanel.aetsbc2 = a1.vtpsbc1;
		//RightControlPanel.aetsbc2 = RightControlPanel.aetsbc2;
		a1.vtpsbc1= RightControlPanel.aetsbc2 ;
		a1.vtpsbc1=  a1.vtpsbc1;
		RightControlPanel a11 = new RightControlPanel(c1);
		a11.getestsbc1();
		RightControlPanel a111 = new RightControlPanel(c1);
		a111.getestsbc1();
		RightControlPanel a1111 = new RightControlPanel(c1);
		a1111.getestsbc1();
		RightControlPanel a11111 = new RightControlPanel(c1);
		a11111.getestsbc1();
		RightControlPanel a111111 = new RightControlPanel(c1);
		a111111.getestsbc1();
		
		int level = 5;
		 switch(level) { 
         	case 10: 
         		RightControlPanel a1111111 = new RightControlPanel(c1);
        		//a1111111.getestsbc1();
        		break;
		 }
	}
	
	public void testabc(){
		ChessBoard c = new ChessBoard(1);
		c.getestsnbc1();
		abc = new RightControlPanel(c);
		int level = vtpsnbc1;
	}
	//empty method should be caught
	public void emptyMethod1() {
		int level = 5;
		 switch(level) { 
            case 10: 
            case 9: 
            	ChessBoard c1 = new ChessBoard(1);
				RightControlPanel a1 = new RightControlPanel(c1);
				a1.getestsbc1();
				RightControlPanel.getestsbc2();
                break; 
            case 8: 
            	if(2>1) {
            		ChessBoard c2 = new ChessBoard(1);
            		RightControlPanel a2 = new RightControlPanel(c2);
            		int vtpsnbc3  = getvtpsnbc1();
            		
            	}
                break; 
            case 7: 
                System.out.println("得C"); 
                break; 
            case 6: 
                if(1>3){
					testabc();	
					ChessBoard c2 = new ChessBoard(1);
	        		RightControlPanel a2 = new RightControlPanel(c2);
	        		
				}else if(2>4){
					int b222;
					ChessBoard c2 = new ChessBoard(1);
					RightControlPanel b221= new RightControlPanel(c2);
					int snbc4;
					int[] test = {1,2,3};
					snbc4 = test.length;
					b222= ChessBoard.getaetsnbc2();
				}else if(2>4){
					int snbc;
					snbc = getaetsnbc1();
					testabc();
				}else{
					testabc();
				}
				
                break; 
            default: 
			
					  System.out.println("得C"); 
               
        }
    
	}
	
	
	//empty method should be caught
	public void emptyMethod2() {
		for(;;){
			for(;;){
				int snbc;
				ChessBoard c2 = new ChessBoard(1);

				RightControlPanel b221= new RightControlPanel(c2);
				int vtpsbc1 = b221.getvtpsbc2();
				snbc = c2.getaetsnbc1();
				int vtpsnbc4  = this.getvtpsnbc1();
			} 
		}
	}
	
	
	public static int getData() {
		return 1;
	}
	
	//empty method should be caught
	private void emptyMethod3() {
		int level = 5;
		int vtpsnbc5 =this.vtpsnbc1;
		int snbc5;
		snbc5 =aetsnbc1;
		
		 switch(level) { 
            case 10: 
            case 9: 
                while(2>1) {
                	ChessBoard c4 = new ChessBoard(1);
        			RightControlPanel a4 = new RightControlPanel(c4  );
        			int aetsnbc3 = 1;
        			RightControlPanel.get4();
        			int vtpsnbc6 = ChessBoard.vtpsnbc2;
        			int vtpsbc2 = RightControlPanel.getvtpsbc1();
        			int snbc6;
        			snbc6 =aetsnbc3;
        			 break; 
                }
               
            case 8: 
                System.out.println("得B"); 
                break; 
            case 7: 
                System.out.println("得C"); 
                ChessBoard c4 = new ChessBoard(1);
                int shouldNotBeCaught1 = c4.getABC();
                break; 
            case 6: 
                if(1>3){
					if(1>3){
						 int arr[]={5,3,8};
						 
						 for(int i:arr){
							 ChessBoard c5 = new ChessBoard(1);
			        		 RightControlPanel a5 = new RightControlPanel(c5 );
			        		 if(2>1) {
			        			 int b226;
			        			 int snbc1;
			        			 snbc1 = this.aetsnbc1;
			        			 int shouldNotBeCaught3 =ChessBoard.testData;
			        		 }
			        		 
					     }
					}else{
						if(1>3){
							int b229;
							ChessBoard c2 = new ChessBoard(1);
							RightControlPanel b223= new RightControlPanel(c2);
							int vtpsbc4 = b223.vtpsbc1;
							ChessBoard.getshoudnotbecaughtmethod2();
							int sbc2;
							sbc2 = RightControlPanel.aetsbc2;
						}else if(1>3){
							testabc();
							int sbc3;
							sbc3 = RightControlPanel.testsbc3;
							int vtpsbc3 = RightControlPanel.vtpsbc2;
						}
					}
						
				}
                break; 
            default: 
            System.out.println("得C"); 
			int snbc2;
			this.getshoudnotbecaughtmethod1();
			snbc2 = ChessBoard.aetsnbc2;
               
        }
		
	}
	
	public void getshoudnotbecaughtmethod1() {
		
	}
	
	
	static public void getshoudnotbecaughtmethod2() {
		
	}
	//empty method should be caught
	void emptyMethod4() {
		do {
			int c;
			getshoudnotbecaughtmethod1();
			ChessBoard c3 = new ChessBoard(1);
			ChessBoard.getshoudnotbecaughtmethod2();
			c3.getshoudnotbecaughtmethod1();
			RightControlPanel a3 = new RightControlPanel(c3 );
			a3.get2();
			c = a3.aetsbc1;
			int snbc3;
			snbc3 =c3.aetsnbc1;
			int shouldNotBeCaught6 =this.getABC();
		}while(2>1);
		
	}
	
	
	/**
	 * 初始化棋盤狀態、棋子暫存和MouseListener
	 */
	//MouseListener似乎不應該在這邊被初始化 考慮移到上一層
	public void initialize(){
		setBackground(Color.GRAY);				
		poistionOccupied= new int[grids][grids];
		chessMoves = new ArrayList<int[]>();
		addMouseListener(placeQueenHandler);
	}
	
	/**
	 * 悔棋，回到上一手棋的棋盤狀態
	 */
	public void undo(){
		
		int index = chessMoves.size();
		int[] lastmove = chessMoves.get(index-1);  
		int x = lastmove[0];
		int y = lastmove[1];
		
		chessMoves.remove(index-1);				//移除最後下個的那步棋  棋子下過的暫存-1
		poistionOccupied[x][y] = 0;				//把該步棋的poistionOccupied歸0
		//應該要把checkButtonStatus()移到全域可見的地方		RightControlPanel.checkButtonStatus();  //檢查按鈕狀態
	}
	
	/**
	 * 傳回此局遊戲目前下過的皇后數
	 * 
	 * @return 此局遊戲目前下過的皇后數
	 */
	public int getChessMovesCount(){
		return chessMoves.size();
	}
	
	public void testATFD(){
		RightControlPanel rcp = new RightControlPanel(new ChessBoard(4)); 
		rcp.initialize();
	}
	
	/**
	 * 檢查JPanel當前長寬，並以此計算出最適合的當前視窗大小的棋盤長寬和棋盤格子以及留白等參數
	 */
	//更新JPanel和長寬 棋盤格子大小等參數
	public void checkView(){
		chessView = this.getSize();					//檢查JPanel當前長寬
		chessWidth = chessView.width;
		chessHeight = chessView.height;
		
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){
			chessBoardMinLength = chessHeight;
			cell = chessBoardMinLength/grids;       //棋盤格子大小 = 當前棋盤寬度和高度兩個值中最小的那一個除以棋盤路數
			space= (chessWidth-chessHeight)/2;      //留白是把棋盤置中 兩邊都有相同大小的留白區塊
		}else{
			chessBoardMinLength = chessWidth;
			cell = chessBoardMinLength/grids;
			space= (chessHeight-chessWidth)/2;
		}
	}
	
	/**
	 * 畫棋盤格子
	 * 
	 * @param g
	 */

	public void drawGrids(Graphics g){
		chessView = this.getSize();
		chessWidth = chessView.width;
		chessHeight = chessView.height;
		
		//抓取當前視窗大小最小的長或寬 再畫成N*N棋盤
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){
			chessBoardMinLength = chessHeight ;
			cell = chessBoardMinLength/grids;
			space= (chessWidth-chessHeight)/2;          //四周留白 看長跟寬哪個比較長 哪邊就需要留白 
				                                        //靠增加留白區域設定繪圖初始位置製造置中效果							
			//上色				
			paintWhiteGrids(g);
			paintBlackGrids(g);	
			addMouseListener(placeQueenHandler);
		}else{
			chessBoardMinLength = chessWidth ;			
			cell = chessBoardMinLength/grids;
			space= (chessHeight-chessWidth)/2;
															
			paintWhiteGrids(g);
			paintBlackGrids(g);							
		}										
	}
	
	/**
	 * 畫棋盤格線
	 * 
	 * @param g
	 */

	public void drawLines(Graphics g){
		g.setColor(Color.BLACK);
		
		//一次畫一條直的跟一條橫的 棋盤有幾路就畫幾次
		for(int i = 0;i<=grids;i++){	
			chessView = this.getSize();
			chessWidth = chessView.width;
			chessHeight = chessView.height;
		
			//抓取當前視窗大小最小的長或寬 再畫成8*8棋盤
			//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
			if(chessWidth > chessHeight){
				chessBoardMinLength = chessHeight ;
				cell = chessBoardMinLength/grids;
				//考慮把space封裝起來 space = 長減寬的絕對值 這樣就不需要判斷長寬哪個的值比較大了
				space= (chessWidth-chessHeight)/2;          //四周留白 看長跟寬哪個比較長 哪邊就需要留白 
				                                            //靠增加留白區域設定繪圖初始位置製造置中效果							
				g.drawLine(0+space, i*cell , grids*cell+space, i*cell);		
				//橫線 從(space,i*cell)到(grids*cell+space,i*cell)間畫一條直線
				//i*cell代表了每次for迴圈往下畫下一條直線的Y座標一定是跟上一條((i-1)*cell)距離一個棋盤格的距離
				g.drawLine(i*cell+space, 0 , i*cell+space, grids*cell);		
				//直線 從(i*cell+space,0)到(i*cell+space,grids*cell)間畫一條直線
				//+space保證畫出來會在JPanel正中間	
			}else{
				chessBoardMinLength = chessWidth ;
				cell = chessBoardMinLength/grids;
				cell = chessBoardMinLength/grids;
				space= (chessHeight-chessWidth)/2;		    //四周留白 看長跟寬哪個比較長 哪邊就需要留白 
															//靠增加留白區域設定繪圖初始位置製造置中效果																		
				g.drawLine(0, i*cell+space , grids*cell, i*cell+space);		//橫線
				g.drawLine(i*cell, 0+space , i*cell, grids*cell+space);		//直線
			}								
		}
	}
	
	//M型程式碼 考慮重構
	/**
	 * 畫出黑色的棋盤格子
	 * 
	 * @param g
	 */
	public void paintBlackGrids(Graphics g){
		g.setColor(Color.BLACK);
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){
			for(int i=0 ; i<grids ;i++){   //Y方向循環 循環八次
				//第一次 檢查奇數行
				for(int j=0 ;j<grids ;j++){  //X方向循環 畫奇數行的黑格
					if(j%2!=0){
						g.fillRect(0+space+j*cell, i*cell , cell, cell);									   						
					}					
				}			
				//第二次 檢查偶數行
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2==0){   //X方向循環 畫偶數行的黑格
						g.fillRect(0+space+j*cell, i*cell , cell, cell);																	
					}								
				}
			}
		}else{     //Height > Width
			for(int i=0 ; i<grids ;i++){   //Y方向循環 循環八次
				//第一次 檢查奇數行
				for(int j=0 ;j<grids ;j++){  //X方向循環 畫奇數行的黑格
					if(j%2!=0){
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);				
					}					
				}			
				//第二次 檢查偶數行
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2==0){   //X方向循環 畫偶數行的黑格
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);
					}								
				}
			}
		}
	}
	
	/**
	 * 畫出白色的棋盤格子
	 * 
	 * @param g
	 */
	public void paintWhiteGrids(Graphics g){
		g.setColor(Color.WHITE);
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){
			for(int i=0 ; i<grids ;i++){   //Y方向循環 循環八次
				//第一次 檢查奇數行
				for(int j=0 ;j<grids ;j++){  //X方向循環 畫奇數行的白格
					if(j%2==0){
						g.fillRect(0+space+j*cell, i*cell , cell, cell);																					   						
					}					
				}			
				//第二次 檢查偶數行
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2!=0){   //X方向循環 畫偶數行的白格
						g.fillRect(0+space+j*cell, i*cell , cell, cell);																	
					}								
				}
			}
		}else{     //Height > Width
			for(int i=0 ; i<grids ;i++){   //Y方向循環 循環八次
				//第一次 檢查奇數行
				for(int j=0 ;j<grids ;j++){  //X方向循環 畫奇數行的白格
					if(j%2==0){
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);								
					}					
				}			
				//第二次 檢查偶數行
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2!=0){   //X方向循環 畫偶數行的白格
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);
					}								
				}
			}
		}		
	}
	
	/**
	 * 畫出棋子步數暫存中的所有皇后
	 * 
	 * @param g
	 */
	private void drawAllQueens(Graphics g){
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){	
			Iterator<int[]> it = chessMoves.iterator();	
			while(it.hasNext()){				
				int[] moves  = it.next();				
				//開發時暫時代替皇后圖標的印棋子方法
				//g.fillRect(0+space+moves[0]*cell,moves[1]*cell,cell,cell);	
				g.drawImage(queen, 0+space+moves[0]*cell, moves[1]*cell, cell, cell, this);
			}		
		}else{  //Height > Width
			Iterator<int[]> it = chessMoves.iterator();	
			while(it.hasNext()){				
				int[] moves  = it.next();				
				//g.fillRect(moves[0]*cell,0+space+moves[1]*cell,cell,cell);	
				g.drawImage(queen, moves[0]*cell, 0+space+moves[1]*cell, cell, cell, this);
			}
		}
	}
	
	
	//滑鼠點擊放棋子
	private MouseListener placeQueenHandler= new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			x=e.getX();
			y=e.getY();
			
			if(GameStatusController.gameMode == Mode.normal){         //遊戲模式下才可擺放棋子
				//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
				if(chessWidth > chessHeight){
					if(x<=chessBoardMinLength+space && x>=0+space && y<=chessBoardMinLength && y>=0){
						//開發時DEBUG用 不知現在還能不能運作 考慮移除
						//System.out.println("W>H　");
						//System.out.println(chessBoardMinLength+"　"+space+" "+cell);
						//System.out.println("X"+x);
						//System.out.println("Y"+y);
						//System.out.println("X"+getXCoordinate(x));
						//System.out.println("Y"+getYCoordinate(y));
					
						coordinateX = getXCoordinate(x);					
						coordinateY = getYCoordinate(y);
						recordChessMoves(coordinateX, coordinateY);
						repaint();  										
					}
				}else{   //chessHeight > chessWidth
					if(x<=chessBoardMinLength && x>=0 && y<=chessBoardMinLength+space && y>=0+space){			
						coordinateX = getXCoordinate(x);					
						coordinateY = getYCoordinate(y);
						recordChessMoves(coordinateX, coordinateY);			
						repaint(); 														
					}
				}
			}
		}
	};
	
	/**
	 * 檢查目前這步能不能成功擺放並儲存 
	 * 
	 * @param x 目前這步在棋盤上的X座標
	 * @param y 目前這步在棋盤上的Y座標
	 */
	private void recordChessMoves(int x, int y){	
		if(chessMoves!=null  && chessMoves.size()<8){	 //chessMoves.size()<8 8應該要改成N 跟N皇后問題動態結合
			//透過檢查poistionOccupied這個flag來判斷格子是否被占據  進而排除已經下過的步數
			if(poistionOccupied[x][y] == 0){
				poistionOccupied[x][y] = 1;
				chessMoves.add(new int[]{x,y});
				RightControlPanel.checkButtonStatus();    //檢查當前按鈕狀態 如果棋盤暫存滿了 就能按驗證答案
			}
		}		
	}
		
	/*
	//印出下過的每一步   開發時DEBUG用 不知現在還能不能運作 考慮移除
	private void printChessMoves(){
		if(chessMoves!=null){
			Iterator<int[]> it = chessMoves.iterator();
			int i = 0;		
			while(it.hasNext()){				
				int[] moves  = it.next();				
				System.out.println("第"+(i+1)+"步下在座標("+moves[0]+","+moves[1]+")");
				i++;				
			}
		}
	}
	*/
	
	void setXXYY(){
	
	}
	
	
	public void setXXX(){
	
	}
	
	
	/**
	 * 計算當前滑鼠點擊位置對應到的棋盤X座標(0~7)
	 * 
	 * @param x 當前滑鼠在元件上點擊的X座標
	 * @return  滑鼠點擊的位置對應到棋盤上的X座標
	 */
	private int getXCoordinate(int x){
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){
			for(int i = 0 ; i<grids ;i++){
				if(x>=i*cell+space && x<(i+1)*cell+space)
					return i;
			}			
			return grids-1;      //當初計算cell時忽略的小數點可能造成後面的臨界區塊判定錯誤 靠return grids-1來修正
			                     //如果棋盤路數更大應該不能這樣弄 考慮把cell算得更精確 看能不能算到小數點後第二位
		}else{   //chessHeight > chessWidth
			for(int i = 0 ; i<grids ;i++){
				if(x>=i*cell && x<(i+1)*cell)
					return i;
			}		
			return grids-1;
		}
	}
	
	/**
	 * 計算當前滑鼠點擊位置對應到的棋盤Y座標(0~7)
	 * 
	 * @param y 當前滑鼠在元件上點擊的Y座標
	 * @return	滑鼠點擊的位置對應到棋盤上的Y座標
	 */
	private int getYCoordinate(int y){
		//考慮把這個判斷和後續的執行封裝起來放在全域可見的地方 因為if(chessWidth > chessHeight)實在太常用到了
		if(chessWidth > chessHeight){
			for(int i = 0 ; i<grids ;i++){
				if(y>=i*cell && y<(i+1)*cell)
					return i;
			}		
			return grids-1;		//當初計算cell時忽略的小數點可能造成後面的臨界區塊判定錯誤 靠return grids-1來修正
								//如果棋盤路數更大應該不能這樣弄 考慮把cell算得更精確 看能不能算到小數點後第二位
		}else{   //chessHeight > chessWidth
			for(int i = 0 ; i<grids ;i++){			
				if(y>=i*cell+space && y<(i+1)*cell+space)
					return i;
			}		
			return grids-1;
		}
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawGrids(g);
		drawAllQueens(g);
		drawLines(g);
		//先畫棋盤格，再畫棋子，最後畫線
		//不然先畫棋子的話，棋子會被棋盤格蓋掉。同理，線不最後畫的話會被棋子跟棋盤蓋掉
		
		
/* 		//只要清空棋盤暫存做好就行 好像移除也沒有差 待研究 
		if(x!=0 && y!= 0){					
			x=0;
			y=0;		
			coordinateX = 0;
			coordinateY = 0;
		}
		*/
	}
}