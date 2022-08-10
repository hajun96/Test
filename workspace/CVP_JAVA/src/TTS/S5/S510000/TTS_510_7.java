package TTS.S5.S510000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_510_7 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*[TTS_510_7] : 이체 완료 되었습니다. 
		이체 후 출금가능금액은 
		(m_strOamtEnblAmt) 원 
		입니다.*/
		String m_strOamtEnblAmt = (String) actionAPI.getSessionData("m_strOamtEnblAmt"); //은행명or증권사명
		m_strOamtEnblAmt = trimNum(m_strOamtEnblAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append(", 이체, ")
		.append(", 완료, ")
		.append(", 되었습니다. ")
		.append(", 이체 후 , ")
		.append(", 출금가능금액은, ")
		.append(m_strOamtEnblAmt)
		.append(", 원, ")
		.append(", 입니다.");
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
