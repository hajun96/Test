package TTS.S7.S753000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_753_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strRecvMnOnly = (String) actionAPI.getSessionData("m_strRecvMnOnly"); //���¸�
		String m_strBnkNm = (String) actionAPI.getSessionData("m_strBnkNm"); //�����
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strRecvMnOnly)
		.append(", ���Բ� ������ü�� ��ϵ� ������, ")
		.append(m_strBnkNm)
		.append(", �Դϴ�. ");
		
		actionAPI.setSessionData("ment", sb.toString());
	}
}
