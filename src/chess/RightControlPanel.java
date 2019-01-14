package chess;


/* 
 * ClassName		 :
 * RightControlPanel 
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
 *          修正立刻完成算法的bug
 * 
 */


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 設定右邊控制面板的布局跟面板上的按鈕元件
 * 
 * @note 八皇后遊戲
 * @author 	許博淳
 * @version 1.0
 * 
 */

public class RightControlPanel extends JPanel{
	private static ChessBoard chessBoard;	
	//private Image queenImage;        		//本來要放在顯示剩下的皇后數旁邊的圖案 等待以後實作   
	private JLabel imageLabel;          	//承上 放置該圖案的區域 目前為空
	private static JLabel queenLeft;    	//顯示在遊戲模式下目前還剩下幾個皇后要擺
	private static JButton newGame;    		//"重開新局"的按鈕
	private static JButton confirmAnswer;   //"確認答案"的按鈕
	private static JButton undo;			//"悔棋"的按鈕
	private static JButton startNormalGame; //"一般遊戲"的按鈕
	private static JButton startDemo;		//"Demo"的按鈕
	private static JComboBox<Integer> selcetDemoGrids;   //Demo模式選擇demo幾路棋盤的下拉式清單 裡面的元素類型是Integer
	private JLabel leftBlankArea;   		//控制面板左邊的空白區域
	private JLabel rightBlankArea;  		//控制面板右邊的空白區域
	private JLabel buttomBlankArea; 		//控制面板下方的空白區域
	private JLabel topBlankArea;			//控制面板上方的空白區域
	private GridBagLayout rightLayout;
	private GridBagConstraints constraints;	
	private static int demoGrids;			//Demo模式啟動時下拉式清單所選擇的元素
	private static final long serialVersionUID = 1L;
	public int aetsbc1 = 1;
	public  static  int  aetsbc2 =2;
	public  static  int  testsbc3 =2;
	
	public static int vtpsbc2 =2;
	public  int vtpsbc1 =2;
	/*
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
	*/
	
	public RightControlPanel(ChessBoard gameBorad){
		this.chessBoard = gameBorad;
	}
	public void testabc(){
	}
	public void testInRightControlPanel() {
		get123();
		if(1>2){
			if(1<=0){
				//ChessBoard.testabc();
			}
		}	
	}
	
	public static int getaetsbc1() {
		return 1;
	}
	
	public int getadditionsbc999() {
		return 1;
	}
	
	public int getaetsbc2() {
		return 1;
	}
	
	
	public static int getvtpsbc1() {
		return 1;
	}
	
	public int getvtpsbc2() {
		return 1;
	}
	
	public static int getestsbc2() {
		return 1;
	}
	
	public int getestsbc1() {
		return 1;
	}
	
	public void get123(){
		
		
	}
	
	public static void get2() {
		
	}
	
	public static void get3() {
		
	}
	
	public static int get4() {
		return 4;
	}
	
	public static void set1() {
		
	}
	
	public int get1() {
		return 1;
	}
	
	public void test1234567() {
		ChessBoard c = new ChessBoard(8);
		JLabel a = new JLabel();
		a.getDisplayedMnemonic();
		//c.getABC();
	}
	
	/**
	 * 初始化右邊控制面板
	 * 
	 */
	public void initialize(){		
		rightLayout = new GridBagLayout();
		constraints = new GridBagConstraints();	
		
		setLayout(rightLayout);	
		setBlankArea();
		setImageLabel();
		setQueenLeft();
		setNewGame();
		setConfirmAnswer();
		setUndo();
		setStartNormalGame();
		setStartDemo();
		setDemoGrids();	
	}

