package chess;

/* 
 * ClassName		 :
 * GameInterface 
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
 *          在擺放八個皇后之後 應該要可以按驗證答案 但是不能按立刻完成
 *          考慮新增白色的皇后 在白格放黑色的皇后 在黑格放白色的皇后
 *          
 * 
 */

import org.jpl7.Term;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.LineBorder;
//畫邊框用的

/**
 * GameInterface負責建立主要的MainFrame、處理其他JPanel的初始化跟布局、啟動計時器、設定message
 * 
 * @note 八皇后遊戲
 * @author 許博淳
 * @version 1.0
 * 
 */

public class GameInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	Container contentPane;
	static LeftControlPanel leftControlPanel;
	static RightControlPanel rightControlPanel;
	static JPanel midShowPanel;
	static ChessBoard chessBoard;
	//ChessBoard chessBoard;
	static JLabel messageBox;
	GridBagLayout mainLayout;
	private static Timer gameTimer;
	private static long timerStartTime;
	
	//private Prolog prolog;
	private GameStatusController controller;

	final private static String FOURQUEENS_RULEBASE = "four_queens.pl";
	final private static String FIVEQUEENS_RULEBASE = "five_queens.pl";
	final private static String SIXQUEENS_RULEBASE = "six_queens.pl";
	final private static String SEVENQUEENS_RULEBASE = "seven_queens.pl";
	final private static String EIGHTQUEENS_RULEBASE = "eight_queens.pl";
	final private static String NINEQUEENS_RULEBASE = "nine_queens.pl";
	final private static String TENQUEENS_RULEBASE = "ten_queens.pl";

	/**
	 * 初始化遊戲狀態
	 * 
	 * @param defaultchessBoard
	 *            是傳入的棋盤
	 */
	public GameInterface(ChessBoard defaultchessBoard) {
		super("八皇后遊戲");
		chessBoard = defaultchessBoard;
		//this.prolog = new Prolog();
		initialize();
	}

	/**
	 * 具體的初始化內容。初始化控制器，Layout，ContentPane跟各個JPanel
	 * 
	 */
	public void initialize() {
		controller = new GameStatusController();
		controller.initialize();

		contentPane = getContentPane();
		mainLayout = new GridBagLayout();

		contentPane.setLayout(mainLayout);

		midShowPanel = new JPanel();
		setMidShowPanel(midShowPanel);

		leftControlPanel = new LeftControlPanel(chessBoard, messageBox);
		setLeftControlPanel(leftControlPanel);

		LeftControlPanel.completeNow.setEnabled(false);
		LeftControlPanel.showNextAnswer.setEnabled(false);

		rightControlPanel = new RightControlPanel(chessBoard);
		setRightControlPanel(rightControlPanel);
		RightControlPanel.checkButtonStatus();

		contentPane.add(leftControlPanel);
		contentPane.add(midShowPanel);
		contentPane.add(rightControlPanel);

		setPreferredSize(new Dimension(1800, 1800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}

	/**
	 * 設定MidShowPanel的布局位置和Constraints屬性 ，最後進行初始化。
	 * 
	 * 待補充
	 * 
	 * @param midJPanel
	 *            要進行設定的JPanel(JPanel元件)
	 * 
	 */

	public void setMidShowPanel(JPanel midJPanel) {
		GridBagConstraints constraints_MidControlPanel = new GridBagConstraints();

		constraints_MidControlPanel.gridx = 2;
		constraints_MidControlPanel.gridy = 0;
		constraints_MidControlPanel.gridwidth = 4;
		constraints_MidControlPanel.gridheight = 4;
		constraints_MidControlPanel.fill = GridBagConstraints.BOTH;
		constraints_MidControlPanel.weightx = 800;
		constraints_MidControlPanel.weighty = 800;

		mainLayout.setConstraints(midJPanel, constraints_MidControlPanel);
		midShowPanelInitialize(midJPanel, chessBoard);
	}

	/**
	 * 設定LeftControlPanel的布局位置和Constraints屬性 ，最後進行初始化。
	 * 
	 * 待補充
	 * 
	 * @param midJPanel
	 *            要進行設定的LeftControlPanel(JPanel元件)
	 * 
	 */

	public void setLeftControlPanel(LeftControlPanel leftJPanel) {
		GridBagConstraints constraints_LeftControlPanel = new GridBagConstraints();

		constraints_LeftControlPanel.gridx = 0;
		constraints_LeftControlPanel.gridy = 0;
		constraints_LeftControlPanel.gridwidth = 2;
		constraints_LeftControlPanel.gridheight = 4;
		constraints_LeftControlPanel.weightx = 100;
		constraints_LeftControlPanel.weighty = 100;
		constraints_LeftControlPanel.fill = GridBagConstraints.BOTH;

		mainLayout.setConstraints(leftJPanel, constraints_LeftControlPanel);
		leftJPanel.setBackground(Color.GRAY);
		leftJPanel.initialize();
	}

	/**
	 * 設定RightControlPanel的布局位置和Constraints屬性 ，最後進行初始化。
	 * 
	 * 待補充
	 * 
	 * @param midJPanel
	 *            要進行設定的RightControlPanel(JPanel元件)
	 */

	public void setRightControlPanel(RightControlPanel rightJPanel) {
		GridBagConstraints constraints_RightControlPanel = new GridBagConstraints();

		constraints_RightControlPanel.gridx = 6;
		constraints_RightControlPanel.gridy = 0;
		constraints_RightControlPanel.gridwidth = 2;
		constraints_RightControlPanel.gridheight = 4;
		constraints_RightControlPanel.weightx = 50;
		constraints_RightControlPanel.weighty = 50;
		constraints_RightControlPanel.fill = GridBagConstraints.BOTH;

		mainLayout.setConstraints(rightJPanel, constraints_RightControlPanel);
		rightJPanel.setBackground(Color.GRAY);
		rightJPanel.initialize();
	}

	/**
	 * 初始化MidShowPanel，MidJPanel上面有一個ChessBoard(JPanel元件)和MessageBox(JLabel元件)
	 * 
	 * @param midJPanel
	 *            要進行設定的MidShowPanel
	 * @param chessBoard
	 *            要加入MidJPanel中的ChessBoard元件
	 */

	public void midShowPanelInitialize(JPanel midJPanel, ChessBoard chessBoard) {
		midJPanel.setBackground(Color.YELLOW);
		GridBagLayout midJPanelLayout = new GridBagLayout();
		midJPanel.setLayout(midJPanelLayout);
		//setMidShowPanel_ChessBoard(chessBoard); // 好像沒有用 待Debug 如果無用處就做廢

		GridBagConstraints constraints_MidPanel_ChessBoard = new GridBagConstraints();
		constraints_MidPanel_ChessBoard.gridx = 0;
		constraints_MidPanel_ChessBoard.gridy = 0;
		constraints_MidPanel_ChessBoard.gridwidth = 4;
		constraints_MidPanel_ChessBoard.gridheight = 4;
		constraints_MidPanel_ChessBoard.weightx = 1200;
		constraints_MidPanel_ChessBoard.weighty = 1200;
		constraints_MidPanel_ChessBoard.fill = GridBagConstraints.BOTH;
		constraints_MidPanel_ChessBoard.anchor = GridBagConstraints.CENTER;
		midJPanelLayout.setConstraints(chessBoard, constraints_MidPanel_ChessBoard);

		midJPanel.add(chessBoard); // 新建棋盤

		messageBox = new JLabel("", SwingConstants.CENTER);
		messageBox.setFont(new Font("標楷體", Font.PLAIN, 50));
		initializeMidShowPanel_MessageBox(messageBox);

		GridBagConstraints constraints_MidPanel_MessageBox = new GridBagConstraints();
		constraints_MidPanel_MessageBox.gridx = 0;
		constraints_MidPanel_MessageBox.gridy = 4;
		constraints_MidPanel_MessageBox.gridwidth = 4;
		constraints_MidPanel_MessageBox.gridheight = 1;
		constraints_MidPanel_MessageBox.weightx = 0;
		constraints_MidPanel_MessageBox.weighty = 0;
		midJPanelLayout.setConstraints(messageBox, constraints_MidPanel_MessageBox);

		midJPanel.add(messageBox); // 新建顯示訊息列
	}

	/**
	 * 好像沒有用 待Debug 如果無用處就做廢
	 * 
	 * @param chessBoard
	 */
	/*
	 * public static void setMidShowPanel_ChessBoard(JPanel chessBoard){
	 * //chessBoard.setBorder(new LineBorder(Color.RED)); //JPANEL外框
	 * chessBoard.setPreferredSize(new Dimension());
	 * 
	 * }
	 */

	/**
	 * 初始化進入遊戲的歡迎訊息和遊戲狀態並初始化計時器
	 * 
	 * @param messageBox
	 *            負責輸出歡迎訊息的JLabel元件
	 */

	// 考慮把初始化遊戲狀態移到別的地方去處理
    public static void initializeMidShowPanel_MessageBox(JLabel messageBox) {
		messageBox.setText("歡迎進入遊戲");
		GameStatusController.gameMode = Mode.none;
		showTimer(messageBox);
	}

	/**
	 * 將計時器歸零
	 * 
	 */

	public static void setTimerStartTime() {
		timerStartTime = System.currentTimeMillis();
	}

	// 遊戲計時功能

	/**
	 * 初始化計時器
	 * 
	 * actionPerformed待補充
	 * 
	 * @param messageBox
	 *            負責輸出此局遊戲經過多久時間的JLabel元件
	 */

	private static void showTimer(JLabel messageBox) {
		
		gameTimer = new Timer(100, new ActionListener() {
			int hourPassed = 0;
			int minutePassed = 0;
			int secondPassed = 0;

			public void actionPerformed(ActionEvent e) {
				if (GameStatusController.gameMode == Mode.normal) {
					messageBox.setText("開始計時");

					long currentTime = System.currentTimeMillis();
					int timePassed = (int) (currentTime - timerStartTime) / 1000;

					if (timePassed >= 60 * 60) { // 3600秒一小時 遊戲開始後滿一小時以上
						hourPassed = (timePassed) / 3600; // 可能有錯
						minutePassed = ((timePassed) % 3600) / 60; // 可能有錯
						secondPassed = (timePassed) % 60; // 可能有錯

						messageBox.setText("過了" + hourPassed + "時" + minutePassed + "分" + secondPassed + "秒");
					} else if (timePassed < 3600 && timePassed >= 60) { // 60秒一分鐘
																		// 遊戲開始後滿一分鐘
																		// 未滿一小時
						minutePassed = (timePassed) / 60;
						secondPassed = (timePassed) % 60;

						messageBox.setText("過了" + minutePassed + "分" + secondPassed + "秒");
					} else { // timePassed<60 遊戲開始後未滿一分鐘
						messageBox.setText("過了" + timePassed + "秒");
					}
				}
			}
		});
		gameTimer.start();
	}

	/**
	 * 連結prolog檔案並對八皇后棋局是否為正確解答做出對應的動作。 如果此局是正確解答之一則停止計時器並改變輸出的訊息。
	 * 如果此局不是正確解答則跳出小視窗告知使用者答案錯誤。
	 * 
	 * @param query
	 *            傳給SWI-prolog判斷八皇后問題true of false的語句
	 */

	static void infer_Eightqueens_Solution_TrueorFalse(String query) {
		/*
		 * 以後應該要隨著傳入N皇后而動態改變連結的prolog檔案 方法也需要重新命名 以後可能會多一個參數size 代表棋盤大小 也代表N皇后問題
		 */
		Prolog.link(EIGHTQUEENS_RULEBASE); // 與prolog檔案進行連結

		if (Prolog.drive_TrueORFalse(query)) { // 呼叫Prolog類別內的方法進行判斷此局是正確解答之一
			messageBox.setText("Bingo"); // 停止計時器
			GameStatusController.gameMode = Mode.none;
		} else { // 此局不是正確解答
			JOptionPane.showMessageDialog(null, "請再檢查看看", "答案錯誤", JOptionPane.ERROR_MESSAGE);
			// 顯示小視窗告知使用者答案錯誤
		}

	}

	/**
	 * 連結prolog檔案並傳回所有八皇后問題可行解的串列。
	 * 
	 * @param query
	 *            傳給SWI-prolog判斷八皇后問題可行解有哪些的語句
	 * @return 所有八皇后問題可行解
	 */

	static List infer_Eightqueens_SolutionDemo(String query) {
		/*
		 * 以後應該要隨著傳入N皇后而動態改變連結的prolog檔案 方法也需要重新命名 以後可能會多一個參數size 代表棋盤大小 也代表N皇后問題
		 */
		Prolog.link(EIGHTQUEENS_RULEBASE); // 與prolog檔案進行連結
		List result = Prolog.drive_demo(query); // 呼叫Prolog類別內的方法並傳回可行的答案串列
		return result;
	}

	/**
	 * 連結prolog檔案並判斷當前八皇后棋局可能有哪些可行解。 若無解則則改變輸出給使用者的訊息並停止計時器。 若有解則自動完成剩餘的棋局。
	 * 
	 * @param query
	 *            傳給SWI-prolog判斷當前八皇后棋局可能有哪些可行解的語句
	 */

	static void infer_Eightqueens_Solution(String query) {
		/*
		 * 以後應該要隨著傳入N皇后而動態改變連結的prolog檔案 方法也需要重新命名 以後可能會多一個參數size 代表棋盤大小 也代表N皇后問題
		 */
		
		Prolog.link(EIGHTQUEENS_RULEBASE); // 與prolog檔案進行連結
		if (Prolog.drive_TrueORFalse(query)) { // 當前八皇后棋局有解
			List result = Prolog.drive(query); // 呼叫Prolog類別內的方法並傳回此局可行的答案串列
			/*
			 * 把SWI Prolog傳回來的八皇后問題答案串列擷取成字串
			 */
			Iterator<Map<String, Term>> it = result.iterator();
			String temp = new String();
			while (it.hasNext()) {
				Map<String, Term> key = it.next();
				temp = key.toString();
			}

			/*
			 * 把SWI Prolog傳回來的八皇后問題答案串列擷取成字串後再把字串轉成座標
			 */
			for (int i = 0; i < 8; i++) { // Y1到Y8
				int index = temp.indexOf("Y" + (i + 1)); // 抓取對應的字串 index的值
				if (index != -1) { // 如果沒有抓到對應的字串 index的值就會是-1
					String count = temp.substring(index + 3, index + 4);
					int coordinateY = Integer.valueOf(count) - 1;
					ChessBoard.chessMoves.add(new int[] { i, coordinateY });
				}
			}

			chessBoard.repaint();
			GameStatusController.gameMode = Mode.none;
		} else { // 若當前八皇后棋局無解則改變輸出給使用者的訊息並停止計時器
			messageBox.setText("此局無解");
			GameStatusController.gameMode = Mode.none;
		}
	}

	/**
	 * 算出八皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92 ,Y8=... 要研究一下
	 */
	static void infer_Eightqueens_Solutionnum() {
		/*
		 * 以後應該要隨著傳入N皇后而動態改變連結的prolog檔案 方法也需要重新命名 以後可能會多一個參數size 代表棋盤大小 也代表N皇后問題
		 */
		Prolog.link(EIGHTQUEENS_RULEBASE);
		List result = Prolog.drive(
				"findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8],eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			/* 這部分被寫死了 應該要能抓到動態的資料長度 而不是依靠lastIndexOf(Y8)來判斷 */
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("Y8");
			String count = temp.substring(firstindex + 3, lastindex - 2);

			messageBox.setText("八皇后問題共有" + count + "組解");
		}
	}

	/**
	 * 算出九皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92 ,Y8=... 要研究一下 這個方法感覺是多餘的
	 * 如果以後能隨著傳入N皇后而動態改變連結的prolog檔案應該就不需要這個方法了
	 */
	static void infer_Ninequeens_Solutionnum() {
		Prolog.link(NINEQUEENS_RULEBASE);
		List result = Prolog.drive(
				"findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8,Y9],nine_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8),(9,Y9)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("Y8");
			String count = temp.substring(firstindex + 3, lastindex - 2);

			messageBox.setText("九皇后問題共有" + count + "組解");
		}
	}

	/**
	 * 算出十皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92 ,Y8=... 要研究一下 這個方法感覺是多餘的
	 * 如果以後能隨著傳入N皇后而動態改變連結的prolog檔案應該就不需要這個方法了
	 */
	static void infer_Tenqueens_Solutionnum() {
		Prolog.link(TENQUEENS_RULEBASE);
		List result = Prolog.drive(
				"findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8,Y9,Y10],ten_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8),(9,Y9),(10,Y10)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("Y8");
			String count = temp.substring(firstindex + 3, lastindex - 2);

			messageBox.setText("十皇后問題共有" + count + "組解");
		}
	}

	/**
	 * 算出七皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92} 要研究一下 這個方法感覺是多餘的
	 * 如果以後能隨著傳入N皇后而動態改變連結的prolog檔案應該就不需要這個方法了
	 */
	static void infer_Sevenqueens_Solutionnum() {
		Prolog.link(SEVENQUEENS_RULEBASE);
		List result = Prolog.drive(
				"findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7],seven_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("}");
			String count = temp.substring(firstindex + 3, lastindex);

			messageBox.setText("七皇后問題共有" + count + "組解");
		}
	}

	/**
	 * 算出六皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92} 要研究一下 這個方法感覺是多餘的
	 * 如果以後能隨著傳入N皇后而動態改變連結的prolog檔案應該就不需要這個方法了
	 */
	static void infer_Sixqueens_Solutionnum() {
		Prolog.link(SIXQUEENS_RULEBASE);
		List result = Prolog.drive(
				"findall([Y1,Y2,Y3,Y4,Y5,Y6],six_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("}");
			String count = temp.substring(firstindex + 3, lastindex);

			messageBox.setText("六皇后問題共有" + count + "組解");
		}
	}

	/**
	 * 算出五皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92} 要研究一下 這個方法感覺是多餘的
	 * 如果以後能隨著傳入N皇后而動態改變連結的prolog檔案應該就不需要這個方法了
	 */
	static void infer_Fivequeens_Solutionnum() {
		Prolog.link(FIVEQUEENS_RULEBASE);
		List result = Prolog
				.drive("findall([Y1,Y2,Y3,Y4,Y5],five_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("}");
			String count = temp.substring(firstindex + 3, lastindex);

			messageBox.setText("五皇后問題共有" + count + "組解");
		}
	}

	/**
	 * 算出四皇后問題有幾組解
	 * 
	 */

	/*
	 * 為什麼key.toString()出來會是 ...N=92} 要研究一下 這個方法感覺是多餘的
	 * 如果以後能隨著傳入N皇后而動態改變連結的prolog檔案應該就不需要這個方法了
	 */
	static void infer_Fourqueens_Solutionnum() {
		Prolog.link(FOURQUEENS_RULEBASE);
		List result = Prolog.drive("findall([Y1,Y2,Y3,Y4],four_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("}");
			String count = temp.substring(firstindex + 3, lastindex);

			messageBox.setText("四皇后問題共有" + count + "組解");
		}
	}

	public static void main(String args[]) {
		new GameInterface(new ChessBoard(8));
	}
}