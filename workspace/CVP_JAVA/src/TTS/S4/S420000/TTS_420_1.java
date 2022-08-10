package TTS.S4.S420000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_420_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strBalDepCashAmt = (String) actionAPI.getSessionData("m_strBalDepCashAmt"); // 예수금액
		m_strBalDepCashAmt = trimNum(m_strBalDepCashAmt);
		String m_strBalOutEnAmt = (String) actionAPI.getSessionData("m_strBalOutEnAmt"); // 출금가능금액
		m_strBalOutEnAmt = trimNum(m_strBalOutEnAmt);
		
		/*현재 고객님의 예수금 총액은 
		(m_strBalDepCashAmt) 원이며, 
		출금 가능 금액은
		(m_strBalOutEnAmt) 원 입니다.*/
		
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strBalDepCashAmt.equals("0") || m_strBalDepCashAmt.equals(null)){
			sb.append("현재, 고객님의, 예수금, 총액은,")
			.append(", 없으며, ");
		}else{
			sb.append("현재, 고객님의, 예수금, 총액은,")
			.append(m_strBalDepCashAmt).append(", 원, 이며,");
		}
		
		if(m_strBalOutEnAmt.equals("0") || m_strBalOutEnAmt.equals(null)){
			sb.append("출금, 가능 금액은,")
			.append(", 없습니다. ");
		}else{
			sb.append("출금, 가능 금액은,")
			.append(m_strBalOutEnAmt).append(", 원, 입니다.");
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