	/**
	 * 設定右邊控制面板空白區域的位置跟布局
	 * 
	 */
	private void setBlankArea(){	
		//右邊控制面板左邊的空白區域
		leftBlankArea = new JLabel();		
		constraints.gridx= 0;
		constraints.gridy= 0;
		constraints.gridwidth =1;
		constraints.gridheight = 14;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(leftBlankArea, constraints);
		
		//右邊控制面板上方的空白區域		
		topBlankArea = new JLabel();				
		constraints.gridx= 1;
		constraints.gridy= 0;
		constraints.gridwidth =9;
		constraints.gridheight = 3;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(topBlankArea, constraints);
		
		//右邊控制面板右邊的空白區域			
		rightBlankArea = new JLabel();		
		constraints.gridx= 5;
		constraints.gridy= 8;
		constraints.gridwidth =5;
		constraints.gridheight = 3;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(rightBlankArea, constraints);
		
		//右邊控制面板下方的空白區域
		buttomBlankArea = new JLabel();		
		constraints.gridx= 1;
		constraints.gridy= 12;
		constraints.gridwidth =10;
		constraints.gridheight = 2;
		constraints.weightx= 50;
		constraints.weighty= 50;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(buttomBlankArea, constraints);
					
		add(leftBlankArea);
		add(topBlankArea);
		add(rightBlankArea);
		add(buttomBlankArea);
	}
	
	/**
	 * 設定放置圖案區域的布局 目前無圖案等以後再新增圖案
	 * 
	 */
	public void setImageLabel(){
		imageLabel = new JLabel();
		constraints.gridx= 1;
		constraints.gridy= 3;
		constraints.gridwidth =4;
		constraints.gridheight = 2;
		constraints.weightx= 30;
		constraints.weighty= 30;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(imageLabel, constraints);
		
		add(imageLabel);
	}
	
	/**
	 * 設定顯示皇后數區域的布局
	 * 
	 */
	public void setQueenLeft(){
		queenLeft = new JLabel();		
		queenLeft.setFont(new Font("新細明體",Font.PLAIN, 40));
		queenLeft.setText("剩下的皇后數 : " + (8-chessBoard.getChessMovesCount()));
		
		constraints.gridx= 6;
		constraints.gridy= 3;
		constraints.gridwidth =3;
		constraints.gridheight = 2;
		constraints.weightx= 30;
		constraints.weighty= 30;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(queenLeft, constraints);
		
		add(queenLeft);
	}
	
