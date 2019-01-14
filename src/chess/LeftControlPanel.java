package chess;

/* 
 * ClassName		 :
 * LeftControlPanel 
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

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.Image;   
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 設定左邊控制面板的布局跟面板上的按鈕元件
 * 
 * @note 八皇后遊戲
 * @author 	許博淳
 * @version 1.0
 * 
 */

public class LeftControlPanel extends JPanel{
	private static ChessBoard chessBoard;
	private JLabel messageBox;
	//private Image mainImage;   		//作弊模式觸發區域使用的圖標   
	private JLabel imageLabel;   		//作弊模式的觸發區域 按這個可以開啟從鍵盤輸入作弊碼 等待以後的版本實作
	static JButton completeNow;  		//在遊戲模式下立刻完成棋局  (等待實作:開啟作弊模式後才可以顯示並使用)
	static JButton showNextAnswer;  	//演算法模式下show出下一組解  同時會更新中下方面板的文字	 顯示目前是 第X of Y組解								  	                              		
	private JButton no;           		//功能忘了 待新增
	private JLabel leftBlankArea;   	//左邊空白
	private JLabel rightBlankArea;  	//右邊空白
	private JLabel buttomBlankArea; 	//下方空白	
	private GridBagLayout leftLayout;
	private GridBagConstraints constraints;	
	public int testLCPattributes = 1;
	public static int test1 = 1;
	
	//flag考慮要改名 不然根本不知道做甚麼用的
	static int flag = 0;				//控制演算法模式下show出第N組解控制旗標
	static List<String> tempAnswer = new ArrayList<String>();  //存放用SWI Prolog查詢八皇后問題後的各種可行解
	private static final long serialVersionUID = 1L;

	public LeftControlPanel(ChessBoard gameBorad, JLabel messageBox){
		this.chessBoard = gameBorad;
		this.messageBox = messageBox;
	}
	
	public LeftControlPanel(){
		
	}
	
	/**
	 * 初始化左邊控制面板
	 * 
	 */
	public void initialize(){		
		leftLayout = new GridBagLayout();
		constraints = new GridBagConstraints();		
		
		setLayout(leftLayout);		
		setBlankArea();
		setMainImage();
		setCompleteNowButton();
		setShowNextAnswerButton();
		setNoButton();	
	}
	
	/**
	 * 設定左邊控制面板空白區域的位置跟布局
	 * 
	 */
	private void setBlankArea(){		
		//左邊控制面板左邊的空白區域
		leftBlankArea = new JLabel();		
		constraints.gridx= 0;
		constraints.gridy= 6;
		constraints.gridwidth =1;
		constraints.gridheight = 6;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.fill = GridBagConstraints.BOTH;
		leftLayout.setConstraints(leftBlankArea, constraints);		
		
		//左邊控制面板右邊的空白區域
		rightBlankArea = new JLabel();	
		constraints.gridx= 5;
		constraints.gridy= 6;
		constraints.gridwidth =1;
		constraints.gridheight = 6;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.fill = GridBagConstraints.BOTH;
		leftLayout.setConstraints(rightBlankArea, constraints);		
		
		//左邊控制面板下方的空白區域
		buttomBlankArea = new JLabel();	
		constraints.gridx= 0;
		constraints.gridy= 12;
		constraints.gridwidth =6;
		constraints.gridheight = 6;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.fill = GridBagConstraints.BOTH;
		leftLayout.setConstraints(buttomBlankArea, constraints);
		
		add(leftBlankArea);
		add(rightBlankArea);
		add(buttomBlankArea);
	}
	
	/**
	 * 設定左邊控制面板作弊模式的觸發區域的布局，目前還沒有實作功能跟把圖貼上去
	 * 
	 */
	private void setMainImage(){
		imageLabel = new JLabel();	
		constraints.gridx= 0;
		constraints.gridy= 0;
		constraints.gridwidth =6;
		constraints.gridheight = 6;
		constraints.weightx= 300;
		constraints.weighty= 300;
		constraints.fill = GridBagConstraints.BOTH;
		leftLayout.setConstraints(imageLabel, constraints);		
		add(imageLabel);
	}
	
