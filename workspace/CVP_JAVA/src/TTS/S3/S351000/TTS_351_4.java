package TTS.S3.S351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_351_4 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		String m_strBsprAplyDate = (String) actionAPI.getSessionData("m_strBsprAplyDate"); //������
		
		String SellBsprAplyDate1 = m_strBsprAplyDate.substring(0, 4); // ��
		String SellBsprAplyDate2 = m_strBsprAplyDate.substring(4, 6); // ��
		SellBsprAplyDate2 = trimNum(SellBsprAplyDate2);
		String SellBsprAplyDate3 = m_strBsprAplyDate.substring(6, 8); // ��
		SellBsprAplyDate3 = trimNum(SellBsprAplyDate3);
		
		
		String m_strSttDate = (String) actionAPI.getSessionData("m_strSttDate"); // �ݵ������
		String m_strSellSttDate1 = m_strSttDate.substring(0, 4); // ��
		String m_strSellSttDate2 = m_strSttDate.substring(4, 6); // ��
		m_strSellSttDate2 = trimNum(m_strSellSttDate2);
		String m_strSellSttDate3 = m_strSttDate.substring(6, 8); // ��
		m_strSellSttDate3 = trimNum(m_strSellSttDate3);
		
		

		StringBuffer sb = new StringBuffer();
		
		sb.append(", �������� , ").append(SellBsprAplyDate1).append(", ��, ")
		.append(SellBsprAplyDate2).append(", , ").append(", �� , ").append(SellBsprAplyDate3).append(", , ").append(", �� �̸�, �ݵ��������, ")
		.append(m_strSellSttDate1).append(", , ").append(", ��, ").append(m_strSellSttDate2).append(", , ").append(", ��, ").append(m_strSellSttDate3).append(", , ").append(", �� �Դϴ�., ");
		
		
		
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