	/**
	 * 
	 * 設定"重開新局"按鈕的布局和功能
	 */
	public void setNewGame(){
		newGame = new JButton("重開新局");
		newGame.setFont(new Font("新細明體",Font.PLAIN, 20));
		
		constraints.insets=new Insets(40,40,40,40);
		constraints.gridx= 1;
		constraints.gridy= 6;
		constraints.gridwidth =3;
		constraints.gridheight = 2;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(newGame, constraints);
		
		if(GameStatusController.gameMode != Mode.normal){
			newGame.setEnabled(false);
		}				
		
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GameStatusController.gameMode = Mode.normal;								
				chessBoard.initialize();  			//初始化棋盤
				chessBoard.repaint();				//重繪棋盤
				GameInterface.setTimerStartTime();  //開始計時
				checkButtonStatus();							
			}					
		});
		
		add(newGame);
	}
	
	/**
	 * 
	 * 設定"確認答案"按鈕的布局和功能
	 */
	public void setConfirmAnswer(){
		confirmAnswer = new JButton("確認答案");
		confirmAnswer.setFont(new Font("新細明體",Font.PLAIN, 20));
		
		constraints.insets=new Insets(40,40,40,40);
		constraints.gridx= 4;
		constraints.gridy= 6;
		constraints.gridwidth =3;
		constraints.gridheight = 2;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(confirmAnswer, constraints);
			
		confirmAnswer.setEnabled(false);		
		confirmAnswer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){								
				//讀取暫存裡的座標
				//ChessBoard.chessMoves.size()==8 這邊被寫死了 應該要跟棋盤路數動態連結
				if(ChessBoard.chessMoves!=null && ChessBoard.chessMoves.size()==8){
					Iterator<int[]> it = ChessBoard.chessMoves.iterator();
					//用map來排除掉X座標重複的問題
					HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();	
					while(it.hasNext()){				
						int[] moves  = it.next();	
						temp.put(moves[0],moves[1]);
					}
					//temp.size()!=8這邊被寫死了 應該要跟棋盤路數動態連結
					if(temp.size()!=8){       //八個棋步的暫存轉成map後的size()!=8 代表作為key值的X座標有重複的
						JOptionPane.showMessageDialog(null, "請再檢查看看","答案錯誤",JOptionPane.ERROR_MESSAGE);
						//跳出小視窗告知使用者目前答案有誤
					}else{      			
						confirmAnswer(temp);    //傳入SWI Prolog進行比較
					}			
				}										
				checkButtonStatus();						
			}					
		});
		
		add(confirmAnswer);
	}
	
	/**
	 * 
	 * 設定"悔棋"按鈕的布局和功能
	 */
	public void setUndo(){
		undo = new JButton("悔棋");
		undo.setFont(new Font("新細明體",Font.PLAIN, 20));	
		
		constraints.insets=new Insets(40,40,40,40);
		constraints.gridx= 7;
		constraints.gridy= 6;
		constraints.gridwidth =2;
		constraints.gridheight = 2;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(undo, constraints);
		undo.setEnabled(false);
		
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				if(GameStatusController.gameMode == Mode.normal){  				
					chessBoard.undo();				
					chessBoard.repaint();
					
					checkButtonStatus();					
				}
			}					
		});
			
		add(undo);	
	}
	
	/**
	 * 
	 * 設定"一般遊戲"按鈕的布局和功能
	 */
	public void setStartNormalGame(){
		startNormalGame = new JButton("一般遊戲");
		startNormalGame.setFont(new Font("新細明體",Font.PLAIN, 20));		
		
		constraints.insets=new Insets(200,20,20,0);
		constraints.gridx= 1;
		constraints.gridy= 9;
		constraints.gridwidth =4;
		constraints.gridheight = 1;
		constraints.weightx= 20;
		constraints.weighty= 20;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(startNormalGame, constraints);
			
		startNormalGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(GameStatusController.gameMode != Mode.normal){  
					GameStatusController.gameMode = Mode.normal;
					//這部分跟重開新局一樣 可以考慮封裝成一個新方法
					chessBoard.initialize();  			//初始化棋盤
					chessBoard.repaint();				//重繪棋盤				
					checkButtonStatus();
					GameInterface.setTimerStartTime();  //重新開始計時器
				}
			}					
		});
		
		add(startNormalGame);
	}

	/**
	 * 
	 * 設定"Demo"按鈕的布局和功能
	 */
	public void setStartDemo(){
		startDemo = new JButton("Demo");
		startDemo.setFont(new Font("新細明體",Font.PLAIN, 20));
		
		constraints.insets=new Insets(0,20,200,0);
		constraints.gridx= 1;
		constraints.gridy= 10;
		constraints.gridwidth =4;
		constraints.gridheight = 1;
		constraints.weightx= 20;
		constraints.weighty= 20;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(startDemo, constraints);
		
		startDemo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GameStatusController.gameMode = Mode.demo;
				queenLeft.setText("");         
				//感覺常常用到以下三行  重構的時候注意一下
				chessBoard.initialize();  		//初始化棋盤
				chessBoard.repaint();			//重繪棋盤
				checkButtonStatus();	
				GameInterface.messageBox.setText("演算法模式");
				if(selcetDemoGrids.getSelectedItem() != null){	
					//ChessBoard.getClass();
					
					demoGrids = (int) selcetDemoGrids.getSelectedItem();
					checkButtonStatus();	
					//根據選擇的元素 連接對應的prolog檔案
					//應該把demoGrids作為參數傳入 呼叫連接prolog的方法 由該方法依據參數判斷該連哪個prolog檔案
					switch(demoGrids){
						case 4:
							checkButtonStatus();
							GameInterface.infer_Fourqueens_Solutionnum();			
							break;
						case 5:
							checkButtonStatus();
							GameInterface.infer_Fivequeens_Solutionnum();
							break;	
						case 6:
							checkButtonStatus();
							GameInterface.infer_Sixqueens_Solutionnum();	
							break;
						case 7:
							checkButtonStatus();
							GameInterface.infer_Sevenqueens_Solutionnum();	
							break;	
						case 8:							
							checkButtonStatus();
							GameInterface.infer_Eightqueens_Solutionnum();	
							break;
						case 9:							
							checkButtonStatus();
							GameInterface.infer_Ninequeens_Solutionnum();	
							break;
						case 10:						
							checkButtonStatus();
							GameInterface.infer_Tenqueens_Solutionnum();	
							break;	
					}				
				}
			}					
		});
		
		add(startDemo);	
	}

	/**
	 * 
	 * 設定Demo模式中下拉式清單的布局和功能
	 */
	public void setDemoGrids(){
		selcetDemoGrids = new JComboBox<Integer>();		   //此清單內的元素都是Integer物件
		selcetDemoGrids.setFont(new Font("新細明體",Font.PLAIN, 20));
		
		constraints.gridx= 5;
		constraints.gridy= 10;
		constraints.gridwidth =3;
		constraints.gridheight = 1;
		constraints.weightx= 50;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(selcetDemoGrids, constraints);
				
		selcetDemoGrids.addItem(null);
		selcetDemoGrids.setSelectedIndex(0);
		for(int i = 0 ;i<7;i++){
			selcetDemoGrids.addItem(i+4);
		}
			
		add(selcetDemoGrids);
	}
	
	
	//應該要放在更高的層次 讓全域可見  透過此方法來控制按鈕狀態 而不是在每次點擊或是條件達到後 呼叫一個改變按鈕狀態的setEnabled()方法
	/**
	 * 
	 * 依據目前遊戲模式和棋局狀態檢查並更新按鈕狀態
	 */
	public static void checkButtonStatus(){
		if(GameStatusController.gameMode == Mode.none){         	//none模式下 
			newGame.setEnabled(false);								//不可以點擊"重開新局"按鈕
			confirmAnswer.setEnabled(false);						//不可以點擊"確認答案"按鈕
			undo.setEnabled(false);									//不可以點擊"悔棋"按鈕
			startNormalGame.setEnabled(true); 						//可以點擊"一般遊戲"按鈕   此舉會導致遊戲模式轉換成normal模式
			startDemo.setEnabled(true); 							//可以點擊"Demo"按鈕         此舉會導致遊戲模式轉換成demo模式
			selcetDemoGrids.setEnabled(false);  					//不可以點選下拉式清單
			selcetDemoGrids.setSelectedIndex(0);					//把下拉式清單初始化
			LeftControlPanel.completeNow.setEnabled(false);			//不可以點擊左邊控制面板的"立刻完成"按鈕
			LeftControlPanel.showNextAnswer.setEnabled(false); 		//不可以點擊左邊控制面板的"下一組解"按鈕
					
			//應該要把清空flag給移到別的地方去實現  flag是用來計算demo模式目前demo到第幾組解用的 跟button狀態無關
			LeftControlPanel.flag = 0;		
		}else if (GameStatusController.gameMode == Mode.normal){  	//normal模式下
			newGame.setEnabled(true);								//可以點擊"重開新局"按鈕
			startNormalGame.setEnabled(false); 						//不可以點擊"一般遊戲"按鈕
			startDemo.setEnabled(true); 							//可以點擊"Demo"按鈕         此舉會導致遊戲模式轉換成demo模式
			selcetDemoGrids.setEnabled(false);						//不可以點選下拉式清單
			selcetDemoGrids.setSelectedIndex(0);					//把下拉式清單初始化
			LeftControlPanel.completeNow.setEnabled(true);			//可以點擊左邊控制面板的"立刻完成"按鈕
			LeftControlPanel.showNextAnswer.setEnabled(false);		//不可以點擊左邊控制面板的"下一組解"按鈕
			
			//應該要把清空flag這個功能移到別的地方去實現  flag是用來計算demo模式目前demo到第幾組解用的 跟button狀態無關
			LeftControlPanel.flag = 0;
			
			//(8-chessBoard.getChessMovesCount())== 0)寫死了 應該要能動態連接到目前的棋盤路數
			if((8-chessBoard.getChessMovesCount())== 0){  			//如果此局的暫存中的皇后沒有放滿八個 就不能點擊"確認答案"按鈕
				confirmAnswer.setEnabled(true);
			}else{
				confirmAnswer.setEnabled(false);  
			}
			
			if(chessBoard.getChessMovesCount()>0 ){   				//如果此局的暫存為空 就不能點擊"悔棋"按鈕
				undo.setEnabled(true);
			}else{
				undo.setEnabled(false);
			}			
			
			//應該要把顯示剩下的皇后數這個功能移到別的地方去實現 這跟功能跟button狀態無關
			if(ChessBoard.chessMoves != null ){
				//(8-chessBoard.getChessMovesCount())寫死了 應該要能動態連接到目前的棋盤路數
				queenLeft.setText("剩下的皇后數 : " + (8-chessBoard.getChessMovesCount()));			
			}
		}else{  													//demo模式下demo
			newGame.setEnabled(false);								//不可以點擊"重開新局"按鈕
			confirmAnswer.setEnabled(false);						//不可以點擊"確認答案"按鈕
			undo.setEnabled(false);									//不可以點擊"悔棋"按鈕
			startNormalGame.setEnabled(true); 						//可以點擊"一般遊戲"按鈕
			selcetDemoGrids.setEnabled(true);						//可以點選下拉式清單
			 /*	不能在demo模式中初始化下拉式清單   不然抓取不到下拉式清單的數值
			  * 所以把初始化下拉式清單的工作交由在其他遊戲狀態時執行
			  */
			LeftControlPanel.completeNow.setEnabled(false);			//不可以點擊左邊控制面板的"立刻完成"按鈕
			LeftControlPanel.showNextAnswer.setEnabled(false);		//不可以點擊左邊控制面板的"下一組解"按鈕
			
			//應該要把清空flag給移到別的地方去實現  flag是用來計算demo模式目前demo到第幾組解用的 跟button狀態無關
			LeftControlPanel.flag = 0;
			
			//下拉式清單能選的棋盤應該都要能demo 所以以後只要  demoGrids == null 就可以點擊"下一組解"按鈕
			//demoGrids == 8寫死了 應該要能動態連接到目前的棋盤路數
			if(demoGrids == 8){										//如果demo的棋盤路數是8 可以點擊"下一組解"按鈕
				LeftControlPanel.showNextAnswer.setEnabled(true);
			}else{
				LeftControlPanel.showNextAnswer.setEnabled(false);
			}
		}		
	}
	
	/**
	 * 檢查目前完成的棋局是否為正確答案之一
	 * 
	 * @param answer 下過的棋步暫存
	 */
	public void confirmAnswer(HashMap<Integer, Integer> answer){
		int y[]=new int[8];

		//這部分的code好像也出現過 考慮封裝起來 
		Iterator<Map.Entry<Integer, Integer>> it = answer.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, Integer> entry = it.next();
			switch((int)entry.getKey()){
				case 0:
					y[0] = (int)entry.getValue()+1;
					break;
				case 1:
					y[1] = (int)entry.getValue()+1;
					break;
				case 2:
					y[2] = (int)entry.getValue()+1;
					break;
				case 3:
					y[3] = (int)entry.getValue()+1;
					break;
				case 4:
					y[4] = (int)entry.getValue()+1;
					break;
				case 5:
					y[5] = (int)entry.getValue()+1;
					break;
				case 6:
					y[6] = (int)entry.getValue()+1;
					break;
				case 7:
					y[7] = (int)entry.getValue()+1;
					break;			
			}									
		}		
		
		String query = "eight_queens([(1,"+y[0]+"),(2,"+y[1]+"),(3,"+y[2]+"),(4,"+y[3]+"),(5,"+y[4]+"),(6,"+
						y[5]+"),(7,"+y[6]+"),(8,"+y[7]+")]). ";		
		GameInterface.infer_Eightqueens_Solution_TrueorFalse(query);
	}	
}