	/**
	 * 設定左邊控制面板上"立刻完成"按鈕的布局跟功能
	 * 
	 */
	private void setCompleteNowButton(){
		completeNow = new JButton("立刻完成");
		completeNow.setFont(new Font("新細明體",Font.PLAIN, 40));
		
		constraints.gridx= 1;
		constraints.gridy= 6;
		constraints.gridwidth =4;
		constraints.gridheight = 2;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.insets=new Insets(50,0,50,0);
		leftLayout.setConstraints(completeNow, constraints);
		
		completeNow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ChessBoard.chessMoves.size()<8被寫死了 應該要能跟棋盤路數動態連結
				if(ChessBoard.chessMoves!=null && ChessBoard.chessMoves.size()<8){/*
					Iterator<int[]> it = ChessBoard.chessMoves.iterator();
					HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();	
					while(it.hasNext()){				
						int[] moves  = it.next();	
						temp.put(moves[0],moves[1]);
					}*/
					ArrayList<int[]> temp  = ChessBoard.chessMoves;
					completeAnswer(temp);    //傳入當前棋局暫存裡儲存的步數
				}			
			}			
		});
		add(completeNow);
	}
	
	/**
	 * 把當前棋局暫存裡儲存的步數轉換成SWI Prolog查詢語句
	 * 
	 * @param answer 當前棋局暫存裡儲存的步數
	 */
	private void completeAnswer(ArrayList<int[]> answer){
		Iterator<int[]> mapit = ChessBoard.chessMoves.iterator();
		HashMap<Integer,Integer> maptemp = new HashMap<Integer,Integer>();	
		while(mapit.hasNext()){				
			int[] moves  = mapit.next();	
			maptemp.put(moves[0],moves[1]);   //把座標的X值當成map的key
		}		
		int y[]=new int[8];
		//new int[8]被寫死了 應該要能跟棋盤路數動態連結
		Iterator<int[]> listit = ChessBoard.chessMoves.iterator();
		//把暫存步數的arraylist轉成map 再比較兩者的長度就能得知本來的arraylist裡是否有座標X值相同的棋步
		if(((int)maptemp.size())==((int)answer.size())){
			while(listit.hasNext()){
				int[] moves  = listit.next();
				//switch case被寫死了 應該要能跟棋盤路數動態連結
				switch((int)moves[0]){//把當前棋局暫存裡儲存的步數 Y座標+1 符合一般人的坐標系 也讓程式能判斷該位置已有皇后
					case 0:
						y[0] = (int)moves[1]+1;
						break;
					case 1:
						y[1] = (int)moves[1]+1;
						break;
					case 2:
						y[2] = (int)moves[1]+1;
						break;
					case 3:
						y[3] = (int)moves[1]+1;
						break;
					case 4:
						y[4] = (int)moves[1]+1;
						break;
					case 5:
						y[5] = (int)moves[1]+1;
						break;
					case 6:
						y[6] = (int)moves[1]+1;
						break;
					case 7:
						y[7] = (int)moves[1]+1;
						break;			
				}
			}
			//String query被寫死了 應該要能跟棋盤路數動態連結
			//字串的串接效率要改善
			String query = "eight_queens([";	
			//for(int i = 1;i<9;i++)被寫死了 應該要能跟棋盤路數動態連結
			for(int i = 1;i<9;i++){
				if(y[i-1] !=0){         //if y[i-1] != 0 代表此局棋盤上對應到的格子有放皇后
					query = query+"("+i+","+y[i-1];
				}else{
					query = query+"("+i+","+"Y"+i;
				}
				//if(i !=8) 應該要能跟棋盤路數動態連結
				if(i !=8){
					query = query +"),";
				}else{
					query = query +")";
				}
			}
			query =query +"]).";
			GameInterface.infer_Eightqueens_Solution(query);
		}else{    //((int)maptemp.size())<((int)answer.size())
			messageBox.setText("此局無解");
			GameStatusController.gameMode = Mode.none;
		}		
		RightControlPanel.checkButtonStatus();	
	}
	
	//目前僅可在八皇后的情況下運作
	/**
	 * 設定左邊控制面板上"下一組解"按鈕的布局跟功能
	 * 
	 */
	private void setShowNextAnswerButton(){
		showNextAnswer = new JButton("下一組解");
		showNextAnswer.setFont(new Font("新細明體",Font.PLAIN, 40));
		
		constraints.gridx= 1;
		constraints.gridy= 8;
		constraints.gridwidth =4;
		constraints.gridheight = 2;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.insets=new Insets(50,0,50,0);
		leftLayout.setConstraints(showNextAnswer, constraints);
		
		showNextAnswer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ChessBoard.chessMoves.clear();
				if(GameStatusController.gameMode == Mode.demo){  //演算法模式下才可用
					String query = "eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]).";
					List result = GameInterface.infer_Eightqueens_SolutionDemo(query);				
					ListIterator<String> it = result.listIterator();				
					while(it.hasNext()){
						tempAnswer.add(it.next());
					}		
					if(flag<92){		   //flag 0 ~ 91最多共92次				
						String temp = tempAnswer.get(flag);
						for(int i =0 ;i <8; i++){
							int index = temp.indexOf("Y"+(i+1)+"=");
							String y = temp.substring(index+3,index+4);
							int coordinateY = Integer.valueOf(y)-1;
							ChessBoard.chessMoves.add(new int[]{i,coordinateY});
						}
						chessBoard.repaint();
						//messageBox.setText被寫死了 應該要能跟算出來的N皇后問題解數動態連結	
						messageBox.setText("八皇后問題共有92組解 目前是第"+(flag+1)+"種解");	
						flag++;
					}							
					if(flag == 92){      //if(flag == 92)被寫死了 應該要能跟算出來的N皇后問題解數動態連結	
						showNextAnswer.setEnabled(false);   //到了最後一組解 就不再按"下一組解"這個按鈕了
					}
				}							
			}					
		});		
		add(showNextAnswer);
	}
	
	/**
	 * 設定左邊控制面板上"   "按鈕的布局跟功能 目前沒有用到 等待以後擴充用所以設為完全不可見
	 * 
	 */
	private void setNoButton(){
		no = new JButton("     ");
		no.setFont(new Font("新細明體",Font.PLAIN, 40));
		no.setEnabled(false);
		constraints.gridx= 1;
		constraints.gridy= 10;
		constraints.gridwidth =4;
		constraints.gridheight = 2;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.insets=new Insets(50,0,50,0);
		leftLayout.setConstraints(no, constraints);
		/* 如果直接調用setVisible(false);
		 * 按鈕本來的區域會直接被覆蓋過去
		 * 要改為 不畫按鈕實際上的內容去達成隱藏但是占空間的按鈕
		 */
		no.setBorderPainted(false);     	//不畫按鈕的邊界
		no.setOpaque(false);            	//按鈕設為透明
		add(no);
	}
}