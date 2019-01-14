package chess;

/* 
 * ClassName		 :
 * Prolog 
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 * ��@�VSWI Prolog�i��U�جd�ߪ���k
 * 
 * @note �K�ӦZ�C��
 * @author 	�\�ղE
 * @version 1.0
 * 
 */

public class Prolog {
	/**
	 * �s����ؼ�SWI Prolog�ɮ�
	 * 
	 * @param rulebase �n�d�ߪ�.pl�ɮצW��
	 * @return consult prolog�ɮ׬O�_���\
	 */
	static boolean link(String rulebase){
		String command = "consult('" + rulebase + "')";
		return new Query(command).hasSolution();
	}
	
	/**
	 * �VSWI Prolog�ɮ׬d�߬O�_����
	 * 
	 * @param command �U��SWI Prolog�ɮת��d�߻y�y
	 * @return �d�ߵ��G�O�_��true
	 */
	
	static boolean isTrue(String command){
		return new Query(command).hasSolution();
	}
	
	//�Pı�� isTrue(String command)���ƤF
	/**
	 * �VSWI Prolog�ɮ׬d�߬O�_����
	 * 
	 * @param command �U��SWI Prolog�ɮת��d�߻y�y
	 * @return �d�ߵ��G�O�_��true
	 */
	static boolean drive_TrueORFalse(String command){	
		boolean isTrue = isTrue(command);
		Query q = new Query(command);	
		List <Map<String, Term>> list = new ArrayList <Map<String, Term>>();;
		if (isTrue){
			return  true;	   
		}else{
			return  false;	
		}		
	}
	
	/**
	 * �VSWI Prolog�ɮ׬d�߬O�_���ѡA�p�G���ѫh�Ǧ^�p��X�Ӫ����G
	 * 
	 * @param command �U��SWI Prolog�ɮת��d�߻y�y
	 * @return prolog��X�Ӫ����G
	 */
	static List drive(String command){
		boolean isTrue = isTrue(command);
		Query q = new Query(command);	
		
		List <Map<String, Term>> list = new ArrayList <Map<String, Term>>();	
		while ( q.hasMoreSolutions() ){
			Map<String, Term> s4=  q.nextSolution();			
			list.add(s4);				
		}
		return  list;	
	}
	
	//���M���ODEMO�����Ϊ� ���L�n����drive(String command)���ƤF �ݬ�s
	/**
	 * �VSWI Prolog�ɮ׬d�߬O�_���ѡA�p�G���ѫh�Ǧ^�p��X�Ӫ����G  
	 * 
	 * @param command �U��SWI Prolog�ɮת��d�߻y�y
	 * @return prolog��X�Ӫ����G
	 */
	static List drive_demo(String command){
		boolean isTrue = isTrue(command);
		Query q = new Query(command);
		
		List list = new ArrayList();
		while ( q.hasMoreSolutions() ){   	
			String s = q.nextSolution().toString();
            list.add(s);
        }
		return  list;		
	}
	
	/*
	 //�Ѯv����k �ݬ�s
	String drive_trace(String command){
		boolean isTrue = isTrue(command);
		String result = command + " =>  " + isTrue + " \n";
		return result;
	}
	*/
	/*
	//�Ѯv����k �ݬ�s
	static List <Map<String, Term>>  conduct(String command){
		Query q = new Query(command);
      
        List <Map<String, Term>> list = new ArrayList <Map<String, Term>>();
        q.hasSolution();
        while ( q.hasMoreSolutions() ){
        	Map<String, Term> s4=  q.nextSolution();
            list.add(s4);
        }
        return list;
	}*/
	/*
	//�Ѯv����k �ݬ�s
	static List<String>keyOrder(String command){
		String reg = "[,()]";
		String [] tokens = command.split(reg);
		List<String> list = new ArrayList<String>();
		for (int i=0; i< tokens.length; i++){
			String str = tokens[i].trim();
			if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')
				list.add(str);
		}
		return list;
	} */
}
