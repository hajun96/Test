package TTS.S5.S520000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_520_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		//m_strBankAccount
		String m_strBankAccount = (String) actionAPI.getSessionData("m_strBankAccount"); //���¹�ȣ
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(", �Է��Ͻ�, ")
		.append(", ���¹�ȣ��, ")
		.append("[")
		.append(m_strBankAccount)
		.append("]")
		.append(", �Դϴ�. ");
		actionAPI.setSessionData("ment", sb.toString());
	}
}
