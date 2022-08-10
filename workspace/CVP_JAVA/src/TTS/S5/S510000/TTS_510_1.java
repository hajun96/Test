package TTS.S5.S510000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_510_1 extends ActionElementBase{
	/*출금 가능금액은 #### (m_strOamptEnblAmt)
	원 이고, 
	당일 이체출금 한도금액은 #### (m_strTdayLimitSrplAmt)
	원 입니다.*/
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strOamptEnblAmt = (String) actionAPI.getSessionData("m_strOamptEnblAmt"); //출금가능금액
		m_strOamptEnblAmt = trimNum(m_strOamptEnblAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append("출금 가능금액은")
		.append(m_strOamptEnblAmt)
		.append(", 원 ,")
		.append("입니다.");
		
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
