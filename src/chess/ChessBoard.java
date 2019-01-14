package chess;

/* 
 * ClassName		 :
 * ChessBoard 
 * 
 * Description 	     :
 * ���v�n�u�Ӥ@�ҵ{�M�a�t�δ����@�~ - �K�ӦZ�C��
 * �\��:�}�s�C���B���ѡB�\���K�ӬӦZ�i�H�T�{����
 *     �p��N�ӦZ���D���i��Ѽ�(N = 4 ~10)
 *     �i�H�i�ܥX�C�@�ؤK�ӦZ���D����
 * 
 * Author		     :
 * �\�ղE
 * 
 * History	         :	    
 * Date		 2016/11/16
 * Version   1.0
 * 
 * Copyright notice  :
 * �D�g��@�̱��v�\�i�A�T�������ŧ�C
 * 
 * ���Ӫ����:���c�ﵽ�[�c
 *          �Ѯv����ĳ:1.Chessboard���O���ӭn����  �Ҽ{�b�t�d�B�zgui���a��Τ@�ӰƵ{���h�I�sø(N���ѽL)�Ϫ��覡	
 * 					  2.��j�w�bLeft/Right/MidJPanel�ƦܬOChessboard�̪��ݩʵ��󥭤�
 *                      �]�N�O����JFrame���O�U�i��ŧi�A�o�˳o���ܼƴN�ܦ�����i��
 *          �ﵽ�걵�r�ꪺ�į�
 *          GameInterface���O�����\��Ӧh�n��L�̤��X��
 *          ��L�ѷӵ��Ѷi����
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
 * �t�dø�s�M�إߴѽL�A�x�s�M�ާ@��L���ӦZ��m�A�٦����Ѫ��\��C
 * 
 * @note �K�ӦZ�C��
 * @author 	�\�ղE
 * @version 1.0
 * 
 */

public class ChessBoard extends JPanel{	
	private static final long serialVersionUID = 1L;
	private int grids ;
	private Dimension chessView;
	private Image queen;              		//�ѽL�W�ӦZ��icon
	private int chessWidth ;          		//��e�ѽL���e��
	private int chessHeight ;         		//��e�ѽL������
	private	int chessBoardMinLength;  		//��e�ѽL�e�שM���ר�ӭȤ��̤p�����@��
	private	int cell;   					//�ѽL��l�j�p
	private int space; 						//�ѽL��JPanel��ɤ����d�դj�p
	private int x;  						//�ƹ��b�ѽL�W�I����m��X�y��
	private int y;  						//�ƹ��b�ѽL�W�I����m��Y�y��
	private int coordinateX ;     			//�ѽL��X�y��
	private int coordinateY ; 			 	//�ѽL��Y�y��
	private int[][] poistionOccupied;     	//�P�_�ѽL��l�W�O�_���Ѥl
	static ArrayList<int[]> chessMoves ;  	//�Ȯ��x�s�Ѥl�U�L���B��
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
	 * ��l�ƴѽL����(N*N���ѽL)�B�ӦZ�ϼСC
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
                System.out.println("�oC"); 
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
			
					  System.out.println("�oC"); 
               
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
                System.out.println("�oB"); 
                break; 
            case 7: 
                System.out.println("�oC"); 
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
            System.out.println("�oC"); 
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
	 * ��l�ƴѽL���A�B�Ѥl�Ȧs�MMouseListener
	 */
	//MouseListener���G�����Ӧb�o��Q��l�� �Ҽ{����W�@�h
	public void initialize(){
		setBackground(Color.GRAY);				
		poistionOccupied= new int[grids][grids];
		chessMoves = new ArrayList<int[]>();
		addMouseListener(placeQueenHandler);
	}
	
	/**
	 * ���ѡA�^��W�@��Ѫ��ѽL���A
	 */
	public void undo(){
		
		int index = chessMoves.size();
		int[] lastmove = chessMoves.get(index-1);  
		int x = lastmove[0];
		int y = lastmove[1];
		
		chessMoves.remove(index-1);				//�����̫�U�Ӫ����B��  �Ѥl�U�L���Ȧs-1
		poistionOccupied[x][y] = 0;				//��ӨB�Ѫ�poistionOccupied�k0
		//���ӭn��checkButtonStatus()�������i�����a��		RightControlPanel.checkButtonStatus();  //�ˬd���s���A
	}
	
