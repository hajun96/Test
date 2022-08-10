package CLASS.C7.C742000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

/*
 * ��й�ȣ �ܼ���ȣ, ���ӹ�ȣ ��ũ
 * m_strNumberCheck = Y -> �����ȣ 
 * m_strNumberCheck = S -> �ܼ���ȣ
 * m_strNumberCheck = C -> ���ӹ�ȣ
 */

public class PasswordCheck extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strNewAccPwd = (String) actionAPI.getSessionData("m_strNewAccPwd"); //�����Է��� Password
		String strFirstPwd = m_strNewAccPwd.substring(0, 1);
		int nFirstPwd = Integer.parseInt(strFirstPwd);
		String strSecondPwd = m_strNewAccPwd.substring(1, 2);
		int nSecondPwd = Integer.parseInt(strSecondPwd);
		String strThirdPwd = m_strNewAccPwd.substring(2, 3);
		int nThirdPwd = Integer.parseInt(strThirdPwd);
		String strForthPwd = m_strNewAccPwd.substring(3, 4);
		int nForthPwd = Integer.parseInt(strForthPwd);
		
		if(nSecondPwd == nFirstPwd){
			if(nSecondPwd == nThirdPwd){
				if(nThirdPwd == nForthPwd){
					//�ܼ���ȣ 
					actionAPI.setSessionData("m_strNumberCheck", "S");
				}else{
					//���� ��й�ȣ
					actionAPI.setSessionData("m_strNumberCheck", "Y");
				}
			}else{
				//���� ��й�ȣ
				actionAPI.setSessionData("m_strNumberCheck", "Y");
			}
		}else if(nSecondPwd == nFirstPwd + 1){
			if(nSecondPwd + 1 == nThirdPwd){
				if(nThirdPwd + 1 == nForthPwd){
					//���ӹ�ȣ 
					actionAPI.setSessionData("m_strNumberCheck", "C");
				}else{
					//���� ��й�ȣ
					actionAPI.setSessionData("m_strNumberCheck", "Y");
				}
			}else{
				//���� ��й�ȣ
				actionAPI.setSessionData("m_strNumberCheck", "Y");
			}
		}else if(nSecondPwd == nFirstPwd -1){
			if(nSecondPwd - 1 == nThirdPwd){
				if(nThirdPwd - 1 == nForthPwd){
					//���ӹ�ȣ 
					actionAPI.setSessionData("m_strNumberCheck", "C");
				}else{
					//���� ��й�ȣ
					actionAPI.setSessionData("m_strNumberCheck", "Y");
				}
			}else{
				//���� ��й�ȣ
				actionAPI.setSessionData("m_strNumberCheck", "Y");
			}
		}else{
			//�����й�ȣ
			actionAPI.setSessionData("m_strNumberCheck", "Y");
		}
	}
}
