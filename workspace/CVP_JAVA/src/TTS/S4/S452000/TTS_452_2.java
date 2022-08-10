package TTS.S4.S452000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_452_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strTradeTrdDate = (String) actionAPI.getSessionData("m_strTradeTrdDate");		//�Ÿ�����
		String year = m_strTradeTrdDate.substring(0, 4);
		String month = m_strTradeTrdDate.substring(4, 6);
		String day = m_strTradeTrdDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		String m_strTradeTrSectNm = (String) actionAPI.getSessionData("m_strTradeTrSectNm"); 	//�ŷ����и�
		m_strTradeTrSectNm = m_strTradeTrSectNm.replaceAll(" ", "");
		//String m_strTradeItemCode = (String) actionAPI.getSessionData("m_strTradeItemCode"); 	//�����ڵ�
		String m_strTradeItemName = (String) actionAPI.getSessionData("m_strTradeItemName"); 	//�����
		String m_strTradeTrdQty = (String) actionAPI.getSessionData("m_strTradeTrdQty"); 		//�Ÿż���
		m_strTradeTrdQty = trimNum(m_strTradeTrdQty);
		String m_strTradeTrdUprc = (String) actionAPI.getSessionData("m_strTradeTrdUprc");		//�ŸŴܰ�
		m_strTradeTrdUprc = trimNum(m_strTradeTrdUprc);
		String m_strTradeTrdAmt = (String) actionAPI.getSessionData("m_strTradeTrdAmt"); 		//�Ÿűݾ�
		m_strTradeTrdAmt = trimNum(m_strTradeTrdAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
		.append("����� ������, ")
		.append(m_strTradeTrdAmt)
		.append(", ��, ")
		.append(m_strTradeItemName).append(", ")
		.append(m_strTradeTrSectNm)
		.append(", �Ǿ����ϴ�.. ");
		
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
