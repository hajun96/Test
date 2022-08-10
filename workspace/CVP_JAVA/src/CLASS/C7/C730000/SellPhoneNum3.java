package CLASS.C7.C730000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class SellPhoneNum3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strDialNum = (String) actionAPI.getSessionData("m_strDialNum"); //°í°´¹øÈ£
		String m_strSellPhoneNum3 = "";
		if(m_strDialNum.equals(null) || m_strDialNum.equals("")){
			actionAPI.setSessionData("m_strSellPhoneNum3", "error");
		}else{
			int m_strDialLength = m_strDialNum.length();
			int m_strDialLast = m_strDialLength - 4;
			m_strSellPhoneNum3 = m_strDialNum.substring(m_strDialLast, m_strDialLength);
			actionAPI.setSessionData("m_strSellPhoneNum3", m_strSellPhoneNum3);
		}
	}
}
