package TTS.S7.S753000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_753_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strRecvMnOnly = (String) actionAPI.getSessionData("m_strRecvMnOnly"); //계좌명
		String m_strBnkNm = (String) actionAPI.getSessionData("m_strBnkNm"); //은행명
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strRecvMnOnly)
		.append(", 고객님께 유선이체로 등록된 은행은, ")
		.append(m_strBnkNm)
		.append(", 입니다. ");
		
		actionAPI.setSessionData("ment", sb.toString());
	}
}
