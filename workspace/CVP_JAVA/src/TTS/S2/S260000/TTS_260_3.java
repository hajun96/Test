package TTS.S2.S260000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_260_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectOffer = (String) actionAPI.getSessionData("m_strExpectOffer"); //예상매도호가
		m_strExpectOffer = trimNum(m_strExpectOffer);
		String m_strExpectBid = (String) actionAPI.getSessionData("m_strExpectBid"); //예상매수호가
		m_strExpectBid = trimNum(m_strExpectBid);
		
		StringBuffer sb = new StringBuffer();

		
		if(m_strExpectOffer.equals("0") || m_strExpectOffer.equals("") || m_strExpectOffer.equals(null)){
			sb.append(", 예상매도호가는, ")
			.append(", 없고, ");
		}else{
			sb.append(", 예상매도호가는,")
			.append(m_strExpectOffer).append(", ,")
			.append(",원 ,");
		}
		
		
		if(m_strExpectBid.equals("0") || m_strExpectBid.equals("") || m_strExpectBid.equals(null)){
			sb.append(", 예상매수호가는,")
			.append(", 없습니다.");
		}else{
			sb.append(", 예상매수호가는,")
			.append(m_strExpectBid).append(", ,")
			.append(", 원,")
			.append(", 입니다.");
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
