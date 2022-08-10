package TTS.S5.S520000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_520_4 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*미래에셋대우, 
(m_strRecvMn) 님의 계좌로
(m_strFtrnAmt) 원이 이체될
예정입니다.*/
		
		String m_strRecvMn = (String) actionAPI.getSessionData("m_strRecvMn"); //받는사람이름
		String m_strBankAccount = (String) actionAPI.getSessionData("m_strBankAccount"); //받는계좌
		String m_strFtrnAmt = (String) actionAPI.getSessionData("m_strFtrnAmt"); //이체금액
		m_strFtrnAmt = trimNum(m_strFtrnAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append("미래에셋대우, ");
		
		if(m_strRecvMn.equals("") || m_strRecvMn.equals(null)){
			sb.append("[").append(m_strBankAccount).append("]");
		}else{
			sb.append(m_strRecvMn)
			.append(", , ")
			.append(", 님의 , ");
		}
		
		sb.append(", 계좌로, ")
		.append(m_strFtrnAmt)
		.append(", 원이, ")
		.append(", 이체 될, ")
		.append(", 예정, ")
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
