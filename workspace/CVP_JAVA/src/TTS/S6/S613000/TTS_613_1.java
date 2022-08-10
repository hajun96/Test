package TTS.S6.S613000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_613_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		/*
		 * m_strSubItemNmList 종목명

           m_strSubsQtyList 전체 청약 수량
           m_strSubsQty 신청한 청약 수량  m_strSubsQty
           m_strSubsEnblStkqTemp
           m_strSubsQtyList
		
		*/
		
	
		String m_strSubItemNmList = (String) actionAPI.getSessionData("m_strSubItemNmList"); // 종목명
		m_strSubItemNmList = trimNum(m_strSubItemNmList);
		String m_strSubsQtyList = (String) actionAPI.getSessionData("m_strSubsQtyList"); // 청약수량
		m_strSubsQtyList = trimNum(m_strSubsQtyList);
	
		
		
	
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strSubItemNmList).append(", , , ").append(m_strSubsQtyList);
		
		
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
