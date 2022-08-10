package TTS.S5.S520000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_520_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		//m_strBankAccount
		String m_strBankAccount = (String) actionAPI.getSessionData("m_strBankAccount"); //계좌번호
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(", 입력하신, ")
		.append(", 계좌번호는, ")
		.append("[")
		.append(m_strBankAccount)
		.append("]")
		.append(", 입니다. ");
		actionAPI.setSessionData("ment", sb.toString());
	}
}
