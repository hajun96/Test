package TTS.S4.S430000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_430_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName"); //종목명
		String m_strHoldFluctFlag = (String) actionAPI.getSessionData("m_strHoldFluctFlag"); //전일대비구분
		String m_strHoldFluctAmt = (String) actionAPI.getSessionData("m_strHoldFluctAmt"); //전일대비
		m_strHoldFluctAmt = trimNum(m_strHoldFluctAmt);
		String m_strHoldCurrent = (String) actionAPI.getSessionData("m_strHoldCurrent"); //현재가
		m_strHoldCurrent = trimNum(m_strHoldCurrent);
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(m_strItemName)
		.append(", 현재가는, ");
		
		if(m_strHoldFluctFlag.equals("5") || m_strHoldFluctFlag.equals("6") || m_strHoldFluctFlag.equals("7") || m_strHoldFluctFlag.equals("8")){
			sb.append(m_strHoldFluctAmt)
			.append(", 원, ")
			.append(", 내린, ")
			.append(m_strHoldCurrent)
			.append(", 원, ");
		}else if(m_strHoldFluctFlag.equals("1") || m_strHoldFluctFlag.equals("2") || m_strHoldFluctFlag.equals("3") || m_strHoldFluctFlag.equals("4")){
			sb.append(m_strHoldFluctAmt)
			.append(", 원, ")
			.append(", 오른, ")
			.append(m_strHoldCurrent)
			.append(", 원, ");
		}else{
			sb.append(", 보합인, ")
			.append(m_strHoldCurrent)
			.append(", 원, ");
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
