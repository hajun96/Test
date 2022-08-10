package TTS.S2.S270000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_270_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strFrgTrd = (String) actionAPI.getSessionData("m_strFrgTrd"); //외국인매매
		String m_strAgcyTrd = (String) actionAPI.getSessionData("m_strAgcyTrd"); //기관매매
		String m_strGenTrd = (String) actionAPI.getSessionData("m_strGenTrd"); //일반매매
		
		//[외국인매매 연산] 
		m_strFrgTrd = trimNum(m_strFrgTrd);
		Float f_m_strFrgTrd = Float.parseFloat(m_strFrgTrd);
		
		//[기관매매 연산]
		m_strAgcyTrd = trimNum(m_strAgcyTrd);
		Float f_m_strAgcyTrd = Float.parseFloat(m_strAgcyTrd);
		
		//[일반매매 연산]
		m_strGenTrd = trimNum(m_strGenTrd);
		Float f_m_strGenTrd = Float.parseFloat(m_strGenTrd);
		
		StringBuffer sb = new StringBuffer();
		
		if(f_m_strFrgTrd > 0){
			sb.append("거래소시장은, ")
			.append(", 외국인, ")
			.append(", 순매수, ")
			.append(m_strFrgTrd).append(", , ")
			.append(", 원, ");
		}else if(f_m_strFrgTrd < 0){
			sb.append("거래소시장은, ")
			.append(", 외국인, ")
			.append(", 순매도, ")
			.append(m_strFrgTrd).append(", , ")
			.append(", 원, ");
		}else{
			sb.append("거래소시장은, ")
			.append(", 외국인, ")
			.append(m_strFrgTrd).append(", , ")
			.append(", 원, ");
		}
		
		if(f_m_strAgcyTrd > 0){
			sb.append("기관, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd).append(", , ")
			.append(", 원, ");
		}else if(f_m_strAgcyTrd < 0){
			sb.append("기관, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd).append(", , ")
			.append(", 원, ");
		}else{
			sb.append("기관, ")
			.append(m_strAgcyTrd).append(", , ")
			.append(", 원, ");
		}

		if(f_m_strGenTrd > 0){
			sb.append("개인, ")
			.append(", 순매수, ")
			.append(m_strGenTrd).append(", , ")
			.append(", 원, ")
			.append(", 이며, ");
		}else if(f_m_strGenTrd < 0){
			sb.append("개인, ")
			.append(", 순매도, ")
			.append(m_strGenTrd).append(", , ")
			.append(", 원, ")
			.append(", 이며, ");
		}else{
			sb.append("개인, ")
			.append(m_strGenTrd).append(", , ")
			.append(", 원, ")
			.append(", 이며, ");
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
