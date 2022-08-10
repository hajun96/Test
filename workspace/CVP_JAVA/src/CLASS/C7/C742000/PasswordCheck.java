package CLASS.C7.C742000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

/*
 * 비밀번호 단순번호, 연속번호 에크
 * m_strNumberCheck = Y -> 정상번호 
 * m_strNumberCheck = S -> 단순번호
 * m_strNumberCheck = C -> 연속번호
 */

public class PasswordCheck extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strNewAccPwd = (String) actionAPI.getSessionData("m_strNewAccPwd"); //새로입력한 Password
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
					//단순번호 
					actionAPI.setSessionData("m_strNumberCheck", "S");
				}else{
					//정상 비밀번호
					actionAPI.setSessionData("m_strNumberCheck", "Y");
				}
			}else{
				//정상 비밀번호
				actionAPI.setSessionData("m_strNumberCheck", "Y");
			}
		}else if(nSecondPwd == nFirstPwd + 1){
			if(nSecondPwd + 1 == nThirdPwd){
				if(nThirdPwd + 1 == nForthPwd){
					//연속번호 
					actionAPI.setSessionData("m_strNumberCheck", "C");
				}else{
					//정상 비밀번호
					actionAPI.setSessionData("m_strNumberCheck", "Y");
				}
			}else{
				//정상 비밀번호
				actionAPI.setSessionData("m_strNumberCheck", "Y");
			}
		}else if(nSecondPwd == nFirstPwd -1){
			if(nSecondPwd - 1 == nThirdPwd){
				if(nThirdPwd - 1 == nForthPwd){
					//연속번호 
					actionAPI.setSessionData("m_strNumberCheck", "C");
				}else{
					//정상 비밀번호
					actionAPI.setSessionData("m_strNumberCheck", "Y");
				}
			}else{
				//정상 비밀번호
				actionAPI.setSessionData("m_strNumberCheck", "Y");
			}
		}else{
			//정상비밀번호
			actionAPI.setSessionData("m_strNumberCheck", "Y");
		}
	}
}
