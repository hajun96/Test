package TTS.S2.S270000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_270_7 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strTotBidTot = (String) actionAPI.getSessionData("m_strTotBidTot"); 
		String m_strAgcyTrd = (String) actionAPI.getSessionData("m_strAgcyTrd"); 
		
		m_strTotBidTot = trimNum(m_strTotBidTot);
		Float f_m_strTotBidTot = Float.parseFloat(m_strTotBidTot);
		
		m_strAgcyTrd = trimNum(m_strAgcyTrd);
		Float f_m_strAgcyTrd = Float.parseFloat(m_strAgcyTrd);
		
		StringBuffer sb = new StringBuffer();
		
		if(f_m_strTotBidTot > 0){
			sb.append(", ���α׷� �Ÿŵ�����, ")
			.append(", �ŷ���, ")
			.append(", ���ż�, ")
			.append(m_strTotBidTot).append(", , ")
			.append(", ��, ");
		}else if(f_m_strTotBidTot < 0){
			sb.append(", ���α׷� �Ÿŵ�����, ")
			.append(", �ŷ���, ")
			.append(", ���ŵ�, ")
			.append(m_strTotBidTot).append(", , ")
			.append(", ��, ");
		}else{
			sb.append(", ���α׷� �Ÿŵ�����, ")
			.append(", �ŷ���, ")
			.append(m_strTotBidTot).append(", , ")
			.append(", ��, ");
		}
		
		if(f_m_strAgcyTrd > 0){
			sb.append(", �ڽ���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd).append(", , ")
			.append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(f_m_strAgcyTrd < 0){
			sb.append(", �ڽ���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd).append(", , ")
			.append(", ��, ")
			.append(", �Դϴ�. ");
		}else{
			sb.append(", �ڽ���, ")
			.append(m_strAgcyTrd).append(", , ")
			.append(", ��, ")
			.append(", �Դϴ�. ");
		}

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
