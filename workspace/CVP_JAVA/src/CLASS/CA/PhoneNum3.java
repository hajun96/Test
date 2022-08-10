package CLASS.CA;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class PhoneNum3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strAnyNum = (String) actionAPI.getSessionData("m_strAnyNum"); //고객번호
		String m_strPhoneNum1 = (String) actionAPI.getSessionData("m_strPhoneNum1"); //지역번호
		String m_strPhoneNum2 = (String) actionAPI.getSessionData("m_strPhoneNum2"); //중간번호
		String m_strPhoneNum3 = "";
		if(m_strAnyNum.equals(null) || m_strAnyNum.equals("")){
			actionAPI.setSessionData("m_strPhoneNum3", "error");
		}else{
			int m_strAnyLength = m_strAnyNum.length();
			int m_strAnyLast = m_strAnyLength - 4;
			
			if(m_strPhoneNum1.length() == 1){
				m_strPhoneNum1 = m_strPhoneNum1 + "   ";
			}else if(m_strPhoneNum1.length() == 2){
				m_strPhoneNum1 = m_strPhoneNum1 + "  ";
			}else if(m_strPhoneNum1.length() == 3){
				m_strPhoneNum1 = m_strPhoneNum1 + " ";
			}
			
			if(m_strPhoneNum2.length() == 2){
				m_strPhoneNum2 = m_strPhoneNum2 + "   ";
			}else if(m_strPhoneNum2.length() == 2){
				m_strPhoneNum2 = m_strPhoneNum2 + "  ";
			}else if(m_strPhoneNum2.length() == 3){
				m_strPhoneNum2 = m_strPhoneNum2 + " ";
			}
			
			m_strPhoneNum3 = m_strAnyNum.substring(m_strAnyLast, m_strAnyLength);
			
			actionAPI.setSessionData("m_strPhoneNum1", m_strPhoneNum1);
			actionAPI.setSessionData("m_strPhoneNum2", m_strPhoneNum2);
			actionAPI.setSessionData("m_strPhoneNum3", m_strPhoneNum3);
		}
	}
}