	/**
	 * �Ǧ^�����C���ثe�U�L���ӦZ��
	 * 
	 * @return �����C���ثe�U�L���ӦZ��
	 */
	public int getChessMovesCount(){
		return chessMoves.size();
	}
	
	public void testATFD(){
		RightControlPanel rcp = new RightControlPanel(new ChessBoard(4)); 
		rcp.initialize();
	}
	
	/**
	 * �ˬdJPanel��e���e�A�åH���p��X�̾A�X����e�����j�p���ѽL���e�M�ѽL��l�H�ίd�յ��Ѽ�
	 */
	//��sJPanel�M���e �ѽL��l�j�p���Ѽ�
	public void checkView(){
		chessView = this.getSize();					//�ˬdJPanel��e���e
		chessWidth = chessView.width;
		chessHeight = chessView.height;
		
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){
			chessBoardMinLength = chessHeight;
			cell = chessBoardMinLength/grids;       //�ѽL��l�j�p = ��e�ѽL�e�שM���ר�ӭȤ��̤p�����@�Ӱ��H�ѽL����
			space= (chessWidth-chessHeight)/2;      //�d�լO��ѽL�m�� ���䳣���ۦP�j�p���d�հ϶�
		}else{
			chessBoardMinLength = chessWidth;
			cell = chessBoardMinLength/grids;
			space= (chessHeight-chessWidth)/2;
		}
	}
	
	/**
	 * �e�ѽL��l
	 * 
	 * @param g
	 */

	public void drawGrids(Graphics g){
		chessView = this.getSize();
		chessWidth = chessView.width;
		chessHeight = chessView.height;
		
		//�����e�����j�p�̤p�����μe �A�e��N*N�ѽL
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){
			chessBoardMinLength = chessHeight ;
			cell = chessBoardMinLength/grids;
			space= (chessWidth-chessHeight)/2;          //�|�P�d�� �ݪ���e���Ӥ���� ����N�ݭn�d�� 
				                                        //�a�W�[�d�հϰ�]�wø�Ϫ�l��m�s�y�m���ĪG							
			//�W��				
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
	 * �e�ѽL��u
	 * 
	 * @param g
	 */

	public void drawLines(Graphics g){
		g.setColor(Color.BLACK);
		
		//�@���e�@��������@��� �ѽL���X���N�e�X��
		for(int i = 0;i<=grids;i++){	
			chessView = this.getSize();
			chessWidth = chessView.width;
			chessHeight = chessView.height;
		
			//�����e�����j�p�̤p�����μe �A�e��8*8�ѽL
			//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
			if(chessWidth > chessHeight){
				chessBoardMinLength = chessHeight ;
				cell = chessBoardMinLength/grids;
				//�Ҽ{��space�ʸ˰_�� space = ����e������� �o�˴N���ݭn�P�_���e���Ӫ��Ȥ���j�F
				space= (chessWidth-chessHeight)/2;          //�|�P�d�� �ݪ���e���Ӥ���� ����N�ݭn�d�� 
				                                            //�a�W�[�d�հϰ�]�wø�Ϫ�l��m�s�y�m���ĪG							
				g.drawLine(0+space, i*cell , grids*cell+space, i*cell);		
				//��u �q(space,i*cell)��(grids*cell+space,i*cell)���e�@�����u
				//i*cell�N��F�C��for�j�驹�U�e�U�@�����u��Y�y�Ф@�w�O��W�@��((i-1)*cell)�Z���@�ӴѽL�檺�Z��
				g.drawLine(i*cell+space, 0 , i*cell+space, grids*cell);		
				//���u �q(i*cell+space,0)��(i*cell+space,grids*cell)���e�@�����u
				//+space�O�ҵe�X�ӷ|�bJPanel������	
			}else{
				chessBoardMinLength = chessWidth ;
				cell = chessBoardMinLength/grids;
				cell = chessBoardMinLength/grids;
				space= (chessHeight-chessWidth)/2;		    //�|�P�d�� �ݪ���e���Ӥ���� ����N�ݭn�d�� 
															//�a�W�[�d�հϰ�]�wø�Ϫ�l��m�s�y�m���ĪG																		
				g.drawLine(0, i*cell+space , grids*cell, i*cell+space);		//��u
				g.drawLine(i*cell, 0+space , i*cell, grids*cell+space);		//���u
			}								
		}
	}
	
	//M���{���X �Ҽ{���c
	/**
	 * �e�X�¦⪺�ѽL��l
	 * 
	 * @param g
	 */
	public void paintBlackGrids(Graphics g){
		g.setColor(Color.BLACK);
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){
			for(int i=0 ; i<grids ;i++){   //Y��V�`�� �`���K��
				//�Ĥ@�� �ˬd�_�Ʀ�
				for(int j=0 ;j<grids ;j++){  //X��V�`�� �e�_�Ʀ檺�®�
					if(j%2!=0){
						g.fillRect(0+space+j*cell, i*cell , cell, cell);									   						
					}					
				}			
				//�ĤG�� �ˬd���Ʀ�
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2==0){   //X��V�`�� �e���Ʀ檺�®�
						g.fillRect(0+space+j*cell, i*cell , cell, cell);																	
					}								
				}
			}
		}else{     //Height > Width
			for(int i=0 ; i<grids ;i++){   //Y��V�`�� �`���K��
				//�Ĥ@�� �ˬd�_�Ʀ�
				for(int j=0 ;j<grids ;j++){  //X��V�`�� �e�_�Ʀ檺�®�
					if(j%2!=0){
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);				
					}					
				}			
				//�ĤG�� �ˬd���Ʀ�
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2==0){   //X��V�`�� �e���Ʀ檺�®�
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);
					}								
				}
			}
		}
	}
	
	/**
	 * �e�X�զ⪺�ѽL��l
	 * 
	 * @param g
	 */
	public void paintWhiteGrids(Graphics g){
		g.setColor(Color.WHITE);
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){
			for(int i=0 ; i<grids ;i++){   //Y��V�`�� �`���K��
				//�Ĥ@�� �ˬd�_�Ʀ�
				for(int j=0 ;j<grids ;j++){  //X��V�`�� �e�_�Ʀ檺�ծ�
					if(j%2==0){
						g.fillRect(0+space+j*cell, i*cell , cell, cell);																					   						
					}					
				}			
				//�ĤG�� �ˬd���Ʀ�
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2!=0){   //X��V�`�� �e���Ʀ檺�ծ�
						g.fillRect(0+space+j*cell, i*cell , cell, cell);																	
					}								
				}
			}
		}else{     //Height > Width
			for(int i=0 ; i<grids ;i++){   //Y��V�`�� �`���K��
				//�Ĥ@�� �ˬd�_�Ʀ�
				for(int j=0 ;j<grids ;j++){  //X��V�`�� �e�_�Ʀ檺�ծ�
					if(j%2==0){
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);								
					}					
				}			
				//�ĤG�� �ˬd���Ʀ�
				i++;
				for(int j=0 ; j<grids ;j++){				
					if(j%2!=0){   //X��V�`�� �e���Ʀ檺�ծ�
						g.fillRect(j*cell, 0+space+i*cell, cell, cell);
					}								
				}
			}
		}		
	}
	
	/**
	 * �e�X�Ѥl�B�ƼȦs�����Ҧ��ӦZ
	 * 
	 * @param g
	 */
	private void drawAllQueens(Graphics g){
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){	
			Iterator<int[]> it = chessMoves.iterator();	
			while(it.hasNext()){				
				int[] moves  = it.next();				
				//�}�o�ɼȮɥN���ӦZ�ϼЪ��L�Ѥl��k
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
	
	
	//�ƹ��I����Ѥl
	private MouseListener placeQueenHandler= new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			x=e.getX();
			y=e.getY();
			
			if(GameStatusController.gameMode == Mode.normal){         //�C���Ҧ��U�~�i�\��Ѥl
				//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
				if(chessWidth > chessHeight){
					if(x<=chessBoardMinLength+space && x>=0+space && y<=chessBoardMinLength && y>=0){
						//�}�o��DEBUG�� �����{�b�ٯण��B�@ �Ҽ{����
						//System.out.println("W>H�@");
						//System.out.println(chessBoardMinLength+"�@"+space+" "+cell);
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
	 * �ˬd�ثe�o�B�ण�ন�\�\����x�s 
	 * 
	 * @param x �ثe�o�B�b�ѽL�W��X�y��
	 * @param y �ثe�o�B�b�ѽL�W��Y�y��
	 */
	private void recordChessMoves(int x, int y){	
		if(chessMoves!=null  && chessMoves.size()<8){	 //chessMoves.size()<8 8���ӭn�令N ��N�ӦZ���D�ʺA���X
			//�z�L�ˬdpoistionOccupied�o��flag�ӧP�_��l�O�_�Q�e��  �i�ӱư��w�g�U�L���B��
			if(poistionOccupied[x][y] == 0){
				poistionOccupied[x][y] = 1;
				chessMoves.add(new int[]{x,y});
				RightControlPanel.checkButtonStatus();    //�ˬd��e���s���A �p�G�ѽL�Ȧs���F �N������ҵ���
			}
		}		
	}
		
	/*
	//�L�X�U�L���C�@�B   �}�o��DEBUG�� �����{�b�ٯण��B�@ �Ҽ{����
	private void printChessMoves(){
		if(chessMoves!=null){
			Iterator<int[]> it = chessMoves.iterator();
			int i = 0;		
			while(it.hasNext()){				
				int[] moves  = it.next();				
				System.out.println("��"+(i+1)+"�B�U�b�y��("+moves[0]+","+moves[1]+")");
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
	 * �p���e�ƹ��I����m�����쪺�ѽLX�y��(0~7)
	 * 
	 * @param x ��e�ƹ��b����W�I����X�y��
	 * @return  �ƹ��I������m������ѽL�W��X�y��
	 */
	private int getXCoordinate(int x){
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){
			for(int i = 0 ; i<grids ;i++){
				if(x>=i*cell+space && x<(i+1)*cell+space)
					return i;
			}			
			return grids-1;      //���p��cell�ɩ������p���I�i��y���᭱���{�ɰ϶��P�w���~ �areturn grids-1�ӭץ�
			                     //�p�G�ѽL���Ƨ�j���Ӥ���o�˧� �Ҽ{��cell��o���T �ݯण����p���I��ĤG��
		}else{   //chessHeight > chessWidth
			for(int i = 0 ; i<grids ;i++){
				if(x>=i*cell && x<(i+1)*cell)
					return i;
			}		
			return grids-1;
		}
	}
	
	/**
	 * �p���e�ƹ��I����m�����쪺�ѽLY�y��(0~7)
	 * 
	 * @param y ��e�ƹ��b����W�I����Y�y��
	 * @return	�ƹ��I������m������ѽL�W��Y�y��
	 */
	private int getYCoordinate(int y){
		//�Ҽ{��o�ӧP�_�M���򪺰���ʸ˰_�ө�b����i�����a�� �]��if(chessWidth > chessHeight)��b�ӱ`�Ψ�F
		if(chessWidth > chessHeight){
			for(int i = 0 ; i<grids ;i++){
				if(y>=i*cell && y<(i+1)*cell)
					return i;
			}		
			return grids-1;		//���p��cell�ɩ������p���I�i��y���᭱���{�ɰ϶��P�w���~ �areturn grids-1�ӭץ�
								//�p�G�ѽL���Ƨ�j���Ӥ���o�˧� �Ҽ{��cell��o���T �ݯण����p���I��ĤG��
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
		//���e�ѽL��A�A�e�Ѥl�A�̫�e�u
		//���M���e�Ѥl���ܡA�Ѥl�|�Q�ѽL��\���C�P�z�A�u���̫�e���ܷ|�Q�Ѥl��ѽL�\��
		
		
/* 		//�u�n�M�ŴѽL�Ȧs���n�N�� �n�������]�S���t �ݬ�s 
		if(x!=0 && y!= 0){					
			x=0;
			y=0;		
			coordinateX = 0;
			coordinateY = 0;
		}
		*/
	}
}