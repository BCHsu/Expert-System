package chess;

/* 
 * ClassName		 :
 * LeftControlPanel 
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
 * �]�w���䱱��O�������򭱪O�W�����s����
 * 
 * @note �K�ӦZ�C��
 * @author 	�\�ղE
 * @version 1.0
 * 
 */

public class LeftControlPanel extends JPanel{
	private static ChessBoard chessBoard;
	private JLabel messageBox;
	//private Image mainImage;   		//�@���Ҧ�Ĳ�o�ϰ�ϥΪ��ϼ�   
	private JLabel imageLabel;   		//�@���Ҧ���Ĳ�o�ϰ� ���o�ӥi�H�}�ұq��L��J�@���X ���ݥH�᪺������@
	static JButton completeNow;  		//�b�C���Ҧ��U�ߨ觹���ѧ�  (���ݹ�@:�}�ҧ@���Ҧ���~�i�H��ܨèϥ�)
	static JButton showNextAnswer;  	//�t��k�Ҧ��Ushow�X�U�@�ո�  �P�ɷ|��s���U�譱�O����r	 ��ܥثe�O ��X of Y�ո�								  	                              		
	private JButton no;           		//�\��ѤF �ݷs�W
	private JLabel leftBlankArea;   	//����ť�
	private JLabel rightBlankArea;  	//�k��ť�
	private JLabel buttomBlankArea; 	//�U��ť�	
	private GridBagLayout leftLayout;
	private GridBagConstraints constraints;	
	public int testLCPattributes = 1;
	public static int test1 = 1;
	
	//flag�Ҽ{�n��W ���M�ڥ������D���ƻ�Ϊ�
	static int flag = 0;				//����t��k�Ҧ��Ushow�X��N�ոѱ���X��
	static List<String> tempAnswer = new ArrayList<String>();  //�s���SWI Prolog�d�ߤK�ӦZ���D�᪺�U�إi���
	private static final long serialVersionUID = 1L;

	public LeftControlPanel(ChessBoard gameBorad, JLabel messageBox){
		this.chessBoard = gameBorad;
		this.messageBox = messageBox;
	}
	
	public LeftControlPanel(){
		
	}
	
