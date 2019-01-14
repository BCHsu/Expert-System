package chess;

/* 
 * ClassName		 :
 * GameInterface 
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
 *          �b�\��K�ӬӦZ���� ���ӭn�i�H�����ҵ��� ���O������ߨ觹��
 *          �Ҽ{�s�W�զ⪺�ӦZ �b�ծ��¦⪺�ӦZ �b�®��զ⪺�ӦZ
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
//�e��إΪ�

/**
 * GameInterface�t�d�إߥD�n��MainFrame�B�B�z��LJPanel����l�Ƹ򥬧��B�Ұʭp�ɾ��B�]�wmessage
 * 
 * @note �K�ӦZ�C��
 * @author �\�ղE
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
	 * ��l�ƹC�����A
	 * 
	 * @param defaultchessBoard
	 *            �O�ǤJ���ѽL
	 */
	public GameInterface(ChessBoard defaultchessBoard) {
		super("�K�ӦZ�C��");
		chessBoard = defaultchessBoard;
		//this.prolog = new Prolog();
		initialize();
	}

	/**
	 * ���骺��l�Ƥ��e�C��l�Ʊ���ALayout�AContentPane��U��JPanel
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
	 * �]�wMidShowPanel��������m�MConstraints�ݩ� �A�̫�i���l�ơC
	 * 
	 * �ݸɥR
	 * 
	 * @param midJPanel
	 *            �n�i��]�w��JPanel(JPanel����)
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
	 * �]�wLeftControlPanel��������m�MConstraints�ݩ� �A�̫�i���l�ơC
	 * 
	 * �ݸɥR
	 * 
	 * @param midJPanel
	 *            �n�i��]�w��LeftControlPanel(JPanel����)
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
	 * �]�wRightControlPanel��������m�MConstraints�ݩ� �A�̫�i���l�ơC
	 * 
	 * �ݸɥR
	 * 
	 * @param midJPanel
	 *            �n�i��]�w��RightControlPanel(JPanel����)
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
	 * ��l��MidShowPanel�AMidJPanel�W�����@��ChessBoard(JPanel����)�MMessageBox(JLabel����)
	 * 
	 * @param midJPanel
	 *            �n�i��]�w��MidShowPanel
	 * @param chessBoard
	 *            �n�[�JMidJPanel����ChessBoard����
	 */

	public void midShowPanelInitialize(JPanel midJPanel, ChessBoard chessBoard) {
		midJPanel.setBackground(Color.YELLOW);
		GridBagLayout midJPanelLayout = new GridBagLayout();
		midJPanel.setLayout(midJPanelLayout);
		//setMidShowPanel_ChessBoard(chessBoard); // �n���S���� ��Debug �p�G�L�γB�N���o

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

		midJPanel.add(chessBoard); // �s�شѽL

		messageBox = new JLabel("", SwingConstants.CENTER);
		messageBox.setFont(new Font("�з���", Font.PLAIN, 50));
		initializeMidShowPanel_MessageBox(messageBox);

		GridBagConstraints constraints_MidPanel_MessageBox = new GridBagConstraints();
		constraints_MidPanel_MessageBox.gridx = 0;
		constraints_MidPanel_MessageBox.gridy = 4;
		constraints_MidPanel_MessageBox.gridwidth = 4;
		constraints_MidPanel_MessageBox.gridheight = 1;
		constraints_MidPanel_MessageBox.weightx = 0;
		constraints_MidPanel_MessageBox.weighty = 0;
		midJPanelLayout.setConstraints(messageBox, constraints_MidPanel_MessageBox);

		midJPanel.add(messageBox); // �s����ܰT���C
	}

	/**
	 * �n���S���� ��Debug �p�G�L�γB�N���o
	 * 
	 * @param chessBoard
	 */
	/*
	 * public static void setMidShowPanel_ChessBoard(JPanel chessBoard){
	 * //chessBoard.setBorder(new LineBorder(Color.RED)); //JPANEL�~��
	 * chessBoard.setPreferredSize(new Dimension());
	 * 
	 * }
	 */

	/**
	 * ��l�ƶi�J�C�����w��T���M�C�����A�ê�l�ƭp�ɾ�
	 * 
	 * @param messageBox
	 *            �t�d��X�w��T����JLabel����
	 */

	// �Ҽ{���l�ƹC�����A����O���a��h�B�z
    public static void initializeMidShowPanel_MessageBox(JLabel messageBox) {
		messageBox.setText("�w��i�J�C��");
		GameStatusController.gameMode = Mode.none;
		showTimer(messageBox);
	}

	/**
	 * �N�p�ɾ��k�s
	 * 
	 */

	public static void setTimerStartTime() {
		timerStartTime = System.currentTimeMillis();
	}

	// �C���p�ɥ\��

	/**
	 * ��l�ƭp�ɾ�
	 * 
	 * actionPerformed�ݸɥR
	 * 
	 * @param messageBox
	 *            �t�d��X�����C���g�L�h�[�ɶ���JLabel����
	 */

	private static void showTimer(JLabel messageBox) {
		
		gameTimer = new Timer(100, new ActionListener() {
			int hourPassed = 0;
			int minutePassed = 0;
			int secondPassed = 0;

			public void actionPerformed(ActionEvent e) {
				if (GameStatusController.gameMode == Mode.normal) {
					messageBox.setText("�}�l�p��");

					long currentTime = System.currentTimeMillis();
					int timePassed = (int) (currentTime - timerStartTime) / 1000;

					if (timePassed >= 60 * 60) { // 3600��@�p�� �C���}�l�ạ�@�p�ɥH�W
						hourPassed = (timePassed) / 3600; // �i�঳��
						minutePassed = ((timePassed) % 3600) / 60; // �i�঳��
						secondPassed = (timePassed) % 60; // �i�঳��

						messageBox.setText("�L�F" + hourPassed + "��" + minutePassed + "��" + secondPassed + "��");
					} else if (timePassed < 3600 && timePassed >= 60) { // 60��@����
																		// �C���}�l�ạ�@����
																		// �����@�p��
						minutePassed = (timePassed) / 60;
						secondPassed = (timePassed) % 60;

						messageBox.setText("�L�F" + minutePassed + "��" + secondPassed + "��");
					} else { // timePassed<60 �C���}�l�᥼���@����
						messageBox.setText("�L�F" + timePassed + "��");
					}
				}
			}
		});
		gameTimer.start();
	}

	/**
	 * �s��prolog�ɮרù�K�ӦZ�ѧ��O�_�����T�ѵ����X�������ʧ@�C �p�G�����O���T�ѵ����@�h����p�ɾ��ç��ܿ�X���T���C
	 * �p�G�������O���T�ѵ��h���X�p�����i���ϥΪ̵��׿��~�C
	 * 
	 * @param query
	 *            �ǵ�SWI-prolog�P�_�K�ӦZ���Dtrue of false���y�y
	 */

	static void infer_Eightqueens_Solution_TrueorFalse(String query) {
		/*
		 * �H�����ӭn�H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ� ��k�]�ݭn���s�R�W �H��i��|�h�@�ӰѼ�size �N��ѽL�j�p �]�N��N�ӦZ���D
		 */
		Prolog.link(EIGHTQUEENS_RULEBASE); // �Pprolog�ɮ׶i��s��

		if (Prolog.drive_TrueORFalse(query)) { // �I�sProlog���O������k�i��P�_�����O���T�ѵ����@
			messageBox.setText("Bingo"); // ����p�ɾ�
			GameStatusController.gameMode = Mode.none;
		} else { // �������O���T�ѵ�
			JOptionPane.showMessageDialog(null, "�ЦA�ˬd�ݬ�", "���׿��~", JOptionPane.ERROR_MESSAGE);
			// ��ܤp�����i���ϥΪ̵��׿��~
		}

	}

	/**
	 * �s��prolog�ɮרöǦ^�Ҧ��K�ӦZ���D�i��Ѫ���C�C
	 * 
	 * @param query
	 *            �ǵ�SWI-prolog�P�_�K�ӦZ���D�i��Ѧ����Ǫ��y�y
	 * @return �Ҧ��K�ӦZ���D�i���
	 */

	static List infer_Eightqueens_SolutionDemo(String query) {
		/*
		 * �H�����ӭn�H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ� ��k�]�ݭn���s�R�W �H��i��|�h�@�ӰѼ�size �N��ѽL�j�p �]�N��N�ӦZ���D
		 */
		Prolog.link(EIGHTQUEENS_RULEBASE); // �Pprolog�ɮ׶i��s��
		List result = Prolog.drive_demo(query); // �I�sProlog���O������k�öǦ^�i�檺���צ�C
		return result;
	}

	/**
	 * �s��prolog�ɮרçP�_��e�K�ӦZ�ѧ��i�঳���ǥi��ѡC �Y�L�ѫh�h���ܿ�X���ϥΪ̪��T���ð���p�ɾ��C �Y���ѫh�۰ʧ����Ѿl���ѧ��C
	 * 
	 * @param query
	 *            �ǵ�SWI-prolog�P�_��e�K�ӦZ�ѧ��i�঳���ǥi��Ѫ��y�y
	 */

	static void infer_Eightqueens_Solution(String query) {
		/*
		 * �H�����ӭn�H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ� ��k�]�ݭn���s�R�W �H��i��|�h�@�ӰѼ�size �N��ѽL�j�p �]�N��N�ӦZ���D
		 */
		
		Prolog.link(EIGHTQUEENS_RULEBASE); // �Pprolog�ɮ׶i��s��
		if (Prolog.drive_TrueORFalse(query)) { // ��e�K�ӦZ�ѧ�����
			List result = Prolog.drive(query); // �I�sProlog���O������k�öǦ^�����i�檺���צ�C
			/*
			 * ��SWI Prolog�Ǧ^�Ӫ��K�ӦZ���D���צ�C�^�����r��
			 */
			Iterator<Map<String, Term>> it = result.iterator();
			String temp = new String();
			while (it.hasNext()) {
				Map<String, Term> key = it.next();
				temp = key.toString();
			}

			/*
			 * ��SWI Prolog�Ǧ^�Ӫ��K�ӦZ���D���צ�C�^�����r���A��r���ন�y��
			 */
			for (int i = 0; i < 8; i++) { // Y1��Y8
				int index = temp.indexOf("Y" + (i + 1)); // ����������r�� index����
				if (index != -1) { // �p�G�S�����������r�� index���ȴN�|�O-1
					String count = temp.substring(index + 3, index + 4);
					int coordinateY = Integer.valueOf(count) - 1;
					ChessBoard.chessMoves.add(new int[] { i, coordinateY });
				}
			}

			chessBoard.repaint();
			GameStatusController.gameMode = Mode.none;
		} else { // �Y��e�K�ӦZ�ѧ��L�ѫh���ܿ�X���ϥΪ̪��T���ð���p�ɾ�
			messageBox.setText("�����L��");
			GameStatusController.gameMode = Mode.none;
		}
	}

	/**
	 * ��X�K�ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92 ,Y8=... �n��s�@�U
	 */
	static void infer_Eightqueens_Solutionnum() {
		/*
		 * �H�����ӭn�H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ� ��k�]�ݭn���s�R�W �H��i��|�h�@�ӰѼ�size �N��ѽL�j�p �]�N��N�ӦZ���D
		 */
		Prolog.link(EIGHTQUEENS_RULEBASE);
		List result = Prolog.drive(
				"findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8],eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R), length(R,N).");
		Iterator<Map<String, Term>> it = result.iterator();

		while (it.hasNext()) {
			Map<String, Term> key = it.next();
			String temp = key.toString();
			/* �o�����Q�g���F ���ӭn����ʺA����ƪ��� �Ӥ��O�̾alastIndexOf(Y8)�ӧP�_ */
			int firstindex = temp.lastIndexOf(" N=");
			int lastindex = temp.lastIndexOf("Y8");
			String count = temp.substring(firstindex + 3, lastindex - 2);

			messageBox.setText("�K�ӦZ���D�@��" + count + "�ո�");
		}
	}

	/**
	 * ��X�E�ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92 ,Y8=... �n��s�@�U �o�Ӥ�k�Pı�O�h�l��
	 * �p�G�H����H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ����ӴN���ݭn�o�Ӥ�k�F
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

			messageBox.setText("�E�ӦZ���D�@��" + count + "�ո�");
		}
	}

	/**
	 * ��X�Q�ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92 ,Y8=... �n��s�@�U �o�Ӥ�k�Pı�O�h�l��
	 * �p�G�H����H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ����ӴN���ݭn�o�Ӥ�k�F
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

			messageBox.setText("�Q�ӦZ���D�@��" + count + "�ո�");
		}
	}

	/**
	 * ��X�C�ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92} �n��s�@�U �o�Ӥ�k�Pı�O�h�l��
	 * �p�G�H����H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ����ӴN���ݭn�o�Ӥ�k�F
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

			messageBox.setText("�C�ӦZ���D�@��" + count + "�ո�");
		}
	}

	/**
	 * ��X���ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92} �n��s�@�U �o�Ӥ�k�Pı�O�h�l��
	 * �p�G�H����H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ����ӴN���ݭn�o�Ӥ�k�F
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

			messageBox.setText("���ӦZ���D�@��" + count + "�ո�");
		}
	}

	/**
	 * ��X���ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92} �n��s�@�U �o�Ӥ�k�Pı�O�h�l��
	 * �p�G�H����H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ����ӴN���ݭn�o�Ӥ�k�F
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

			messageBox.setText("���ӦZ���D�@��" + count + "�ո�");
		}
	}

	/**
	 * ��X�|�ӦZ���D���X�ո�
	 * 
	 */

	/*
	 * ������key.toString()�X�ӷ|�O ...N=92} �n��s�@�U �o�Ӥ�k�Pı�O�h�l��
	 * �p�G�H����H�۶ǤJN�ӦZ�ӰʺA���ܳs����prolog�ɮ����ӴN���ݭn�o�Ӥ�k�F
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

			messageBox.setText("�|�ӦZ���D�@��" + count + "�ո�");
		}
	}

	public static void main(String args[]) {
		new GameInterface(new ChessBoard(8));
	}
}