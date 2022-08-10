package TTS.S6.S613000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_613_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		/*
		 * m_strSubsAmtList 청약증거금
		 * 
		 * m_strSubsRpmtDateList 환불일

          
		
		*/
		
	
		String m_strSubsAmtList = (String) actionAPI.getSessionData("m_strSubsAmtList"); // 청약증거금
		m_strSubsAmtList = trimNum(m_strSubsAmtList);
		String m_strSubsRpmtDateList = (String) actionAPI.getSessionData("m_strSubsRpmtDateList"); // 환불일
		String year = m_strSubsRpmtDateList.substring(0, 4);
		String month = m_strSubsRpmtDateList.substring(4, 6);
		String day = m_strSubsRpmtDateList.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
	
		
		StringBuffer sb = new StringBuffer();
		sb.append(",청약증거금은,").append(", , , ").append(m_strSubsAmtList).append(", , , ")
		.append(",원 환불일,").append(", , , ").append(year).append(", , , ").append(",년,").append(", , , ")
		.append(month).append(", , , ").append(",월,").append(day).append(", , , ").append(",일 입니다.,");
		
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