	/**
	 * ��l�ƥ��䱱��O
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
	 * �]�w���䱱��O�ťհϰ쪺��m�򥬧�
	 * 
	 */
	private void setBlankArea(){		
		//���䱱��O���䪺�ťհϰ�
		leftBlankArea = new JLabel();		
		constraints.gridx= 0;
		constraints.gridy= 6;
		constraints.gridwidth =1;
		constraints.gridheight = 6;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.fill = GridBagConstraints.BOTH;
		leftLayout.setConstraints(leftBlankArea, constraints);		
		
		//���䱱��O�k�䪺�ťհϰ�
		rightBlankArea = new JLabel();	
		constraints.gridx= 5;
		constraints.gridy= 6;
		constraints.gridwidth =1;
		constraints.gridheight = 6;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.fill = GridBagConstraints.BOTH;
		leftLayout.setConstraints(rightBlankArea, constraints);		
		
		//���䱱��O�U�誺�ťհϰ�
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
	 * �]�w���䱱��O�@���Ҧ���Ĳ�o�ϰ쪺�����A�ثe�٨S����@�\����϶K�W�h
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
	 * �]�w���䱱��O�W"�ߨ觹��"���s��������\��
	 * 
	 */
	private void setCompleteNowButton(){
		completeNow = new JButton("�ߨ觹��");
		completeNow.setFont(new Font("�s�ө���",Font.PLAIN, 40));
		
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
				//ChessBoard.chessMoves.size()<8�Q�g���F ���ӭn���ѽL���ưʺA�s��
				if(ChessBoard.chessMoves!=null && ChessBoard.chessMoves.size()<8){/*
					Iterator<int[]> it = ChessBoard.chessMoves.iterator();
					HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();	
					while(it.hasNext()){				
						int[] moves  = it.next();	
						temp.put(moves[0],moves[1]);
					}*/
					ArrayList<int[]> temp  = ChessBoard.chessMoves;
					completeAnswer(temp);    //�ǤJ��e�ѧ��Ȧs���x�s���B��
				}			
			}			
		});
		add(completeNow);
	}
	
	/**
	 * ���e�ѧ��Ȧs���x�s���B���ഫ��SWI Prolog�d�߻y�y
	 * 
	 * @param answer ��e�ѧ��Ȧs���x�s���B��
	 */
	private void completeAnswer(ArrayList<int[]> answer){
		Iterator<int[]> mapit = ChessBoard.chessMoves.iterator();
		HashMap<Integer,Integer> maptemp = new HashMap<Integer,Integer>();	
		while(mapit.hasNext()){				
			int[] moves  = mapit.next();	
			maptemp.put(moves[0],moves[1]);   //��y�Ъ�X�ȷ�map��key
		}		
		int y[]=new int[8];
		//new int[8]�Q�g���F ���ӭn���ѽL���ưʺA�s��
		Iterator<int[]> listit = ChessBoard.chessMoves.iterator();
		//��Ȧs�B�ƪ�arraylist�নmap �A�����̪����״N��o�����Ӫ�arraylist�̬O�_���y��X�ȬۦP���ѨB
		if(((int)maptemp.size())==((int)answer.size())){
			while(listit.hasNext()){
				int[] moves  = listit.next();
				//switch case�Q�g���F ���ӭn���ѽL���ưʺA�s��
				switch((int)moves[0]){//���e�ѧ��Ȧs���x�s���B�� Y�y��+1 �ŦX�@��H�����Шt �]���{����P�_�Ӧ�m�w���ӦZ
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
			//String query�Q�g���F ���ӭn���ѽL���ưʺA�s��
			//�r�ꪺ�걵�Ĳv�n�ﵽ
			String query = "eight_queens([";	
			//for(int i = 1;i<9;i++)�Q�g���F ���ӭn���ѽL���ưʺA�s��
			for(int i = 1;i<9;i++){
				if(y[i-1] !=0){         //if y[i-1] != 0 �N�����ѽL�W�����쪺��l����ӦZ
					query = query+"("+i+","+y[i-1];
				}else{
					query = query+"("+i+","+"Y"+i;
				}
				//if(i !=8) ���ӭn���ѽL���ưʺA�s��
				if(i !=8){
					query = query +"),";
				}else{
					query = query +")";
				}
			}
			query =query +"]).";
			GameInterface.infer_Eightqueens_Solution(query);
		}else{    //((int)maptemp.size())<((int)answer.size())
			messageBox.setText("�����L��");
			GameStatusController.gameMode = Mode.none;
		}		
		RightControlPanel.checkButtonStatus();	
	}
	
	//�ثe�ȥi�b�K�ӦZ�����p�U�B�@
	/**
	 * �]�w���䱱��O�W"�U�@�ո�"���s��������\��
	 * 
	 */
	private void setShowNextAnswerButton(){
		showNextAnswer = new JButton("�U�@�ո�");
		showNextAnswer.setFont(new Font("�s�ө���",Font.PLAIN, 40));
		
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
				if(GameStatusController.gameMode == Mode.demo){  //�t��k�Ҧ��U�~�i��
					String query = "eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]).";
					List result = GameInterface.infer_Eightqueens_SolutionDemo(query);				
					ListIterator<String> it = result.listIterator();				
					while(it.hasNext()){
						tempAnswer.add(it.next());
					}		
					if(flag<92){		   //flag 0 ~ 91�̦h�@92��				
						String temp = tempAnswer.get(flag);
						for(int i =0 ;i <8; i++){
							int index = temp.indexOf("Y"+(i+1)+"=");
							String y = temp.substring(index+3,index+4);
							int coordinateY = Integer.valueOf(y)-1;
							ChessBoard.chessMoves.add(new int[]{i,coordinateY});
						}
						chessBoard.repaint();
						//messageBox.setText�Q�g���F ���ӭn����X�Ӫ�N�ӦZ���D�ѼưʺA�s��	
						messageBox.setText("�K�ӦZ���D�@��92�ո� �ثe�O��"+(flag+1)+"�ظ�");	
						flag++;
					}							
					if(flag == 92){      //if(flag == 92)�Q�g���F ���ӭn����X�Ӫ�N�ӦZ���D�ѼưʺA�s��	
						showNextAnswer.setEnabled(false);   //��F�̫�@�ո� �N���A��"�U�@�ո�"�o�ӫ��s�F
					}
				}							
			}					
		});		
		add(showNextAnswer);
	}
	
	/**
	 * �]�w���䱱��O�W"   "���s��������\�� �ثe�S���Ψ� ���ݥH���X�R�ΩҥH�]���������i��
	 * 
	 */
	private void setNoButton(){
		no = new JButton("     ");
		no.setFont(new Font("�s�ө���",Font.PLAIN, 40));
		no.setEnabled(false);
		constraints.gridx= 1;
		constraints.gridy= 10;
		constraints.gridwidth =4;
		constraints.gridheight = 2;
		constraints.weightx= 100;
		constraints.weighty= 100;
		constraints.insets=new Insets(50,0,50,0);
		leftLayout.setConstraints(no, constraints);
		/* �p�G�����ե�setVisible(false);
		 * ���s���Ӫ��ϰ�|�����Q�л\�L�h
		 * �n�אּ ���e���s��ڤW�����e�h�F�����æ��O�e�Ŷ������s
		 */
		no.setBorderPainted(false);     	//���e���s�����
		no.setOpaque(false);            	//���s�]���z��
		add(no);
	}
}