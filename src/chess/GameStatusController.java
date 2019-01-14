package chess;

/* 
 * ClassName		 :
 * GameStatusController 
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

/**
 * 負責處理遊戲模式狀態的控制
 * 
 * @note 八皇后遊戲
 * @author 	許博淳
 * @version 1.0
 * 
 */

public class GameStatusController {
	//private static boolean inCheatMode  = false;   //以後控制作弊模式開啟的flag 目前無作用
	static Mode gameMode;						//遊戲模式狀態
	public static int test2 =2;
	/*
	 * 總是透過直接存取gameMode屬性來進行操作 要重構 考慮把GameStatusController類別取消
	 * 直接在全域變數設定gameMode屬性就好
	 * 
	 */
		
	/**
	 * 初始化遊戲模式
	 * 
	 */
	
	public void initialize(){
		setgameMode(Mode.none);
		
	}
	
	/**
	 * 更改遊戲模式
	 * 
	 * @param mode 要進入的遊戲模式
	 */
	
	public void setgameMode(Mode mode ){
		gameMode = mode;	
	}
	
}