package TTS.S1.S111000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_111_5 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strPrevAmt = (String) actionAPI.getSessionData("m_strPrevAmt");		//��������
		m_strPrevAmt = trimNum(m_strPrevAmt);
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt");	//���簡
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		String m_strPrevVolume = (String) actionAPI.getSessionData("m_strPrevVolume");	//�ŷ���
		m_strPrevVolume = trimNum(m_strPrevVolume);
		StringBuffer sb = new StringBuffer();
		sb.append(", ���� ������, ")
		.append(m_strPrevAmt)
		.append(", ��, ")
		.append(", ���簡��, ")
		.append(m_strCurrentAmt)
		.append(", ��,")
		.append(", �ŷ�����, ")
		.append(m_strPrevVolume)
		.append(", ��, ")
		.append(", �Դϴ�.");
		
		actionAPI.setSessionData("ment", sb.toString());
	}
	
	private String trimNum(String num) {
		if(num == null) return "0";

		boolean isMinus = false;
		String result = "";

		if(num.startsWith("-")) {
			num = num.substring(1);
			isMinus = true;
		}

		int index = num.indexOf(".");

		if (index == -1) {
			for (int i = 0; i < num.length(); i++) {
				if (!num.substring(i, i + 1).equals("0")) {
					result = num.substring(i);
					break;
				}
			}

		} else {

			String temp1 = num.substring(0, index);
			String temp2 = num.substring(index + 1, num.length());

			for (int i = 0; i < temp1.length(); i++) {
				if (!temp1.substring(i, i + 1).equals("0")) {
					result = temp1.substring(i);
					break;
				}
			}

			String result2 = "";
			for (int i = temp2.length(); i > 0; i--) {
				if (!temp2.substring(i - 1, i).equals("0")) {
					result2 = temp2.substring(0, i);
					break;
				}
			}
			if (result2.length() != 0) {
				result = result + "." + result2;
			}

		}
		if(result.isEmpty()) {
			return "0";
		}

		if(result.startsWith("."))
			result  = "0" + result;

		if(isMinus){
			result = "-" + result;
		}

		return result;
	}
}
