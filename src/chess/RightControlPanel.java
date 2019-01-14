package chess;


/* 
 * ClassName		 :
 * RightControlPanel 
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
 *          �ץ��ߨ觹����k��bug
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
 * �]�w�k�䱱��O�������򭱪O�W�����s����
 * 
 * @note �K�ӦZ�C��
 * @author 	�\�ղE
 * @version 1.0
 * 
 */

public class RightControlPanel extends JPanel{
	private static ChessBoard chessBoard;	
	//private Image queenImage;        		//���ӭn��b��ܳѤU���ӦZ�Ʈ��䪺�Ϯ� ���ݥH���@   
	private JLabel imageLabel;          	//�ӤW ��m�ӹϮת��ϰ� �ثe����
	private static JLabel queenLeft;    	//��ܦb�C���Ҧ��U�ثe�ٳѤU�X�ӬӦZ�n�\
	private static JButton newGame;    		//"���}�s��"�����s
	private static JButton confirmAnswer;   //"�T�{����"�����s
	private static JButton undo;			//"����"�����s
	private static JButton startNormalGame; //"�@��C��"�����s
	private static JButton startDemo;		//"Demo"�����s
	private static JComboBox<Integer> selcetDemoGrids;   //Demo�Ҧ����demo�X���ѽL���U�Ԧ��M�� �̭������������OInteger
	private JLabel leftBlankArea;   		//����O���䪺�ťհϰ�
	private JLabel rightBlankArea;  		//����O�k�䪺�ťհϰ�
	private JLabel buttomBlankArea; 		//����O�U�誺�ťհϰ�
	private JLabel topBlankArea;			//����O�W�誺�ťհϰ�
	private GridBagLayout rightLayout;
	private GridBagConstraints constraints;	
	private static int demoGrids;			//Demo�Ҧ��ҰʮɤU�Ԧ��M��ҿ�ܪ�����
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
	 * ��l�ƥk�䱱��O
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
	 * �]�w�k�䱱��O�ťհϰ쪺��m�򥬧�
	 * 
	 */
	private void setBlankArea(){	
		//�k�䱱��O���䪺�ťհϰ�
		leftBlankArea = new JLabel();		
		constraints.gridx= 0;
		constraints.gridy= 0;
		constraints.gridwidth =1;
		constraints.gridheight = 14;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(leftBlankArea, constraints);
		
		//�k�䱱��O�W�誺�ťհϰ�		
		topBlankArea = new JLabel();				
		constraints.gridx= 1;
		constraints.gridy= 0;
		constraints.gridwidth =9;
		constraints.gridheight = 3;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(topBlankArea, constraints);
		
		//�k�䱱��O�k�䪺�ťհϰ�			
		rightBlankArea = new JLabel();		
		constraints.gridx= 5;
		constraints.gridy= 8;
		constraints.gridwidth =5;
		constraints.gridheight = 3;
		constraints.weightx= 10;
		constraints.weighty= 10;
		constraints.fill = GridBagConstraints.BOTH;
		rightLayout.setConstraints(rightBlankArea, constraints);
		
		//�k�䱱��O�U�誺�ťհϰ�
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
	 * �]�w��m�Ϯװϰ쪺���� �ثe�L�Ϯ׵��H��A�s�W�Ϯ�
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
	 * �]�w��ܬӦZ�ưϰ쪺����
	 * 
	 */
	public void setQueenLeft(){
		queenLeft = new JLabel();		
		queenLeft.setFont(new Font("�s�ө���",Font.PLAIN, 40));
		queenLeft.setText("�ѤU���ӦZ�� : " + (8-chessBoard.getChessMovesCount()));
		
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
	 * �]�w"���}�s��"���s�������M�\��
	 */
	public void setNewGame(){
		newGame = new JButton("���}�s��");
		newGame.setFont(new Font("�s�ө���",Font.PLAIN, 20));
		
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
				chessBoard.initialize();  			//��l�ƴѽL
				chessBoard.repaint();				//��ø�ѽL
				GameInterface.setTimerStartTime();  //�}�l�p��
				checkButtonStatus();							
			}					
		});
		
		add(newGame);
	}
	
	/**
	 * 
	 * �]�w"�T�{����"���s�������M�\��
	 */
	public void setConfirmAnswer(){
		confirmAnswer = new JButton("�T�{����");
		confirmAnswer.setFont(new Font("�s�ө���",Font.PLAIN, 20));
		
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
				//Ū���Ȧs�̪��y��
				//ChessBoard.chessMoves.size()==8 �o��Q�g���F ���ӭn��ѽL���ưʺA�s��
				if(ChessBoard.chessMoves!=null && ChessBoard.chessMoves.size()==8){
					Iterator<int[]> it = ChessBoard.chessMoves.iterator();
					//��map�ӱư���X�y�Э��ƪ����D
					HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();	
					while(it.hasNext()){				
						int[] moves  = it.next();	
						temp.put(moves[0],moves[1]);
					}
					//temp.size()!=8�o��Q�g���F ���ӭn��ѽL���ưʺA�s��
					if(temp.size()!=8){       //�K�ӴѨB���Ȧs�নmap�᪺size()!=8 �N��@��key�Ȫ�X�y�Ц����ƪ�
						JOptionPane.showMessageDialog(null, "�ЦA�ˬd�ݬ�","���׿��~",JOptionPane.ERROR_MESSAGE);
						//���X�p�����i���ϥΪ̥ثe���צ��~
					}else{      			
						confirmAnswer(temp);    //�ǤJSWI Prolog�i����
					}			
				}										
				checkButtonStatus();						
			}					
		});
		
		add(confirmAnswer);
	}
	
	/**
	 * 
	 * �]�w"����"���s�������M�\��
	 */
	public void setUndo(){
		undo = new JButton("����");
		undo.setFont(new Font("�s�ө���",Font.PLAIN, 20));	
		
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
	 * �]�w"�@��C��"���s�������M�\��
	 */
	public void setStartNormalGame(){
		startNormalGame = new JButton("�@��C��");
		startNormalGame.setFont(new Font("�s�ө���",Font.PLAIN, 20));		
		
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
					//�o�����򭫶}�s���@�� �i�H�Ҽ{�ʸ˦��@�ӷs��k
					chessBoard.initialize();  			//��l�ƴѽL
					chessBoard.repaint();				//��ø�ѽL				
					checkButtonStatus();
					GameInterface.setTimerStartTime();  //���s�}�l�p�ɾ�
				}
			}					
		});
		
		add(startNormalGame);
	}

	/**
	 * 
	 * �]�w"Demo"���s�������M�\��
	 */
	public void setStartDemo(){
		startDemo = new JButton("Demo");
		startDemo.setFont(new Font("�s�ө���",Font.PLAIN, 20));
		
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
				//�Pı�`�`�Ψ�H�U�T��  ���c���ɭԪ`�N�@�U
				chessBoard.initialize();  		//��l�ƴѽL
				chessBoard.repaint();			//��ø�ѽL
				checkButtonStatus();	
				GameInterface.messageBox.setText("�t��k�Ҧ�");
				if(selcetDemoGrids.getSelectedItem() != null){	
					//ChessBoard.getClass();
					
					demoGrids = (int) selcetDemoGrids.getSelectedItem();
					checkButtonStatus();	
					//�ھڿ�ܪ����� �s��������prolog�ɮ�
					//���ӧ�demoGrids�@���ѼƶǤJ �I�s�s��prolog����k �ѸӤ�k�̾ڰѼƧP�_�ӳs����prolog�ɮ�
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
	 * �]�wDemo�Ҧ����U�Ԧ��M�檺�����M�\��
	 */
	public void setDemoGrids(){
		selcetDemoGrids = new JComboBox<Integer>();		   //���M�椺���������OInteger����
		selcetDemoGrids.setFont(new Font("�s�ө���",Font.PLAIN, 20));
		
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
	
	
	//���ӭn��b�󰪪��h�� ������i��  �z�L����k�ӱ�����s���A �Ӥ��O�b�C���I���άO����F��� �I�s�@�ӧ��ܫ��s���A��setEnabled()��k
	/**
	 * 
	 * �̾ڥثe�C���Ҧ��M�ѧ����A�ˬd�ç�s���s���A
	 */
	public static void checkButtonStatus(){
		if(GameStatusController.gameMode == Mode.none){         	//none�Ҧ��U 
			newGame.setEnabled(false);								//���i�H�I��"���}�s��"���s
			confirmAnswer.setEnabled(false);						//���i�H�I��"�T�{����"���s
			undo.setEnabled(false);									//���i�H�I��"����"���s
			startNormalGame.setEnabled(true); 						//�i�H�I��"�@��C��"���s   ���|�|�ɭP�C���Ҧ��ഫ��normal�Ҧ�
			startDemo.setEnabled(true); 							//�i�H�I��"Demo"���s         ���|�|�ɭP�C���Ҧ��ഫ��demo�Ҧ�
			selcetDemoGrids.setEnabled(false);  					//���i�H�I��U�Ԧ��M��
			selcetDemoGrids.setSelectedIndex(0);					//��U�Ԧ��M���l��
			LeftControlPanel.completeNow.setEnabled(false);			//���i�H�I�����䱱��O��"�ߨ觹��"���s
			LeftControlPanel.showNextAnswer.setEnabled(false); 		//���i�H�I�����䱱��O��"�U�@�ո�"���s
					
			//���ӭn��M��flag������O���a��h��{  flag�O�Ψӭp��demo�Ҧ��ثedemo��ĴX�ոѥΪ� ��button���A�L��
			LeftControlPanel.flag = 0;		
		}else if (GameStatusController.gameMode == Mode.normal){  	//normal�Ҧ��U
			newGame.setEnabled(true);								//�i�H�I��"���}�s��"���s
			startNormalGame.setEnabled(false); 						//���i�H�I��"�@��C��"���s
			startDemo.setEnabled(true); 							//�i�H�I��"Demo"���s         ���|�|�ɭP�C���Ҧ��ഫ��demo�Ҧ�
			selcetDemoGrids.setEnabled(false);						//���i�H�I��U�Ԧ��M��
			selcetDemoGrids.setSelectedIndex(0);					//��U�Ԧ��M���l��
			LeftControlPanel.completeNow.setEnabled(true);			//�i�H�I�����䱱��O��"�ߨ觹��"���s
			LeftControlPanel.showNextAnswer.setEnabled(false);		//���i�H�I�����䱱��O��"�U�@�ո�"���s
			
			//���ӭn��M��flag�o�ӥ\�ಾ��O���a��h��{  flag�O�Ψӭp��demo�Ҧ��ثedemo��ĴX�ոѥΪ� ��button���A�L��
			LeftControlPanel.flag = 0;
			
			//(8-chessBoard.getChessMovesCount())== 0)�g���F ���ӭn��ʺA�s����ثe���ѽL����
			if((8-chessBoard.getChessMovesCount())== 0){  			//�p�G�������Ȧs�����ӦZ�S���񺡤K�� �N�����I��"�T�{����"���s
				confirmAnswer.setEnabled(true);
			}else{
				confirmAnswer.setEnabled(false);  
			}
			
			if(chessBoard.getChessMovesCount()>0 ){   				//�p�G�������Ȧs���� �N�����I��"����"���s
				undo.setEnabled(true);
			}else{
				undo.setEnabled(false);
			}			
			
			//���ӭn����ܳѤU���ӦZ�Ƴo�ӥ\�ಾ��O���a��h��{ �o��\���button���A�L��
			if(ChessBoard.chessMoves != null ){
				//(8-chessBoard.getChessMovesCount())�g���F ���ӭn��ʺA�s����ثe���ѽL����
				queenLeft.setText("�ѤU���ӦZ�� : " + (8-chessBoard.getChessMovesCount()));			
			}
		}else{  													//demo�Ҧ��Udemo
			newGame.setEnabled(false);								//���i�H�I��"���}�s��"���s
			confirmAnswer.setEnabled(false);						//���i�H�I��"�T�{����"���s
			undo.setEnabled(false);									//���i�H�I��"����"���s
			startNormalGame.setEnabled(true); 						//�i�H�I��"�@��C��"���s
			selcetDemoGrids.setEnabled(true);						//�i�H�I��U�Ԧ��M��
			 /*	����bdemo�Ҧ�����l�ƤU�Ԧ��M��   ���M�������U�Ԧ��M�檺�ƭ�
			  * �ҥH���l�ƤU�Ԧ��M�檺�u�@��Ѧb��L�C�����A�ɰ���
			  */
			LeftControlPanel.completeNow.setEnabled(false);			//���i�H�I�����䱱��O��"�ߨ觹��"���s
			LeftControlPanel.showNextAnswer.setEnabled(false);		//���i�H�I�����䱱��O��"�U�@�ո�"���s
			
			//���ӭn��M��flag������O���a��h��{  flag�O�Ψӭp��demo�Ҧ��ثedemo��ĴX�ոѥΪ� ��button���A�L��
			LeftControlPanel.flag = 0;
			
			//�U�Ԧ��M���諸�ѽL���ӳ��n��demo �ҥH�H��u�n  demoGrids == null �N�i�H�I��"�U�@�ո�"���s
			//demoGrids == 8�g���F ���ӭn��ʺA�s����ثe���ѽL����
			if(demoGrids == 8){										//�p�Gdemo���ѽL���ƬO8 �i�H�I��"�U�@�ո�"���s
				LeftControlPanel.showNextAnswer.setEnabled(true);
			}else{
				LeftControlPanel.showNextAnswer.setEnabled(false);
			}
		}		
	}
	
	/**
	 * �ˬd�ثe�������ѧ��O�_�����T���פ��@
	 * 
	 * @param answer �U�L���ѨB�Ȧs
	 */
	public void confirmAnswer(HashMap<Integer, Integer> answer){
		int y[]=new int[8];

		//�o������code�n���]�X�{�L �Ҽ{�ʸ˰_�� 
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