package TTS.S5.S510000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_510_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strBankName = (String) actionAPI.getSessionData("m_strBankName"); //�����or���ǻ��
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strBankName)
		.append(", �Դϴ�. ");
		actionAPI.setSessionData("ment", sb.toString());
	}
}
