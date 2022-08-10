package CLASS.C3.C351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class Choice extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strDTMF = (String) actionAPI.getSessionData("m_strDTMF"); //누른번호
		int m_nDTMF = Integer.parseInt(m_strDTMF) - 1;
		m_strDTMF = String.valueOf(m_nDTMF);
		actionAPI.setSessionData("m_strDTMF", m_strDTMF);
	}
}
