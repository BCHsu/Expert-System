package chess;

/* 
 * ClassName		 :
 * GameStatusController 
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

/**
 * �t�d�B�z�C���Ҧ����A������
 * 
 * @note �K�ӦZ�C��
 * @author 	�\�ղE
 * @version 1.0
 * 
 */

public class GameStatusController {
	//private static boolean inCheatMode  = false;   //�H�ᱱ��@���Ҧ��}�Ҫ�flag �ثe�L�@��
	static Mode gameMode;						//�C���Ҧ����A
	public static int test2 =2;
	/*
	 * �`�O�z�L�����s��gameMode�ݩʨӶi��ާ@ �n���c �Ҽ{��GameStatusController���O����
	 * �����b�����ܼƳ]�wgameMode�ݩʴN�n
	 * 
	 */
		
	/**
	 * ��l�ƹC���Ҧ�
	 * 
	 */
	
	public void initialize(){
		setgameMode(Mode.none);
		
	}
	
	/**
	 * ���C���Ҧ�
	 * 
	 * @param mode �n�i�J���C���Ҧ�
	 */
	
	public void setgameMode(Mode mode ){
		gameMode = mode;	
	}
	
}