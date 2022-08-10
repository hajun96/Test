package TTS.S4.S463000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_463_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strMotgKeepRate = (String) actionAPI.getSessionData("m_strMotgKeepRate"); //담보유지비율
		m_strMotgKeepRate = trimNum(m_strMotgKeepRate);
		String m_strMotgLackTamt = (String) actionAPI.getSessionData("m_strMotgLackTamt"); //부족금액
		m_strMotgLackTamt = trimNum(m_strMotgLackTamt);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strMotgKeepRate.equals("0")){
			sb.append("현재가 기준, 추정 담보유지 비율은,")
			.append(", 없습니다. ");
		}else{
			sb.append("현재가 기준, 추정 담보유지 비율은,")
			.append(m_strMotgKeepRate)
			.append(", 퍼센트, ");
		}
		
		if(m_strMotgLackTamt.equals("0")){
			sb.append("부족, 금액은, ")
			.append("없습니다.");
		}else{
			sb.append("부족, 금액은, ")
			.append(m_strMotgLackTamt)
			.append(", 원, ")
			.append("입니다.");
		}
		
		sb.append("당일, 종가, 반영은, 16시, 이후에, 확인이, 가능합니다.");
		
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
